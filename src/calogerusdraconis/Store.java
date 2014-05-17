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

import java.util.ArrayList; 

public class Store {

    private ArrayList<Consumable> fdInventory;
	
	private static Store s = new Store();
	
	/**
	 * Constructor Store
	 */
    private Store () {
		fdInventory = new ArrayList<>();
		fdInventory.add(new Consumable("first-aid","res/first-aid.png",200,0,0,300,0,0,0,0));
		fdInventory.add(new Consumable("potion","res/potion.png",250,0,0,400,0,0,0,0));
		fdInventory.add(new Consumable("hi-potion","res/hi-potion.png",500,0,0,600,0,0,0,0));
		fdInventory.add(new Consumable("x-potion","res/ex-potion.png",1000,0,0,1000,0,0,0,0));
		fdInventory.add(new Consumable("ether","res/ether.png",0,0,0,300,200,0,0,0));
		fdInventory.add(new Consumable("hi-ether","res/hi-ether.png",0,0,0,600,500,0,0,0));
		fdInventory.add(new Consumable("ex-ether","res/ex-ether.png",0,0,0,1000,1000,0,0,0));
		fdInventory.add(new Consumable("elixir","res/elixir.png",1500,0,0,1700,1500,0,0,0));
		fdInventory.add(new Consumable("shard of fire heart","res/shard-of-fire-heart.png",0,0,0,1000000,0,100,0,0));
		fdInventory.add(new Consumable("sacred root","res/sacred-root.png",0,0,0,500000,0,0,10,0));
		fdInventory.add(new Consumable("candy","res/candy.png",0,5,-20,100,0,0,0,40));
		fdInventory.add(new Consumable("orange","res/orange.png",50,-20,-30,250,0,0,0,0));
		fdInventory.add(new Consumable("meat","res/meat.png",100,10,-60,300,0,0,0,30));
		fdInventory.add(new Consumable("juice","res/juice.png",0,-40,0,200,30,0,0,0));
		fdInventory.add(new Consumable("milk","res/milk.png",150,-50,-10,400,20,0,0,0));
		fdInventory.add(new Consumable("eggroll","res/egg-roll.png",0,0,-50,250,25,0,0,0));
		fdInventory.add(new Consumable("peanut","res/peanut.png",100,0,-10,200,0,0,0,20));
		fdInventory.add(new Consumable("pill","res/pill.png",30,0,-30,250,30,0,0,-30));
	}
	
	/**
	 * Getter Instance
	 * @return store 
	 */
	public static Store getInstance() {
		return s;
	}

	/**
	 * Getter inventory
	 * @return array inventory
	 */
    public ArrayList<Consumable> getFdInventory () {
        return fdInventory;
    }

	/**
	 * Setter inventory
	 * @param val new inventory of Store
	 */
    public void setFdInventory (ArrayList<Consumable> val) {
        this.fdInventory = val;
    }
	
	/**
	 * Membeli Consumable dari Store
	 * @param arrLoc posisi Consumable yang akan dibeli
	 * @return Consumable yang dibeli
	 */
    public Consumable buy (int arrLoc) {
		int idx = arrLoc - 1;
        return fdInventory.get(idx);
    }
}

