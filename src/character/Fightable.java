package character;

/**
 * interface for fightable object
 */
public interface Fightable {
    /**
     * calculate attack point from fightable object based on str, agi, and int.
     * @return int net attack point
     */
    public int getAttackPoint();
    
    /**
     * calculate defense point from fightable object based on str, agi, and int.
     * @return int net defense point
     */
    public int getDefensePoint();
    
    /**
     * check whether the character is dead (current HP <= 0)
     * @return boolean
     */
    public boolean isDead();
    
    /**
     * check whether the character is alive
     * @return boolean
     */
    public boolean isAlive();
    
    /**
     * calculate the net damage based on damage.
     * @param damage the gross damage value
     * @return integer >= 0
     */
    public int getNetDamage(int damage);
    
    /**
     * decrease current health based on net damage
     * @param damage the gross damage value
     */
    public void doAbsorbDamage(int damage);
    
    /**
     * attack an fightable object
     * @param fight 
     */
    public void doAttack(Fightable fight);
}
