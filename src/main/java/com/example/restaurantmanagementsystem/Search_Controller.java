package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

import static com.example.restaurantmanagementsystem.Loader.man;

public class Search_Controller {

    @FXML
    private Button account;

    @FXML
    private ImageView click_to_search;

    @FXML
    private Button dashboard;

    @FXML
    private Button menu1;

    @FXML
    private Button online_orders;

    @FXML
    private Button onsite_orders;

    @FXML
    private Button sales;

    @FXML
    private TextField search1;

    @FXML
    private Label search_result;

    @FXML
    private HBox toppane;


    private Parent root;
    private Scene scene;
    private Stage stage;
    private Dashboard_to_others_Controller dtoc = new Dashboard_to_others_Controller();
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
    public void go_to_take_orders(MouseEvent e) throws IOException{
        dtoc.go_to_take_orders(e);
    }
    public void go_to_Orders_Overview(MouseEvent e) throws IOException{
        dtoc.go_to_Orders_Overview(e);
    }
    public void go_to_menu_page(MouseEvent e) throws IOException{
        dtoc.go_to_menu_page(e);
    }
    public void go_to_sales_insight(MouseEvent e) throws IOException{
        dtoc.go_to_sales_insight(e);
    }
    public void go_to_order_status(MouseEvent e) throws IOException{
        dtoc.go_to_order_status(e);
    }
    public void go_to_logout(MouseEvent e) throws IOException{
        dtoc.go_to_logout(e);
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
    public void set_search_res(String s){
//        System.out.println(s);
        String p;
        if(s.compareToIgnoreCase("add dish")==0) {
            p = "Go to Menu Page";
        }
        else if(s.compareToIgnoreCase("delete dish")==0 || s.compareToIgnoreCase("remove dish")==0)p = "Go To Menu Page.";
        else if(s.compareToIgnoreCase("update dish")==0)p = "Go To Menu Page.";
        else if(s.compareToIgnoreCase("Update Order")==0)p = "Go To Order Status.";
        else if(s.compareToIgnoreCase("total sales")==0 || s.compareToIgnoreCase("orders of the day")==0 || s.compareToIgnoreCase("on the way")==0 || s.compareToIgnoreCase("total orders")==0|| s.compareToIgnoreCase("orders overview")==0 || s.compareToIgnoreCase("order overview")==0)p = "Go To Order Overview.";
        else if(s.compareToIgnoreCase("profit")==0 || s.compareToIgnoreCase("loss")==0 || s.compareToIgnoreCase("cost")==0 || s.compareToIgnoreCase("sales insight")==0 || s.compareToIgnoreCase("sales")==0)p="Go To Sales Insight.";
        else if(s.compareToIgnoreCase("order")==0)p = "Go To Take Orders.";
        else p = "Not Found.";
//        System.out.println(s+" " +p);
        search_result.setText(p);
    }
}