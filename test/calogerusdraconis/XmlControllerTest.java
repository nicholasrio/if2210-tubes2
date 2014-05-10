/*
 * Copyright (C) 2014 dalva
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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dalva
 */
public class XmlControllerTest {
	
	//private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	//private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	public XmlControllerTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		//System.setOut(new PrintStream(outContent));
		//System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void tearDown() {
		//System.setOut(null);
		//System.setErr(null);
	}

	/**
	 * Test of LoadDragon method, of class XmlController.
	 */
	@Test
	public void testLoadDragon() {
		System.out.println("LoadDragon");
		XmlController instance = new XmlController();
		try {
			UserDragon ud = instance.LoadDragon("Xanareth");
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		// TODO review the generated test code and remove the default call to fail.
		//assertEquals("Dragon Name : Xanareth\n", outContent.toString());
	}
	
}
