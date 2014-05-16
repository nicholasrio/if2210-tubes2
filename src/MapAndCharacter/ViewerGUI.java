/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapAndCharacter;

import java.awt.Graphics;

/**
 *
 * @author Calvin
 */
public class ViewerGUI {
    public static void view(Graphics g,MapAdapter MA){
        map.ViewerGUI.view(g,MA.getMap());
        //!!Gambar Orang Disini
    }
    
    public static void viewWithoutVisiblity(Graphics g,MapAdapter MA){
        map.ViewerGUI.viewWithoutVisiblity(g,MA.getMap());
        //!!Gambar Orang Disini
    }
    
    // menampilkan map mulai dengan posisi Left Top (x,y) 
    // dengan lebar dan tinggi yang bersesuaian
    public static void view(Graphics g,MapAdapter MA, int x1, int y1
                            ,int width, int height){
        map.ViewerGUI.view(g,MA.getMap(),x1,y1,width,height);
        //!!Gambar Orang Disini
    }
}
