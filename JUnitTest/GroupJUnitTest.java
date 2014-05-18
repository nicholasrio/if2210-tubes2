package JunitTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Group.*;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author asus
 */
public class GroupJUnitTest {
    Group G;
    public GroupJUnitTest() {
        G = new Group();
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void TestSelectData() throws SQLException {
        String[] row1 = {"1", "jbui", "bnjb", "bb", "h"};
        assertArrayEquals(row1, G.GroupData().get(0));
    }
    
    @Test
    public void TestCekData() throws SQLException {
        boolean ada = true;
        assertEquals(ada, G.cekDataGroup(1, "jbui"));
    }
}
