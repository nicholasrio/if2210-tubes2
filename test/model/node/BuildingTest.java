package model.node;

import model.room.Room;
import model.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test class Building using JUnit
 * @author Riva Syafri Rachmatullah 
 */
public class BuildingTest {
    private final Room r;
    
    public BuildingTest() {
        r = new Room("test", 0);
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
     * Test of setName method, of class Building.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Labtek V";
        Building instance = new Building(new Point(), 1);
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getName method, of class Building.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Building instance = new Building(0, 0);
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
        instance.setName("labtek V");
        expResult = "labtek V";
        result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of addRoom method, of class Building.
     */
    @Test
    public void testAddRoom() {
        System.out.println("addRoom");
        Building instance = new Building(new Point());
        instance.addRoom(r);
        assertTrue(instance.getListOfRooms().contains(r));
    }

    /**
     * Test of removeRoom method, of class Building.
     */
    @Test
    public void testRemoveRoom() {
        System.out.println("removeRoom");
        Building instance = new Building(new Point());
        instance.addRoom(r);
        instance.removeRoom(r);
        assertTrue(!instance.getListOfRooms().contains(r));
    }

    /**
     * Test of numberOfRooms method, of class Building.
     */
    @Test
    public void testNumberOfRooms() {
        System.out.println("numberOfRooms");
        Building instance = new Building(0, 0);
        int expResult = 1;
        instance.addRoom(r);
        int result = instance.numberOfRooms();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfRooms method, of class Building.
     */
    @Test
    public void testGetListOfRooms() {
        System.out.println("getListOfRooms");
        Building instance = new Building(0, 0);
        instance.addRoom(r);
        assertTrue(instance.getListOfRooms() != null);
        assertTrue(instance.getListOfRooms().contains(r));
    }

    /**
     * Test of getRoom method, of class Building.
     */
    @Test
    public void testGetRoom() {
        System.out.println("getRoom");
        int index = 0;
        Building instance = new Building(1, 0);
        instance.addRoom(r);
        Room result = instance.getRoom(index);
        assertEquals(r, result);
    }

    /**
     * Test of setRoom method, of class Building.
     */
    @Test
    public void testSetRoom() {
        System.out.println("setRoom");
        int index = 0;
        Building instance = new Building(0, 0);
        instance.addRoom(r);
        Room r1;
        instance.setRoom(index, r1 = new Room("test", 1));
        Room result = instance.getRoom(index);
        assertEquals(r1, result);
    }
}
