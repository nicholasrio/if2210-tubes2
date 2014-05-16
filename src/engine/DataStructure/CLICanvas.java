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
public class CLICanvas {
    private final int MAXROWSIZE;
    private final int MAXCOLSIZE;
    private char[][] drawBuffer;
    
    public CLICanvas(int maxRowSize, int maxColSize){
        MAXROWSIZE = maxRowSize;
        MAXCOLSIZE = maxColSize;
        drawBuffer = new char[MAXROWSIZE][MAXCOLSIZE];
    }
    
    public void setCanvasPixel(int row, int col, char c){
        if(row<MAXROWSIZE && col<MAXCOLSIZE)
            drawBuffer[row][col] = c;
    }
    public void clear(){
        for(int i=0;i<MAXROWSIZE;i++)
            for(int j=0;j<MAXCOLSIZE;j++){
                drawBuffer[i][j] = ' ';
            }
    }
    public void repaint(){
        for(int i=0;i<MAXROWSIZE;i++){
            for(int j=0;j<MAXCOLSIZE;j++){
                System.out.print(drawBuffer[i][j]);
            }
            System.out.println();
        }
    }
    
}
