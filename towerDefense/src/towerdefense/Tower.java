/*  File    : Tower.java
 Author  : Chrestella Stephanie (13512005) & Jan Wira Gotama Putra (13512015)
 */
package towerdefense;

public class Tower {

    public static final int attackIncreaseRate = 10; //in percent
    public static final int coolDownRate = 10; //in percent
    public static final int maximum_speed = 100;
    public static final int costIncreaseRate = 10; //in percent
    public static final int rateJual = 90; //in percent
    public static final int level_max = 20;
    private int currentLevel;
    private int position_x;
    private int position_y;
    private int upgradeCost;
    private int attack;
    private int range;
    private int coolDown;
    private int coolDownCount;

    /**
     * Default constructor
     */
    public Tower(int pos_x, int pos_y) {
        currentLevel = 1;
        position_x = pos_x;
        position_y = pos_y;
        upgradeCost = 1;
        attack = 1;
        range = 5;
        coolDown = 10;
    }

    /**
     * set currentLevel to level
     *
     * @param level
     */
    protected void setCurrentLevel(int level) {
        currentLevel = level;
    }

    /**
     * set position_x to pos_x
     */
    protected void setPositionX(int pos_x) {
        position_x = pos_x;
    }

    /**
     * set position_y to pos_y
     */
    protected void setPositionY(int pos_y) {
        position_y = pos_y;
    }

    /**
     * set upgradeCost to cost
     */
    protected void setUpgradeCost(int cost) {
        upgradeCost = cost;
    }

    /**
     * set attack to att
     */
    protected void setAttack(int att) {
    }

    /**
     * set range to r
     */
    protected void setRange(int r) {
    }

    /**
     * set attackSpeed to attSpeed
     */
    protected void setAttackSpeed(int attSpeed) {
    }

    /**
     * return currentLevel
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * return position_x
     */
    public int getPositionX() {
        return position_x;
    }

    /**
     * return position_y
     */
    public int getPositionY() {
        return position_y;
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
     * return attackSpeed
     */
    public int getAttackSpeed() {
        return coolDown;
    }

    /**
     * shoot the enemy at (pos_x_enemy,pos_y_enemy) if the position is in range
     */
    public boolean rangeCheck(int pos_x_enemy, int pos_y_enemy) {
        //check if the enemy's position is in range
        //if so then shoot it! else tower cannot shot it
    }

    /**
     * upgrade the tower, precondition : player's gold is enough
     */
    public void upgradeTower() {
        //increase attack, attackSpeed and Cost by rate (static final variable)
    }

    public int sellTower() {
        //menjual tower, mengembalikan uang sejumlah sekian persen dari cost terakhir tower
    }
}
