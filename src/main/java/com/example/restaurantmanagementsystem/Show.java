package com.example.restaurantmanagementsystem;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Show {
    private double x = 0.0;
    private double y = 0.0;
    private Parent root1;
    {
        try {
            root1 = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dis_play(Parent root, Event e){
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public void display(Stage stage, String filename) throws IOException {
        Parent root;
        if(filename.equals("dashboard.fxml")){
            root = root1;
        }
        else {
            root = FXMLLoader.load(getClass().getResource(filename));
        }
        Scene scene = new Scene(root);
        root.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}