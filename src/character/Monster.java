/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import java.awt.Graphics2D;
import java.awt.image.*;
import java.util.ArrayList;
import java.awt.Rectangle;
/**
 *
 * @author yafithekid
 */

import map.Map;

/**
 * class Monster extends Character implements Recoverable,Fightable
 * @author yafithekid
 */
public class Monster extends Character implements Recoverable,Fightable{
    
        
    private int[] pattern; /*menyimpan pattern gerakan monster berupa banyak langakah ke atas,bawah,kanan dan kiri
        Monster bergerak sebanyak pattern[0] langkah ke atas lalu pattern[1] langkah ke kanan dan seterusnya
    */
    private int patternCounter; //menghitung langkah monster. digunakan sebagi pendukung pattern[]
    private int visionRange; //jarak pandang Monster. apabila berada dalam wilayah pandang maka akan dikejar
    private int chasingCounter; /*menghitung jumlah langkah monster mengejar jika sudah melawati batas tertentu maka 
                                       maka akan berpindah dari CHASING_HORIZONTAL menjadi CHASING_VERTICAL*/
    private int chaseX;//target chasing monster
    private int chaseY;//target chasing monster
    private final int chasingCounterLimit = 32; //nilai limit chasingCounter
    
    private boolean flinching;
    private long flinchingStart;
    
    private enum MonsterState{
        MOVE_UP,MOVE_RIGHT,MOVE_DOWN,MOVE_LEFT,ATTACK,CHASING
    }
    
    private enum ChasingState{
        CHASE_HORIZONTAL,CHASE_VERTICAL,NOT_CHASING
    }
    
    private MonsterState monsterState;
    private ChasingState chasingState; 

    /**
     * method for initialize
     */
    public void init(){
        
        //inisialisasi gerakan
        movingUp=true;
        movingDown=false;
        movingRight=false;
        movingLeft=false;
        monsterState = MonsterState.MOVE_UP;
        chasingState = ChasingState.NOT_CHASING;
        faceDirection = direction.UP;
        chaseX=0;
        chaseY=0;
        
        setCurrentHealth(getMaxHealth());
        
        //inisialisasi animasi
        animation = new Animation();
        animation.setDelay(100);
        animation.setFrames(sprites.get(3));
        patternCounter = 0;
        attackAnimation = new Animation();
        attackAnimation.setDelay(100);
        attackAnimation.setFrames(attackFrame);
        
        flinching = false;
        
    }
    
    /**
     * method for set pattern
     * @param up
     * @param right
     * @param down
     * @param left 
     */
    public void setPattern(int up,int right,int down,int left){
        pattern = new int[4];
        pattern[0]=up*32;
        pattern[1]=right*32;
        pattern[2]=down*32;
        pattern[3]=left*32;
    }
    
    @Override
    public int getAttackPoint() {
        return this.getStr();
    }

    @Override
    public int getDefensePoint() {
        return this.getAgi();
    }

    /**
     * method get vision range
     * @return 
     */
    public int getVisionRange() {
        return this.visionRange;
    }
    
    /**
     * method set vision range
     * @param vR 
     */
    public void setVisionRange(int vR) {
        this.visionRange = vR;
    }
    
    @Override
    public boolean isDead() {
        return this.getCurrentHealth() <= 0;
    }

    @Override
    public boolean isAlive() {
        return !this.isDead();
    }
        
    public int getNetDamage(int damage){
        int result = damage - this.getDefensePoint();
        if (result < 0) result = 0;
        return result;
    }
    
    @Override
    public void addCurrentHealth(int x){
        this._currentHealth += x;
        if (this._currentHealth > this._maxHealth) {
            this._currentHealth = this._maxHealth;
        }
        else if (this._currentHealth < 0){
            this._currentHealth = 0;
        }
    }
    
    public void doAbsorbDamage(int damage) {
        this.addCurrentHealth(-this.getNetDamage(damage));
    }

