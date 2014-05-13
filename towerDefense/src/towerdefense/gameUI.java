package towerdefense;

import model.*;
import controller.*;
import java.util.List;
import java.util.ArrayList;
import static model.Map.Peta;
import static model.Map.col;
import static model.Map.row;

public class gameUI {
    private static char MapView[][];
    
    public static void showTransition(Map m, Player player, int score, int lvl, int gold, int lvs,  List<Tower> T, List<Monster> M) {
        MapView = new char[Map.row][Map.col];
        makeMap(m,T,M);
        System.out.println("---------------------------------------------------------");
        System.out.println("Player name     : " + player.getName());
        System.out.println("Player score    : " + score);
        System.out.println("Current Level   : " + lvl);
        System.out.println("Current lives   : " + lvs);
        System.out.println("Current Gold    : " + gold);
        System.out.println("---------------------------------------------------------");
        for (int i=0; i<Map.row; i++) {
            for (int j=0; j<Map.col; j++) {
                System.out.print(MapView[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Menus : ");
        System.out.println("1. Create   Tower");
        System.out.println("2. Sell     Tower");
        System.out.println("3. Upgrade  Tower");
        System.out.println("4. Save     Game");
        System.out.println("5. Start    Level");
        System.out.println("6. Quit");
        System.out.println("---------------------------------------------------------");
        System.out.print(">");
    }
    
    public static void showMap(Map m, Player player, int score, int lvl, int gold,  List<Tower> T, List<Monster> M) {
        MapView = new char[Map.row][Map.col];
        makeMap(m,T,M);
        System.out.println("---------------------------------------------------------");
        for (int i=0; i<Map.row; i++) {
            for (int j=0; j<Map.col; j++) {
                System.out.print(MapView[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------");
    }
    
    private static void makeMap(Map m, List<Tower> T, List<Monster> M) {
        for (int i = 0; i < Map.row ; i ++)
                for (int j = 0; j < Map.col; j++)
                    if (Map.Peta[i][j]==256)
                           MapView[i][j] = '.';
                    else MapView[i][j] = '#';
        
        for (int i=0; i<T.size(); i++) {
            MapView[T.get(i).getPositionRow()][T.get(i).getPositionCol()] = 'T'; //tanda tower
        }
        for (int i=0; i<M.size(); i++) {
            if (M.get(i).getHP()>0) {
                if ((M.get(i).getRow() >=0 && M.get(i).getRow() < Map.row) && (M.get(i).getCol() >=0 && M.get(i).getCol() < Map.col)) 
                    MapView[M.get(i).getRow()][M.get(i).getCol()] = 'M'; //tanda tower
            }
        }
    }
}
