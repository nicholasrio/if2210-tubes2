package controller;

/**
 *
 * @author wira gotama this is a singleton model class
 */
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.Collections;
import exception.*;
import model.*;

public class Controller {

    private List<Tower> listOfTower = Collections.synchronizedList(new ArrayList());
    private int maximumTower; //should be final
    private static Controller instance;
    private List<Monster> listOfMonster;
    private int currentLevel;
    private final int maximumLevel;
    private int score;
    private int gold;
    private int lives;
    private int start_x, start_y;
    private int[][] map;

    private Controller() {
        maximumLevel = 10;
    }

    public void newGame() {
        map = new int[ROW][COL];
        listOfTower = new ArrayList<>();
        listOfMonster = new ArrayList<>(); // misalkan 10 monster langsung keluar
        currentLevel = 1;
        score = 0;
        gold = 0;
        lives = INITIAL_LIFE;
    }

    public void loadGame() {

    }

    public void spawnMonster() {
        listOfMonster.add(new Monster(start_x, start_y));
    }

    /**
     * create new tower at position (pos_x, pos_y) if have enough money. return
     * true if the tower could be created
     *
     * @param pos_x
     * @param pos_y
     * @return
     */
    public boolean createNewTower(int pos_x, int pos_y) {
        /* ?Precondition, there should not exist any tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_x, pos_y);
        assert (idx == -1) : "There's already tower in there";
        if (idx == -1 && gold >= Tower.towerCost) {
            Tower temp = new Tower(pos_x, pos_y);
            listOfTower.add(temp);
            return true;
        } else {
            return false;
        }
    }

    public void moveAllMonster() {
        for (int it = 0; it < listOfMonster.size(); ++it) {
            /*
             int x_new = ambil dari bit map sesuai dengan posisinya sekarang
             int y_new = ambil dari bit map sesuai dengan posisinya sekarang
             */
            Monster M = listOfMonster.get(it);
            int x_new = M.getX();
            int y_new = M.getY();
            int arah = map[x_new][y_new] & 0xF;
            switch (arah) {
                case 1: {
                    x_new += 1;
                    break;
                }
                case 2: {
                    y_new += 1;
                    break;
                }
                case 4: {
                    x_new -= 1;
                    break;
                }
                case 8: {
                    y_new -= 1;
                    break;
                }
                default:
                    assert (false);
            }
            M.changePos(x_new, y_new);
        }
    }

    public void decreaseLive() {
        --lives;
    }

    public void nextLevel() {
        listOfMonster = new ArrayList<>();
        ++currentLevel;
        lives = INITIAL_LIFE;
    }

    /**
     * for testing purpose
     */
    public void getTower() {
        if (listOfTower.size() > 0) {
            System.out.println("ada");
        }
    }

    /**
     * sell (destroy) the tower at (pos_x, pos_y) to get pay back money
     *
     * @param pos_x
     * @param pos_y
     * @return
     */
    public int sellTower(int pos_x, int pos_y) {
        /* ?Precondition, there should exist a tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_x, pos_y);
        int payBack = 0;
        assert (idx != -1) : "Tower not found";
        if (idx != -1) {
            payBack = listOfTower.get(idx).sellTower();
            listOfTower.remove(idx);
        }
        return payBack;
    }

    /**
     * upgrade tower at position (pos_x, pos_y) if player's money is sufficient,
     *
     * @param pos_x
     * @param pos_y
     */
    public void upgradeTower(int pos_x, int pos_y) {
        /* ?Precondition, there should exist a tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_x, pos_y);
        assert (idx != -1) : "Tower not found";
        gold = gold - listOfTower.get(idx).getUpgradeCost();
        listOfTower.get(idx).upgradeTower();
    }

    /**
     * Enemies are being attacked by tower(s)
     */
    public void allTowersAttack() {
        //this requires map and MonsterListInstance
        int m = 5; //m adalah jumlah instans monster
        for (int i = 0; i < listOfTower.size(); i++) {
            for (int j = 0; j < listOfMonster.size(); ++j) {
                /* 
                 if (there's ')enemy in tower's sight, then attack those enemy
                 */
                Tower T = listOfTower.get(i);
                Monster M = listOfMonster.get(j);
                if (T.rangeCheck(M.getX(), M.getY())) {
                    M.decreaseHitPoints(T.getAttack());
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
     * get this class instance
     *
     * @return
     */
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    /**
     * Save ListOfTower to file
     *
     * @param out
     */
    public void saveToFile(PrintWriter out) {
        out.println(listOfTower.size());
        // TODO: ini perlu diubah
        for (int i = 0; i < listOfTower.size(); i++) {
            writeToFile(i, out);
        }
        out.flush();
    }

    /**
     * read from file, then create new tower
     *
     * @param in
     */
    public void readFromFile(Scanner in) {
        // TODO: ini perlu diubah
        int total = in.nextInt();
        for (int i = 0; i < total; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            // Ini ditambahkan di terakhir saja

            Tower temp = new Tower(x, y);
            temp.setCurrentLevel(in.nextInt());
            temp.setUpgradeCost(in.nextInt());
            temp.setAttack(in.nextInt());
            temp.setRange(in.nextInt());
            temp.setCoolDown(in.nextInt());
            listOfTower.add(temp);
        }
    }

    /**
     * Get tower (pos_x, pos_y) index in the list
     *
     * @param pos_x
     * @param pos_y
     * @return
     */
    public int getTowerIdx(int pos_x, int pos_y) {
        int simpan = -1;
        for (int i = 0; i < listOfTower.size(); i++) {
            if (listOfTower.get(i).getPositionX() == pos_x && listOfTower.get(i).getPositionY() == pos_y) {
                simpan = i;
                break;
            }
        }
        return simpan;
    }

    /**
     * write LisOfTower[idx] to file
     */
    private void writeToFile(int idx, PrintWriter out) {
        out.println(listOfTower.get(idx).getPositionX() + " "
                + listOfTower.get(idx).getPositionY() + " "
                + listOfTower.get(idx).getUpgradeCost() + " "
                + listOfTower.get(idx).getAttack() + " "
                + listOfTower.get(idx).getRange() + " "
                + listOfTower.get(idx).getCoolDownCount() + " "
                + listOfTower.get(idx).getCurrentLevel() + " ");
    }
    private static final int ROW = 25, COL = 80, INITIAL_LIFE = 5;
}