    @Override
    public void doAttack(Fightable fight) {
        fight.hitted(this.getAttackPoint());
    }
    /**
     * method update
     */
    public void update(){
        
        if (flinching){
            if ((System.nanoTime()-flinchingStart)/1000000000>2){
                flinching = false;
            }
        }
       
        switch (monsterState){
            case ATTACK :
                attackAnimation.update();
                break;
            case CHASING :
                chasingCounter+=moveSpeed;
                if (chasingState == ChasingState.CHASE_HORIZONTAL){
                    if (chaseX-x>2){
                        if(!movingRight){
                            faceDirection = direction.RIGHT;
                            movingRight = true;
                            movingLeft = false;
                            animation.setFrames(sprites.get(2));
                        }
                    }
                    else if (chaseX-x<-2){
                        if (!movingLeft){
                            faceDirection = direction.LEFT;
                            movingLeft = true;
                            movingRight = false;
                            animation.setFrames(sprites.get(1));
                        }
                    }
                    else{
                        chasingCounter = 0;
                        chasingState = ChasingState.CHASE_VERTICAL;
                        movingLeft = false ;
                        movingRight = false;
                    }
                    if (chasingCounter > chasingCounterLimit){
                        chasingCounter = 0;
                        chasingState = ChasingState.CHASE_VERTICAL;
                        movingLeft = false ;
                        movingRight = false;
                    }
                }
                else if (chasingState == ChasingState.CHASE_VERTICAL){
                    if (chaseY-y>2){
                        if (!movingDown){
                            faceDirection = direction.DOWN;
                            movingDown=true;
                            movingUp=false;
                            animation.setFrames(sprites.get(0));
                        }
                    }
                    else if (chaseY-y<-2){
                        if (!movingUp){
                            faceDirection = direction.UP;
                            movingUp = true;
                            movingDown = false;
                            animation.setFrames(sprites.get(3));
                        }
                    }
                    else{
                        chasingCounter = 0;
                        chasingState = ChasingState.CHASE_HORIZONTAL;
                        movingUp = false;
                        movingDown = false;
                    }
                    if (chasingCounter >chasingCounterLimit){
                        chasingCounter = 0;
                        chasingState = ChasingState.CHASE_HORIZONTAL;
                        movingUp = false;
                        movingDown = false;
                    }
                }
                break;
            case MOVE_UP :
                if (patternCounter>pattern[0]){
                    patternCounter = 0;
                    monsterState=MonsterState.MOVE_RIGHT;
                    movingUp=false;
                    movingRight=true;
                    faceDirection = direction.RIGHT;
                    animation.setFrames(sprites.get(2));
                }
                else{
                    patternCounter+=moveSpeed;
                }
                break;
            case MOVE_RIGHT :
                if (patternCounter>pattern[1]){
                    patternCounter = 0;
                    monsterState = MonsterState.MOVE_DOWN;
                    movingRight = false;
                    movingDown = true;
                    faceDirection = direction.DOWN;
                    animation.setFrames(sprites.get(0));
                }
                else{
                    patternCounter+=moveSpeed;
                }
                break;
            case MOVE_DOWN :
                if (patternCounter>pattern[2]){
                    patternCounter = 0;
                    monsterState = MonsterState.MOVE_LEFT;
                    movingDown = false;
                    movingLeft = true;
                    faceDirection = direction.LEFT;
                    animation.setFrames(sprites.get(1));
                }
                else{
                    patternCounter+=moveSpeed;
                }
                break;
            case MOVE_LEFT :
                if (patternCounter>pattern[3]){
                    patternCounter = 0;
                    monsterState = MonsterState.MOVE_UP;
                    movingLeft = false;
                    movingUp = true;
                    faceDirection = direction.UP;
                    animation.setFrames(sprites.get(3));
                }
                else{
                    patternCounter+=moveSpeed;
                }
                break;
        }
        
        if (monsterState!=MonsterState.ATTACK){
            if (movingUp){
                y-=moveSpeed;
            }
            else if (movingDown){
                y+=moveSpeed;
            }
            else if (movingLeft){
                x-=moveSpeed;
            }
            else if (movingRight){
                x+=moveSpeed;
            }
            checkTileCollision();
        }
        animation.update();
    }
    
    /*Mengecek apakah hero berada dalam jangakuan serang Monster
        jika iya lakukan serangan */
    /**
     * method check attacking
     * @param enemy 
     */
    public void checkAttacking(Character enemy){
        
        Rectangle R1 = new Rectangle(
                    (int)x-attackRange,
                    (int)y-attackRange,
                    attackRange*2+width,
                    attackRange*2+height);
        if (R1.intersects(enemy.getRectangle())){
            if (monsterState != MonsterState.ATTACK){
                monsterState = MonsterState.ATTACK;
            }
        }
        else{
            checkVisionRange(enemy);
        }
    }
    
