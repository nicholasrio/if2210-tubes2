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
    public static Player lastLogin = new Player("Mikaza"); //Default nya Mikaza, digunakan untuk testing load map.
    public static int nowLevelPlayed; 
    public static int height = 57; //57 height of half full screen, 25 is standard cmd size full screen
    public static int width = 168; // 80 full width of standard cmd screen and half full screen cmd size, 168 full screen
    
    /**
     * Reset dataPlayer dan dataMap
     */
    public static void reset()
    {
        dataPlayer.clear();
        dataMap.clear();
    }
    
    /**
     * @param nama nama pemain yang ingin ditambakan
     */
    public static void addPlayer(String nama)
    {
        dataPlayer.add(new Player(nama));
    }
    
    /**
     * 
     * @param nama nama pemain yang akan dihapus
     */
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
        }
    }
    
    /**
     * 
     * @return jumlah player yang terdaftar
     */
    public static int getJumlahPlayer()
    {
        return dataPlayer.size();
    }
    
    /**
     * 
     * @return jumlah map yang tersedia
     */
    public static int getJumlahMap()
    {
        return dataMap.size();
    }
    
    
    /**
     * 
     * @param nama nama player yang dicari
     * @return posisi player pada dataPlayer
     */
    public static int getIndexPlayer(String nama)
    {
        int i = 0;
        while (i < getJumlahPlayer() && !dataPlayer.get(i).getNama().equals(nama))
        {
            i++;
        }
        if (i == getJumlahPlayer())
        {
           return -1;
        }
        return i;
    }
    
    /**
     * 
     * @param filename Nama file tempat menyimpan data player
     */
    public static void savePlayer(String filename)
    {
        try 
        {
            filename = "Database Player/" + filename;
            System.out.println(filename);
            int i;
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            /* Root Element */
            Element root = doc.createElement("DatabasePlayer");
            doc.appendChild(root);
            
            /* Simpan player yang login terakhir */
            Element lastlogin = doc.createElement("lastLogin");
            
            Element score = doc.createElement("score");
            score.appendChild(doc.createTextNode(String.valueOf(lastLogin.getScore())));
            
            Element achievementUnlocked = doc.createElement("achievementUnlocked");
            achievementUnlocked.appendChild(doc.createTextNode(String.valueOf(lastLogin.getAchievmentUnlocked())));
            
            Element levelUnlocked = doc.createElement("levelUnlocked");
            levelUnlocked.appendChild(doc.createTextNode(String.valueOf(lastLogin.getLevelUnlocked())));
            
            Element nama = doc.createElement("nama");
            nama.appendChild(doc.createTextNode(lastLogin.getNama()));
            
            root.appendChild(lastlogin);
            lastlogin.appendChild(nama);
            lastlogin.appendChild(score);
            lastlogin.appendChild(levelUnlocked);
            lastlogin.appendChild(achievementUnlocked);
            
            for(i=0; i<getJumlahPlayer(); i++)
            {
                /* Element Player */
                Element player = doc.createElement("player");
                player.setAttribute("id", String.valueOf(i));
                root.appendChild(player);
                
                /* Anggota Element Player */
                nama = doc.createElement("nama");
                nama.appendChild(doc.createTextNode(dataPlayer.get(i).getNama()));
                score = doc.createElement("score");
                score.appendChild(doc.createTextNode(String.valueOf(dataPlayer.get(i).getScore())));
                levelUnlocked = doc.createElement("levelUnlocked");
                levelUnlocked.appendChild(doc.createTextNode(String.valueOf(dataPlayer.get(i).getLevelUnlocked())));
                achievementUnlocked = doc.createElement("achievementUnlocked");
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
    
    /**
     * 
     * @param filename nama file tempat disimpannya data player
     */
    public static void loadPlayer (String filename)
    {
        try
        {
            dataPlayer.clear();
            int i;
            
            /* Inisialisasi */
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            filename = "Database Player/" + filename;
            Document doc = docBuilder.parse(new File(filename));
            
            doc.getDocumentElement().normalize();
            
            /* Ambil data player dari file XML */
            /* Ambil semua data player */
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
            
            /* Ambil player yang terakhir login */
            playerList = doc.getElementsByTagName("lastLogin");
            playerNode = playerList.item(0);
            element = (Element) playerNode;
            lastLogin.setNama(element.getElementsByTagName("nama").item(0).getTextContent());
            lastLogin = GameData.dataPlayer.get(GameData.getIndexPlayer(lastLogin.getNama()));

        } 
        catch (ParserConfigurationException | SAXException | IOException ex) 
        {
            Logger.getLogger(GameData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void loadMap()
    {
        dataMap.clear();
        dataMap.add(new Map("map1.xml"));
        dataMap.add(new Map("map2.xml"));
    }
    
    /**
     * menampilkan daftar player yang ada
     */
    public static void printPlayer()
    {
        System.out.println("Last Login : ");
        System.out.println(lastLogin);
        System.out.println("Database Player : ");
        for(Player p : dataPlayer)
        {
            System.out.println(p);
        }
    }
}

