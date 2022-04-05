package com.example.restaurantmanagementsystem;

import com.example.restaurantmanagementsystem.HelloController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;

import static com.example.restaurantmanagementsystem.HelloController.names;

public class Sign_Up_to_Login {

//    private Parent root;
    private Stage stage;

    @FXML
    private TextField email;

    @FXML
    private Label email_label;

    @FXML
    private AnchorPane mainloginpane;

    @FXML
    private PasswordField password;

    @FXML
    private Label pw_label;

    @FXML
    private Button signup;

    @FXML
    private StackPane stackpane;

    @FXML
    private Label toe_lable;

    @FXML
    private TextField username;

    @FXML
    private Label username_label;

    @FXML
    private Label welcome;
    public void back_to_login(ActionEvent event) throws IOException {
        Parent p;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        p = FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
//        Show.dis_play(root,event);
        String mail = email.getText();
        String pass = password.getText();
        String name = username.getText();
        Pair<String,String> pair = new Pair<String,String>(name,pass);
        names.add(pair);
        Show s = new Show();
        s.display(stage,"Login_Page.fxml");
//        Show.dis_play(p,event);
//        Show s = new Show();
//        s.dis_play(root,e);
    }
}
