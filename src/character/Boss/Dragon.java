/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character.Boss;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import character.Animation;
import character.Fightable;
import character.Hero;
import character.Item;
import character.Skill.*;
import java.util.ArrayList;
import java.io.File;
/**
 *
 * @author kevinyu
 */
public class Dragon extends Boss{
    
    private enum BossState{
        CHASING, ATTACK, CHARGE, SKILL
    }
    
    private BufferedImage chargeSprite;
    private BufferedImage[] chargeFrame;
    private final int nChargeFrame = 51; //jumlah frame pada charge
    private Animation chargeAnimation;
    private long chargeStart = 0; //waktu mulai charge dalam nanosekon
    private int chargeTime = 1; //waktu charge untuk special attack
    BossState bossState; //State dari dragon
    private int currentSkill; //Skill yang sedang digunakan
    private int chaseX; //posisi target yang dikejar
    private int chaseY; //posisi target yang dikejar
    private long attackLast = 0; //waktu mulai attack terakhir
    private final int attackDelay = 5; //waktu antar attack
    private final int attackDuration = 1; //waktu attack;
    
    /**
     * class dragon
     */
    public Dragon(){
            
            //initialize movement
            bossState = BossState.CHASING;
            chaseX = (int)x;
            chaseY = (int)y;
            movingUp=false;
            movingDown=false;
            movingRight=false;
            movingLeft=false;
            faceDirection = direction.DOWN;
            
    }
    
    /**
     * method intialize
     */
    public void init(){
        initStatus();
        initSkill();
        initAnimation();
    }
    
    /**
     * method initialize status
     */
    public void initStatus(){
        _maxHealth = 3000;
        _currentHealth = 3000;
        _maxMana = 3000;
        _currentMana = 3000;
        _str = 50;
        _agi = 50;
        _int = 50;
        attackRange = 8;
        moveSpeed = 1;
        skillLast[0] = (long)(System.nanoTime());
        skillLast[1] = (long)(System.nanoTime());
    }
    
    /**
     * method initialize skill
     */
    public void initSkill(){
        skills = new ArrayList<Skill>();
        skills.add(new Celoblast());
        skills.add(new FireBall());
    }
    
    /**
     * method intialzie animition
     */
    public void initAnimation(){
        //initialize animation
        BufferedImage tmp;
        try{
            tmp = ImageIO.read(new File("src/Resource/Boss/SacredDragon.png"));
            loadImage(tmp);
            tmp = ImageIO.read(new File("src/Resource/Attack/CycloneSlash.png"));
            loadAttackFrame(tmp);
            tmp = ImageIO.read(new File("src/Resource/Boss/Celocharge.bmp"));
            loadChargeFrame(tmp);
        } catch (Exception e){
            e.printStackTrace();
        }
        
        animation = new Animation();
        animation.setDelay(100);
        animation.setFrames(sprites.get(0));
        
        attackAnimation = new Animation();
        attackAnimation.setFrames(attackFrame);
        attackAnimation.setDelay(100);
        
        chargeAnimation = new Animation();
        chargeAnimation.setFrames(chargeFrame);
        chargeAnimation.setDelay(10);
    }
    
    /**
     * method load charge frame
     * @param image 
     */
    public void loadChargeFrame(BufferedImage image){
        chargeSprite = image;
        chargeFrame = new BufferedImage[nChargeFrame];
        int chargeWidth = chargeSprite.getWidth()/nChargeFrame;
        int chargeHeight = chargeSprite.getHeight();
        for (int i=0;i<nChargeFrame;i++){
            chargeFrame[i] = chargeSprite.getSubimage(i*chargeWidth,0,chargeWidth,chargeHeight);
        }
        
    }
    
    /**
     * method pushed backand flinching
     */
    public void pushedBackandFlinching(){}
    
    /**
     * method check skill range
     * @param enemy 
     */
    public void checkSkillRange(character.Character enemy){
        if ((bossState==BossState.CHASING) || (bossState==BossState.ATTACK)){
            for (int i=0;i<skills.size();i++){
                
                Rectangle R1 = new Rectangle ((int)x-skillRange[i],
                                                (int)y-skillRange[i],
                                                skillRange[i]+width*2,
                                                skillRange[i]+height*2);
                if (R1.intersects(enemy.getRectangle())){
                    if ((System.nanoTime()-skillLast[i])/1000000000>skillDelay[i]){
                        skillLast[i] = System.nanoTime();
                        chargeStart = System.nanoTime();
                        bossState = BossState.CHARGE;
                        currentSkill = i;
                        break;
                    }
                }
            }
        }
    }
    
    /**
     * method check attack range
     * @param enemy 
     */
    public void checkAttackRange(character.Character enemy){
        if ((bossState == BossState.CHASING)){
            if ((System.nanoTime()-attackLast)/1000000000>attackDelay){
                Rectangle R1 = new Rectangle ((int)x - attackRange,
                                                (int)y - attackRange,
                                                attackRange+width,
                                                attackRange+height);
                if (R1.intersects(enemy.getRectangle())){
                    attackLast = System.nanoTime();
                    bossState=BossState.ATTACK;
                }
                else{
                    bossState = BossState.CHASING;
                    chaseX = (int)enemy.getPositionX();
                    chaseY = (int)enemy.getPositionY();
                    chase();
                }
            }
        }
    }
    
