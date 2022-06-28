package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

import static com.example.restaurantmanagementsystem.Loader.man;

public class Menu_Controller {


    private Parent root;
    private Scene scene;
    private Stage stage;
    private Dashboard_to_others_Controller dtoc = new Dashboard_to_others_Controller();

    @FXML
    private Button account;

    @FXML
    private Button dashboard;

    @FXML
    private Button menu1;

    @FXML
    private TextField dish_to_be_removed;
    @FXML
    private TextField new_dish_image_src;

    @FXML
    private TextField new_dish_name;

    @FXML
    private TextField new_dish_price;

    @FXML
    private TextArea new_dish_description;

    @FXML
    private Button online_orders;

    @FXML
    private TextField search1;

    @FXML
    private Button onsite_orders;

    @FXML
    private Button sales;

    @FXML
    private TextField to_be_updated_name;

    @FXML
    private TextField to_be_updated_price;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private HBox search;

    @FXML
    private HBox toppane;

    @FXML
    private VBox vbox;

    public void go_back_to_dashboard(ActionEvent e) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();
        Dashboard_to_others_Controller dtoc = loader.getController();
        dtoc.set_money(String.valueOf(man.today_sale));
        dtoc.set_sales1(String.valueOf(man.today_order_count));
        dtoc.set_sales11(String.valueOf(man.on_the_way));
        dtoc.set_sales111(new Date().toString());
        Show.dis_play(root,e);
    }
    public void go_to_take_orders(MouseEvent e) throws IOException {
        dtoc.go_to_take_orders(e);
    }
    public void go_to_Orders_Overview(MouseEvent e) throws IOException{
        dtoc.go_to_Orders_Overview(e);
    }
    public void go_to_sales_insight(MouseEvent e) throws IOException{
        dtoc.go_to_sales_insight(e);
    }
    public void go_to_account_page(MouseEvent e) throws IOException{
        dtoc.go_to_order_status(e);
    }
    public void search(MouseEvent e) throws IOException{
        String s = search1.getText();
//        System.out.println(s);
        if(s!="") {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Search_Page.fxml"));
            root = loader.load();
            Search_Controller s_c = loader.getController();
            s_c.set_search_res(s);
            Show.dis_play(root, e);
        }
    }
    public void search1(ActionEvent e) throws IOException{
        String s = search1.getText();
//        System.out.println(s);
        if(s!="") {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Search_Page.fxml"));
            root = loader.load();
            Search_Controller s_c = loader.getController();
            s_c.set_search_res(s);
            Show.dis_play(root, e);
        }
    }
    public void go_to_logout(MouseEvent e) throws IOException{
        dtoc.go_to_logout(e);
    }

    public void set_scrollpane(){
//        vbox.setPadding(new Insets(20,20,20,20));
        vbox.setSpacing(20.0);
        for(int i = 0; i < man.menu.all_dishes.size(); i++){
            Label sl = new Label();
            sl.setText(String.valueOf(i + 1));
            sl.setPrefSize(50,-1);
            sl.setMaxSize(50,-1);
            sl.setMinSize(50,-1);
            Dish d = man.menu.all_dishes.get(i);
            Label food = new Label(d.getName());
            food.setPrefSize(128,-1);
            food.setMaxSize(128,-1);
            food.setMinSize(128,-1);
            Label description = new Label(d.getDescription());
            description.setPrefSize(225,-1);
            description.setMaxSize(225,-1);
            description.setMinSize(225,-1);
            VBox v = new VBox();
            try {
                var img2 = new Image(getClass().getResource(d.getImgSrc()).toString(),120.0,70,false,false);
                ImageView im = new ImageView(img2);
                v.setAlignment(Pos.TOP_LEFT);
                v.getChildren().add(im);
            }catch (IllegalArgumentException x){
                System.out.println("haha");
            }
            v.setAlignment(Pos.TOP_LEFT);
            sl.setAlignment(Pos.CENTER);
            food.setAlignment(Pos.CENTER);
            description.setAlignment(Pos.CENTER);
            Label price = new Label(String.valueOf(d.getPrice()));
            price.setAlignment(Pos.CENTER);
            price.setPrefSize(90,-1);
            price.setMaxSize(90,-1);
            price.setMinSize(90,-1);
            HBox hb = new HBox(sl,food,description,v,price);
            hb.setAlignment(Pos.CENTER_LEFT);
            vbox.getChildren().add(hb);
        }
        scrollpane.setContent(vbox);
    }

    public void add_dish(MouseEvent e)throws IOException{
        String name = new_dish_name.getText();
        Integer price;
        String description = new_dish_description.getText();
        String img_src = new_dish_image_src.getText();
//        System.out.println(check_image_source(img_src));
        if(name!="" && check_image_source(img_src)==true) {
            try {
                price = Integer.valueOf(new_dish_price.getText());
                man.menu.add_dish(name, price, description, img_src);
                dtoc.go_to_menu_page(e);
            }catch(NumberFormatException x) {
                System.out.println("Not a Number");
                show_alert();
            }
        }
        else {
            show_alert();
        }
        man.write_in_data();
    }
    public void remove_dish(MouseEvent e)throws IOException{
        String s = dish_to_be_removed.getText();
        man.menu.remove_dish(s);
        dtoc.go_to_menu_page(e);

        man.write_in_data();
    }
    public void update_dish(MouseEvent e)throws IOException{
        String s = to_be_updated_name.getText();
        Integer price;
        try{
            price = Integer.valueOf(to_be_updated_price.getText());
            man.menu.edit_price_of_dish(s,price);
            dtoc.go_to_menu_page(e);
        }catch (NumberFormatException x){
            show_alert();
        }

        man.write_in_data();

    }
    public boolean check_image_source(String src){
        try{
            var img2 = new Image(getClass().getResource(src).toString());
            return true;
        }catch (Exception x) {
            System.out.println("Invalid Image Source");
            return false;
        }

    }
    public void show_alert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);// line 1
        alert.setTitle("Information Dialog Box");// line 2
        alert.setHeaderText("Wrong Information");// line 3
        alert.setContentText("Information that was provided is incorrect please check again");// line 4
        alert.showAndWait();
        new_dish_name.clear();
        new_dish_price.clear();
        new_dish_description.clear();
        new_dish_image_src.clear();
        to_be_updated_price.clear();
        to_be_updated_name.clear();
    }
}
