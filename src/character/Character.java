package character;
import map.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * class abstract character extends MapEntity implements Cloneable, Recoverable
 * @author yafithekid
 */
public abstract class Character extends MapEntity implements Cloneable,Recoverable{
/**
 * the base class for character
 * all other characters should extends from here.
 */
    private int id;
    private String name;
    /**
     * the character strength
     */
    protected int _str;
    /**
     * the character agility
     */
    protected int _agi;
    /**
     * the character intelligence
     */
    protected int _int;

    /**
     * the map
     */
    protected Map map;
    /**
     * the character current health
     */
    protected int _currentHealth;
    /**
     * the character current mana
     */
    protected int _currentMana;
    /**
     * the character maximum health
     */
    protected int _maxHealth;
    /**
     * the character maximum mana
     */
    protected int _maxMana;
     
    //movement attribute
    /**
     * the character move down
     */
    protected boolean movingDown;
    /**
     * the character move up
     */
    protected boolean movingUp;
    /**
     * the character move left
     */
    protected boolean movingLeft;
    /**
     * the character move right
     */
    protected boolean movingRight;
    /**
     * the character move speed
     */
    protected int moveSpeed;
    /**
     * enum for direction
     */
    protected enum direction {
        /**
         * enum Down
         */
        DOWN,
        /**
         * enum Left
         */
        LEFT,
        /**
         * enum Right
         */
        RIGHT,
        /**
         * enum Up
         */
        UP};
    /**
     * facedirection for character
     */
    protected direction faceDirection;
    /**
     * sprites for character
     */
    protected ArrayList<BufferedImage[]> sprites;
    private final int toleransiWidth = 6; //nilai toleransi collision
    /**
     * attack sprite for character
     */
    protected BufferedImage attackSprite;
    /**
     * attack frame for character
     */
    protected BufferedImage[] attackFrame;
    /**
     * attack animation for character
     */
    protected Animation attackAnimation; 
    /**
     * attack range for character
     */
    protected int attackRange;
    
    /**
     * method for initialize the character
     */
    public abstract void init();
    
    /**
     * method for set the map
     * @param map is Map
     */
    public void setMap(Map map){
        this.map = map;
    }
    
    private String imagePath;
    private String attackPath;
    /**
     * getter for strength
     * @return int
     */
    public int getStr() { return _str; }
    
    /**
     * getter for agility
     * @return int
     */
    public int getAgi() { return _agi; }
    
    /**
     * getter for intelligence
     * @return int
     */
    public int getInt() { return _int; }
    
    /**
     * getter for current health
     * @return int
     */
    public int getCurrentHealth(){ return _currentHealth; }
    /**
     * getter for current mana
     * @return int
     */
    public int getCurrentMana(){ return _currentMana; }
    /**
     * getter for maximum health
     * @return
     */
    public int getMaxHealth(){ return _maxHealth;}
    /**
     * getter for maximum mana
     * @return
     */
    public int getMaxMana(){ return _maxMana;} 

    /**
     * method for get attack range from character
     * @return 
     */
    public int getAttackRange() { return attackRange; }
    
    /**
     * method for get attack path from character
     * @return 
     */
    public String getAttackPath(){ return attackPath;}
    
    /**
     * setter for maximum strength
     * @param x
     */
    public void setStr(int x){ this._str = x; }
    /**
     * setter for maximum agility
     * @param x
     */
    public void setAgi(int x){ this._agi = x; }
    /**
     * setter for maximum intelligence
     * @param x
     */
    public void setInt(int x){ this._int = x; }
    /**
     * setter for maximum health
     * @param x
     */
    public void setMaxHealth(int x){ this._maxHealth = x;}
    /**
     * setter for maximum mana
     * @param x
     */
    public void setMaxMana(int x){ this._maxMana = x; }
    
    /**
     * setter for move speed
     * @param x is integer
     */
    public void setMoveSpeed(int x){ this.moveSpeed = x; }
    
    /**
     * setter for attack range
     * @param x int
     */
    public void setAttackRange(int x){ this.attackRange = x; }
    
    /**
     * setter for attack path
     * @param s string
     */
    public void setAttackPath(String s){ this.attackPath = s; }
    
