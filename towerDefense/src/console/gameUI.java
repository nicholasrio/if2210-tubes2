/**
 *
 * @author 
 * Darwin Prasetio (13512015)
 * Chrestella Stephanie (13512005)
 * Jan Wira Gotama Putra (13512015)
 * Eric (13512021)
 * Willy(13512070)
 * Melvin FOnda (13512085)
 */

package console;

import model.*;
import controller.*;
import java.util.List;
import java.util.ArrayList;
import static model.Map.Peta;
import static model.Map.col;
import static model.Map.row;

public class gameUI {
    private static char MapView[][];
    
    /** Showing game transition UI */
    public static void showTransition(Controller controller) {
        model.Map Map = controller.getMap();
        List <Tower> T = controller.getListOfTower();
        List <Monster> M = controller.getListOfMonster();
        MapView = new char[Map.row][Map.col];
        makeMap(Map,T,M);
        System.out.println("---------------------------------------------------------");
        System.out.println("Player name     : " + controller.getPlayer().getName());
        System.out.println("Player score    : " + controller.getScore());
        System.out.println("Current Level   : " + controller.getCurrentLevel());
        System.out.println("Current lives   : " + controller.getLives());
        System.out.println("Current Gold    : " + controller.getGold());
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
        System.out.println("4. Tower    Info");
        System.out.println("5. Save     Game");
        System.out.println("6. Start    Level");
        System.out.println("7. Quit");
        System.out.println("---------------------------------------------------------");
        System.out.print(">");
    }
    
    /** Showing game started - UI */
    public static void showMap(Controller controller) {
        model.Map Map = controller.getMap();
        List <Tower> T = controller.getListOfTower();
        List <Monster> M = controller.getListOfMonster();
        MapView = new char[Map.row][Map.col];
        makeMap(Map,T,M);
        System.out.println("---------------------------------------------------------");
        for (int i=0; i<Map.row; i++) {
            for (int j=0; j<Map.col; j++) {
                System.out.print(MapView[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------");
    }
    
    /** Make map view for UI */
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
