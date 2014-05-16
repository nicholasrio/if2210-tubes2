package character;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class Hero extends Character implements Useitem,Upgradeable,Recoverable,Fightable {
    protected int _money;
    ArrayList<Item> _items;
    private static ArrayList<BufferedImage[]> sprites;
    
    public Hero(){
            _money = 0;
            _items = new ArrayList<Item>();
            
            moveSpeed = 1;
            movingUp=false;
            movingDown=false;
            movingRight=false;
            movingLeft=false;
            faceDirection = direction.UP;
            animation = new Animation();
            animation.setDelay(100);
            loadImage();
            animation.setFrames(sprites.get(3));
    }
    
    //implementasi interface useitem
    @Override
    public void addItem(Item newItem){
        try{
            _items.add(newItem);
        } catch(Exception e){ 
            e.printStackTrace();
        }
    }

    @Override
    public void removeItem(int pos)  {
            if (0 <= pos && pos < _items.size())
                    _items.remove(pos);
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

    public boolean sell(Item item){
            if (haveItem(item)){
                    this.removeItem(item.getCost());
                    this._money += item.getCost();
                    return true;
            } else {
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

    //implementasi interface Recoverable
    @Override
    public void addCurrentHealth(int x){
        this._currentHealth += x;
        if (this._currentHealth > this._maxHealth) {
            this._currentHealth = this._maxHealth;
        }
    }
    @Override
    public void addCurrentMana(int x){
        this._currentMana += x;
        if (this._currentMana > this._currentMana) {
            this._currentMana = this._maxMana;
        }
    }
    
    public void printStatus(){
        System.out.println("Status: "+this.getStr()+" "+this.getAgi()+" "+this.getInt());
        System.out.println("Current Health: "+this.getCurrentHealth()+" "+this.getCurrentMana()+" "+this.toString());
    }
    

    
    /*public static void main(String[] args){
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
    }*/
    
    public void loadImage() {
        
        sprites = new ArrayList<BufferedImage[]>(4);
        for (int i=0;i<4;i++){
            BufferedImage[] bi= new BufferedImage[3];
            try{
                BufferedImage spriteSheet = ImageIO.read(getClass().getResourceAsStream("/Hero/Hero.png"));
                for (int j=0;j<3;j++){
                    int width = spriteSheet.getWidth();
                    int height = spriteSheet.getHeight();
                    bi[j]=spriteSheet.getSubimage(j*width/3,i*height/4,width/3,height/4);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            sprites.add(bi);
        }
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
        return this.getCurrentHealth() < 0;
    }

    @Override
    public boolean isAlive() {
        return !this.isDead();
    }

    @Override
    public void doDamageCalculation(int damage) {
        this.addCurrentHealth(-damage);
    }

    @Override
    public void doAttack(Fightable fight) {
        fight.doDamageCalculation(fight.getAttackPoint());
    }
    
    //update
    public void update(){
        if (movingUp){
            y-=moveSpeed;
        }
        else if (movingDown){
            y+=moveSpeed;
        }
        else if (movingRight){
            x+=moveSpeed;
        }
        else if (movingLeft){
            x-=moveSpeed;
        }
        if (!isIdle()){
            animation.update();
        }
    }
    
    public boolean isIdle(){
        return !(movingUp || movingDown || movingRight || movingLeft);
    }
    public void keyPressed(int k){
        //Reaction to KeyPressed
        
        if(k == KeyEvent.VK_UP){
            if (!movingUp){
                movingUp=true;
                faceDirection = direction.UP;
                animation.setFrames(sprites.get(3));
            }
        }
        else if(k == KeyEvent.VK_DOWN) {
            if (!movingDown){
                movingDown=true;
                faceDirection = direction.DOWN;
                animation.setFrames(sprites.get(0));
            }
	}
        else if(k == KeyEvent.VK_RIGHT) {
            if (!movingRight){
                movingRight=true;
                faceDirection = direction.RIGHT;
                animation.setFrames(sprites.get(2));
            }
	}
        else if (k == KeyEvent.VK_LEFT) {
            if (!movingLeft){
                movingLeft=true;
                faceDirection = direction.LEFT;
                animation.setFrames(sprites.get(1));
            }
        }
    }
    
    public void draw(Graphics2D g){
        g.drawImage(animation.getImage(),(int)x,(int)y,null);
    }
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_UP){
            movingUp=false;
        }
        else if(k == KeyEvent.VK_DOWN) {
            movingDown=false;
	}
        else if(k == KeyEvent.VK_RIGHT) {
            movingRight=false;
	}
        else if (k == KeyEvent.VK_LEFT) {
            movingLeft=false;
        }
    }
    
}
