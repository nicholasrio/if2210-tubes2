package character;

/**
 * method upgradeable
 * @author yafithekid
 */
public interface Upgradeable{
    /**
     * add the character strength. have no limit.
     * @param value integer the added value
     */
    public void addStr(int value);
    /**
     * add the character agility. have no limit
     * @param value integer the added value
     */
    public void addAgi(int value);
    /**
     * add the character intelligence. have no limit
     * @param value integer the added value
     */
    public void addInt(int value);
    /**
     * add the character maximum health. does not change current health.
     * @param value integer the add value.
     */
    public void addMaxHealth(int value);
    /**
     * add the character maximum mana. does not change current mana.
     * @param value integer the add value.
     */
    public void addMaxMana(int value);
}