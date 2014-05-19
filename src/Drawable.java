/**
 * @author Zaky		
 */

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Drawable {
	/** Draw object to g */
	public void draw(Graphics g);

	/** Update object after timeElapsed seconds */
	public void update(double timeElapsed);
	
	/** Get bounds of object */
	public Rectangle getBounds();
}
