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

import java.util.ArrayList;
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
 * @author Dariel Valdano
 */
public class XmlControllerTest {
	/**
	 * Test of LoadDragon method, of class XmlController.
	 */
	@Test
	public void testLoadDragon() {
		System.out.println("LoadDragon");
		XmlController instance = new XmlController();
		try {
			UserDragon ud = instance.LoadDragon("Xanareth","anotherPass");
			assertEquals("Xanareth",ud.getName());
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	/**
	 * Test of SaveDragon method, of class XmlController.
	 */
	@Test
	public void testSaveDragon() {
		System.out.println("SaveDragon");
		UserDragon dragon = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		ArrayList<Consumable> arr = new ArrayList<>();
		arr.add(new Consumable("first-aid","res/first-aid.png",200,0,0,300,0,0,0,0));
		arr.add(new Consumable("potion","res/potion.png",250,0,0,400,0,0,0,0));
		dragon.setFdInventory(arr);
		XmlController instance = new XmlController();
		try {
			instance.SaveDragon(dragon);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		
	}
}