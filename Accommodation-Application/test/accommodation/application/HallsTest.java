/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation.application;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael McCormick (15012271)
 */
public class HallsTest {
    
    public HallsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getHallName method, of class Halls.
     */
    @Test
    public void testGetHallName() {
        System.out.println("getHallName");
        Halls instance = null;
        String expResult = "";
        String result = instance.getHallName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHallID method, of class Halls.
     */
    @Test
    public void testGetHallID() {
        System.out.println("getHallID");
        Halls instance = null;
        int expResult = 0;
        int result = instance.getHallID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHallAddress method, of class Halls.
     */
    @Test
    public void testGetHallAddress() {
        System.out.println("getHallAddress");
        Halls instance = null;
        String expResult = "";
        String result = instance.getHallAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHallPostCode method, of class Halls.
     */
    @Test
    public void testGetHallPostCode() {
        System.out.println("getHallPostCode");
        Halls instance = null;
        String expResult = "";
        String result = instance.getHallPostCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhoneNumber method, of class Halls.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Halls instance = null;
        String expResult = "";
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
