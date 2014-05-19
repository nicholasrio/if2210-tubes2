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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author WILLY
 */
public class utilTest {
	
	/**
	 * Test of randomInt method, of class util.
	 */
	@Test
	public void testRandomInt() {
		System.out.println("randomInt");
		
		for (int min = 0; min <= 1000; ++min) {
			for (int max = min; max <= 1000; ++max) { 
				int expResult = 0;
				int result = util.randomInt(min, max);
				assert(min <= result && max >= result);
			}
		}
	}

	/**
	 * Test of gaussBasedOn method, of class util.
	 */
	@Test
	public void testGaussBasedOn() {
		System.out.println("gaussBasedOn");
		for (double value = 0; value <= 1000; ++value) {
			float result = util.gaussBasedOn(value);
			if (Math.abs((float)Math.ceil(value*0.8)-result) < 0.00000000001) continue;
			if (Math.abs((float)Math.ceil(value*1.2)-result) < 0.00000000001) continue;
			assert(Math.ceil(value*0.8) <= result && Math.ceil(value*1.2) >= result);
		}
	}
}
