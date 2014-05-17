/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Opel Howard
 */
import controller.MainMenu;
import exception.NameNotExistException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Opel Howard, wiragotama
 */
public class TowerDefense {

    public static int pilihanMenu;
    public static String inputMenu;

    public static void main(String[] args) throws IOException {
        MainMenu menuList = MainMenu.getInstance();
        try {
            menuList.loadPlayer();
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
            if (pilihanMenu <= 2 && inputMenu == null) {
                pilihanMenu = 5;
            }
            switch (pilihanMenu) {
                case 1: {
                    try {
                        menuList.Login(inputMenu);
                    } catch (NameNotExistException ex) {
                        System.out.println(ex);
                    }
                    break;
                }
                case 2: {
                    try {
                        menuList.newPlayer(inputMenu);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    break;
                }
                case 3: {
                    pilihanMenu = 0;
                    display.showHighScore(menuList.getHighScore());
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
                        menuList.Login(inputMenu);
                        not_exist = false;
                    } catch (NameNotExistException ex) {
                        display.showWarning(ex.toString());
                    }
                    if (not_exist) {
                        if (display.showChoice("Create New User") == JOptionPane.YES_OPTION) {
                            display.showLogin("Input New Username");
                            try {
                                menuList.newPlayer(inputMenu);
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
                        menuList.deletePlayer(inputMenu);
                        inputMenu = null;
                    } catch (NameNotExistException ex) {
                        System.out.println(ex);
                    }
                    break;
                }
            }
        }
        System.exit(0);
    }
}
