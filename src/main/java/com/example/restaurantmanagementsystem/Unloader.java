package com.example.restaurantmanagementsystem;

import javafx.util.Pair;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static com.example.restaurantmanagementsystem.Loader.man;
import static com.example.restaurantmanagementsystem.Loader.names;

public class Unloader {
    Unloader(){
        try{
            File Menu_file = new File("src/main/resources/com/example/restaurantmanagementsystem/Data.txt");
            BufferedWriter Menu_unloader = new BufferedWriter(new FileWriter(Menu_file));

            String to_be_written=String.valueOf(man.menu.number_of_dishes);
            Menu_unloader.write(to_be_written);
            Menu_unloader.newLine();

            for(int i = 0; i < man.menu.all_dishes.size(); i++){
                Dish this_dish = man.menu.all_dishes.get(i);

                to_be_written=this_dish.getName();
                Menu_unloader.write(to_be_written);
                Menu_unloader.newLine();

                to_be_written=String.valueOf(this_dish.getPrice());
                Menu_unloader.write(to_be_written);
                Menu_unloader.newLine();

                to_be_written=this_dish.getDescription();
                if(to_be_written.isEmpty()) to_be_written="****";
                Menu_unloader.write(to_be_written);
                Menu_unloader.newLine();

                to_be_written=this_dish.getImgSrc();
                if(to_be_written.isEmpty()) to_be_written="****";
                Menu_unloader.write(to_be_written);
                Menu_unloader.newLine();
            }

            Menu_unloader.close();

        }
        catch(Exception e){System.out.println(e);}
    }
    Unloader(Integer x){
        File Login_file = new File("src/main/resources/com/example/restaurantmanagementsystem/Login.txt");
        try {
            BufferedWriter Login_unloader = new BufferedWriter(new FileWriter(Login_file));
            for(int i = 0; i < names.size(); i++){

                String s = names.get(i).getKey();
                Login_unloader.write(s);
                Login_unloader.newLine();

                s = names.get(i).getValue();
                Login_unloader.write(s);
                Login_unloader.newLine();
            }

            Login_unloader.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}