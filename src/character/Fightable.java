package character;

public interface Fightable {
    
    public int getAttackPoint();
    public int getDefensePoint();
    public boolean isDead();
    public boolean isAlive();
    public void doDamageCalculation(int damage);
    public void doAttack(Fightable fight);
    
}
