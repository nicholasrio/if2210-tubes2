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
 * @author Chrestella Stephanie
 */
public class TowerTest {
    
    public TowerTest() {
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
     * Test of setCurrentLevel method, of class Tower.
     */
    @Test
    public void testSetCurrentLevel() {
        System.out.println("setCurrentLevel");
        int level = 5;
        Tower instance = new Tower(0,0);
        instance.setCurrentLevel(level);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getCurrentLevel(),level);
    }

    /**
     * Test of setPositionRow method, of class Tower.
     */
    @Test
    public void testSetPositionRow() {
        System.out.println("setPositionRow");
        int row = 0;
        Tower instance = new Tower(0,0);
        instance.setPositionRow(row);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getPositionRow(),row);
    }

    /**
     * Test of setPositionCol method, of class Tower.
     */
    @Test
    public void testSetPositionCol() {
        System.out.println("setPositionCol");
        int col = 9;
        Tower instance = new Tower(0,0);
        instance.setPositionCol(col);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getPositionCol(), col);
    }

    /**
     * Test of setUpgradeCost method, of class Tower.
     */
    @Test
    public void testSetUpgradeCost() {
        System.out.println("setUpgradeCost");
        int cost = 100;
        Tower instance = new Tower(0,0);
        instance.setUpgradeCost(cost);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getUpgradeCost(), cost);

    }

    /**
     * Test of setAttack method, of class Tower.
     */
    @Test
    public void testSetAttack() {
        System.out.println("setAttack");
        int att = 3;
        Tower instance = new Tower(0,0);
        instance.setAttack(att);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getAttack(), att);
    }

    /**
     * Test of setRange method, of class Tower.
     */
    @Test
    public void testSetRange() {
        System.out.println("setRange");
        int r = 5;
        Tower instance = new Tower(0,0);
        instance.setRange(r);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getRange(), r);
    }

    /**
     * Test of setCoolDown method, of class Tower.
     */
    @Test
    public void testSetCoolDown() {
        System.out.println("setCoolDown");        
        Tower instance = new Tower(0,0);
        instance.setCoolDown(10);
        instance.resetCoolingDownTime();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getCoolDownCount(), 10);
    }

    /**
     * Test of resetCoolingDownTime method, of class Tower.
     */
    @Test
    public void testResetCoolingDownTime() {
        System.out.println("resetCoolingDownTime");
        Tower instance = new Tower(0,0);
        instance.setCoolDown(12);
        instance.resetCoolingDownTime();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getCoolDownCount(),instance.getCoolDown());
    }

    /**
     * Test of coolingDown method, of class Tower.
     */
    @Test
    public void testCoolingDown() {
        System.out.println("coolingDown");
        Tower instance = new Tower(0,0);
        instance.setCoolDown(10);
        instance.resetCoolingDownTime();
        instance.coolingDown();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getCoolDownCount(),9);
    }

    /**
     * Test of getCurrentLevel method, of class Tower.
     */
    @Test
    public void testGetCurrentLevel() {
        System.out.println("getCurrentLevel");
        Tower instance = new Tower(0,0);
        int expResult = 0;
        instance.setCurrentLevel(10);
        int result = instance.getCurrentLevel();
        assertEquals(instance.getCurrentLevel(), 10);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPositionRow method, of class Tower.
     */
    @Test
    public void testGetPositionRow() {
        System.out.println("getPositionRow");
        Tower instance = new Tower(0,0);
        int expResult = 0;
        int result = instance.getPositionRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPositionCol method, of class Tower.
     */
    @Test
    public void testGetPositionCol() {
        System.out.println("getPositionCol");
        Tower instance = new Tower(0,0);
        int expResult = 0;
        int result = instance.getPositionCol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getUpgradeCost method, of class Tower.
     */
    @Test
    public void testGetUpgradeCost() {
        System.out.println("getUpgradeCost");
        Tower instance = new Tower(0,0);
        instance.setUpgradeCost(2);
        int expResult = 0;
        int result = instance.getUpgradeCost();
        assertEquals(instance.getUpgradeCost(), 2);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAttack method, of class Tower.
     */
    @Test
    public void testGetAttack() {
        System.out.println("getAttack");
        Tower instance = new Tower(0,0);
        instance.setAttack(3);
        int expResult = 0;
        int result = instance.getAttack();
        assertEquals(instance.getAttack(), 3);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getRange method, of class Tower.
     */
    @Test
    public void testGetRange() {
        System.out.println("getRange");
        Tower instance = new Tower(0,0);
        instance.setRange(10);
        int expResult = 0;
        int result = instance.getRange();
        assertEquals(instance.getRange(), 10);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCoolDownCount method, of class Tower.
     */
    @Test
    public void testGetCoolDownCount() {
        System.out.println("getCoolDownCount");
        Tower instance = new Tower(0,0);
        instance.setCoolDown(10);
        instance.resetCoolingDownTime();
        int expResult = 10;
        int result = instance.getCoolDownCount();
        assertEquals(instance.getCoolDownCount(), result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of rangeCheck method, of class Tower.
     */
    @Test
    public void testRangeCheck() {
        System.out.println("rangeCheck");
        int enemy_row = 0;
        int enemy_col = 0;
        int row = 0;
        int col = 0;
        Tower instance = new Tower(0,0);
        boolean expResult = false;
        boolean result = instance.rangeCheck(enemy_row, enemy_col, row, col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of upgradeTower method, of class Tower.
     */
    @Test
    public void testUpgradeTower() {
        System.out.println("upgradeTower");
        Tower instance = new Tower(0,0);
        instance.setUpgradeCost(100);
        instance.setCurrentLevel(10);
        instance.upgradeTower();
        
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getUpgradeCost(),110);
        assertEquals(instance.getCurrentLevel(),11);
    }

    /**
     * Test of sellTower method, of class Tower.
     */
    @Test
    public void testSellTower() {
        System.out.println("sellTower");
        Tower instance = new Tower(0,0);
        instance.setUpgradeCost(100);
        int expResult = 0;
        int result = instance.sellTower();
        assertEquals(instance.sellTower(), 90);
        // TODO review the generated test code and remove the default call to fail.        
    }    
}
