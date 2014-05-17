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
public class RecoverableTest {
    
    public RecoverableTest() {
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
     * Test of addCurrentHealth method, of class Recoverable.
     */
    @Test
    public void testAddCurrentHealth() {
        System.out.println("addCurrentHealth");
        int value = 0;
        Character hero; hero = new Hero();
        hero.setMaxHealth(10);
        hero.addCurrentHealth(10);
        
        assertSame(hero.getCurrentHealth(),10);
        
        hero.addCurrentHealth(-5);
        assertSame(hero.getCurrentHealth(),5);
        
        hero.addCurrentHealth(-5000);
        assertSame(hero.getCurrentHealth(),0);
        
        hero.addCurrentHealth(10000);
        assertSame(hero.getCurrentHealth(),10);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addCurrentMana method, of class Recoverable.
     */
    @Test
    public void testAddCurrentMana() {
        System.out.println("addCurrentMana");
        int value = 0;
        Character hero; hero = new Hero();
        hero.setMaxMana(10);
        hero.addCurrentMana(10);
        
        hero.addCurrentMana(-5);
        assertSame(hero.getCurrentMana(),5);
        
        hero.addCurrentMana(-5000);
        assertSame(hero.getCurrentMana(),0);
        
        hero.addCurrentMana(10000);
        assertSame(hero.getCurrentMana(),10);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class RecoverableImpl implements Recoverable {

        public void addCurrentHealth(int value) {
        }

        public void addCurrentMana(int value) {
        }
    }
}
