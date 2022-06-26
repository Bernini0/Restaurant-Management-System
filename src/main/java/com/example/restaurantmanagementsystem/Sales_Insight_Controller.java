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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

import static com.example.restaurantmanagementsystem.Loader.man;

public class Sales_Insight_Controller {
    @FXML
    private Button account;

    @FXML
    private ImageView click_to_search;

    @FXML
    private Button dashboard;

    @FXML
    private Label date;

    @FXML
    private Button menu1;

    @FXML
    private Label money1;

    @FXML
    private Label money12;

    @FXML
    private Label money13;

    @FXML
    private Label money14;

    @FXML
    private Label money21;

    @FXML
    private Label money22;

    @FXML
    private Label money23;

    @FXML
    private Label money24;

    @FXML
    private Button online_orders;

    @FXML
    private Button onsite_orders;

    @FXML
    private Button sales;

    @FXML
    private Label sales1;

    @FXML
    private Label sales2;

    @FXML
    private Label sales3;

    @FXML
    private HBox search;

    @FXML
    private TextField search1;

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
        money1.setText(p);
        money12.setText(q);
        money13.setText(r);
        money14.setText(s);
        money21.setText(t);
        money22.setText(u);
        money23.setText(v);
        money24.setText(w);

    }
    public void set_date(String s){date.setText(s);}
}
