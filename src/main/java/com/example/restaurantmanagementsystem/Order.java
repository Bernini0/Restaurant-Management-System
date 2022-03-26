package com.example.restaurantmanagementsystem;

import java.util.HashMap;
import java.util.Map;

class Order {
    Integer id;
    Integer total;
    private Boolean isOnline;
    private Boolean isDelivered;
    private String state;
    Map<String,Integer> order_summary = new HashMap<String,Integer>();

    public String getState(){
        return state;
    }


    public void next_stage(){
        if(isOnline==Boolean.TRUE){
            if(state.equals("Preparing")){
                state="On Route";
            }
            else{
                state="Delivered";
            }
        }
        else{
            state="Delivered";
        }
    }

    public Boolean getIsDelivered (){
        return isDelivered;
    }


}
