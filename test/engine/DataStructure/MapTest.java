/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.DataStructure;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Winson
 */
public class MapTest {
    Map testMap;
    
    @Before
    public void setUp() {
        System.out.println("SetUp Map");
        testMap = new Map("map1.xml");
    }

    /**
     * Test of getElement method, of class Map.
     */
    @Test
    public void testGetElement() {
        System.out.println("getElement");
        Location L = new Location(5,0,4);
        GameItem expResult = new CoinItem();
        GameItem result = testMap.getElement(L);
        assertEquals(expResult.getName(), result.getName());
    }

    /**
     * Test of setElement method, of class Map.
     */
    @Test
    public void testSetElement() {
        System.out.println("setElement");
        Location L = new Location(1,1,1);
        GameItem value = new HoleItem();
        Map instance = new Map(3,3,3);
        instance.setElement(L, value);
        GameItem expected = new HoleItem();
        assertEquals(expected.getName(),instance.getElement(L).getName());
    }

    /**
     * Test of getMaxLevel method, of class Map.
     */
    @Test
    public void testGetMaxLevel() {
        System.out.println("getMaxLevel");
        int expResult = 6;
        int result = testMap.getMaxLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxRow method, of class Map.
     */
    @Test
    public void testGetMaxRow() {
        System.out.println("getMaxRow");
        int expResult = 6;
        int result = testMap.getMaxRow();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxCol method, of class Map.
     */
    @Test
    public void testGetMaxCol() {
        System.out.println("getMaxCol");
        int expResult = 6;
        int result = testMap.getMaxCol();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStart method, of class Map.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetStart() throws Exception {
        System.out.println("getStart");
        Location expResult = new Location(5,0,0);
        Location result = testMap.getStart();
        assertEquals(expResult.getLevel(), result.getLevel());
        assertEquals(expResult.getCol(), result.getCol());
        assertEquals(expResult.getRow(), result.getRow());
    }    
}
