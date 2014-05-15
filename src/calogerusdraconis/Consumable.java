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


public final class Consumable {

    private String name;

    private String img;
	
	private final float health;
	private final float thirst;
	private final float hunger;
	private final float cost;
	private final float stamina;
	private final float maxHealth;
	private final float maxStamina;
	private final float happiness;
	
	/**
	 * Constructor Consumable
	 * @param name		Name of Consumable
	 * @param img		Image path of Consumable
	 * @param health	Health point of Consumable
	 * @param thirst	Thirst point of Consumable
	 * @param hunger	Hunger point of Consumable
	 * @param cost		Cost of Consumable
	 * @param stamina	Stamina point of Consumable
	 * @param maxHealth maxHealth point of Consumable
	 * @param maxStamina maxStamina point of Consumable
	 * @param happiness Happiness point of Consumable
	 */
    public Consumable (String name, String img, float health, float thirst, float hunger, float cost, float stamina, float maxHealth, float maxStamina, float happiness) {
        this.name = name;
        this.img = img;
		this.health = health;
		this.thirst = thirst;
		this.hunger = hunger;
		this.cost = cost;
		this.stamina = stamina;
		this.maxHealth = maxHealth;
		this.maxStamina = maxStamina;
		this.happiness = happiness;
	}
	
	/**
	 * Getter Image path
	 * @return image path of consumable
	 */
    public String getImg () {
        return img;
    }

	/**
	 * Setter Image path
	 * @param val new image path of Consumable
	 */
    public void setImg (String val) {
        this.img = val;
    }
	
	/**
	 * Getter Name
	 * @return name of Consumable
	 */
    public String getName () {
        return name;
    }
	
	/**
	 * Setter Name
	 * @param val new name of Consumable
	 */
    public void setName (String val) {
        this.name = val;
    }
	
	/**
	 * Getter Health Value
	 * @return health point of Consumable
	 */
	public float getHealthValue() {
		return health;
	}
	
	/**
	 * Getter Thirst Value
	 * @return thirst point of Consumable
	 */
	public float getThirstValue() {
		return thirst;
	}
	
	/**
	 * Getter Hunger Value
	 * @return hunger point of Consumable
	 */
	public float getHungerValue() {
		return hunger;
	}
	
	/**
	 * Getter Cost
	 * @return cost of Consumable
	 */
	public float getCost() {
		return cost;
	}
	
	/**
	 * Getter Stamina Value
	 * @return stamina point of Consumable
	 */
	public float getStaminaValue() {
		return stamina;
	}
	
	/**
	 * Getter maxHealth Value
	 * @return maxHealth point of Consumable
	 */
	public float getMaxHealthValue() {
		return maxHealth;
	}
	
	/**
	 * Getter maxStamina Value
	 * @return maxStamina point of Consumable
	 */
	public float getMaxStaminaValue() {
		return maxStamina;
	}
	
	/**
	 * Getter Happiness Value
	 * @return happiness point of Consumable
	 */
	public float getHappinessValue() {
		return happiness;
	}
	
	@Override
	public String toString() {
		return("Nama : " + getName() + '\n' +
			   "Harga : " + getCost() + '\n' + 
			   "Happiness : " + getHappinessValue() + '\n' +
			   "Hunger : " + getHungerValue() + '\n' +
			   "Thirst : " + getThirstValue() + '\n' +
			   "Health : " + getHealthValue() + '\n' +
			   "MaxHealth : " + getMaxHealthValue() + '\n' +
			   "Stamina : " + getStaminaValue() + '\n' +
			   "MaxStamina : " + getMaxStaminaValue());
	}
}