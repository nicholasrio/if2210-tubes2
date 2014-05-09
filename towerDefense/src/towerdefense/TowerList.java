/**
 *
 * @author wira gotama
 * this is a singleton model class
 */
import java.util.List;
import java.util.ArrayList;
import java.lang.Exception;
import java.util.Collections;

public class TowerList {
    private  List<Tower> ListOfTower = Collections.synchronizedList(new ArrayList());
    private  int maximumTower; //should be final
    private static TowerList instance;
    
    private TowerList() {}
    
    /** create new tower at position (pos_x, pos_y) if have enough money. return true if the tower could be created */
    public boolean createNewTower(int pos_x, int pos_y, int money) throws Exception {
    /* ?Precondition, there should not exist any tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_x, pos_y);
        if (idx!=-1) {
            throw new Exception("Tower already created there");
        }
        else if (money>=1) {
            Tower temp = new Tower(pos_x,pos_y);
            ListOfTower.add(temp);
            return true;
        }
        else return false;
    }
    
    /** for testing purpose */
    public void getTower() {
        if (ListOfTower.size() > 0 ) {
            System.out.println("ada");
        }
    }
    
    /** sell (destroy) the tower at (pos_x, pos_y) to get pay back money */
    public int sellTower(int pos_x, int pos_y) {
    /* ?Precondition, there should exist a tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_x, pos_y);
        int payBack=0;
        if (idx!=-1) {
            payBack = ListOfTower.get(idx).sellTower();
            ListOfTower.remove(idx);
            return payBack;
        }
        else return 0;
    }
    
    /** upgrade tower at position (pos_x, pos_y) if player's money is sufficient, return remaining money */
    public int upgradeTower(int pos_x, int pos_y, int money) throws Exception {
    /* ?Precondition, there should exist a tower at position (pos_x, pos_y) */
        int idx = getTowerIdx(pos_x,pos_y);
        if (idx==-1) { 
            throw new Exception("There's no tower there");
        }
        else if (idx!=-1) {
            if (money >= ListOfTower.get(idx).getUpgradeCost()) {
                int retval = money - ListOfTower.get(idx).getUpgradeCost();
                ListOfTower.get(idx).upgradeTower();
                return retval;
            }
        } 
        return 0;
    }
    
    /** Enemies are being attacked by tower(s) */
    public void Attack() {
        //this requires map and MonsterListInstance
        int m = 5; //m adalah jumlah instans monster
        for (int i=0; i<ListOfTower.size(); i++) {
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
         for (int i=0; i<ListOfTower.size(); i++)
             ListOfTower.get(i).coolingDown();
    }
    
    /** get this class instance
     * @return  */
    public static TowerList getInstance() {
        if (instance == null)
            instance = new TowerList();
        return instance;
    }
    
    /** Get tower (pos_x, pos_y) index in the list */
    private int getTowerIdx(int pos_x, int pos_y) {
        boolean stop = false;
        int simpan=-1;
        for (int i=0; i<ListOfTower.size(); i++) {
            if (ListOfTower.get(i).getPositionX()==pos_x && ListOfTower.get(i).getPositionY()==pos_y) {
                stop = true;
                simpan = i;
            }
        }
        return simpan;
    }
}
