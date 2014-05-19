/**
 *
 * @author 
 * Darwin Prasetio (13512015)
 * Chrestella Stephanie (13512005)
 * Jan Wira Gotama Putra (13512015)
 * Eric (13512021)
 * Willy(13512070)
 * Melvin Fonda (13512085)
 */

package model;

public class Monster {

    private static final int BASE_HP = 1;
    private int hitPoints;
    private int position_row;
    private int position_col;

    /** 
     * Default constructor 
     */
    public Monster(int _position_row, int _position_col, int level) {
        hitPoints = BASE_HP * level;
        position_row = _position_row;
        position_col = _position_col;
    }

    /** 
     * Decrease monster hitPoints by damage 
     */
    public void decreaseHitPoints(int damage) {
        hitPoints = hitPoints - damage;
    }

    /** 
     * Change monster position to (row, col) 
     */
    public void changePos(int _row, int _col) {
        position_row = _row;
        position_col = _col;
    }

    /** 
     * Set monster hitPoints to HP 
     */
    public void setHP(int HP) {
        hitPoints = HP;
    }

    /** 
     * Get monster position row 
     */
    public int getRow() {
        return position_row;
    }

    /** 
     * Get monster position column 
     */
    public int getCol() {
        return position_col;
    }

    /** 
     * Get monster hitPoints 
     */
    public int getHP() {
        return hitPoints;
    }
}
