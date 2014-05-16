/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import static character.ItemCache.imageCache;
import static character.ItemCache.itemCache;
import java.util.HashMap;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author yafithekid
 */
public class CharacterCache {
    /**
     * contains unique character. need to be cloned to get instance.
     */
    public static HashMap<String,Character> characterCache = new HashMap<>();
    /**
     * the image related to the character.
     */
    public static HashMap<String,BufferedImage> image = new HashMap<>();
    
    private CharacterCache() { }
    
    /**
     * load all available resources and reset the cache.
     */
    public static void loadCache(){
        loadCharacters();
        loadImages();
    }

    /**
     * get a clone of item from cache
     * use like getItem("CIRCLE")
     * @param itemName the name item
     * @return new item if exist, null if not.
     */
    public static Character getItem(String itemName){
        if (characterCache.containsKey(itemName)){
            try {
                return characterCache.get(itemName).clone();
            } catch (CloneNotSupportedException e){
                return null;
            }
        } else {
            return null;
        }
    }
    /**
     * load character from database
     */
    private static void loadCharacters()
    {
        try {
            
            File file = new File(ItemCache.class.getClassLoader().getResource("Resource/character.xml").getFile());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList characterNodes = doc.getElementsByTagName("character");
            for (int i=0; i<characterNodes.getLength(); i++) {
                Node characterNode = characterNodes.item(i);
                Element characterElement = (Element)characterNode;
                Character character;
                if(characterElement.getAttribute("class").equals("hero"))
                    character = new Hero();
                else if(characterElement.getAttribute("class").equals("monster"))
                    character = new Monster();
                else
                    character = new Character();
                character.setId(Integer.parseInt(characterElement.getElementsByTagName("id").item(0).getTextContent()));
                character.setName(characterElement.getElementsByTagName("name").item(0).getTextContent());
                character.setStr(Integer.parseInt(characterElement.getElementsByTagName("str").item(0).getTextContent()));
                character.setAgi(Integer.parseInt(characterElement.getElementsByTagName("agi").item(0).getTextContent()));
                character.setInt(Integer.parseInt(characterElement.getElementsByTagName("int").item(0).getTextContent()));
                character.setMaxHealth(Integer.parseInt(characterElement.getElementsByTagName("maxHealth").item(0).getTextContent()));
                character.setMaxMana(Integer.parseInt(characterElement.getElementsByTagName("maxMana").item(0).getTextContent()));
                character.setImagePath(characterElement.getElementsByTagName("imagePath").item(0).getTextContent());
                characterCache.put(character.getName(), character);
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ItemCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * load images for character sprite
     */
    private static void loadImages()
    {
        for(Map.Entry<String,Character> character: characterCache.entrySet())
        {
            try {
                URL path = CharacterCache.class.getClassLoader().getResource(character.getValue().getImagePath());
                
                imageCache.put(character.getValue().getName(), ImageIO.read(path));
            } catch (IOException ex) {
                Logger.getLogger(ItemCache.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
