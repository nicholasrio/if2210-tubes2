/**
 *
 * @author 
 * Darwin Prasetio (13512015)
 * Chrestella Stephanie (13512005)
 * Jan Wira Gotama Putra (13512015)
 * Eric (13512021)
 * Willy(13512070)
 * Melvin FOnda (13512085)
 */

package controller;

import java.util.*;
import java.io.*;
import exception.*;
import model.Player;
import model.Tower;

public class MainMenu {

    private List<Player> players = new ArrayList<Player>();
    private Player loginPlayer;
    private static MainMenu instance = new MainMenu();
    
    /** Default Constructor */
    private MainMenu() {
    }
    
    /** Log player (username) to the game */
    public void Login(String username) throws NameNotExistException {
        int idx = searchPlayer(username);
        if (idx != -1) {
            loginPlayer = players.get(idx);
        } else {
            throw new NameNotExistException();
        }
    }

    /** Create new player within given username */
    public void newPlayer(String username) throws Exception {
        int idx = searchPlayer(username);
        if (idx != -1) {
            throw new NameExistException();
        } else {
            Player temp = new Player(username, 0);
            players.add(temp);
        }
    }

    /** Delete player within given username */
    public void deletePlayer(String username) throws NameNotExistException {
        int idx = searchPlayer(username);
        if (idx != -1) {
            players.remove(idx);
        } else {
            throw new NameNotExistException();
        }
    }
    
    /** Search player within given username */
    public int searchPlayer(String username) {
        int idx = -1;
        int i = 0;
        for (Player px : players) {
            if (username.equalsIgnoreCase(px.getName())) {
                idx = i;
                break;
            }
            i++;
        }
        return idx;
    }
    
    /** Playing tower defense game */
    public void PlayGame(boolean newGame) throws FileNotFoundException, IOException {
        Controller gameControl = Controller.getInstance();
        if (newGame==false) {
            gameControl.loadGame(loginPlayer);
        }
        else { 
            gameControl.newGame(loginPlayer);
        }
        Scanner in = new Scanner(System.in);
        int menu=0, pos_row=0, pos_col=0;
        /** Game menus */
        while (gameControl.getCurrentLevel() <= gameControl.getMaxLevel() && menu!=7) { //TO DO : inget diganti
            gameControl.showGame(true);
            menu = in.nextInt();
            if (menu<5) {
                System.out.print(">Position(row,col) ");
                pos_row = in.nextInt();
                pos_col = in.nextInt();
            }
            switch(menu) {
                case 1 : { //create tower 
                    boolean retval = gameControl.createNewTower(pos_row, pos_col);
                    break;
                }
                case 2 : { //sell tower
                    gameControl.sellTower(pos_row, pos_col);
                    break;
                }
                case 3 : { //upgrade tower
                    gameControl.upgradeTower(pos_row, pos_col);
                    break;
                }
                case 4 : { //see tower's info
                    gameControl.towerInfo(pos_row,pos_col);
                }
                case 5 : { //save game
                    gameControl.saveToFile();
                    break;
                }
                case 6 : { //level started
                    gameControl.spawnMonster();
                    /** game level started */
                    while (gameControl.countSeenMonster() > 0 && gameControl.getLives() > 0) {
                        gameControl.showGame(false);
                        gameControl.allTowersAttack();
                        gameControl.moveAllMonster();
                        gameControl.coolDownAllTower();
                        gameControl.showMonsterLive(); //for testing purpose only
                        if (gameControl.getScore() > loginPlayer.getHighScore()) {
                            loginPlayer.setHighScore(gameControl.getScore());
                        }    
                        in.nextLine();
                    }
                    if (gameControl.getLives()>0) {
                        System.out.println("Congratulations... you may advance to next level!");
                        gameControl.nextLevel();
                    }
                    else {
                        System.out.println("You lose!");
                    }
                    break;
                }
                case 7 : { break; } //quit game
                default : {
                    System.out.println("Menu not found!");
                    break;
                }
            }
        }
        if (gameControl.getCurrentLevel() > gameControl.getMaxLevel()) {
            System.out.println("Congratulation... you've win the game!");
        }    
        if (gameControl.getScore() > loginPlayer.getHighScore()) {
            loginPlayer.setHighScore(gameControl.getScore());
        }  
        int idx = searchPlayer(loginPlayer.getName());
        players.get(idx).setHighScore(loginPlayer.getHighScore());
    }

    /** Get player highscore */
    public List<Player> getHighScore() {
        SortPlayers();
        return players;
    }

    /** Load player data */
    public void loadPlayer() throws FileNotFoundException {
        String name;
        int score;
        File fin = new File("Playerlist.txt");
        Scanner in = new Scanner(fin);
        while (in.hasNext()) {
            name = in.next();
            score = in.nextInt();
            Player x = new Player(name, score);
            players.add(x);
        }
        in.close();
    }

    /** Sort palyers by highscore */
    private void SortPlayers() {
        for (int i = 0; i < players.size() - 1; i++) {
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(j).getHighScore() > players.get(i).getHighScore()) {
                    Player temp = players.get(j);
                    players.set(j, players.get(i));
                    players.set(i, temp);
                }
            }
        }
    }

    /** get this class instance */
    public static MainMenu getInstance() {
        return instance;
    }
    
    /** Showing Main menu */
    public void showMenus() {
        System.out.println("1. Login");
        System.out.println("2. New Player");
        System.out.println("3. High Scores");
        System.out.println("4. Detele Player");
        System.out.println("5. New Game");
        System.out.println("6. Load Game");
        System.out.println("7. Exit");
    }
    
    /** Save last player data to file */
    public void closePlayer() throws FileNotFoundException {
        String name;
        int score;
        File fin = new File("Playerlist.txt");
        PrintWriter out = new PrintWriter(fin);
        for (Player px : players) {
            out.println(px.getName());
            out.println(px.getHighScore());
        }
        out.flush();
    }
    
    /** True if there's any player logged to the game */
    public boolean logged() {
        return loginPlayer!=null;
    }
}
