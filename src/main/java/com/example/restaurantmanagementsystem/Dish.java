package com.example.restaurantmanagementsystem;

class Dish {
    private String name;
    private Integer price;
    Dish(String _name, Integer _price){
        this.name=_name;
        this.price=_price;
    }

    void update(Integer new_price){
        this.price=new_price;
    }
}
