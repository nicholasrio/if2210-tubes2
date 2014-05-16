/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.DataStructure;

import com.sun.corba.se.impl.protocol.AddressingDispositionException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Timothy
 * 
 */
public class Player 
{
    /* Attribut */
    private String nama;
    private int score;
    private int levelUnlocked;
    private int achievementUnlocked;
    private Location position;
    
    /* Constructor */
    /**
     * 
     * @param nama The name of the player
     */
    public Player(String nama)
    {
        this.nama = nama;
        score = 0;
        levelUnlocked = 0;
        achievementUnlocked = 0;
        position = new Location();
    }
    
    @Override
    public String toString()
    {
        StringBuilder temp = new StringBuilder();
        temp.append("Nama : ");
        temp.append(nama);
        temp.append("\n");
        temp.append("Score : ");
        temp.append(score);
        temp.append("\n");
        temp.append("Level unlocked : ");
        temp.append(levelUnlocked);
        temp.append("\n");
        temp.append("Achievement unlocked : ");
        temp.append(achievementUnlocked);
        temp.append("\n");
        return temp.toString();
    }
    
    /* Getter */
    /**
     * 
     * @return the name of the player
     */
    public String getNama()
    {
        return nama;
    }
    /**
     * 
     * @return the score that has been collected by the player
     */
    public int getScore()
    {
        return score;
    }
    /**
     * 
     * @return number of level that has been unlocked by the player
     */
    public int getLevelUnlocked()
    {
        return levelUnlocked;
    }
    /**
     * 
     * @return number of achievement that has been unlocked by the player
     */
    public int getAchievmentUnlocked()
    {
        return achievementUnlocked;
    }
    
    public Location getLocation()
    {
        return position;
    }
    
    /* Setter */
    /**
     * 
     * @param nama the name of the player
     */
    public void setNama(String nama)
    {
        this.nama = nama;
    }
    /**
     * 
     * @param score the score that has been collected by the player
     */
    public void setScore(int score)
    {
        this.score = score;
    }
    /**
     * 
     * @param achievement achievement that has been unlocked by the player
     */
    public void setAchievementUnlocked(int achievement)
    {
        this.achievementUnlocked = achievement;
    }
    /**
     * 
     * @param level that has been unlocked by the player 
     */
    public void setLevelUnlocked(int level)
    {
        this.levelUnlocked = level;
    }
    
    
    /* Method */
    /**
     * 
     * @param peta the map in which the player is playing
     * @param command 1 for up, 2 for down, 3 for left, 4 for right
     */
    public void move(Map peta, int command)
    {
        try 
        {
            Map map = new Map(peta);

            /* Ukuran Map */
            int maxLevel = map.getMaxLevel();
            int maxRow = map.getMaxRow();
            int maxCol = map.getMaxCol();
            GameItem status;
            
            /* Play */
            GameItem itemHere = map.getElement(new Location(position.getLevel(), position.getRow(), position.getCol()));
            while(!itemHere.getName().equalsIgnoreCase("finish")) /* Belum ketemu exit */
            {
                switch (command) {
                    case 1: // move ke atas
                        if(position.getRow() > 0) // periksa apakah posisi sudah diujung atas map?
                        {
                            itemHere = map.getElement(new Location(position.getLevel(), position.getRow()-1, position.getCol()));
                            if(!itemHere.getName().equalsIgnoreCase("wall")) // periksa apakah ada tembok?
                            {
                                position.setRow(position.getRow()-1);
                            }
                        }
                        break;
                    case 2: // move ke bawah
                        if(position.getRow()<map.getMaxRow()-1) // periksa apakah posisi sudah diujung bawah map?
                        {
                            itemHere = map.getElement(new Location(position.getLevel(), position.getRow()+1, position.getCol()));
                            if(!itemHere.getName().equalsIgnoreCase("wall")) // periksa apakah ada tembok?
                            {
                                position.setRow(position.getRow()+1);
                            }
                        }
                        break;
                    case 3: // move ke kiri
                        if(position.getCol() > 0) // periksa apakah posisi sudah diujung kiri map?
                        {
                            itemHere = map.getElement(new Location(position.getLevel(), position.getRow(), position.getCol()-1));
                            if(!itemHere.getName().equalsIgnoreCase("wall")) // periksa apakah ada tembok?
                            {
                                position.setRow(position.getCol()-1);
                            }
                        }
                        break;
                    case 4: // move ke kanan
                        if(position.getCol() < map.getMaxCol()-1) // periksa apakah posisi sudah diujung kanan map?
                        {
                            itemHere = map.getElement(new Location(position.getLevel(), position.getRow(), position.getCol()+1));
                            if(!itemHere.getName().equalsIgnoreCase("wall")) // periksa apakah ada tembok?
                            {
                                position.setRow(position.getCol()+1);
                            }
                        }
                        break;
                }
                status = map.getElement(new Location(position.getLevel(), position.getRow(), position.getCol()));
                if(status.getName().equalsIgnoreCase("coin")) // ada coin
                {
                    score++;
                    map.setElement(new Location(position.getLevel(), position.getRow(), position.getCol()), new RoadItem());
                }
                else if(status.getName().equalsIgnoreCase("teleporter")) // teleporter
                {
                    TeleporterItem tele = (TeleporterItem) status;
                    Location teleLocation = tele.getArrivalLocation();
                    position.setLocation(teleLocation.getLevel(), teleLocation.getRow(), teleLocation.getCol());
                }
                else if(status.getName().equalsIgnoreCase("hole")){
                    position.setLocation(position.getLevel()-1, position.getRow(), position.getCol());
                }
            }
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initPlayerPosition(Map M){
        try{
            position = M.getStart();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
