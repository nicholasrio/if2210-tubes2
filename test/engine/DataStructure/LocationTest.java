/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.DataStructure;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Winson
 */
public class LocationTest {
    
    public LocationTest() {
        Location L = new Location(1,2,3);
        assertNotNull("Cek Constructor Location", L);
    }

    /**
     * Test of setLocation method, of class Location.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        int level = 4;
        int row = 6;
        int col = 7;
        Location instance = new Location();
        instance.setLocation(level, row, col);
        assertEquals(level, instance.getLevel());
        assertEquals(col, instance.getCol());
        assertEquals(row, instance.getRow());
    }

    /**
     * Test of getLevel method, of class Location.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        Location instance = new Location();
        instance.setLevel(4546);
        int expResult = 4546;
        int result = instance.getLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRow method, of class Location.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Location instance = new Location();
        instance.setRow(345);
        int expResult = 345;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCol method, of class Location.
     */
    @Test
    public void testGetCol() {
        System.out.println("getCol");
        Location instance = new Location();
        instance.setCol(234);
        int expResult = 234;
        int result = instance.getCol();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Location.
     */
    @Test
    public void testToString() {
        System.out.println("toString Location");
        Location instance = new Location(2,3,4);
        String expResult = "Baris = 2\nKolom = 3\nLevel = 4\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
