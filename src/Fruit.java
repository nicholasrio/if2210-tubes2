/**
 * @author William Stefan
 */
import java.util.*;
import java.io.*;

public class Fruit extends SaleableObject implements Drawable {
	private int id;
	private int sellprice;
	private int rottenTime;
	private int harvestPeriod;

	Fruit() {
		
	}

	Fruit(String name) {
		this.name = name;
		this.capacity = 0;
		this.price = 0;
	}

	Fruit(String name, int harvestPeriod, int rottenTime, int price,
			int capacity, String imageSource) {
		this.name = name;
		this.harvestPeriod = harvestPeriod;
		this.rottenTime = rottenTime;
		this.price = price;
		this.capacity = capacity;
	}

	public int getID() {
		return this.id;
	}

	/** Set the image */
	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int x) {
		// TODO Auto-generated method stub

	}


	/** Getter-Setter */

	public int getRottenTime() {
		return rottenTime;
	}

	public void setRottenTime(int rottenTime) {
		this.rottenTime = rottenTime;
	}

	public int getHarvestPeriod() {
		return harvestPeriod;
	}

	public void setHarvestPeriod(int harvestPeriod) {
		this.harvestPeriod = harvestPeriod;
	}
}