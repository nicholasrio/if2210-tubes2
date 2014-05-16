package character;

/**
 * the base class for character
 * all other characters should extends from here.
 */
public class Character implements Cloneable,Recoverable{
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

    private String imagePath;
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
    public void setMaxMana(int x){ this._maxMana = x;}
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
}
