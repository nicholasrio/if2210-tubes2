/**
 * @author William Stefan
 */
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Fruit extends SaleableObject implements Drawable {
	private int id;
	private static Image imgFruit;
	
	public void setImage(int ID) {
		ImageIcon i;
		if(ID == 1) {
			i = new ImageIcon(".png");
			Fruit.imgFruit = i.getImage();
		}
		else if(ID == 2) {
			i = new ImageIcon(".png");
			Fruit.imgFruit = i.getImage();
		}
		else if(ID == 3) {
			i = new ImageIcon(".png");
			Fruit.imgFruit = i.getImage();
		}
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
