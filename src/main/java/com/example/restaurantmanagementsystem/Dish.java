package com.example.restaurantmanagementsystem;

class Dish {
    public String name;
    public Integer price;
    Dish(String _name, Integer _price){
        this.name=_name;
        this.price=_price;
    }

    public void update(Integer new_price){
        this.price=new_price;
    }
}
