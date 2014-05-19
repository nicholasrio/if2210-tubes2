package model.room;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for RoomFactory using JUnit
 * @author Riva Syafri Rachmatullah
 */
public class RoomFactoryTest {
    
    public RoomFactoryTest() {
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
     * Test of createRoom method, of class RoomFactory.
     */
    @Test
    public void testCreateRoom() {
        System.out.println("createRoom");
        assertTrue("model.room.Room".equals(RoomFactory.createRoom(RoomType.ROOM, "7602", 3).getClass().getTypeName()));
        assertTrue("model.room.Restroom".equals(RoomFactory.createRoom(RoomType.RESTROOM, "Toilet Labtek V lt.3", 3).getClass().getTypeName()));
    }
    
}
