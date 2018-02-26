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
public class Student {
    
    //Declares class attributes
    private String studentName;
    private int studentID;
    
    //Class Constructor
    public Student(String studentName, int studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
    }
    
    /* -Class getters- */    
    public String getStudentName() {
        return studentName;
    }
    
    public int getStudentID() {
        return studentID;
    }   
    
    /* -Class Setters- */ 
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
