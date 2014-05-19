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
public class EventTest {
	
	public EventTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of getMessage method, of class Event.
	 */
	@Test
	public void testGetMessage() {
		System.out.println("getMessage");
		Event instance = new Event("test","lagi testing");
		String expResult = "lagi testing";
		String result = instance.getMessage();
		assertEquals(expResult, result);
			}

	/**
	 * Test of setMessage method, of class Event.
	 */
	@Test
	public void testSetMessage() {
		System.out.println("setMessage");
		String val = "";
		Event instance = new Event("test","lagi testing");
		instance.setMessage(val);
		assertEquals(val, instance.getMessage());
			}

	/**
	 * Test of getType method, of class Event.
	 */
	@Test
	public void testGetType() {
		System.out.println("getType");
		Event instance = new Event("test","lagi testing");
		String expResult = "test";
		String result = instance.getType();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setType method, of class Event.
	 */
	@Test
	public void testSetType() {
		System.out.println("setType");
		String val = "";
		Event instance = new Event("test","lagi testing");
		instance.setType(val);
		assertEquals(val, instance.getType());
	}
	
}
