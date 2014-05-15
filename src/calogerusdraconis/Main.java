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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public Dragon draco;

	public Main() {

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Tekan 1 untuk GUI atau tekan 2 untuk Terminal: ");
		//int pil = in.nextInt();
		View view = null;
		//if (pil == 2)
		view = new TerminalView();
		
		XmlController instance = new XmlController();
		UserDragon ud = null;
		try {
			ud = instance.LoadDragon("Xanareth");
			int menu = 0;
			do {
				view.showMenu();
				System.out.println("Input menu yang diinginkan : ");
				menu = in.nextInt();
				switch (menu) {
					case 1: view.UpdateScreen(ud); break;
				}
				//view.UpdateScreen(Store.getInstance());
			} while (menu != 9);
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
