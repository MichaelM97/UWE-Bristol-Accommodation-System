/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation.application;

import java.lang.reflect.Field;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael McCormick (15012271)
 */
public class StudentTest {
    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getStudentName method, of class Student.
     */
    @Test
    public void testGetStudentName() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getStudentName");
        Student instance = null;
        final Field field = instance.getClass().getDeclaredField("studentName");
        field.setAccessible(true);
        field.set(instance, "John Smith");
        final String result = instance.getStudentName();
        assertEquals("Field wasn't retrieved properly", result, "John Smith");
    }

    /**
     * Test of getStudentID method, of class Student.
     */
    @Test
    public void testGetStudentID() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getStudentID");
        Student instance = null;
        final Field field = instance.getClass().getDeclaredField("studentID");
        field.setAccessible(true);
        field.set(instance, 1);
        final int result = instance.getStudentID();
        assertEquals("Field wasn't retrieved properly", result, 1);
    }
    
}
