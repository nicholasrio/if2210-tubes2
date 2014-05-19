/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ItemCache {
    public static HashMap<String,Item> itemCache = new HashMap<>();
    public static HashMap<String,BufferedImage> imageCache = new HashMap<>();
    private ItemCache() { }
    
    /**
     * load all available resources and reset the cache.
     */
    public static void loadCache(){
        loadItems();
        loadImages();
    }
    
    /**
     * get a clone of item from cache
     * use like getItem("CIRCLE")
     * @param itemName the name item
     * @return new item if exist, null if not.
     */
    public static Item getItem(String itemName){
        if (itemCache.containsKey(itemName)){
            try {
                return itemCache.get(itemName).clone();
            } catch (CloneNotSupportedException e){
                return null;
            }
        } else {
            return null;
        }
    }
    /**
     * load the item from database
     */
    private static void loadItems(){
        try {
            File file = new File(ItemCache.class.getClassLoader().getResource("Resource/item.xml").getFile());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList itemNodes = doc.getElementsByTagName("item");
            for (int i=0; i<itemNodes.getLength(); i++) {
                Node itemNode = itemNodes.item(i);
                NodeList attributeNodes = itemNode.getChildNodes();
                Item item = new Item();
                for(int j=0; j<attributeNodes.getLength(); j++)
                {
                    Node attributeNode = attributeNodes.item(j);
                    String attributeName = attributeNode.getNodeName();
                    String attributeValue = attributeNode.getTextContent();
                    if(attributeName.equals("id"))
                        item.setId(Integer.parseInt(attributeValue));
                    else if(attributeName.equals("name"))
                        item.setName(attributeValue);
                    else if(attributeName.equals("cost"))
                        item.setCost(Integer.parseInt(attributeValue));
                    else if(attributeName.equals("strEff"))
                        item.setStrEff(Integer.parseInt(attributeValue));
                    else if(attributeName.equals("agiEff"))
                        item.setAgiEff(Integer.parseInt(attributeValue));
                    else if(attributeName.equals("intEff"))
                        item.setIntEff(Integer.parseInt(attributeValue));
                    else if(attributeName.equals("currentHealthEff"))
                        item.setCurrentHealthEff(Integer.parseInt(attributeValue));
                    else if(attributeName.equals("currentManaEff"))
                        item.setCurrentManaEff(Integer.parseInt(attributeValue));
                    else if(attributeName.equals("maxHealthEff"))
                        item.setMaxHealthEff(Integer.parseInt(attributeValue));
                    else if(attributeName.equals("maxManaEff"))
                        item.setMaxManaEff(Integer.parseInt(attributeValue));
                    else if(attributeName.equals("description"))
                        item.setDescription(attributeValue);
                    else if(attributeName.equals("imagePath"))
                        item.setImagePath(attributeValue);
                }
                itemCache.put(item.getName(), item);
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ItemCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void loadImages()
    {
        for(Map.Entry<String,Item> item: itemCache.entrySet())
        {
            try {
                URL path = ItemCache.class.getClassLoader().getResource(item.getValue().getImagePath());
                imageCache.put(item.getValue().getName(), ImageIO.read(path));
            } catch (IOException ex) {
                Logger.getLogger(ItemCache.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
