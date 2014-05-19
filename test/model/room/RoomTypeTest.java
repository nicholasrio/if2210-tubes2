package model.room;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for RoomType enumerator
 * @author Riva Syafri Rachmatullah
 */
public class RoomTypeTest {
    
    public RoomTypeTest() {
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
     * Test of values method, of class RoomType.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        RoomType[] expResult = { RoomType.ROOM, RoomType.RESTROOM };
        RoomType[] result = RoomType.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class RoomType.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        RoomType expResult = RoomType.ROOM;
        RoomType result = RoomType.valueOf("ROOM");
        assertEquals(expResult, result);
    }
    
}
