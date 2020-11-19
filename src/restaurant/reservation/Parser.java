/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.reservation;
import java.io.*;
import java.util.*;
import org.jdom2.*;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jdom2.Document;

import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author DELL
 */
public class Parser {

    /**
     *
     */
    public void parse(Restaurant r){ try{
   SAXBuilder saxbuilder=new SAXBuilder(); 
   File f =new File("Restaurant.xml");
   Document doc=saxbuilder.build(f);
   Element restaurant=doc.getRootElement();
    List <Element> nodes= restaurant.getChildren();
    Element node;
    Loader a=new Loader();
    for(int i=0;i<nodes.size();i++){
        node=nodes.get(i);
       a.load(node,r);
       
    }
    
    
}catch(JDOMException | IOException e){
    e.printStackTrace();
}
}
    public void writeInXml(ArrayList<Users> usersList, ArrayList<Tables> avTablesList, ArrayList<Tables> resTablesList,ArrayList<Dishes> dishesList,ArrayList<Order> ordersList) throws IOException{
        Document doc =new Document();
        doc.setRootElement(new Element ("restaurant"));
        Element users=new Element ("users");
        Element tables=new Element ("tables");
        Element dishes=new Element ("dishes");
        Element orders=new Element ("orders");
        for(Users a:usersList){
            Element user=new Element ("user");
            user.addContent(new Element("name").setText(a.getName()));
            user.addContent(new Element("role").setText(a.getRole()));
            user.addContent(new Element("username").setText(a.getUsername()));
            user.addContent(new Element("password").setText(a.getPassword()));
            users.addContent(user);
        }
       for(Tables b:avTablesList){
            Element table=new Element ("table");
            table.addContent(new Element("number").setText(b.getTableNumber()));
            table.addContent(new Element("number_of_seats").setText(b.getNumberOfSeats()));
            table.addContent(new Element("smoking").setText(String.valueOf(b.isSmoking())));
            
            tables.addContent(table);
        }
     for(Tables b:resTablesList){
            Element table=new Element ("table");
            table.addContent(new Element("number").setText(b.getTableNumber()));
            table.addContent(new Element("number_of_seats").setText(b.getNumberOfSeats()));
            table.addContent(new Element("smoking").setText(String.valueOf(b.isSmoking())));
            
            tables.addContent(table);
        }
     for(Dishes b:dishesList){
            Element dish=new Element ("dish");
            dish.addContent(new Element("name").setText(b.getName()));
            dish.addContent(new Element("price").setText(b.getPrice()+""));
            dish.addContent(new Element("type").setText(b.getType()));
            
           dishes.addContent(dish);
        }
     for(Order b:ordersList){
            Element order=new Element ("order");
            order.addContent(new Element("name").setText(b.getName()));
            order.addContent(new Element("ordernumber").setText(b.getOrderNumber()+""));
            order.addContent(new Element("tablenumber").setText(b.getTableNumber()+""));
            order.addContent(new Element("Total_price").setText(b.getTotalPrice()+""));
            order.addContent(new Element("date").setText(b.getDate()+""));
            order.addContent(new Element("time").setText(b.getTime()+""));
             Element dishesinorder = null;
            for(Dishes a:b.getDishes()){
                dishesinorder=new Element("dish");
                dishesinorder.addContent(new Element("name").setText(a.getName()));
                dishesinorder.addContent(new Element("price").setText(a.getPrice()+""));
                dishesinorder.addContent(new Element("type").setText(a.getType()));
                dishesinorder.addContent(new Element("quantity").setText(a.getQuantity()+""));
                  order.addContent(dishesinorder);
            }
       
         
            orders.addContent(order);
        }
     
     doc.getRootElement().addContent(users);
     doc.getRootElement().addContent(tables);
     doc.getRootElement().addContent(dishes);
     doc.getRootElement().addContent(orders);
      XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
       FileOutputStream f =new FileOutputStream("Restaurant.xml");
      xmlOutputter.output(doc,f);
    }   
    
}