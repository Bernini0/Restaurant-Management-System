package com.example.restaurantmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Dashboard_to_others_Controller {
    @FXML
    Label user_label;

    private Parent root;
//    private Scene scene;
//    private Stage stage;

    public void go_to_onside_order(MouseEvent e) throws IOException{
        root =  FXMLLoader.load(getClass().getResource("Onsite_Orders_Page.fxml"));
        Show.dis_play(root,e);
    }
    public void go_to_online_order(MouseEvent e) throws IOException{
        root =  FXMLLoader.load(getClass().getResource("Online_Order_Page.fxml"));
        Show.dis_play(root,e);
    }
    public void go_to_sales_insight(MouseEvent e) throws IOException{
        root =  FXMLLoader.load(getClass().getResource("Sales_Insight_Page.fxml"));
        Show.dis_play(root,e);
    }
    public void go_to_menu_page(MouseEvent e) throws IOException{
        root =  FXMLLoader.load(getClass().getResource("Menu_Page.fxml"));
        Show.dis_play(root,e);
    }
    public void go_to_account_page(MouseEvent e) throws IOException{
        root =  FXMLLoader.load(getClass().getResource("Account_Page.fxml"));
        Show.dis_play(root,e);
    }
    public void go_to_logout(MouseEvent e) throws IOException{
        root =  FXMLLoader.load(getClass().getResource("First_Page.fxml"));
        Show.dis_play(root,e);
    }

}