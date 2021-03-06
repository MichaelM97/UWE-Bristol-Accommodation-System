/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation.application;

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
    
    //Class Constructor
    public Room(int roomNumber, double monthlyRent, int hallID,
            String cleanStatus, String occupancy) {
        this.roomNumber = roomNumber;
        this.monthlyRent = monthlyRent;
        this.hallID = hallID;
        this.cleanStatus = cleanStatus;
        this.occupancy = occupancy;
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
    public void setCleanStatus(String cleanStatus){
        this.cleanStatus = cleanStatus;
    }
    
    public void setOccupancy(String occupancy){
        this.occupancy = occupancy;
    }
}
