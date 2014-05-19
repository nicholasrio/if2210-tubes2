/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import java.awt.Graphics2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kevinyu
 */
public class StatusBarTest {
    
    public StatusBarTest() {
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
     * Test of getHP method, of class StatusBar.
     */
    @Test
    public void testSetandGetHP() {
        System.out.println("getHP");
        StatusBar instance = new StatusBar();
        instance.setHP(5);
        int result = instance.getHP();
        assertEquals(true, result==5);
    }
    
    /**
     * Test of getHP method, of class StatusBar.
     */
    @Test
    public void testSetandGetMana() {
        System.out.println("getHP");
        StatusBar instance = new StatusBar();
        instance.setHP(5);
        int result = instance.getHP();
        assertEquals(true, result == 5);
    }
}
