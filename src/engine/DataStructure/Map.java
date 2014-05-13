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

import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Map{
    private int maxLevel,maxRow,maxCol;
    private GameItem matrix[][][];
    /**
     * Constructor
     * 
     * @param maxLevel maximum Level of Map
     * @param maxRow maximum Row of Map
     * @param maxCol maximum Col of Map
     */
    public Map(int maxLevel,int maxRow, int maxCol){
        this.maxLevel = maxLevel;
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        matrix = new GameItem[maxLevel][maxRow][maxCol];
        for(int i=0;i<maxLevel;i++)
            for(int j=0;j<maxRow;j++)
                for(int k=0;k<maxCol;k++)
                    matrix[i][j][k] = new RoadItem();
    }
    
    /**
     * Constructor from xml file
     * 
     * @param namaFile xml map file location
     */
    public Map(String namaFile){
        try{
            //Open File
            File xmlFile = new File(namaFile);
            //SetParser
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            //Normalization
            doc.getDocumentElement().normalize();
            //Ambil ukuran matrix
            maxRow = Integer.parseInt(doc.getElementsByTagName("baris").item(0).getTextContent());
            maxCol = Integer.parseInt(doc.getElementsByTagName("kolom").item(0).getTextContent());
            maxLevel = Integer.parseInt(doc.getElementsByTagName("level").item(0).getTextContent());
            //Ambil isi dari matrix
            NodeList matrixList = doc.getElementsByTagName("el");
            if (matrixList.getLength()!= maxRow*maxCol*maxLevel)
                throw new Exception("Data Corrupt");
            for(int i=0;i<maxLevel;i++)
                for(int j=0;j<maxRow;j++)
                    for(int k=0;k<maxCol;k++){
                        Element el = (Element) matrixList.item(i*(maxRow*maxCol)+j*(maxCol)+k);
                        //Ini dibuat untuk lihat aja karena xml belum pada format yang sesuai
                        System.out.println(el.getTextContent());
                    }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Copy Constructor
     * <p>
     * This copy constructor copy Map entity by reference
     * </p>
     * @param others Map
     */
    public Map(Map others)
    {
        this.matrix = others.matrix;
        this.maxCol = others.maxCol;
        this.maxRow = others.maxRow;
        this.maxLevel = others.maxLevel;
    }

    /**
     * Get element
     * @param L Location of Map
     * @return Map element
     */
    public GameItem getElement(Location L){
        return matrix[L.getLevel()][L.getRow()][L.getCol()];
    }

    /**
     * Set element
     * @param L level of Map
     * @param value value of Map
     */
    public void setElement(Location L, GameItem value){
        matrix[L.getLevel()][L.getRow()][L.getCol()] = value; 
    }

    /**
     * Get max level
     * @return max level of Map
     */
    public int getMaxLevel(){
        return maxLevel;
    }

    /**
     * Get max row
     * @return max row of Map
     */
    public int getMaxRow(){
        return maxRow;
    }

    /**
     * Get max column
     * @return max column of Map
     */
    public int getMaxCol(){
        return maxCol;
    }

    /**
     * Find Location of start point
     * @return Location of start
     * @throws Exception
     */
    public Location getStart() throws Exception{
        for(int i=0;i<maxLevel;i++)
            for(int j=0;j<maxRow;j++)
                for(int k=0;k<maxCol;k++)
                    if(matrix[i][j][k].getName().equalsIgnoreCase("start"))
                        return new Location(i,j,k);
        throw new Exception("Tidak menemukan start.");
    }
}

