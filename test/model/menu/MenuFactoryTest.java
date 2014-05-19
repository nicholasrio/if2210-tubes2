package model.menu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for MenuFactory using JUnit
 * @author Riva Syafri Rachmatullah
 */
public class MenuFactoryTest {
    
    public MenuFactoryTest() {
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
     * Test of createMenu method, of class MenuFactory.
     */
    @Test
    public void testCreateMenu() {
        System.out.println("createMenu");
        assertTrue("model.menu.Food".equals(MenuFactory.createMenu(MenuType.FOOD, "Nasi Ayam Goreng", 14000).getClass().getTypeName()));
        assertTrue("model.menu.Beverage".equals(MenuFactory.createMenu(MenuType.BEVERAGE, "Jus Alpukat", 6000).getClass().getTypeName()));
    }
    
}
