package Entity;

import java.io.Serializable;

public class TransObject implements Serializable{

	private static final long serialVersionUID = -4630977808690959143L;
	
	String NIM;
	String name;
	
	public TransObject(String nim, String nama) {
		NIM = nim;
		name = nama;
	}
	
	public String getNIM(){
		return NIM;
	}
	
	public String getName(){
		return name;
	}

}
