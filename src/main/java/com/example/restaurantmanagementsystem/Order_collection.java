package com.example.restaurantmanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class Order_collection {
    public Integer order_count;
    public Integer pending_count;
    public Map<Integer,Order> all_orders,pending_orders;


    public Order_collection(){
        order_count = 0;
        pending_count = 0;
        all_orders = new HashMap<Integer,Order>();
        pending_orders = new HashMap<Integer,Order>();
    }

    void add_order(Order new_order){
        order_count++;
        pending_count++;
        all_orders.put(new_order.id, new_order);
        pending_orders.put(new_order.id,new_order);
    }



    void update(Integer id){  //check if this works
//        System.out.println(id+" ");
        Order to_be_updated=pending_orders.get(id);
        System.out.println("total order sum " + to_be_updated.total);
        if(to_be_updated==null){
            System.out.println("does not work");
        }
        else {
            System.out.println("works");
            to_be_updated.next_state();
            if (to_be_updated.getIsDelivered() == Boolean.TRUE) {
                pending_orders.remove(id);
                pending_count--;
            }
        }
    }
}
