package character;
import character.Skill.*;
import java.util.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.*;
import map.*;

/**
 * class Hero extends Character implements Useitem,Upgradeable,Recoverable,Fightable
 * @author yafithekid
 */
public class Hero extends Character implements Useitem,Upgradeable,Recoverable,Fightable {
    /**
     * money for hero
     */
    protected int _money;
    private ArrayList<Item> _items;
    private ArrayList<Skill> skills;
    private boolean flinching;
    private long flinchingStart;
    /**
     * enum hero state
     */
    public enum HeroState{
        /**
         * state hero
         */
        IDLE,
        /**
         * state move
         */
        MOVE,
        /**
         * state attack
         */
        ATTACK,
        /**
         * state skill
         */
        SKILL
    };
    private int activeSkill;
    HeroState heroState;
    
    /**
     * constructor
     */
    public Hero(){
            _money = 0;
            _items = new ArrayList<Item>();
            
            //initialize movement
            heroState = HeroState.IDLE;
            movingUp=false;
            movingDown=false;
            movingRight=false;
            movingLeft=false;
            faceDirection = direction.UP;
            
    }
    
    /**
     * initialize hero
     */
    public void init(){
        
        _currentHealth = _maxHealth;
        _currentMana = _maxMana;
        
        //initialize animation
            animation = new Animation();
            animation.setDelay(100);
            animation.setFrames(sprites.get(3));
            skills = new ArrayList<Skill>();
            skills.add(new FireBall());
            skills.add(new Celoblast());
            _items = new ArrayList<>();
            
            attackAnimation = new Animation();
            attackAnimation.setFrames(attackFrame);
            attackAnimation.setDelay(100);
            
            flinching = false;
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

    
    /**
     * method for print status
     */
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
        fight.hitted(this.getAttackPoint());
    }
    
    //cek apakah hero melukai enemy
    /**
     * checking if a hero hitting the enemy
     * @param enemy 
     */
    public void checkHitting(Character enemy){
        
        /*Cek apakah hero melakukan attack. jika iya cek apakah attack tersebut mengenai enemy(monster)*/
        if (heroState == HeroState.ATTACK){
            int aWidth = attackSprite.getWidth()/5;
            int aHeight = attackSprite.getHeight();
            Rectangle R1 = new Rectangle((int)x-aWidth/6,
                            (int)y-aHeight/6,
                            aWidth/2,
                            aHeight/2);
            if (R1.intersects(enemy.getRectangle())){
                doAttack((Fightable)enemy);
            }
        }
        
        /*traversal semua bola api jika ada bola api yang 
            bersentuhan dengan enemy maka berarti hero berhasil melukai enemy
            lakukan doAttack*/
        for (int i=0;i<skills.size();i++){
            if (skills.get(i).isActive()){
                if (skills.get(i).checkHitting(enemy)){
                    ((Fightable)enemy).hitted(skills.get(i).getDamage());
                }
            }
        }
        
    }
    
    //update
    /**
     * update the game
     */
    public void update(){
        
        if (heroState == HeroState.SKILL){
            if (!skills.get(activeSkill).isActive()){
                heroState = HeroState.IDLE;
            }
            else{
                skills.get(activeSkill).update();
            }
        }
        if (flinching){
            if ((System.nanoTime()-flinchingStart)/1000000000>2){
                flinching = false;
            }
        }
        if (heroState==HeroState.ATTACK){
            attackAnimation.update();
            if (attackAnimation.getFrame() == 4){
                heroState=HeroState.IDLE;
            }
        }
        
        if (heroState==HeroState.MOVE){
            animation.update();
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
        }

        //ubah peta menjadi visible
        int mx=(int)x/32;
        int my=(int)y/32;
        for (int i=Math.max(mx-3,0);i<=Math.min(mx+3,map.xsize-1);i++){
            for (int j=Math.max(my-3,0);j<=Math.min(my+3,map.ysize-1);j++){
                map.setVisible(i, j, true);
            }
        }
        
    }
    
