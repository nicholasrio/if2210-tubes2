/**
 * @author Zaky		
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener, MouseListener,
		MouseMotionListener {

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
	private Player player;
	private Vehicle vehicle;
	private Pest pest;
	private int water;

	/** Game Components */
	private Image background;
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

	/** Current states of the game */
	private static GameState state;
	private PlayerState playerState;

	private int plantID;

	/** Constructor to initialize the UI components and game objects */
	public Game() {
		// TODO remove this part of code
		id = ++ID;

		/** Initialize game components */
		gameInit();

		this.setLayout(null);
		this.setPreferredSize(new Dimension(ThePlants.PANEL_WIDTH,
				ThePlants.PANEL_HEIGHT));

		/** Add action listener */
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		/** Start the game */
		gameStart();
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

		money = 5000;
		water = 10;

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
		pest = new Pest();

		/** Set background */
		background = (new ImageIcon("images/background_game.png")).getImage();

		/** Add components */
		/** Reset button to reset the game back to the start */
<<<<<<< HEAD
		JButton resetButton = new JButton("Reset");
=======
		resetButton = new JButton("Reset");
>>>>>>> b0ab8a954e166f8dada1f0f879754aa59e554278
		resetButton.setBounds(650, 250, 120, 30);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showMessage("Hai! mau reset game?");
				ThePlants.changePanel(new Game());
				// Stop Current Thread
				gameThread.interrupt();
			}
		});
		resetButton.setToolTipText("Reset the game");
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
							System.out.println("Your money is not enough");
						}
					} else if (vehicle.getID() == 2) {
						if ((money - 500) > -0) {
							vehicle.Upgrade();
							money -= 500;
						} else {
							System.out.println("Your money is not enough");
						}
					}
				} else {
					showMessage("Wait until our vehicle has arrived at the farm");
				}
			}
		});
		upgrade.setToolTipText("Upgrade your vehicle");
		this.add(upgrade);

		/** Downgrade button for your vehicle */
		downgrade = new JButton("Downgrade");
		downgrade.setBounds(650, 310, 120, 30);
		downgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (vehicle.getStatus() == 0) {
					vehicle.Downgrade();
				} else {
					showMessage("Wait until our vehicle has arrived at the farm");
				}
			}
		});
		downgrade.setToolTipText("Downgrade your vehicle");
		this.add(downgrade);

		/** Make your vehicle go to the market and sell all the storages */
		go = new JButton("Go");
		go.setBounds(650, 340, 120, 30);
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
<<<<<<< HEAD
		
		/** A button to buy apple seed */
		final JButton buyApple = new JButton("Buy apple seed");
		buyApple.setBounds(120, 0, 120, 30);
=======

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
		buyApple.setBounds(200, 40, 100, 30);
>>>>>>> b0ab8a954e166f8dada1f0f879754aa59e554278
		buyApple.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
<<<<<<< HEAD

			}
		});
		buyApple.setToolTipText("A button to buy apple seed");
		this.add(buyApple);
		
		/** A button to buy strawberry seed */
		final JButton buyStrawberry = new JButton("Buy strawberry seed");
		buyStrawberry.setBounds(240, 0, 120, 30);
		buyStrawberry.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

			}
		});
		buyStrawberry.setToolTipText("Buy strawberry seed");
		this.add(buyStrawberry);
		
		/** A button to take you back to the main menu */
		final JButton back = new JButton("Back");
		back.setBounds(680, 0, 120, 30);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				gameThread.interrupt();
				ThePlants.changePanel(new MainMenu());			}
		});
		back.setToolTipText("A button to take you back to the main menu");
		this.add(back);

=======
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
		buyStrawberry.setBounds(300, 40, 100, 30);
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
		go.setToolTipText("Click on the grid to plant");
		this.add(buyStrawberry);

		/** A button to buy orange seed */
		buyOrange = new JButton("Orange");
		buyOrange.setBounds(400, 40, 100, 30);
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
		go.setToolTipText("Click on the grid to plant");
		this.add(buyOrange);

		/** A button to buy Durian seed */
		buyDurian = new JButton("Durian");
		buyDurian.setBounds(500, 40, 100, 30);
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
		go.setToolTipText("Click on the grid to plant");
		this.add(buyDurian);

		/** A button to refill your water */
		refill = new JButton("Refill water");
		refill.setBounds(650, 370, 120, 30);
		refill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (money >= 10) {
					water = 10;
					money -= 10;
				} else {
					System.out.println("Your money is not enough");
				}
			}
		});
		refill.setToolTipText("A button to refill your water");
		this.add(refill);
>>>>>>> b0ab8a954e166f8dada1f0f879754aa59e554278
	}

	/** Close the game */
	public void gameShutdown() {

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
		// plant.update();
		land.update(timeElapsed);
		vehicle.update(timeElapsed);
		// check if it has any money
		if (vehicle.getMoney() > 0) {
			this.money += vehicle.getMoney();
			vehicle.setMoney(0);
		}
	}

	/** Change current state of player */
	public void changePlayerState(PlayerState newState) {
		// Normalize state
		fertilizerButton.setText("Fertilize");
		waterButton.setText("Water");
		
		// Set current state to the desired ones
		playerState = newState;
		if (newState == PlayerState.WATERING) {
			waterButton.setText("Choose a plant");
		}
		else if (newState == PlayerState.FERTILIZING) {
			fertilizerButton.setText("Choose a plant");
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
		// TODO draw pest
		//pest.draw(g);

		/** Game info */
		g.setFont(new Font("Dialog", Font.PLAIN, 14));
		g.setColor(Color.WHITE);
		g.drawString(TITLE, 200, 300);
<<<<<<< HEAD
		g.drawString(beliApel, 150, 50);
		g.drawString(beliStrawberry, 250, 50);
=======
		g.drawString("Price: "
				+ PlantFactory.getPrototype("Pohon Apel").getPrice(), 220, 90);
		g.drawString("Price: "
				+ PlantFactory.getPrototype("Pohon Strawberry").getPrice(),
				320, 90);
		g.drawString("Price: "
				+ PlantFactory.getPrototype("Pohon Jeruk").getPrice(), 420, 90);
		g.drawString("Price: "
				+ PlantFactory.getPrototype("Pohon Durian").getPrice(), 520, 90);
		g.drawString("Money: " + money, 200, 20);
		g.drawString("Your water: " + water, 200, 35);
>>>>>>> b0ab8a954e166f8dada1f0f879754aa59e554278
		if (state == GameState.GAMEOVER) {
			g.setFont(new Font("Verdana", Font.BOLD, 30));
			g.setColor(Color.RED);
			g.drawString("GAME OVER!", 200, 300);
		}
	}

	/** Show message */
	public void showMessage(String message){
		JOptionPane.showConfirmDialog(null, message, ThePlants.TITLE, JOptionPane.DEFAULT_OPTION);
	}
	
	/** Code for Action Listener (Mouse and Key Listener) */

	@Override
	public void mouseClicked(MouseEvent event) {
		if (state == GameState.PLAYING) {
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
				// Take fruit
				if (vehicle.getStatus() == 0) {
					for (Plant p : allPlant) {
						if (p.contains(event.getPoint())) {
							if (p.isFruitAvailable()) {
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
							// break so that other plants behind it will not be clicked
							break;
						}
					}
				}
				else {
					showMessage("Tunggu sampai kendaraan tiba kembali");
				}
				
				break;
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
	public void keyPressed(KeyEvent event) {
		// TODO insert something here or remove this method

	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO insert something here or remove this method

	}

	@Override
	public void keyTyped(KeyEvent event) {
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