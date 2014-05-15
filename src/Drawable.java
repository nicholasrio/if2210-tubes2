import java.awt.Graphics;

public interface Drawable {
	// Draw object to g
	public void draw(Graphics g);
	
	// Update object after timeElapsed seconds
	public void update(double timeElapsed);
}
