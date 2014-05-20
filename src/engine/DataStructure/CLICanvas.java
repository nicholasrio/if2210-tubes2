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
    
    /**
     * CLICanvas Constructor
     * 
     * @param maxRowSize Canvas row size
     * @param maxColSize Canvas col size
     */
    public CLICanvas(int maxRowSize, int maxColSize){
        MAXROWSIZE = maxRowSize;
        MAXCOLSIZE = maxColSize;
        drawBuffer = new char[MAXROWSIZE][MAXCOLSIZE];
    }
    
    /**
     * Set Canvas pixel
     * 
     * @param row Canvas Row
     * @param col Canvas Col
     * @param c character
     */
    public void setCanvasPixel(int row, int col, char c){
        if(row<MAXROWSIZE && col<MAXCOLSIZE && row>=0 && col>=0)
            drawBuffer[row][col] = c;
    }

    /**
     * Write String to Canvas
     * 
     * @param row write row offset
     * @param col write col offset
     * @param S string
     */
    public void writeHorisontal(int row, int col, String S){
        for(int i=0;i<S.length();i++)
            setCanvasPixel(row,col+i,S.charAt(i));
    }

    /**
     * Clear Canvas
     */
    public void clear(){
        for(int i=0;i<MAXROWSIZE;i++)
            for(int j=0;j<MAXCOLSIZE;j++){
                drawBuffer[i][j] = ' ';
            }
    }

    /**
     * Repaint CLI
     */
    public void repaint(){
        for(int i=0;i<MAXROWSIZE;i++){
            for(int j=0;j<MAXCOLSIZE;j++){
                System.out.print(drawBuffer[i][j]);
            }
            System.out.println();
        }
    }
    
}
