/**
 * @author William Stefan
 */

/** This class is the class to control the fertilizer used in the game */
public class Fertilizer
{
	private int level, buyprice, amount, price;

	/** CTOR */
	public Fertilizer(int new_level, int new_buyprice) {
		this.level = 1;
		this.buyprice = 10;
		this.amount = 30;
	}

	/** Method to fertilize plant */
	public void Fertilize(int x, int y) {

	}
	
	/** Get the amount of fertilizer of current level */
	public int getAmount() {
		return this.amount;
	}
	
	/** Get the price of fertilizer */
	public int getPrice() {
		// TODO THIS IS ONLY STUB
		return 10;
	}
}
