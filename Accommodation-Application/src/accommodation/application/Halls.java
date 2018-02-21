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
public class Halls {
    
    //Declares class attributes
    private String hallName;
    private int hallID;
    private String address;
    private String phoneNumber;
    private List<Room> rooms;
    
    //Class Constructor
    public Halls(String hallName, int hallID, String address, 
            String phoneNumber, List<Room> rooms) {
        this.hallName = hallName;
        this.hallID = hallID;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rooms = rooms;
    }
}
