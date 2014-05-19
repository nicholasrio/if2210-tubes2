/**
 * @author Eldwin
 */
import java.util.ArrayList;

/** This class is used to control the storage that the vehicle will have to carry all the items that will be sold */
public class Storage {
	/** The capacity of the storage */
	private int capacity;
	private int maxCapacity;

	/** The array container */
	ArrayList<SaleableObject> arrStorage;

	/** CTOR */
	public Storage() {
		this.capacity = 6;
		this.maxCapacity = 6;
		arrStorage = new ArrayList<SaleableObject>();
	}

	/** Set the capacity */
	public void setCapacity(int x) {
		capacity = x;
	}
	
	/** Get the capacity */
	public int getCapacity() {
		return this.capacity;
	}
	
	/** Get the maximum capacity */
	public int maxCapacity() {
		return this.maxCapacity;
	}
	
	/** Empty the storage */
	public void empty() {
		arrStorage.clear();
		capacity = maxCapacity;
	}
	
	/** Sell all objects in storage */
	public int sellAll() {
		int value = 0;
		for (SaleableObject o : arrStorage) {
			value += o.getPrice();
		}
		this.empty();
		return value;
	}

	/** Add object to storage */
	public void add(SaleableObject object) throws StorageOverflowException {
		if (capacity >= object.getCapacity()) {
			capacity -= object.getCapacity();
			arrStorage.add(object);
		}
		else {
			throw new StorageOverflowException(this);
		}
	}
}