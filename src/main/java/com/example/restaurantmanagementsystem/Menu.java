package com.example.restaurantmanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    List<Dish> all_dishes = new ArrayList<Dish>();
    Map<String,Integer> prices =new HashMap<String,Integer>();

    public void add_dish(String name, Integer price){
        Dish new_dish = new Dish(name,price);
        all_dishes.add(new_dish);
        prices.put(name,price);
    }

    public void remove_dish(String name){
        Integer price = prices.get(name);
        Dish dish_to_be_removed = new Dish(name,price);
        all_dishes.remove(dish_to_be_removed);
        prices.remove(name);
    }
}
