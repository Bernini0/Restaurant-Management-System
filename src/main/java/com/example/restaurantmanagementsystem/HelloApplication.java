package com.example.restaurantmanagementsystem;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private double x = 0.0;
    private double y = 0.0;

    @Override
    public void start(Stage stage) throws IOException {
//        double x = 0.0;
//        double y = 0.0;

//            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
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
    public static void main(String[] args) {
        launch();
    }
}