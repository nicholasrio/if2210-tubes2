public class SaleableObjects{
	protected int value;
	protected int capacity;
	
	public SaleableObjects(){
		value = 0;
		capacity = 0;
	}
	
	public SaleableObjects(int x, int y){
		value = x;
		capacity = y;
	}
	
	public void SetValue(int x){
		value = x;
	}
	
	public int GetValue(){
		return value;
	}
	
	public void SetCapacity(int x){
		capacity = x;
	}
	
	public int GetCapacity(){
		return capacity;
	}
}