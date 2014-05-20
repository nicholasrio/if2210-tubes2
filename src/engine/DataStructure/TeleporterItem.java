/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.DataStructure;

import engine.SoundManager;

/**
 *
 * @author Winson
 */
public class TeleporterItem extends GameItem{
    private Location arrivalLocation;
    
    public TeleporterItem(Location L){
        super("teleporter");
        arrivalLocation = L;
    }
    
    /**
     * Get teleport arrive location
     * @return arrive location
     */
    public Location getArrivalLocation(){
        return arrivalLocation;
    }
    
    public void Draw(CLICanvas canvas, int row, int col){
        canvas.setCanvasPixel(row, col, '[');
        canvas.setCanvasPixel(row, col+1, ' ');
        canvas.setCanvasPixel(row, col+2, ']');
        canvas.setCanvasPixel(row+1, col, '[');
        canvas.setCanvasPixel(row+1, col+1, ' ');
        canvas.setCanvasPixel(row+1, col+2, ']');
        canvas.setCanvasPixel(row+2, col, '-');
        canvas.setCanvasPixel(row+2, col+1, '-');
        canvas.setCanvasPixel(row+2, col+2, '-');
    }
    
    public void makeSound(){
        SoundManager.playSound("teleport");
    }
}
