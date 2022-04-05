package com.example.restaurantmanagementsystem;

import java.util.Map;

public class Offline_Customer implements Order_Food{
    public Integer id;

    @Override
    public Order order(Map<Dish, Integer> order_sum, Menu menu) {
        Order new_order = new Order(false);
        new_order.id=this.id;
        for(Map.Entry<Dish,Integer> entry:order_sum.entrySet()){
            new_order.total+=(menu.get_price(entry.getKey().getName())* entry.getValue());
            new_order.order_summary.put(entry.getKey().getName(), entry.getValue());
        }
        return new_order;
    }
}
