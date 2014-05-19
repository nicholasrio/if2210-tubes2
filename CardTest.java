/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ramandika
 */
public class CardTest {
    
    public CardTest() {
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
     * Test of displayCard method, of class Card.
     */
    @Test
    public void testDisplayCard() {
        System.out.println("displayCard");
        Card instance = new CardImpl();
        instance.displayCard();
    }

    /**
     * Test of getType method, of class Card.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Card instance = new CardImpl();
        int expResult = 0;
        int result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getID method, of class Card.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Card instance = new CardImpl();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    public class CardImpl extends Card {

        public void displayCard() {
        }

        public int getType() {
            return 0;
        }

        public int getID() {
            return 0;
        }
    }
    
}
