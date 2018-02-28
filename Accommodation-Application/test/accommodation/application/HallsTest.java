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
    public void testGetHallName() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getHallName");
        Halls instance = null;
        final Field field = instance.getClass().getDeclaredField("hallName");
        field.setAccessible(true);
        field.set(instance, "UWEH1");
        final String result = instance.getHallName();
        assertEquals("Field wasn't retrieved properly", result, "UWEH1");
    }

    /**
     * Test of getHallID method, of class Halls.
     */
    @Test
    public void testGetHallID() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getHallID");
        Halls instance = null;
        final Field field = instance.getClass().getDeclaredField("hallID");
        field.setAccessible(true);
        field.set(instance, 1);
        final int result = instance.getHallID();
        assertEquals("Field wasn't retrieved properly", result, 1);
    }

    /**
     * Test of getHallAddress method, of class Halls.
     */
    @Test
    public void testGetHallAddress() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getHallAddress");
        Halls instance = null;
        final Field field = instance.getClass().getDeclaredField("hallAddress");
        field.setAccessible(true);
        field.set(instance, "3 Coldharbour Lane");
        final String result = instance.getHallAddress();
        assertEquals("Field wasn't retrieved properly", result, "3 Coldharbour Lane");
    }

    /**
     * Test of getHallPostCode method, of class Halls.
     */
    @Test
    public void testGetHallPostCode() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getHallPostCode");
        Halls instance = null;
        final Field field = instance.getClass().getDeclaredField("hallPostCode");
        field.setAccessible(true);
        field.set(instance, "BS16 1QY");
        final String result = instance.getHallPostCode();
        assertEquals("Field wasn't retrieved properly", result, "BS16 1QY");
    }

    /**
     * Test of getPhoneNumber method, of class Halls.
     */
    @Test
    public void testGetPhoneNumber() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("getPhoneNumber");
        Halls instance = null;
        final Field field = instance.getClass().getDeclaredField("phoneNumber");
        field.setAccessible(true);
        field.set(instance, "9604161");
        final String result = instance.getPhoneNumber();
        assertEquals("Field wasn't retrieved properly", result, "9604161");
    }
    
}
