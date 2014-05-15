/*
 * Copyright (C) 2014 WILLY
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
 * @author WILLY
 */
public class ConsumableFactory {
	//private static final Store s = Store.getInstance();
	public static Consumable produceConsumable(String name) {
		Store s = Store.getInstance();
		ArrayList<Consumable> ac = s.getFdInventory();
		for (Consumable c : ac){
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}
}
