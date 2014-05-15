/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.DataStructure;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Timothy
 */
public class GameData {
    public static ArrayList<Player> dataPlayer = new ArrayList<>();
    public static ArrayList<Map> dataMap = new ArrayList<>();
    public static Player lastLogin;
    
    public static void reset()
    {
        dataPlayer.clear();
        dataMap.clear();
    }
    
    public static void addPlayer(String nama)
    {
        dataPlayer.add(new Player(nama));
    }
    
    public static void deletePlayer(String nama)
    {
        int i = 0;
        while(i<getJumlahPlayer() && !dataPlayer.get(i).getNama().equals(nama))
        {
            i++;
        }
        if(i==getJumlahPlayer())
        {
            System.out.println("User : " + nama + " tidak ditemukan.");
        }
        else
        {
            dataPlayer.remove(i);
            System.out.println("User : " + nama + " telah dihapus.");
        }
    }
    
    public static int getJumlahPlayer()
    {
        return dataPlayer.size();
    }
    
    public static int getJumlahMap()
    {
        return dataMap.size();
    }
    
    public static int getIndexPlayer(String nama)
    {
        int i = 0;
        while (i < getJumlahPlayer() && !dataPlayer.get(i).getNama().equals(nama))
        {
            i++;
        }
        if (i == getJumlahPlayer())
        {
            try 
            {
                throw new Exception("User : " + nama + " does not exist.");
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(GameData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return i;
    }
    
    public static void savePlayer(String filename)
    {
        try 
        {
            int i;
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            /* Root Element */
            Element root = doc.createElement("DatabasePlayer");
            doc.appendChild(root);
            
            for(i=0; i<getJumlahPlayer(); i++)
            {
                /* Element Player */
                Element player = doc.createElement("player");
                player.setAttribute("id", String.valueOf(i));
                root.appendChild(player);
                
                /* Anggota Element Player */
                Element nama = doc.createElement("nama");
                nama.appendChild(doc.createTextNode(dataPlayer.get(i).getNama()));
                Element score = doc.createElement("score");
                score.appendChild(doc.createTextNode(String.valueOf(dataPlayer.get(i).getScore())));
                Element levelUnlocked = doc.createElement("levelUnlocked");
                levelUnlocked.appendChild(doc.createTextNode(String.valueOf(dataPlayer.get(i).getLevelUnlocked())));
                Element achievementUnlocked = doc.createElement("achievementUnlocked");
                achievementUnlocked.appendChild(doc.createTextNode(String.valueOf(dataPlayer.get(i).getAchievmentUnlocked())));
               
                /* Append kan element Player dengan anggotanya */
                player.appendChild(nama);
                player.appendChild(score);
                player.appendChild(levelUnlocked);
                player.appendChild(achievementUnlocked);
            }
            
            /* Tulis ke file */
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            
            // config the output
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD,"xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
            
            // transform
            transformer.transform(source, result);
            
            // Notification
            System.out.println("File Saved!");
        } 
        catch (ParserConfigurationException ex) 
        {
            Logger.getLogger(GameData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(GameData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(GameData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void loadPlayer (String filename)
    {
        /*try 
        {
            dataPlayer.clear();
            int i;
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(filename));
            
            doc.getDocumentElement().normalize();
            
            NodeList playerList = doc.getElementsByTagName("player");
            Node playerNode;
            Element element;
            for(i=0; i<playerList.getLength(); i++)
            {
                playerNode = playerList.item(i);
                element = (Element) playerNode;
                Player temp = new Player("temp");
                temp.setNama(element.getElementsByTagName("nama").item(0).getTextContent());
                temp.setScore(Integer.parseInt(element.getElementsByTagName("score").item(0).getTextContent()));
                temp.setLevelUnlocked(Integer.parseInt(element.getElementsByTagName("levelUnlocked").item(0).getTextContent()));
                temp.setAchievementUnlocked(Integer.parseInt(element.getElementsByTagName("achievementUnlocked").item(0).getTextContent()));
                dataPlayer.add(temp);
            }
        } 
        catch (ParserConfigurationException ex) 
        {
            Logger.getLogger(GameData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(GameData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GameData.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public static void printPlayer()
    {
        for(Player p : dataPlayer)
        {
            System.out.println(p);
        }
    }
    
    public static  void main (String[] args)
    {
        /*GameData.dataPlayer.clear();
        GameData.loadPlayer("player.xml");
        GameData.printPlayer();*/
    }
}

