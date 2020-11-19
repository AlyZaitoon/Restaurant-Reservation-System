/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.reservation;

import java.util.ArrayList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 *
 * @author DELL
 */
public class DishList {
    public ArrayList <Dishes> getList(Restaurant rest,ArrayList <CheckBox> main,ArrayList <CheckBox> appetizer,ArrayList <CheckBox> desert,ArrayList <TextField> mainFields,ArrayList <TextField> appetizerFields,ArrayList <TextField> desertFields)
    {
        ArrayList <Dishes> d=new ArrayList<>();
        int i,j,quantity; 
        Dishes dish;
        for(i=0;i<main.size();i++)
        {if(main.get(i).isSelected())
        for(j=0;j<rest.getMenu().size();j++)
            if(main.get(i).getText().equals(rest.getMenu().get(j).getName()))
            {
                quantity=Integer.parseInt(mainFields.get(i).getText());
                dish=new MainCourse(rest.getMenu().get(j).getName(), rest.getMenu().get(j).getType(), rest.getMenu().get(j).getPrice());
                dish.setQuantity(quantity);
                d.add(dish);
            }
        }
         for(i=0;i<appetizer.size();i++)
         {if(appetizer.get(i).isSelected())
         for(j=0;j<rest.getMenu().size();j++)
            if(appetizer.get(i).getText().equals(rest.getMenu().get(j).getName()))
            {
                quantity=Integer.parseInt(appetizerFields.get(i).getText());
                dish=new Appetizer(rest.getMenu().get(j).getName(), rest.getMenu().get(j).getType(), rest.getMenu().get(j).getPrice());
                dish.setQuantity(quantity);
                d.add(dish);
            }
    }
        for(i=0;i<desert.size();i++)
        {if(desert.get(i).isSelected())
        for(j=0;j<rest.getMenu().size();j++)
            if(desert.get(i).getText().equals(rest.getMenu().get(j).getName()))
               {
                quantity=Integer.parseInt(desertFields.get(i).getText());
                dish=new Dessert(rest.getMenu().get(j).getName(), rest.getMenu().get(j).getType(), rest.getMenu().get(j).getPrice());
                dish.setQuantity(quantity);
                d.add(dish);
            }
        
    }   
    return d;
    }
    
}
