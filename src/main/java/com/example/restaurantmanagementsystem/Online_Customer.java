package com.example.restaurantmanagementsystem;

import java.util.Map;

public class Online_Customer extends Offline_Customer{
    String address;

    public Online_Customer(Integer id, Integer discount, String address){
        super(id,discount);
        this.address=address;
    }

    @Override
    public Order order(Map<Dish, Integer> order_sum, Menu menu, String name){
        discount=0;
        Order new_order=super.order(order_sum,menu,name);
        new_order.changeIsOnline();
        return new_order;
    }
}
