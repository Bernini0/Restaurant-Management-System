package com.example.restaurantmanagementsystem;

import java.util.Map;

public class Online_Customer extends Offline_Customer{
    String Address;

    @Override
    public Order order(Map<Dish, Integer> order_sum, Menu menu){
        Order new_order=super.order(order_sum,menu);
        new_order.changeIsOnline();
        return new_order;
    }
}
