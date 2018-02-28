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
    public void testGetRoomNumber() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getRoomNumber");
        Room instance = null;
        final Field field = instance.getClass().getDeclaredField("roomNumber");
        field.setAccessible(true);
        field.set(instance, 1);
        final int result = instance.getRoomNumber();
        assertEquals("Field wasn't retrieved properly", result, 1);
    }

    /**
     * Test of getMonthlyRent method, of class Room.
     */
    @Test
    public void testGetMonthlyRent() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getMonthlyRent");
        Room instance = null;
        final Field field = instance.getClass().getDeclaredField("monthlyRent");
        field.setAccessible(true);
        field.set(instance, 1.1);
        final double result = instance.getMonthlyRent();
        assertEquals("Field wasn't retrieved properly", result, 1.1);
    }

    /**
     * Test of getHallID method, of class Room.
     */
    @Test
    public void testGetHallID() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getHallID");
        Room instance = null;
        final Field field = instance.getClass().getDeclaredField("hallID");
        field.setAccessible(true);
        field.set(instance, 1);
        final int result = instance.getHallID();
        assertEquals("Field wasn't retrieved properly", result, 1);
    }

    /**
     * Test of getCleanStatus method, of class Room.
     */
    @Test
    public void testGetCleanStatus() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getCleanStatus");
        Room instance = null;
        final Field field = instance.getClass().getDeclaredField("cleanStatus");
        field.setAccessible(true);
        field.set(instance, "Clean");
        final String result = instance.getCleanStatus();
        assertEquals("Field wasn't retrieved properly", result, "Clean");
    }

    /**
     * Test of getOccupancy method, of class Room.
     */
    @Test
    public void testGetOccupancy() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getOccupancy");
        Room instance = null;
        final Field field = instance.getClass().getDeclaredField("occupancy");
        field.setAccessible(true);
        field.set(instance, "Occupied");
        final String result = instance.getOccupancy();
        assertEquals("Field wasn't retrieved properly", result, "Occupied");
    }

    /**
     * Test of setCleanStatus method, of class Room.
     */
    @Test
    public void testSetCleanStatus() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("setCleanStatus");
        String cleanStatus = "Clean";
        Room instance = null;
        instance.setCleanStatus(cleanStatus);
        final Field field = instance.getClass().getDeclaredField("cleanStatus");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), "Clean");
    }

    /**
     * Test of setOccupancy method, of class Room.
     */
    @Test
    public void testSetOccupancy() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("setOccupancy");
        String occupancy = "Occupied";
        Room instance = null;
        instance.setOccupancy(occupancy);
        final Field field = instance.getClass().getDeclaredField("occupancy");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), "Occupied");
    }
    
}
