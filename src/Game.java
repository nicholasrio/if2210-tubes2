/*
 * @author Zaky		
 */

import java.util.*; 
import java.io.*;

public class Game {
	/** Constant */
	private static Scanner scan = new Scanner(System.in); 
	
	/** Game attributes */
	private GridPlant land;
	private Fertilizer fertilizer;
	private int waterCapacity;
	private int money;
	private Player player;
	private Vehicle vehicle;
	private Pest pest;
	private int gameturn;
	private Level level;
	private double limitturn;
	
	/** Enumeration for the states of the game */
	static enum GameState {
		INITIALIZED, PLAYING, PAUSED, GAMEOVER, DESTROYED
	}

	static enum PlayerState {
		WATER, BUYPLANT, NORMAL
	}

	/** Current states of the game */
	private static GameState state;

	private PlayerState playerState;

	private int plantID;

	/** Constructor to initialize the UI components and game objects */
	public Game(Level level) {
		this.level = level;
		/** Initialize game components */
		gameInit();
		
		/** Start the game */
		gameLoop();
	}

	/** Getter-Setter */

	/** Return the grid (space/tiles for playing) */
	public GridPlant getLand() {
		return land;
	}

	/** Set the grid */
	public void setLand(GridPlant land) {
		this.land = land;
	}

	/** Return the water capacity that you could carry */
	public int getWaterCapacity() {
		return waterCapacity;
	}

	/** Set the water capacity */
	public void setWaterCapacity(int waterCapacity) {
		this.waterCapacity = waterCapacity;
	}

	/** Return the money */
	public int getMoney() {
		return money;
	}

	/** Set the money */
	public void setMoney(int money) {
		this.money = money;
	}

	/** Return the player */
	public Player getPlayer() {
		return player;
	}

	/** Set the player */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/** All game-related codes */

	/** Initialize all game objects */
	public void gameInit() {
		gameturn = 1;
		money = level.getStartMoney();
		waterCapacity = 10;

		state = GameState.INITIALIZED;

		playerState = PlayerState.NORMAL;
		land = new GridPlant();
		limitturn = level.getLimitTime()/3;
		limitturn = (int) limitturn;
		vehicle = new Vehicle();
		pest = new Pest();
		fertilizer = new Fertilizer(1,10);
	}

