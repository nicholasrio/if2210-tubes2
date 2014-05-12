/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapGenerator;
import java.io.File;
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
 
import org.w3c.dom.Attr;
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
    
    /* Konstruktor Kelas */
    public XMLGenerator()
    {
        baris = 0;
        kolom = 0;
        level = 0;
        map = null;
    }
    
    /* Setter dan Getter */
    public void setJumlahBaris(int baris)
    {
        this.baris = baris;
    }
    public void setJumlahKolom(int kolom)
    {
        this.kolom = kolom;
    }
    public void setJumlahLevel(int level)
    {
        this.level = level;
    }
    public int getJumlahBaris()
    {
        return baris;
    }
    public int getJumlahKolom()
    {
        return kolom;
    }
    public int getJumlahLevel()
    {
        return level;
    }
    
    /* Method */
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
            System.out.printf("baris,kolom,level : %d,%d,%d\n", baris,kolom,level);
            assert (baris == kolom && kolom == level) : baris + "," + kolom + "," + level + " tidak sama panjang";
            System.out.println(baris == kolom && kolom == level);
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
            
        } catch (FileNotFoundException ex) {}
    }
    
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
    }
    
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
             
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            
            // config the output
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD,"xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

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
        g.getMap("map.txt");
        g.convertToXML("map.xml");
    }
}
