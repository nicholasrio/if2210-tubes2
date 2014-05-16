/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.ArrayList;

/**
 *
 * @author Tony
 */
public class ImageLoader extends JPanel
{
    private static ArrayList<Image> allImages = new ArrayList<>();  
    
    private static Image loadImage(String path)
    {
        Image tes = null;
        tes = new ImageIcon(path).getImage();
        return tes;
    }
    
    public static void loadAllImages()
    {
        // Image buat MainMenu
        allImages.add(loadImage("Image/MainMenu/title.png"));
        allImages.add(loadImage("Image/MainMenu/mainmenu_bg.png"));
        allImages.add(loadImage("Image/MainMenu/newgame.png"));
        allImages.add(loadImage("Image/MainMenu/achievement.png"));
        allImages.add(loadImage("Image/MainMenu/options.png"));
        allImages.add(loadImage("Image/MainMenu/about.png"));
        allImages.add(loadImage("Image/MainMenu/exit.png"));
        allImages.add(loadImage("Image/MainMenu/back.png"));
        
        //Image buat level menu
        allImages.add(loadImage("Image/LevelMenu/background.png"));
        allImages.add(loadImage("Image/LevelMenu/cube_mazer(ice).png")); 
        allImages.add(loadImage("Image/LevelMenu/cube_mazer(fire).png"));
        allImages.add(loadImage("Image/LevelMenu/Frozen Cube 800x600.png"));
        allImages.add(loadImage("Image/LevelMenu/Burning Cube 800x600.png"));
        allImages.add(loadImage("Image/LevelMenu/level(ice).png"));        
        allImages.add(loadImage("Image/LevelMenu/Ice_Mage.png"));
        allImages.add(loadImage("Image/LevelMenu/locked(ice).png"));
        allImages.add(loadImage("Image/LevelMenu/Unlocked(ice).png"));
        
        // Image achievement
        allImages.add(loadImage("Image/AchievementBack.png"));
        
        // Image GameMenu
        allImages.add(loadImage("Image/GameMenu/Ice_Maze/ice_path.png"));
        allImages.add(loadImage("Image/GameMenu/Ice_Maze/ice_wall.png"));
        allImages.add(loadImage("Image/GameMenu/Ice_Maze/ice_hole.png"));
        allImages.add(loadImage("Image/GameMenu/Ice_Maze/ice_teleporter.png"));
        allImages.add(loadImage("Image/GameMenu/Ice_Maze/ice_gold.png"));
        allImages.add(loadImage("Image/GameMenu/Ice_Maze/ice_char_right_left.png"));
        allImages.add(loadImage("Image/GameMenu/Ice_Maze/ice_char_up_down.png"));
    }
    
    public static Image getImage(String imgName)
    {
        if ("title".equalsIgnoreCase(imgName))
        {
            return allImages.get(0);
        }
        else if ("mainmenu_bg".equalsIgnoreCase(imgName))
        {
            return allImages.get(1);
        }
        else if ("newgame".equalsIgnoreCase(imgName))
        {
            return allImages.get(2);
        }
        else if ("achievement".equalsIgnoreCase(imgName))
        {
            return allImages.get(3);
        }
        else if ("options".equalsIgnoreCase(imgName))
        {
            return allImages.get(4);
        }
        else if ("about".equalsIgnoreCase(imgName))
        {
            return allImages.get(5);
        }
        else if ("exit".equalsIgnoreCase(imgName))
        {
            return allImages.get(6);
        }
        else if ("back".equalsIgnoreCase(imgName))
        {
            return allImages.get(7);
        }
        else if ("background".equalsIgnoreCase(imgName))
        {
            return allImages.get(8);
        }
        else if ("cube_mazer_ice".equalsIgnoreCase(imgName))
        {
            return allImages.get(9);
        }
        else if ("cube_mazer_fire".equalsIgnoreCase(imgName))
        {
            return allImages.get(10);
        }
        else if ("frozen_cube".equalsIgnoreCase(imgName))
        {
            return allImages.get(11);
        }
        else if ("burning_cube".equalsIgnoreCase(imgName))
        {
            return allImages.get(12);
        }
        else if ("level_ice".equalsIgnoreCase(imgName))
        {
            return allImages.get(13);
        }
        else if ("ice_mage".equalsIgnoreCase(imgName))
        {
            return allImages.get(14);
        }
        else if ("locked_ice".equalsIgnoreCase(imgName))
        {
            return allImages.get(15);
        }
        else if ("unlocked_ice".equalsIgnoreCase(imgName))
        {
            return allImages.get(16);
        }
        else if ("AchievementBack".equalsIgnoreCase(imgName))
        {
            return allImages.get(17);
        }
        
        else if ("Ice_Path".equalsIgnoreCase(imgName))
        {
            return allImages.get(18);
        }
        else if ("Ice_Wall".equalsIgnoreCase(imgName))
        {
            return allImages.get(19);
        }
        else if ("Ice_Hole".equalsIgnoreCase(imgName))
        {
            return allImages.get(20);
        }else if ("Ice_Teleporter".equalsIgnoreCase(imgName))
        {
            return allImages.get(21);
        }
        else if ("Ice_Gold".equalsIgnoreCase(imgName))
        {
            return allImages.get(22);
        }
        else if ("Ice_Char_RL".equalsIgnoreCase(imgName))
        {
            return allImages.get(23);
        }
        else if ("Ice_Char_UD".equalsIgnoreCase(imgName))
        {
            return allImages.get(24);
        }
        
        return null;
    }
    
}
