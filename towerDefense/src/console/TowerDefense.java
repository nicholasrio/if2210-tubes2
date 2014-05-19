/**
 *
 * @author 
 * Darwin Prasetio (13512015)
 * Chrestella Stephanie (13512005)
 * Jan Wira Gotama Putra (13512015)
 * Eric (13512021)
 * Willy(13512070)
 * Melvin Fonda (13512085)
 */
package console;

import model.Player;
import controller.MainMenuController;
import java.io.FileNotFoundException;
import java.util.*;
import exception.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TowerDefense {  

    public static void main(String[] args) {
        MainMenuController mainMenu = MainMenuController.getInstance();
        boolean cannotPlay = false;
        /**
         * Load player data from file
         */
        try {
            mainMenu.loadPlayer();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            cannotPlay = true;
            return;
        }
        Scanner in = new Scanner(System.in);
        String str;
        int pilihanMenu = 0;
        /**
         * Game menu
         */
        while (pilihanMenu != 7 && !cannotPlay) {
            //clearscreen???5
            GameConsoleUI.showMainMenus();
            pilihanMenu = in.nextInt();
            if (pilihanMenu == 1 || pilihanMenu == 2 || pilihanMenu == 4) {
                str = in.next();
                switch (pilihanMenu) {
                    case 1: {
                        try {
                            mainMenu.login(str);
                        } catch (NameNotExistException ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                    case 2: {
                        try {
                            mainMenu.newPlayer(str);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                    case 4: {
                        try {
                            mainMenu.deletePlayer(str);
                        } catch (NameNotExistException ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                }
            } else if (pilihanMenu == 3 || pilihanMenu == 5 || pilihanMenu == 6) {
                switch (pilihanMenu) {
                    case 3: {
                        GameConsoleUI.showHighScore(mainMenu.getHighScore());
                        break;
                    }
                    case 5: {
                        if (mainMenu.logged()) {
                            try {
                                mainMenu.playGameConsole(true);
                            } catch (IOException ex) {
                                Logger.getLogger(TowerDefense.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    }
                    case 6: {
                        if (mainMenu.logged()) {
                            /**
                             * load game
                             */
                            try {
                                mainMenu.playGameConsole(false);
                            } catch (FileNotFoundException ex) {
                                System.out.println("Cannot load game");
                                cannotPlay = true;
                            } catch (IOException ex) {
                                System.out.println("Interrupted");
                            }

                        }
                        break;
                    }
                }
            } else if (pilihanMenu != 7) {
                System.out.println("Menu not found");
            }
        }
        try {
            mainMenu.closePlayer();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
