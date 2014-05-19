/*
 * @author Riady		
 */

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class GridPlant implements Drawable {
	/** The container for plants */
	private ArrayList<ArrayList<Plant>> arrPlant;

	/** Number of the grid rows */
	private final int NROW = 4;

	/** Number of the grid columns */
	private final int NCOL = 4;

	/** Set the position of the grid */
	private final static Rectangle[][] positions = new Rectangle[4][4];
//	{
//			{ new Rectangle(274, 250, 80, 80), new Rectangle(355, 250, 80, 80), new Rectangle(444, 250, 80, 80), new Rectangle(525, 250, 80, 80) },
//			{ new Rectangle(268, 315, 82, 82), new Rectangle(352, 315, 82, 82), new Rectangle(449, 315, 82, 82), new Rectangle(538, 315, 82, 82) },
//			{ new Rectangle(258, 375, 85, 85), new Rectangle(348, 375, 85, 85), new Rectangle(453, 375, 85, 85), new Rectangle(547, 375, 85, 85) },
//			{ new Rectangle(248, 430, 90, 90), new Rectangle(344, 430, 90, 90), new Rectangle(457, 430, 90, 90), new Rectangle(556, 430, 90, 90) }
//	};
	
	private final static Point UPPER_LEFT = new Point(63, 281);
	private final static Point UPPER_RIGHT = new Point(376, 281);
	private final static Point BOTTOM_LEFT = new Point(13, 512);
	private final static Point BOTTOM_RIGHT = new Point(427, 512);
	private final static Polygon[][] grid = new Polygon[4][4];
	private Point activeGrid = null;

	/** CTOR */
	GridPlant() {
		arrPlant = new ArrayList<ArrayList<Plant>>();
		for (int i = 0; i < NROW; i++) {
			ArrayList<Plant> temp = new ArrayList<Plant>();
			for (int j = 0; j < NCOL; j++) {
				temp.add(null);
			}
			arrPlant.add(temp);
		}
		
		calculatePolygon();
	}
	
	private void calculatePolygon() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				grid[i][j] = new Polygon();
				Point p = new Point(UPPER_LEFT.x + (UPPER_RIGHT.x - UPPER_LEFT.x) * j / 4, UPPER_LEFT.y + (UPPER_RIGHT.y - UPPER_LEFT.y) * j / 4);
				Point q = new Point(UPPER_LEFT.x + (UPPER_RIGHT.x - UPPER_LEFT.x) * (j+1) / 4, UPPER_LEFT.y + (UPPER_RIGHT.y - UPPER_LEFT.y) * (j+1) / 4);
				Point r = new Point(BOTTOM_LEFT.x + (BOTTOM_RIGHT.x - BOTTOM_LEFT.x) * j / 4, BOTTOM_LEFT.y + (BOTTOM_RIGHT.y - BOTTOM_LEFT.y) * j / 4);
				Point s = new Point(BOTTOM_LEFT.x + (BOTTOM_RIGHT.x - BOTTOM_LEFT.x) * (j+1) / 4, BOTTOM_LEFT.y + (BOTTOM_RIGHT.y - BOTTOM_LEFT.y) * (j+1) / 4);

				Point a = new Point(p.x + (r.x - p.x) * i / 4, p.y + (r.y - p.y) * i / 4); 
				Point b = new Point(p.x + (r.x - p.x) * (i+1) / 4, p.y + (r.y - p.y) * (i+1) / 4); 
				Point c = new Point(q.x + (s.x - q.x) * i / 4, q.y + (s.y - q.y) * i / 4); 
				Point d = new Point(q.x + (s.x - q.x) * (i+1) / 4, q.y + (s.y - q.y) * (i+1) / 4); 
				
				grid[i][j].addPoint(a.x, a.y);
				grid[i][j].addPoint(b.x, b.y);
				grid[i][j].addPoint(d.x, d.y);
				grid[i][j].addPoint(c.x, c.y);
				
				Point x = new Point((a.x + b.x) / 2 + 5, (a.y + b.y) / 2 + 5);
				Point y = new Point((c.x + d.x) / 2 - 5, (c.y + d.y) / 2 + 5);
				int size = y.x - x.x;
				positions[i][j] = new Rectangle(x.x, x.y - size, size, size);
			}
		}
	}

	/** Plant the plant with coordinate i, j */
	public void createPlant(int i, int j, String name) {
		Plant p = PlantFactory.getInstance(name);
		p.setBounds(positions[i][j]);
		arrPlant.get(i).set(j, p);
	}

	/** Return the plants that you've planted */
	public ArrayList<Plant> getAllPlants() {
		ArrayList<Plant> allPlant = new ArrayList<Plant>();
		for (int i = 0; i < NROW; i++) {
			for (int j = 0; j < NCOL; j++) {
				Plant now = arrPlant.get(i).get(j);
				if (now != null) {
					allPlant.add(now);
				}
			}
		}

		return allPlant;
	}

	public Rectangle[][] getAllPos() {
		return positions;
	}

	public boolean createPlantWithEvent(MouseEvent event, String name) {

		for (int i = 0; i < NROW; i++) {
			for (int j = 0; j < NCOL; j++) {
				if (grid[i][j].contains(event.getPoint()) && arrPlant.get(i).get(j) == null) {
					createPlant(i, j, name);
					return true;
				}
			}
		}
		return false;
	}

	public void updateActiveGrid(Point position, boolean usePlant) {
		activeGrid = null;
		for (int i = NROW-1; i >= 0; i--) {
			for (int j = NCOL-1; j >= 0; j--) {
				if (usePlant) {
					if (arrPlant.get(i).get(j) != null && positions[i][j].contains(position)) {
						activeGrid = new Point(i, j);
						return;
					}
				}
				else {
					if (grid[i][j].contains(position)) {
						activeGrid = new Point(i, j);
						return;
					}
				}
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		
		// draw the grid
		Color cFill = new Color(255, 217, 102);
		Color cFillActive = new Color(255, 190, 102);
		for (int i = 0; i < NROW; i++) {
			for (int j = 0; j < NCOL; j++) {
				if (activeGrid != null && activeGrid.x == i && activeGrid.y == j) {
					g.setColor(cFillActive);
				}
				else {
					g.setColor(cFill);
				}
				g.fillPolygon(grid[i][j]);
			}
		}

		Graphics2D g2 = (Graphics2D)g;
		Stroke oldStroke = g2.getStroke();
		g2.setStroke(new BasicStroke(3));
		Color cLine = new Color(127, 96, 0);
		g2.setColor(cLine);
		for (int i = 0; i < NROW; i++) {
			for (int j = 0; j < NCOL; j++) {
				g2.drawPolygon(grid[i][j]);
			}
		}
		g2.setStroke(oldStroke);

		for (int i = 0; i < NROW; i++) {
			for (int j = 0; j < NCOL; j++) {
				if (arrPlant.get(i).get(j) != null) {
					arrPlant.get(i).get(j).draw(g);
				}
			}
		}
	}

	@Override
	public void update(double timeElapsed) {
		// TODO Auto-generated method stub

		for (int i = 0; i < NROW; i++) {
			for (int j = 0; j < NCOL; j++) {
				if (arrPlant.get(i).get(j) != null) {
					arrPlant.get(i).get(j).update(timeElapsed);
					// check if current plant dies
					if (arrPlant.get(i).get(j).getStage() == null) {
						arrPlant.get(i).set(j, null);
					}
				}
			}
		}
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}
}
