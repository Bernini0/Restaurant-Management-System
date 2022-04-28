package com.example.restaurantmanagementsystem;

import java.util.Map;

public class Sales_collection {
    public Integer today_sale;
    public Map<Integer,Integer> completed_daily_sales,pending_sales;

    public void update(Integer id, Integer sale, Boolean done){
        if(done==Boolean.TRUE){
            today_sale +=sale;
            completed_daily_sales.put(id,sale);
            pending_sales.remove(id);
        }
        else pending_sales.put(id,sale);
    }

}
