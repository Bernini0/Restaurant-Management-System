package com.example.restaurantmanagementsystem;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Menu_Controller implements Initializable {
    @FXML
    private VBox chosenDishCard;

    @FXML
    private Label dishNameLable;

    @FXML
    private Label dishPriceLabel;

    @FXML
    private ImageView dishImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private List<Dish> dishes = new ArrayList<>();
    private Image image;
    private click_control control;

    private List<Dish> getData() {
        List<Dish> dishes = new ArrayList<>();
        Dish dish;

        dish = new Dish("Bibimbap", 10);
        dish.setImgSrc("/images/bibimbap.jpg");
        dish.setColor("6A7324");
        dishes.add(dish);

        dish = new Dish("Hot Chocolate", 8);
        dish.setImgSrc("/images/hotchoc.jpg");
        dish.setColor("A7745B");
        dishes.add(dish);

        dish = new Dish("Harissa Pasta", 15);
        dish.setImgSrc("/images/pasta.jpg");
        dish.setColor("F16C31");
        dishes.add(dish);

        dish = new Dish("Macaroons", 12);
        dish.setImgSrc("/images/macaroon.jpg");
        dish.setColor("291D36");
        dishes.add(dish);

        dish = new Dish("Chicken Curry and Naan", 20);
        dish.setImgSrc("/images/chicken_curry.jpg");
        dish.setColor("22371D");
        dishes.add(dish);

        dish = new Dish("Bento", 10);
        dish.setImgSrc("/images/bento.jpg");
        dish.setColor("FB5D03");
        dishes.add(dish);

        dish = new Dish("Raspberry Trifle", 15);
        dish.setImgSrc("/images/raspberry.jpg");
        dish.setColor("80080C");
        dishes.add(dish);

        dish = new Dish("English Breakfast", 20);
        dish.setImgSrc("/images/engbf.jpg");
        dish.setColor("FFB605");
        dishes.add(dish);

        dish = new Dish("Berry Waffle", 12);
        dish.setImgSrc("/images/waffle.jpg");
        dish.setColor("5F060E");
        dishes.add(dish);

        dish = new Dish("Twin Rollcakes", 15);
        dish.setImgSrc("/images/rollcake");
        dish.setColor("E7C00F");
        dishes.add(dish);

        return dishes;
    }

    private void setChosenDish(Dish dish) {
        dishNameLable.setText(dish.getName());
        dishPriceLabel.setText(Menu.CURRENCY + dish.getPrice());
        image = new Image(getClass().getResourceAsStream(dish.getImgSrc()));
        dishImg.setImage(image);
        chosenDishCard.setStyle("-fx-background-color: #" + dish.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }


    public void initialize(URL location, ResourceBundle resources) {
        dishes.addAll(getData());
        if (dishes.size() > 0) {
            setChosenDish(dishes.get(0));
            control = new click_control() {
                @Override
                public void on_click(Dish dish) {
                    setChosenDish(dish);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < dishes.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("resources/com/example/restaurantmanagementsystem/Dish.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                Dish_Controller dishController = fxmlLoader.getController();
                dishController.setData(dishes.get(i),control);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
