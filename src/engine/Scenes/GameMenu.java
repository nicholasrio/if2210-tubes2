/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.Scenes;

import engine.*;
import engine.DataStructure.*;
import java.util.Scanner;

/**
 *
 * @author Tony
 */
public class GameMenu extends Scene
{
    private Map gameMap;
    private Player player;
    private CLICanvas canvas;
    private final int MAXROWCANVAS = 53;
    private final int MAXCOLCANVAS = 166;
    private int MAPROWOFFSET;
    private int MAPCOLOFFSET;
    private boolean isFinish;
    private boolean isLevelUnlocked;
    
    public GameMenu()
    {
        super("GameMenu");
    }
    
    @Override
    public void Initialize()
    {
        GameData.loadMap();
        gameMap = new Map(GameData.dataMap.get(GameData.nowLevelPlayed));
        
        MAPROWOFFSET = (MAXROWCANVAS-gameMap.getMaxRow()*3)/2;
        MAPCOLOFFSET = (MAXCOLCANVAS-gameMap.getMaxCol()*3)/2;
        
        player = GameData.lastLogin;
        player.initPlayerPosition(gameMap);
        player.resetTempScore();
        
        isFinish = false;
        isLevelUnlocked = false;
        
        canvas = new CLICanvas(MAXROWCANVAS,MAXCOLCANVAS);
    }
    
    @Override
    public void Update()
    {
        Scanner Sc = new Scanner(System.in);
        if(isFinish){
            //Press any key to continue
            Sc.nextLine();
            SceneManager.SwitchScene("LevelMenu");
        }else{
            //Pilihan perintah pada GameMenu
            int choise = Sc.nextInt();
            int output = 0;
            switch(choise){
                case 1 : output = player.move(gameMap,1);
                         break;
                case 2 : output = player.move(gameMap,2);
                         break;
                case 3 : output = player.move(gameMap,3);
                         break;
                case 4 : output = player.move(gameMap,4);
                         break;
                case 5 : SceneManager.SwitchScene("LevelMenu");
                         break;
                case 6 : Game.gameRunning = false;
                         break;
            }
            if(output == 1){
                isFinish = true;
                if(GameData.nowLevelPlayed == player.getLevelUnlocked()){
                    player.setLevelUnlocked(player.getLevelUnlocked()+1);
                    isLevelUnlocked = true;
                }
            }
        }
    }
    
    @Override
    public void Draw()
    {
        if(isFinish){
            canvas.clear();
            String S;
            S = "Congratulation";
            canvas.writeHorisontal(20, (MAXROWCANVAS - S.length())/2 , S);
            S = "Score = "+player.getTempScore();
            canvas.writeHorisontal(21, (MAXROWCANVAS - S.length())/2 , S);
            if(isLevelUnlocked){
                S = "Level Unlocked!!!";
                canvas.writeHorisontal(22, (MAXROWCANVAS - S.length())/2 , S);
                S = "Level "+player.getLevelUnlocked();
                canvas.writeHorisontal(23, (MAXROWCANVAS - S.length())/2 , S);
                S = "Press Enter to Continue";
                canvas.writeHorisontal(24, (MAXROWCANVAS - S.length())/2 , S);
            } 
            canvas.repaint();
        } else{
            canvas.clear();
            Location L = player.getLocation();
            System.out.println("Floor: "+L.getLevel()+"; Score: "+player.getTempScore());
            gameMap.Draw(canvas,L.getLevel(),MAPROWOFFSET, MAPCOLOFFSET);
            player.Draw(canvas, MAPROWOFFSET+L.getRow()*3, MAPCOLOFFSET+L.getCol()*3);
            canvas.repaint();
            System.out.println("Enter 1(up) 2(down) 3(left) 4(right) to move, 5 to return, 6 to exit : ");
        }
    }
}
