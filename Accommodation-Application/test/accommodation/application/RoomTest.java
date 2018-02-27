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
public class RoomTest {
    
    public RoomTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getRoomNumber method, of class Room.
     */
    @Test
    public void testGetRoomNumber() {
        System.out.println("getRoomNumber");
        Room instance = null;
        int expResult = 0;
        int result = instance.getRoomNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonthlyRent method, of class Room.
     */
    @Test
    public void testGetMonthlyRent() {
        System.out.println("getMonthlyRent");
        Room instance = null;
        double expResult = 0.0;
        double result = instance.getMonthlyRent();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHallID method, of class Room.
     */
    @Test
    public void testGetHallID() {
        System.out.println("getHallID");
        Room instance = null;
        int expResult = 0;
        int result = instance.getHallID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCleanStatus method, of class Room.
     */
    @Test
    public void testGetCleanStatus() {
        System.out.println("getCleanStatus");
        Room instance = null;
        String expResult = "";
        String result = instance.getCleanStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOccupancy method, of class Room.
     */
    @Test
    public void testGetOccupancy() {
        System.out.println("getOccupancy");
        Room instance = null;
        String expResult = "";
        String result = instance.getOccupancy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCleanStatus method, of class Room.
     */
    @Test
    public void testSetCleanStatus() {
        System.out.println("setCleanStatus");
        String cleanStatus = "";
        Room instance = null;
        instance.setCleanStatus(cleanStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOccupancy method, of class Room.
     */
    @Test
    public void testSetOccupancy() {
        System.out.println("setOccupancy");
        String occupancy = "";
        Room instance = null;
        instance.setOccupancy(occupancy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
