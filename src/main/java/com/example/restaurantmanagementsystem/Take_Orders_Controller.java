package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.restaurantmanagementsystem.Loader.man;

public class Take_Orders_Controller {
    @FXML
    private TextField address_or_table_num;

    @FXML
    private TextField name;

    @FXML
    private CheckBox offline;

    @FXML
    private CheckBox online;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private HBox search;

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
            c.setText(man.menu.all_dishes.get(i).getName());
            TextField t = new TextField();
            Label l2 = new Label(String.valueOf(man.menu.all_dishes.get(i).getPrice()));
            HBox x = new HBox(c,t,l2);
            x.setSpacing(20.0);
            v.getChildren().add(x);
        }
        scrollpane.setContent(v);
    }
    public void taking_orders(){
        Map<Dish,Integer> dish_count = new HashMap<Dish,Integer>();
        offline.setIndeterminate(false);
        online.setIndeterminate(false);
        for(int i = 0; i < v.getChildren().size(); i++){
            HBox x = (HBox) v.getChildren().get(i);
            CheckBox c = (CheckBox) x.getChildren().get(0);
            TextField t = (TextField) x.getChildren().get(1);

            Label l = (Label) x.getChildren().get(2);
            System.out.println("hocche");
            String s = t.getText();
            if(s!= "" && c.isSelected()==true){
                System.out.println(Integer.valueOf(l.getText()));
                Dish d = man.menu.check_dishes.get(c.getText());
                System.out.println(d.getName() + " " + d.getPrice() + " " + d.getDescription() + " " + d.getImgSrc());
                dish_count.put(d,Integer.valueOf(s));

            }
        }
        if(offline.isSelected()==true){
            Integer discount = 0;
            man.take_offline_order(man.index,discount,dish_count);
            man.index++;
            offline.fire();
//            man.calculate_sales_and_orders_insight();
        }
        else if(online.isSelected()==true){
            Integer discount = 0;
            String address = address_or_table_num.getText();
            man.take_online_order(man.index, discount, address,dish_count);
            man.index++;
//            man.calculate_sales_and_orders_insight();
        }
        if(online.isSelected()==true)online.fire();
        name.clear();
        address_or_table_num.clear();
        for(int i = 0; i < v.getChildren().size(); i++){
            HBox x = (HBox) v.getChildren().get(i);
            CheckBox c = (CheckBox) x.getChildren().get(0);
            TextField t = (TextField) x.getChildren().get(1);
            if(c.isSelected()==true){
                c.fire();
                t.clear();
            }
        }
    }
    public void go_back_to_dashboard(ActionEvent e) throws IOException {
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Show s = new Show();
        s.display(stage,"dashboard.fxml");
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
    public void go_to_account_page(MouseEvent e) throws IOException{
        dtoc.go_to_account_page(e);
    }
    public void go_to_logout(MouseEvent e) throws IOException{
        dtoc.go_to_logout(e);
    }
}



