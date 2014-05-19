/**
 * @author William Stefan
 */

import java.util.*; 
import java.io.*;

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
	//private static Image imgPest;

	/** CTOR */
	public Pest() {
		this.id = 1 + (int) (Math.random() * ((3 - 1) + 1));
		System.out.println(id);
		//ImageIcon i = new ImageIcon("images/pest1.png");
		if (this.id == 1) {
			this.speed = 2;
			this.strength = 2;
			this.hp = 5;
			//i = new ImageIcon("images/pest1.png");
		}
		else if (this.id == 2) {
			this.speed = 3;
			this.strength = 3;
			this.hp = 7;
			//i = new ImageIcon("images/pest2.png");
		}
		else if (this.id == 3) {
			this.speed = 4;
			this.strength = 4;
			this.hp = 9;
			//i = new ImageIcon("images/pest3.png");
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
	public void draw() {
		//g.drawImage(imgPest, 50, 50, 50, 50, null);
		
	}

	@Override
	public void update(int x) {
		// TODO Auto-generated method stub

	}

}