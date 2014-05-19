/**
 * @author Zaky		
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
/** This class is used to create buttons and acts as the game initializer */
public class Game extends JPanel implements MouseListener, MouseMotionListener {

	/** Constant */
	static String TITLE = "The Plan(T)s";
	static String beliApel = "Price: $x";
	static String beliStrawberry= "Price: $y";
	
	/** For debugging */
	private static int ID = 0;
	int id;

	/** Game attributes */
	private GridPlant land;
	private int waterCapacity;
	private Fertilizer fertilizer;
	private int money;
	private int goalMoney;
	private Player player;
	private Vehicle vehicle;
	private Pest pest;
	private double pestCoolDown;
	private int water;
	private Level level;
	private double timeLeft;

	/** Game Components */
	private Image background;
	private Image clockImage;
	private Image moneyImage;
	private Image waterImage;
	private JButton resetButton;
	private JButton upgrade;
	private JButton downgrade;
	private JButton go;
	private JButton waterButton;
	private JButton fertilizerButton;
	private JButton buyApple;
	private JButton buyStrawberry;
	private JButton buyOrange;
	private JButton buyDurian;
	private JButton refill;

	/** The number of updates per second */
	private static final int FRAMERATE = 10;

	/** The main thread of the game */
	private Thread gameThread = null;

	/** Enumeration for the states of the game */
	static enum GameState {
		INITIALIZED, PLAYING, PAUSED, GAMEOVER, DESTROYED
	}

	static enum PlayerState {
		WATERING, FERTILIZING, BUYPLANT, NORMAL
	}
	String status;

	/** Current states of the game */
	private GameState state;
	private PlayerState playerState;

	private int plantID;

	/** Constructor to initialize the UI components and game objects */
	public Game(Level level) {
		// TODO remove this part of code
		id = ++ID;
		
		this.level = level;

		/** Initialize game components */
		gameInit();

		this.setLayout(null);
		this.setPreferredSize(new Dimension(ThePlants.PANEL_WIDTH,
				ThePlants.PANEL_HEIGHT));

		/** Add action listener */
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		/** Start the game */
		gameStart();
	}

	/* Getter-Setter */

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

	/* All game-related codes */

