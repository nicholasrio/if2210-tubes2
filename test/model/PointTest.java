package model;

import model.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test class Point using JUnit
 * @author Riva Syafri Rachmatullah
 */
public class PointTest {
    
    public PointTest() {
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
     * Test of getLocation method, of class Point.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Point instance = new Point(1, 2);
        Point expResult1 = new Point(1, 2);
        Point result1 = instance.getLocation();
        assertTrue(expResult1.equals(result1));
        Point expResult2 = new Point();
        Point result2 = instance.getLocation();
        assertTrue(!expResult2.equals(result2));
    }

    /**
     * Test of setLocation method, of class Point.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        double x1 = 0.0;
        double y1 = 0.0;
        Point instance = new Point();
        instance.setLocation(x1, y1);
        assertTrue(x1 == instance.getX() && y1 == instance.getY());
        double x2 = 10.0;
        double y2 = 9.0;
        instance.setLocation(x2, y2);
        assertTrue(x2 == instance.getX() && y2 == instance.getY());
    }

    /**
     * Test of distance method, of class Point.
     */
    @Test
    public void testDistance_Point() {
        System.out.println("distance");
        Point pt = new Point(3, 4);
        Point instance = new Point();
        double expResult = 5.0;
        double result = instance.distance(pt);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of distance method, of class Point.
     */
    @Test
    public void testDistance_double_double() {
        System.out.println("distance");
        double px = 3.0;
        double py = 4.0;
        Point instance = new Point();
        double expResult = 5.0;
        double result = instance.distance(px, py);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getX method, of class Point.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Point instance = new Point(3, 4);
        double expResult = 3.0;
        double result = instance.getX();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getY method, of class Point.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Point instance = new Point(3, 4);
        double expResult = 4.0;
        double result = instance.getY();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of move method, of class Point.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        double x = 1.0;
        double y = 2.0;
        Point instance = new Point();
        instance.move(x, y);
        assertTrue(x == instance.getX() && y == instance.getY());
    }

    /**
     * Test of translate method, of class Point.
     */
    @Test
    public void testTranslate() {
        System.out.println("translate");
        double dx = 5.0;
        double dy = 6.0;
        double x = 4.0;
        double y = 8.0;
        Point instance = new Point(-1, 2);
        instance.translate(dx, dy);
        assertTrue(instance.getX() == x && instance.getY() == y);
    }

    /**
     * Test of equal method, of class Point.
     */
    @Test
    public void testEquals_Point() {
        System.out.println("equal");
        Point p = new Point();
        Point instance1 = new Point(1, 1);
        boolean expResult1 = false;
        boolean result1 = instance1.equals(p);
        assertEquals(expResult1, result1);
        Point instance2 = new Point(0, 0);
        boolean expResult2 = true;
        boolean result2 = instance2.equals(p);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of equal method, of class Point.
     */
    @Test
    public void testEquals_double_double() {
        System.out.println("equals");
        double x = 0.0;
        double y = 0.0;
        Point instance = new Point();
        boolean expResult = true;
        boolean result = instance.equals(x, y);
        assertEquals(expResult, result);
    }
}
