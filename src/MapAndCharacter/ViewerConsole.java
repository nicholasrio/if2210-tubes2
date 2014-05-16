/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapAndCharacter;

import character.Character;
import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Calvin
 */
public class ViewerConsole {
    public static void view(PrintStream out,MapAdapter MA){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        map.ViewerConsole.view(ps,MA.getMap());
        StringBuffer content = new StringBuffer();
        try {
            content = new StringBuffer(baos.toString("ASCII"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ViewerConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        //!!Gambar Orang Disini
        for (int i = 0; i < MA.getAllCharacter().size(); i++){
            Point pos = MA.getPos(i);
            int xsize = MA.getMap().xsize;
            int oneLineLength = xsize + 2;
            if (MA.getMap().isVisible(pos.x, pos.y)){
                content.replace(pos.y*(oneLineLength)+pos.x,1,"" + drawCharacter(MA.getCharByIndeks(i)));
            }
        }
        out.print(content.toString());    
    }
    
    public static void viewWithoutVisiblity(PrintStream out,MapAdapter MA){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        map.ViewerConsole.viewWithoutVisiblity(ps,MA.getMap());
        StringBuffer content = new StringBuffer();
        try {
            content = new StringBuffer(baos.toString("ASCII"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ViewerConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        //!!Gambar Orang Disini
        for (int i = 0; i < MA.getAllCharacter().size(); i++){
            Point pos = MA.getPos(i);
            int xsize = MA.getMap().xsize;
            int oneLineLength = xsize + 2;
            content.replace(pos.y*(oneLineLength)+pos.x,pos.y*(oneLineLength)+pos.x+1,"" + drawCharacter(MA.getCharByIndeks(i)));
        }
        out.print(content.toString());
    }
    
    // menampilkan map mulai dengan posisi Left Top (x,y) 
    // dengan lebar dan tinggi yang bersesuaian
    public static void view(PrintStream out,MapAdapter MA, int x1, int y1
                            ,int width, int height){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        map.ViewerConsole.view(ps,MA.getMap(),x1,y1,width,height);
        StringBuffer content = new StringBuffer();
        try {
            content = new StringBuffer(baos.toString("ASCII"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ViewerConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        //!!Gambar Orang Disini
        for (int i = 0; i < MA.getAllCharacter().size(); i++){
            Point mapPos = MA.getPos(i);
            if (mapPos.x < x1 || mapPos.x>x1+width-1
                    || mapPos.y < y1 || mapPos.y>y1+width-1){
                continue;
            }
            int xsize = MA.getMap().xsize;
            int oneLineLength = xsize + 2;
            int printPos = (mapPos.y-y1)*(oneLineLength)+(mapPos.x-x1);
            content.replace(printPos,1,"" + drawCharacter(MA.getCharByIndeks(i)));
        }
        out.print(content.toString());
    }
    
    //STUB
    private static char drawCharacter(Character charByIndeks) {
        return 'C';
    }
}
