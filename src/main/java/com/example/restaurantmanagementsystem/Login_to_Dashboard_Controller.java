package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login_to_Dashboard_Controller {
    @FXML
    TextField user_text_field;
    @FXML
    TextField user_pass;

    private Parent root;
    private Scene scene;
    private Stage stage;
    public void d_board(ActionEvent e) throws IOException {
        root =  FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Show.dis_play(root,e);
    }
    public void back_to_login(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("First_Page.fxml"));
        Show.dis_play(root,e);
    }
}
