/**
 * @author Eldwin
 */
import java.util.ArrayList;

public class Storage{
	private int capacity;
	ArrayList<SaleableObject> arrStorage;
	
	public Storage(){
		this.capacity = 6;
		arrStorage = new ArrayList<SaleableObject>(capacity);
	}
	
	public Storage(int x){
		capacity = x;
	}
	
	public void SetCapacity(int x){
		capacity = x;
	}
	
	public int GetCapacity(){
		return capacity;
	}
	
	public void addPlant(Plant P) {
		this.arrStorage.add(P);
	}
	
	public void addPest(Pest P) {
		this.arrStorage.add(P);
	}
	
	public void addFruit(Fruit F) {
		this.arrStorage.add(F);
	}
}