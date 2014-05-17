/*
 * @author Riady		
 */

import java.awt.*;
import java.util.*;

public class GridPlant implements Drawable {
	private ArrayList<ArrayList<Plant>> arrPlant;

	private final int NROW = 4; /** Number of the grid rows */
	private final int NCOL = 4; /**Number of the grid columns */

	/** Set the position of the grid */
	private final Rectangle[][] positions = {
			{new Rectangle(274, 250, 80, 80), new Rectangle(355, 250, 80, 80), new Rectangle(444, 250, 80, 80), new Rectangle(525, 250, 80, 80)},
			{new Rectangle(268, 315, 82, 82), new Rectangle(352, 315, 82, 82), new Rectangle(449, 315, 82, 82), new Rectangle(538, 315, 82, 82)},
			{new Rectangle(258, 375, 85, 85), new Rectangle(348, 375, 85, 85), new Rectangle(453, 375, 85, 85), new Rectangle(547, 375, 85, 85)},
			{new Rectangle(248, 430, 90, 90), new Rectangle(344, 430, 90, 90), new Rectangle(457, 430, 90, 90), new Rectangle(556, 430, 90, 90)}
	};

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
	}

	/** Plant the plant with coordinate i, j */
	public void createPlant(int i, int j) {
		Plant p = PlantFactory.getInstance("Pohon Apel");
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

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

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
				}
			}
		}
	}
}