    //Input Handling
    /**
     * method for checking if key pressed
     * @param k 
     */
    public void keyPressed(int k){
        //Reaction to KeyPressed
        if (heroState == HeroState.IDLE){
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
                    Tile cell1 = null;
                    Tile cell2 =null;
                    Tile cell3 = null;
                    if (faceDirection == direction.RIGHT){
                        cell1 = map.getCell((int)(x/width)+1, (int)(y/height)-1);
                        cell2 = map.getCell((int)(x/width)+1, (int) y/height);
                        cell3 = map.getCell((int)(x/width)+1, (int)(y/height)+1);
                    }
                    else if (faceDirection == direction.LEFT){
                        cell1 = map.getCell((int)(x/width),(int)(y/height)+1);
                        cell2 = map.getCell((int)(x/width),(int)y/height);
                        cell3 = map.getCell((int)(x/width),(int)(y/height)-1);
                    }
                    else if (faceDirection == direction.UP){
                        cell1 = map.getCell((int)(x/width)-1,(int)(y/height));
                        cell2 = map.getCell((int)(x/width),(int)(y/height));
                        cell3 = map.getCell((int)(x/width)+1,(int)(y/height));
                    }
                    else if (faceDirection == direction.DOWN){
                        cell1 = map.getCell((int)(x/width)+1,(int)(y/height)+1);
                        cell2 = map.getCell((int)x/width,(int)(y/height)+1);
                        cell3 = map.getCell((int)(x/width)-1,(int)(y/height)+1);
                    }
                    
                    if (cell1.isOpenable()){
                        //jika cell merupakan pintu maka buka pintu
                        Openable tile;
                        tile = (Openable)cell1;
                        tile.open();
                    }
                    if (cell2.isOpenable()){
                        //jika cell merupakan pintu maka buka pintu
                        Openable tile;
                        tile = (Openable)cell2;
                        tile.open();
                    }
                    if (cell3.isOpenable()){
                        //jika cell merupakan pintu maka buka pintu
                        Openable tile;
                        tile = (Openable)cell3;
                        tile.open();
                    }
                }
                else if (k== KeyEvent.VK_A){
                    heroState = HeroState.ATTACK;
                }
                else if (k == KeyEvent.VK_Z){
                    if (skills.size()>0){
                        
                        if (_currentMana >= skills.get(0).getMana()){
                            heroState = HeroState.SKILL;
                            activateSkill(0);
                        }
                    }
                }
                else if (k == KeyEvent.VK_X){
                    if (skills.size()>1){        
                        if (_currentMana >= skills.get(1).getMana()){
                            heroState = HeroState.SKILL;
                            activateSkill(1);
                        }
                    }
                }
                else if (k == KeyEvent.VK_C){
                    if (skills.size()>2){
                        if (_currentMana >= skills.get(2).getMana()){
                            heroState = HeroState.SKILL;
                            activateSkill(2);
                        }
                    }
                }
                else if (k == KeyEvent.VK_V){
                    if (skills.size()>3){
                        if (_currentMana >= skills.get(3).getMana()){
                            heroState = HeroState.SKILL;
                            activateSkill(3);
                        }
                    }
                }
        }
    }
    /**
     * method for activate the skill
     * @param n 
     */
    public void activateSkill(int n){
        activeSkill = n;
        skills.get(n).start((int)x,(int) y, getDirectionInt());
        _currentMana -= skills.get(n).getMana();
    }
    
    //gambar hero
    /**
     * method draw
     * @param g
     * @param offsetX
     * @param offsetY 
     */
    public void draw(Graphics2D g,int offsetX,int offsetY){
        if ((flinching) && ((System.nanoTime()-flinchingStart)/100000000)%2 != 0){
        }else{
            //gambar hero
            g.drawImage(animation.getImage(),((int)x-offsetX),((int)y-offsetY),null);
        }
        

        if (heroState==HeroState.SKILL){
            skills.get(activeSkill).draw(g,offsetX,offsetY);
        }
        
        //gambar attack biasa jika sedang melakukan attack
        BufferedImage tmp = attackAnimation.getImage();
        int aWidth = tmp.getWidth();
        int aHeight = tmp.getHeight();
        if (heroState==HeroState.ATTACK){
            int xtmp = (int)x - aWidth/3 - offsetX;
            int ytmp = (int)y - aHeight/3 - offsetY;
            g.rotate(Math.toRadians(getDirectionInt()*90),(int)x-offsetX+(width/2),(int)y-offsetY+(height/2));
            g.drawImage(attackAnimation.getImage(),xtmp,ytmp,null);
            g.rotate(Math.toRadians(-getDirectionInt()*90),(int)x-offsetX+(width/2),(int)y-offsetY+(height/2));
        }
    }
    /**
     * method for checking if key released
     * @param k 
     */
    public void keyReleased(int k){
        switch (heroState){
            case IDLE :
            case MOVE :
                if(k == KeyEvent.VK_UP){
                    if (movingUp){
                        movingUp=false;
                        heroState = HeroState.IDLE;
                    }
                }
                else if(k == KeyEvent.VK_DOWN) {
                    if (movingDown){
                        movingDown=false;
                        heroState = HeroState.IDLE;
                    }
                }
                else if(k == KeyEvent.VK_RIGHT) {
                    if(movingRight){
                        movingRight=false;
                        heroState = HeroState.IDLE;
                    }
                }
                else if (k == KeyEvent.VK_LEFT) {
                    if (movingLeft){
                        movingLeft=false;
                        heroState = HeroState.IDLE;
                    }
                }
                break;
            case ATTACK :
                break;
        }
    }
    /**
     * method for flinchinging if got attacked
     */
    public void pushedBackandFlinching(){
        if (movingUp){
            y-=10;
            movingDown = true;
            movingUp = false;
        }
        else if (movingDown){
            y+=10;
            movingUp = true;
            movingDown = false;
        }
        else if (movingLeft){
            x-=10;
            movingRight = true;
            movingLeft = false;
        }
        else if (movingRight){
            x+=10;
            movingRight = true;
            movingLeft = false;
        }
        checkTileCollision();
        if (movingDown){
            movingDown = false;
            movingUp = true;
        }
        else if (movingUp){
            movingUp = false;
            movingDown = true;
        }
        else if (movingLeft){
            movingLeft = false;
            movingRight = true;
        }
        else if (movingRight){
            movingRight = false;
            movingLeft = true;
        }
        
        flinching = true;
        flinchingStart = System.nanoTime();
    }
    /**
     * method if got damage
     * @param damage 
     */
    public void hitted(int damage){
        if (!flinching){
            flinching = true;
            flinchingStart = System.nanoTime();
            doAbsorbDamage(damage);
        }
    }
    
}
