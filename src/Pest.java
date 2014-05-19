/**
 * @author William Stefan
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/** This class is the class used to control the pest that will attack the plants */
public class Pest extends SaleableObject implements Drawable {
	/** The speed of the pest */
	private double speed;

	/** The hit points of the pest */
	private double hp;
	private double maxHp;

	/** The ID of the pest */
	private int id;

	/** The image container for the pest */
	private Image imgPest;

	/** The target plant */
	private Plant target;

	/** CTOR */
	public Pest() {
		this.id = 1 + (int) (Math.random() * ((3 - 1) + 1));
		System.out.println(id);
		ImageIcon i = new ImageIcon("images/pest1.png");
		if (this.id == 1) {
			this.speed = 20;
			this.hp = this.maxHp = 5;
			i = new ImageIcon("images/pest1.png");
		} else if (this.id == 2) {
			this.speed = 30;
			this.hp = this.maxHp = 7;
			i = new ImageIcon("images/pest2.png");
		} else if (this.id == 3) {
			this.speed = 40;
			this.hp = this.maxHp = 9;
			i = new ImageIcon("images/pest3.png");
		}
		imgPest = i.getImage();
		this.setImage(this.id);
		this.target = null;
	}

	/** Set the images according to the pest's ID */
	public void setImage(int ID) {
		ImageIcon i;
		if (ID == 1) {
			i = new ImageIcon("images/pest1.png");
			imgPest = i.getImage();
		} else if (ID == 2) {
			i = new ImageIcon("images/pest2.png");
			imgPest = i.getImage();
		} else if (ID == 3) {
			i = new ImageIcon("images/pest3.png");
			imgPest = i.getImage();
		}
	}

	/** Set the target plant */
	public void setTarget(Plant target) {
		this.target = target;
	}

	/** Get the target plant */
	public Plant getTarget() {
		return this.target;
	}
	
	/** Get distance between pest and target */
	private double getDistance() {
		double distance = Math.sqrt((bounds.getCenterX() - target
				.getBounds().getCenterX())
				* (bounds.getCenterX() - target.getBounds().getCenterX())
				+ (bounds.getCenterY() - target.getBounds().getCenterY())
				* (bounds.getCenterY() - target.getBounds().getCenterY()));
		return distance;
	}
	
	/** Check if pest has reached in target */
	public boolean isTargetReached() {
		return getDistance() < 5.;
	}

	/** Hit the pest to decrease their HP */
	public void hit() {
		hp--;
	}

	/** Check if the pest is dead */
	public boolean isDead() {
		return hp <= 0;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(imgPest, bounds.x, bounds.y, bounds.width, bounds.height,
				null);
		// draw the hp
		g.setColor(Color.RED);
		for (int i = 0; i < 50; i++) {
			if (i >= 50.0 * (double)hp / (double)maxHp) {
				g.setColor(Color.GRAY);
			}
			g.fillRect(getBounds().x - 10, getBounds().y + getBounds().height - i, 4, 1);
		}
	}

	@Override
	public void update(double timeElapsed) {
		// Move the pest to target
		if (target != null) {
			double distance = getDistance();
			if (distance < 1) {
				// do nothing
			} else {
				double dx = (double) (target.getBounds().getCenterX() - bounds
						.getCenterX()) / distance * speed * timeElapsed;
				double dy = (double) (target.getBounds().getCenterY() - bounds
						.getCenterY()) / distance * speed * timeElapsed;
				bounds.x += dx;
				bounds.y += dy;
			}
		}
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
		return bounds;
	}
}