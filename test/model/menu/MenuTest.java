package model.menu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test class Menu using JUnit
 * @author Riva Syafri Rachmatullah 
 */
public class MenuTest {
    private final String name = "Nasi Ayam Goreng Dada Penyet";
    
    public MenuTest() {
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
     * Test of setName method, of class Menu.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        Menu instance = MenuFactory.createMenu(MenuType.FOOD, name, 14000);
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getName method, of class Menu.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Menu instance = MenuFactory.createMenu(MenuType.FOOD, name, 14000);
        String expResult = "Nasi Ayam Goreng Dada Penyet";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class Menu.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        int price = 0;
        Menu instance = MenuFactory.createMenu(MenuType.FOOD, name, 14000);
        instance.setPrice(price);
        assertTrue(instance.getPrice() != 14000);
        assertTrue(instance.getPrice() == price);
    }

    /**
     * Test of getPrice method, of class Menu.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Menu instance = MenuFactory.createMenu(MenuType.FOOD, name, 14000);
        int expResult = 14000;
        int result = instance.getPrice();
        assertEquals(expResult, result);
    }
}
