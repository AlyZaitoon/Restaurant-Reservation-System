/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.reservation;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Restaurant {
    LocalDate date = LocalDate.now();
    private float todayMoney;
    private String restaurantName;
    private int numberOfOrders=0;
    private ArrayList<Users> users = new ArrayList<Users>();
    private ArrayList<Order> orders = new ArrayList<Order>();
    private ArrayList<Tables> availableTables = new ArrayList<Tables>();
    private ArrayList<Tables> reservedTables = new ArrayList<Tables>();
    private ArrayList<Dishes> menu = new ArrayList<Dishes>();

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Tables> getAvailableTables() {
        return availableTables;
    }

    public void setAvailableTables(ArrayList<Tables> availableTables) {
        this.availableTables = availableTables;
    }

    public ArrayList<Tables> getReservedTables() {
        return reservedTables;
    }

    public void setReservedTables(ArrayList<Tables> reservedTables) {
        this.reservedTables = reservedTables;
    }

    public ArrayList<Dishes> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Dishes> menu) {
        this.menu = menu;
    }

    
    public float getTodayMoney() {
        calcTodayMoney();
        return todayMoney;
    }

    public void setTodayMoney(float todayMoney) {
        this.todayMoney = todayMoney;
    }
    
   public Users Validate(String username,String password)
   {int i;Users n;
       for(i=0;i<users.size();i++){
           if(users.get(i).getUsername().equals(username)&&users.get(i).getPassword().equals(password))
           return users.get(i);
       }
       return null;
  
   }
   
   public void calcTodayMoney() 
   {this.todayMoney=0;
       for(int k=0;k<this.orders.size();k++)
           if(this.orders.get(k).getDate().equalsIgnoreCase(date.toString()))
           this.todayMoney+=this.orders.get(k).getTotalPrice();
   }
}
