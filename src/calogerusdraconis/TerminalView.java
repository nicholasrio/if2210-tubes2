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
		System.out.println(drg.getName()+"'s Attribute: ");
		System.out.println(drg.getLevel());
		System.out.println(drg.getExperience());
		System.out.println(drg.getHappiness());
		System.out.println(drg.getBladder());
		System.out.println(drg.getThirst());
		System.out.println(drg.getHealth());
		System.out.println(drg.getMaxHealth());
		System.out.println(drg.getStamina());
		System.out.println(drg.getMaxStamina());
		System.out.println(drg.getMoney());
	}

	@Override
    public void UpdateScreen (Store str) {
		for (Consumable c : str.getFdInventory()) {
			System.out.println(c);
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

	@Override
	public void seeFoodDirectory(UserDragon drg) {
		ArrayList<Consumable> ac = drg.getFdInventory();
		for (Consumable c : ac) {
			System.out.println(c.getName());
		}
	}
	
}

