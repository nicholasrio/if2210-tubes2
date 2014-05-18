package calogerusdraconis;


import javax.swing.JPanel;

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

/**
 *
 * @author WILLY
 */
public class StoreDisplay extends JPanel {
	private ImageIcon[] image;
	private ArrayList<Consumable> ac;
	public static Integer pilihan = null;
	public StoreDisplay(Store st) {
		ac = st.getFdInventory();
		
		int jum = ac.size();
		setPreferredSize(new Dimension(100,64*jum+10));
		image = new ImageIcon[jum];
		for (int i = 0; i < jum; ++i) {
			image[i] = new ImageIcon(getClass().getResource("/calogerusdraconis/" + ac.get(i).getImg()));
		}
	}
	
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image!=null) {
			for (int i = 0; i < image.length; ++i) {
				image[i].paintIcon(this, g, 0, i*64+10);
			}
			if(pilihan!=null) {
				int minus = 0;
				if (pilihan == ac.size()-1) minus = 120;
				else if (pilihan == ac.size()-2) minus = 60;
				else if (pilihan == 0) minus = -10;
				try{
					synchronized (this) {
						g.drawString("Nama : "+ac.get(pilihan).getName(), 100 , pilihan*64+20-minus);
						g.drawString("Harga : "+ac.get(pilihan).getCost(), 100 , pilihan*64+40-minus);
						g.drawString("Happiness : "+ac.get(pilihan).getHappinessValue(), 100 , pilihan*64+60-minus);
						g.drawString("Health : "+ac.get(pilihan).getHealthValue(), 100 , pilihan*64+80-minus);
						g.drawString("MaxHealth : "+ac.get(pilihan).getMaxHealthValue(), 100 , pilihan*64+100-minus);
						g.drawString("Hunger : "+ac.get(pilihan).getHungerValue(), 100 , pilihan*64+120-minus);
						g.drawString("Stamina : "+ac.get(pilihan).getStaminaValue(), 100 , pilihan*64+140-minus);
						g.drawString("MaxStamina : "+ac.get(pilihan).getMaxStaminaValue(), 100 , pilihan*64+160-minus);
						g.drawString("Thirst : "+ac.get(pilihan).getThirstValue(), 100 , pilihan*64+180-minus);
					}
				} catch (Exception e) {
					
				}
			}
		}
		repaint();
	}
}
