import java.awt.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Plant extends SaleableObject implements Drawable {

	private static int ID = 0;
	private int id;

	private double age;
	private double waterLevel;
	private double maxWaterLevel;
	private double fertilizerLevel;
	private double maxFertilizerLevel;
	
	private Stage stage;
	private ArrayList<Stage> stages;
	
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
	
	// Getter-Setter
	public int getId() {
		return this.id;
	}
	public double getWaterLevel() {
		return waterLevel;
	}
	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}
	public double getFertilizerLevel() {
		return fertilizerLevel;
	}
	public void setFertilizerLevel(double fertilizerLevel) {
		this.fertilizerLevel = fertilizerLevel;
	}

	// An inner class that represents stage of Plants
	public class Stage {
		private String name;
		private double waterDropLevel;
		private double fertilizerDropLevel;
		private double lifeTime;
		private Image image;
		
		public Stage(String name) {
			this.name = name;
		}
		
		// Getter Setter
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getWaterDropLevel() {
			return waterDropLevel;
		}
		public void setWaterDropLevel(double waterDropLevel) {
			this.waterDropLevel = waterDropLevel;
		}
		public double getFertilizerDropLevel() {
			return fertilizerDropLevel;
		}
		public void setFertilizerDropLevel(double fertilizerDropLevel) {
			this.fertilizerDropLevel = fertilizerDropLevel;
		}
		public double getLifeTime() {
			return lifeTime;
		}
		public void setLifeTime(double lifeTime) {
			this.lifeTime = lifeTime;
		}
		public Image getImage() {
			return image;
		}
		public void setImage(Image image) {
			this.image = image;
		}
		public void setImage(String path) {
			ImageIcon ii = new ImageIcon(path);
			this.image = ii.getImage();
		}
	}

	// Add stage. This must be done in the correct order for
	public void addStage(Stage newStage) {
		stages.add(newStage);
		
		// if this is the first stage added, set it to be current stage
		if (stage == null) {
			stage = newStage;
		}
	}
	public void addStage(String stageName, double lifeTime, double waterDropLevel, double fertilizerDropLevel, String imageSource) {
		Stage newStage = new Stage(stageName);
		newStage.setLifeTime(lifeTime);
		newStage.setWaterDropLevel(waterDropLevel);
		newStage.setFertilizerDropLevel(fertilizerDropLevel);
		newStage.setImage(imageSource);
		
		addStage(newStage);
	}

	// Get current stage
	public Stage getStage() {
		return this.stage;
	}
	
	// Get next stage of stage
	private Stage getNextStage(Stage stage) {
		int index = stages.indexOf(stage);
		if (index >= stages.size() - 1) {
			return null;
		}
		else {
			return stages.get(index + 1);
		}
	}

	// Set current stage to the next stage
	public void evolve() {
		if (getNextStage(stage) != null) {
			stage = getNextStage(stage);
		}
	}
	
	// Gives water to Plant
	public void water(double amount) {
		waterLevel += amount;
		if (waterLevel > maxWaterLevel) {
			waterLevel = maxWaterLevel;
		}
	}
	
	// Gives fertilizer to Plant
	public void fertilize(double amount) {
		fertilizerLevel += amount;
		if (fertilizerLevel > maxFertilizerLevel) {
			fertilizerLevel = maxFertilizerLevel;
		}
	}
	
	@Override
	public void draw(Graphics g) {
		// Draw plant
		g.drawImage(stage.getImage(), bounds.x, bounds.y, bounds.width, bounds.height, null);
		
		// Draw water level
		g.setColor(Color.BLUE);
		for(int i = 0; i < maxWaterLevel; i++){
			if (i >= waterLevel) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(bounds.x + (bounds.width-10), bounds.y+bounds.height-(i * 1), 10, 1);
		}
		
		// TODO Draw fertilizer level
	}

	@Override
	public void update(double timeElapsed) {
		// Reduce water and fertilizer level
		if (waterLevel > 0) {
			waterLevel -= timeElapsed * stage.getWaterDropLevel();
		}
		if (fertilizerLevel > 0) {
			fertilizerLevel -= timeElapsed * stage.getFertilizerDropLevel();
		}
		
		// TODO Rotten management here
		
		// aging
		age += timeElapsed;
		if (age > stage.getLifeTime()) {
			evolve();
		}
		
		// TODO Fruit management here
	}

	// Section for Shape interface
	Rectangle bounds;
	
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public boolean contains(Point point) {
		return bounds.contains(point);
	}
	
	// Get copy of this object
	public Plant clone() {
		Plant p = new Plant(name, maxWaterLevel, maxFertilizerLevel);
		for (Stage s : stages) {
			p.addStage(s);
		}
		
		return p;
	}

}
