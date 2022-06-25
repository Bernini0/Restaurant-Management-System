package com.example.restaurantmanagementsystem;

import java.util.Map;

public interface Order_Food {
    Order order(Map<Dish,Integer> order_sum, Menu menu, String name);
}
