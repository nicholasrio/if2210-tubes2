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

}
