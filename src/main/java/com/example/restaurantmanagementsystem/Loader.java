package com.example.restaurantmanagementsystem;



import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Loader {
    public static Manager man = new Manager();
    public static ArrayList<Pair<String,String>> names = new ArrayList<Pair<String,String>>();
    Loader(){
        try{
            File Menu_file = new File("src/main/resources/com/example/restaurantmanagementsystem/Data.txt");
            BufferedReader Menu_loader = new BufferedReader(new FileReader(Menu_file));
            Integer number_of_dishes;

            String input_data;
            input_data=Menu_loader.readLine();
            number_of_dishes=Integer.valueOf(input_data);

            for(int i=0;i<number_of_dishes;i++){
                String Name,des,img_src;
                Integer price;

                input_data=Menu_loader.readLine();
                Name=input_data;

                input_data = Menu_loader.readLine();
                price = Integer.valueOf(input_data);

                input_data=Menu_loader.readLine();
                des=input_data;

                input_data=Menu_loader.readLine();
                img_src=input_data;

                if(des.equals("****")) des="";
                man.menu.add_dish(Name,price,des,img_src);
            }

            Menu_loader.close();

            File Login_file = new File("src/main/resources/com/example/restaurantmanagementsystem/Login.txt");
            BufferedReader Login_loader = new BufferedReader(new FileReader(Login_file));


            while ((input_data = Login_loader.readLine())!=null){
                String username = input_data;
                String pass = Login_loader.readLine();
                names.add(new Pair<>(username,pass));
            }

            Login_loader.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}
