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
public class TableTest {
    
    public TableTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getHallName method, of class Table.
     */
    @Test
    public void testGetHallName() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getHallName");
        Table instance = null;
        final Field field = instance.getClass().getDeclaredField("hallName");
        field.setAccessible(true);
        field.set(instance, "UWEH1");
        final String result = instance.getHallName();
        assertEquals("Field wasn't retrieved properly", result, "UWEH1");
    }

    /**
     * Test of getRoomNumber method, of class Table.
     */
    @Test
    public void testGetRoomNumber() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getRoomNumber");
        Table instance = null;
        final Field field = instance.getClass().getDeclaredField("roomNumber");
        field.setAccessible(true);
        field.set(instance, 1);
        final int result = instance.getRoomNumber();
        assertEquals("Field wasn't retrieved properly", result, 1);
    }

    /**
     * Test of getOccupancy method, of class Table.
     */
    @Test
    public void testGetOccupancy() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getOccupancy");
        Table instance = null;
        final Field field = instance.getClass().getDeclaredField("occupancy");
        field.setAccessible(true);
        field.set(instance, "Occupied");
        final String result = instance.getOccupancy();
        assertEquals("Field wasn't retrieved properly", result, "Occupied");
    }

    /**
     * Test of getCleanStatus method, of class Table.
     */
    @Test
    public void testGetCleanStatus() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getCleanStatus");
        Table instance = null;
        final Field field = instance.getClass().getDeclaredField("cleanStatus");
        field.setAccessible(true);
        field.set(instance, "Clean");
        final String result = instance.getCleanStatus();
        assertEquals("Field wasn't retrieved properly", result, "Clean");
    }

    /**
     * Test of getLeaseNumber method, of class Table.
     */
    @Test
    public void testGetLeaseNumber() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getLeaseNumber");
        Table instance = null;
        final Field field = instance.getClass().getDeclaredField("leaseNumber");
        field.setAccessible(true);
        field.set(instance, "1001");
        final String result = instance.getLeaseNumber();
        assertEquals("Field wasn't retrieved properly", result, "1001");
    }

    /**
     * Test of getLeaseDuration method, of class Table.
     */
    @Test
    public void testGetLeaseDuration() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getLeaseDuration");
        Table instance = null;
        final Field field = instance.getClass().getDeclaredField("leaseDuration");
        field.setAccessible(true);
        field.set(instance, "9 Months");
        final String result = instance.getLeaseDuration();
        assertEquals("Field wasn't retrieved properly", result, "9 Months");
    }

    /**
     * Test of getStudentName method, of class Table.
     */
    @Test
    public void testGetStudentName() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getStudentName");
        Table instance = null;
        final Field field = instance.getClass().getDeclaredField("studentName");
        field.setAccessible(true);
        field.set(instance, "John Smith");
        final String result = instance.getHallName();
        assertEquals("Field wasn't retrieved properly", result, "John Smith");
    }

    /**
     * Test of setOccupancy method, of class Table.
     */
    @Test
    public void testSetOccupancy() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("setOccupancy");
        String occupancy = "Occupied";
        Table instance = null;
        instance.setOccupancy(occupancy);
        final Field field = instance.getClass().getDeclaredField("occupancy");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), "Occupied");
    }

    /**
     * Test of setLeaseNumber method, of class Table.
     */
    @Test
    public void testSetLeaseNumber() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("setLeaseNumber");
        String leaseNumber = "1001";
        Table instance = null;
        instance.setLeaseNumber(leaseNumber);
        final Field field = instance.getClass().getDeclaredField("leaseNumber");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), "1001");
    }

    /**
     * Test of setLeaseDuration method, of class Table.
     */
    @Test
    public void testSetLeaseDuration() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("setLeaseDuration");
        String leaseDuration = "9";
        Table instance = null;
        instance.setLeaseDuration(leaseDuration);
        final Field field = instance.getClass().getDeclaredField("leaseDuration");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), "9 Months");
    }

    /**
     * Test of setStudentName method, of class Table.
     */
    @Test
    public void testSetStudentName() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("setStudentName");
        String studentName = "John Smith";
        Table instance = null;
        instance.setStudentName(studentName);
        final Field field = instance.getClass().getDeclaredField("studentName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), "John Smith");
    }

    /**
     * Test of setCleanStatus method, of class Table.
     */
    @Test
    public void testSetCleanStatus() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("setCleanStatus");
        String cleanStatus = "Clean";
        Table instance = null;
        instance.setCleanStatus(cleanStatus);
        final Field field = instance.getClass().getDeclaredField("cleanStatus");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), "Clean");
    }
    
}
