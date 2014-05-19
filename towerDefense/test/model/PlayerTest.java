/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of setHighScore method, of class Player.
     */
    @Test
    public void testSetHighScore() {
        System.out.println("setHighScore");
        int newScore = 100;
        Player instance = new Player("Darwin",10);
        instance.setHighScore(newScore);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getHighScore(),newScore);
        
    }

    /**
     * Test of getHighScore method, of class Player.
     */
    @Test
    public void testGetHighScore() {
        System.out.println("getHighScore");
        Player instance = new Player("Darwin",10);
        int expResult = 10;
        int result = instance.getHighScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = new Player("Darwin",10);
        String expResult = "Darwin";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
}
