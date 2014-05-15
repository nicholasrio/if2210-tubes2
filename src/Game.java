import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Game extends JPanel implements KeyListener, MouseListener {

	// Constants
	static String TITLE = "The Plan(T)s";
	
	private static int COUNT_ID = 0;
	int ID;
	
	static final int UPDATES_PER_SEC = 3; // number of game update per second
	static final long UPDATE_PERIOD_NSEC = 100000000L / UPDATES_PER_SEC; // nanoseconds
	private Color COLOR_PIT = Color.LIGHT_GRAY;
	
	private static final int CANVAS_WIDTH = ThePlants.PANEL_WIDTH;
	private static final int CANVAS_HEIGHT = ThePlants.PANEL_HEIGHT;
	
	private Thread gameThread = null;

	// Enumeration for the states of the game.
	static enum GameState {
		INITIALIZED, PLAYING, PAUSED, GAMEOVER, DESTROYED
	}
	
	// current state of the game
	private static GameState state;

	// Define instance variables for the game objects
	private Plant plant;
	private GridPlant gridPlant;

	// Constructor to initialize the UI components and game objects
	public Game() {
		ID = ++COUNT_ID;
		
		// Initialize the game objects
		gameInit();

		// UI components
		this.setPreferredSize(new Dimension(ThePlants.PANEL_WIDTH, ThePlants.PANEL_HEIGHT));
		//add(pit);
		
		// Add Action Listener
		this.addKeyListener(this);
		this.addMouseListener(this);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(0, 360, 100, 30);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ThePlants.changePanel(new Game());
				// Stop Current Thread
				gameThread.interrupt();
			}
		});
		this.add(resetButton);
		
		// Start the game.
		gameStart();
	}

	// ------ All the game related codes here ------

	// Initialize all the game objects, run only once in the constructor of the
	// main class.
	public void gameInit() {
		// Allocate a new snake and a food item, do not regenerate.
		plant = new Plant();
		gridPlant = new GridPlant();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				gridPlant.createPlant(i, j);
			}
		}
		state = GameState.INITIALIZED;
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
			System.out.println("Ini Game dengan ID = " + ID);
			
			beginTime = System.nanoTime();
			if (state == GameState.PLAYING) {
				// Update the state and position of all the game objects,
				// detect collisions and provide responses.
				gameUpdate();
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
			    Thread.currentThread().interrupt();//preserve the message
			    return;//Stop doing whatever I am doing and terminate
			}
		}
	}

	// Update the state and position of all the game objects,
	// detect collisions and provide responses.
	public void gameUpdate() {
		// plant.update();
		gridPlant.update(0.);
	}

	// Collision detection and response

	// Refresh the display. Called back via repaint(), which invoke the
	// paintComponent().
	private void gameDraw(Graphics g) {
		// draw game objects
		// plant.draw(g,100,100);
		gridPlant.draw(g);
		// game info
		g.setFont(new Font("Dialog", Font.PLAIN, 14));
		g.setColor(Color.BLACK);
		g.drawString(TITLE, 200, CANVAS_HEIGHT / 2);
		if (state == GameState.GAMEOVER) {
			g.setFont(new Font("Verdana", Font.BOLD, 30));
			g.setColor(Color.RED);
			g.drawString("GAME OVER!", 200, CANVAS_HEIGHT / 2);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // paint background
		setBackground(COLOR_PIT); // may use an image for background

		// Draw the game objects
		gameDraw(g);
	}
	
	/// Code for Action Listener (Mouse and Key Listener)

	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub
		TITLE = "Masuk!";
	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		
		switch (event.getButton()) {
		case MouseEvent.BUTTON1:
			TITLE = "Button 1 ceritanya";
			break;
		case MouseEvent.BUTTON2:
			TITLE = "Button 2 ceritanya";
			break;
		case MouseEvent.BUTTON3:
			TITLE = "Button 3 ceritanya";
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub

		switch (event.getKeyCode()) {
		case KeyEvent.VK_UP:
			plant.watering();
			TITLE = "UP";
			break;
		case KeyEvent.VK_DOWN:
			TITLE = "DOWN";
			break;
		case KeyEvent.VK_LEFT:
			TITLE = "LEFT";
			break;
		case KeyEvent.VK_RIGHT:
			TITLE = "RIGHT";
			break;
		}		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}
}