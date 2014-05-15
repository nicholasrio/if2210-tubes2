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

/**
 *
 * @author Willy
 */
public class TerminalView implements View {
 
    public TerminalView () {
        super();
    }

	@Override
    public void UpdateScreen (UserDragon drg) {
		ArrayList<Consumable> ac = drg.getFdInventory();
		for (Consumable c : ac) {
			System.out.println(c.getName());
		}
	}

	@Override
    public void UpdateScreen (Store str) {
		for (Consumable c : str.getFdInventory()) {
			System.out.println("Nama : " + c.getName());
			System.out.println("Harga : " + c.getCost());
			System.out.println("Happiness : " + c.getHappinessValue());
			System.out.println("Hunger : " + c.getHungerValue());
			System.out.println("Thirst : " + c.getThirstValue());
			System.out.println("Health : " + c.getHealthValue());
			System.out.println("MaxHealth : " + c.getMaxHealthValue());
			System.out.println("Stamina : " + c.getStaminaValue());
			System.out.println("MaxStamina : " + c.getMaxStaminaValue());
			System.out.println();
		}
    }

	@Override
    public void UpdateScreen (UserDragon drg, Dragon enemy) {
		
    }

	@Override
    public void UpdateScreen (UserDragon drg, Event evnt) {
		System.out.println(evnt.getMessage());
    }
	
	public void showMenu () {
		System.out.println("Piliah menu: ");
		System.out.println("1. See Attribute");
		System.out.println("2. Entertain");
		System.out.println("3. Rest");
		System.out.println("4. Go to toilet");
		System.out.println("5. Fight");
		System.out.println("6. Train");
		System.out.println("7. See Food Directory");
		System.out.println("8. Go to Store");
		System.out.println("9. Exit");
	}
	
}

