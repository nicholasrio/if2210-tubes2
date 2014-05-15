package character;

public interface Useitem{
	public void addItem(Item item);
	public void removeItem(int pos);
	public int findItem(Item item);

	public boolean haveItem(Item item);
	public boolean haveMoney(int money);
	public void applyEffect(Item item);
	public boolean consume(Item item);
	public boolean save(Item item);
	public boolean buy(Item item);

}