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
import java.util.Scanner;

public class Main {

	public static UserDragon draco;
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		if (args.length == 0) {
			gui();
		} else {
			switch (args[0]) {
				case "gui":
					gui();
					break;
				case "term":
					terminal();
					break;
				default:
					System.err.println("Arguments Invalid");
					break;
			}
		}
		System.exit(0);
	}
	
	/**
	 * Main program in terminal
	 */
	public static void terminal() {
		Scanner in = new Scanner(System.in);
		int loadNew = 0;
		do {
			System.out.println("Tekan 1 untuk New Game atau tekan 2 untuk Load Game:");
			loadNew = in.nextInt();
			if (!(loadNew==1 || loadNew==2)) {
				System.out.println("Input tidak valid. Ulangi!");
			}
		} while (!(loadNew==1 || loadNew==2));
		String nama;
		String password;
		System.out.println("Masukkan nama: ");
		nama = in.next();
		System.out.println("Masukkan password: ");
		password = in.next();
		View view = new TerminalView();

		try {
			if (loadNew == 2)
				draco = loadGame(nama, password);
			else draco = newGame(nama, password);
			int menu = 0;
			do {
				view.showMenu();
				System.out.println("Input menu yang diinginkan : ");
				menu = in.nextInt();
				switch (menu) {
					case 1: view.UpdateScreen(draco); break;
					case 2: Event e = draco.entertain();
							view.UpdateScreen(draco, e); break;
					case 3: e = draco.rest();
							view.UpdateScreen(draco, e); break;
					case 4: e = draco.toToilet();
							view.UpdateScreen(draco, e); break;
					case 5: Dragon enemy = draco.generateEnemy();
							e = draco.fight(enemy); 
							view.UpdateScreen(draco, enemy);
							view.UpdateScreen(draco, e);
							break;
					case 6: e = draco.train();
							view.UpdateScreen(draco, e); break;
					case 7: {
								int pil7;
								int jum; int pilExit;
								do {
									view.seeFoodDirectory(draco);
									jum = draco.getFdInventory().size();
									if (jum==0) {
										System.out.println("Tidak ada barang yang anda miliki");
									} else {
										System.out.println("Tekan 1 sampai " + jum + " untuk menggunakan barang sesuai pilihan");
									}
									pilExit = jum + 1;
									System.out.println("Tekan " + pilExit + " untuk keluar");
									pil7 = in.nextInt();
									System.out.println("pil7: " + pil7);
									if (pil7 > pilExit || pil7 < 1) {
										System.out.println("Pilihan salah!");
									} else if (pil7!=pilExit) {
										System.out.println("halo");
										draco.useConsumable(draco.getFdInventory().get(pil7-1));
										System.out.println("Anda berhasil menggunakan barang dengan nomor " + pil7);
									}
									System.out.println(pil7 + " " + pilExit);
								} while(pil7!=pilExit);
								System.out.println("keluar");
							}System.out.println("keluar1");
							break;
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
									} else if (pil8!=pilExit) {
										try {
											draco.addConsumable(Store.getInstance().buy(pil8-1));
											System.out.println("Anda berhasil membeli barang dengan nomor " + pil8);
										} catch (Exception ex) {
											System.out.println(ex.getMessage());
										}
									}
								} while(pil8!=pilExit);
							} break;
					case 9 : {
								XmlController.SaveDragon(draco);
							} break;
					default: break;
				}
				//System.out.println("menu " + menu);
			} while (menu != 10);
			draco.sebelumExit();
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	/**
	 * Main program in GUI
	 */
	public static void gui() {
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>
		
		GUIViewLogin GVL = new GUIViewLogin();
		draco = GVL.getDragon();
		
		final GUIView view = new GUIView();
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				view.setVisible(true);
				/*while (true) {
					try {
						sleep(300);
					} catch (InterruptedException ex) {
						Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
					}
					view.UpdateScreen(draco);
				}*/
			}
		};
		java.awt.EventQueue.invokeLater(thread);
		
		Thread updater;
		updater = new Thread() {
            @Override
            public void run() {
                try {
                    while(true) {
                        sleep(100);
                        view.UpdateScreen(draco);
                    }
                } catch (InterruptedException ex) {
                    System.out.println("interrupted");
                }
            }
        };
        updater.start();
		
		/*try {
			sleep(5000);
			mainGUI.UpdateScreen(draco);
			Scanner in = new Scanner(System.in);
			String a = in.next();
		} catch (InterruptedException e) {
			
		}*/
		view.UpdateScreen(Store.getInstance());
		view.UpdateScreen(draco);
		
		Event e;
		int selection;
		boolean willFight;
		do {
			selection = view.waitForSelection();
			switch (selection) {
				case 1:
					e = draco.entertain();
					view.UpdateScreen(draco, e);
					break;
				case 2:
					e = draco.train();
					view.UpdateScreen(draco, e);
					break;
				case 3:
					e = draco.rest();
					view.UpdateScreen(draco, e);
					break;
				case 4:
					e = draco.toToilet();
					view.UpdateScreen(draco, e);
					break;
				case 5:
					Dragon enemy = draco.generateEnemy();
					//view.UpdateScreen(draco, enemy); //not used due to the need of retval.
					final GUIViewFight fightView = new GUIViewFight(draco, enemy);
					Runnable fightThread = new Runnable() {
						@Override
						public void run() {
							fightView.setVisible(true);
						}
					};
					java.awt.EventQueue.invokeLater(fightThread);
					willFight = fightView.waitForSelection();
					if (willFight) {
						e = draco.fight(enemy);
						view.UpdateScreen(draco, e);
					}
					break;
				case 6:
					XmlController.SaveDragon(draco);
					break;
			}
		} while (selection != -1);
		XmlController.SaveDragon(draco);
		draco.sebelumExit();
	}

	/**
	 * Mengembalikan dragon baru di saat new game
	 * @param name		nama untuk dragon baru
	 * @param password	password untuk dragon baru
	 * @return			dragon baru yang dibuat
	 */
	public static UserDragon newGame(String name, String password) {
		return new UserDragon(name, 100, 100, 100, 100, 0, 0, 0, 1, 0, password, 100, 100);
	}

	/**
	 * Mengembalikan dragon lama di saat load game
	 * @param name		nama dari dragon lama
	 * @param password	password dari dragon lama
	 * @return			dragon lama yang ingin di-load
	 * @throws java.lang.Exception 
	 */
	public static UserDragon loadGame(String name, String password) throws Exception {
		XmlController instance = new XmlController();
		UserDragon ud = XmlController.LoadDragon(name, password);
		return ud;
	}
}
