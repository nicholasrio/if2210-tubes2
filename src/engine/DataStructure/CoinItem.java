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
public class CoinItem extends GameItem {
    public CoinItem(){
        super("coin");
    }
    public void Draw(CLICanvas canvas, int row, int col){
        for(int i=0;i<3;i++)
           for(int j=0;j<3;j++){
               canvas.setCanvasPixel(row+i, col+j, ' ');
           }
        canvas.setCanvasPixel(row+1, col+1, '*');
    }
    public void makeSound(){
        SoundManager.playSound("coin");
    }
}
