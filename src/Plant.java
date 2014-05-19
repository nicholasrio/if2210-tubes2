/*
 * @author Riady		
 */

import java.awt.*;
import java.util.*;
import javax.swing.ImageIcon;

/** This class is used to control the plants */
public class Plant implements Drawable {
	/** The counter of the plant's ID */
	private static int ID = 0;

	/** The ID of the plant */
	private int id;
	
	/** The plant's name */
	private String name;

	/** The plant's age */
	private double age;

	/** The plant's need for water */
	private double waterLevel;

	/** The plant's max level of water that it could contains */
	private double maxWaterLevel;

	/** The plant's need for fertilizer (it's optional) */
	private double fertilizerLevel;

	/** The plant's max level of fertilizer that it could contain */
	private double maxFertilizerLevel;

	/** The price of the plant's seed */
	private int price;

	/** The plant's level, decided by its age */
	private Stage stage;

	/** The array containing the stages */
	private ArrayList<Stage> stages;

	/** The plant's fruit and its status */
	private Fruit fruit;
	private double fruitTimeLeft;
	public enum FruitStatus {
		NONE, GROWING, ROTTING, ROTTEN
	}
	private FruitStatus fruitStatus;

	/** CTOR */
	public Plant(String name, double maxWaterLevel, double maxFertilizerLevel,
			int price, Fruit fruit) {
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
	
	/** Return the plant's name */
	public String getName() {
		return this.name;
	}
	
	/** Return the plant's price */
	public int getPrice() {
		return this.price;
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
		String name = "";
		switch (ID) {
		case 1:
			name = "Pohon Apel";
			break;
		case 2:
			name = "Pohon Strawberry";
			break;
		case 3:
			name = "Pohon Jeruk";
			break;
		case 4:
			name = "Pohon Durian";
			break;
		}
		try {
			return PlantFactory.getPrototype(name).getPrice();
		}
		catch (Exception e) {
			return 0;
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
		/** The lifetime of the plant */
		private Image image;
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

		/** Return the image */
		public Image getImage() {
			return image;
		}

		/** Set the image */
		public void setImage(Image image) {
			this.image = image;
		}

		/** Set the image with its path */
		public void setImage(String path) {
			ImageIcon ii = new ImageIcon(path);
			this.image = ii.getImage();
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
		newStage.setImage(imageSource);
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

	public void fertilize(double amount) {
		fertilizerLevel += amount;
		if (fertilizerLevel > maxFertilizerLevel) {
			fertilizerLevel = maxFertilizerLevel;
		}
	}

	/** Fruit handling */

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
	public void draw(Graphics g) {
		/** Draw the plant */
		g.drawImage(stage.getImage(), bounds.x, bounds.y, bounds.width,
				bounds.height, null);
		
		/** Draw the fruit */
		if (isFruitAvailable()) {
			if (fruitStatus == FruitStatus.ROTTING) {
				g.drawImage(fruit.getImage(), bounds.x, bounds.y, bounds.width,
						bounds.height, null);
			}
			else {
				g.drawImage(fruit.getRottenImage(), bounds.x, bounds.y, bounds.width,
						bounds.height, null);
			}
		}

		/** Draw the water level */
		if (waterLevel / maxWaterLevel < 0.15) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLUE);
		}
		for (int i = 0; i < bounds.height / 2; i++) {
			if (i >= waterLevel * bounds.height / 2 / maxWaterLevel) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(bounds.x + (bounds.width - 10), bounds.y + bounds.height
					/ 2 - i, 4, 1);
		}

		/** Draw the fertilizer level */
		if (fertilizerLevel / maxFertilizerLevel < 0.15) {
			g.setColor(Color.RED);
		} else {
			g.setColor(new Color(156, 93, 82)); // brown
		}
		for (int i = 0; i < bounds.height / 2; i++) {
			if (i >= fertilizerLevel * bounds.height / 2 / maxFertilizerLevel) {
				g.setColor(Color.WHITE);
			}
			g.fillRect(bounds.x + (bounds.width - 5), bounds.y + bounds.height
					/ 2 - i, 4, 1);
		}
	}

	@Override
	public void update(double timeElapsed) {
		/** Reduce the water and the fertilizer level */
		if (waterLevel > 0) {
			waterLevel -= timeElapsed * stage.getWaterDropLevel();
		}
		if (fertilizerLevel > 0) {
			fertilizerLevel -= timeElapsed * stage.getFertilizerDropLevel();
		}
		
		/** Check whether the plant die :( */
		if (waterLevel <= 0 || fertilizerLevel <= 0) {
			stage = null;
			return;
		}

		/** Aging */
		age += timeElapsed;
		if (age > stage.getLifeTime()) {
			evolve();
		}
		
		/** Updating fruit */
		switch (fruitStatus) {
		case NONE:
			break;
		case GROWING:
			fruitTimeLeft -= timeElapsed;
			if (fruitTimeLeft <= 0) {
				fruitTimeLeft = fruit.getRottenTime();
				fruitStatus = FruitStatus.ROTTING;
			}
			break;
		case ROTTING:
			fruitTimeLeft -= timeElapsed;
			if (fruitTimeLeft <= 0) {
				fruitStatus = FruitStatus.ROTTEN;
			}
			break;
		case ROTTEN:
			break;
		}
	}
	

	/** Section for Shape interface */
	private Rectangle bounds;

	/** Set the bounds */
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public Rectangle getBounds() {
		return this.bounds;
	}

	/** Check the points of the bounds */
	public boolean contains(Point point) {
		return bounds.contains(point);
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