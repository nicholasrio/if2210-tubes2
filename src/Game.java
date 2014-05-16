import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Game extends JPanel implements KeyListener, MouseListener, MouseMotionListener {

	// Constants
	static String TITLE = "The Plan(T)s";

	// for debugging
	private static int COUNT_ID = 0;
	int ID;

	// Game Attributes
	private GridPlant land;
	private int waterCapacity;
	private int money;
	private Player player;
	
	// Game Components
	

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
		ID = ++COUNT_ID;

		// Initialize the game objects
		this.setLayout(null);
		gameInit();

		// UI components
		this.setPreferredSize(new Dimension(ThePlants.PANEL_WIDTH,
				ThePlants.PANEL_HEIGHT));
		// add(pit);

		// Add Action Listener
		this.addKeyListener(this);
		this.addMouseListener(this);
		
		

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

	// Initialize all the game objects, run only once in the constructor of the
	// main class.
	public void gameInit() {
		// Allocate a new snake and a food item, do not regenerate.
		land = new GridPlant();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				land.createPlant(i, j);
			}
		}
		state = GameState.INITIALIZED;
		
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
		this.add(resetButton);
		// Water Button
		final JButton waterButton = new JButton("Siram");
		waterButton.setBounds(650, 300, 120, 30);
		waterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				if (!isWatering) {
					waterButton.setText("Klik tanaman");
					isWatering = true;
				}
				else {
					waterButton.setText("Siram");
					isWatering = false;
				}
			}
		});
		this.add(waterButton);
	}

	// Shutdown the game, clean up code that runs only once.
	public void gameShutdown() {

	}

	// To start and re-start the game.
	public void gameStart() {
		// Create a new thread
		gameThread = new Thread() {
			// Override run() to provide the running behavior of this thread.
			@Override
			public void run() {
				gameLoop();
			}
		};
		// Start the thread. start() calls run(), which in turn calls
		// gameLoop().
		gameThread.start();
	}

	// Run the game loop here.
	private void gameLoop() {
		// Regenerate and reset the game objects for a new game
		if (state == GameState.INITIALIZED || state == GameState.GAMEOVER) {

			state = GameState.PLAYING;
		}

		// Game loop
		long beginTime, timeTaken, timeLeft; // in msec
		while (state != GameState.GAMEOVER) {
			//System.out.println("Ini Game dengan ID = " + ID);

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

	// Update the state and position of all the game objects,
	// detect collisions and provide responses.
	public void gameUpdate(double timeElapsed) {
		// plant.update();
		land.update(timeElapsed);
	}

	// Collision detection and response

	// Refresh the display. Called back via repaint(), which invoke the
	// paintComponent().
	private void gameDraw(Graphics g) {
		// draw game objects
		// plant.draw(g,100,100);
		land.draw(g);
		// game info
		g.setFont(new Font("Dialog", Font.PLAIN, 14));
		g.setColor(Color.BLACK);
		g.drawString(TITLE, 200, 300);
		if (state == GameState.GAMEOVER) {
			g.setFont(new Font("Verdana", Font.BOLD, 30));
			g.setColor(Color.RED);
			g.drawString("GAME OVER!", 200, 300);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // paint background
		setBackground(COLOR_PIT); // may use an image for background

		// Draw the game objects
		gameDraw(g);
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
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}