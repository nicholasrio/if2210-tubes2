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

/**
 *
 * @author Dariel Valdano
 */
public interface View {
	
	/**
	 * Menampilkan menu
	 */
	public void showMenu();
	
	/**
	 * Menampilkan Attribut Dragon ke Screen
	 * @param drg Dragon yang ingin ditampilkan
	 */
    public void UpdateScreen (UserDragon drg);

	/**
	 * Menampilkan Store ke Scren
	 * @param str Store yang ingin ditampilkan
	 */
    public void UpdateScreen (Store str);

	/**
	 * Menampilkan pertarungan dragon dan enemy ke screen
	 * @param drg dragon user
	 * @param enemy dragon enemy
	 */
    public void UpdateScreen (UserDragon drg, Dragon enemy);

	/**
	 * Menampilkan event yang didapatkan dragon
	 * @param drg dragon user
	 * @param evnt event yang didapatkan
	 */
    public void UpdateScreen (UserDragon drg, Event evnt);
	
	/**
	 * Menampikan food directory yang dimiliki Dragon
	 * @param drg Dragon user
	 */
	public void seeFoodDirectory (UserDragon drg);
}

