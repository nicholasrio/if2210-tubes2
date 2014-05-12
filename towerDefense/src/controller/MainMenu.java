package controller;

import java.util.*;
import java.io.*;
import exception.*;
import model.Player;

public class MainMenu {

    private List<Player> players = new ArrayList<Player>();
    private String loginPlayer;
    private static MainMenu instance = new MainMenu();

    private MainMenu() {
    }

    public void Login(String username) throws NameNotExistException {
        int idx = searchPlayer(username);
        if (idx != -1) {
            loginPlayer = players.get(idx).getName();
        } else {
            throw new NameNotExistException();
        }
    }

    public void newPlayer(String username) throws Exception {
        int idx = searchPlayer(username);
        if (idx != -1) {
            throw new NameExistException();
        } else {
            Player temp = new Player(username, 0);
            players.add(temp);
        }
    }

    public void deletePlayer(String username) throws NameNotExistException {
        int idx = searchPlayer(username);
        if (idx != -1) {
            players.remove(idx);
        } else {
            throw new NameNotExistException();
        }
    }

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

    public void PlayGame() {
        //jalankan controller game
        //TODO, tambahkan playgame
    }

    public List<Player> getHighScore() {
        SortPlayers();
        return players;
    }

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

    public static MainMenu getInstance() {
        return instance;
    }
    
    public void showMenus() {
        System.out.println("1. Login");
        System.out.println("2. New Player");
        System.out.println("3. High Scores");
        System.out.println("4. Detele Player");
        System.out.println("5. New Game");
        System.out.println("6. Load Game");
        System.out.println("7. Exit");
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
    
    public boolean logged() {
        return loginPlayer!=null;
    }
}
