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

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E6BDD020-1BE0-47FA-DEC1-23321E47E085]
// </editor-fold> 
public final class Store {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F02D507C-955C-E473-70F5-66CF2BE0A57E]
    // </editor-fold> 
    private ArrayList<Consumable> fdInventory;
	
	private Store s = new Store();
	
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0162CBAA-064B-21DC-586A-5086BCF89195]
    // </editor-fold> 
    private Store () {
		s.fdInventory.add(new Consumable("first-aid","",200,0,0,300,0,0,0));
		fdInventory.add(new Consumable("potion","",250,0,0,400,0,0,0));
		fdInventory.add(new Consumable("hi-potion","",500,0,0,600,0,0,0));
		fdInventory.add(new Consumable("x-potion","",1000,0,0,1000,0,0,0));
		fdInventory.add(new Consumable("ether","",0,0,0,300,200,0,0));
		fdInventory.add(new Consumable("hi-ether","",0,0,0,600,500,0,0));
		fdInventory.add(new Consumable("ex-ether","",0,0,0,1000,1000,0,0));
		fdInventory.add(new Consumable("elixir","",1500,0,0,1700,1500,0,0));
		fdInventory.add(new Consumable("shard of fire heart","",0,0,0,1000000,0,100,0));
		fdInventory.add(new Consumable("sacred root","",0,0,0,500000,0,0,10));
		fdInventory.add(new Consumable("candy","",0,0,-20,100,0,0,0));
		fdInventory.add(new Consumable("orange","",0,-20,-30,250,0,0,0));
		fdInventory.add(new Consumable("meat","",0,10,-60,300,0,0,0));
		fdInventory.add(new Consumable("juice","",0,-40,0,200,0,0,0));
		fdInventory.add(new Consumable("milk","",0,-50,-10,400,0,0,0));
	}
	
	public Store getInstance() {
		return s;
	}

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5BA2A08B-741C-A0B6-B5B5-84388C3CA7EC]
    // </editor-fold> 
    public ArrayList<Consumable> getFdInventory () {
        return fdInventory;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4AC594BD-9B48-8604-6DC2-329B93CE310C]
    // </editor-fold> 
    public void setFdInventory (ArrayList<Consumable> val) {
        this.fdInventory = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.51BC2E63-3236-4A18-2895-B470C93E454E]
    // </editor-fold> 
    public Consumable buy (int arrLoc) {
        return null;
    }

}

