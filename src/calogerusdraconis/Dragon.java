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
 * @author WILLY
 */
public class Dragon {
	
	/**
	 * Nama Dragon
	 */
    protected String name;

	/**
	 * Health Dragon
	 */
    protected float health;

	/**
	 * Stamina Dragon
	 */
    protected float stamina;

	/**
	 * Thirst Dragon
	 */
    protected float thirst;

	/**
	 * Bladder Dragon
	 */
    protected float bladder;

	/**
	 * Hunger Dragon
	 */
    protected float hunger;

	/**
	 * View Dragon
	 */
    protected int level;

	/**
	 * Experience Dragon
	 */
    protected int experience;

	/**
	 * Constructor of Dragon
	 * @param name		Name of Dragon
	 * @param health	Health point of Dragon
	 * @param stamina	Stamina point of Dragon
	 * @param thirst	Thirst point of Dragon
	 * @param bladder	Bladder point of Dragon
	 * @param hunger	Hunger point of Dragon
	 * @param level		Level of Dragon
	 * @param experience Experience point of Dragon
	 */
    public Dragon (String name, float health, float stamina, float thirst, float bladder, float hunger, int level, int experience) {
        this.name = name;
		this.health = health;
		this.stamina = stamina;
		this.thirst = thirst;
		this.bladder = bladder;
		this.hunger = hunger;
		this.level = level;
		this.experience = experience;
    }

	/**
	 * Getter Bladder
	 * @return bladder point of Dragon
	 */
    public float getBladder () {
        return bladder;
    }

	/**
	 * Getter Experience
	 * @return experience point of Dragon
	 */
    public int getExperience () {
        return experience;
    }

	/**
	 * Getter Health
	 * @return health point of Dragon
	 */
    public float getHealth () {
        return health;
    }
    
	/**
	 * Getter Hunger
	 * @return hunger point of Dragon
	 */
    public float getHunger () {
        return hunger;
    }

	/**
	 * Getter Level
	 * @return level of Dragon
	 */
    public int getLevel () {
        return level;
    }

	/**
	 * Setter Level
	 * @param val new level of Dragon
	 */
    public void setLevel (int val) {
        synchronized(this) {
            this.level = val;
        }
    }

	/**
	 * Getter Name
	 * @return name of Dragon
	 */
    public String getName () {
        return name;
    }

	/**
	 * Setter Name
	 * @param val new name of Dragon
	 */
    public void setName (String val) {
        this.name = val;
    }

	/**
	 * Getter Stamina
	 * @return stamina point of Dragon
	 */
    public float getStamina () {
        return stamina;
    }

	/**
	 * Getter Thirst
	 * @return thirst point of Dragon
	 */
    public float getThirst () {
        return thirst;
    }

}

