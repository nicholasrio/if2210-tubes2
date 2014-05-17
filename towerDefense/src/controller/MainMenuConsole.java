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
package controller;

import java.util.*;
import java.io.*;
import exception.*;
import model.Player;

public class MainMenuConsole {

    private List<Player> players = new ArrayList<Player>();
    private Player loginPlayer;
    private static MainMenuConsole instance = new MainMenuConsole();

    /**
     * Default Constructor
     */
    private MainMenuConsole() {
    }

    /**
     * Log player (username) to the game
     */
    public void login(String username) throws NameNotExistException {
        int idx = searchPlayer(username);
        if (idx != -1) {
            loginPlayer = players.get(idx);
        } else {
            throw new NameNotExistException();
        }
    }

    /**
     * Create new player within given username
     */
    public void newPlayer(String username) throws Exception {
        int idx = searchPlayer(username);
        if (idx != -1) {
            throw new NameExistException();
        } else {
            Player temp = new Player(username, 0);
            players.add(temp);
        }
    }

    /**
     * Delete player within given username
     */
    public void deletePlayer(String username) throws NameNotExistException {
        int idx = searchPlayer(username);
        if (idx != -1) {
            players.remove(idx);
        } else {
            throw new NameNotExistException();
        }
    }

    /**
     * Search player within given username
     */
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

    /**
     * Playing tower defense game
     */
    public void playGame(boolean newGame) throws FileNotFoundException, IOException {
        GameController gameControl = GameController.getInstance();
        if (newGame == false) {
            gameControl.loadGame(loginPlayer);
        } else {
            gameControl.newGame(loginPlayer);
        }
        loginPlayer = gameControl.playGame(loginPlayer);
        int idx = searchPlayer(loginPlayer.getName());
        players.get(idx).setHighScore(loginPlayer.getHighScore());
    }

    /**
     * Get player highscore
     */
    public List<Player> getHighScore() {
        SortPlayers();
        return players;
    }

    /**
     * Load player data
     */
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

    /**
     * Sort palyers by highscore
     */
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

    /**
     * get this class instance
     * @return 
     */
    public static MainMenuConsole getInstance() {
        return instance;
    }

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

    /**
     * True if there's any player logged to the game
     */
    public boolean logged() {
        return loginPlayer != null;
    }
}
