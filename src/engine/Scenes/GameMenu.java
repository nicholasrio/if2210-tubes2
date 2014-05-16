/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.Scenes;

import engine.*;
import engine.DataStructure.*;
import engine.Exception.SceneNotFoundException;
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
    private final int MAXROWCANVAS = GameData.height;
    private final int MAXCOLCANVAS = GameData.width-2;
    private int MAPROWOFFSET;
    private int MAPCOLOFFSET;
    private boolean isFinish;
    private boolean isLevelUnlocked;
    
    public GameMenu()
    {
        super("GameMenu");
    }
    
    /**
     * Menginisialisasi element-element pada scene GameMenu.
     */
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
    
    /**
     * Mengupdate isi dari Scene GameMenu.
     */
    @Override
    public void Update()
    {
        Scanner Sc = new Scanner(System.in);
        if(isFinish){
            //Press any key to continue
            Sc.nextLine();
            try{
                SceneManager.SwitchScene("LevelMenu");
            }catch(SceneNotFoundException e){
                e.printStackTrace();
            }
        }else{
            //Pilihan perintah pada GameMenu
            int choise = Sc.nextInt();
            int output = 0;
            try{
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
            }catch(SceneNotFoundException e){
                e.printStackTrace();
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
    
    /**
     * Menggambar scene Game Menu.
     */
    @Override
    public void Draw()
    {
        if(isFinish){
            canvas.clear();
            String S;
            System.out.println("\n");
            S = "Congratulation";
            canvas.writeHorisontal(20, (MAXCOLCANVAS - S.length())/2 , S);
            S = "Score = "+player.getTempScore();
            canvas.writeHorisontal(22, (MAXCOLCANVAS - S.length())/2 , S);
            if(isLevelUnlocked){
                S = "Level Unlocked!!!";
                canvas.writeHorisontal(25, (MAXCOLCANVAS - S.length())/2 , S);
                S = "Level "+player.getLevelUnlocked();
                canvas.writeHorisontal(27, (MAXCOLCANVAS - S.length())/2 , S);
                S = "Press Enter to Continue";
                canvas.writeHorisontal(30, (MAXCOLCANVAS - S.length())/2 , S);
            } 
            canvas.repaint();
        } else{
            canvas.clear();
            Location L = player.getLocation();
            String S;
            S = "Floor: "+L.getLevel()+"; Score: "+player.getTempScore();
            canvas.writeHorisontal(2, 3, S);
            gameMap.Draw(canvas,L.getLevel(),MAPROWOFFSET, MAPCOLOFFSET);
            player.Draw(canvas, MAPROWOFFSET+L.getRow()*3, MAPCOLOFFSET+L.getCol()*3);
            S = "Enter 1(up) 2(down) 3(left) 4(right) to move, 5 to return, 6 to exit : ";
            canvas.writeHorisontal(MAXROWCANVAS-1, 0, S);
            canvas.repaint();
        }
    }
}
