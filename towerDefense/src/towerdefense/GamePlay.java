package towerdefense;

import java.util.*;
import java.io.*;

/**
 *
 * @author Klongkgung, opelhoward
 */
public class GamePlay {

    
    private List<Tower> listOfTower;
    

    public GamePlay() {
        
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

    
}
