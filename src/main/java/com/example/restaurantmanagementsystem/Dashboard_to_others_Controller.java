package com.example.restaurantmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard_to_others_Controller {
    @FXML
    Label user_label;

    private Parent root;
//    private Scene scene;
    private Stage stage;

    public void go_to_onsite_order(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//        root =  FXMLLoader.load(getClass().getResource("Onsite_Orders_Page.fxml"));
//        Show.dis_play(root,e);
        Show s = new Show();
        s.display(stage,"Onsite_Orders_Page.fxml");
    }
    public void go_to_online_order(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//        root =  FXMLLoader.load(getClass().getResource("Online_Order_Page.fxml"));
//        Show.dis_play(root,e);
        Show s = new Show();
        s.display(stage,"Online_Order_Page.fxml");
    }
    public void go_to_sales_insight(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//        root =  FXMLLoader.load(getClass().getResource("Sales_Insight_Page.fxml"));
//        Show.dis_play(root,e);
        Show s = new Show();
        s.display(stage,"Sales_Insight_Page.fxml");
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

}