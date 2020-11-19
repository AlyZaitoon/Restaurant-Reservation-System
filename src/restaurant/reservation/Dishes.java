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
abstract public class Dishes {
    private String name;
    private String type;
    private float price;
    private int quantity;

    public Dishes(String name, String type, float price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
    
   
    
    abstract public float getTax();
    abstract public float getFinalPrice();
   
    public String getName() {
        return this.name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getType() {
        return type;
    }

    
    public void setType(String type) {
        this.type = type;
    }

    
    public float getPrice() {
        return price;
    }

    
    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
