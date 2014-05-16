/*
 * Copyright (C) 2014 ASUS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package calogerusdraconis;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class StoreTest {
    
    public StoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getInstance method, of class Store.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Store result = Store.getInstance();
        for (Consumable c : result.getFdInventory()){
            System.out.println(c.getName());}
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFdInventory method, of class Store.
     */
    @Test
    public void testGetFdInventory() {
        System.out.println("getFdInventory");
        Store instance = new Store();
        ArrayList<Consumable> expResult = null;
        ArrayList<Consumable> result = instance.getFdInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFdInventory method, of class Store.
     */
    @Test

    public void testSetFdInventory() {
        System.out.println("setFdInventory");
        ArrayList<Consumable> val = null;
        Store instance = null;
        instance.setFdInventory(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buy method, of class Store.
     */
    @Test
    public void testBuy() {
        System.out.println("buy");
        int arrLoc = 0;
        Store instance = null;
        Consumable expResult = null;
        Consumable result = instance.buy(arrLoc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
