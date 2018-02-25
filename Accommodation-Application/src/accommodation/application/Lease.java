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
public class Lease {
    
    //Declares class attributes
    private int leaseNumber;
    private int leaseDuration;
    private int hallID;
    private int roomNumber;
    private int studentID;
    
    //Class Constructor
    public Lease(int leaseNumber, int leaseDuration, int hallID,
            int roomNumber, int studentID) {
        this.leaseNumber = leaseNumber;
        this.leaseDuration = leaseDuration;
        this.hallID = hallID;
        this.roomNumber = roomNumber;
        this.studentID = studentID;
    }
    
    /* -Class getters- */    
    public int getLeaseNumber() {
        return leaseNumber;
    }
    
    public int getLeaseDuration() {
        return leaseDuration;
    }
    
    public int getHallID() {
        return hallID;
    }
    
    public int getRoomNumber() {
        return roomNumber;
    }
    
    public int getStudentID() {
        return studentID;
    }
    
    /* -Class Setters- */    
    public void setLeaseDuration(int leaseDuration) {
        this.leaseDuration = leaseDuration;
    }
    
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
}
