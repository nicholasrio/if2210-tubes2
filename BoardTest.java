/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Vector;
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
public class BoardTest {
    
    public BoardTest() {
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
     * Test of viewMap method, of class Board.
     */
    @Test
    public void testViewMap() {
        System.out.println("viewMap");
        int i = 0;
        Board instance = new Board();
        instance.viewMap(i);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validatorPosition method, of class Board.
     */
    @Test
    public void testValidatorPosition() {
        System.out.println("validatorPosition");
        Path_Card P = new Path_Card('1','1','1','1','1',1);
        Vector<Integer> Position = new Vector<Integer>();
        Position.addElement(4);
        Position.addElement(5);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.validatorPosition(P, Position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of putCardOnBoard method, of class Board.
     */
    @Test
    public void testPutCardOnBoard() {
        System.out.println("putCardOnBoard");
        Path_Card P = new Path_Card('1','1','1','1','1',1);
        Vector<Integer> Position = new Vector<Integer>();
        Position.addElement(3);
        Position.addElement(4);
        Board instance = new Board();
        int expResult = -1;
        int result = instance.putCardOnBoard(P, Position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of PrintBoard method, of class Board.
     */
    @Test
    public void testPrintBoard() {
        System.out.println("PrintBoard");
        Board instance = new Board();
        instance.PrintBoard();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of openGoal method, of class Board.
     */
    @Test
    public void testOpenGoal() {
        System.out.println("openGoal");
        Board instance = new Board();
        instance.openGoal();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isFinished method, of class Board.
     */
    @Test
    public void testIsFinished() {
        System.out.println("isFinished");
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isFinished();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
