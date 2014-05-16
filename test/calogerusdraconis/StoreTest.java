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
    }

    /**
     * Test of getFdInventory method, of class Store.
     */
    @Test
    public void testGetFdInventory() {
        System.out.println("getFdInventory");
        Store instance = Store.getInstance();
        ArrayList<Consumable> expResult = new ArrayList<> ();
        expResult.add(new Consumable("first-aid","res/first-aid.png",200,0,0,300,0,0,0,0));
        ArrayList<Consumable> result = instance.getFdInventory();
        for (Consumable c : result){
            System.out.println(c.getName());}        
        assertEquals(expResult.get(0).getName(),result.get(0).getName());
    }

    /**
     * Test of setFdInventory method, of class Store.
     */
    @Test

    public void testSetFdInventory() {
        System.out.println("setFdInventory");
        ArrayList<Consumable> val = new ArrayList<Consumable> ();
        val.add(new Consumable("first-aid","res/first-aid.png",200,0,0,300,0,0,0,0));
        System.out.println(val.get(0).getName());
        Store instance = Store.getInstance();
        instance.setFdInventory(val);
        ArrayList<Consumable> tes = instance.getFdInventory();
        System.out.println(val.get(0).getName()+tes.get(0).getName());
        assertEquals(val.get(0).getName(),tes.get(0).getName());
    }

    /**
     * Test of buy method, of class Store.
     */
    @Test
    public void testBuy() {
        System.out.println("buy");
        int arrLoc = 0;
        Store instance = Store.getInstance();
        Consumable expResult = new Consumable("first-aid","res/first-aid.png",200,0,0,300,0,0,0,0);
        Consumable result = instance.buy(arrLoc);
        assertEquals(result.getName(),expResult.getName());
    }
    
}
