package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

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
    private Label sales3;

    @FXML
    private HBox search;

    @FXML
    private HBox toppane;
    private Parent root;
    private Scene scene;
    private Stage stage;
    public void x(){

    }
    public void go_back_to_dashboard(ActionEvent e) throws IOException {
//        root =  FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Show s = new Show();
        s.display(stage,"dashboard.fxml");
//        Show.dis_play(root,e);
//        Show s = new Show();
//        s.dis_play(root,e);
    }
    public void go_to_take_orders(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//        root =  FXMLLoader.load(getClass().getResource("Take_Order_Page.fxml"));
//        Show.dis_play(root,e);
        Show s = new Show();
        s.display(stage,"Take_Order_Page.fxml");
    }
    public void go_to_sales_insight(MouseEvent e) throws IOException{
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Sales_Insight_Page.fxml"));
        root = loader.load();
        Sales_Insight_Controller sc4 = loader.getController();
        Dashboard_to_others_Controller dtoc = new Dashboard_to_others_Controller();
        dtoc.calculate_sales_and_orders_insight();
        System.out.println(dtoc.total_sale_onsite);
        sc4.setter(Integer.toString(dtoc.today_sale),Integer.toString(dtoc.today_order_count),Integer.toString(dtoc.on_the_way),Integer.toString(dtoc.total_sale_onsite),Integer.toString(dtoc.net_profit_onsite),Integer.toString(dtoc.total_sale_online),Integer.toString(dtoc.net_profit_online),Integer.toString(dtoc.total_cost_onsite),Integer.toString(dtoc.net_loss_onsite),Integer.toString(dtoc.total_cost_online),Integer.toString(dtoc.net_loss_online));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
//        root =  FXMLLoader.load(getClass().getResource("Sales_Insight_Page.fxml"));
//        Show.dis_play(root,e);
//        Show s = new Show();
//        s.display(stage,"Sales_Insight_Page.fxml");
    }
    public void go_to_menu_page(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//        root =  FXMLLoader.load(getClass().getResource("Menu_Page.fxml"));
//        Show.dis_play(root,e);
        Show s = new Show();
        s.display(stage,"Menu_Page.fxml");
    }
    public void go_to_account_page(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//        root =  FXMLLoader.load(getClass().getResource("Account_Page.fxml"));
//        Show.dis_play(root,e);
        Show s = new Show();
        s.display(stage,"Account_Page.fxml");
    }
    public void go_to_logout(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//        root =  FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
//        Show.dis_play(root,e);
        Show s = new Show();
        s.display(stage,"Login_Page.fxml");
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
}
