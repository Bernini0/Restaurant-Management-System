package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.restaurantmanagementsystem.Loader.man;

public class Take_Orders_Controller {
    @FXML
    private TextField address_or_table_num;

    @FXML
    private TextField name;

    @FXML
    private TextField discount_on_order;
    @FXML
    private CheckBox offline;

    @FXML
    private CheckBox online;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private HBox search;
    @FXML
    private TextField search1;

    @FXML
    private VBox v;

    private Parent root;
    private Scene scene;
    private Stage stage;
    private Dashboard_to_others_Controller dtoc = new Dashboard_to_others_Controller();


    public void set_scrollPane(){
//        VBox v = new VBox();
        v.setPadding(new Insets(20,20,20,20));
        v.setSpacing(20.0);
        for(int i = 0; i < man.menu.all_dishes.size(); i++){
            CheckBox c = new CheckBox();
            c.setPrefSize(228,-1);
            c.setMaxSize(228,-1);
            c.setMinSize(228,-1);
            c.setText(man.menu.all_dishes.get(i).getName());
            TextField t = new TextField();
            t.setPrefSize(336,-1);
            t.setMaxSize(336,-1);
            t.setMinSize(336,-1);
            Label l2 = new Label(String.valueOf(man.menu.all_dishes.get(i).getPrice()));
            l2.setPrefSize(341,-1);
            l2.setMaxSize(341,-1);
            l2.setMinSize(341,-1);
            HBox x = new HBox(c,t,l2);
            x.setSpacing(20.0);
            v.getChildren().add(x);
        }
        scrollpane.setContent(v);
    }
    public void taking_orders(){
        String customer_name = name.getText();
        Map<Dish,Integer> dish_count = new HashMap<Dish,Integer>();
        offline.setIndeterminate(false);
        online.setIndeterminate(false);
        boolean yes = true;
        for(int i = 0; i < v.getChildren().size(); i++){

            HBox x = (HBox) v.getChildren().get(i);
            CheckBox c = (CheckBox) x.getChildren().get(0);
            TextField t = (TextField) x.getChildren().get(1);
            Label l = (Label) x.getChildren().get(2);

            String s = t.getText();

            if((s!= "" || s!="0") && c.isSelected()==true){

                Dish d = man.menu.check_dishes.get(c.getText());

                try {
                    dish_count.put(d, Integer.valueOf(s));
                }catch (NumberFormatException p){
                    yes = false;
                    break;
                }

            }
        }
        if(yes==false)show_alert();
        else if(dish_count.size()==0)show_alert();
        else if(online.isSelected()==true && offline.isSelected()==true)show_alert();
        else if(offline.isSelected()==true){
            Integer discount = cal_discount(discount_on_order.getText());
            man.take_offline_order(man.index,discount,customer_name,dish_count);
            man.index++;
            man.calculate_sales_and_orders_insight();
//            man.calculate_sales_and_orders_insight();
        }
        else if(online.isSelected()==true){
            Integer discount = cal_discount(discount_on_order.getText());
            String address = address_or_table_num.getText();
            if(address=="")show_alert();
            else {
                man.take_online_order(man.index, discount, customer_name, address, dish_count);
                man.index++;
                man.calculate_sales_and_orders_insight();
            }
        }
        else show_alert();
        if(online.isSelected()==true)online.fire();
        if(offline.isSelected()==true)offline.fire();
        name.clear();
        address_or_table_num.clear();
        discount_on_order.clear();
        for(int i = 0; i < v.getChildren().size(); i++){
            HBox x = (HBox) v.getChildren().get(i);
            CheckBox c = (CheckBox) x.getChildren().get(0);
            TextField t = (TextField) x.getChildren().get(1);
            if(c.isSelected()==true){
                c.fire();
            }
            t.clear();
        }
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
    public void go_to_Orders_Overview(MouseEvent e) throws IOException{
        dtoc.go_to_Orders_Overview(e);
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
    private boolean checker(String s){
        try{
            Integer i = Integer.valueOf(s);
            return true;
        }catch (NumberFormatException e){
            return  false;
        }
    }
    private Integer cal_discount(String s){
        if(checker(s)==true)return Integer.valueOf(s);
        else return 0;
    }
    public void show_alert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);// line 1
        alert.setTitle("Information Dialog Box");// line 2
        alert.setHeaderText("Wrong Information");// line 3
        alert.setContentText("Information that was provided is incorrect please check again");// line 4
        alert.showAndWait();

    }
}



