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
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.DA1CAA8E-DC4F-B1A6-2BEB-CD5E1F104533]
// </editor-fold> 
public class Main {

	// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
	// #[regen=yes,id=DCE.63CA2664-F119-3E4F-70B9-EBE581D09D8B]
	// </editor-fold> 
	public Dragon draco;

	// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
	// #[regen=yes,id=DCE.0BE79718-C1E2-6BA1-97AA-29B6F470E4CF]
	// </editor-fold> 
	public Main() {

	}

	public static void main(String[] args) {
		UserDragon ud = new UserDragon("S", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0);
		try {
			sleep(10000);
		} catch (InterruptedException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		ud.sebelumExit();
	}

	// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
	// #[regen=yes,id=DCE.300DE1C1-8FFF-9876-186B-6A300231FB80]
	// </editor-fold> 
	public void newGame() {
	}

	// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
	// #[regen=yes,id=DCE.A635F2FE-A9F8-36AD-47CE-2F0270215A08]
	// </editor-fold> 
	public void loadGame() {
	}

	// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
	// #[regen=yes,regenBody=yes,id=DCE.80151BEA-D69C-3C3E-5363-37DFEC7601CC]
	// </editor-fold> 
	public Dragon getDraco() {
		return draco;
	}

	// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
	// #[regen=yes,regenBody=yes,id=DCE.1EFC7D1A-E329-168A-3331-F1511B338D84]
	// </editor-fold> 
	public void setDraco(Dragon val) {
		this.draco = val;
	}
}
