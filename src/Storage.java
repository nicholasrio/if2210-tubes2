public class Storage{
	private int capacity;
	
	public Storage(){
		capacity = 0;
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
	
}