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
    private String loginName;
    private String loginPassword;
    private byte permissionLevel;
    
    //Class Constructor
    public Warden(String wardenName, int wardenID, String loginName,
            String loginPassword, byte permissionLevel) {
        this.wardenName = wardenName;
        this.wardenID = wardenID;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.permissionLevel = permissionLevel;
    }
    
    /* -Class getters- */    
    public String getWardenName() {
        return wardenName;
    }
    
    public int getWardenID() {
        return wardenID;
    }
    
    public String getLoginName() {
        return loginName;
    }
    
    public String getLoginPassword() {
        return loginPassword;
    }
    
    public byte getPermissionLevel() {
        return permissionLevel;
    }
    
    /* -Class Setters- */
    
    //Incase Warden wants to change password in the future
    public void setLoginPassword(String newPassword) {
        this.loginPassword = newPassword;
    }
}
