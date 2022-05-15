package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.restaurantmanagementsystem.HelloApplication.l;

public class Take_Orders_Controller {
    @FXML
    private TextField update_id;

    private Parent root;
    private Scene scene;
    private Stage stage;
    public void go_back_to_dashboard(ActionEvent e) throws IOException {
//        root =  FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Show s = new Show();
        s.display(stage,"dashboard.fxml");
//        Show.dis_play(root,e);
//        Show s = new Show();
//        s.dis_play(root,e);
    }
    public void update_order(){
        String s = update_id.getText();
//        System.out.println(s);
        int i = Integer.parseInt(s);
        l.man.update_order(i);
        Order x = l.man.all_order_collection.all_orders.get(i);
        if(Boolean.compare(x.getIsDelivered(),true)==0){
            System.out.println("hahahaha");
        }
    }
}
