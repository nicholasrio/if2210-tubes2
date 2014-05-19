package character;

/**
 * method recoverable
 * @author yafithekid
 */
public interface Recoverable {
    /**
     * add current health. truncated if > maxHealth
     * @param value integer. can be negative
     */
    public void addCurrentHealth(int value);
    
    /**
     * add current mana. truncated if > maxMana
     * @param value integer. can be negative.
     */
    public void addCurrentMana(int value);
}
