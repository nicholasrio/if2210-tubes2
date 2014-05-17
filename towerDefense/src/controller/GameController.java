/**
 *
 * @author Darwin Prasetio (13512015) Chrestella Stephanie (13512005) Jan Wira
 * Gotama Putra (13512015) Eric (13512021) Willy(13512070) Melvin Fonda
 * (13512085)
 */
package controller;

import console.GameUI;
import gui.*;
import java.io.*;
import static java.lang.Thread.sleep;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

public class GameController {

    private List<Tower> listOfTower = Collections.synchronizedList(new ArrayList());
    private List<Monster> listOfMonster = new ArrayList<Monster>();
    private static final int ROW = 15, COL = 20, INITIAL_LIFE = 10;
    public static int menu, pos_row, pos_col;
    private static GameController instance;
    private final int maximumLevel;
    private final int goldRate = 5;
    
    private model.Player player;
    private int currentLevel;
    private int score;
    private int gold;
    private int lives;
    private final int start_row = 2, start_col = 0;
    private final int monsterCount = 10;
    private model.Map map;

    /**
     * Default consructor
     */
    private GameController() {
        maximumLevel = 2; //buat testing dulu
    }

    /**
     * Show every monster hit point's to console
     */
    public void showMonsterLive() {
        for (int i = 0; i < listOfMonster.size(); i++) {
            if (listOfMonster.get(i).getHP()>0)
                System.out.println("Monster ke-" + i + " " + listOfMonster.get(i).getHP());
        }
    }

    /**
     * New game initialization
     */
    public void newGame(Player x) throws FileNotFoundException, IOException {
        map.readFile();
        player = x;
        currentLevel = 1;
        score = 0;
        gold = 10;
        lives = INITIAL_LIFE;
    }

    /**
     * Load player x's last game
     */
    public void loadGame(Player x) throws FileNotFoundException, IOException {
        player = x;
        map.readFile();
        String filename = player.getName() + ".txt";
        Scanner in = new Scanner(new File(filename));
        readFromFile(in);
    }

    /**
     * Spawn monster
     */
    public void spawnMonster() {
        for (int i = 0; i < monsterCount; i++) {
            listOfMonster.add(new Monster(start_row, start_col - i, currentLevel));
        }
    }

