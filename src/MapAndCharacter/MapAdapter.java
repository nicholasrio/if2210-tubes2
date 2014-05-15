/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapAndCharacter;
import character.Character;
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
    private List<point> LCharPos;
    public MapAdapter(Map M){
        this.M = M;
        LCharacter = new LinkedList<Character>();
        LCharPos = new LinkedList<point>();
    }
    
    public Map getMap(){ return M;}
    
    // x dan y adalah posisi C
    public void addChar(Character C, int x,int y){
        LCharacter.add(C);
        LCharPos.add(new point(x,y));
    }
    
    public List<Character> getAllCharacter(){
        return LCharacter;
    }
    
    public Character getCharByIndeks(int i){
        return LCharacter.get(i);
    }
    
    public point getPos (Character C){
        int i = LCharacter.indexOf(C);
        assert(i>-1);
        return LCharPos.get(i);
    }
    
    public point getPos (int i){
        return LCharPos.get(i);
    }
}

class point{
        int x;
        int y;
        public point(int a,int b){x = a;y = b;}
        public void setPoint(int a,int b){x = a;y = b;}
        public int getX() {return x;}
        public int getY() {return y;}
    }