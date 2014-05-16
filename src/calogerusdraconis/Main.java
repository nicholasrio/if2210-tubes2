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
		ud = new UserDragon("S", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0);

		try {
			ud = instance.LoadDragon("Xanareth");
			int menu = 0;
			do {
				view.showMenu();
				System.out.println("Input menu yang diinginkan : ");
				menu = in.nextInt();
				switch (menu) {
					case 1: view.UpdateScreen(ud); break;
					case 2: Event e = ud.entertain();
							view.UpdateScreen(ud, e); break;
					case 3: e = ud.rest();
							view.UpdateScreen(ud, e); break;
					case 4: e = ud.toToilet();
							view.UpdateScreen(ud, e); break;
					case 5: Dragon enemy = ud.generateEnemy();
							e = ud.fight(enemy); 
							view.UpdateScreen(ud, enemy);
							view.UpdateScreen(ud, e);
							break;
					case 6: e = ud.train();
							view.UpdateScreen(ud, e); break;
					case 7: {
								int pil7;
								int jum; int pilExit;
								do {
									view.seeFoodDirectory(ud);
									jum = ud.getFdInventory().size();
									if (jum==0) {
										System.out.println("Tidak ada barang yang anda miliki");
									} else {
										System.out.println("Tekan 1 sampai " + jum + " untuk menggunakan barang sesuai pilihan");
									}
									pilExit = jum + 1;
									System.out.println("Tekan " + pilExit + " untuk keluar");
									pil7 = in.nextInt();
									if (pil7 > pilExit || pil7 < 1) {
										System.out.println("Pilihan salah!");
									} else {
										ud.useConsumable(ud.getFdInventory().get(pil7));
										System.out.println("Anda berhasil menggunakan barang dengan nomor " + pil7);
									}
								} while(pil7!=pilExit);
								break;
							}
					case 8: {
								int pil8;
								int jum; int pilExit;
								do {
									view.UpdateScreen(Store.getInstance());
									jum = Store.getInstance().getFdInventory().size();
									if (jum==0) {
										System.out.println("Tidak ada barang di Store");
									} else {
										System.out.println("Tekan 1 sampai " + jum + " untuk membeli barang sesuai pilihan");
									}
									pilExit = jum + 1;
									System.out.println("Tekan " + pilExit + " untuk keluar");
									pil8 = in.nextInt();
									if (pil8 > pilExit || pil8 < 1) {
										System.out.println("Pilihan salah!");
									} else {
										try {
											ud.addConsumable(Store.getInstance().buy(jum));
											System.out.println("Anda berhasil membeli barang dengan nomor " + pil8);
										} catch (Exception ex) {
											System.out.println(ex.getMessage());
										}
									}
								} while(pil8!=pilExit);
								break;
							}
					default: break;
				}
				//view.UpdateScreen(Store.getInstance());
			} while (menu != 9);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		ud.sebelumExit();
		System.exit(0);
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
