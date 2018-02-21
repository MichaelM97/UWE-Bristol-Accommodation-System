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
    private Halls hallID;
    private Room roomNumber;
    private Student studentID;
    
    //Class Constructor
    public Lease(int leaseNumber, int leaseDuration, Halls hallID,
            Room roomNumber, Student studentID) {
        this.leaseNumber = leaseNumber;
        this.leaseDuration = leaseDuration;
        this.hallID = hallID;
        this.roomNumber = roomNumber;
        this.studentID = studentID;
    }
}
