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
            namaFile = "Map/xml/" + namaFile;
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
            //Inisiasi matrix
            matrix = new GameItem[maxLevel][maxRow][maxCol];
            //Ambil daftar teleporter
            int nTeleporter = Integer.parseInt(doc.getElementsByTagName("teleporters").item(0).getTextContent());
            Location teleLocation[] = new Location[nTeleporter];
            NodeList NodeTeleporter = doc.getElementsByTagName("teleporter");
            for(int i=0;i<nTeleporter;i++){
                int b,c,l,idx;
                idx = Integer.parseInt(((Element)NodeTeleporter.item(i)).getAttribute("id"));
                b = Integer.parseInt(((Element) NodeTeleporter.item(i)).getElementsByTagName("baris").item(0).getTextContent());
                c = Integer.parseInt(((Element) NodeTeleporter.item(i)).getElementsByTagName("kolom").item(0).getTextContent());
                l = Integer.parseInt(((Element) NodeTeleporter.item(i)).getElementsByTagName("level").item(0).getTextContent());
                teleLocation[idx] = new Location(b,c,l);
            }
            //Ambil isi dari matrix
            NodeList matrixList = doc.getElementsByTagName("el");
            if (matrixList.getLength()!= maxRow*maxCol*maxLevel)
                throw new Exception("Data Corrupt");
            for(int i=0;i<maxLevel;i++)
                for(int j=0;j<maxRow;j++)
                    for(int k=0;k<maxCol;k++){
                        Element el = (Element) matrixList.item(i*(maxRow*maxCol)+j*(maxCol)+k);
                        if(el.getTextContent().equals("p"))
                            matrix[i][j][k] = new RoadItem();
                        else if(el.getTextContent().equals("w"))
                            matrix[i][j][k] = new WallItem();
                        else if(el.getTextContent().equals("c"))
                            matrix[i][j][k] = new CoinItem();
                         else if(el.getTextContent().equals("h"))
                            matrix[i][j][k] = new HoleItem();
                        else if(el.getTextContent().equals("f"))
                            matrix[i][j][k] = new FinishItem();
                        else if(el.getTextContent().equals("s"))
                            matrix[i][j][k] = new StartItem();
                        else if(el.getTextContent().matches("^[tT](\\d)*")){
                            String kode = el.getTextContent();
                            String nomorString = kode.substring(1);
                            int nomorInt = Integer.parseInt(nomorString);
                            matrix[i][j][k] = new TeleporterItem(teleLocation[nomorInt]);
                        }
                    }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Copy Constructor
     * This is copy constructor of Map
     * @param others Map
     */
    public Map(Map others)
    {
        maxCol = others.maxCol;
        maxRow = others.maxRow;
        maxLevel = others.maxLevel;
        matrix = new GameItem[maxLevel][maxRow][maxCol];
        for(int i=0;i<maxLevel;i++)
            for(int j=0;j<maxRow;j++)
                System.arraycopy(others.matrix[i][j], 0, matrix[i][j], 0, maxCol);
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
                        return new Location(j,k,i);
        throw new Exception("Tidak menemukan start.");
    }
    
    /**
     * Draw Map to Canvas
     * 
     * @param canvas Canvas
     * @param level Player Location level
     * @param rowOffset drawing row offset
     * @param colOffset drawing col offset
     */
    public void Draw(CLICanvas canvas,int level, int rowOffset, int colOffset){
        for(int i=rowOffset-1;i<rowOffset+(maxRow*3+1);i++){
            canvas.setCanvasPixel(i, colOffset-1, '#');
            canvas.setCanvasPixel(i, colOffset+maxCol*3, '#');
        }
        for(int i=colOffset-1;i<colOffset+(maxCol*3+1);i++){
            canvas.setCanvasPixel(rowOffset-1, i, '#');
            canvas.setCanvasPixel(rowOffset+maxRow*3, i, '#');
        }

        for(int i=0;i<maxRow;i++)
            for(int j=0;j<maxCol;j++)
                matrix[level][i][j].Draw(canvas, rowOffset+3*i, colOffset+3*j);
    }
}

