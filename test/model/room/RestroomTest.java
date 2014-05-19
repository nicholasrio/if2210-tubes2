package model.room;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rivarave777
 */
public class RestroomTest {
    
    public RestroomTest() {
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

    @Test
    public void testSomeMethod() {
        Restroom instance = new Restroom("Toilet Labtek V lt. 4", 4);
        assertEquals(instance.getName(), "Toilet Labtek V lt. 4");
    }
    
}
