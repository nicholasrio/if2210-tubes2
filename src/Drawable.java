/**
 * @author Zaky		
 */

import java.awt.Graphics;
import java.awt.Rectangle;

/** This interface is used in every class that will be displayed in the GUI */
public interface Drawable {
	/** Draw object to g */
	public void draw(Graphics g);

	/** Update object after timeElapsed seconds */
	public void update(double timeElapsed);
	
	/** Get bounds of object */
	public Rectangle getBounds();
}
