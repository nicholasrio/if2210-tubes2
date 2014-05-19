package model.menu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for MenuType enumerator
 * @author Riva Syafri Rachmatullah
 */
public class MenuTypeTest {
    
    public MenuTypeTest() {
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
     * Test of values method, of class MenuType.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        MenuType[] expResult = { MenuType.FOOD, MenuType.BEVERAGE };
        MenuType[] result = MenuType.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class MenuType.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        MenuType expResult = MenuType.BEVERAGE;
        MenuType result = MenuType.valueOf("BEVERAGE");
        assertEquals(expResult, result);
    }
    
}
