/*
 * @author Riady		
 */

import java.util.*; 
import java.io.*;

public class Plant extends SaleableObject implements Drawable {
	/** The counter of the plant's ID */
	private static int ID = 0;

	/** The ID of the plant */
	private int id;

	/** The plant's age */
	private double age;

	/** The plant's need for water */
	private double waterLevel;

	/** The plant's max level of water that it could contains */
	private double maxWaterLevel;

	/** The plant's need for fertilizer (it's optional) */
	private double fertilizerLevel;

	/** The plant's max level of ferilizer that it could contains */
	private double maxFertilizerLevel;

	/** The price of the plant's seed */
	private int buyprice;

	/** The plant's level, decided by its age */
	private Stage stage;

	/** The array to contains the stages */
	private ArrayList<Stage> stages;

	/** The plant's fruit */
	private Fruit fruit;
	public double fruitTimeLeft;
	public enum FruitStatus {
		NONE, GROWING, ROTTING, ROTTEN
	}
	private FruitStatus fruitStatus;
	
	/** CTOR */
	public Plant(String name, double maxWaterLevel, double maxFertilizerLevel,
			int price,Fruit fruit) {
		id = ++ID;

		this.name = name;
		this.maxWaterLevel = maxWaterLevel;
		this.maxFertilizerLevel = maxFertilizerLevel;
		this.price = price;
		this.fruitStatus = FruitStatus.NONE;

		this.age = 0;
		this.setWaterLevel(maxWaterLevel);
		this.setFertilizerLevel(maxFertilizerLevel);

		stages = new ArrayList<Stage>();
		stage = null;
		this.fruit = fruit;
	}

	/** Getter-Setter */

	/** Return the plant's ID */
	public int getId() {
		return this.id;
	}

	/** Return the plant's water level */
	public double getWaterLevel() {
		return waterLevel;
	}

