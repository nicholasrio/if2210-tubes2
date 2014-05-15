/*
 * Copyright (C) 2014 Anggi
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
 * @author Anggi
 */
public class DragonTest {
	
	public DragonTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of getBladder method, of class Dragon.
	 */
	@Test
	public void testGetBladder() {
		System.out.println("getBladder");
		Dragon instance = new Dragon("enemy",78,89,23,51,21,5,123);
		float expResult = 51;
		float result = instance.getBladder();
		//System.out.println(result);
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getExperience method, of class Dragon.
	 */
	@Test
	public void testGetExperience() {
		System.out.println("getExperience");
		Dragon instance = new Dragon("enemy",78,89,23,51,21,5,123);
		int expResult = 123;
		int result = instance.getExperience();
		//System.out.println(result);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getHealth method, of class Dragon.
	 */
	@Test
	public void testGetHealth() {
		System.out.println("getHealth");
		Dragon instance = new Dragon("enemy",78,89,23,51,21,5,123);
		float expResult = 78;
		float result = instance.getHealth();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getHunger method, of class Dragon.
	 */
	@Test
	public void testGetHunger() {
		System.out.println("getHunger");
		Dragon instance = new Dragon("enemy",78,89,23,51,21,5,123);
		float expResult = 21;
		float result = instance.getHunger();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getLevel method, of class Dragon.
	 */
	@Test
	public void testGetLevel() {
		System.out.println("getLevel");
		Dragon instance = new Dragon("enemy",78,89,23,51,21,5,123);
		int expResult = 5;
		int result = instance.getLevel();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setLevel method, of class Dragon.
	 */
	@Test
	public void testSetLevel() {
		System.out.println("setLevel");
		int val = 0;
		Dragon instance = new Dragon("enemy",78,89,23,51,21,5,123);
		instance.setLevel(val);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getName method, of class Dragon.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Dragon instance = new Dragon("enemy",78,89,23,51,21,5,123);
		String expResult = "enemy";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setName method, of class Dragon.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String val = "";
		Dragon instance = new Dragon("enemy",78,89,23,51,21,5,123);
		instance.setName(val);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getStamina method, of class Dragon.
	 */
	@Test
	public void testGetStamina() {
		System.out.println("getStamina");
		Dragon instance = new Dragon("enemy",78,89,23,51,21,5,123);
		float expResult = 89;
		float result = instance.getStamina();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getThirst method, of class Dragon.
	 */
	@Test
	public void testGetThirst() {
		System.out.println("getThirst");
		Dragon instance = new Dragon("enemy",78,89,23,51,21,5,123);
		float expResult = 23;
		float result = instance.getThirst();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