    /*Mengecek apakah Monster melukai  enemy(hero)
        jika iya lakukan doAttacking untuk mengurangi Health Hero*/
    /**
     * method check hitting
     * @param enemy 
     */
    public void checkHitting(Character enemy){
        int aWidth = animation.getImage().getWidth();
        int aHeight = animation.getImage().getHeight();
        int xtmp = (int)x - aWidth / 3;
        int ytmp = (int)y - aHeight / 3;
        xtmp = (int)x + (int)(Math.cos(Math.toRadians(getDirectionInt()*90)) * (xtmp - (int)x) - 
                (int)Math.sin(Math.toRadians(getDirectionInt()*90)) * (ytmp - (int)y));
        ytmp = (int)y + (int)(Math.sin(Math.toRadians(getDirectionInt()*90)) * (xtmp - (int)x) + 
                (int)Math.cos(Math.toRadians(getDirectionInt()*90)) * (ytmp - (int)y));
        Rectangle R1 = new Rectangle(xtmp,
                            ytmp,
                            aWidth,
                            aHeight);
        if (R1.intersects(enemy.getRectangle())){
            doAttack((Fightable)enemy);
        }
    }
    
    /*cek apakah enemy(hero) ada dalam jarak pandang Monster.
        Jika iya lakukan pengejaran*/
    /**
     * method check vision range
     * @param enemy 
     */
    public void checkVisionRange(Character enemy){
        
        Rectangle r1 = new Rectangle((int)x-visionRange,
                (int)y-visionRange,
                visionRange*2,
                visionRange*2);
        if (r1.intersects(enemy.getRectangle())){
            if (monsterState!=MonsterState.CHASING){
                monsterState = MonsterState.CHASING;
                if (faceDirection==direction.UP || faceDirection == direction.DOWN){
                    chasingState = ChasingState.CHASE_VERTICAL;
                }
                else{
                    chasingState = ChasingState.CHASE_HORIZONTAL;
                }
                chasingCounter = 0;
                
            }
            chaseX = (int)enemy.getPositionX();
            chaseY = (int)enemy.getPositionY();
        }
        else{
            if (monsterState==MonsterState.CHASING){
                chasingState = ChasingState.NOT_CHASING;
                monsterState = MonsterState.MOVE_UP;
                movingUp = true;
                faceDirection = direction.UP;
                patternCounter = 0;
                animation.setFrames(sprites.get(3));
            }
        }
    }
    
    /**
     * method draw
     * @param g
     * @param offsetX
     * @param offsetY 
     */
    public void draw(Graphics2D g,int offsetX,int offsetY){
        
        
        //gambar attack biasa jika sedang melakukan attack
        if ((flinching) && ((System.nanoTime()-flinchingStart)/100000000)%2 !=0) {
        }
        else{
            if (map.isVisible((int)x/32,(int)y/32)){
                g.drawImage(animation.getImage(),((int)x-offsetX),((int)y-offsetY),null);
            }
            BufferedImage tmp = attackAnimation.getImage();
            int aWidth = tmp.getWidth();
            int aHeight = tmp.getHeight();
            if (monsterState==MonsterState.ATTACK){
                int xtmp = (int)x - aWidth/3 - offsetX;
                int ytmp = (int)y - aHeight/3 - offsetY;
                g.rotate(Math.toRadians(getDirectionInt()*90),(int)x-offsetX+(width/2),(int)y-offsetY+(height/2));
                g.drawImage(attackAnimation.getImage(),xtmp,ytmp,null);
                g.rotate(Math.toRadians(-getDirectionInt()*90),(int)x-offsetX+(width/2),(int)y-offsetY+(height/2));
            }
        }
    }
    
    /**
     * method pushed backand flinching
     */
    public void pushedBackandFlinching(){
        if (movingUp){
            y+=10;
            movingDown = true;
            movingUp = false;
        }
        else if (movingDown){
            y-=10;
            movingUp = true;
            movingDown = false;
        }
        else if (movingLeft){
            x+=10;
            movingRight = true;
            movingLeft = false;
        }
        else if (movingRight){
            x-=10;
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
     * method hitted
     * @param damage 
     */
    public void hitted(int damage){
        if (!flinching){
            doAbsorbDamage(damage);
            pushedBackandFlinching();
        }
    }
}
