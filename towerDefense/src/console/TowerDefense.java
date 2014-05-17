/**
 *
 * @author Darwin Prasetio (13512015) Chrestella Stephanie (13512005) Jan Wira
 * Gotama Putra (13512015) Eric (13512021) Willy(13512070) Melvin FOnda
 * (13512085)
 */
package console;

import model.Player;
import controller.MainMenu;
import java.io.FileNotFoundException;
import java.util.*;
import exception.*;
import java.io.IOException;

public class TowerDefense {    

    public static void showMenus() {
        System.out.println("1. Login");
        System.out.println("2. New Player");
        System.out.println("3. High Scores");
        System.out.println("4. Detele Player");
        System.out.println("5. New Game");
        System.out.println("6. Load Game");
        System.out.println("7. Exit");
    }

    public static void main(String[] args) {
        MainMenu menuList = MainMenu.getInstance();
        boolean cannotPlay = false;
        /**
         * Load player data from file
         */
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
        /**
         * Game menu
         */
        while (pilihanMenu != 7 && !cannotPlay) {
            //clearscreen???5
            showMenus();
            pilihanMenu = in.nextInt();
            if (pilihanMenu == 1 || pilihanMenu == 2 || pilihanMenu == 4) {
                str = in.next();
                switch (pilihanMenu) {
                    case 1: {
                        try {
                            menuList.Login(str);
                        } catch (NameNotExistException ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                    case 2: {
                        try {
                            menuList.newPlayer(str);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                    case 4: {
                        try {
                            menuList.deletePlayer(str);
                        } catch (NameNotExistException ex) {
                            System.out.println(ex);
                        }
                        break;
                    }
                }
            } else if (pilihanMenu == 3 || pilihanMenu == 5 || pilihanMenu == 6) {
                switch (pilihanMenu) {
                    case 3: {
                        //menuList.showHighScore(menuList);
                        break;
                    }
                    case 5: {
                        if (menuList.logged()) {
                            /**
                             * new game
                             */
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
                    case 6: {
                        if (menuList.logged()) {
                            /**
                             * load game
                             */
                            try {
                                menuList.PlayGame(false);
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
            menuList.closePlayer();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
