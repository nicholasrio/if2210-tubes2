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
        
        canvas = new CLICanvas(MAXROWCANVAS,MAXCOLCANVAS);
    }
    
    @Override
    public void Update()
    {
        System.out.println("Enter 1(up) 2(down) 3(left) 4(right) to move, 5 to return, 6 to exit : ");
        Scanner Sc = new Scanner(System.in);
        int choise = Sc.nextInt();
        switch(choise){
            case 1 : player.move(gameMap,1);
                     break;
            case 2 : player.move(gameMap,2);
                     break;
            case 3 : player.move(gameMap,3);
                     break;
            case 4 : player.move(gameMap,4);
                     break;
            case 5 : SceneManager.SwitchScene("LevelMenu");
                     break;
            case 6 : Game.gameRunning = false;
                     break;
        }
    }
    
    @Override
    public void Draw()
    {
        canvas.clear();
        Location L = player.getLocation();
        System.out.println("Floor: "+L.getLevel());
        gameMap.Draw(canvas,L.getLevel(),MAPROWOFFSET, MAPCOLOFFSET);
        player.Draw(canvas, MAPROWOFFSET+L.getRow()*3, MAPCOLOFFSET+L.getCol()*3);
        canvas.repaint();
    }
}
