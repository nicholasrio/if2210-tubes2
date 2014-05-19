package model.node;

import model.Point;
import model.menu.Menu;
import model.menu.MenuFactory;
import model.menu.MenuType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test class Canteen using JUnit
 * @author Riva Syafri Rachmatullah
 */
public class CanteenTest {
    private final Menu m1;
    private final Menu m2;
    
    public CanteenTest() {
        m1 = MenuFactory.createMenu(MenuType.FOOD, "Nasi Ayam Goreng Penyet", 14000);
        m2 = MenuFactory.createMenu(MenuType.BEVERAGE, "Jus Alpukat", 6000);
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
     * Test of setName method, of class Canteen.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Kantin Bengkok";
        Canteen instance = new Canteen(new Point(), 1);
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getName method, of class Canteen.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Canteen instance = new Canteen(0, 0);
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
        instance.setName("Kantin Barat Laut");
        expResult = "Kantin Barat Laut";
        result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of addMenu method, of class Canteen.
     */
    @Test
    public void testAddMenu() {
        System.out.println("addMenu");
        Canteen instance = new Canteen(new Point());
        instance.addMenu(m1);
        assertEquals(instance.getMenu(0), m1);
    }

    /**
     * Test of removeMenu method, of class Canteen.
     */
    @Test
    public void testRemoveMenu() {
        System.out.println("removeMenu");
        Canteen instance = new Canteen(new Point());
        instance.addMenu(m1);
        instance.addMenu(m2);
        instance.removeMenu(m1);
        assertTrue(!instance.getListOfMenus().contains(m1));
    }

    /**
     * Test of numberOfMenus method, of class Canteen.
     */
    @Test
    public void testNumberOfMenus() {
        System.out.println("numberOfMenus");
        Canteen instance = new Canteen(0, 0);
        int expResult = 2;
        instance.addMenu(m1);
        instance.addMenu(m2);
        int result = instance.numberOfMenus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfMenus method, of class Canteen.
     */
    @Test
    public void testGetListOfMenus() {
        System.out.println("getListOfMenus");
        Canteen instance = new Canteen(0, 0);
        instance.addMenu(m1);
        assertTrue(instance.getListOfMenus()!= null);
        assertTrue(instance.getListOfMenus().contains(m1));
    }

    /**
     * Test of getMenu method, of class Canteen.
     */
    @Test
    public void testGetMenu() {
        System.out.println("getMenu");
        int index = 0;
        Canteen instance = new Canteen(1, 0);
        instance.addMenu(m1);
        Menu result = instance.getMenu(index);
        assertEquals(m1, result);
    }

    /**
     * Test of setMenu method, of class Canteen.
     */
    @Test
    public void testSetMenu() {
        System.out.println("setMenu");
        int index = 0;
        Canteen instance = new Canteen(0, 0);
        instance.addMenu(m1);
        instance.setMenu(index, m2);
        Menu result = instance.getMenu(index);
        assertEquals(result, m2);
    }
    
}
