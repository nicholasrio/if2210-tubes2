/*
 * @author Riady		
 */

import java.awt.*;
import java.util.*;
import javax.swing.ImageIcon;

public class Plant extends SaleableObject implements Drawable {

	private static int ID = 0; /** The counter of the plant's ID */
	private int id; /** The ID of the plant */

	private double age; /** The plant's age */
	private double waterLevel; /** The plant's need for water */
	private double maxWaterLevel; /** The plant's max level of water that it could contains */
	private double fertilizerLevel; /** The plant's need for fertilizer (it's optional) */
	private double maxFertilizerLevel; /** The plant's max level of ferilizer that it could contains */

	private Stage stage; /** The plant's level, decided by its age */
	private ArrayList<Stage> stages; /** The array to contains the stages */

	/** CTOR */
	public Plant(String name, double maxWaterLevel, double maxFertilizerLevel) {
		id = ++ID;

		this.name = name;
		this.maxWaterLevel = maxWaterLevel;
		this.maxFertilizerLevel = maxFertilizerLevel;

		this.age = 0;
		this.setWaterLevel(maxWaterLevel);
		this.setFertilizerLevel(maxFertilizerLevel);

		stages = new ArrayList<Stage>();
		stage = null;
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

	/** An inner class that represents the stages of the plants */
	public class Stage {
		private String name; /** The stage's name */
		private double waterDropLevel; /** The level at which the water deplets */
		private double fertilizerDropLevel; /** The level at which the fertilizer deplets */
		private double lifeTime; /** The lifetime of the plant */
		private Image image; /** The image container */

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

		/** Return the water drop level  */
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
	public void addStage(String stageName, double lifeTime, double waterDropLevel, double fertilizerDropLevel, String imageSource) {
		Stage newStage = new Stage(stageName);
		newStage.setLifeTime(lifeTime);
		newStage.setWaterDropLevel(waterDropLevel);
		newStage.setFertilizerDropLevel(fertilizerDropLevel);
		newStage.setImage(imageSource);

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
		}
		else {
			return stages.get(index + 1);
		}
	}

	/** Set current stage to the next stage */
	public void evolve() {
		if (getNextStage(stage) != null) {
			stage = getNextStage(stage);
		}
	}

	/** Gives water to the plant */
	public void water(double amount) {
		waterLevel += amount;
		if (waterLevel > maxWaterLevel) {
			waterLevel = maxWaterLevel;
		}
	}

	/** Gives fertilizer to the plant */
	public void fertilize(double amount) {
		fertilizerLevel += amount;
		if (fertilizerLevel > maxFertilizerLevel) {
			fertilizerLevel = maxFertilizerLevel;
		}
	}

	@Override
	public void draw(Graphics g) {
		/** Draw the plant */
		g.drawImage(stage.getImage(), bounds.x, bounds.y, bounds.width, bounds.height,  null);

		/** Draw the water level */
		if (waterLevel / maxWaterLevel < 0.1) {
			g.setColor(Color.RED);
		}
		else {
			g.setColor(Color.BLUE);
		}
		for(int i = 0; i < bounds.height/2; i++){
			if (i >= waterLevel * bounds.height/2 / maxWaterLevel) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(bounds.x + (bounds.width-5), bounds.y + bounds.height/2 - i, 5, 1);
		}

		// TODO Draw fertilizer level
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

		// TODO Rotten management here

		/** Aging */
		age += timeElapsed;
		if (age > stage.getLifeTime()) {
			evolve();
		}

		// TODO Fruit management here
	}

	/** Section for Shape interface */
	Rectangle bounds;

	/** Set the bounds */
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	/** Check the points of the bounds */
	public boolean contains(Point point) {
		return bounds.contains(point);
	}

	/** Set copy of this object */
	public Plant clone() {
		Plant p = new Plant(name, maxWaterLevel, maxFertilizerLevel);
		for (Stage s : stages) {
			p.addStage(s);
		}

		return p;
	}

}
