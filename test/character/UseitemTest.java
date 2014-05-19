/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yafithekid
 */
public class UseitemTest {
    
    /**
     * method use item test
     */
    public UseitemTest() {
    }
    
    /**
     * method set up class
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     * method tear down class
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * method set up
     */
    @Before
    public void setUp() {
    }
    
    /**
     * method tear down
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of addItem method, of class Useitem.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Item item = null;
        Useitem instance = new UseitemImpl();
        instance.addItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItem method, of class Useitem.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        int pos = 0;
        Useitem instance = new UseitemImpl();
        instance.removeItem(pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findItem method, of class Useitem.
     */
    @Test
    public void testFindItem() {
        System.out.println("findItem");
        Item item = null;
        Useitem instance = new UseitemImpl();
        int expResult = 0;
        int result = instance.findItem(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of haveItem method, of class Useitem.
     */
    @Test
    public void testHaveItem() {
        System.out.println("haveItem");
        Item item = null;
        Useitem instance = new UseitemImpl();
        boolean expResult = false;
        boolean result = instance.haveItem(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of haveMoney method, of class Useitem.
     */
    @Test
    public void testHaveMoney() {
        System.out.println("haveMoney");
        int money = 0;
        Useitem instance = new UseitemImpl();
        boolean expResult = false;
        boolean result = instance.haveMoney(money);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of applyEffect method, of class Useitem.
     */
    @Test
    public void testApplyEffect() {
        System.out.println("applyEffect");
        Item item = null;
        Useitem instance = new UseitemImpl();
        instance.applyEffect(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consume method, of class Useitem.
     */
    @Test
    public void testConsume() {
        System.out.println("consume");
        Item item = null;
        Useitem instance = new UseitemImpl();
        boolean expResult = false;
        boolean result = instance.consume(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Useitem.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Item item = null;
        Useitem instance = new UseitemImpl();
        boolean expResult = false;
        boolean result = instance.save(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buy method, of class Useitem.
     */
    @Test
    public void testBuy() {
        System.out.println("buy");
        Item item = null;
        Useitem instance = new UseitemImpl();
        boolean expResult = false;
        boolean result = instance.buy(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * class use item impl implements use item
     */
    public class UseitemImpl implements Useitem {

        public void addItem(Item item) {
        }

        public void removeItem(int pos) {
        }

        public int findItem(Item item) {
            return 0;
        }

        public boolean haveItem(Item item) {
            return false;
        }

        public boolean haveMoney(int money) {
            return false;
        }

        public void applyEffect(Item item) {
        }

        public boolean consume(Item item) {
            return false;
        }

        public boolean save(Item item) {
            return false;
        }

        public boolean buy(Item item) {
            return false;
        }
    }
}
