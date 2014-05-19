package model;

import model.menu.MenuSuite;
import model.node.NodeSuite;
import model.room.RoomSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This class is for integration testing of model package.
 * @author Riva Syafri Rachmatullah
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({PointTest.class, MenuSuite.class, RoomSuite.class, NodeSuite.class})
public class ModelSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
