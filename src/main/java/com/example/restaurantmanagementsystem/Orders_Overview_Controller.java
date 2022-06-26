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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import static com.example.restaurantmanagementsystem.Loader.man;

public class Orders_Overview_Controller {
    @FXML
    private Button account;

    @FXML
    private Button dashboard;

    @FXML
    private Label date;

    @FXML
    private Button logout;

    @FXML
    private Button menu1;

    @FXML
    private Button online_orders;

    @FXML
    private Button onsite_orders;

    @FXML
    private Label order11;

    @FXML
    private Label order12;

    @FXML
    private Label order13;

    @FXML
    private Label order14;

    @FXML
    private Label order21;

    @FXML
    private Label order22;

    @FXML
    private Label order23;

    @FXML
    private Label order24;

    @FXML
    private Label sales1;

    @FXML
    private Button sales;

    @FXML
    private Label sales2;
    @FXML
    private TextField search1;

    @FXML
    private Label sales3;

    @FXML
    private HBox search;

    @FXML
    private HBox toppane;
    private Parent root;
    private Scene scene;
    private Stage stage;

    private Dashboard_to_others_Controller dtoc = new Dashboard_to_others_Controller();
    public void x(){

    }
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
    public void go_to_sales_insight(MouseEvent e) throws IOException{
        dtoc.go_to_sales_insight(e);
    }
    public void go_to_menu_page(MouseEvent e) throws IOException{
        dtoc.go_to_menu_page(e);
    }
    public void go_to_order_status(MouseEvent e) throws IOException{
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
    public void setter(String m, String n, String o, String p, String q, String r, String s, String t, String u, String v,String w){
        sales1.setText(m);
        sales2.setText(n);
        sales3.setText(o);
        order11.setText(p);
        order12.setText(q);
        order13.setText(r);
        order14.setText(s);
        order21.setText(t);
        order22.setText(u);
        order23.setText(v);
        order24.setText(w);
    }
    public void set_date(String s){date.setText(s);}
}
