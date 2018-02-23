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
public class Warden {
    
    //Declares class attributes
    private String wardenName;
    private int wardenID;
    
    //Class Constructor
    public Warden(String wardenName, int wardenID, String loginName,
            String loginPassword, byte permissionLevel) {
        this.wardenName = wardenName;
        this.wardenID = wardenID;
    }
    
    /* -Class getters- */    
    public String getWardenName() {
        return wardenName;
    }
    
    public int getWardenID() {
        return wardenID;
    }

}
