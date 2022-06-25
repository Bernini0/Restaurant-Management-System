package com.example.restaurantmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

import static com.example.restaurantmanagementsystem.HelloApplication.l;


//import static com.example.restaurantmanagementsystem.Order_collection.all_orders;

public class Dashboard_to_others_Controller {
    @FXML
    Label user_label;

    private Parent root;
    private Scene scene;
    private Stage stage;
    int today_sale;
    int today_order_count;
    int online_order_count;
    int onsite_order_count;
    int onsite_delivered_order_count;
    int online_delivared_order_count;
    int on_the_way;
    int total_sale_onsite;
    int total_cost_onsite;
    int net_profit_onsite;
    int net_loss_onsite;
    int total_sale_online;
    int total_cost_online;
    int net_profit_online;
    int net_loss_online;
    private void setting(int a, int b, int c, int d, int e, int g, int f, int h, int i, int j, int k,int l, int m, int n, int o){
        a = b = c = d = e = f = g = h = i = j = k = l = m = n = o = 0;
    }
    private double profit(double a){
        return (a*(0.2));
    }
    public void calculate_sales_and_orders_insight(){
        setting(today_sale,today_order_count,on_the_way,total_sale_online,total_cost_online,total_sale_onsite,total_cost_onsite,net_loss_onsite,net_profit_onsite,net_profit_online,net_loss_online,online_order_count,onsite_order_count,onsite_delivered_order_count,online_delivared_order_count);
//        Order_collection oc = new Order_collection();
//        for (Integer i = 0; i < 4; i++){
//            Order x = new Order(false);
//            x.id = i;
//            x.total = 100;
//            x.order_summary.put("Vat",100);
//            x.order_summary.put("Fist",100);
//            oc.add_order(x);
////            all_orders.put(x.id,x);
//        }
////        System.out.println(all_orders.get(0).total);
        for (Map.Entry<Integer,Order> entry:l.man.all_order_collection.all_orders.entrySet()){
            Order now_processing = l.man.all_order_collection.all_orders.get(entry.getKey());
            today_sale += now_processing.total;
            today_order_count++;
            System.out.println(now_processing.getIsOnline());
            if(Boolean.compare(now_processing.getIsOnline(),true)==0){
                total_sale_online+= now_processing.total;
                online_delivared_order_count++;
                if(Boolean.compare(now_processing.getIsDelivered(),false)==0)on_the_way++;
                else online_delivared_order_count++;
            }
            else{
                onsite_order_count++;
                total_sale_onsite+= now_processing.total;
                if(Boolean.compare(now_processing.getIsDelivered(),true)==0)onsite_delivered_order_count++;
            }
        }
        net_profit_online = (int)profit(total_sale_online);
        net_profit_onsite = (int)profit(total_sale_onsite);
        total_cost_onsite = total_sale_onsite - net_profit_onsite;
        total_cost_online = total_sale_online - net_profit_online;
        net_loss_onsite = net_loss_online = 0;
    }
    public void go_to_take_orders(MouseEvent e) throws IOException{
//        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Take_Order_Page.fxml"));
        root = loader.load();
        Take_Orders_Controller t_o_c = loader.getController();
        t_o_c.set_scrollPane();
        Show.dis_play(root,e);
    }
    public void go_to_Orders_Overview(MouseEvent e) throws IOException{
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Orders_Overview_Page.fxml"));
        root = loader.load();
        Dashboard_to_others_Controller dtoc = new Dashboard_to_others_Controller();
        Orders_Overview_Controller ooc = loader.getController();
        dtoc.calculate_sales_and_orders_insight();
        ooc.setter(Integer.toString(dtoc.today_sale),Integer.toString(dtoc.today_order_count),Integer.toString(dtoc.on_the_way),Integer.toString(dtoc.onsite_order_count),Integer.toString(dtoc.onsite_order_count-dtoc.onsite_delivered_order_count),Integer.toString(dtoc.online_order_count),Integer.toString((int)(dtoc.today_sale*(0.2))),Integer.toString(dtoc.onsite_delivered_order_count),Integer.toString(0),Integer.toString(dtoc.online_delivared_order_count),Integer.toString(0));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void go_to_sales_insight(MouseEvent e) throws IOException{
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Sales_Insight_Page.fxml"));
        root = loader.load();
        Sales_Insight_Controller sc4 = loader.getController();
        calculate_sales_and_orders_insight();
        System.out.println(total_sale_onsite);
        sc4.setter(Integer.toString(today_sale),Integer.toString(today_order_count),Integer.toString(on_the_way),Integer.toString(total_sale_onsite),Integer.toString(net_profit_onsite),Integer.toString(total_sale_online),Integer.toString(net_profit_online),Integer.toString(total_cost_onsite),Integer.toString(net_loss_onsite),Integer.toString(total_cost_online),Integer.toString(net_loss_online));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void go_to_menu_page(MouseEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu_Page.fxml"));
        root = loader.load();
        Menu_Controller m_c = loader.getController();
        m_c.set_scrollpane();
        Show.dis_play(root,e);
    }
    public void go_to_account_page(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Show s = new Show();
        s.display(stage,"Account_Page.fxml");
    }
    public void go_to_logout(MouseEvent e) throws IOException{
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Show s = new Show();
        s.display(stage,"Login_Page.fxml");
    }

}