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
	/**
	 * Print status Dragon ke layar
	 */
    public void UpdateScreen (UserDragon drg) {
		System.out.println(drg.getName()+"'s Attribute: ");
		System.out.println("Level: " + drg.getLevel());
		System.out.println("Experience: " + drg.getExperience());
		System.out.println("Happiness: " + drg.getHappiness());
		System.out.println("Bladder: " + drg.getBladder());
		System.out.println("Thirst: " + drg.getThirst());
		System.out.println("Hunger: " + drg.getHunger());
		System.out.println("Health: " + drg.getHealth());
		System.out.println("Max Health: " + drg.getMaxHealth());
		System.out.println("Stamina: " + drg.getStamina());
		System.out.println("MaxStamina: " + drg.getMaxStamina());
		System.out.println("Money: " + drg.getMoney());
	}

	@Override
	/**
	 * Print daftar consumable di store ke layar
	 */
    public void UpdateScreen (Store str) {
		int i = 0;
		if (str.getFdInventory() == null) return;
		for (Consumable c : str.getFdInventory()) {
			++i;
			System.out.println(i + ". " + c);
			System.out.println();
		}
    }

	@Override
	/**
	 * Print event saat dragon fight
	 */
    public void UpdateScreen (UserDragon drg, Dragon enemy) {
		System.out.println("Dragon anda sedang melawan musuh");
    }

	@Override
	/**
	 * Print event yang telah dilakukan Dragon
	 */
    public void UpdateScreen (UserDragon drg, Event evnt) {
		System.out.println(evnt.getMessage());
    }
	
	/**
	 * Print pilihan menu ke layar
	 */
	public void showMenu () {
		System.out.println("Pilihan menu: ");
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

	@Override
	/**
	 * Print daftar consumable yang dimiliki Dragon
	 */
	public void seeFoodDirectory(UserDragon drg) {
		int i = 0;
		ArrayList<Consumable> ac = drg.getFdInventory();
		if (ac == null) return;
		for (Consumable c : ac) {
			++i;
			System.out.println(i + ". "  + c.getName());
		}
	}
	
}