	/** Set the plant's water level */
	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}

	/** Return the plant's fertilizer level */
	public double getFertilizerLevel() {
		return fertilizerLevel;
	}

	/** Set the plant's fertilizer level */
	public void setFertilizerLevel(double fertilizerLevel) {
		this.fertilizerLevel = fertilizerLevel;
	}

	/** Buy the plant's seed */
	public static int buySeed(int ID) {
		if (ID == 1) {
			return 50;
		} else if (ID == 2) {
			return 200;
		} else if (ID == 3) {
			return 500;
		} else {
			return 1000;
		}
	}

	/** An inner class that represents the stages of the plants */
	public class Stage {
		private String name;
		/** The stage's name */
		private double waterDropLevel;
		/** The level at which the water depletes */
		private double fertilizerDropLevel;
		/** The level at which the fertilizer depletes */
		private double lifeTime;
		/** Whether this stage has fruit or not */
		private boolean isFruiting;

		/** The image container */

		/** CTOR */
		public Stage(String name) {
			this.name = name;
		}

		/** Getter-Setter */
		public String getName() {
			return name;
		}

		/** Set the stage's name */
		public void setName(String name) {
			this.name = name;
		}

		/** Return the water drop level */
		public double getWaterDropLevel() {
			return waterDropLevel;
		}

		/** Set the water drop level */
		public void setWaterDropLevel(double waterDropLevel) {
			this.waterDropLevel = waterDropLevel;
		}

		/** Return the fertilizer drop level */
		public double getFertilizerDropLevel() {
			return fertilizerDropLevel;
		}

		/** Set the fertilizer drop level */
		public void setFertilizerDropLevel(double fertilizerDropLevel) {
			this.fertilizerDropLevel = fertilizerDropLevel;
		}

		/** Return the lifetime */
		public double getLifeTime() {
			return lifeTime;
		}

		/** Set the life time */
		public void setLifeTime(double lifeTime) {
			this.lifeTime = lifeTime;
		}

		public boolean isFruiting() {
			return isFruiting;
		}

		public void setFruiting(boolean fruiting) {
			this.isFruiting = fruiting;
		}
	}

	/** Add the stage, this must be done in the correct order */
	public void addStage(Stage newStage) {
		stages.add(newStage);

		/** If this is the first stage, set it as the current stage */
		if (stage == null) {
			stage = newStage;
		}
	}

	/** CTOR PARAM */
	public void addStage(String stageName, double lifeTime,
			double waterDropLevel, double fertilizerDropLevel,
			String imageSource, boolean isFruiting) {
		Stage newStage = new Stage(stageName);
		newStage.setLifeTime(lifeTime);
		newStage.setWaterDropLevel(waterDropLevel);
		newStage.setFertilizerDropLevel(fertilizerDropLevel);
		newStage.setFruiting(isFruiting);

		addStage(newStage);
	}

	/** Get the current stage */
	public Stage getStage() {
		return this.stage;
	}

	/** Set the next stage of a stage */
	private Stage getNextStage(Stage stage) {
		int index = stages.indexOf(stage);
		if (index >= stages.size() - 1) {
			return null;
		} else {
			return stages.get(index + 1);
		}
	}

	/** Set current stage to the next stage */
	public void evolve() {
		if (getNextStage(stage) != null) {
			stage = getNextStage(stage);
			// if current stage has fruit
			if (stage.isFruiting()) {
				fruitStatus = FruitStatus.GROWING;
				fruitTimeLeft = fruit.getHarvestPeriod();
			}
		}
	}

	/** Gives water to the plant */
	public void water() {
		waterLevel = maxWaterLevel;
	}

	/** Gives fertilizer to the plant */
	public void fertilize() {
		fertilizerLevel = maxFertilizerLevel;
	}
	/** Fruit handling */
	public boolean isFruitAvailable() {
		return fruitStatus == FruitStatus.ROTTEN || fruitStatus == FruitStatus.ROTTING;
	}
	

	public Fruit getFruit() {
		if (fruitStatus == FruitStatus.NONE || fruitStatus == FruitStatus.GROWING) {
			return null;
		}
		else if (fruitStatus == FruitStatus.ROTTING) {
			return fruit;
		}
		else {
			return new Fruit(fruit.getName());
		}
	}
	
	public void removeFruit() {
		if (fruitStatus == FruitStatus.NONE || fruitStatus == FruitStatus.GROWING) {
			// do nothing
		}
		else {
			fruitStatus = FruitStatus.GROWING;
			fruitTimeLeft = fruit.getHarvestPeriod();
		}
	}
	
	@Override
	public void draw() {
		String s="";
		int level = stages.indexOf(stage);
		if(name.equals("Pohon Strawberry")){
			s = "Strawberry level ";
		}
		else{
			s = name+" level ";
		}
		System.out.printf("%-20s:",s);
		System.out.printf("%-3d",level);
	}

	@Override
	public void update(int x) {
		/** Reduce the water and the fertilizer level */
		if (waterLevel > 0) {
			waterLevel -= stage.getWaterDropLevel();
		}
		if (fertilizerLevel > 0) {
			fertilizerLevel -= stage.getFertilizerDropLevel();
		}

		// TODO Rotten management here
		if (waterLevel <= 0 || fertilizerLevel <= 0) {
			stage = null;
			return;
		}
		/** Aging */
		age += x;
		if (age > stage.getLifeTime()) {
			evolve();
		}

		// TODO Fruit management here
		switch(fruitStatus){
			case NONE:
				break;
			case GROWING:
				fruitTimeLeft -= x;
				if(fruitTimeLeft <= 0){
					fruitTimeLeft = fruit.getRottenTime();
					fruitStatus = FruitStatus.ROTTING;
				}
				break;
			case ROTTING:
				fruitTimeLeft -= x;
				if(fruitTimeLeft <= 0){
					fruitStatus = FruitStatus.ROTTEN;
				}
				break;
			case ROTTEN:
				break;
		}
	}

	/** Set copy of this object */
	public Plant clone() {
		Plant p = new Plant(name, maxWaterLevel, maxFertilizerLevel, price, fruit);
		for (Stage s : stages) {
			p.addStage(s);
		}

		return p;
	}

}
