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
    public void testGetLeaseNumber() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getLeaseNumber");
        Lease instance = null;        
        final Field field = instance.getClass().getDeclaredField("leaseNumber");
        field.setAccessible(true);
        field.set(instance, 1);
        final int result = instance.getLeaseNumber();
        assertEquals("Field wasn't retrieved properly", result, 1);
    }

    /**
     * Test of getLeaseDuration method, of class Lease.
     */
    @Test
    public void testGetLeaseDuration() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getLeaseDuration");
        Lease instance = null;
        final Field field = instance.getClass().getDeclaredField("leaseDuration");
        field.setAccessible(true);
        field.set(instance, 1);
        final int result = instance.getLeaseDuration();
        assertEquals("Field wasn't retrieved properly", result, 1);
    }

    /**
     * Test of getHallID method, of class Lease.
     */
    @Test
    public void testGetHallID() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getHallID");
        Lease instance = null;
        final Field field = instance.getClass().getDeclaredField("hallID");
        field.setAccessible(true);
        field.set(instance, 1);
        final int result = instance.getHallID();
        assertEquals("Field wasn't retrieved properly", result, 1);
    }

    /**
     * Test of getRoomNumber method, of class Lease.
     */
    @Test
    public void testGetRoomNumber() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getRoomNumber");
        Lease instance = null;
        final Field field = instance.getClass().getDeclaredField("roomNumber");
        field.setAccessible(true);
        field.set(instance, 1);
        final int result = instance.getRoomNumber();
        assertEquals("Field wasn't retrieved properly", result, 1);
    }

    /**
     * Test of getStudentID method, of class Lease.
     */
    @Test
    public void testGetStudentID() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getStudentID");
        Lease instance = null;
        final Field field = instance.getClass().getDeclaredField("studentID");
        field.setAccessible(true);
        field.set(instance, 1);
        final int result = instance.getStudentID();
        assertEquals("Field wasn't retrieved properly", result, 1);
    }

    /**
     * Test of setLeaseNumber method, of class Lease.
     */
    @Test
    public void testSetLeaseNumber() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("setLeaseNumber");
        int leaseNumber = 1;
        Lease instance = null;
        instance.setLeaseNumber(leaseNumber);
        final Field field = instance.getClass().getDeclaredField("leaseNumber");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), 0);
    }

    /**
     * Test of setLeaseDuration method, of class Lease.
     */
    @Test
    public void testSetLeaseDuration() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("setLeaseDuration");
        int leaseDuration = 1;
        Lease instance = null;
        instance.setLeaseDuration(leaseDuration);
        final Field field = instance.getClass().getDeclaredField("leaseDuration");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), 0);
    }

    /**
     * Test of setStudentID method, of class Lease.
     */
    @Test
    public void testSetStudentID() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("setStudentID");
        int studentID = 1;
        Lease instance = null;
        instance.setStudentID(studentID);
        final Field field = instance.getClass().getDeclaredField("studentID");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), 0);
    }
    
}
