/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import java.awt.Graphics2D;
/**
 *
 * @author yafithekid
 */

import map.Map;

public class Monster extends Character implements Recoverable,Fightable{
    
    public Monster(Map map){
        super(map);
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
<<<<<<< HEAD
    public void doAttack(Fightable fight) {
        fight.doDamageCalculation(this.getAttackPoint());
=======
    public int getNetDamage(int damage){
        int result = damage - this.getDefensePoint();
        if (result < 0) result = 0;
        return result;
>>>>>>> ddc66afaa1eefc2227e052fe2b3f0d153bc7978c
    }
    
    @Override
<<<<<<< HEAD
    public void addCurrentHealth(int x){
        this._currentHealth += x;
        if (this._currentHealth > this._maxHealth) {
            this._currentHealth = this._maxHealth;
        }
        else if (this._currentHealth > 0){
            this._currentHealth = 0;
        }
    }
    
=======
    public void doAbsorbDamage(int damage) {
        this.addCurrentHealth(-this.getNetDamage(damage));
    }

>>>>>>> ddc66afaa1eefc2227e052fe2b3f0d153bc7978c
    @Override
    public void doAttack(Fightable fight) {
        fight.doAbsorbDamage(this.getAttackPoint());
    }
    
    public void draw(Graphics2D g,int offsetX,int offsetY){
        
    }
}
