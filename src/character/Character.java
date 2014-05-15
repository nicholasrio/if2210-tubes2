package character;

public class Character implements Cloneable{
    protected int _str;
    protected int _agi;
    protected int _int;

    protected int _currentHealth;
    protected int _currentMana;
    protected int _maxHealth;
    protected int _maxMana;

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
        
    @Override
    public Character clone() throws CloneNotSupportedException{
        return (Character) super.clone();
    }
}
