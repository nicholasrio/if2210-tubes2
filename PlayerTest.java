/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of getScore method, of class Player.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatus method, of class Player.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String S = "";
        Player instance = new Player();
        instance.setStatus(S);
    }
    
    /**
     * Test of setTurn method, of class Player.
     */
    @Test
    public void testSetTurn() {
        System.out.println("setTurn");
        int t = 0;
        Player instance = new Player();
        instance.setTurn(t);
    }

    /**
     * Test of getTurn method, of class Player.
     */
    @Test
    public void testGetTurn() {
        System.out.println("getTurn");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getTurn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFinishedTurn method, of class Player.
     */
    @Test
    public void testGetFinishedTurn() {
        System.out.println("getFinishedTurn");
        Player instance = new Player();
        boolean expResult = false;
        boolean result = instance.getFinishedTurn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFinishedTurn method, of class Player.
     */
    @Test
    public void testSetFinishedTurn() {
        System.out.println("setFinishedTurn");
        boolean myBool = false;
        Player instance = new Player();
        instance.setFinishedTurn(myBool);
    }

    /**
     * Test of getFinishedDraw method, of class Player.
     */
    @Test
    public void testGetFinishedDraw() {
        System.out.println("getFinishedDraw");
        Player instance = new Player();
        boolean expResult = false;
        boolean result = instance.getFinishedDraw();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFinishedDraw method, of class Player.
     */
    @Test
    public void testSetFinishedDraw() {
        System.out.println("setFinishedDraw");
        boolean myBool = false;
        Player instance = new Player();
        instance.setFinishedDraw(myBool);
    }

    /**
     * Test of setScore method, of class Player.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int s = 0;
        Player instance = new Player();
        instance.setScore(s);
    }

    /**
     * Test of setDate method, of class Player.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String d = "";
        Player instance = new Player();
        instance.setDate(d);
    }

    /**
     * Test of getDate method, of class Player.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Player instance = new Player();
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerName method, of class Player.
     */
    @Test
    public void testGetPlayerName() {
        System.out.println("getPlayerName");
        Player instance = new Player("Daniar Heri Kurniawan");
        String expResult = "Daniar Heri Kurniawan";
        String result = instance.getPlayerName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNCardonHand method, of class Player.
     */
    @Test
    public void testGetNCardonHand() {
        System.out.println("getNCardonHand");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getNCardonHand();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRole method, of class Player.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        int id = 0;
        Player instance = new Player();
        instance.setRole(id);
        assertEquals(instance.getRoleId(),id);
    }

    /**
     * Test of getRoleId method, of class Player.
     */
    @Test
    public void testGetRoleId() {
        System.out.println("getRoleId");
        Player instance = new Player();
        instance.setRole(1);
        int expResult = 1;
        int result = instance.getRoleId();
        assertEquals(expResult, result);
    }

    /**
     * Test of drawCard method, of class Player.
     */
    @Test
    public void testDrawCard() {
        System.out.println("drawCard");
        Card c = null;
        Player instance = new Player();
        instance.drawCard(c);
        
    }

    /**
     * Test of setIdxRemovedCard method, of class Player.
     */
    @Test
    public void testSetIdxRemovedCard() {
        System.out.println("setIdxRemovedCard");
        int Idx = 0;
        Player instance = new Player();
        instance.setIdxRemovedCard(Idx);
    }

    /**
     * Test of disCard method, of class Player.
     */
    @Test
    public void testDisCard() {
        System.out.println("disCard");
        int index = 0;
        Player instance = new Player();
        Card expResult = new Path_Card('1','1','1','1','1',1);
        instance.drawCard(expResult);
        Card result = instance.disCard(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class Player.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Player instance = new Player();
        instance.setStatus("disabled");
        String expResult = "disabled";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of printCardsOnHand method, of class Player.
     */
    @Test
    public void testPrintCardsOnHand() {
        System.out.println("printCardsOnHand");
        Player instance = new Player();
        instance.printCardsOnHand();
    }
    
}
