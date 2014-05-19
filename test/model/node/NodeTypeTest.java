package model.node;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for NodeType enumerator
 * @author Riva Syafri Rachmatullah
 */
public class NodeTypeTest {
    
    public NodeTypeTest() {
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
     * Test of values method, of class NodeType.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        NodeType[] expResult = {NodeType.NODE, NodeType.BUILDING, NodeType.CANTEEN };
        NodeType[] result = NodeType.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class NodeType.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        NodeType expResult = NodeType.BUILDING;
        NodeType result = NodeType.valueOf("BUILDING");
        assertEquals(expResult, result);
    }
    
}
