package com.example.restaurantmanagementsystem;

import java.util.HashMap;
import java.util.Map;

class Order {
    public Integer id;

    public String customer_name;
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
        if(isOnline==true){
            if(state.equals("Preparing")){
                System.out.println("Paisi");
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
    public void setCustomer_name(String s){
        customer_name = s;
    }

    public String getCustomer_name(){return customer_name;}

}
