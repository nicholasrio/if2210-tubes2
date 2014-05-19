/**
 * @author William Stefan
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/** This class is the class to control the fruits that is produced by the plants, it is a derived class from SaleableObject */
public class Fruit extends SaleableObject implements Drawable {
	private int id;
	private Image imgFruit;
	private Image imgRotten; // TODO
	private int sellprice;
	private int rottenTime;
	private int harvestPeriod;

	Fruit() {
		// if (this.id == 1) {
		// this.sellprice = 75;
		// } else if (this.id == 2) {
		// this.sellprice = 300;
		// } else if (this.id == 3) {
		// this.sellprice = 750;
		// } else {
		// this.sellprice = 1500;
		// }
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
		setImage(imageSource);
	}

	public int getID() {
		return this.id;
	}

	/** Set the image */
	public void setImage(int ID) {
		ImageIcon i;
		if (ID == 1) {
			i = new ImageIcon("apple.png");
			imgFruit = i.getImage();
		} else if (ID == 2) {
			i = new ImageIcon("strawberry.png");
			imgFruit = i.getImage();
		} else if (ID == 3) {
			i = new ImageIcon("orange.png");
			imgFruit = i.getImage();
		} else {
			i = new ImageIcon("durian.png");
			imgFruit = i.getImage();
		}
	}

	public void setImage(String path) {
		imgFruit = (new ImageIcon(path)).getImage();
	}

	public Image getImage() {
		return imgFruit;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(double timeElapsed) {
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
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