/**
 *
 * @author wira gotama
 * this is a singleton model class
 */
import java.util.List;
import java.util.ArrayList;
import java.lang.AssertionError;
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Singleton {
    private  List<Tower> listOfTower = Collections.synchronizedList(new ArrayList());
    private  int maximumTower; //should be final
    private static Singleton instance;
    private List<Monster> listOfMonster;
    private int currentLevel;
    private final int maximumLevel;
    private int score;
    private int gold;
    private int lives;
    private int start_x, start_y;
    protected int[][] map;
    
    private Singleton() {
        map = new int[ROW][COL];
        listOfTower = new ArrayList<>();
        listOfMonster = new ArrayList<Monster>(); // misalkan 10 monster langsung keluar
        currentLevel = 1;
        maximumLevel = 5;
        score = 0;
        gold = 0;
        lives = INITIAL_LIFE;
    }
    
    
    /** create new tower at position (pos_x, pos_y) if have enough money. return true if the tower could be created */
    public boolean createNewTower(int pos_x, int pos_y, int money) {
    /* ?Precondition, there should not exist any tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_x, pos_y);
        assert(idx==-1) : "There's already tower in there";
        if (idx==-1 && money>=1) {
            Tower temp = new Tower(pos_x,pos_y);
            listOfTower.add(temp);
            return true;
        }
        else return false;
    }
    
    public void decreaseLive() {
        --lives;
    }
    
    public void nextLevel() {
        listOfMonster = new ArrayList<>();
        ++currentLevel;
        lives = INITIAL_LIFE;
    }
    
    /** for testing purpose */
    public void getTower() {
        if (listOfTower.size() > 0 ) {
            System.out.println("ada");
        }
    }
    
    /** sell (destroy) the tower at (pos_x, pos_y) to get pay back money */
    public int sellTower(int pos_x, int pos_y) {
    /* ?Precondition, there should exist a tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_x, pos_y);
        int payBack=0;
        assert(idx!=-1) : "Tower not found";
        if (idx!=-1) {
            payBack = listOfTower.get(idx).sellTower();
            listOfTower.remove(idx);
        }
        return payBack;
    }
    
    /** upgrade tower at position (pos_x, pos_y) if player's money is sufficient, return remaining money */
    public int upgradeTower(int pos_x, int pos_y, int money) {
    /* ?Precondition, there should exist a tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_x,pos_y);
        assert(idx!=-1) : "Tower not found";
        if (idx!=-1 && money >= listOfTower.get(idx).getUpgradeCost()) {
            int retval = money - listOfTower.get(idx).getUpgradeCost();
            listOfTower.get(idx).upgradeTower();
            return retval;
        }
        else return 0;
    }
    
    /** Enemies are being attacked by tower(s) */
    public void Attack() {
        //this requires map and MonsterListInstance
        int m = 5; //m adalah jumlah instans monster
        for (int i=0; i<listOfTower.size(); i++) {
            boolean Attacking = false;
            for (int j=0; j<m && !Attacking; j++) {
                /*if (ListOfTower.elementAt(i).rangeCheck(pos_x musuh, pos_y musuh)) {
                    Musuh kena tembakan...
                    ListOfTower.elementAt(i).resetCoolingDownTime();
                }
                */
            }
            /* if (there's ')enemy in tower's sight, then attack those enemy
            */
        }
    }
    
    /** CoolDown tower after attacking */
    public void CoolDownAllTower() {
         for (int i=0; i<listOfTower.size(); i++)
             listOfTower.get(i).coolingDown();
    }
    
    /** get this class instance
     * @return  */
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
    
    /** Save ListOfTower to file */
    public void saveToFile(PrintWriter out) {
        out.println(listOfTower.size());
        for (int i=0; i<listOfTower.size(); i++) {
           writeToFile(i,out); 
        }
        out.flush();
    }
    
    /** read from file, then create new tower
     * @param in */
    public void readFromFile(Scanner in) {
        int total = in.nextInt();
        for (int i=0; i<total; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Tower temp = new Tower(x,y);
            listOfTower.add(temp);
            readAttributes(i,in);
        }
    }
    
    /** Get tower (pos_x, pos_y) index in the list */
    private int getTowerIdx(int pos_x, int pos_y) {
        boolean stop = false;
        int simpan=-1;
        for (int i=0; i<listOfTower.size(); i++) {
            if (listOfTower.get(i).getPositionX()==pos_x && listOfTower.get(i).getPositionY()==pos_y) {
                stop = true;
                simpan = i;
            }
        }
        return simpan;
    }
    
    /** write LisOfTower[idx] to file */
    private void writeToFile(int idx, PrintWriter out) {
        out.println(listOfTower.get(idx).getPositionX() + " " +
                    listOfTower.get(idx).getPositionY() + " " +
                    listOfTower.get(idx).getUpgradeCost()+ " " +
                    listOfTower.get(idx).getAttack()+ " " +
                    listOfTower.get(idx).getRange()+ " " +
                    listOfTower.get(idx).getCoolDown()+ " " +
                    listOfTower.get(idx).getCurrentLevel()+ " ");
    }
    
    private void readAttributes(int idx, Scanner in) {
        int cost = in.nextInt(); listOfTower.get(idx).setUpgradeCost(cost);
        int att = in.nextInt(); listOfTower.get(idx).setAttack(att);
        int r = in.nextInt(); listOfTower.get(idx).setRange(r);
        int CD = in.nextInt(); listOfTower.get(idx).setCoolDown(CD);
        int level = in.nextInt(); listOfTower.get(idx).setCurrentLevel(level);
    }
    
    private static final int ROW = 25, COL = 80, INITIAL_LIFE = 5;
}
