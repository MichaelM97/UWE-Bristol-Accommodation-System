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
public class LeaseTest {
    
    public LeaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getLeaseNumber method, of class Lease.
     */
    @Test
    public void testGetLeaseNumber() {
        System.out.println("getLeaseNumber");
        Lease instance = null;
        int expResult = 0;
        int result = instance.getLeaseNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLeaseDuration method, of class Lease.
     */
    @Test
    public void testGetLeaseDuration() {
        System.out.println("getLeaseDuration");
        Lease instance = null;
        int expResult = 0;
        int result = instance.getLeaseDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHallID method, of class Lease.
     */
    @Test
    public void testGetHallID() {
        System.out.println("getHallID");
        Lease instance = null;
        int expResult = 0;
        int result = instance.getHallID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomNumber method, of class Lease.
     */
    @Test
    public void testGetRoomNumber() {
        System.out.println("getRoomNumber");
        Lease instance = null;
        int expResult = 0;
        int result = instance.getRoomNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentID method, of class Lease.
     */
    @Test
    public void testGetStudentID() {
        System.out.println("getStudentID");
        Lease instance = null;
        int expResult = 0;
        int result = instance.getStudentID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLeaseNumber method, of class Lease.
     */
    @Test
    public void testSetLeaseNumber() {
        System.out.println("setLeaseNumber");
        int leaseNumber = 0;
        Lease instance = null;
        instance.setLeaseNumber(leaseNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLeaseDuration method, of class Lease.
     */
    @Test
    public void testSetLeaseDuration() {
        System.out.println("setLeaseDuration");
        int leaseDuration = 0;
        Lease instance = null;
        instance.setLeaseDuration(leaseDuration);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStudentID method, of class Lease.
     */
    @Test
    public void testSetStudentID() {
        System.out.println("setStudentID");
        int studentID = 0;
        Lease instance = null;
        instance.setStudentID(studentID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
