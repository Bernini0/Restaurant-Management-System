package com.example.restaurantmanagementsystem;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    public static final String CURRENCY = "$";

    public Integer number_of_dishes;
    public List<Dish> all_dishes;
    public Map<String,Integer> prices;
    public Map<String, Dish> check_dishes;
    public ImageView image;

    public Menu(){
        number_of_dishes=0;
        all_dishes = new ArrayList<Dish>();
        prices =new HashMap<String,Integer>();
        check_dishes = new HashMap<String, Dish>();
    }

    public void add_dish(String name, Integer price){
        Dish new_dish = new Dish(name,price);
        all_dishes.add(new_dish);
        prices.put(name,price);
        check_dishes.put(name, new_dish);
        number_of_dishes+=1;
    }
    public void add_dish(String name, Integer price, String description){
        Dish new_dish = new Dish(name,price,description);
        all_dishes.add(new_dish);
        prices.put(name,price);
        check_dishes.put(name, new_dish);
        number_of_dishes+=1;
    }
    public void add_dish(String name, Integer price, String description, String imagesrc){
        Dish new_dish = new Dish(name,price,description,imagesrc);
        all_dishes.add(new_dish);
        prices.put(name,price);
        check_dishes.put(name, new_dish);
        number_of_dishes+=1;
    }

    public void remove_dish(String name){
        Integer price = prices.get(name);
        Dish dish_to_be_removed = check_dishes.get(name);
        check_dishes.remove(name);
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
