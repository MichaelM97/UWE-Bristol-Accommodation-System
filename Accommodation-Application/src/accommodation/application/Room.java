/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation.application;

import java.util.List;

/**
 *
 * @author Michael McCormick (15012271)
 */
public class Room {
    
    //Declares class attributes
    private int roomNumber;
    private double monthlyRent;
    private Halls hallID;
    private byte cleanStatus;
    
    //Class Constructor
    public Room(int roomNumber, double monthlyRent, Halls hallID,
            byte cleanStatus) {
        this.roomNumber = roomNumber;
        this.monthlyRent = monthlyRent;
        this.hallID = hallID;
        this.cleanStatus = cleanStatus;
    }
}