/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation.application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael McCormick (15012271)
 */
public class Room {
    
    //Declares class attributes
    private int roomNumber;
    private double monthlyRent;
    private int hallID;
    private String cleanStatus;
    private String occupancy;
    private Lease lease;
    private Halls hall;
    private ArrayList<Lease> leases;
    private ArrayList<Halls> halls;
    
    //Class Constructor
    public Room(int roomNumber, double monthlyRent, int hallID,
            String cleanStatus) {
        this.roomNumber = roomNumber;
        this.monthlyRent = monthlyRent;
        this.hallID = hallID;
        this.cleanStatus = cleanStatus;
        if(cleanStatus.equals("Offline")) {
            this.occupancy = "Unoccupied";
        }
        else {
            this.occupancy = "Occupied";
        }
    }
    
    /* -Class getters- */    
    public int getRoomNumber() {
        return roomNumber;
    }
    
    public double getMonthlyRent() {
        return monthlyRent;
    }
    
    public int getHallID() {
        return hallID;
    }
    
    public String getCleanStatus() {
        return cleanStatus;
    }
    
    public String getOccupancy() {
        return occupancy;
    }
    
    /* -Class Setters- */
    
    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }
    
    public void setCleanStatus(String cleanStatus){
        this.cleanStatus = cleanStatus;
    }
    
    public void setOccupancy(String occupancy){
        this.occupancy = occupancy;
    }
}
