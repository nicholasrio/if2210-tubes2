/**
 * @author Eldwin
 */

public class SaleableObject {
	protected String name; /** The name of the object */
	protected int price; /** The price of the object */
	protected int capacity; /** The capacity of the objects */

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
