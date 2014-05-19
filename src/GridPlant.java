/*
 * @author Riady		
 */

import java.util.*; 
import java.io.*;

public class GridPlant implements Drawable {
	/** The container for plants */
	private ArrayList<ArrayList<Plant>> arrPlant;

	/** Number of the grid rows */
	private final int NROW = 4;

	/** Number of the grid columns */
	private final int NCOL = 4;

	/** Set the position of the grid */
	/*private final Rectangle[][] positions = {
			{ new Rectangle(274, 250, 80, 80), new Rectangle(355, 250, 80, 80), new Rectangle(444, 250, 80, 80), new Rectangle(525, 250, 80, 80) },
			{ new Rectangle(268, 315, 82, 82), new Rectangle(352, 315, 82, 82), new Rectangle(449, 315, 82, 82), new Rectangle(538, 315, 82, 82) },
			{ new Rectangle(258, 375, 85, 85), new Rectangle(348, 375, 85, 85), new Rectangle(453, 375, 85, 85), new Rectangle(547, 375, 85, 85) },
			{ new Rectangle(248, 430, 90, 90), new Rectangle(344, 430, 90, 90), new Rectangle(457, 430, 90, 90), new Rectangle(556, 430, 90, 90) }
	};*/
	public ArrayList<ArrayList<Plant>> getarrPlant(){
		return arrPlant;
	}
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
	public void createPlant(int i, int j, String name) {
		Plant p = PlantFactory.getInstance(name);
		//p.setBounds(positions[i][j]);
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
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < NROW; i++) {
			for (int j = 0; j < NCOL; j++) {	
				System.out.printf("| ");
				if (arrPlant.get(i).get(j) != null) {
					arrPlant.get(i).get(j).draw();
				}
				else{
					System.out.printf("%-24s","");
				}
			}
			System.out.println("|");
			for (int j = 0; j < NCOL; j++) {	
				System.out.printf("| ");
				if (arrPlant.get(i).get(j) != null) {
					if(arrPlant.get(i).get(j).isFruitAvailable()){
						System.out.printf("%-24s","Pohon telah berbuah");
					}
					else{
						System.out.printf("%-24s","Pohon belum berbuah");
					}
				}
				else{
					System.out.printf("%-24s","");
				}
			}
			System.out.println("|");
			for (int j = 0; j < NCOL; j++) {	
				System.out.printf("| ");
				if (arrPlant.get(i).get(j) != null) {
					System.out.printf("%-19s:","Fertilizer Level ");
					System.out.printf("%-4d",(int)arrPlant.get(i).get(j).getFertilizerLevel());
				}
				else{
					System.out.printf("%-24s","");
				}
			}
			System.out.println("|");
			for (int j = 0; j < NCOL; j++) {	
				System.out.printf("| ");
				if (arrPlant.get(i).get(j) != null) {
					System.out.printf("%-19s:","Water Level  ");
					System.out.printf("%-4d",(int)arrPlant.get(i).get(j).getWaterLevel());
				}
				else{
					System.out.printf("%-24s","");
				}
			}
			System.out.println("|");
			System.out.println("---------------------------------------------------------------------------------------------------------");
		}
	}
	public void destroy(int i, int j) {
		arrPlant.get(i).set(j, null);
	}
	
	@Override
	public void update(int x) {
		// TODO Auto-generated method stub
		for (int i = 0; i < NROW; i++) {
			for (int j = 0; j < NCOL; j++) {
				if (arrPlant.get(i).get(j) != null) {
					arrPlant.get(i).get(j).update(x);
					if(arrPlant.get(i).get(j).getStage()==null){
						destroy(i,j);
					}
				}
			}
		}
	}
}
