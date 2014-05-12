package model;

import java.io.*;

public class Monster {
    private final int baseHP = 1;
    private int hitPoints;
    private int position_x;
    private int position_y;

    public Monster(int _position_x, int _position_y, int level) {
        hitPoints = baseHP * level;
        position_x = _position_x;
        position_y = _position_y;
    }

    public void decreaseHitPoints(int damage) {
        hitPoints = hitPoints - damage;
    }

    /*public void LevelUp(int level) {
        hitPoints = level * baseHP;
        position_x = 0;
        position_y = 0;

    }*/

    public void changePos(int _x, int _y) {
        position_x = _x;
        position_y = _y;
    }
    
    public void setHP(int HP) {
        hitPoints = HP;
    }

    public int getX() {
        return position_x;
    }

    public int getY() {
        return position_y;
    }
    
    public int getHP() {
        return hitPoints;
    }
}
