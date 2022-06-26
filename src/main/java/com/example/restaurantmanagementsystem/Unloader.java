package com.example.restaurantmanagementsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

import static com.example.restaurantmanagementsystem.Loader.man;

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
}