    /**
     * create new tower at position (pos_x, pos_y) if have enough money. return
     * true if the tower could be created
     *
     * @param pos_row
     * @param pos_col
     * @return
     */
    public boolean createNewTower(int pos_row, int pos_col) {
        /* ?Precondition, there should not exist any tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_row, pos_col);
        assert (idx == -1) : "There's already tower in there";
        if (idx == -1 && gold >= Tower.towerCost) {
            Tower temp = new Tower(pos_row, pos_col);
            listOfTower.add(temp);
            gold -= Tower.towerCost;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Move all monster to their next position
     */
    public void moveAllMonster() {
        for (int it = 0; it < listOfMonster.size(); ++it) {
            /*
             int x_new = ambil dari bit map sesuai dengan posisinya sekarang
             int y_new = ambil dari bit map sesuai dengan posisinya sekarang
             */
            Monster M = listOfMonster.get(it);
            if (M.getHP() > 0) {
                int row_new = M.getRow();
                int col_new = M.getCol();
                if (row_new >= 0 && row_new < map.row && col_new >= 0 && col_new < map.col) {
                    int arah = map.Peta[row_new][col_new] & 0xF;
                    switch (arah) {
                        case 1: {
                            col_new += 1;
                            break;
                        }
                        case 2: {
                            row_new -= 1;
                            break;
                        }
                        case 4: {
                            col_new -= 1;
                            break;
                        }
                        case 8: {
                            row_new += 1;
                            break;
                        }
                        default:
                            assert (false);
                    }
                } else {
                    col_new += 1;
                }
                M.changePos(row_new, col_new);
                if (col_new == 20) { //masuk ke rumah kita
                    decreaseLive();
                }
            }
        }
    }

    /**
     * Count current seen Monster on the UI
     */
    public int countSeenMonster() {
        int count = 0;
        for (int i = 0; i < listOfMonster.size(); i++) {
            if ((listOfMonster.get(i).getCol() < map.col && listOfMonster.get(i).getCol() >= 0)
                    && (listOfMonster.get(i).getRow() < map.row && listOfMonster.get(i).getRow() >= 0)) {
                if (listOfMonster.get(i).getHP() > 0) {
                    ++count;
                }
            }
        }
        return count;
    }

    /**
     * Decrease player's live
     */
    public void decreaseLive() {
        --lives;
    }

    /**
     * Go to next level
     */
    public void nextLevel() {
        listOfMonster = new ArrayList<Monster>();
        ++currentLevel;
        gold = gold + (goldRate * currentLevel);
    }

    /**
     * Sell (destroy) the tower at (pos_x, pos_y) to get pay back money
     *
     * @param pos_row
     * @param pos_col
     * @return
     */
    public void sellTower(int pos_row, int pos_col) {
        /* ?Precondition, there should exist a tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_row, pos_col);
        int payBack = 0;
        assert (idx != -1) : "Tower not found";
        if (idx != -1) {
            payBack = listOfTower.get(idx).sellTower();
            listOfTower.remove(idx);
        }
        gold = gold + payBack;
    }

    /**
     * Get tower at idx
     */
    public Tower getTower(int idx) {
        return listOfTower.get(idx);
    }

    /**
     * Upgrade tower at position (pos_x, pos_y) if player's money is sufficient,
     *
     * @param pos_row
     * @param pos_col
     */
    public void upgradeTower(int pos_row, int pos_col) {
        /* ?Precondition, there should exist a tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_row, pos_col);
        assert (idx != -1) : "Tower not found";
        if (listOfTower.get(idx).getUpgradeCost() <= gold) {
            gold = gold - listOfTower.get(idx).getUpgradeCost();
            listOfTower.get(idx).upgradeTower();
        }
    }

    /**
     * Enemies are being attacked by tower(s)
     */
    public void allTowersAttack() {
        System.out.println("Attacking!");
        for (int i = 0; i < listOfTower.size(); i++) {
            System.out.println("Tower ke-" + i + " Cooldown : " + listOfTower.get(i).getCoolDownCount());
            for (int j = 0; j < listOfMonster.size(); ++j) {
                /* 
                 if (there's ')enemy in tower's sight, then attack those enemy
                 */
                if (listOfMonster.get(j).getHP() > 0 && listOfMonster.get(j).getCol() >= 0
                        && listOfTower.get(i).rangeCheck(listOfMonster.get(j).getRow(), listOfMonster.get(j).getCol(), map.row, map.col)) {
                    listOfTower.get(i).resetCoolingDownTime();
                    listOfMonster.get(j).decreaseHitPoints(listOfTower.get(i).getAttack());
                    if (listOfMonster.get(j).getHP() <= 0) {
                        ++score;
                    }
                    break;
                }
            }
        }
    }

    /**
     * CoolDown tower after attacking
     */
    public void coolDownAllTower() {
        for (int i = 0; i < listOfTower.size(); i++) {
            listOfTower.get(i).coolingDown();
        }
    }

    /**
     * Get this class instance
     *
     * @return
     */
    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    /**
     * Save ListOfTower to file and ListOfMonster
     *
     * @param out
     */
    public void saveToFile() throws IOException {
        File file = new File(player.getName() + ".txt");
        FileWriter writer = new FileWriter(file);
        PrintWriter out = new PrintWriter(writer);
        out.println(score);
        out.println(gold);
        out.println(currentLevel);
        out.println(lives);
        out.println(listOfTower.size());
        for (int i = 0; i < listOfTower.size(); i++) {
            writeTowerToFile(i, out);
        }
        out.println(listOfMonster.size());
        for (int i = 0; i < listOfMonster.size(); i++) {
            writeMonsterToFile(i, out);
        }
        out.flush();
        out.close();
        writer.close();
    }

    /**
     * Read saved game from file, then create new tower and monster
     *
     * @param in
     */
    public void readFromFile(Scanner in) {
        score = in.nextInt();
        gold = in.nextInt();
        currentLevel = in.nextInt();
        lives = in.nextInt();
        int total = in.nextInt();
        for (int i = 0; i < total; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            // Ini ditambahkan di terakhir saja

            Tower temp = new Tower(x, y);
            temp.setUpgradeCost(in.nextInt());
            temp.setAttack(in.nextInt());
            temp.setRange(in.nextInt());
            temp.setCoolDown(in.nextInt());
            temp.setCurrentLevel(in.nextInt());
            listOfTower.add(temp);
        }
        total = in.nextInt();
        for (int i = 0; i < total; i++) {
            int HP = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            // Ini ditambahkan di terakhir saja

            Monster temp = new Monster(x, y, currentLevel);
            temp.setHP(HP);
            listOfMonster.add(temp);
        }
    }

    /**
     * Get tower (pos_x, pos_y) index in the list
     *
     * @param pos_row
     * @param pos_col
     * @return index of tower in that position
     */
    public int getTowerIdx(int pos_row, int pos_col) {
        int simpan = -1;
        for (int i = 0; i < listOfTower.size(); i++) {
            if (listOfTower.get(i).getPositionRow() == pos_row && listOfTower.get(i).getPositionCol() == pos_col) {
                simpan = i;
                break;
            }
        }
        return simpan;
    }

    /**
     * Write tower data to file
     */
    private void writeTowerToFile(int idx, PrintWriter out) {
        out.println(listOfTower.get(idx).getPositionRow() + " "
                + listOfTower.get(idx).getPositionCol() + " "
                + listOfTower.get(idx).getUpgradeCost() + " "
                + listOfTower.get(idx).getAttack() + " "
                + listOfTower.get(idx).getRange() + " "
                + listOfTower.get(idx).getCoolDownCount() + " "
                + listOfTower.get(idx).getCurrentLevel() + " ");
    }

    /**
     * Write Monster data to file
     */
    private void writeMonsterToFile(int idx, PrintWriter out) {
        out.println(listOfMonster.get(idx).getHP() + " "
                + listOfMonster.get(idx).getRow() + " "
                + listOfMonster.get(idx).getCol());
    }

    /**
     * Show game UI
     */
    public void showGame(boolean ingame) {
        if (ingame) {
            GameUI.showTransition(instance);
        } else {
            GameUI.showGame(instance);
        }
    }

    /**
     * Get List of tower
     */
    public List<Tower> getListOfTower() {
        return listOfTower;
    }

    /**
     * Get List of monster
     */
    public List<Monster> getListOfMonster() {
        return listOfMonster;
    }

    /**
     * Get map
     */
    public model.Map getMap() {
        return map;
    }

    /**
     * Get player
     */
    public model.Player getPlayer() {
        return player;
    }

    /**
     * Get current level
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Get maximum level of the game
     */
    public int getMaxLevel() {
        return maximumLevel;
    }

    /**
     * Get player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * Get player's lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * Get player's gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * Give tower information at (row,col)
     */
    public void towerInfo(int row, int col) {
        int idx = getTowerIdx(row, col);
        Tower t = listOfTower.get(idx);
        GameUI.showTowerInfo(t);
    }

    /**
     * Gaming mode
     */
    public Player playGameConsole(Player loginPlayer) {
        Scanner in = new Scanner(System.in);
        //int menu = 0, pos_row = 0, pos_col = 0;
        /**
         * Game menus
         */
        while (getCurrentLevel() <= getMaxLevel() && menu != 7) { //TO DO : inget diganti
            showGame(true);
            menu = in.nextInt();
            if (menu < 5) {
                System.out.print(">Position(row,col) ");
                pos_row = in.nextInt();
                pos_col = in.nextInt();
            }
            switch (menu) {
                case 1: { //create tower 
                    boolean retval = createNewTower(pos_row, pos_col);

                    break;
                }
                case 2: { //sell tower
                    sellTower(pos_row, pos_col);
                    break;
                }
                case 3: { //upgrade tower
                    upgradeTower(pos_row, pos_col);
                    break;
                }
                case 4: { //see tower's info
                    towerInfo(pos_row, pos_col);
                }
                case 5: {
                    try {
                        //save game
                        saveToFile();
                    } catch (IOException ex) {
                        Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 6: { //level started
                    spawnMonster();
                    /**
                     * game level started
                     */
                    while (countSeenMonster() > 0 && getLives() > 0) {
                        showGame(false);
                        allTowersAttack();
                        moveAllMonster();
                        coolDownAllTower();
                        showMonsterLive(); 
                        if (getScore() > loginPlayer.getHighScore()) {
                            loginPlayer.setHighScore(getScore());
                        }
                        in.nextLine();
                    }
                    if (getLives() > 0) {
                        System.out.println("Congratulations... you may advance to next level!");
                        nextLevel();
                    } else {
                        System.out.println("You lose!");
                    }
                    break;
                }
                case 7: {
                    break;
                } //quit game
            }
        }
        if (getCurrentLevel() > getMaxLevel()) {
            System.out.println("Congratulation... you've win the game!");
        }
        return loginPlayer;
    }
    

    public Player playGameGUI(Player loginPlayer) throws IOException {
        gui.MapGUI mapGUI = new gui.MapGUI(getInstance());
        //int pos_row = 0, pos_col = 0;
        menu = 0;
        pos_row = 0;
        pos_col = 0;
        /**
         * Game menus
         */
        boolean exit = false;
        while (menu != 7) {
            while (menu == 0) {
            }
            switch (menu) {
                case 1: { //create tower 
                    mapGUI.hide();
                    boolean retval = createNewTower(pos_row, pos_col);
                    if (retval) {
                        mapGUI.changeStatus();
                        mapGUI.status.updateUI();
                        mapGUI.mainFrame.repaint();
                    }
                    mapGUI.show();
                    break;
                }
                case 2: { //sell tower
                    mapGUI.hide();
                    sellTower(pos_row, pos_col);
                    mapGUI.changeStatus();
                    mapGUI.status.updateUI();
                    mapGUI.mainFrame.repaint();
                    mapGUI.show();
                    break;
                }
                case 3: { //upgrade tower
                    mapGUI.hide();
                    upgradeTower(pos_row, pos_col);
                    mapGUI.changeStatus();
                    mapGUI.status.updateUI();
                    mapGUI.mainFrame.repaint();
                    mapGUI.show();
                    break;
                }
                case 5: {
                    try {
                        //save game
                        saveToFile();
                    } catch (IOException ex) {
                        Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 6: { //level started
                    spawnMonster();
                    mapGUI.hide();
                    /**
                     * game level started
                     */

                    while (countSeenMonster() > 0 && getLives() > 0) {
                        //showGame(false);
                        allTowersAttack();
                        moveAllMonster();
                        try {
                            Thread.sleep(333);
                        } catch (InterruptedException ex) {
                            System.out.println("Alpha");
                        }

                        coolDownAllTower();
                        if (getScore() > loginPlayer.getHighScore()) {
                            loginPlayer.setHighScore(getScore());
                        }
                        mapGUI.hide();
                        mapGUI.changeStatus();
                        mapGUI.status.updateUI();
                        mapGUI.mainFrame.repaint();
                        mapGUI.show();
                    }
                    mapGUI.hide();
                    mapGUI.changeStatus();
                    mapGUI.status.updateUI();
                    mapGUI.mainFrame.repaint();
                    mapGUI.show();

                    if (getLives() > 0) {
                        mapGUI.addAnnouncement("Congratulations... you may advance to next level!");
                        nextLevel();
                    } else {
                        mapGUI.addAnnouncement("You lose!");
                        break;
                    }
                    
                    if (getCurrentLevel() > getMaxLevel()) {
                        mapGUI.addAnnouncement("Congratulation... you've win the game!");
                    }
                    break;
                }
                case 7: {
                    mapGUI.hide();
                    break;
                }
            }
            if (menu!=7)
                menu = 0;
        }
        return loginPlayer;
    }
}
