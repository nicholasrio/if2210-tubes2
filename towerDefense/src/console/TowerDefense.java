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
import controller.MainMenuConsole;
import java.io.FileNotFoundException;
import java.util.*;
import exception.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TowerDefense {  

    public static void main(String[] args) {
        MainMenuConsole mainMenuConsole = MainMenuConsole.getInstance();
        boolean cannotPlay = false;
        /**
         * Load player data from file
         */
        try {
            mainMenuConsole.loadPlayer();
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
            GameUI.showMainMenus();
            pilihanMenu = in.nextInt();
            if (pilihanMenu == 1 || pilihanMenu == 2 || pilihanMenu == 4) {
                str = in.next();
                switch (pilihanMenu) {
                    case 1: {
                        try {
                            mainMenuConsole.login(str);
                        } catch (NameNotExistException ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                    case 2: {
                        try {
                            mainMenuConsole.newPlayer(str);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                    case 4: {
                        try {
                            mainMenuConsole.deletePlayer(str);
                        } catch (NameNotExistException ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                }
            } else if (pilihanMenu == 3 || pilihanMenu == 5 || pilihanMenu == 6) {
                switch (pilihanMenu) {
                    case 3: {
                        GameUI.showHighScore(mainMenuConsole.getHighScore());
                        break;
                    }
                    case 5: {
                        if (mainMenuConsole.logged()) {
                            try {
                                mainMenuConsole.playGameConsole(false);
                            } catch (IOException ex) {
                                Logger.getLogger(TowerDefense.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    }
                    case 6: {
                        if (mainMenuConsole.logged()) {
                            /**
                             * load game
                             */
                            try {
                                mainMenuConsole.playGameConsole(false);
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
            mainMenuConsole.closePlayer();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
