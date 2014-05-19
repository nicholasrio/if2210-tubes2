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
public class Action_CardTest {
    
    public Action_CardTest() {
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
     * Test of getType method, of class Action_Card.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Action_Card instance = null;
        instance=new Action_Card();
        int expResult = 2;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getID method, of class Action_Card.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Action_Card instance = null;
        int expResult = 0;
        instance=new Action_Card();
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of displayCard method, of class Action_Card.
     */
    @Test
    public void testDisplayCard() {
        System.out.println("displayCard");
        Action_Card instance = new Action_Card();
        instance.displayCard();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
