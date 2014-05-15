import java.awt.Graphics;
import java.util.ArrayList;

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
		arrPlant.get(i).set(j, new Plant());
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (arrPlant.get(i).get(j) != null) {
					arrPlant.get(i).get(j).draw(g, i * 100, j * 100);
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
					arrPlant.get(i).get(j).update(0.);
				}
			}
		}
	}
}
