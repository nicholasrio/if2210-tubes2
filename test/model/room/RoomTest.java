package model.room;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test class Room using JUnit
 * @author Riva Syafri Rachmatullah 
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
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setName method, of class Room.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "test1";
        Room instance = new Room("test", 0);
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getName method, of class Room.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Room instance = new Room("test", 0);
        String expResult = "test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocation method, of class Room.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        int floor = 1;
        Room instance = new Room("test", 0);
        instance.setLocation(floor);
        assertEquals(floor, instance.getLocation());
    }

    /**
     * Test of getLocation method, of class Room.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Room instance = new Room("test", 0);
        int expResult = 0;
        int result = instance.getLocation();
        assertEquals(expResult, result);
    }
}
