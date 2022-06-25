package com.example.restaurantmanagementsystem;



import java.util.HashMap;
import java.util.Map;

public class Loader {
    public static Manager man = new Manager();
    Loader(){
        //Will take input from Files

        //Menu will also be loaded here

        man.menu.add_dish("Bento",100,"a","images/bento.jpg");
        man.menu.add_dish("Waffles",200,"b","images/waffle.jpg");
        Map<Dish,Integer> dish_count = new HashMap<Dish,Integer>();
//        dish_count.put(new Dish("Vat",100,"a","images/time.png"),1);
//        dish_count.put(new Dish("Murgi",100,"b","images/time.png"),1);
//        for(int i = 0; i < 5; i++){
//            man.take_offline_order(i,10,dish_count);
//            man.index++;
//        }
    }
}
