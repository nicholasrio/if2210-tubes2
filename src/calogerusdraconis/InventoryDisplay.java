package calogerusdraconis;


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

/**
 *
 * @author WILLY
 */
public class InventoryDisplay extends JPanel {
	private ImageIcon[] image;
	public InventoryDisplay() {
		try {
			UserDragon drg = new XmlController().LoadDragon("Xanareth", "anotherPass");
			ArrayList<Consumable> ac = drg.getFdInventory();
			int jum = drg.getFdInventory().size();
			if (jum!=0) {
				image = new ImageIcon[jum];
				for (int i = 0; i < jum; ++i) {
					image[i] = new ImageIcon(getClass().getResource("/calogerusdraconis/" + ac.get(i).getImg()));
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(InventoryDisplay.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
		if (image==null) return;
		for (int i = 0; i < image.length; ++i) {
			image[i].paintIcon(this, g, 0, i*64+10);
		}
	}
}
