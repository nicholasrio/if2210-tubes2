/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

/**
 *
 * @author yafithekid
 */
public class Monster extends Character implements Recoverable,Fightable{
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
