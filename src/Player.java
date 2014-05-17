/*
 * @author Nisa		
 */

import java.util.ArrayList;

public class Player {
	private double Money; /** The player's money */
	private String ID; /** The player's name */
	private ArrayList<Plant> ULPlant; /** The plants that the player has */
	private ArrayList<Vehicle> ULVehicle; /** The vehicles that the player has */
	private ArrayList<Fertilizer> ULFertilizer; /** The fertilizer that the player has */

	/** CTOR */
	public Player() {
		Money=100;
		ID="Player";
		ULPlant=new ArrayList<Plant>();
		ULVehicle=new ArrayList<Vehicle>();
		ULFertilizer=new ArrayList<Fertilizer>();
	}

	/** Change the player's name */
	public void ChangeID(String nama) {
		ID=nama;
	}

	/** Purchase plant's seed*/
	public void beli(Plant P){
		// TODO resolve this
		// Money=Money-P.hargabibit();
	}

	/** Add the plant to the array */
	public void addPlant(Plant OB){
		ULPlant.add(OB);
	}

	/** Add the vehicle to the array */
	public void addVehicle(Vehicle OB){
		ULVehicle.add(OB);
	}

	/** Add the fertilizer to the array */
	public void addFertilizer(Fertilizer OB){
		ULFertilizer.add(OB);
	}
}
