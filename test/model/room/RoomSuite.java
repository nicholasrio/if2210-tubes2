package model.room;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite to test all test case in package model.room together.
 * @author Riva Syafri Rachmatullah
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({RoomTest.class, RoomTypeTest.class, RoomFactoryTest.class, RestroomTest.class})
public class RoomSuite {

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
