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
public class Path_CardTest {
    
    public Path_CardTest() {
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
     * Test of getType method, of class Path_Card.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Path_Card instance = new Path_Card('1', '0', '0', '0', '1', 9);
        int expResult = 1;
        int result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getID method, of class Path_Card.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Path_Card instance = new Path_Card('1', '0', '0', '0', '1', 9);
        int expResult = 9;
        int result = instance.getID();
        assertEquals(expResult, result);;
    }

    /**
     * Test of displayCard method, of class Path_Card.
     */
    @Test
    public void testDisplayCard() {
        System.out.println("displayCard");
        Path_Card instance = new Path_Card('1','1','1','1','1',1);
        instance.displayCard();
    }

    /**
     * Test of getRight method, of class Path_Card.
     */
    @Test
    public void testGetRight() {
        System.out.println("getRight");
        Path_Card instance =new Path_Card('1', '0', '0', '0', '1', 9);
        char expResult = '1';
        char result = instance.getRight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLeft method, of class Path_Card.
     */
    @Test
    public void testGetLeft() {
        System.out.println("getLeft");
        Path_Card instance = new Path_Card('1', '0', '0', '0', '1', 9);
        char expResult = '0';
        char result = instance.getLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTop method, of class Path_Card.
     */
    @Test
    public void testGetTop() {
        System.out.println("getTop");
        Path_Card instance = new Path_Card('1', '0', '0', '0', '1', 9);
        char expResult = '0';
        char result = instance.getTop();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBottom method, of class Path_Card.
     */
    @Test
    public void testGetBottom() {
        System.out.println("getBottom");
        Path_Card instance = new Path_Card('1', '1', '1', '0', '0', 15);
        char expResult = '1';
        char result = instance.getBottom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCenter method, of class Path_Card.
     */
    @Test
    public void testGetCenter() {
        System.out.println("getCenter");
        Path_Card instance = new Path_Card('1', '0', '0', '0', '1', 9);
        char expResult = '1';
        char result = instance.getCenter();
        assertEquals(expResult, result);
    }

    /**
     * Test of canBePlacedRightOf method, of class Path_Card.
     */
    @Test
    public void testCanBePlacedRightOf() {
        System.out.println("canBePlacedRightOf");
        Path_Card C = new Path_Card('0', '0', '1', '1', '0', 10);
        Path_Card instance = new Path_Card('1','1','1','1','1',1);
        boolean expResult = false;
        boolean result = instance.canBePlacedRightOf(C);
        assertEquals(expResult, result);
    }

    /**
     * Test of canBePlacedLeftOf method, of class Path_Card.
     */
    @Test
    public void testCanBePlacedLeftOf() {
        System.out.println("canBePlacedLeftOf");
        Path_Card C = new Path_Card('1','1','1','1','1',1);
        Path_Card instance = new Path_Card('1','1','1','1','0',16);
        boolean expResult = true;
        boolean result = instance.canBePlacedLeftOf(C);
        assertEquals(expResult, result);
    }

    /**
     * Test of canBePlacedAboveOf method, of class Path_Card.
     */
    @Test
    public void testCanBePlacedAboveOf() {
        System.out.println("canBePlacedAboveOf");
        Path_Card C = new Path_Card('1','1','1','1','1',1);
        Path_Card instance = new Path_Card('1','1','1','1','1',1);
        boolean expResult = true;
        boolean result = instance.canBePlacedAboveOf(C);
        assertEquals(expResult, result);
    }

    /**
     * Test of canBePlacedBelowOf method, of class Path_Card.
     */
    @Test
    public void testCanBePlacedBelowOf() {
        System.out.println("canBePlacedBelowOf");
        Path_Card C = new Path_Card('0', '0', '1', '1', '0', 14);
        Path_Card instance = new Path_Card('1', '1', '1', '1', '0', 16);
        boolean expResult = true;
        boolean result = instance.canBePlacedBelowOf(C);
        assertEquals(expResult, result);
    }

    /**
     * Test of CompareCard method, of class Path_Card.
     */
    @Test
    public void testCompareCard() {
        System.out.println("CompareCard");
        Path_Card C = new Path_Card('1', '0', '0', '0', '1', 9);
        Path_Card instance = new Path_Card('1', '0', '0', '0', '1', 9);
        boolean expResult = true;
        boolean result = instance.CompareCard(C);
        assertEquals(expResult, result);
    }

    /**
     * Test of rotateCard method, of class Path_Card.
     */
    @Test
    public void testRotateCard() {
        System.out.println("rotateCard");
        Path_Card instance = new Path_Card('1', '0', '0', '0', '1', 9);
        instance.rotateCard();
        assertEquals(instance.getLeft(),'1');
        assertEquals(instance.getRight(),'0');
        assertEquals(instance.getBottom(),'0');
        assertEquals(instance.getTop(),'0');
    }
    
}
