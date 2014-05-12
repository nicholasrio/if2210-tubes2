package model;

import java.io.*;

public class Monster {

    private int hitPoints;
    private int position_x;
    private int position_y;

    public Monster(int _position_x, int _position_y) {
        hitPoints = 100;
        position_x = _position_x;
        position_y = _position_y;
    }

    public void decreaseHitPoints(int damage) {
        hitPoints = hitPoints - damage;
    }

    public void LevelUp(int level) {
        hitPoints = level * hitPoints;
        position_x = 0;
        position_y = 0;

    }

    public void changePos(int _x, int _y) {
        position_x = _x;
        position_y = _y;
    }

    public int getX() {
        return position_x;
    }

    public int getY() {
        return position_y;
    }
}
