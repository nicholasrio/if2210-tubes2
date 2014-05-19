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
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cilvia Sianora Putri
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
		Event expResult = new Event("Proses Selesai","useCosumable Selesai");
		Event result = instance.useConsumable(fd);
		assertEquals(expResult.getMessage(), result.getMessage());
		assertEquals(expResult.getType(), result.getType());
		assertEquals(expHealth, instance.getHealth(), 0.0);
		assertEquals(expThirst, instance.getThirst(), 0.0);
		assertEquals(expHunger, instance.getHunger(), 0.0);
		assertEquals(expStamina, instance.getStamina(), 0.0);
		assertEquals(expMaxStamina, instance.getMaxStamina(), 0.0);
		assertEquals(expMaxHealth, instance.getMaxHealth(), 0.0);
		assertEquals(expHappiness, instance.getHappiness(), 0.0);
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
		Event result = new Event();
		try {
			result = instance.addConsumable(what);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		assertEquals(expMoney, instance.getMoney(), 0.0);
		assertEquals(what.getName(), instance.getFdInventory().get(0).getName());
		assertEquals(expResult.getMessage(), result.getMessage());
		assertEquals(expResult.getType(), result.getType());
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
		Event expResult = new Event("Proses Selesai","The dragon is now Trained");
		Event result = instance.train();
		assertEquals(expExperience, instance.getExperience(), 0.0);
		assertEquals(expLevel, instance.getLevel());
		assertEquals(expMaxHealth, instance.getMaxHealth(), 0.0);
		assertEquals(expMaxStamina, instance.getMaxStamina(), 0.0);
		assertEquals(expResult.getMessage(), result.getMessage());
		assertEquals(expResult.getType(), result.getType());
	}

	/**
	 * Test of generateEnemy method, of class UserDragon.
	 */
	@Test
	public void testGenerateEnemy() {
		System.out.println("generateEnemy");
		UserDragon instance = new UserDragon("user",100,150,100,200,50,50,50,1,500,"pass",50,66);
		Dragon result = instance.generateEnemy();
		assert(result.getHealth() >= (float)Math.ceil(0.8*(double)(3*instance.getMaxHealth()/4)));
		assert(result.getHealth() <= (float)Math.ceil(1.2*(double)(3*instance.getMaxHealth()/4)));
		assert(result.getStamina() >= (float)Math.ceil(0.8*(double)(3*instance.getMaxStamina()/4)));
		assert(result.getStamina() <= (float)Math.ceil(1.2*(double)(3*instance.getMaxStamina()/4)));
		assert(result.getExperience() >= (int)Math.ceil(0.8*instance.getExperience()));
		assert(result.getExperience() <= (int)Math.ceil(1.2*instance.getExperience()));
		assert(result.getLevel() >= (int)Math.ceil(0.8*instance.getLevel()));
		assert(result.getLevel() <= (int)Math.ceil(1.2*instance.getLevel()));
		assert(result.getHunger() >= (float)Math.ceil(0.8*(double)(100/4)));
		assert(result.getHunger() <= (float)Math.ceil(1.2*(double)(100/4)));
		assert(result.getBladder() >= (float)Math.ceil(0.8*(double)(100/4)));
		assert(result.getBladder() <= (float)Math.ceil(1.2*(double)(100/4)));
		assert(result.getThirst() >= (float)Math.ceil(0.8*(double)(100/4)));
		assert(result.getThirst() <= (float)Math.ceil(1.2*(double)(100/4)));
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of fight method, of class UserDragon, if the UserDragon win.
	 */
	@Test
	public void testFightWin() {
		System.out.println("fight");
		Dragon withWho = new Dragon("enemy",81,83,25,63,27,3,778);
		UserDragon instance = new UserDragon("user",78,150,89,200,23,22,21,1,795,"pass",50,66);
		Event expResult = new Event();
		expResult.setType("WinFight");
		expResult.setMessage("Congrats! You Win.");
		float expExperience = instance.getExperience() + 200 + 30 * instance.getLevel();
		float expMoneyMin = instance.getMoney() + 100;
		float expMoneyMax = instance.getMoney() + 500;
		float expStamina = instance.getStamina() - (20 * instance.getLevel());
		Event result = instance.fight(withWho);
		assert(instance.getMoney() >= expMoneyMin);
		assert(instance.getMoney() <= expMoneyMax);
		assertEquals(expExperience, instance.getExperience(), 0.0);
		assertEquals(expStamina, instance.getStamina(), 0.0);
		assertEquals(expResult.getMessage(), result.getMessage());
		assertEquals(expResult.getType(), result.getType());
	}

	/**
	 * Test of fight method, of class UserDragon, if the result is draw.
	 */
	@Test
	public void testFightDraw() {
		System.out.println("fight");
		Dragon withWho = new Dragon("enemy",81,89,25,51,27,1,778);
		UserDragon instance = new UserDragon("user",81,150,89,200,25,51,27,1,778,"pass",50,66);
		Event expResult = new Event();
		expResult.setType("DrawFight");
		expResult.setMessage("This fight is a Draw.");
		float expExperience = instance.getExperience() + 25 * instance.getLevel();
        float expStamina = instance.getStamina() - (20 * instance.getLevel());
		Event result = instance.fight(withWho);
		assertEquals(expExperience, instance.getExperience(), 0.0);
		assertEquals(expStamina, instance.getStamina(), 0.0);
		assertEquals(expResult.getMessage(), result.getMessage());
		assertEquals(expResult.getType(), result.getType());
	}
	
	/**
	 * Test of fight method, of class UserDragon, if the UserDragon lose.
	 */
	@Test
	public void testFightLose() {
		System.out.println("fight");
		Dragon withWho = new Dragon("enemy",81,83,25,63,27,3,778);
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,1,795,"pass",50,66);
		Event expResult = new Event();
		expResult.setType("LoseFight");
		expResult.setMessage("Sorry! You Lose.");
		float expExperience = instance.getExperience() + 20 * instance.getLevel();
		float expStamina = instance.getStamina() - (20 * instance.getLevel());
		Event result = instance.fight(withWho);
		assertEquals(expExperience, instance.getExperience(), 0.0);
		assertEquals(expStamina, instance.getStamina(), 0.0);
		assertEquals(expResult.getMessage(), result.getMessage());
		assertEquals(expResult.getType(), result.getType());
	}
	
	/**
	 * Test of entertain method, of class UserDragon.
	 */
	@Test
	public void testEntertain() {
		System.out.println("entertain");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,26);
		float initHappiness = instance.getHappiness();
		Event expResult = new Event("Proses Selesai","The dragon is now more entertained");
		Event result = instance.entertain();
		assertEquals(expResult.getMessage(), result.getMessage());
		assertEquals(expResult.getType(), result.getType());
		assert(instance.getHappiness() <= 100);
		assert(instance.getHappiness() > initHappiness);
	}

	/**
	 * Test of rest method, of class UserDragon.
	 */
	@Test
	public void testRest() {
		System.out.println("rest");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		float expStamina = instance.getMaxStamina();
		float expHealth = instance.getMaxHealth();
		Event expResult = new Event("Proses Selesai","The dragon feels well-rested");
		Event result = instance.rest();
		assertEquals(expResult.getMessage(), result.getMessage());
		assertEquals(expResult.getType(), result.getType());
		assertEquals(expStamina, instance.getStamina(), 0.0);
		assertEquals(expHealth, instance.getHealth(), 0.0);
	}

	/**
	 * Test of toToilet method, of class UserDragon.
	 */
	@Test
	public void testToToilet() {
		System.out.println("toToilet");
		UserDragon instance = new UserDragon("user",78,150,89,200,23,51,21,5,123,"pass",50,66);
		float expBladder = 0;
		Event expResult = new Event("Proses Selesai","The dragon's bladder is emptied.");
		Event result = instance.toToilet();
		assertEquals(expBladder, instance.getBladder(), 0.0);
		assertEquals(expResult.getMessage(), result.getMessage());
		assertEquals(expResult.getType(), result.getType());
	} 
	
}
