/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapAndCharacter;

import java.io.PrintStream;
import java.util.List;
import map.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import character.Character;
import java.util.LinkedList;
/**
 *
 * @author Calvin
 */
public class ViewerConsoleTest {
    Map M;
    List<Character> LC; 
    MapAdapter MA;
    
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
        M =new Map();
        M.createDungeon(80, 25, 40);
        LC = new LinkedList<Character>();
        LC.add(new Character());
        MA = new MapAdapter(M);
        MA.addChar(new Character(), 3, 3);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of view method, of class ViewerConsole.
     */
    @Test
    public void testView_PrintStream_MapAdapter() {
        System.out.println("view");
        ViewerConsole.view(System.out, MA);
    }

    /**
     * Test of viewWithoutVisiblity method, of class ViewerConsole.
     */
    @Test
    public void testViewWithoutVisiblity() {
        System.out.println("viewWithoutVisiblity");
        ViewerConsole.viewWithoutVisiblity(System.out, MA);
    }

    /**
     * Test of view method, of class ViewerConsole.
     */
    @Test
    public void testViewArea() {
        System.out.println("viewArea");
        int x1 = 1;
        int y1 = 1;
        int width = 10;
        int height = 10;
        ViewerConsole.view(System.out, MA);
    }
    
}
