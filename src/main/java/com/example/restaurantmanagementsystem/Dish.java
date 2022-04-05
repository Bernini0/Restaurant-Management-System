package com.example.restaurantmanagementsystem;

public class Dish {
    private String name, image_source, color;
    private Integer price;

    public Dish(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getImgSrc() {
        return image_source;
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

    