	/** The game's main loop */
	private void gameLoop() {
		/** Regenerate and reset the game objects for a new game */
		String s = " ";
		//gamestate.initialized
		/** Game loop */
		while (state != GameState.GAMEOVER && money<level.getGoalMoney() && gameturn<=limitturn) {
			gameUpdate(1);
			/** Refresh the display */			
			s = generateDisplay();
			if(parser(s) == 1){
				System.out.println("Money: " + money);
				/** Draw vehicle */
				System.out.println("Storage capacity :"+vehicle.getVehStorage().getCapacity());
				System.out.println("Water Capacity: " + waterCapacity);
			}
			else if(parser(s) == 2){
				if(vehicle.getId() <=2){
					if (vehicle.getId() == 1){
						if(money - 400 >=0){
							money -= 400;
							vehicle.Upgrade();
						}
					}
					else if (vehicle.getId() == 2){
						if(money - 500 >=0){
							money -= 500;
							vehicle.Upgrade();
						}
					}
					System.out.println("Vehicle has been upgraded");
				}
			}
			else if(parser(s) == 3){
				System.out.printf("1. %-10s %-6s %-5s\n","Apple","Price:", "$50");
				if(level.getUnlockedFruit()==2){
					System.out.printf("2. %-10s %-6s %-5s\n","Strawberry","Price:", "$200");
				}
				else if(level.getUnlockedFruit()==3){
					System.out.printf("2. %-10s %-6s %-5s\n","Strawberry","Price:", "$200");
					System.out.printf("3. %-10s %-6s %-5s\n","Orange","Price:", "$500");
				}
				else if(level.getUnlockedFruit()==4){
					System.out.printf("2. %-10s %-6s %-5s\n","Strawberry","Price:", "$200");
					System.out.printf("3. %-10s %-6s %-5s\n","Orange","Price:", "$500");
					System.out.printf("4. %-10s %-6s %-5s\n","Durian","Price:", "$1000");
				}
				System.out.println("Please enter your choice :");
				String ID = scan.nextLine();
				int id = Integer.parseInt(ID);
				if(money - Plant.buySeed(id) >= 0){
					System.out.println("Put plants coordinate: ");
					String input = scan.nextLine();
					String[] coordinate = input.split(" ");
					String coordinate1 = coordinate[0];
					String coordinate2 = coordinate[1];
					int absis = Integer.parseInt(coordinate1);
					int ordinat = Integer.parseInt(coordinate2);
					if(absis>=0 && absis<=3 && ordinat>=0 && ordinat<=3){
						if(land.getarrPlant().get(absis).get(ordinat) == null){
							money = money - Plant.buySeed(id);
							String name ="";
							if(id == 1){
								name = "Pohon Apel";
							}
							else if(id == 2){
								name = "Pohon Strawberry";
							}
							else if(id == 3){
								name = "Pohon Jeruk";
							}
							else {
								name = "Pohon Durian";
							}
							land.createPlant(absis,ordinat,name);
						}
						else{
							System.out.println("There is a plant in this grid");
						}
					}
					else{
						System.out.println("Wrong input! ckckckck. . .");
					}
				}
				else{
					System.out.println("Wrong input! ckckckck. . .");
				}
			}
			else if(parser(s) == 4){
				System.out.println("Put plants coordinate: ");
				String input = scan.nextLine();
				String[] coordinate = input.split(" ");
				String coordinate1 = coordinate[0];
				String coordinate2 = coordinate[1];
				int absis = Integer.parseInt(coordinate1);
				int ordinat = Integer.parseInt(coordinate2);
				if(absis>=0 && absis<=3 && ordinat>=0 && ordinat<=3){
					if(land.getarrPlant().get(absis).get(ordinat) != null){
						land.getarrPlant().get(absis).get(ordinat).water();
						if(waterCapacity > 0){
							waterCapacity--;
							System.out.println("Plant has been watered");
						}
						else{
							System.out.println("Not enough water");
						}
					}
					else{
						System.out.println("There is no plant in this grid");
					}
				}
				else{
					System.out.println("Wrong input! ckckckck. . .");
				}
			}
			else if(parser(s) == 5){
				if(money >=10){
					money -= 10;
					waterCapacity = 10;
					System.out.println("Water has been refilled");
				}
				else{
					System.out.println("Insufficient money");
				}
			}
			else if(parser(s) == 6){
				System.out.println("Put plants coordinate: ");
				String input = scan.nextLine();
				String[] coordinate = input.split(" ");
				String coordinate1 = coordinate[0];
				String coordinate2 = coordinate[1];
				int absis = Integer.parseInt(coordinate1);
				int ordinat = Integer.parseInt(coordinate2);
				if(absis>=0 && absis<=3 && ordinat>=0 && ordinat<=3){
					if(land.getarrPlant().get(absis).get(ordinat) != null){
						land.getarrPlant().get(absis).get(ordinat).fertilize();
						if(money >=10){
							money -= 10;
							System.out.println("Plant has been fertilized");
						}
						else{
							System.out.println("Insufficient money");
						}
					}
					else{
						System.out.println("There is no plant in this grid");
					}
				}
				else{
					System.out.println("Wrong input! ckckckck. . .");
				}
			}
			else if(parser(s) == 7){
				System.out.println("Put plants coordinate: ");
				String input = scan.nextLine();
				String[] coordinate = input.split(" ");
				String coordinate1 = coordinate[0];
				String coordinate2 = coordinate[1];
				int absis = Integer.parseInt(coordinate1);
				int ordinat = Integer.parseInt(coordinate2);
				if(absis>=0 && absis<=3 && ordinat>=0 && ordinat<=3){
					if(land.getarrPlant().get(absis).get(ordinat) != null){
						if(land.getarrPlant().get(absis).get(ordinat).getFruit() != null){
							try {
								vehicle.addItem(land.getarrPlant().get(absis).get(ordinat).getFruit());
								land.getarrPlant().get(absis).get(ordinat).removeFruit();
								System.out.println("Plant has been harvested");
							}
							catch (StorageOverflowException e) {
								System.out.println(e.getMessage());
							}
						}
						else{
							System.out.println("There is no fruit in this plant");
						}
					}
					else{
						System.out.println("There is no plant in this grid");
					}
				}
				else{
					System.out.println("Wrong input! ckckckck. . .");
				}
			}
			else if(parser(s) == 8){
				vehicle.printVehicleContents();
			}
			else if(parser(s) == 9){
				int a=vehicle.sellAll();
				if(a != 0){
					money += a;
					System.out.println("Harvest plants have been sold");
				}
			}
			else if(parser(s) == 10){
				System.out.println("You pass!!!");
			}
			else if(parser(s) == 11){
				state  = GameState.GAMEOVER;
				System.out.println("Game Over!");
			}
			else{
				System.out.println("Masukan salah");
			}
			gameturn++;
			getchar();
		}
		if(money>=level.getGoalMoney()){
			state  = GameState.GAMEOVER;
			System.out.println("Congratulations, you win the level!!!");
		}
		else if(gameturn>limitturn){
			state  = GameState.GAMEOVER;
			System.out.println("YOU LOSE!!!");
		}
	}
	public int parser(String s){
		String[] input = s.split(" ");
		return (Integer.parseInt(input[0]));
	}
	/** Update the state and position of all the game objects */
	public void gameUpdate(int x) {
		land.update(x);
	}
	
	public void getchar(){
		System.out.println("Press enter to continue . . .");
		String enter = scan.nextLine();
	}
	
	/** Draw components */
	public String generateDisplay() {
		String s = "";
		/** Draw gridplant */
		land.draw();
		System.out.println("Menu ");
		System.out.println("1. Player Status");
		System.out.println("2. Upgrade Vehicle");
		System.out.println("3. Buy a Plant");
		System.out.println("4. Water a Plant");
		System.out.println("5. Refill water");
		System.out.println("6. Fertilize a Plant");
		System.out.println("7. Harvest a Plant");
		System.out.println("8. See Vehicle Contents");
		System.out.println("9. Sell Harvest Plants");
		System.out.println("10. Standby");
		System.out.println("11. Exit");
		System.out.print("Masukkan pilihan anda : ");
		s = scan.nextLine();
		return s;
	}
	
}