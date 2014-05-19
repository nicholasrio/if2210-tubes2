/**
 * @author Eldwin
 */

/** This class is the superclass for fruits and pest */
public class SaleableObject {
	/** The name of the object */
	protected String name;

	/** The price of the object */
	protected int price;

	/** The capacity of the objects */
	protected int capacity;

	/** Return the object's name */
	public String getName() {
		return (this.name);
	}

	/** Return the obect's price */
	public int getPrice() {
		return (this.price);
	}

	/** Return the object's capacity */
	public int getCapacity() {
		return (this.capacity);
	}
}
