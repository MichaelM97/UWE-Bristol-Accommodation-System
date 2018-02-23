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
    private String hallAddress;
    private String phoneNumber;
    
    Halls(){
        
    }
    
    //Class Constructor
    public Halls(String hallName, int hallID, String address,
            String phoneNumber) {
        this.hallName = hallName;
        this.hallID = hallID;
        this.hallAddress = address;
        this.phoneNumber = phoneNumber;
    }
    
    /* -Class getters- */    
    public String getHallName() {
        return hallName;
    }
    
    public int getHallID() {
        return hallID;
    }
    
    public String getHallAddress() {
        return hallAddress;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
