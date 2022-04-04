package com.example.restaurantmanagementsystem;

import javafx.scene.control.Button;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;


public class common_methods {
    public static boolean confirmed = false;      //logging out
    public static boolean disablelogin = true;    //login button animation
    public static String leftpanecolor = "";      //button drop shadow colours
    private double initialx, initialy;          //dragging window
    protected static String page = "";            //keeping track of current pages
    private boolean rotatedpane = false;         //rotate pane animation
    public static String username = "";
    public static boolean loggedout = false;
    public static boolean running = true;
    private boolean loading = false;


    //handles the event for closing a window
    public void handleClose(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    //displays user who is logged in
    public void displayUserName(Label label){
        label.setText("Logged in as: " + username);
    }


    //Given a parent anchorpane and an ID, finds and returns the child anchorpane with that that id
    public AnchorPane findPane(AnchorPane parent, String id){
        if(parent.getId().equals(id)){
            return parent;
        }
        for(Node node: parent.getChildren()){
            if(node.getId().equals(id)){
                return (AnchorPane)node;
            }
        }
        return null;
    }

    //loads new scene/page
    public  void loadScene(ActionEvent event){
        if(loading){
            return;
        }
        loading=true;
        String newscene="";
        common_methods.confirmed=false;
        if(((Button)(event.getSource())).getId().equals("dashboard")){
            newscene="dashboard.fxml";
        }else if(((Button)(event.getSource())).getId().equals("onsite")){
            newscene="Onsite_Order_Page.fxml";
        }else if(((Button)(event.getSource())).getId().equals("online")){
            newscene="Online_Order_Page.fxml";
        }else if(((Button)(event.getSource())).getId().equals("menu")){
            newscene="Menu_Page.fxml";
        }else if(((Button)(event.getSource())).getId().equals("sales")){
            newscene="Sales_Insight_Page.fxml";
        }

        Timeline t=dropShadow(event, 0.75,leftpanecolor);
        t.play();
        String finalNewscene = newscene;
        t.setOnFinished(event1 -> {
            ((Button)(event.getSource())).setEffect(null);
            if(finalNewscene.isEmpty()){
                return;
            }
            try {
                Parent parent = FXMLLoader.load(getClass().getResource(finalNewscene));
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                Scene scene=new Scene(parent);
                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                stage.setScene(scene);
                stage.show();
                loading=false;
            } catch (IOException ex) {
                System.out.println("Error in switching stages");
            }
        });
    }


    //rotates button clockwise then anticlockwise 45 degrees
    public void rotateButton(Button button){
        if(rotatedpane == false){
            rotatedpane = true;
            RotateTransition rt = new RotateTransition(Duration.millis(60),button);
            rt.setByAngle(45);
            rt.setCycleCount(2);
            rt.setAutoReverse(true);
            rt.play();

            rt.setOnFinished(event -> {
                RotateTransition rt2=new RotateTransition(Duration.millis(60),button);
                rt2.setByAngle(-45);
                rt2.setCycleCount(2);
                rt2.setAutoReverse(true);
                rt2.play();
                rt2.setOnFinished(event1 -> rotatedpane =false);
            });
        }
    }

    //shadow effect on button
    public Timeline dropShadow(ActionEvent event, double shadowspread, String color){
        Button button=(Button) event.getSource();
        Color origcolor = Color.web(color);
        Color newcolor = origcolor.brighter();
        String darker=("#"+newcolor.toString().substring(2,8));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web(darker));
        shadow.setSpread(shadowspread);

        Timeline shadowAnimation = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(shadow.radiusProperty(), 0d)),
                new KeyFrame(Duration.millis(150), new KeyValue(shadow.radiusProperty(), 20d)));
        shadowAnimation.setAutoReverse(true);
        shadowAnimation.setCycleCount(2);
        Node target = button;
        target.setEffect(shadow);
        return shadowAnimation;
    }

    //hover effect on anchor pane
    public void tileHover(MouseEvent event){
        AnchorPane pane = (AnchorPane)event.getSource();
        String original = pane.getStyle().substring(22,29);
        Color origcolor = Color.web(original);

        Color newcolor = origcolor.darker();
        String darker=("#"+newcolor.toString().substring(2,8));
        pane.setStyle("-fx-background-color: "+darker);
        pane.setEffect(new Bloom(0.85));
    }

    //reverse tile hover
    public void tileExit(MouseEvent event){
        AnchorPane pane=(AnchorPane)event.getSource();
        String original=pane.getStyle().substring(22,29);
        Color origcolor=Color.web(original);

        Color newcolor=origcolor.brighter();
        String brighter=("#"+newcolor.toString().substring(2,8));
        pane.setStyle("-fx-background-color: "+brighter);
        pane.setEffect(new Bloom(1));

    }

    //button hover effect
    public void buttonHover(MouseEvent event){
        Button button = (Button) event.getSource();
        Color origcolor = Color.web(leftpanecolor);
        Color newcolor = origcolor.darker();

        button.setOpacity(1.0);
        String darker=("#"+newcolor.toString().substring(2,8));
        button.setStyle("-fx-background-color: "+darker);
        button.setEffect(new Bloom(0.75));
    }

    //reverse button hover effect
    public void buttonExit(MouseEvent event){
        Button button = (Button) event.getSource();
        if((button.getText().equals(page))) {
            button.setOpacity(1.0);
        }else{
            button.setOpacity(0.8);
        }
        button.setStyle("-fx-background-color: transparent");
        button.setEffect(new Bloom(1));
    }

    //adds hover effect, e.g darkens button colour
    public void buttonEffect(Button button){
        String buttoncolor = button.getStyle().substring(22,29);
        Color origcolor = Color.web(buttoncolor);
        Color newcolor = origcolor.darker();
        String darker=("#"+newcolor.toString().substring(2,8));

        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color: "+darker);
            button.setEffect(new Bloom(0.85));
        });
        String brighter = ("#"+origcolor.toString().substring(2,8));
        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color: "+brighter);
            button.setEffect(new Bloom(1));
        });
    }

    //popup window asking user whether they want to log out
    public void logOut(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        AnchorPane mainpane = (AnchorPane) ((Node) event.getSource()).getParent().getParent();
        mainpane.setEffect(new ColorAdjust(0,0,-0.25,0));
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("logout.fxml"));
            Stage popup = new Stage();
            Scene scene=new Scene(parent);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

            popup.initOwner(stage);
            popup.setScene(scene);
            popup.initStyle(StageStyle.UNDECORATED);
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.showAndWait();
            if(confirmed==true){
                stage.close();
                loadLogin();
            }else{
                mainpane.setEffect(new ColorAdjust(0,0,0,0));
            }
        } catch (IOException ex) {
            System.out.println("Error in switching stages logout button");
            ex.printStackTrace();
        }
    }

    //initial window displayed after user logs out
    private void loadLogin(){
        try {
            loggedout = true;
            Parent parent = FXMLLoader.load(getClass().getResource("First_Page.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("Error in switching stages");
        }
    }

    //set pane properties
    public void moveWindow(AnchorPane pane){
        pane.setOnMousePressed(e ->{
            initialx = e.getSceneX();
            initialy = e.getSceneY();
        });
        pane.setOnMouseDragged(e -> {
            Node source = (Node) e.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setX(e.getScreenX() - initialx);
            stage.setY(e.getScreenY() - initialy);
        });
    }

    //hover effects for min/max, exit buttons
    public void customiseWindowButtons(Button closebutton,  Button minimisebutton){
        closebutton.setOnMouseEntered(e -> {
            closebutton.setStyle("-fx-background-color:  #F6490D");
            closebutton.setEffect(new Bloom(0.7));
        });
        closebutton.setOnMouseExited(e -> {
            closebutton.setStyle("-fx-background-color: transparent");
            closebutton.setEffect(new Bloom(1));
        });

        minimisebutton.setOnMouseEntered(e -> {
            minimisebutton.setStyle("-fx-background-color:  #F6490D");
            minimisebutton.setEffect(new Bloom(0.7));
        });
        minimisebutton.setOnMouseExited(e -> {
            minimisebutton.setStyle("-fx-background-color: transparent");
            minimisebutton.setEffect(new Bloom(1));
        });
    }

    //ability to minimise window
    public void minimiseWindow(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setIconified(true);
    }

    //creates and plays scale transition on anchorpane
    public void popNode(AnchorPane pane){
        ScaleTransition st = new ScaleTransition(Duration.millis(800), pane);
        st.setFromX(0.5);
        st.setFromY(0.5);
        st.setToX(1.0);
        st.setToY(1.0);
        st.setRate(1.5);
        st.setCycleCount(1);
        st.play();
    }

    public SequentialTransition makeButtonFly(Button button){
        TranslateTransition t1=new TranslateTransition(Duration.millis(200),button);
        t1.setToY(-17d);
        PauseTransition p1=new PauseTransition(Duration.millis(30));
        TranslateTransition t2=new TranslateTransition(Duration.millis(200),button);
        t2.setToY(0d);

        SequentialTransition transition=new SequentialTransition(button, t1,p1,t2);
        return transition;
    }

    public SequentialTransition popButton(Button button, double scale){
        ScaleTransition st1 = new ScaleTransition(Duration.millis(200), button);
        st1.setToX(scale);
        st1.setToY(scale);
        st1.setRate(1.5);
        st1.setCycleCount(1);

        ScaleTransition st2 = new ScaleTransition(Duration.millis(200), button);
        st2.setToX(1);
        st2.setToY(1);
        st2.setRate(1.5);
        st2.setCycleCount(1);
        SequentialTransition transition=new SequentialTransition(button, st1,st2);
        return transition;
    }
}