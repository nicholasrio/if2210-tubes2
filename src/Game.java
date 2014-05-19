/*
 * @author Zaky		
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.*;

import javax.swing.*;

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
	private int money;
	private Player player;
	private Vehicle vehicle;

	/** Game Components */
	private Image background;

	private static final int FRAMERATE = 10;
	/** Change UPDATES_PER_SEC to FRAMERATE */
	static final int UPDATES_PER_SEC = 10; /** Number of game update per second */ 
	static final long UPDATE_PERIOD_NSEC = 1000000000L / UPDATES_PER_SEC; /** Nanosecond */
	private Color COLOR_PIT = Color.LIGHT_GRAY;

	private Thread gameThread = null;

	/** Enumeration for the states of the game*/
	static enum GameState {
		INITIALIZED, PLAYING, PAUSED, GAMEOVER, DESTROYED
	}

	boolean isWatering = false;

	/** Current states of the game*/
	private static GameState state;

	/** Constructor to initialize the UI components and game objects */
	public Game() {
		id = ++ID;

		// 		/** Initialize game comonents*/
		gameInit();

		this.setLayout(null);
		this.setPreferredSize(new Dimension(ThePlants.PANEL_WIDTH,
				ThePlants.PANEL_HEIGHT));

		/** Add action listener */
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		/** Start the game*/
		gameStart();
	}

	/** Getter-Setter */

	/** Return the grid (space/tiles for playing)*/
	public GridPlant getLand() {
		return land;
	}

	/** Set the grid*/
	public void setLand(GridPlant land) {
		this.land = land;
	}

	/** Return the water capacity that you could carry*/
	public int getWaterCapacity() {
		return waterCapacity;
	}

	/** Set the water capacity*/
	public void setWaterCapacity(int waterCapacity) {
		this.waterCapacity = waterCapacity;
	}

	/** Return the money*/
	public int getMoney() {
		return money;
	}

	/** Set the money */
	public void setMoney(int money) {
		this.money = money;
	}

	/** Return the player*/
	public Player getPlayer() {
		return player;
	}

	/** Set the player*/
	public void setPlayer(Player player) {
		this.player = player;
	}

	/** All game-related codes*/

	/** Initialize all game objects */
	public void gameInit() {
		state = GameState.INITIALIZED;

		land = new GridPlant();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				land.createPlant(i, j);
			}
		}

		vehicle = new Vehicle();

		/** Set background */
		background = (new ImageIcon("images/background_game.png")).getImage();

		/** Add components */
		/** Reset button to reset the game back to the start */
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(650, 250, 120, 30);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ThePlants.changePanel(new Game());
				// Stop Current Thread
				gameThread.interrupt();
			}
		});
		resetButton.setToolTipText("Me-reset game");
		this.add(resetButton);

		/** Upgrade button for your vehicle */
		JButton upgrade = new JButton("Upgrade");
		upgrade.setBounds(650, 280, 120, 30);
		upgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (vehicle.getStatus() == 0) {
					vehicle.Upgrade();
				} else {
					System.out
					.println("Tunggu hingga kendarran mencapai perkebunan");
				}
			}
		});
		upgrade.setToolTipText("Meng-upgrade vehicle");
		this.add(upgrade);

		/** Downgrade button for your vehicle */
		JButton downgrade = new JButton("Downgrade");
		downgrade.setBounds(650, 310, 120, 30);
		downgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (vehicle.getStatus() == 0) {
					vehicle.Downgrade();
				} else {
					System.out
					.println("Tunggu hingga kendarran mencapai perkebunan");
				}
			}
		});
		downgrade.setToolTipText("Men-downgrade vehicle");
		this.add(downgrade);

		/** Make your vehicle go to the market and sell all the storages */
		JButton go = new JButton("Go");
		go.setBounds(650, 340, 120, 30);
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (vehicle.getStatus() == 0) {
					vehicle.setStatus(1);
				} else {
					System.out
					.println("Tunggu hingga kendarran mencapai perkebunan");
				}
			}
		});
		go.setToolTipText("Menjalankan vehicle ke pasar");
		this.add(go);

		/** A button that lets you water your plants*/
		final JButton waterButton = new JButton("Siram");
		waterButton.setBounds(650, 220, 120, 30);
		waterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				if (!isWatering) {
					waterButton.setText("Klik tanaman");
					isWatering = true;
				} else {
					waterButton.setText("Siram");
					isWatering = false;
				}
			}
		});
		go.setToolTipText("Menyiram tanaman");
		this.add(waterButton);
		
		/** A button to buy apple seed */
		final JButton buyApple = new JButton("Buy apple seed");
		buyApple.setBounds(120, 0, 120, 30);
		buyApple.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

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

	}

	/** Close the game */
	public void gameShutdown() {

	}

	/** To start and restart your game*/
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

	/** The game's main loop*/
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
				gameUpdate(UPDATE_PERIOD_NSEC * 1e-9);
			}
			/** Refresh the display */
			repaint();
			/** Delay timer to provide the necessary delay to meet the target rate in milliseconds*/
			timeTaken = System.nanoTime() - beginTime;
			timeLeft = (UPDATE_PERIOD_NSEC - timeTaken) / 1000000;

			if (timeLeft < 10)
				timeLeft = 10; /** Set a minimum */
			try {
				/** Provide the necessary delay and also yields control so that other threads can do the work */
				Thread.sleep(timeLeft);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt(); /** Preserves the message */
				return; /** Stop all active things and terminate */
			}
		}
	}

	/** Update the state and position of all the game objects */
	public void gameUpdate(double timeElapsed) {
		// plant.update();
		land.update(timeElapsed);
		vehicle.update(timeElapsed);
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

		/** Game info */
		g.setFont(new Font("Dialog", Font.PLAIN, 14));
		g.setColor(Color.WHITE);
		g.drawString(TITLE, 200, 300);
		g.drawString(beliApel, 150, 50);
		g.drawString(beliStrawberry, 250, 50);
		if (state == GameState.GAMEOVER) {
			g.setFont(new Font("Verdana", Font.BOLD, 30));
			g.setColor(Color.RED);
			g.drawString("GAME OVER!", 200, 300);
		}
	}

	// / Code for Action Listener (Mouse and Key Listener)

	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		if (state == GameState.PLAYING) {
			ArrayList<Plant> allPlant = land.getAllPlants();

			// Watering plants
			if (isWatering) {
				for (Plant p : allPlant) {
					if (p.contains(event.getPoint())) {
						p.water(20);
					}
				}
			}

			// Other ...
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {

	}

	@Override
	public void mouseExited(MouseEvent event) {

	}

	@Override
	public void mousePressed(MouseEvent event) {

	}

	@Override
	public void mouseReleased(MouseEvent event) {

	}

	@Override
	public void keyPressed(KeyEvent event) {

	}

	@Override
	public void keyReleased(KeyEvent event) {

	}

	@Override
	public void keyTyped(KeyEvent event) {

	}

	@Override
	public void mouseDragged(MouseEvent event) {
		TITLE = "Dragged";
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		TITLE = "Position: " + event.getX() + ", " + event.getY();
	}
}