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
public class MonsterTest {
    
    public MonsterTest() {
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
     * Test of decreaseHitPoints method, of class Monster.
     */
    @Test
    public void testDecreaseHitPoints() {
        System.out.println("decreaseHitPoints");
        int damage = 1;
        Monster instance = new Monster(0,0,1);
        instance.decreaseHitPoints(damage);
        assertEquals(damage-1, instance.getHP());
    }

    /**
     * Test of changePos method, of class Monster.
     */
    @Test
    public void testChangePos() {
        System.out.println("changePos");
        int _row = 0;
        int _col = 0;
        Monster instance = new Monster(1,1,0);
        instance.changePos(_row, _col);
        assertEquals(instance.getCol(), _col);
                
    }

    /**
     * Test of setHP method, of class Monster.
     */
    @Test
    public void testSetHP() {
        System.out.println("setHP");
        int HP = 0;
        Monster instance = new Monster(0,0,100);
        instance.setHP(HP);
        assertEquals(instance.getHP(), HP);
    }

    /**
     * Test of getRow method, of class Monster.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Monster instance = new Monster(0,0,1);
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getCol method, of class Monster.
     */
    @Test
    public void testGetCol() {
        System.out.println("getCol");
        Monster instance = new Monster(0,0,1);
        int expResult = 0;
        int result = instance.getCol();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getHP method, of class Monster.
     */
    @Test
    public void testGetHP() {
        System.out.println("getHP");
        Monster instance = new Monster(2,2,2);
        int expResult = 2;
        int result = instance.getHP();
        assertEquals(expResult, result);
        
    }
    
}
