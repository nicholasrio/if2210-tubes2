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

    public String getImg () {
        return img;
    }

    public void setImg (String val) {
        this.img = val;
    }

    public String getName () {
        return name;
    }
	
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
	
	public float getStaminaValue() {
		return stamina;
	}
	
	public float getMaxHealthValue() {
		return maxHealth;
	}
	
	public float getMaxStaminaValue() {
		return maxStamina;
	}
	
	public float getHappinessValue() {
		return happiness;
	} 
}

