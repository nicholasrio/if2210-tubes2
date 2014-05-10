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


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.8C0A9E96-A0E7-4807-A522-F6B14E09C50C]
// </editor-fold> 
public final class Consumable {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.86F6A278-9B7D-6DDB-EDA6-9A84D27CD125]
    // </editor-fold> 
    private String name;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D15787C4-332B-20A0-16ED-013269409DAD]
    // </editor-fold> 
    private String img;
	
	private float health;
	private float thirst;
	private float hunger;
	private float cost;
	
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F03DB0AA-CF3F-89E5-39C3-F3B3682E7B01]
    // </editor-fold> 
    public Consumable (String name, String img, float health, float thirst, float hunger, float cost) {
        this.name = name;
        this.img = img;
		this.health = health;
		this.thirst = thirst;
		this.hunger = hunger;
		this.cost = cost;
	}

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C5B6B673-F75B-9DC3-6EDB-CF4CD4C391D2]
    // </editor-fold> 
    public String getImg () {
        return img;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2BAEFB0D-A6EE-7659-6732-2C542110AF05]
    // </editor-fold> 
    public void setImg (String val) {
        this.img = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.51066AD5-031F-C47D-1755-8200DDE00E01]
    // </editor-fold> 
    public String getName () {
        return name;
    }
	
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DB401575-72EA-83C8-2ECF-AC0D5743D50B]
    // </editor-fold> 
    public void setName (String val) {
        this.name = val;
    }
	
	public float getHealthValue() {
		return health;
	}
	
	public float getThirstValue() {
		return thirst;
	}
	
	public float getHungerValue() {
		return hunger;
	}
	
	public float getCost() {
		return cost;
	}
}

