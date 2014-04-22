package towerdefense;

import java.util.*;
import java.io.*;

/**
 *
 * @author Klongkgung, opelhoward
 */
public class GamePlay {

    protected int[][] map;
    private List<Tower> listOfTower;
    private List<Monster> listOfMonster;
    private int currentLevel;
    private final int maximumLevel;
    private int score;
    private int gold;
    private int lives;
    private int start_x, start_y, end_x, end_y;

    public GamePlay() {
        map = new int[ROW][COL];
        listOfTower = new ArrayList<>();
        listOfMonster = new ArrayList<Monster>(); // misalkan 10 monster langsung keluar
        currentLevel = 1;
        maximumLevel = 5;
        score = 0;
        gold = 0;
        lives = INITIAL_LIFE;
    }

    public void decreaseLive() {
        --lives;
    }

    public void buildTower(int pos_x, int pos_y) {
        listOfTower.add(new Tower(int pos_x
        , int pos_y
    

    

    ));
    }
    
    public void upgradeTower(int pos_x, int pos_y) {
        for (int it = 0; it < listOfTower.size(); it++) {
            Tower temp = listOfTower.get(it);
            if ((temp.getposition_x() == pos_x) && (temp.getposition_y() == pos_y)) {
                temp.upgrade();
                break;
            }
        }
    }

    public void nextLevel() {
        listOfMonster = new ArrayList<>();
        ++currentLevel;
        lives = INITIAL_LIFE;
    }

    public void spawnMonster() {
        listOfMonster.add(Monster());

    }

    private void run() throws FileNotFoundException {
        Scanner cin = new Scanner(new File("level1.txt"));
        while (cin.hasNext() || ((!listOfMonster.isEmpty()) && (lives > 0))) {
            if (cin.hasNext()) {
                spawnMonster();
            }
            for (int i = 0; i < listOfTower.size(); i++) {
                for (int j = 0; j < listOfMonster.size(); it++) {
                    Monster temp = listOfMonster.get(j);
                    if (listOfTower.get(i).rangeCheck(temp.getposition_x(), temp.getposition_y())) {
                        listOfTower.get(i).tembak();
                    }
                }
            }
            for (int j = 0; j < listOfMonster.size(); j++) {
                listOfMonster.get(j).move(); // HARUS DIPERBAIKI
                if ((listOfMonster.get(j).getposition_x() == end_x) && (listOfMonster.get(j).getposition_y() == end_y)) {
                    --lives;
                }
            }
        }

    }

    private static final int ROW = 25, COL = 80, INITIAL_LIFE = 5;
}
