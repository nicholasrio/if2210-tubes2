/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapAndCharacter;
import character.Character;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import map.Map;
/**
 *
 * @author Calvin
 */
public class MapAdapter {
    private Map M;
    private List<Character> LCharacter;
    private List<Point> LCharPos;
    public MapAdapter(Map M){
        this.M = M;
        LCharacter = new LinkedList<Character>();
        LCharPos = new LinkedList<Point>();
    }
    
    public Map getMap(){ return M;}
    
    // x dan y adalah posisi C
    public void addChar(Character C, int x,int y){
        LCharacter.add(C);
        LCharPos.add(new Point(x,y));
    }
    
    public List<Character> getAllCharacter(){
        return LCharacter;
    }
    
    public Character getCharByIndeks(int i){
        return LCharacter.get(i);
    }
    
    public Point getPos (Character C){
        int i = LCharacter.indexOf(C);
        assert(i>-1);
        return LCharPos.get(i);
    }
    
    public Point getPos (int i){
        return LCharPos.get(i);
    }
}
