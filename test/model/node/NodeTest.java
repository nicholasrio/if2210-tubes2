package model.node;

import model.Point;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test class Node using JUnit
 * @author Riva Syafri Rachmatullah 
 */
public class NodeTest {
    
    public NodeTest() {
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
     * Test of getID method, of class Node.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Node instance = new Node(0, 0);
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        instance = new Node(new Point(), 1);
        expResult = 1;
        result = instance.getID();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setID method, of class Node.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int ID = 1;
        Node instance = new Node(1, 0);
        instance.setID(ID);
        assertTrue(instance.getID() == ID);
    }
    
    /**
     * Test of setLocation method, of class Node.
     */
    @Test
    public void testSetLocation_Point() {
        System.out.println("setLocation");
        Point p = new Point(-1, 1);
        Node instance = new Node(0, 0);
        instance.setLocation(p);
        assertTrue(instance.getLocation().equals(p));
    }

    /**
     * Test of setLocation method, of class Node.
     */
    @Test
    public void testSetLocation_double_double() {
        System.out.println("setLocation");
        double x = -1.0;
        double y = 1.0;
        Node instance = new Node(0, 0);
        instance.setLocation(x, y);
        assertTrue(instance.getLocation().equals(x, y));
    }

    /**
     * Test of getLocation method, of class Node.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Node instance = new Node(3, 4);
        Point expResult = new Point(3, 4);
        Point result = instance.getLocation();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of getListOfNeighbours method, of class Node.
     */
    @Test
    public void testGetListOfNeighbours() {
        System.out.println("getListOfNeighbours");
        Node instance = new Node(0, 0);
        instance.addNeighbor(1);instance.addNeighbor(2);
        LinkedList<Integer> result = instance.getListOfNeighbours();
        assertEquals(result, instance.getListOfNeighbours());
    }

    /**
     * Test of numberOfNeighbor method, of class Node.
     */
    @Test
    public void testNumberOfNeighbor() {
        System.out.println("numberOfNeighbor");
        Node instance = new Node(1, 0);
        instance.addNeighbor(1);instance.addNeighbor(2);
        int expResult = 2;
        int result = instance.numberOfNeighbor();
        assertTrue(result == expResult);
    }

    /**
     * Test of getIDNeighbor method, of class Node.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetIDNeighbor() {
        System.out.println("getIDNeighbor");
        int index = 0;
        Node instance = new Node(1, 1);
        instance.addNeighbor(1);instance.addNeighbor(2);
        Integer expResult = 1;
        Integer result = instance.getIDNeighbor(index);
        assertEquals(expResult, result);
        index = 1;
        expResult = 2;
        result = instance.getIDNeighbor(index);
        assertEquals(expResult, result);
        index = 2;
        expResult = null;
        result = instance.getIDNeighbor(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of setIDNeighbor method, of class Node.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetIDNeighbor() {
        System.out.println("setIDNeighbor");
        int index = 0;
        Node instance = new Node(1, 1);
        instance.addNeighbor(1);instance.addNeighbor(2);
        Integer expResult = 3;
        instance.setIDNeighbor(index, 3);
        assertEquals(expResult, instance.getIDNeighbor(index));
        index = 1;
        expResult = 4;
        instance.setIDNeighbor(index, 4);
        assertEquals(expResult, instance.getIDNeighbor(index));
        index = 2;
        expResult = null;
        instance.setIDNeighbor(index, 5);
        assertEquals(expResult, instance.getIDNeighbor(index));
    }

    /**
     * Test of addNeighbor method, of class Node.
     */
    @Test
    public void testAddNeighbor() {
        System.out.println("addNeighbor");
        int ID = 1;
        Node instance = new Node(new Point());
        instance.addNeighbor(ID);
        assertTrue(instance.getListOfNeighbours().contains(ID));
    }

    /**
     * Test of removeNeighbor method, of class Node.
     */
    @Test
    public void testRemoveNeighbor() {
        System.out.println("removeNeighbor");
        Integer ID = 1;
        Node instance = new Node(new Point());
        instance.addNeighbor(ID);
        instance.removeNeighbor(ID);
        assertTrue(!instance.getListOfNeighbours().contains(ID));
    }
}
