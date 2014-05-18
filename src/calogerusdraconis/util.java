/*
 * Copyright (C) 2014 dalva
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

import java.util.Random;

public class util {
	
	/**
	 * Mengembalikan random integer pada range input
	 * @param min  batas minimal hasil random
	 * @param max  batas maksimal hasil random
	 * @return	hasil random integer
	 */
	public static int randomInt(int min, int max) {
		return new Random().nextInt((max - min) + 1) + min;
	}
	
	/**
	 * Mengembalikan gaussian random sekitar value
	 * @param value  value pembanding
	 * @return	hasil random integer
	 */
	public static float gaussBasedOn(double value) {
		Random rand = new Random();
		double x = rand.nextGaussian();
		if (x > 1.0) x = 1.0; else if (x < -1.0) x = -1.0;
        return (float) Math.ceil(x*(0.2*value)+value);
	}
}
