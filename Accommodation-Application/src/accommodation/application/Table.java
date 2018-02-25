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
    private int leaseNumber;
    private String studentName;
        
    public Table(String hallName, int roomNumber, String occupancy, 
            String cleanStatus, int leaseNumber, String studentName) {
        this.hallName = hallName;
        this.roomNumber = roomNumber;
        this.occupancy = occupancy;
        this.cleanStatus = cleanStatus;
        this.leaseNumber = leaseNumber;
        this.studentName = studentName;
    }
    
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
    
    public int getLeaseNumber() {
        return leaseNumber;
    }
    
    public String getStudentName() {
        return studentName;
    }    
}
