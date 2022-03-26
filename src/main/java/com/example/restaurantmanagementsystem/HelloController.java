package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class HelloController {
    private Parent root;

    public void login(ActionEvent e) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
        Show.dis_play(root,e);
    }

}