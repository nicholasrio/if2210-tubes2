import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelMenu extends JPanel {
	/**
	 * Auto-generated serial version ID
	 */
	private static final long serialVersionUID = 7823230732972515452L;
	/** Game Components */
	private Image background;
	private Thread gameThreadMM = null;
	
	/** CTOR */
	public LevelMenu() {
		// 		/** Initialize game components*/
		gameInit();

		this.setLayout(null);
		this.setPreferredSize(new Dimension(ThePlants.PANEL_WIDTH,ThePlants.PANEL_HEIGHT));

		/** Start the game*/
		gameStart();
	}
	
	public void gameInit() {
		/** Set background */
		background = (new ImageIcon("images/background_start.png")).getImage();
		int startx = 50;
		int posy = 220;
		/** Add components */
		/** Play button to start the game */
		JButton level1 = new JButton("Level 1");
		level1.setBounds(startx, posy, 120, 120);
		level1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ThePlants.changePanel(new Game(new Level(1)));
				gameThreadMM.interrupt();
			}
		});
		level1.setToolTipText("Start the game");
		this.add(level1);
		
		JButton level2 = new JButton("Level 2");
		level2.setBounds(startx + (1*140), posy, 120, 120);
		level2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ThePlants.changePanel(new Game(new Level(2)));
				gameThreadMM.interrupt();
			}
		});
		level2.setToolTipText("Start the game");
		this.add(level2);
		
		JButton level3 = new JButton("Level 3");
		level3.setBounds(startx + (2*140), posy, 120, 120);
		level3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ThePlants.changePanel(new Game(new Level(3)));
				gameThreadMM.interrupt();
			}
		});
		level3.setToolTipText("Start the game");
		this.add(level3);
		
		JButton level4 = new JButton("Level 4");
		level4.setBounds(startx + (3*140), posy, 120, 120);
		level4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ThePlants.changePanel(new Game(new Level(4)));
				gameThreadMM.interrupt();
			}
		});
		level4.setToolTipText("Start the game");
		this.add(level4);
		
		JButton level5 = new JButton("Level 5");
		level5.setBounds(startx + (4*140), posy, 120, 120);
		level5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ThePlants.changePanel(new Game(new Level(5)));
				gameThreadMM.interrupt();
			}
		});
		level5.setToolTipText("Start the game");
		this.add(level5);
		/** Quit button to quit the game */
		JButton quit= new JButton("Back");
		quit.setBounds(330, 400, 120, 30);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ThePlants.changePanel(new MainMenu());				
			}
		});
		quit.setToolTipText("Start the game");
		this.add(quit);
	}
	
	/** To start and restart your game*/
	public void gameStart() {
		gameThreadMM = new Thread();
		// Start the main game thread
		gameThreadMM.start();
	}
	
	public void paintComponent(Graphics g) {
		/** Draw background */
		super.paintComponent(g);
		g.drawImage(background, 0, 0, ThePlants.PANEL_WIDTH, ThePlants.PANEL_HEIGHT, null);
		g.setColor(new Color(255, 255, 255, 127));
		g.fillRect(0, 0, ThePlants.PANEL_WIDTH, ThePlants.PANEL_HEIGHT);
	}

}