package character;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.net.URL;

public class Hero extends Character implements Useitem,Upgradeable,Recoverable,Fightable {
    protected int _money;
    ArrayList<Item> _items;

    public Hero(){
            _money = 0;
            _items = new ArrayList<>();
    }
    //implementasi interface useitem
    
    @Override
    public void addItem(Item newItem){
        try{
            _items.add(newItem);
        } catch(Exception e){ }
    }

    @Override
    public void removeItem(int pos)  {
        if (0 <= pos && pos < _items.size()) {
            _items.remove(pos);
        }
    }

    @Override
    public int findItem(Item item){
            for(int i = 0 ;i <_items.size(); ++i){
                if (_items.get(i).getId() == item.getId()) {
                    return i;
                }
            }
            return -1;
    }

    @Override
    public boolean haveItem(Item item){
        return (this.findItem(item)!=-1);
    }

    @Override
    public boolean haveMoney(int money){
        return this._money >= money;
    }

    @Override
    public void applyEffect(Item item){
        this.addStr(item.getStrEff());
        this.addAgi(item.getAgiEff());
        this.addInt(item.getIntEff());
        this.addMaxHealth(item.getMaxHealthEff());
        this.addMaxMana(item.getMaxManaEff());
        this.addCurrentHealth(item.getCurrentHealthEff());
        this.addCurrentMana(item.getCurrentManaEff());
    }

    @Override
    public boolean consume(Item item){
        if (this.haveItem(item)){
                this.removeItem(this.findItem(item));
                this.applyEffect(item);
                return true;
        } else {
                return false;
        }
    }
    
    @Override
    public boolean save(Item item) {
        try {
            this.addItem(item);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean buy(Item item){
        if (haveMoney(item.getCost())){
                this._money -= item.getCost();
                this.addItem(item);
                return false;
        } else{
                return false;
        }
    }

    //implementasi interface upgradeable
    @Override
    public void addStr(int x){ this._str += x; }
    @Override
    public void addAgi(int x){ this._agi += x; }
    @Override
    public void addInt(int x){ this._int += x; }
    @Override
    public void addMaxHealth(int x){ this._maxHealth += x; }
    @Override
    public void addMaxMana(int x){ this._maxMana += x; }

    
    
    public void printStatus(){
        System.out.println("Status: "+this.getStr()+" "+this.getAgi()+" "+this.getInt());
        System.out.println("Current Health: "+this.getCurrentHealth()+" "+this.getCurrentMana()+" "+this.toString());
    }
    
    public static BufferedImage bi;
    
    public static void main(String[] args){
        try {
            loadImage();
            Hero hero = new Hero();
            ItemCache.loadCache();
            Item item = ItemCache.getItem("ironwood_branch");
            hero.addItem(item);
            hero.consume(item);
            hero.printStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadImage() throws IOException{
        bi = ImageIO.read(
               Hero.class.getResource("Resources/tiles32.bmp"));
    }

    @Override
    public int getAttackPoint() {
        return this.getStr();
    }

    @Override
    public int getDefensePoint() {
        return this.getAgi();
    }

    @Override
    public boolean isDead() {
        return this.getCurrentHealth() <= 0;
    }

    @Override
    public boolean isAlive() {
        return !this.isDead();
    }
    
    @Override
    public int getNetDamage(int damage){
        int result = damage - this.getDefensePoint();
        if (result < 0) result = 0;
        return result;
    }
    @Override
    public void doAbsorbDamage(int damage) {
        this.addCurrentHealth(-this.getNetDamage(damage));
    }

    @Override
    public void doAttack(Fightable fight) {
        fight.doAbsorbDamage(this.getAttackPoint());
    }

}
