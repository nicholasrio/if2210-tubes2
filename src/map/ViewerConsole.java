/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

import java.awt.Graphics;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Calvin
 */
public class ViewerConsole {
    // Melihat map tanpa memperhitungkan visibilitas
    public static void viewWithoutVisiblity(PrintStream out,Map M){
        for (int y = 0; y < M.ysize; y++){
            for (int x = 0; x < M.xsize; x++){
                //System.out.print(getCell(x, y));
                switch(M.getCell(x, y).getId()){
                case Tile.tileUnused:
                        out.print(" ");
                        break;
                case Tile.tileDirtWall:
                        out.print("+");
                        break;
                case Tile.tileDirtFloor:
                        out.print(".");
                        break;
                case Tile.tileStoneWall:
                        out.print("O");
                        break;
                case Tile.tileCorridor:
                        out.print("#");
                        break;
                case Tile.tileDoor:
                        out.print("D");
                        break;
                case Tile.tileUpStairs:
                        out.print("<");
                        break;
                case Tile.tileDownStairs:
                        out.print(">");
                        break;
                case Tile.tileChest:
                        out.print("*");
                        break;
                };
            }
            out.println();
        }
    }
    
    //melihat map
    public static void view(PrintStream out,Map M){
        for (int y = 0; y < M.ysize; y++){
            for (int x = 0; x < M.xsize; x++){
                if (!M.isVisible(x, y)) {out.print("X"); continue;}
                switch(M.getCell(x, y).getId()){
                case Tile.tileUnused:
                        out.print(" ");
                        break;
                case Tile.tileDirtWall:
                        out.print("+");
                        break;
                case Tile.tileDirtFloor:
                        out.print(".");
                        break;
                case Tile.tileStoneWall:
                        out.print("O");
                        break;
                case Tile.tileCorridor:
                        out.print("#");
                        break;
                case Tile.tileDoor:
                        out.print("D");
                        break;
                case Tile.tileUpStairs:
                        out.print("<");
                        break;
                case Tile.tileDownStairs:
                        out.print(">");
                        break;
                case Tile.tileChest:
                        out.print("*");
                        break;
                }
            }
            out.println();
        }
    }
    
    // menampilkan map mulai dengan posisi Left Top (x,y) 
    // dengan lebar dan tinggi yang bersesuaian
    public static void view(PrintStream out,Map M, int x1, int y1
                            ,int width, int height){
        assert(x1+width+1 <= M.xsize);
        assert(y1+height+1 <= M.ysize);
        assert(width > 0);
        assert(height > 0);
        for (int y = y1; y < y1 + height; y++){
            for (int x = x1; x < x1 + width; x++){
                if (!M.isVisible(x, y)) {out.print("X"); continue;}
                switch(M.getCell(x, y).getId()){
                case Tile.tileUnused:
                        out.print(" ");
                        break;
                case Tile.tileDirtWall:
                        out.print("+");
                        break;
                case Tile.tileDirtFloor:
                        out.print(".");
                        break;
                case Tile.tileStoneWall:
                        out.print("O");
                        break;
                case Tile.tileCorridor:
                        out.print("#");
                        break;
                case Tile.tileDoor:
                        out.print("D");
                        break;
                case Tile.tileUpStairs:
                        out.print("<");
                        break;
                case Tile.tileDownStairs:
                        out.print(">");
                        break;
                case Tile.tileChest:
                        out.print("*");
                        break;
                }
            }
            out.println();
        }
    }
}
