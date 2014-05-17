import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.*;

import javax.swing.*;

public class Game extends JPanel implements KeyListener, MouseListener,
		MouseMotionListener {

	// Constants
	static String TITLE = "The Plan(T)s";

	// for debugging
	private static int ID = 0;
	int id;

	// Game Attributes
	private GridPlant land;
	private int waterCapacity;
	private int money;
	private Player player;
	private Vehicle vehicle;

	// Game Components
	private Image background;

	private static final int FRAMERATE = 10;
	// TODO change UPDATES_PER_SEC to FRAMERATE
	static final int UPDATES_PER_SEC = 10; // number of game update per second
	static final long UPDATE_PERIOD_NSEC = 1000000000L / UPDATES_PER_SEC; // nanoseconds
	private Color COLOR_PIT = Color.LIGHT_GRAY;

	private Thread gameThread = null;

	// Enumeration for the states of the game.
	static enum GameState {
		INITIALIZED, PLAYING, PAUSED, GAMEOVER, DESTROYED
	}

	boolean isWatering = false;

	// current state of the game
	private static GameState state;

	// Constructor to initialize the UI components and game objects
	public Game() {
		id = ++ID;

		// Initialize the game objects
		gameInit();

		this.setLayout(null);
		this.setPreferredSize(new Dimension(ThePlants.PANEL_WIDTH,
				ThePlants.PANEL_HEIGHT));

		// Add Action Listener
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		// Start the game.
		gameStart();
	}

	// Getter-Setter

	public GridPlant getLand() {
		return land;
	}

	public void setLand(GridPlant land) {
		this.land = land;
	}

	public int getWaterCapacity() {
		return waterCapacity;
	}

	public void setWaterCapacity(int waterCapacity) {
		this.waterCapacity = waterCapacity;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	// ------ All the game related codes here ------

	// Initialize all the game objects
	public void gameInit() {
		state = GameState.INITIALIZED;

		land = new GridPlant();
		// TODO remove this part
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				land.createPlant(i, j);
			}
		}

		vehicle = new Vehicle();

		// Set background
		background = (new ImageIcon("images/background_game.png")).getImage();

		// Add components
		// Reset Button
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(650, 250, 120, 30);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ThePlants.changePanel(new Game());
				// Stop Current Thread
				gameThread.interrupt();
			}
		});
		resetButton.setToolTipText("Me-reset meteran air");
		this.add(resetButton);

		// Upgrade Button
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

		// Downgrade Button
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

		// Go Button
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

		// Water Button
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
	}

	// Shutdown the game, clean up code that runs only once.
	public void gameShutdown() {

	}

	// To start and re-start the game.
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

	// The main loop of game
	private void gameLoop() {
		// Regenerate and reset the game objects for a new game
		if (state == GameState.INITIALIZED || state == GameState.GAMEOVER) {

			state = GameState.PLAYING;
		}

		// Game loop
		long beginTime, timeTaken, timeLeft; // in msec
		while (state != GameState.GAMEOVER) {
			// System.out.println("Ini Game dengan ID = " + ID);

			beginTime = System.nanoTime();
			if (state == GameState.PLAYING) {
				// Update the state and position of all the game objects,
				// detect collisions and provide responses.
				gameUpdate(UPDATE_PERIOD_NSEC * 1e-9);
			}
			// Refresh the display
			repaint();
			// Delay timer to provide the necessary delay to meet the target
			// rate
			timeTaken = System.nanoTime() - beginTime;
			timeLeft = (UPDATE_PERIOD_NSEC - timeTaken) / 1000000; // in
																	// milliseconds
			if (timeLeft < 10)
				timeLeft = 10; // set a minimum
			try {
				// Provides the necessary delay and also yields control so that
				// other thread can do work.
				Thread.sleep(timeLeft);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();// preserve the message
				return;// Stop doing whatever I am doing and terminate
			}
		}
	}

	// Update the state and position of all the game objects
	public void gameUpdate(double timeElapsed) {
		// plant.update();
		land.update(timeElapsed);
		vehicle.update(timeElapsed);
	}

	// Draw components
	@Override
	public void paintComponent(Graphics g) {
		// Draw background
		super.paintComponent(g);
		g.drawImage(background, 0, 0, ThePlants.PANEL_WIDTH,
				ThePlants.PANEL_HEIGHT, null);

		// Draw GridPlant
		land.draw(g);

		// Draw vehicle
		vehicle.draw(g);

		// TODO remove this part
		// game info
		g.setFont(new Font("Dialog", Font.PLAIN, 14));
		g.setColor(Color.WHITE);
		g.drawString(TITLE, 200, 300);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub
		TITLE = "Dragged";
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub
		TITLE = "Position: " + event.getX() + ", " + event.getY();
	}
}