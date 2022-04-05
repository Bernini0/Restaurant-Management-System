package com.example.restaurantmanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    public static final String CURRENCY = "$";

    public Integer number_of_dishes=0;
    public List<Dish> all_dishes = new ArrayList<Dish>();
    public Map<String,Integer> prices =new HashMap<String,Integer>();

    public void add_dish(String name, Integer price){
        Dish new_dish = new Dish(name,price);
        all_dishes.add(new_dish);
        prices.put(name,price);
        number_of_dishes+=1;
    }

    public void remove_dish(String name){
        Integer price = prices.get(name);
        Dish dish_to_be_removed = new Dish(name,price);
        all_dishes.remove(dish_to_be_removed);
        prices.remove(name);
        number_of_dishes-=1;
    }

    public void edit_price_of_dish(String name, Integer new_price){
        Integer price = prices.get(name);
        Dish dish_to_be_edited = new Dish(name,price);
        Dish current_dish;
        for(int i=0;i<number_of_dishes;i++) {
            current_dish = all_dishes.get(i);
            if (current_dish.getName().equals(name)) {
                current_dish.update(new_price);
            }
        }
    }

    public Integer get_price(String name) {return prices.get(name);}

}
