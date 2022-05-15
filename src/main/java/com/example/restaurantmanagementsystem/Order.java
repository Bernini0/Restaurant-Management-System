package com.example.restaurantmanagementsystem;

import java.util.HashMap;
import java.util.Map;

class Order {
    public Integer id;
    public Integer total;
    private Boolean isOnline;
    private Boolean isDelivered;
    private String state;
    public Map<String,Integer> order_summary = new HashMap<String,Integer>();

    public Order(Boolean mode){
        state="Preparing";
        isOnline=mode;
        isDelivered=false;
        total = 0;
    }
    public String getState(){
        return state;
    }


    public void next_state(){
        if(Boolean.compare(isOnline,true)==0){
            if(state.equals("Preparing")){
                state="On Route";
            }
            else{
                state="Delivered";
                isDelivered = true;
            }
        }
        else{
            state="Delivered";
            isDelivered = true;
        }
    }

    public Boolean getIsDelivered (){
        return isDelivered;
    }
    public Boolean getIsOnline(){
        return isOnline;
    }
    public void changeIsOnline() { isOnline=!isOnline; }

}