	/** Initialize all game objects */
	public void gameInit() {

		state = GameState.INITIALIZED;

		playerState = PlayerState.NORMAL;
		land = new GridPlant();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// land.createPlant(i, j);
			}
		}

		// TODO set fertilizer yang bener
		fertilizer = new Fertilizer(1, 0);
		vehicle = new Vehicle();
		pest = null;
		pestCoolDown = 10;

		/** Set background */
		background = (new ImageIcon("images/background_game.png")).getImage();
		
		/** Load another images */
		waterImage = (new ImageIcon("images/water.png")).getImage();
		moneyImage = (new ImageIcon("images/money.png")).getImage();
		clockImage = (new ImageIcon("images/clock.png")).getImage();
		
		/** Add components */
		// Hapus!
		/** Reset button to reset the game back to the start */
		resetButton = new JButton("Back");
		resetButton.setBounds(650, 340, 120, 30);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int response = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin?", ThePlants.TITLE, JOptionPane.OK_OPTION);
				if (response == JOptionPane.OK_OPTION) {
					ThePlants.changePanel(new MainMenu());
					// Stop Current Thread
					gameThread.interrupt();
				}
			}
		});
		resetButton.setToolTipText("Back to Main Menu");
		this.add(resetButton);

		/** Upgrade button for your vehicle */
		upgrade = new JButton("Upgrade");
		upgrade.setBounds(650, 280, 120, 30);
		upgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (vehicle.getStatus() == 0) {
					if (vehicle.getID() == 1) {
						if ((money - 400) > -0) {
							vehicle.Upgrade();
							money -= 400;
						} else {
							showMessage("Your money is not enough");
						}
					} else if (vehicle.getID() == 2) {
						if ((money - 500) > -0) {
							vehicle.Upgrade();
							money -= 500;
						} else {
							showMessage("Your money is not enough");
						}
					}
				} else {
					showMessage("Wait until our vehicle has arrived at the farm");
				}
			}
		});
		upgrade.setToolTipText("Upgrade your vehicle");
		this.add(upgrade);

		/** Make your vehicle go to the market and sell all the storages */
		go = new JButton("Sell All");
		go.setBounds(650, 310, 120, 30);
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (vehicle.getStatus() == 0) {
					vehicle.setStatus(1);
				} else {
					showMessage("Wait until our vehicle has arrived at the farm");
				}
			}
		});
		go.setToolTipText("Make the vehicle go to the market to sell your collections");
		this.add(go);

		/** A button that lets you water your plants */
		waterButton = new JButton("Water");
		waterButton.setBounds(650, 220, 120, 30);
		waterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				if (playerState != PlayerState.WATERING) {
					changePlayerState(PlayerState.WATERING);
				} else {
					changePlayerState(PlayerState.NORMAL);
				}
			}
		});
		waterButton.setToolTipText("Watering the plant");
		this.add(waterButton);

		/** A button that lets you fertilize your plants */
		fertilizerButton = new JButton("Fertilize");
		fertilizerButton.setBounds(650, 190, 120, 30);
		fertilizerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				if (playerState != PlayerState.FERTILIZING) {
					changePlayerState(PlayerState.FERTILIZING);
				} else {
					changePlayerState(PlayerState.NORMAL);
				}
			}
		});
		fertilizerButton.setToolTipText("Fertilizing the plant");
		this.add(fertilizerButton);

		/** A button to buy apple seed */
		buyApple = new JButton("Apple");
		buyApple.setBounds(200, 70, 100, 30);
		buyApple.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				if (playerState != PlayerState.BUYPLANT || plantID != 1) {
					plantID = 1;
					changePlayerState(PlayerState.BUYPLANT);
				} else {
					changePlayerState(PlayerState.NORMAL);
				}
			}
		});
		buyApple.setToolTipText("Click on the grid to plant");
		this.add(buyApple);

		/** A button to buy strawberry seed */
		buyStrawberry = new JButton("Strawberry");
		buyStrawberry.setBounds(300, 70, 100, 30);
		buyStrawberry.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (playerState != PlayerState.BUYPLANT || plantID != 1) {
					plantID = 2;
					changePlayerState(PlayerState.BUYPLANT);
				} else {
					changePlayerState(PlayerState.NORMAL);
				}
			}
		});
		buyStrawberry.setToolTipText("Click on the grid to plant");
		this.add(buyStrawberry);

		/** A button to buy orange seed */
		buyOrange = new JButton("Orange");
		buyOrange.setBounds(400, 70, 100, 30);
		buyOrange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (playerState != PlayerState.BUYPLANT || plantID != 1) {
					plantID = 3;
					changePlayerState(PlayerState.BUYPLANT);
				} else {
					changePlayerState(PlayerState.NORMAL);
				}
			}
		});
		buyOrange.setToolTipText("Click on the grid to plant");
		this.add(buyOrange);

		/** A button to buy Durian seed */
		buyDurian = new JButton("Durian");
		buyDurian.setBounds(500, 70, 100, 30);
		buyDurian.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (playerState != PlayerState.BUYPLANT || plantID != 1) {
					plantID = 4;
					changePlayerState(PlayerState.BUYPLANT);
				} else {
					changePlayerState(PlayerState.NORMAL);
				}
			}
		});
		buyDurian.setToolTipText("Click on the grid to plant");
		this.add(buyDurian);

		/** A button to refill your water */
		refill = new JButton("Refill water");
		refill.setBounds(650, 250, 120, 30);
		refill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (money >= 10) {
					water = 10;
					money -= 10;
				} else {
					showMessage("Your money is not enough");
				}
			}
		});
		refill.setToolTipText("A button to refill your water");
		this.add(refill);

		// Set level here
		money = level.getStartMoney();
		goalMoney = level.getGoalMoney();
		timeLeft = level.getLimitTime();
		if (level.getUnlockedFruit() < 4) {
			buyDurian.setEnabled(false);
		}
		if (level.getUnlockedFruit() < 3) {
			buyOrange.setEnabled(false);
		}
		if (level.getUnlockedFruit() < 2) {
			buyStrawberry.setEnabled(false);
		}
		water = 10;
	}

	/** Close the game */
	public void gameShutdown() {

	}

	/** Procedure called after the game ends */
	public void gameOver() {
		this.state = GameState.GAMEOVER;
		showMessage("Game Over!");
		if (money >= goalMoney) {
			if (level.getId() < 5) {
				int response = JOptionPane.showConfirmDialog(null, "Selamat! Anda mencapai target! Apakah Anda mau ke level selanjutnya?", ThePlants.TITLE, JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.OK_OPTION) {
					// Go to the next level
					ThePlants.changePanel(new Game(new Level(level.getId() + 1)));
				}
				else {
					// Go to main menu
					ThePlants.changePanel(new MainMenu());
				}
				Thread.currentThread().interrupt();
			}
			else {
				showMessage("Selamat! Anda menyelesaikan level terakhir!");
				// Go to main menu
				ThePlants.changePanel(new MainMenu());
				Thread.currentThread().interrupt();
			}
		}
		else {
			int response = JOptionPane.showConfirmDialog(null, "Sayang sekali Anda kalah! Mau mengulangi?", ThePlants.TITLE, JOptionPane.YES_NO_OPTION);
			if (response == JOptionPane.OK_OPTION) {
				ThePlants.changePanel(new Game(level));
			}
			else {
				ThePlants.changePanel(new MainMenu());
			}
			Thread.currentThread().interrupt();
		}
	}
	
	/** To start and restart your game */
	public void gameStart() {
		gameThread = new Thread() {
			@Override
			public void run() {
				gameLoop();
			}
		};
		// Start the main game thread
		gameThread.start();
	}

	/** The game's main loop */
	private void gameLoop() {
		/** Regenerate and reset the game objects for a new game */
		if (state == GameState.INITIALIZED || state == GameState.GAMEOVER) {

			state = GameState.PLAYING;
		}

		/** Game loop */
		long beginTime, timeTaken, timeLeft; // in msec
		while (state != GameState.GAMEOVER) {
			// System.out.println("Ini Game dengan ID = " + ID);

			beginTime = System.nanoTime();
			if (state == GameState.PLAYING) {
				/** Update the state and position of all the game objects */
				/** Detect collisions and provide responses */
				gameUpdate(1.0 / FRAMERATE);
			}
			/** Refresh the display */
			repaint();
			/**
			 * Delay timer to provide the necessary delay to meet the target
			 * rate in milliseconds
			 */
			timeTaken = System.nanoTime() - beginTime;
			timeLeft = (1000000000L / FRAMERATE - timeTaken) / 1000000;

			if (timeLeft < 10)
				timeLeft = 10;
			/** Set a minimum */
			try {
				/**
				 * Provide the necessary delay and also yields control so that
				 * other threads can do the work
				 */
				Thread.sleep(timeLeft);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
				/** Preserves the message */
				return;
				/** Stop all active things and terminate */
			}
		}
	}

	/** Update the state and position of all the game objects */
	public void gameUpdate(double timeElapsed) {
		// decrease time left
		if (this.state == GameState.PLAYING) {
			timeLeft -= timeElapsed;
			if (timeLeft <= 0) {
				timeLeft = 0;
				gameOver();
			}
			// plant.update();
			land.update(timeElapsed);
			vehicle.update(timeElapsed);
			// check if it has any money
			if (vehicle.getMoney() > 0) {
				this.money += vehicle.getMoney();
				vehicle.setMoney(0);
			}
			// pest update
			if (pest != null) {
				pest.update(timeElapsed);
				if (pest.getTarget() == null) {
					// find a new target
					ArrayList<Plant> allPlants = land.getAllPlants();
					if (allPlants.size() > 0) {
						int i = (new Random(System.nanoTime())).nextInt(allPlants.size());
						pest.setTarget(allPlants.get(i));
					}
				}
				else {
					if (pest.isTargetReached()) {
						// destroy plant
						land.destroy(pest.getTarget());
						pest.setTarget(null);
					}
				}
				if (pest.isDead()) {
					pest = null;
					pestCoolDown = 10;
				}
			}
			else {
				pestCoolDown -= timeElapsed;
				if (pestCoolDown <= 0) {
					pest = new Pest();
					pest.setBounds(new Rectangle(550, 300 + (new Random(System.nanoTime())).nextInt(150), 45, 45));
				}
			}
		}
	}

	/** Change current state of player */
	public void changePlayerState(PlayerState newState) {
		playerState = newState;
	}
	/** Get current status */
	public String getStatus() {
		switch (playerState) {
		case NORMAL:
			if (pest != null) {
				return "Klik hama untuk membunuhnya";
			}
			else {
				if (land.getAllPlants().isEmpty()) {
					return "Klik tombol di bawah untuk membeli tanaman";
				}
				else {
					return "Klik tanaman saat sudah \nberbuah untuk menjualnya";
				}
			}
		case WATERING:
			return "Klik salah satu tanaman \nuntuk menyiram";
		case FERTILIZING:
			return "Klik salah satu tanaman \nuntuk memberi pupuk";
		case BUYPLANT:
			return "Klik salah satu petak untuk \nmenanam";
		default:
			return "";
		}
	}

	/** Draw components */
	@Override
	public void paintComponent(Graphics g) {
		/** Draw background */
		super.paintComponent(g);
		g.drawImage(background, 0, 0, ThePlants.PANEL_WIDTH,
				ThePlants.PANEL_HEIGHT, null);
		
		/** Draw gridplant */
		land.draw(g);

		/** Draw vehicle */
		vehicle.draw(g);

		/** Draw pest */
		if (pest != null) {
			pest.draw(g);
		}

		/** Game info */
		g.setFont(new Font("Dialog", Font.PLAIN, 14));
		g.setColor(Color.WHITE);
		g.drawString(TITLE, 200, 300);
		Font oldFont = g.getFont();
		g.setFont(new Font("Dialog", Font.BOLD, 16));
		g.drawString("Petunjuk", 460, 25);
		g.setFont(oldFont);
		g.drawString(getStatus(), 460, 45);
		g.drawString("Price: "
				+ PlantFactory.getPrototype("Pohon Apel").getPrice(), 220, 120);
		g.drawString("Price: "
				+ PlantFactory.getPrototype("Pohon Strawberry").getPrice(), 320, 120);
		g.drawString("Price: "
				+ PlantFactory.getPrototype("Pohon Jeruk").getPrice(), 420, 120);
		g.drawString("Price: "
				+ PlantFactory.getPrototype("Pohon Durian").getPrice(), 520, 120);

		g.drawString("Goal: " + goalMoney, 200, 66);
		g.setFont(new Font("Verdana", Font.BOLD, 30));

		/** Draw time left */
		g.drawImage(clockImage, 20, 20, 30, 30, null);
		g.drawString(String.format("%02d:%02d", (int)Math.floor(timeLeft) / 60, (int)Math.floor(timeLeft) % 60), 60, 40);

		/** Draw Money and water capacity */
		g.drawImage(moneyImage, 200, 20, 45, 30, null);
		g.drawString(String.valueOf(money), 250, 40);
		
		g.drawImage(waterImage, 350, 20, 20, 30, null);
		g.drawString(String.valueOf(water), 380, 40);
	}

	/** Show message */
	public void showMessage(String message){
		JOptionPane.showConfirmDialog(null, message, ThePlants.TITLE, JOptionPane.DEFAULT_OPTION);
	}
	
	/* Code for Action Listener (Mouse Listener) */

	@Override
	public void mouseClicked(MouseEvent event) {
		if (state == GameState.PLAYING) {
			// Klik kanan
			if (event.getButton() == MouseEvent.BUTTON3) {
				changePlayerState(PlayerState.NORMAL);
			}
			// Klik kiri
			else if (event.getButton() == MouseEvent.BUTTON1) {
				ArrayList<Plant> allPlant = land.getAllPlants();
				// reverse the array, for convenience
				Collections.reverse(allPlant);

				// Choose action depending on the current player state
				switch (playerState) {
				case WATERING:
					for (Plant p : allPlant) {
						if (p.contains(event.getPoint())) {
							if (water > 0) {
								p.water();
								water--;
							} else {
								showMessage("Air Anda habis! Silakan refill air Anda");
							}
							// break so that other plants behind it will not be clicked
							break;
						}
					}
					break;

				case FERTILIZING:
					for (Plant p : allPlant) {
						if (p.contains(event.getPoint())) {
							if (money >= fertilizer.getPrice()) {
								p.fertilize(fertilizer.getAmount());
								money -= fertilizer.getPrice();
							} else {
								showMessage("Anda tidak punya uang yang cukup");
							}
							break;
						}
					}
					break;

				case BUYPLANT:
					if ((money - Plant.buySeed(plantID)) >= 0) {
						String name = "";
						switch (plantID) {
						case 1:
							name = "Pohon Apel";
							break;
						case 2:
							name = "Pohon Strawberry";
							break;
						case 3:
							name = "Pohon Jeruk";
							break;
						case 4:
							name = "Pohon Durian";
							break;
						}
						if (land.createPlantWithEvent(event, name)) {
							money -= Plant.buySeed(plantID);
							playerState = PlayerState.NORMAL;
						}
					}
					// TODO Other ...
					break;

				case NORMAL:
					// Kill pest
					if (pest != null) {
						if (pest.contains(event.getPoint())) {
							pest.hit();
							break;
						}
					}
					
					// Take fruit
					for (Plant p : allPlant) {
						if (p.contains(event.getPoint())) {
							if (p.isFruitAvailable()) {
								if (vehicle.getStatus() == 0) {
									Fruit fruit = p.getFruit();
									if (fruit.getCapacity() > 0) {
										try {
											vehicle.addItem(fruit);
											p.removeFruit();
										}
										catch (StorageOverflowException e) {
											showMessage("Storage tidak muat! Coba jual dulu barang-barang yang ada sekarang");
										}
									}
									else {
										p.removeFruit();
									}
								}
								else {
									showMessage("Tunggu sampai kendaraan tiba kembali");
								}
								// break so that other plants behind it will not be clicked
								break;
							}
						}
					}
					
					break;
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		// TODO insert something here or remove this method

	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO insert something here or remove this method

	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO insert something here or remove this method

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO insert something here or remove this method

	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO insert something here or remove this method
		TITLE = "Dragged";
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// update land
		if (playerState == PlayerState.BUYPLANT) {
			land.updateActiveGrid(event.getPoint(), false);
		}
		else {
			land.updateActiveGrid(event.getPoint(), true);
		}
		// TODO remove codes below
		TITLE = "Position: " + event.getX() + ", " + event.getY();
	}
}