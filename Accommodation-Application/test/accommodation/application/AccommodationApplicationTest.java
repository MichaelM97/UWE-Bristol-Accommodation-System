/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation.application;

import javafx.stage.Stage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael McCormick (15012271)
 */
public class AccommodationApplicationTest {
    
    public AccommodationApplicationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class AccommodationApplication.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AccommodationApplication.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("Main method in AccomodationApplication class call failed!");
    }

    /**
     * Test of start method, of class AccommodationApplication.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Stage primaryStage = null;
        AccommodationApplication instance = new AccommodationApplication();
        instance.start(primaryStage);
        // TODO review the generated test code and remove the default call to fail.
        fail("Start method in AccomodationApplication class call failed!");
    }

    /**
     * Test of getFileData method, of class AccommodationApplication.
     */
    @Test
    public void testGetFileData() throws Exception {
        System.out.println("getFileData");
        AccommodationApplication instance = new AccommodationApplication();
        instance.getFileData();
        // TODO review the generated test code and remove the default call to fail.
        fail("GetFileData method in AccomodationApplication class call failed!");
    }

    /**
     * Test of saveFileData method, of class AccommodationApplication.
     */
    @Test
    public void testSaveFileData() throws Exception {
        System.out.println("saveFileData");
        AccommodationApplication instance = new AccommodationApplication();
        instance.saveFileData();
        // TODO review the generated test code and remove the default call to fail.
        fail("SaveFileData method in AccomodationApplication class call failed!");
    }

    /**
     * Test of getTableData method, of class AccommodationApplication.
     */
    @Test
    public void testGetTableData() {
        System.out.println("getTableData");
        AccommodationApplication instance = new AccommodationApplication();
        instance.getTableData();
        // TODO review the generated test code and remove the default call to fail.
        fail("GetTableData method in AccomodationApplication class call failed!");
    }
    
}
