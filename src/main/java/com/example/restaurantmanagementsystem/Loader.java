package com.example.restaurantmanagementsystem;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Loader {
    public static Manager man = new Manager();
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

                input_data=Menu_loader.readLine();
                price=Integer.valueOf(input_data);

                input_data=Menu_loader.readLine();
                des=input_data;

                input_data=Menu_loader.readLine();
                img_src=input_data;

                if(img_src.equals("****")&&des.equals("****")) man.menu.add_dish(Name,price);
                else if(img_src.equals("****")) man.menu.add_dish(Name,price,des);
                else man.menu.add_dish(Name,price,des,img_src);
            }

            Menu_loader.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}
