/*
 * @author Zaky		
 */

import java.util.*; 
import java.io.*;

public interface Drawable {
	/** Draw object to g */
	public void draw();

	/** Update object after timeElapsed seconds */
	public void update(int x);
}
