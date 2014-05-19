/**
g * @author William Stefan
 */
import java.util.*; 
import java.io.*;

public class Vehicle {
	/** The vehicle's capacity */
	private int capacity;

	/** The vehicle's level */
	private int id;

	/** The vehicle's starting position */
	private int startx;

	/** The vehicle's final position */
	private int finalx;

	/** 1 when the vehicle is moving and 0 when it is not */
	private int status;

	/** 1 when it is moving to the right and 0 when it is moving to the left */
	private int arah;

	/** The position of the vehicle */
	private int x;

	/** The vehicle's storage */
	private Storage vehStorage;
	
	public Storage getVehStorage(){
		return vehStorage;
	}

	/** CTOR */
	public Vehicle() {
		this.vehStorage = new Storage();
		this.capacity = 6;
		this.id = 1;
		this.startx = 600;
		this.finalx = 700;
		this.status = 0;
		this.arah = 1;
		this.x = this.startx;
	}

	/** To upgrade the vehicle */
	public void Upgrade() {
		/** Change the image */
		if (this.id < 3) {
			this.id++;
			/** Change the attribute */
			this.vehStorage.setCapacity(this.vehStorage.getCapacity()+2);
		} else {
			System.out.println("Level sudah maksimal");
		}

	}
	
	public int getId(){
		return this.id;
	}
	/** Return the status of the vehicle */
	public int getStatus() {
		return this.status;
	}

	/** Set the vehicle's status */
	public void setStatus(int _status) {
		this.status = _status;
	}

	/** Show the vehicle's contents */
	public void printVehicleContents() {
		if(this.vehStorage.arrStorage.size() == 0){
			System.out.println("Vehicle has no contents");
		}
		else{
			for (int i = 0; i < this.vehStorage.arrStorage.size(); i++) {
				System.out.printf("%-5s %-12s ","name:",this.vehStorage.arrStorage.get(i).getName());
				System.out.printf("%-5s %-4d","price:",this.vehStorage.arrStorage.get(i).getPrice());
				System.out.printf("%-10s ","kapasitas:"
						+ this.vehStorage.arrStorage.get(i).getCapacity());
				System.out.println();
			}
		}
	}

	/** Discard all the vehicle's contents */
	public void emptyAll() {
		this.vehStorage.arrStorage.removeAll(this.vehStorage.arrStorage);
	}

	/** Sell all the vehicle's contents */
	public int sellAll() {
		int sumMoney = 0;
		if(this.vehStorage.arrStorage.size() == 0){
			System.out.println("Vehicle has no contents");
		}
		else{
			for (int i = 0; i < this.vehStorage.arrStorage.size(); i++) {
				sumMoney += this.vehStorage.arrStorage.get(i).getPrice();
			}
			emptyAll();
		}
		return sumMoney;
	}

	/** Add an item to the storage */
	public void addItem(SaleableObject item) throws StorageOverflowException {
		this.vehStorage.add(item);
	}

}