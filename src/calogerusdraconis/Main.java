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

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public Dragon draco;

	public Main() {

	}

	public static void main(String[] args) {
		XmlController instance = new XmlController();
		UserDragon ud = null;
		try {
			ud = instance.LoadDragon("Xanareth");
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		ud.sebelumExit();
	}

	/**
	 * 
	 */
	public void newGame() {
	}

	/**
	 * 
	 */
	public void loadGame() {
	}

	/**
	 * Getter Dragon
	 * @return Dragon of user
	 */

	public Dragon getDraco() {
		return draco;
	}

	/**
	 * Setter Dragon
	 * @param val new Dragon of User
	 */
	public void setDraco(Dragon val) {
		this.draco = val;
	}
}
