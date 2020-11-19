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
public class Tables {
    private String tableNumber;
    private boolean smoking;
    private String numberOfSeats;

    public Tables(String tableNumber, boolean smoking, String numberOfSeats) {
        this.tableNumber = tableNumber;
        this.smoking = smoking;
        this.numberOfSeats = numberOfSeats;
    }
    

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }
    
}