    /**
     * method for check tile collision
     */
    public void checkTileCollision(){
        boolean walkable=true;
        int tileWidth = TileImagePrototype.tileWidth;
        int tileHeight = TileImagePrototype.tileHeight;
        
        boolean topLeft = map.getCell((int)(x+toleransiWidth+1)/tileWidth,
                ((int)(y+toleransiWidth+1)/tileHeight)).isWalkable();
        boolean topRight = map.getCell((int)(x+width-toleransiWidth-1)/tileWidth,
                ((int)(y+toleransiWidth+1)/tileHeight)).isWalkable();
        boolean bottomLeft = map.getCell((int)(x+toleransiWidth+1)/tileWidth,
                (int)((y+height-toleransiWidth-1)/tileHeight)).isWalkable();
        boolean bottomRight = map.getCell((int)(x+width-toleransiWidth-1)/tileWidth,
                (int)((y+height-toleransiWidth-1)/tileHeight)).isWalkable();
        
        if (movingUp){
            walkable = topLeft && topRight;
            if (!walkable){
                y = (((int)(y/tileHeight)+1)*tileHeight)-toleransiWidth;
                
            }
        }
        else if (movingDown){
            walkable = bottomLeft && bottomRight;
            if (!walkable){
                y = ((int)(y/tileHeight)*tileHeight)+toleransiWidth;
                
            }
        }
        else if (movingRight){
            walkable = topRight && bottomRight;
            if (!walkable){
                x = ((int)(x/tileWidth)*tileWidth)+toleransiWidth;
            }
        }
        else if (movingLeft){
            walkable = topLeft && bottomLeft;
            if (!walkable){
                x = (((int)(x/tileWidth)+1)*tileWidth)-toleransiWidth;
                
            }
        }

    }
    
    /**
     * setter for current health
     * @param _currentHealth
     */
    public void setCurrentHealth(int _currentHealth) { this._currentHealth = _currentHealth; } 
    /**
     * setter for current mana
     * @param _currentMana
     */
    public void setCurrentMana(int _currentMana) {  this._currentMana = _currentMana; }
    
    /**
     * setter for strength,agility, and intelligence
     * @param x int new strength
     * @param y int new agility
     * @param z int new intelligence
     */
    public void setStrAgiInt(int x,int y,int z){
        this.setStr(x);
        this.setAgi(y);
        this.setInt(z);
    }
    /**
     * setter for max health and mana
     * @param x int new max health
     * @param y int new max mana
     */
    public void setMaxHealthMana(int x,int y){
        this.setMaxHealth(x);
        this.setMaxMana(y);
    }
    /**
     * setter for current health and mana
     * @param x int new current health
     * @param y int new current mana
     */
    public void setCurrentHealthMana(int x,int y){
        this.setCurrentHealth(x);
        this.setCurrentMana(y);
    }
        
    @Override
    public Character clone() throws CloneNotSupportedException{
        return (Character) super.clone();
    }
    
    //implementasi interface Recoverable
    @Override
    public void addCurrentHealth(int x){
        this._currentHealth += x;
        if (this._currentHealth > this._maxHealth) {
            this._currentHealth = this._maxHealth;
        }
        if (this._currentHealth < 0){
            this._currentHealth = 0;
        }
    }
    @Override
    public void addCurrentMana(int x){
        this._currentMana += x;
        if (this._currentMana > this._maxMana) {
            this._currentMana = this._maxMana;
        }
        if (this._currentMana < 0){
            this._currentMana = 0;
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    /**
     * method for load image
     * @param image BufferedImage
     */
    public void loadImage(BufferedImage image) {
        
        System.out.println("Lol");
        sprites = new ArrayList<BufferedImage[]>(4);
        try{
            spriteSheet = image;
            width = spriteSheet.getWidth()/3;
            height = spriteSheet.getHeight()/4;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        for (int i=0;i<4;i++){
            BufferedImage[] bi= new BufferedImage[3];
            for (int j=0;j<3;j++){  
                bi[j]=spriteSheet.getSubimage(j*width,i*height,width,height);
            }
            sprites.add(bi);
        }
        
    }
    /**
     * method for load attack frame
     * @param attackImage is buffered image
     */
    public void loadAttackFrame(BufferedImage attackImage){
        attackSprite = attackImage;
        attackFrame = new BufferedImage[5];
        int aWidth = attackSprite.getWidth()/5;
        int aHeight = attackSprite.getHeight();
        for (int i=0;i<5;i++){
            attackFrame[i] = attackSprite.getSubimage(i*aWidth,0,aWidth,aHeight);
        }
    }
    
    /**
     * method get direction int
     * @return 
     */
    public int getDirectionInt(){
        int direct = 0;
        if (faceDirection == direction.UP){
            direct = 3;
        }
        else if (faceDirection == direction.RIGHT){
            direct = 4;
        }
        else if (faceDirection == direction.DOWN){
            direct = 1;
        }
        else if (faceDirection == direction.LEFT){
            direct = 2;
        }
        return direct;
    }
}
