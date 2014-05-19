/*
 * Copyright (C) 2014 Calogerus Draconis Team
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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rita Sarah
 */
public class ConsumableTest {
    /**
     * Test of getImg method, of class Consumable.
     */
    @Test
    public void testGetImg() {
        System.out.println("getImg");
        Consumable instance = new Consumable("aa","aa",0,0,0,0,0,0,0,0);
        String expResult = "aa";
        String result = instance.getImg();
        assertEquals(expResult, result);
    }

    /**
     * Test of setImg method, of class Consumable. 
     */
    @Test
    public void testSetImg() {
        System.out.println("setImg");
        String val = "";
        Consumable instance =new Consumable("aa","aa",0,0,0,0,0,0,0,0) ;
        instance.setImg(val);
    }

    /**
     * Test of getName method, of class Consumable.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Consumable instance = new Consumable("aa","aa",0,0,0,0,0,0,0,0);
        String expResult = "aa";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Consumable.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String val = "";
        Consumable instance = new Consumable("aa","aa",0,0,0,0,0,0,0,0);
        instance.setName(val);
    }

    /**
     * Test of getHealthValue method, of class Consumable.
     */
    @Test
    public void testGetHealthValue() {
        System.out.println("getHealthValue");
        Consumable instance = new Consumable("aa","aa",0,0,0,0,0,0,0,0);
        float expResult = 0.0F;
        float result = instance.getHealthValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getThirstValue method, of class Consumable.
     */
    @Test
    public void testGetThirstValue() {
        System.out.println("getThirstValue");
        Consumable instance = new Consumable("aa","aa",0,0,0,0,0,0,0,0);
        float expResult = 0.0F;
        float result = instance.getThirstValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getHungerValue method, of class Consumable.
     */
    @Test
    public void testGetHungerValue() {
        System.out.println("getHungerValue");
        Consumable instance = new Consumable("aa","aa",0,0,0,0,0,0,0,0);
        float expResult = 0.0F;
        float result = instance.getHungerValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCost method, of class Consumable.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        Consumable instance = new Consumable("aa","aa",0,0,0,0,0,0,0,0);
        float expResult = 0.0F;
        float result = instance.getCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getStaminaValue method, of class Consumable.
     */
    @Test
    public void testGetStaminaValue() {
        System.out.println("getStaminaValue");
        Consumable instance = new Consumable("aa","aa",0,0,0,0,0,0,0,0);
        float expResult = 0.0F;
        float result = instance.getStaminaValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMaxHealthValue method, of class Consumable.
     */
    @Test
    public void testGetMaxHealthValue() {
        System.out.println("getMaxHealthValue");
        Consumable instance = new Consumable("aa","aa",0,0,0,0,0,0,0,0);
        float expResult = 0.0F;
        float result = instance.getMaxHealthValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMaxStaminaValue method, of class Consumable.
     */
    @Test
    public void testGetMaxStaminaValue() {
        System.out.println("getMaxStaminaValue");
        Consumable instance = new Consumable("aa","aa",0,0,0,0,0,0,0,0);
        float expResult = 0.0F;
        float result = instance.getMaxStaminaValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getHappinessValue method, of class Consumable.
     */
    @Test
    public void testGetHappinessValue() {
        System.out.println("getHappinessValue");
        Consumable instance = new Consumable("aa","aa",0,0,0,0,0,0,0,0);
        float expResult = 0.0F;
        float result = instance.getHappinessValue();
        assertEquals(expResult, result, 0.0);
    }
    
}
