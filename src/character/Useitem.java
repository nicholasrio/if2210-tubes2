package character;

/**
 * interface useitem
 * @author yafithekid
 */
public interface Useitem{
    /**
     * add the item to character
     * @param item the item to be added
     */
    public void addItem(Item item);
    /**
     * remove the item from character
     * @param pos the pos of the item to be remove
     */
    public void removeItem(int pos);
    /**
     * search the first occurence of item
     * @param item the item to be found
     * @return int the first position of item. return -1 if not found.
     */
    public int findItem(Item item);
    /**
     * check whether the character has the item.
     * @param item the item to be found
     * @return true if exist
     */
    public boolean haveItem(Item item);
    /**
     * check if the character money is >= than money
     * @param money int
     * @return boolean
     */
    public boolean haveMoney(int money);
    /**
     * apply the item effect to the character. Will not remove the item from character.
     * @param item the used item.
     */
    public void applyEffect(Item item);
    /**
     * use ONE item and apply the effect to the user if available. Doesn't do anything if item not exist
     * @param item the used item
     * @return boolean if successfully consumed
     */
    public boolean consume(Item item);
    /**
     * save the item to the inventory. will not save if capacity is overlimit.
     * @param item
     * @return true if can be saved
     */
    public boolean save(Item item);
    /**
     * decrease the money and automatically save the item
     * doesn't do anything if overcapacity or not enough money
     * @param item
     * @return true if can be buyed
     */
    public boolean buy(Item item);

}