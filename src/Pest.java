/**
 * @author William Stefan
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Pest extends SaleableObject implements Drawable {
	/** The speed of the pest */
	private double speed;

	/** The strength of the pest */
	private double strength;

	/** The hit points of the pest */
	private double hp;

	/** The ID of the pest */
	private int id;

	/** The image container for the pest */
	private static Image imgPest;

	/** CTOR */
	public Pest() {
		this.id = 1 + (int) (Math.random() * ((3 - 1) + 1));
		System.out.println(id);
		ImageIcon i = new ImageIcon("images/pest1.png");
		if (this.id == 1) {
			this.speed = 2;
			this.strength = 2;
			this.hp = 5;
			i = new ImageIcon("images/pest1.png");
		}
		else if (this.id == 2) {
			this.speed = 3;
			this.strength = 3;
			this.hp = 7;
			i = new ImageIcon("images/pest2.png");
		}
		else if (this.id == 3) {
			this.speed = 4;
			this.strength = 4;
			this.hp = 9;
			i = new ImageIcon("images/pest3.png");
		}
		Pest.imgPest= i.getImage();
		this.setImage(this.id);
	}

	/** Set the images according to the pest's ID */
	public void setImage(int ID) {
		ImageIcon i;
		if (ID == 1) {
			i = new ImageIcon("images/pest1.png");
			Pest.imgPest = i.getImage();
		} else if (ID == 2) {
			i = new ImageIcon("images/pest2.png");
			Pest.imgPest = i.getImage();
		} else if (ID == 3) {
			i = new ImageIcon("images/pest3.png");
			Pest.imgPest = i.getImage();
		}
	}

	/** Destroy the desired plant/fruit at position i, j */
	public void destroy(int x, int y) {

	}

	/** Hit the pest to decrease their HP */
	public void hit() {


	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(imgPest, 100, 300, 100, 100, null);
	}

	@Override
	public void update(double timeElapsed) {
		// TODO Auto-generated method stub

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
	public Pest clone() {
		Pest p = new Pest();

		return p;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}