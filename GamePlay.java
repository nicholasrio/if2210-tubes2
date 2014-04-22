package towerdefense;

import java.util.List;

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
    
    public GamePlay() {
        map = new int[ROW][COL];
        listOfTower = new List<Tower>();
        listOfMonster = new List<Monster>();
        currentLevel = 1;
        maximumLevel = 5;
        score = 0;
        gold = 0;
        lives = 5;
    }
    
    public void decreaseLive() {
        --lives;
    }
    
    public void buildTower(int pos_x, int pos_y) {}
    
    public void updateTower(int pos_x, int pos_y) {}
    
    public void nextLevel() {}
    
    public void spawnMonster() {}
    
    private simulate() {
        for (Tower )
    }
    
    private static final int ROW = 25, COL = 80;
}
