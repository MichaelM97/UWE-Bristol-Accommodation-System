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
public class HallManager {
    
    //Declares class attributes
    private String managerName;
    private int managerID;
    private String loginName;
    private String loginPassword;
    private byte permissionLevel;
    
    //Class Constructor
    public HallManager(String managerName, int managerID, String loginName, 
            String loginPassword, byte permissionLevel) {
        this.managerName = managerName;
        this.managerID = managerID;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.permissionLevel = permissionLevel;
    }
    
}
