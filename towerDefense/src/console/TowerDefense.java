package console;

import model.Player;
import controller.MainMenu;
import java.io.FileNotFoundException;
import java.util.*;
import controller.*;
import model.*;
import exception.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Opel Howard, wiragotama
 */
public class TowerDefense {
    public static void showHighScore(MainMenu menuList) {
        List<Player> highScore = menuList.getHighScore();
        for (Player Player_each : highScore) {
            System.out.println(Player_each.getName() + " " + Player_each.getHighScore());
        }
    }
    
    public static void main(String[] args) {
        MainMenu menuList = MainMenu.getInstance();
        boolean cannotPlay = false;
        try {
            menuList.loadPlayer();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            cannotPlay = true;
            return;
        }
        Scanner in = new Scanner(System.in);
        String str;
        int pilihanMenu = 0;
        while (pilihanMenu!=7 && !cannotPlay) {
            //clearscreen???5
            menuList.showMenus();
            pilihanMenu = in.nextInt();
            if (pilihanMenu==1 || pilihanMenu==2 || pilihanMenu==4) {
                str = in.next();
                switch(pilihanMenu) {
                    case 1 : {
                        try {
                            menuList.Login(str);
                        } catch (NameNotExistException ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                    case 2 : {
                        try {
                            menuList.newPlayer(str);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                    case 4 : {
                        try {
                            menuList.deletePlayer(str);
                        } catch (NameNotExistException ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                }
            }
            else if (pilihanMenu==3 || pilihanMenu==5 || pilihanMenu==6) {
                switch(pilihanMenu) {
                    case 3 : {
                        showHighScore(menuList);
                        break;
                    } 
                    case 5 : {
                        if (menuList.logged()) {
                            System.out.println("ada login");
                            try {
                                menuList.PlayGame(true);
                            } catch (FileNotFoundException ex) {
                                System.out.println("Map not found");
                                cannotPlay = true;
                            } catch (IOException ex) {
                                System.out.println("Interrupted");
                            }
                        }
                        break;
                    }
                    case 6 : {
                        if (menuList.logged()) {
                            System.out.println("ada login");
                            try {
                                menuList.PlayGame(false);   
                            } catch (FileNotFoundException ex) {
                                System.out.println("Cannot load game");
                                cannotPlay = true;
                            }catch (IOException ex) {
                                System.out.println("Interrupted");
                            }
                            
                        }
                        break;
                    }
                }
            }
            else if (pilihanMenu!=7) {
                System.out.println("Menu not found");
            }
        }
        try {
            menuList.closePlayer();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
}
