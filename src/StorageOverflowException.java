/**
 * @author Zaky
 */

/** This class is the class used to handle the exception when the storage can't carry anything anymore */
public class StorageOverflowException extends Throwable {
	
	Storage storage;
	
	public StorageOverflowException(Storage storage) {
		this.storage = storage;
	}
	
	@Override
	public String getMessage() {
		return "Storage tidak mencukupi! Kapasitas sisa hanya " + storage.getCapacity();
	}

}
