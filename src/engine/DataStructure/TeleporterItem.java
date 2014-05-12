/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.DataStructure;

/**
 *
 * @author Winson
 */
public class TeleporterItem extends GameItem{
    private Location arrivalLocation;
    
    public TeleporterItem(Location L){
        super("teleporter");
    }
    
    public Location getArrivalLocation(){
        return arrivalLocation;
    }
}
