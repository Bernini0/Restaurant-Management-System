package com.example.restaurantmanagementsystem;

import java.util.Map;

public class Offline_Customer implements Order_Food{
    public Integer id;
    public Integer discount;

    public Offline_Customer(Integer id, Integer discount){
        this.id=id;
        this.discount=discount;

    }


    public Order order(Map<Dish, Integer> order_sum, Menu menu, String name) {
        Order new_order = new Order(false);
        new_order.setCustomer_name(name);
        new_order.id=this.id;
        Integer curr,disc;
        for(Map.Entry<Dish,Integer> entry:order_sum.entrySet()){
            curr=(menu.get_price(entry.getKey().getName())* entry.getValue());
            disc=curr*discount;
            disc/=100;
            new_order.total+=curr-disc;
            new_order.order_summary.put(entry.getKey().getName(), entry.getValue());
        }
        return new_order;
    }
}
