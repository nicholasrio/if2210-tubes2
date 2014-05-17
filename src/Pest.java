/**
 * @author William Stefan
 */

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Pest extends SaleableObject implements Drawable {
	private double speed; /** The speed of the pest */
	private double strength; /** The strength of the pest  */
	private double hp; /** The hit points of the pest */
	private int id; /** The ID of the pest */
	private static Image imgPest; /** The image container for the pest */

	/** CTOR */
	public Pest() {
		this.id = 1 + (int)(Math.random() * ((3 - 1) + 1));
		if(this.id == 1) {
			this.speed = 2;
			this.strength = 2;
			this.hp = 5;
		}
		if(this.id == 2) {
			this.speed = 3;
			this.strength = 3;
			this.hp = 7;			
		}
		if(this.id == 3) {
			this.speed = 4;
			this.strength = 4;
			this.hp = 9;			
		}
	}

	/** Set the images according to the pest's ID */
	public void setImage(int ID) {
		ImageIcon i;
		if(ID == 1) {
			i = new ImageIcon("pest1.png");
			Pest.imgPest = i.getImage();
		}
		else if(ID == 2) {
			i = new ImageIcon("pest2.png");
			Pest.imgPest = i.getImage();
		}
		else if(ID == 3) {
			i = new ImageIcon("pest3.png");
			Pest.imgPest = i.getImage();
		}
	}

	/** Destroy the desired plant/fruit at position i, j */
	public void destroy(int x, int y) {

	}

	/** Hit the pest to decrease their HP */
	public void hit() {
		// TODO

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(double timeElapsed) {
		// TODO Auto-generated method stub

	}

}