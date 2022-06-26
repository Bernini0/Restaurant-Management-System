package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.example.restaurantmanagementsystem.Loader.man;
import static com.example.restaurantmanagementsystem.Loader.names;

public class HelloController {

    private Parent root;
    private Stage stage;

    @FXML
    private Label forgot_pw;

    @FXML
    private Button login;

    @FXML
    private AnchorPane mainloginpane;

    @FXML
    private PasswordField password;

    @FXML
    private Label pw_label;

    @FXML
    private StackPane stackpane;

    @FXML
    private TextField username;

    @FXML
    private Label username_label;

    @FXML
    private Label welcome;

    public void go_to_Dashboard(MouseEvent event) throws IOException {

        String name = username.getText();
        String pass = password.getText();
        System.out.println(name);
        System.out.println(pass);
        boolean yes = false;
        for(int i = 0; i < names.size(); i++) {
            Pair<String,String> nem = names.get(i);
            if (name.equals(nem.getKey()) && pass.equals(nem.getValue())) {
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                FXMLLoader loader= new FXMLLoader(getClass().getResource("dashboard.fxml"));
                root = loader.load();
                Dashboard_to_others_Controller dtoc = loader.getController();
                dtoc.set_money(String.valueOf(man.today_sale));
                dtoc.set_sales1(String.valueOf(man.today_order_count));
                dtoc.set_sales11(String.valueOf(man.on_the_way));
                dtoc.set_sales111(new Date().toString());
                yes = true;
                Show.dis_play(root,event);
            }
        }
        if(yes == false){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);// line 1
            alert.setTitle("Information Dialog Box");// line 2
            alert.setHeaderText("Incorrect Credential");// line 3
            alert.setContentText("If you forgot your Pass contact admin");// line 4
            alert.showAndWait();
        }
//        Show s = new Show();
//        s.dis_play(root,e);
    }
    public void go_to_Signup(MouseEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        root = FXMLLoader.load(getClass().getResource("Sign_Up.fxml"));
        Show s = new Show();
        s.display(stage,"Sign_Up.fxml");
//        Show.dis_play(root,event);
//        Show s = new Show();
//        s.dis_play(root,e);
    }
}
