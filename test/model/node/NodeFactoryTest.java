package model.node;

import model.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for NodeFactory using JUnit
 * @author Riva Syafri Rachmatullah
 */
public class NodeFactoryTest {
    
    public NodeFactoryTest() {
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
     * Test of createNode method, of class NodeFactory.
     */
    @Test
    public void testCreateNode() {
        System.out.println("createNode");
        assertTrue("model.node.Building".equals(NodeFactory.createNode(NodeType.BUILDING, new Point(), 0).getClass().getTypeName()));
        assertTrue("model.node.Canteen".equals(NodeFactory.createNode(NodeType.CANTEEN, new Point(), 0).getClass().getTypeName()));
        assertTrue("model.node.Node".equals(NodeFactory.createNode(NodeType.NODE, new Point(), 0).getClass().getTypeName()));
    }
    
}
