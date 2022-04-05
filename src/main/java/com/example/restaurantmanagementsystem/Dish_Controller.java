package com.example.restaurantmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class Dish_Controller {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent) {
        control.on_click(dish);
    }

    private Dish dish;
    private click_control control;

    public void setData(Dish dish, click_control control) {
        this.dish = dish;
        this.control = control;
        nameLabel.setText(dish.getName());
        priceLabel.setText(Menu.CURRENCY + dish.getPrice());
        Image image = new Image(getClass().getResourceAsStream(dish.getImgSrc()));
        img.setImage(image);
    }
}
