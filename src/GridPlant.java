import java.awt.*;
import java.util.*;

public class GridPlant implements Drawable {
	ArrayList<ArrayList<Plant>> arrPlant;

	GridPlant() {
		arrPlant = new ArrayList<ArrayList<Plant>>();
		for (int i = 0; i < 6; i++) {
			ArrayList<Plant> temp = new ArrayList<Plant>();
			for (int j = 0; j < 6; j++) {
				temp.add(null);
			}
			arrPlant.add(temp);
		}
	}

	public void createPlant(int i, int j) {
		Plant p = PlantFactory.getInstance("Pohon Apel");
		p.setBounds(new Rectangle(i * 100, j * 100, 80, 80));
		arrPlant.get(i).set(j, p);
	}
	
	public ArrayList<Plant> getAllPlants() {
		ArrayList<Plant> allPlant = new ArrayList<Plant>();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
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

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (arrPlant.get(i).get(j) != null) {
					arrPlant.get(i).get(j).draw(g);
				}
			}
		}
	}

	@Override
	public void update(double timeElapsed) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (arrPlant.get(i).get(j) != null) {
					arrPlant.get(i).get(j).update(timeElapsed);
				}
			}
		}
	}
}
