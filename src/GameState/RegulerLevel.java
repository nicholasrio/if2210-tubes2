/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;
import map.Map;
import java.util.*;
import character.*;
import static character.CharacterCache.characterCache;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import character.CharacterCache;
import map.ViewerGUI;
/**
 *
 * @author kevinyu
 */
public class RegulerLevel extends Level{
    
    
    private ArrayList<Monster> monsters;
    private ArrayList<Pair> koordinatKosong;
    
    
    private class Pair{
        public Pair(int a,int b){
            x=a;
            y=b;
        }
        public int x;
        public int y;
    }
    

    File file;
    
    //konstruktor
    public RegulerLevel(int k,Hero hero){
        this.hero=hero;
        indexLevel = 1;
        offsetX=0;
        offsetY=0;
    }
    
    public void init(){
        statusBar = new StatusBar();
        statusBar.init();
        file = new File(ItemCache.class.getClassLoader().getResource("Resource/Level"+indexLevel+".xml").getFile());
        loadMap();
        initMonster();
        initHero();
    }
    
    public void loadMap(){
        
        //loadMap dari file xml
        try {
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList configurationNodes = doc.getElementsByTagName("map-info");
            Node mapInfoNode = configurationNodes.item(0);
            Element mapInfoElement = (Element)mapInfoNode;
            
            int mapWidth = Integer.parseInt(mapInfoElement.getElementsByTagName("width").item(0).getTextContent());
            
            int mapHeight = Integer.parseInt(mapInfoElement.getElementsByTagName("height").item(0).getTextContent());
            map = new Map();
            map.createDungeon(80, 100,40);
            
            }
        catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ItemCache.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //cari koordinat kosong. Dipakai untuk menaruh item atau musuh
        koordinatKosong = new ArrayList<Pair>();
        for (int i=0;i<map.xsize;i++){
            for (int j=0;j<map.ysize;j++){
                if (map.getCell(i,j).isWalkable()){
                    koordinatKosong.add(new Pair(i,j));
                }
            }
        }
        
    }
    
    //berfungsi untuk membaca monster yang terdapat pada level ini serta me load gambar monster-monster itu
    public void loadMonsters(){
        try {
            monsters = new ArrayList<Monster>();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList monsterInfoNodes = doc.getElementsByTagName("monster");
            
            for (int i=0;i<monsterInfoNodes.getLength();i++){
                Node monsterInfoNode = monsterInfoNodes.item(i);
                Element monsterInfoElement = (Element)monsterInfoNode;
                String  monsterName = monsterInfoElement.getElementsByTagName("name").item(0).getTextContent();
                int total = Integer.parseInt(monsterInfoElement.getElementsByTagName("total").item(0).getTextContent());
                System.out.println(total);
                for (int j=0;j<total;j++){
                    monsters.add((Monster)CharacterCache.getItem(monsterName));
                    monsters.get(monsters.size()-1).loadImage(CharacterCache.getImage(monsterName));
                    monsters.get(monsters.size()-1).loadAttackFrame(CharacterCache.getAttack(monsterName));
                }
            }
        }
        catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ItemCache.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    //melakukan update
    public void update(){
        
        if (hero.isDead()){
            playGameState.getGameStateManager().switchScene("MainMenu");
        }
        
        //update StatusBar dengan nyawa dan Mana sekarang
        statusBar.update(hero.getCurrentHealth(),hero.getCurrentMana());
        
        /*cek apakah terdapat Monster yang dilukai oleh hero
                dan apakah Hero dilukai Monster*/
        for (int i=0;i<monsters.size();i++){
            hero.checkHitting(monsters.get(i));
            
            //cek apakah hero berada dalam jangkauan serang Monster
            monsters.get(i).checkAttacking(hero);
            
            //cek apakah Monster melukai hero
            monsters.get(i).checkHitting(hero);
        }
        
        //update posisi dan state hero
        hero.update();
        
        //cek apakah terdapat monster yang mati
        for (int i=0;i<monsters.size();i++){
            if (monsters.get(i).isDead()){
                System.out.println("Mati");
                System.out.println(monsters.get(i).getCurrentHealth());
                monsters.remove(i);
                i--;
            }
            else{
                monsters.get(i).update();
            }
        }
    }
    
    //Gambar Kondisi RegulerLevel ini ke layar
    public void draw(Graphics g) {
        
        //cek posisi kamera
        if (hero.getPositionX()>400){
            offsetX = (int)hero.getPositionX()-(400/32)*32;
        }
        if (hero.getPositionY()>250){
            offsetY = (int)hero.getPositionY()-(250/32)*32;
        }
        
        //Tampilkan map
        ViewerGUI.view(g,map,(int)offsetX,(int)offsetY,(int)800,(int)500);
        hero.draw((Graphics2D)g,offsetX,offsetY);
        
        //Tampilkan monster
        for(int i=0;i<monsters.size();i++){
            monsters.get(i).draw((Graphics2D)g,offsetX,offsetY);
        }
        
        //Tampilkan statusBar
        statusBar.draw((Graphics2D) g);
    }
    
    //Inisialisasi MOnster
    public void initMonster(){
        //Ambil data monster pada level ini dari file eksternal
        loadMonsters();
        
        //Inisialisasi Lokasi monster secara random
        Random randomGenerator = new Random();
        Pair tmp;
        int randomInt;
        Monster mTmp;
        for (int i=0;i<monsters.size();i++){
            
            mTmp = monsters.get(i);
            
            mTmp.init();
            mTmp.setMap(map);
            mTmp.setPattern(10,10,10,10);
            randomInt = randomGenerator.nextInt(koordinatKosong.size());
            tmp = koordinatKosong.get(randomInt);
            monsters.get(i).setPosition(tmp.x*32,tmp.y*32);
            koordinatKosong.remove(randomInt);
            
        }
    }
    
    public void initHero(){
        hero.loadImage(CharacterCache.getImage("Yuu"));
        hero.loadAttackFrame(CharacterCache.getAttack("Yuu"));
        hero.setMap(map);
        hero.init();
        Random randomGenerator = new Random();
        Pair tmp;
        int randomInt;
        randomInt = randomGenerator.nextInt(koordinatKosong.size());
        tmp = koordinatKosong.get(randomInt);
        hero.setPosition(tmp.x*32,tmp.y*32);
        koordinatKosong.remove(randomInt);
    }
    
    /**
     * response if key pressed
     * @param k the pressed key.
     */
    public void keyPressed(int k){
        super.keyPressed(k);
        hero.keyPressed(k);
    }
    
    public void keyReleased(int k){
        hero.keyReleased(k);
    }
    
    
}