    /**
     * method check hitting
     * @param enemy 
     */
    public void checkHitting(character.Character enemy){
        //cek ATTACK biasa
        if (bossState == BossState.ATTACK){
            int aWidth = attackSprite.getWidth()/5;
            int aHeight = attackSprite.getHeight();
            Rectangle R1 = new Rectangle((int)x-16,
                            (int)y-16,
                            16+width,
                            16+height);
            if (R1.intersects(enemy.getRectangle())){
                doAttack((Fightable)enemy);
            }
        }
        
        if (bossState == BossState.SKILL){
            if (skills.get(currentSkill).checkHitting(enemy)){
                ((Fightable)enemy).hitted(skills.get(currentSkill).getDamage());
            }
        }
    }
    
    /**
     * method chase
     */
    public void chase(){
        int xtmp = (int)(x - chaseX) + 32;
        int ytmp = (int)(y - chaseY) + 32;
        
        if (xtmp<0){
            xtmp = xtmp*-1;
        }
        if (ytmp<0){
            ytmp = ytmp*-1;
        }
        if ((xtmp-ytmp>128) || (ytmp < 32)){
            if (x-chaseX+32>64){
                setMoveLeft();
            }
            else if (chaseX-x+32>64){
                setMoveRight();
            }
        }
        else {
            if (y-chaseY + 32 > 64){
                setMoveUp();
            }
            else if (chaseY - y + 32 >64){
                setMoveDown();
            }
        }
    }
    
    /**
     * method set move up
     */
    public void setMoveUp(){
        movingUp = true;
        movingDown = false;
        movingLeft = false;
        movingRight = false;
        if (faceDirection!=direction.UP){
            faceDirection = direction.UP;
            animation.setFrames(sprites.get(3));
        }
    }
    
    /**
     * method set move right
     */
    public void setMoveRight(){
        movingUp = false;
        movingDown = false;
        movingLeft = false;
        movingRight = true;if (faceDirection!=direction.RIGHT){
            faceDirection = direction.RIGHT;
            animation.setFrames(sprites.get(2));
        }
    }
    
    /**
     * method set move down
     */
    public void setMoveDown(){
        movingUp = false;
        movingDown = true;
        movingLeft = false;
        movingRight = false;
        if (faceDirection!=direction.DOWN){
            faceDirection = direction.DOWN;
            animation.setFrames(sprites.get(0));
        }
    }
    
    /**
     * method set move left
     */
    public void setMoveLeft(){
        movingUp = false;
        movingDown = false;
        movingLeft = true;
        movingRight = false;
        if (faceDirection!=direction.LEFT){
            faceDirection = direction.LEFT;
            animation.setFrames(sprites.get(1));
        }
    }
    
    /**
     * method update
     */
    public void update(){
        switch (bossState){
            case CHASING :
                if (movingUp){
                    y -= moveSpeed;
                }
                else if (movingRight){
                    x += moveSpeed;
                }
                else if (movingDown){
                    y += moveSpeed;
                }
                else if (movingLeft){
                    x -= moveSpeed;
                }
                checkTileCollision();
                break;
            case ATTACK :
                if ((System.nanoTime()-attackLast)/1000000000<attackDuration){
                    attackAnimation.update();
                }
                else{
                    bossState = BossState.CHASING;
                }
                break;
            case CHARGE :
                if ((System.nanoTime()/1000000000-chargeStart/1000000000)<chargeTime){
                    chargeAnimation.update();
                }
                else{
                    bossState = BossState.SKILL;
                    skills.get(currentSkill).start((int)x+48,(int)y+48,getDirectionInt());
                }
                break;
            case SKILL :
                if ( !skills.get(currentSkill).isActive() ){
                    bossState = BossState.CHASING;
                }
                else{
                    skills.get(currentSkill).update();
                }
                break;
        }
        animation.update();
    }
    
    /**
     * method draw
     * @param g
     * @param offsetX
     * @param offsetY 
     */
    public void draw(Graphics2D g, int offsetX , int offsetY){
        g.drawImage(animation.getImage(),(int)x-offsetX,(int)y-offsetY,null);
        
        if (bossState == BossState.SKILL){
            skills.get(currentSkill).draw(g,offsetX,offsetY);
        }
        
        if (bossState == BossState.CHARGE){
            int cWidth = chargeAnimation.getImage().getWidth();
            int cHeight = chargeAnimation.getImage().getHeight();
            g.drawImage(chargeAnimation.getImage(),(int)x+cWidth/2-offsetX,(int)y+cWidth/2-offsetY,null);
        }
        
        if (bossState == BossState.ATTACK){
            g.drawImage(attackAnimation.getImage(),(int)x-48-offsetX,(int)y-48-offsetY,null);
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
        fight.hitted(this.getAttackPoint());
    }
    
    /**
     * method if get hitted
     * @param damage 
     */
    public void hitted(int damage){
        doAbsorbDamage(damage);
    }
}
