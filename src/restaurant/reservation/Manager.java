/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.reservation;

/**
 *
 * @author DELL
 */
public class Manager extends Users{
     private  String role="Manager";

    public Manager(String name, String username, String password) {
        super(name, username, password);
    }
     @Override
     public String getRole() {
        return role;
    }  
    
}
