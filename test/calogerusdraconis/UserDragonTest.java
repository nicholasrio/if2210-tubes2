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

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anggi
 */
public class UserDragonTest {
	
	public UserDragonTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of getMaxHealth method, of class UserDragon.
	 */
	@Test
	public void testGetMaxHealth() {
		System.out.println("getMaxHealth");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		float expResult = 150;
		float result = instance.getMaxHealth();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of getMaxStamina method, of class UserDragon.
	 */
	@Test
	public void testGetMaxStamina() {
		System.out.println("getMaxStamina");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		float expResult = 200;
		float result = instance.getMaxStamina();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of getFdInventory method, of class UserDragon.
	 */
	@Test
	public void testGetFdInventory() {
		System.out.println("getFdInventory");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		instance.getFdInventory().add(new Consumable("first-aid","res/first-aid.png",200,0,0,300,0,0,0,0));
		ArrayList<Consumable> expResult = new ArrayList<>();
		expResult.add(new Consumable("first-aid","res/first-aid.png",200,0,0,300,0,0,0,0));
		ArrayList<Consumable> result = instance.getFdInventory();
		assertEquals(expResult.get(0).getName(), result.get(0).getName());
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of setFdInventory method, of class UserDragon.
	 */
	@Test
	public void testSetFdInventory() {
		System.out.println("setFdInventory");
		ArrayList<Consumable> fd = new ArrayList<>();
		fd.add(new Consumable("first-aid","res/first-aid.png",200,0,0,300,0,0,0,0));
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		instance.setFdInventory(fd);
		assertEquals(fd.get(0).getName(), instance.getFdInventory().get(0).getName());
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of getHappiness method, of class UserDragon.
	 */
	@Test
	public void testGetHappiness() {
		System.out.println("getHappiness");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		float expResult = 66;
		float result = instance.getHappiness();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of setHappiness method, of class UserDragon.
	 */
	@Test
	public void testSetHappiness() {
		System.out.println("setHappiness");
		float val = 0.0F;
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		instance.setHappiness(val);
		assertEquals(val, instance.getHappiness(), 0.0);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of getMoney method, of class UserDragon.
	 */
	@Test
	public void testGetMoney() {
		System.out.println("getMoney");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		float expResult = 50;
		float result = instance.getMoney();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of setMoney method, of class UserDragon.
	 */
	@Test
	public void testSetMoney() {
		System.out.println("setMoney");
		float val = 0.0F;
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		instance.setMoney(val);
		assertEquals(val, instance.getMoney(), 0.0);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of getPassword method, of class UserDragon.
	 */
	@Test
	public void testGetPassword() {
		System.out.println("getPassword");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		String expResult = "pass";
		String result = instance.getPassword();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of setPassword method, of class UserDragon.
	 */
	@Test
	public void testSetPassword() {
		System.out.println("setPassword");
		String val = "";
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		instance.setPassword(val);
		assertEquals(val, instance.getPassword());
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of useConsumable method, of class UserDragon.
	 */
	@Test
	public void testUseConsumable() {
		System.out.println("useConsumable");
		Consumable fd = new Consumable("first-aid","res/first-aid.png",200,10,30,300,100,80,75,12);
		UserDragon instance = new UserDragon("user",78,300,89,200,23,51,21,5,123,"pass",50,66);
		instance.getFdInventory().add(fd);
		float expHealth = instance.getHealth() + fd.getHealthValue();
		float expThirst = instance.getThirst() + fd.getThirstValue();
		float expHunger = instance.getHunger() + fd.getHungerValue();
		float expStamina = instance.getStamina() + fd.getStaminaValue();
		float expMaxHealth = instance.getMaxHealth() + fd.getMaxHealthValue();
		float expMaxStamina = instance.getMaxStamina() + fd.getMaxStaminaValue();
		float expHappiness = instance.getHappiness() + fd.getHappinessValue();
		Event expResult = null;
		Event result = instance.useConsumable(fd);
		//assertEquals(expResult, result);
		assertEquals(expHealth, instance.getHealth(), 0.0);
		assertEquals(expThirst, instance.getThirst(), 0.0);
		assertEquals(expHunger, instance.getHunger(), 0.0);
		assertEquals(expStamina, instance.getStamina(), 0.0);
		assertEquals(expMaxStamina, instance.getMaxStamina(), 0.0);
		assertEquals(expMaxHealth, instance.getMaxHealth(), 0.0);
		assertEquals(expHappiness, instance.getHappiness(), 0.0);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of addConsumable method, of class UserDragon.
	 */
	@Test
	public void testAddConsumable(){
		System.out.println("addConsumable");
		Consumable what = new Consumable("first-aid","res/first-aid.png",200,0,0,300,0,0,0,0);
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",350,66);
		float expMoney = instance.getMoney() - what.getCost();
		Event expResult = new Event("Proses Selesai","addConsumable Selesai");
		//Event result = null;
		try {
			Event result = instance.addConsumable(what);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		assertEquals(expMoney, instance.getMoney(), 0.0);
		assertEquals(what.getName(), instance.getFdInventory().get(0).getName());
		//assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of sebelumExit method, of class UserDragon.
	 */
	@Test
	public void testSebelumExit() {
		System.out.println("sebelumExit");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		instance.sebelumExit();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of train method, of class UserDragon.
	 */
	@Test
	public void testTrain() {
		System.out.println("train");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,1,795,"pass",50,66);
		float expExperience = 20*instance.getLevel() + instance.getExperience();
		int expLevel = instance.getLevel() + 1;
		float expMaxHealth = instance.getMaxHealth() + 30;
		float expMaxStamina = instance.getMaxStamina() + 10;
		Event expResult = null;
		Event result = instance.train();
		System.out.println(expExperience);
		assertEquals(expExperience, instance.getExperience(), 0.0);
		assertEquals(expLevel, instance.getLevel());
		assertEquals(expMaxHealth, instance.getMaxHealth(), 0.0);
		assertEquals(expMaxStamina, instance.getMaxStamina(), 0.0);
		//assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of generateEnemy method, of class UserDragon.
	 */
	@Test
	public void testGenerateEnemy() {
		System.out.println("generateEnemy");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,1,795,"pass",50,66);
		Dragon expResult = null;
		Dragon result = instance.generateEnemy();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of fight method, of class UserDragon.
	 */
	@Test
	public void testFight() {
		System.out.println("fight");
		Dragon withWho = new Dragon("enemy",81,83,25,63,27,3,778);
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,1,795,"pass",50,66);
		float sum1 = (float)0.2 * instance.getHealth() + (float)0.2 * instance.getStamina() + (float)0.3 * instance.getExperience() + 5 * instance.getLevel() - (float)0.1 * instance.getThirst() - (float)0.1 * instance.getBladder() - (float)0.1 * instance.getHunger();
		float sum2 = (float)0.2 * withWho.getHealth() + (float)0.2 * withWho.getStamina() + (float)0.3 * withWho.getExperience() + 5 * withWho.getLevel() - (float)0.1 * withWho.getThirst() - (float)0.1 * withWho.getBladder() - (float)0.1 * withWho.getHunger();
		float expExperience, expStamina;
		if (sum1 > sum2){ // we win
            expExperience = instance.getExperience() + 200 + 30 * instance.getLevel();
            //tambahMoney((float)(100 + (Math.random() * (500 - 100))));
        } else if (sum1 == sum2){ // draw
            expExperience = instance.getExperience() + 25 * instance.getLevel();
        } else { // we lose
			expExperience = instance.getExperience() + 20 * instance.getLevel();
		}
		expStamina = instance.getStamina() - (20 * instance.getLevel());
		Event expResult = null;
		Event result = instance.fight(withWho);
		assertEquals(expExperience, instance.getExperience(), 0.0);
		assertEquals(expStamina, instance.getStamina(), 0.0);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of entertain method, of class UserDragon.
	 */
/*	@Test
	public void testEntertain() {
		System.out.println("entertain");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		Event expResult = null;
		Event result = instance.entertain();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of rest method, of class UserDragon.
	 */
/*	@Test
	public void testRest() {
		System.out.println("rest");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		Event expResult = new Event("Proses Selesai","Entertain Selesai");
		Event result = instance.rest();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toToilet method, of class UserDragon.
	 */
/*	@Test
	public void testToToilet() {
		System.out.println("toToilet");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		Event expResult = null;
		Event result = instance.toToilet();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}*/
	
}
