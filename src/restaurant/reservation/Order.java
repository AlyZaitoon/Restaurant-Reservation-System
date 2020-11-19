/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.reservation;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate; 
/**
 *
 * @author DELL
 */
public class Order {
private String name;
private int orderNumber;
private int tableNumber;
private ArrayList<Dishes> dishes = new ArrayList<Dishes>();
float totalPrice;
private String date;
private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }


    public void addDishes(Dishes dish) {
        this.dishes.add(dish);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public ArrayList<Dishes> getDishes() {
        return dishes;
    }

    public float getTotalPrice() {
        calcTotalPrice(dishes);
        return totalPrice;
    }
     public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setDishes(ArrayList<Dishes> dishes) {
        this.dishes = dishes;
    }


public void calcTotalPrice(ArrayList<Dishes> dishes)
{   this.totalPrice=0;
    for(int i=0;i<dishes.size();i++){
    this.totalPrice+=dishes.get(i).getFinalPrice()*dishes.get(i).getQuantity();
}
 
}
}


