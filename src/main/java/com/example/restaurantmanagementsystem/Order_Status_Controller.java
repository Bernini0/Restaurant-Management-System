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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import static com.example.restaurantmanagementsystem.Loader.man;

public class Order_Status_Controller {

    @FXML
    private Button account;

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
    private Label order_status_label;

    @FXML
    private RadioButton toggler;
    @FXML
    private ScrollPane scrollpane;

    @FXML
    private HBox search;

    @FXML
    private TextField to_be_updated_order;

    @FXML
    private HBox toppane;

    @FXML
    private VBox vbox;

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
    public void go_to_take_orders(MouseEvent e) throws IOException {
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
    public void go_to_logout(MouseEvent e) throws IOException{
        dtoc.go_to_logout(e);
    }

    public void set_scrollpane(int k){
        vbox.setPadding(new Insets(20,20,20,20));
        vbox.setSpacing(20.0);
        Map<Integer,Order> now_printing;
        if(k==1){
            now_printing = man.all_order_collection.all_orders;
        }
        else {
            now_printing = man.all_order_collection.pending_orders;
        }
        for(Map.Entry<Integer, Order> entry : now_printing.entrySet()){
            Order o = entry.getValue();
            System.out.println(o.getIsOnline()+"  "+o.getState());
            Label status = new Label(o.getState());
            status.setPrefSize(100,-1);
            status.setMaxSize(100,-1);
            status.setMinSize(100,-1);
            status.setAlignment(Pos.CENTER);
            Label customer_name = new Label(o.getCustomer_name());
            customer_name.setPrefSize(247,-1);
            customer_name.setMaxSize(247,-1);
            customer_name.setMinSize(247,-1);
            customer_name.setAlignment(Pos.CENTER);
            customer_name.setWrapText(true);
            Integer i = entry.getKey();
            Label order_id = new Label();
            order_id.setText(String.valueOf(i+1));
            order_id.setPrefSize(94,-1);
            order_id.setMaxSize(94,-1);
            order_id.setMinSize(94,-1);
            order_id.setAlignment(Pos.CENTER);
            HBox hx = new HBox(order_id, customer_name, status);
            hx.setSpacing(20.0);
            vbox.getChildren().add(hx);
        }
        scrollpane.setContent(vbox);
    }

    public void change(MouseEvent e)throws IOException{
        boolean x = toggler.isSelected();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Order_Status.fxml"));
        root = loader.load();
        Order_Status_Controller o_s_c = loader.getController();
        if(x==true){
            o_s_c.set_scrollpane(2);
            o_s_c.setOrder_status_label("Pending Order Status");
        }
        else{
             o_s_c.set_scrollpane(1);
        }
        o_s_c.toggler.setSelected(x);
        Show.dis_play(root,e);
    }
    public void update_order(MouseEvent e)throws IOException{
        Integer i = Integer.valueOf(to_be_updated_order.getText());
        man.update_order(i-1);
        change(e);
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
        if(s!="") {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Search_Page.fxml"));
            root = loader.load();
            Search_Controller s_c = loader.getController();
            s_c.set_search_res(s);
            Show.dis_play(root, e);
        }
    }
    public void setOrder_status_label(String s){order_status_label.setText(s);}
}
