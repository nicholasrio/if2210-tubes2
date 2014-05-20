/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapGenerator;
import engine.DataStructure.Location;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Timothy
 */
public class XMLGenerator {
    /* Atribut kelas */
    private int baris, kolom, level;
    private String map[][][];
    private int jumlah_teleporter;
    private ArrayList<Location> teleporter;
    
    /* Konstruktor Kelas */
    public XMLGenerator()
    {
        baris = 0;
        kolom = 0;
        level = 0;
        map = null;
        jumlah_teleporter = 0;
        teleporter = new ArrayList<>();
    }
    
    /* Method */
    /**
     * 
     * @param fileName nama file tempat map disimpan (bentuk txt)
     */
    public void getMap(String fileName)
    {
        File file = new File(fileName);
        if(file == null)
        {
            try {
                throw new Exception("File : " + fileName + " not found.");
            } catch (Exception ex) {}
        }
        try {
            Scanner read = new Scanner(file);
            String temp;
            
            /* Baca Comment box */
            do
            {
                temp = read.nextLine();
            } while(temp.startsWith("|") || temp.startsWith("="));
            
            /* Baca jumlah baris, kolom, dan level */
            String tempbaris, tempkolom, templevel;
            String [] elements;
            tempbaris = read.nextLine();
            tempkolom = read.nextLine();
            templevel = read.nextLine();
            baris = Integer.parseInt(tempbaris);
            kolom = Integer.parseInt(tempkolom);
            level = Integer.parseInt(templevel);
            assert (baris == kolom && kolom == level) : baris + "," + kolom + "," + level + " tidak sama panjang";
            map = new String[baris][kolom][level];
            
            /* Baca isi Mapnya */
            for(int i=0; i<level; i++)
            {
                /* Baca header level */
                read.nextLine();
                read.nextLine();
                for(int j=0; j<baris; j++)
                {
                    temp = read.nextLine();
                    elements = temp.split(" ");
                    for(int k=0; k<elements.length; k++)
                    {
                        map[i][j][k] = elements[k];
                    }
                }
            }
            
            /* Baca Jumlah Teleporter */
            read.nextLine();
            read.nextLine();
            temp = read.nextLine();
            jumlah_teleporter = Integer.parseInt(temp);
            int i;
            
            for(i = 0; i<jumlah_teleporter ; i++)
            {
                read.nextLine();
                read.nextLine();
                temp = read.nextLine();
                elements = temp.split(" ");
                teleporter.add(new Location(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2])));
            }
            
        } catch (FileNotFoundException ex) {}
    }
    
    /**
     * Mencetak isi map
     */
    public void Print()
    {
        int baris, kolom, level;
        for(level = 0; level < this.level; level ++)
        {
            for (baris = 0; baris < this.baris; baris ++)
            {
                for (kolom = 0; kolom < this.kolom; kolom ++)
                {
                    System.out.printf("[%d][%d][%d] : %s\n",level,baris,kolom,map[level][baris][kolom]);
                }
                System.out.println();
            }
        }
        
        System.out.println("Jumlah teleporter = " + jumlah_teleporter);
        int i = 0;
        for(Location loc : teleporter)
        {
            System.out.printf("Teleporter[%d]\n", i);
            System.out.println(teleporter.get(i));
            i++;
        }
    }
    
    /**
     * 
     * @param filename nama file .xml yang akan dibuat
     */
    public void convertToXML(String filename)
    {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("map");
            doc.appendChild(rootElement);
            
            // Baris elements
            Element Baris = doc.createElement("baris");
            Baris.appendChild(doc.createTextNode(String.valueOf(baris)));
            rootElement.appendChild(Baris);
            
            // Kolom elements
            Element Kolom = doc.createElement("kolom");
            Kolom.appendChild(doc.createTextNode(String.valueOf(kolom)));
            rootElement.appendChild(Kolom);
            
            // Level elements
            Element Level = doc.createElement("level");
            Level.appendChild(doc.createTextNode(String.valueOf(level)));
            rootElement.appendChild(Level);
            
            // Matrix elements
            Element Matrix = doc.createElement("matrix");
            rootElement.appendChild(Matrix);
            int row, column, lvl ,i;
            i = 0;
            for(lvl = 0; lvl < level ; lvl++)
            {
                for(row = 0; row < baris; row++)
                {
                    for(column = 0; column < kolom; column++)
                    {
                        Element el = doc.createElement("el");
                        el.setAttribute("idx", String.valueOf(i));
                        el.appendChild(doc.createTextNode(String.valueOf(map[lvl][row][column])));
                        i++;
                        Matrix.appendChild(el);
                    }
                }
            }

            // Teleporter Elements
            Element sum = doc.createElement("teleporters");
            sum.appendChild(doc.createTextNode(String.valueOf(jumlah_teleporter)));
            rootElement.appendChild(sum);
            
            // Teleporter location
            Element dest = doc.createElement("destination");
            rootElement.appendChild(dest);
            i = 0;
            
            for(Location loc : teleporter)
            {
                Element teleporter = doc.createElement("teleporter");
                teleporter.setAttribute("id", String.valueOf(i));
                dest.appendChild(teleporter);
                Element rows = doc.createElement("baris");
                rows.appendChild(doc.createTextNode(String.valueOf(loc.getRow())));
                
                Element cols = doc.createElement("kolom");
                cols.appendChild(doc.createTextNode(String.valueOf(loc.getCol())));
                
                Element lvls = doc.createElement("level");
                lvls.appendChild(doc.createTextNode(String.valueOf(loc.getLevel())));
                
                teleporter.appendChild(rows);
                teleporter.appendChild(cols);
                teleporter.appendChild(lvls);
                
                i++;
            }
             
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            
            // config the output
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD,"xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

            // transform
            transformer.transform(source, result);  
 
            // notification
            System.out.println("File saved!");
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XMLGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Main Class */
   public static void main (String [] args)
    {
        XMLGenerator g = new XMLGenerator();
        g.getMap("Map/txt/map1.txt");
        g.convertToXML("map1.xml");
    } 
}
