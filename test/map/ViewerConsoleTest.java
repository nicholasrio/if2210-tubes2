/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Calvin
 */
public class ViewerConsoleTest {
    
    public ViewerConsoleTest() {
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

    @Test
    public void testViewWithoutVisiblity() {
        System.out.println("viewWithoutVisiblity");
        Map M = new Map();
        M.createDungeon(80, 25, 40);
        ViewerConsole.viewWithoutVisiblity(System.out, M);
    }

    /**
     * Test of view method, of class ViewerConsole.
     */
    @Test
    public void testView() {
        System.out.println("view");
        Map M = new Map();
        M.createDungeon(80, 25, 40);
        ViewerConsole.view(System.out, M);
    }
    
    @Test
    public void testViewArea() {
        System.out.println("viewArea");
        Map M = new Map();
        M.createDungeon(80, 25, 40);
        ViewerConsole.view(System.out, M, 30, 10, 10, 10);
    }
}
