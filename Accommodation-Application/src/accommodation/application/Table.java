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
public class Table {

    //Declare class attributes
    private String hallName;
    private int roomNumber;
    private String occupancy;
    private String cleanStatus;
    private String leaseNumber;
    private String studentName;

    public Table(String hallName, int roomNumber, String occupancy,
            String cleanStatus, String leaseNumber, String studentName) {
        this.hallName = hallName;
        this.roomNumber = roomNumber;
        this.occupancy = occupancy;
        this.cleanStatus = cleanStatus;
        this.leaseNumber = leaseNumber;
        this.studentName = studentName;        
    }

    /* -Class getters- */ 
    public String getHallName() {
        return hallName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public String getCleanStatus() {
        return cleanStatus;
    }

    public String getLeaseNumber() {
        return leaseNumber;
    }

    public String getStudentName() {
        return studentName;
    }
    
    /* -Class Setters- */    
    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }
        
    public void setLeaseNumber(String leaseNumber) {
        this.leaseNumber = leaseNumber;
    }    
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public void setCleanStatus(String cleanStatus) {
        this.cleanStatus = cleanStatus;
    }
}
