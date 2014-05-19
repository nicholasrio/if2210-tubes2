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

package gui;
import controller.MainMenuController;
import exception.NameNotExistException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class TowerDefense {

    public static int pilihanMenu;
    public static String inputMenu;

    public static void main(String[] args) throws IOException {
        MainMenuController mainMenu = MainMenuController.getInstance();
        try {
            mainMenu.loadPlayer();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            return;
        }

        MainMenuGUI display = new MainMenuGUI();

        while (pilihanMenu != 7) {
            pilihanMenu = 0;
            display.showMenu();
            while (pilihanMenu == 0) {
            };
            if (pilihanMenu <= 2 && (!mainMenu.logged())) {
                pilihanMenu = 5;
            }
            switch (pilihanMenu) {
                case 1: {
                    display.hide();
                    mainMenu.playGameGUI(true);
                    display.show();
                    break;
                }
                case 2: {
                    display.hide();
                    mainMenu.playGameGUI(false);
                    display.show();
                    break;
                }
                case 3: {
                    pilihanMenu = 0;
                    display.showHighScore(mainMenu.getHighScore());
                    while (pilihanMenu == 0) {
                    };
                    pilihanMenu = 0;
                    break;
                }
                case 4: {
                    pilihanMenu = 0;
                    display.showAbout();
                    while (pilihanMenu == 0) {
                    };
                    pilihanMenu = 0;
                    break;
                }
                case 5: {
                    pilihanMenu = 0;
                    inputMenu = "";

                    boolean not_exist = true;
                    display.showLogin("Input Username");
                    try {
                        mainMenu.login(inputMenu);
                        not_exist = false;
                    } catch (NameNotExistException ex) {
                        display.showWarning(ex.toString());
                    }
                    if (not_exist) {
                        if (display.showChoice("Create New User") == JOptionPane.YES_OPTION) {
                            display.showLogin("Input New Username");
                            try {
                                mainMenu.newPlayer(inputMenu);
                                not_exist = false;
                            } catch (Exception ex) {
                                display.showWarning(ex.toString());
                            }
                        }
                    }
                    break;
                }
                case 6: {
                    try {
                        mainMenu.deletePlayer(inputMenu);
                        inputMenu = null;
                    } catch (NameNotExistException ex) {
                        System.out.println(ex);
                    }
                    break;
                }
            }
        }
        try {
            mainMenu.closePlayer();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        System.exit(0);
    }
}
