/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.reservation;
import java.util.*;
import org.jdom2.*;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author DELL
 */

public class Loader {
    LocalDate date = LocalDate.now(); 
    public void load(Element a,Restaurant r){
        String x=a.getName();
        List <Element> nodes=a.getChildren();
        Users s ;
        Tables t;
        Dishes d=null;
        Order o;
        r.setDate(date);
    switch(x){
        
        case "users":
            for(int j=0;j<nodes.size();j++){
                if(nodes.get(j).getChild("role").getText().equalsIgnoreCase("Manager"))
                  s=new Manager(nodes.get(j).getChild("name").getText(),nodes.get(j).getChild("username").getText(), nodes.get(j).getChild("password").getText());
                else if(nodes.get(j).getChild("role").getText().equalsIgnoreCase("Cooker"))
                  s=new Cooker(nodes.get(j).getChild("name").getText(),nodes.get(j).getChild("username").getText(), nodes.get(j).getChild("password").getText()); 
                else if(nodes.get(j).getChild("role").getText().equalsIgnoreCase("Client"))
                  s=new Customers(nodes.get(j).getChild("name").getText(),nodes.get(j).getChild("username").getText(), nodes.get(j).getChild("password").getText()); 
                else
                  s=new Waiter(nodes.get(j).getChild("name").getText(),nodes.get(j).getChild("username").getText(), nodes.get(j).getChild("password").getText()); 
               
                r.getUsers().add(s); 
            }
            
            break;
        case "tables":
            for(int j=0;j<nodes.size();j++){
              t=new Tables(nodes.get(j).getChild("number").getText(),Boolean.parseBoolean(nodes.get(j).getChild("smoking").getText()),nodes.get(j).getChild("number_of_seats").getText());
              r.getAvailableTables().add(t);
            }
            break;
        case "dishes":
            for(int j=0;j<nodes.size();j++){
                 if(nodes.get(j).getChild("type").getText().equalsIgnoreCase("main_course"))
                  d=new MainCourse(nodes.get(j).getChild("name").getText(),nodes.get(j).getChild("type").getText(),Float.parseFloat( nodes.get(j).getChild("price").getText()));
                 else if(nodes.get(j).getChild("type").getText().equalsIgnoreCase("appetizer"))
                  d=new Appetizer(nodes.get(j).getChild("name").getText(),nodes.get(j).getChild("type").getText(),Float.parseFloat( nodes.get(j).getChild("price").getText()));
                 else 
                  d=new Dessert(nodes.get(j).getChild("name").getText(),nodes.get(j).getChild("type").getText(),Float.parseFloat( nodes.get(j).getChild("price").getText()));
                
              r.getMenu().add(d);
          
            }
            break;
        case "orders":
            
            for(int j=0;j<nodes.size();j++){
            o=new Order();
            o.setName(nodes.get(j).getChild("name").getText());
            o.setOrderNumber(Integer.parseInt(nodes.get(j).getChild("ordernumber").getText()));
            o.setTableNumber(Integer.parseInt(nodes.get(j).getChild("tablenumber").getText()));
            o.setTotalPrice(Float.parseFloat(nodes.get(j).getChild("Total_price").getText()));
            o.setDate(nodes.get(j).getChild("date").getText());
            o.setTime(nodes.get(j).getChild("time").getText());
            
          List <Element> dishList=nodes.get(j).getChildren("dish");
          int k;
          for( k=0;k<dishList.size();k++)
          {
                 if(dishList.get(k).getChild("type").getText().equalsIgnoreCase("main_course"))
                 {d=new MainCourse(dishList.get(k).getChild("name").getText(),dishList.get(k).getChild("type").getText(),Float.parseFloat( dishList.get(k).getChild("price").getText()));
                 d.setQuantity(Integer.parseInt(dishList.get(k).getChild("quantity").getText()));}
                 else if(dishList.get(k).getChild("type").getText().equalsIgnoreCase("appetizer"))
                 {d=new Appetizer(dishList.get(k).getChild("name").getText(),dishList.get(k).getChild("type").getText(),Float.parseFloat( dishList.get(k).getChild("price").getText()));
                 d.setQuantity(Integer.parseInt(dishList.get(k).getChild("quantity").getText()));}
                 else if(dishList.get(k).getChild("type").getText().equalsIgnoreCase("desert"))
                 {d=new Dessert(dishList.get(k).getChild("name").getText(),dishList.get(k).getChild("type").getText(),Float.parseFloat( dishList.get(k).getChild("price").getText()));
                 d.setQuantity(Integer.parseInt(dishList.get(k).getChild("quantity").getText()));}
                 o.addDishes(d);
          }
          for(k=0;k<r.getAvailableTables().size();k++)
          if((o.getTableNumber()+"").equalsIgnoreCase(r.getAvailableTables().get(k).getTableNumber())&&o.getDate().equalsIgnoreCase(date.toString()))
             if(LocalTime.parse(o.getTime()).plusHours(3).compareTo(LocalTime.of(0,0))!=-1 || LocalTime.parse(o.getTime()).plusHours(3).compareTo(LocalTime.now())!=-1)
              r.getReservedTables().add(r.getAvailableTables().get(k));
          
          for(k=0;k<r.getReservedTables().size();k++)
           r.getAvailableTables().remove(r.getReservedTables().get(k));
          
          r.getOrders().add(o);
          
            
            }
        if(r.getOrders().get(r.getOrders().size()-1).getDate().equals(r.getDate().toString())){
            r.setNumberOfOrders(r.getOrders().get(r.getOrders().size()-1).getOrderNumber());
        }
        break;    
    }
}

}
