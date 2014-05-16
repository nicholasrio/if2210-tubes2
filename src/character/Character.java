package character;

import map.*;
import java.awt.Graphics2D;

public abstract class Character extends MapEntity implements Cloneable{
    protected int _str;
    protected int _agi;
    protected int _int;

    protected Map map;
    protected int _currentHealth;
    protected int _currentMana;
    protected int _maxHealth;
    protected int _maxMana;
     
    //movement attribute
    protected boolean movingDown;
    protected boolean movingUp;
    protected boolean movingLeft;
    protected boolean movingRight;
    protected int moveSpeed;
    protected enum direction {DOWN,LEFT,RIGHT,UP};
    protected direction faceDirection;
    
    public Character(Map map){
        this.map = map;
    }
    
    public int getStr() { return _str; }
    public int getAgi() { return _agi; }
    public int getInt() { return _int; }
    public int getCurrentHealth(){ return _currentHealth; }
    public int getCurrentMana(){ return _currentMana; }
    public int getMaxHealth(){ return _maxHealth;}
    public int getMaxMana(){ return _maxMana;} 

    public void setStr(int x){ this._str = x; }
    public void setAgi(int x){ this._agi = x; }
    public void setInt(int x){ this._int = x; }
    public void setMaxHealth(int x){ this._maxHealth = x;}
    public void setMaxMana(int x){ this._maxMana = x;}
    
    
    //Cek apakah karakter menabrak dinding
    public void checkTileCollision(){
        boolean walkable=true;
        int tileWidth = TileImagePrototype.tileWidth;
        int tileHeight = TileImagePrototype.tileHeight;
        if (movingUp){
            walkable = map.getCell((int)x/tileWidth,(int)(y/tileHeight)).isWalkable();
            if (!walkable){
                y = ((int)(y/height)+1)*height;
            }
        }
        if (movingDown){
            walkable = map.getCell((int)x/tileWidth,(int)((y+height)/tileHeight)).isWalkable();
            if (!walkable){
                y = ((int)(y/height)*height);
            }
        }
        if (movingRight){
            walkable = map.getCell((int)(x+width)/tileWidth,(int)(y/tileHeight)).isWalkable();
            if (!walkable){
                x = ((int)(x/width)*width);
            }
        }
        if (movingLeft){
            walkable = map.getCell((int)(x/tileWidth),(int)(y/tileHeight)).isWalkable();
            if (!walkable){
                x = ((int)(x/width)+1)*width;
            }
        }
    }
    
    @Override
    public Character clone() throws CloneNotSupportedException{
        return (Character) super.clone();
    }
    
    
}
