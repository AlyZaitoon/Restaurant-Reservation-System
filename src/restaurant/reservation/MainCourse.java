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
public class MainCourse extends Dishes{

    public MainCourse(String name, String type, float price) {
        super(name, type, price);
    }
    

    
    @Override
    public float getTax() {
       float tax= 0.15f*this.getPrice();
        return tax;
    }

    @Override
    public float getFinalPrice() {
      return this.getPrice()+this.getTax();
    }
}
