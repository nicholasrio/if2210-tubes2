package calogerusdraconis;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

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

/**
 *
 * @author WILLY
 */
public class InventoryDisplay extends JPanel {
	private ImageIcon[] image;
	public static Integer pilihan = null;
	public static UserDragon drgon = null;
	
	/**
	 * Constructor InventoryDisplay
	 * @param drg dragon yang ingin ditampilkan isi inventory nya.
	 */
	public InventoryDisplay(UserDragon drg) {
		if (drg == null) {
			setPreferredSize(new Dimension(100,1000));
		} else {
			setPreferredSize(new Dimension(100,1000));
			ArrayList<Consumable> ac = drg.getFdInventory();
			int jum = drg.getFdInventory().size();
			if (jum!=0) {
				image = new ImageIcon[jum];
				for (int i = 0; i < jum; ++i) {
					image[i] = new ImageIcon(getClass().getResource("/calogerusdraconis/" + ac.get(i).getImg()));
				}
			}
		}
	}
	
	/**
	 * Mengubah tampilan inventory jika terjadi perubahan terhadap inventory 
	 * @param ud dragon yang inventory-nya ditampilkan
	 * @param id display inventory sebelumnya
	 */
	public static void change (UserDragon ud, InventoryDisplay id) {
		drgon = ud;
		if (drgon == null) return;
		ArrayList<Consumable> ac = drgon.getFdInventory();
		int jum = drgon.getFdInventory().size();
		id.setPreferredSize(new Dimension(100,64*jum+10));
		if (jum!=0) {
			id.image = new ImageIcon[jum];
			for (int i = 0; i < jum; ++i) {
				id.image[i] = new ImageIcon(id.getClass().getResource("/calogerusdraconis/" + ac.get(i).getImg()));
			}
		} else id.image = null;
	}
	
	@Override
	/**
	 * Menampilkan gambar dan status dari seluruh consumable dalam inventory dragon
	 */
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image!=null) {
			for (int i = 0; i < image.length; ++i) {
				try {
					image[i].paintIcon(this, g, 0, i*64+10);
				} catch (Exception ex) {
				}
			}

			if(pilihan!=null) {
				int minus = 0;
				if (!(drgon.getFdInventory().size() == 1 || drgon.getFdInventory().size() == 2)) {
					if (pilihan == drgon.getFdInventory().size()-1) minus = 120;
					else if (pilihan == drgon.getFdInventory().size()-2) minus = 60;
				}
				try {
					synchronized(this) {
						g.drawString("Nama : "+drgon.getFdInventory().get(pilihan).getName(), 100 , pilihan*64+20-minus);
						g.drawString("Harga : "+drgon.getFdInventory().get(pilihan).getCost(), 100 , pilihan*64+40-minus);
						g.drawString("Happiness : "+drgon.getFdInventory().get(pilihan).getHappinessValue(), 100 , pilihan*64+60-minus);
						g.drawString("Health : "+drgon.getFdInventory().get(pilihan).getHealthValue(), 100 , pilihan*64+80-minus);
						g.drawString("MaxHealth : "+drgon.getFdInventory().get(pilihan).getMaxHealthValue(), 100 , pilihan*64+100-minus);
						g.drawString("Hunger : "+drgon.getFdInventory().get(pilihan).getHungerValue(), 100 , pilihan*64+120-minus);
						g.drawString("Stamina : "+drgon.getFdInventory().get(pilihan).getStaminaValue(), 100 , pilihan*64+140-minus);
						g.drawString("MaxStamina : "+drgon.getFdInventory().get(pilihan).getMaxStaminaValue(), 100 , pilihan*64+160-minus);
						g.drawString("Thirst : "+drgon.getFdInventory().get(pilihan).getThirstValue(), 100 , pilihan*64+180-minus);
					}
				} catch (IndexOutOfBoundsException e) {

				}
			}
		}
		repaint();
	}
}
