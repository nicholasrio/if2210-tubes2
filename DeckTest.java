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
public class DeckTest {
    
    public DeckTest() {
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
     * Test of popCard method, of class Deck.
     */
    @Test
    public void testPopCard() {
        System.out.println("popCard");
        Deck instance = new Deck();
        instance.fillDeck();
        Card expResult = null;
        Card result = instance.popCard();
        assert(expResult!=result);
    }

    /**
     * Test of printDeck method, of class Deck.
     */
    @Test
    public void testPrintDeck() {
        System.out.println("printDeck");
        Deck instance = new Deck();
        instance.printDeck();
    }

    /**
     * Test of pushCard method, of class Deck.
     */
    @Test
    public void testPushCard() {
        System.out.println("pushCard");
        Card C = null;
        Deck instance = new Deck();
        instance.pushCard(C);
    }
    
}
