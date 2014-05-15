/*  File    : Tower.java
 Author  : Chrestella Stephanie (13512005) & Jan Wira Gotama Putra (13512015)
 */
package model;

public class Tower {

    public static final int attackIncreaseRate = 1;
    public static final int rateJual = 90; //in percent
    public static final int levelMax = 20;
    public static final int towerCost = 1;
    public static final int maxRange = 15;

    private int currentLevel;
    private int position_row;
    private int position_col;
    private int upgradeCost;
    private int attack;
    private int range;
    private int coolDown;
    private int coolDownCount;

    /**
     * Default constructor
     */
    public Tower(int pos_row, int pos_col) {
        currentLevel = 1;
        position_row = pos_row;
        position_col = pos_col;
        upgradeCost = 1;
        attack = 1;
        range = 5;
        coolDown = 1;
        coolDownCount = 0;
    }

    /**
     * set currentLevel to level
     */
    public void setCurrentLevel(int level) {
        currentLevel = level;
    }

    /**
     * set position_row to row
     */
    public void setPositionRow(int row) {
        position_row = row;
    }

    /**
     * set position_col to col
     */
    public void setPositionCol(int col) {
        position_col = col;
    }

    /**
     * set upgradeCost to cost
     */
    public void setUpgradeCost(int cost) {
        upgradeCost = cost;
    }

    /**
     * set attack to att
     */
    public void setAttack(int att) {
        attack = att;
    }

    /**
     * set range to r
     */
    public void setRange(int r) {
        range = r;
    }

    /**
     * set attackSpeed to attSpeed
     */
    public void setCoolDown(int attSpeed) {
        coolDown = attSpeed;
    }

    /**
     * decrease coolDownCount
     */
    public void resetCoolingDownTime() {
        coolDownCount = coolDown;
    }

    public void coolingDown() {
        if (coolDownCount > 0) {
            coolDownCount--;
        }
    }

    /**
     * return currentLevel
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * return position_row
     */
    public int getPositionRow() {
        return position_row;
    }

    /**
     * return position_col
     */
    public int getPositionCol() {
        return position_col;
    }

    /**
     * return upgradeCost
     */
    public int getUpgradeCost() {
        return upgradeCost;
    }

    /**
     * return attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * return range
     */
    public int getRange() {
        return range;
    }

    /**
     * return coolDownCount coolDownCount >0 means the tower cannot attack
     */
    public int getCoolDownCount() {
        return coolDownCount;
    }

    /**
     * shoot the enemy at (pos_x_enemy,pos_y_enemy) if the position is in range
     */
    public boolean rangeCheck(int enemy_row, int enemy_col, int row, int col) {
        //check if the enemy's position is in range
        //if so then shoot it! else tower cannot shot it
        //asumsi 0,0 di kiri atas
        boolean retval;
        int batasKiri, batasKanan, batasAtas, batasBawah;
        batasKiri = position_col - range;
        batasKanan = position_col + range;
        batasAtas = position_row - range;
        batasBawah = position_row + range;
        if (coolDownCount == 0) {
            if (enemy_col >= 0 && enemy_row >= 0 && enemy_row < row && enemy_col < col) {
                //System.out.println("Me : "+position_x+","+position_y+" Enemy :"+pos_x_enemy+","+pos_y_enemy);
                if (enemy_col >= batasKiri && enemy_col <= batasKanan && enemy_row <= batasBawah && enemy_row >= batasAtas) {
                    retval = true;
                } else {
                    retval = false;
                }
            } else {
                retval = false;
            }
        } else {
            retval = false;
        }
        return retval;
    }

    /**
     * upgrade the tower, precondition : player's gold is enough
     */
    public void upgradeTower() {
        //increase attack, attackSpeed and Cost by rate (static final variable)
        if (currentLevel < levelMax) {
            upgradeCost = upgradeCost + currentLevel;
            if (range < maxRange) {
                ++range;
            }
            attack = attack + (currentLevel * attackIncreaseRate);
            if (coolDown > 1) {
                coolDown--;
                coolDownCount = coolDown;
            }
        }
    }

    /**
     * sell the tower to get payback money
     */
    public int sellTower() {                                                                       // ini maksudnya public int sellTower? -> betul
        //menjual tower, mengembalikan uang sejumlah sekian persen dari cost terakhir tower
        return (int) Math.ceil(rateJual * upgradeCost / 100);
    }
}
