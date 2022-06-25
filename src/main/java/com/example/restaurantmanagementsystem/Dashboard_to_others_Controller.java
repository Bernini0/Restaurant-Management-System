package com.example.restaurantmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

import static com.example.restaurantmanagementsystem.HelloApplication.l;
import static com.example.restaurantmanagementsystem.Loader.man;


//import static com.example.restaurantmanagementsystem.Order_collection.all_orders;

public class Dashboard_to_others_Controller {
    @FXML
    Label user_label;

    private Parent root;
    private Scene scene;
    private Stage stage;
    public void go_to_take_orders(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Take_Order_Page.fxml"));
        root = loader.load();
        Take_Orders_Controller t_o_c = loader.getController();
        t_o_c.set_scrollPane();
        Show.dis_play(root,e);
    }
    public void go_to_Orders_Overview(MouseEvent e) throws IOException{
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Orders_Overview_Page.fxml"));
        root = loader.load();
        Orders_Overview_Controller ooc = loader.getController();
        man.calculate_sales_and_orders_insight();
        ooc.setter(Integer.toString(man.today_sale),Integer.toString(man.today_order_count),Integer.toString(man.on_the_way),Integer.toString(man.onsite_order_count),Integer.toString(man.onsite_order_count-man.onsite_delivered_order_count),Integer.toString(man.online_order_count),Integer.toString((int)(man.today_sale*(0.2))),Integer.toString(man.onsite_delivered_order_count),Integer.toString(man.onsite_delivered_order_count),Integer.toString(man.online_delivared_order_count),Integer.toString(man.net_loss_online+man.net_loss_onsite));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void go_to_sales_insight(MouseEvent e) throws IOException{
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Sales_Insight_Page.fxml"));
        root = loader.load();
        Sales_Insight_Controller sc4 = loader.getController();
        man.calculate_sales_and_orders_insight();
        System.out.println(man.total_sale_onsite);
        sc4.setter(Integer.toString(man.today_sale),Integer.toString(man.today_order_count),Integer.toString(man.on_the_way),Integer.toString(man.total_sale_onsite),Integer.toString(man.net_profit_onsite),Integer.toString(man.total_sale_online),Integer.toString(man.net_profit_online),Integer.toString(man.total_cost_onsite),Integer.toString(man.net_loss_onsite),Integer.toString(man.total_cost_online),Integer.toString(man.net_loss_online));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void go_to_menu_page(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Menu_Page.fxml"));
        root = loader.load();
        Menu_Controller m_c = loader.getController();
        m_c.set_scrollpane();
        Show.dis_play(root, e);
    }
    public void go_to_order_status(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Order_Status.fxml"));
        root = loader.load();
        Order_Status_Controller o_s_c = loader.getController();
        o_s_c.set_scrollpane(1);
        Show.dis_play(root, e);
    }
    public void go_to_logout(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Show s = new Show();
        s.display(stage,"Login_Page.fxml");
    }
}