package com.example.restaurantmanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class Manager {

    public Map<String,Integer> loyalty;
    public Menu menu;
    public Integer id;
    public Order_collection all_order_collection,offline_order_collection,online_order_collection;
    public Sales_collection all_sale_collection,offline_sale_collection,online_sale_collection;

    public Manager(){
        loyalty= new HashMap<String,Integer>();
        menu=new Menu();
        id = 0;
//        menu.add_dish("Vat",100);
//        menu.add_dish("Fish",100);
//        System.out.println(menu.get_price("Vat"));
        all_order_collection =new Order_collection();
        offline_order_collection =new Order_collection();
        online_order_collection =new Order_collection();

        all_sale_collection =new Sales_collection() ;
        offline_sale_collection =new Sales_collection() ;
        online_sale_collection =new Sales_collection() ;


    }


    public void take_offline_order(Integer id, Integer discount, Map<Dish,Integer> dish_count){
        Offline_Customer customer=new Offline_Customer(id,discount);
        Order current_order=customer.order(dish_count,menu);

        all_order_collection.add_order(current_order);
        offline_order_collection.add_order(current_order);

        all_sale_collection.update(current_order.id,current_order.total,Boolean.FALSE);
        offline_sale_collection.update(current_order.id,current_order.total,Boolean.FALSE);

    }

    public void take_online_order(Integer id, Integer discount, String adress, Map<Dish,Integer> dish_count){
        Online_Customer customer=new Online_Customer(id,discount,adress);
        Order current_order=customer.order(dish_count,menu);

        all_order_collection.add_order(current_order);
        online_order_collection.add_order(current_order);

        all_sale_collection.update(current_order.id,current_order.total,Boolean.FALSE);
        online_sale_collection.update(current_order.id,current_order.total,Boolean.FALSE);

    }

    public void update_order(Integer id){
        all_order_collection.update(id);
        System.out.println("all order collection updated");
        Order current_order=all_order_collection.all_orders.get(id);
        if(Boolean.compare(current_order.getIsDelivered(),true)==0) {
            all_sale_collection.update(id,current_order.total,true);
        }
        if(Boolean.compare(current_order.getIsOnline(),true)==0){
            online_order_collection.update(id);
            if(Boolean.compare(current_order.getIsDelivered(),true)==0) online_sale_collection.update(id,current_order.total,true);
        }
        else{

            offline_order_collection.update(id);
            System.out.println("offline order collection updated");
            if(Boolean.compare(current_order.getIsDelivered(),true)==0) offline_sale_collection.update(id,current_order.total,true);
        }
    }


}
