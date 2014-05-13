package model;

public class Monster {

    private static final int BASE_HP = 1;
    private int hitPoints;
    private int position_row;
    private int position_col;

    public Monster(int _position_row, int _position_col, int level) {
        hitPoints = BASE_HP * level;
        position_row = _position_row;
        position_col = _position_col;
    }

    public void decreaseHitPoints(int damage) {
        hitPoints = hitPoints - damage;
    }

    public void changePos(int _row, int _col) {
        position_row = _row;
        position_col = _col;
    }

    public void setHP(int HP) {
        hitPoints = HP;
    }

    public int getRow() {
        return position_row;
    }

    public int getCol() {
        return position_col;
    }

    public int getHP() {
        return hitPoints;
    }
}
