package com.example.restaurantmanagementsystem;

import java.util.Map;

public class Order_collection {
    public Integer order_count;
    public Integer pending_count;
    public Map<Integer,Order> all_orders,pending_orders;

    void add_order(Order new_order){
        order_count++;
        pending_count++;
        all_orders.put(new_order.id, new_order);
        pending_orders.put(new_order.id,new_order);
    }


    void update(Integer id){  //check if this works
        Order to_be_updated=pending_orders.get(id);
        to_be_updated.next_state();
        if(to_be_updated.getIsDelivered()==Boolean.TRUE){
            pending_orders.remove(id);
            pending_count--;
        }
    }
}
