import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/** This class displays the main menu of the game */
public class MainMenu extends JPanel implements KeyListener, MouseListener, MouseMotionListener{
	/** Game Components */
	private Image background;
	private Thread gameThreadMM = null;
	
	/** CTOR */
	public MainMenu() {
		// 		/** Initialize game comonents*/
		gameInit();

		this.setLayout(null);
		this.setPreferredSize(new Dimension(ThePlants.PANEL_WIDTH,ThePlants.PANEL_HEIGHT));

		/** Add action listener */
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		/** Start the game*/
		gameStart();
	}
	
	public void gameInit() {
		/** Set background */
		background = (new ImageIcon("images/background_start.png")).getImage();
		
		/** Add components */
		/** Play button to start the game */
		JButton play = new JButton("Play");
		play.setBounds(375, 375, 120, 30);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ThePlants.changePanel(new LevelMenu());
				gameThreadMM.interrupt();
			}
		});
		play.setToolTipText("Start the game");
		this.add(play);
		
		/** Quit button to quit the game */
		JButton quit= new JButton("Quit");
		quit.setBounds(515, 375, 120, 30);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);				
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
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}