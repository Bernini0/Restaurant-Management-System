package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene4Controller {
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
}
