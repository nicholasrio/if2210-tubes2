package controller;

import java.util.*;
import java.io.*;
import exception.*;
import model.Player;

public class MainMenu {

    private List<Player> players = new ArrayList<Player>();
    private Player loginPlayer;
    private static MainMenu instance = new MainMenu();
    
    private MainMenu() {
    }
    
    public void Login(String username) throws NameNotExistException {
        int idx = searchPlayer(username);
        if (idx != -1) {
            loginPlayer = players.get(idx);
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

    public void PlayGame(boolean newGame) throws FileNotFoundException, IOException {
        Controller gameControl = Controller.getInstance();
        if (newGame==false) {
            gameControl.loadGame(loginPlayer);
        }
        else { 
            gameControl.newGame(loginPlayer);
        }
        Scanner in = new Scanner(System.in);
        int menu=0, pos_x=0, pos_y=0;
        while (gameControl.getCurrentLevel() <= gameControl.getMaxLevel() && menu!=6) { //TO DO : inget diganti
            gameControl.showGame(true);
            menu = in.nextInt();
            if (menu==1 || menu==2 || menu==3) {
                System.out.print(">Position(x,y) ");
                pos_x = in.nextInt();
                pos_y = in.nextInt();
            }
            switch(menu) {
                case 1 : {
                    boolean retval = gameControl.createNewTower(pos_x, pos_y);
                    break;
                }
                case 2 : {
                    gameControl.sellTower(pos_x, pos_y);
                    break;
                }
                case 3 : {
                    gameControl.upgradeTower(pos_x, pos_y);
                    break;
                }
                case 4 : {
                    gameControl.saveToFile();
                    break;
                }
                case 5 : {
                    gameControl.spawnMonster();
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
                case 6 : { break; }
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
