/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Timothy
 * 
 */
public class Player {
    /* Attribut */
    private String nama;
    private int score;
    private int levelUnlocked;
    private int achievementUnlocked;
    
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
    }
    
    @Override
    public String toString()
    {
        String temp;
        temp = "Nama : " + nama + "\n";
        temp += "Score : " + score + "\n";
        temp += "Level unlocked : " + levelUnlocked + "\n";
        temp += "Achievement unlocked : " + achievementUnlocked + "\n";
        return temp;
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
     */
    public void move(Map peta) /* ? */
    {
        try 
        {
            Map map = new Map(peta);
            Location position = map.getStart();
            Scanner read = new Scanner(System.in);
            ArrayList<String> validMove = new ArrayList<>();
            validMove.add("up");
            validMove.add("down");
            validMove.add("left");
            validMove.add("right");
                        
            /* Keterangan Map */
            // start = -1;
            // exit = -2;
            // coin = -3;
            // wall = -4;
            //  0 : nothing
            // >0 : teleporter
            
            /* Ukuran Map */
            int maxLevel = map.getMaxLevel();
            int maxRow = map.getMaxRow();
            int maxCol = map.getMaxCol();
            int status;
            String command;
            
            /* Play */
            while(map.getElement(position.getLevel(), position.getRow(), position.getCol())!= -2) /* Belum ketemu exit */
            {
                do
                {
                    command = read.next();
                } while (validMove.contains(command) == false);
                switch (command) {
                    case "up": // move ke atas
                        if(position.getRow() > 0) // periksa apakah posisi sudah diujung atas map?
                        {
                            if(map.getElement(position.getLevel(), position.getRow()-1, position.getCol()) != -4) // periksa apakah ada tembok?
                            {
                                position.setRow(position.getRow()-1);
                            }
                        }
                        break;
                    case "down": // move ke bawah
                        if(position.getRow()<map.getMaxRow()-1) // periksa apakah posisi sudah diujung bawah map?
                        {
                            if(map.getElement(position.getLevel(), position.getRow()+1, position.getCol()) != -4) // periksa apakah ada tembok?
                            {
                                position.setRow(position.getRow()+1);
                            }
                        }
                        break;
                    case "left": // move ke kiri
                        if(position.getCol() > 0) // periksa apakah posisi sudah diujung kiri map?
                        {
                            if(map.getElement(position.getLevel(), position.getRow(), position.getCol()-1) != -4) // periksa apakah ada tembok?
                            {
                                position.setRow(position.getCol()-1);
                            }
                        }
                        break;
                    case "right": // move ke kanan
                        if(position.getCol() < map.getMaxCol()-1) // periksa apakah posisi sudah diujung kanan map?
                        {
                            if(map.getElement(position.getLevel(), position.getRow(), position.getCol()+1) != -4) // periksa apakah ada tembok?
                            {
                                position.setRow(position.getCol()+1);
                            }
                        }
                        break;
                }
                status = map.getElement(position.getLevel(), position.getRow(), position.getCol());
                if(status == -3) // ada coin
                {
                    score++;
                    map.setElement(position.getLevel(), position.getRow(), position.getCol(), 0);
                }
                else if(status > 0) // teleporter
                {
                    position.setLevel(status);
                }
            }
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
