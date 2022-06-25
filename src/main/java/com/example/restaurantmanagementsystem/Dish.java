package com.example.restaurantmanagementsystem;

import javafx.scene.image.ImageView;

public class Dish {
    private String name, image_source, color, description;
    private Integer price;

    public Dish(String name, Integer price, String _description) {
        this.name = name;
        this.price = price;
        description = _description;
    }
    public Dish(String name, Integer price, String _description,String _imagesrc) {
        this.name = name;
        this.price = price;
        description = _description;
        image_source = _imagesrc;
    }
    public Dish(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public String getDescription(){return  description;}
    public String getImgSrc() {
        return image_source;
    }

    public ImageView getImage(){
        String src = getImgSrc();
        return new ImageView(src);
    }

    public void setImgSrc(String image_source) {
        this.image_source = image_source;
    }

    public Integer getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void update(Integer new_price){
        this.price=new_price;
    }
}

    

