/**
 * @author Eldwin
 */
import java.util.ArrayList;

public class Storage{
	private int capacity; /** The capacity of the storage */
	ArrayList<SaleableObject> arrStorage; /** The array container */

	/** CTOR */
	public Storage() {
		this.capacity = 6;
		arrStorage = new ArrayList<SaleableObject>(capacity);
	}

	/** Set the capacity */
	public void SetCapacity(int x){
		capacity = x;
	}

	/** Add plant to storage */
	public void addPlant(Plant P) {
		this.arrStorage.add(P);
	}

	/** Add pest to storage */
	public void addPest(Pest P) {
		this.arrStorage.add(P);
	}

	/** Add fruit to storage */
	public void addFruit(Fruit F) {
		this.arrStorage.add(F);
	}
}