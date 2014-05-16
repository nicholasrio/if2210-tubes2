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
    
    public GameMenu()
    {
        super("GameMenu");
    }
    
    @Override
    public void Initialize()
    {
        GameData.loadMap();
        gameMap = GameData.dataMap.get(GameData.nowLevelPlayed);
        
        player = GameData.lastLogin;
        player.initPlayerPosition(gameMap);
        
        canvas = new CLICanvas(55,166);
        
        Game.gameRunning = true;
    }
    
    @Override
    public void Update()
    {
        System.out.println("Enter 1(up) 2(down) 3(down) 4(left) to move : ");
        Scanner Sc = new Scanner(System.in);
        int choise = Sc.nextInt();
        switch(choise){
            case 1 : player.move(gameMap);
                     break;
            case 2 : player.move(gameMap);
                     break;
            case 3 : player.move(gameMap);
                     break;
            case 4 : player.move(gameMap);
                     break;
        }
    }
    
    @Override
    public void Draw()
    {
        canvas.clear();
        //Gambar
        canvas.repaint();
    }
}
