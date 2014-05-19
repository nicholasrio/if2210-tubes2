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
public class Character_CardTest {
    
    public Character_CardTest() {
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
     * Test of getType method, of class Character_Card.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Character_Card instance = new Character_Card(1);
        int expResult = 3;
        int result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getID method, of class Character_Card.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Character_Card instance = new Character_Card(2);
        int expResult = 2;
        int result = instance.getID();
        assertEquals(expResult, result);
    }
    
}
