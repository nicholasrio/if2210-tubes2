package character;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.*;
import javax.imageio.ImageIO;
import map.Map;
import map.*;

public class Hero extends Character implements Useitem,Upgradeable,Recoverable,Fightable {
    protected int _money;
    private ArrayList<Item> _items;
    private static ArrayList<BufferedImage[]> sprites;
    private ArrayList<FireBall> fireballs;
    
    public enum HeroState{
        IDLE,MOVE,ATTACK
    };
    
    HeroState heroState;
    
    public Hero(Map map){
            super(map);
            _money = 0;
<<<<<<< HEAD
            _items = new ArrayList<Item>();
            
            //initialize movement
            heroState = HeroState.IDLE;
            moveSpeed = 2;
            movingUp=false;
            movingDown=false;
            movingRight=false;
            movingLeft=false;
            faceDirection = direction.UP;
            
            //initialize animation
            animation = new Animation();
            animation.setDelay(100);
            loadImage();
            animation.setFrames(sprites.get(3));
            fireballs = new ArrayList<FireBall>(100);  
=======
            _items = new ArrayList<>();
>>>>>>> ddc66afaa1eefc2227e052fe2b3f0d153bc7978c
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
        BufferedImage spriteSheet=null;
        try{
            spriteSheet = ImageIO.read(getClass().getResourceAsStream("/Hero/Hero.png"));
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
    
    //update
    public void update(){
        if (movingUp){
            y-=moveSpeed;
            checkTileCollision();
        }
        else if (movingDown){
            y+=moveSpeed;
            checkTileCollision();
        }
        else if (movingRight){
            x+=moveSpeed;
            checkTileCollision();
        }
        else if (movingLeft){
            x-=moveSpeed;
            checkTileCollision();
        }
        if (heroState==HeroState.MOVE){
            animation.update();
        }
        if (heroState==HeroState.ATTACK){
            heroState=HeroState.IDLE;
        }
        //ubah peta menjadi visible
        int mx=(int)x/32;
        int my=(int)y/32;
        for (int i=Math.max(mx-3,0);i<=Math.min(mx+3,map.xsize-1);i++){
            for (int j=Math.max(my-3,0);j<=Math.min(my+3,map.ysize-1);j++){
                map.setVisible(i, j, true);
            }
        }
        
        //check if fireball should be remove
        for (int i=0;i<fireballs.size();i++){
            fireballs.get(i).update();
            if (fireballs.get(i).shouldRemove()){
                fireballs.remove(i);
                i--;
            }
        }
    }
    
    //Input Handling
    public void keyPressed(int k){
        //Reaction to KeyPressed
        if (heroState == HeroState.IDLE || heroState== HeroState.MOVE){
                if(k == KeyEvent.VK_UP){
                    if (!movingUp){
                        movingUp=true;
                        faceDirection = direction.UP;
                        animation.setFrames(sprites.get(3));
                        heroState=HeroState.MOVE;
                    }
                }
                else if(k == KeyEvent.VK_DOWN) {
                    if (!movingDown){
                        movingDown=true;
                        faceDirection = direction.DOWN;
                        animation.setFrames(sprites.get(0));
                        heroState=HeroState.MOVE;
                    }
                }
                else if(k == KeyEvent.VK_RIGHT) {
                    if (!movingRight){
                        movingRight=true;
                        faceDirection = direction.RIGHT;
                        animation.setFrames(sprites.get(2));
                        heroState=HeroState.MOVE;
                    }
                }
                else if (k == KeyEvent.VK_LEFT) {
                    if (!movingLeft){
                        movingLeft=true;
                        faceDirection = direction.LEFT;
                        animation.setFrames(sprites.get(1));
                        heroState=HeroState.MOVE;
                    }
                }
                else if (k == KeyEvent.VK_O){
                    
                    //OPEN DOOR
                    
                    //cek apakah Tile pada arah yang dihadapi merupakan pintu
                    boolean Openable=false;
                    Tile cell = null;

                    if (faceDirection == direction.RIGHT){
                        cell = map.getCell((int)(x/width)+1, (int)y/height);
                    }
                    else if (faceDirection == direction.LEFT){
                        cell=map.getCell((int)(x/width)-1,(int)y/height);
                    }
                    else if (faceDirection == direction.UP){
                        cell=map.getCell((int)(x/width),(int)(y/height)-1);
                    }
                    else if (faceDirection == direction.DOWN){
                        cell = map.getCell((int)x/width,(int)(y/height)+1);
                    }
                    
                    if (cell.isOpenable()){
                        //jika cell merupakan pintu maka buka pintu
                        Openable tile;
                        tile = (Openable)cell;
                        tile.open();
                    }
                }
                else if (k == KeyEvent.VK_A){
    
                    //heroState=HeroState.ATTACK;
                    int direct = 0;
                    if (faceDirection == direction.UP){
                        direct = 1;
                    }
                    else if (faceDirection == direction.RIGHT){
                        direct = 2;
                    }
                    else if (faceDirection == direction.DOWN){
                        direct = 3;
                    }
                    else if (faceDirection == direction.LEFT){
                        direct = 4;
                    }
                    fireballs.add(new FireBall((int)x+(width/4),(int)y+(height/4),direct));
                }
        }
    }
    
    public void draw(Graphics2D g,int offsetX,int offsetY){
        g.drawImage(animation.getImage(),((int)x-offsetX),((int)y-offsetY),null);
        for (int i=0;i<fireballs.size();i++){
            fireballs.get(i).draw(g,offsetX,offsetY);
        }
    }
    
    public void keyReleased(int k){
        switch (heroState){
            case IDLE :
            case MOVE :
                if(k == KeyEvent.VK_UP){
                    movingUp=false;
                    heroState = HeroState.IDLE;
                }
                else if(k == KeyEvent.VK_DOWN) {
                    movingDown=false;
                    heroState = HeroState.IDLE;
                }
                else if(k == KeyEvent.VK_RIGHT) {
                    movingRight=false;
                    heroState = HeroState.IDLE;
                }
                else if (k == KeyEvent.VK_LEFT) {
                    movingLeft=false;
                    heroState = HeroState.IDLE;
                }
                break;
            case ATTACK :
                break;
        }
    }
    
}
