/*
 * @author Zaky		
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ThePlants {

	/** Application title */
	public static final String TITLE = "The Plan(t)s";

	/** Put the constants for the application size */
	public static final int PANEL_HEIGHT = 600;
	public static final int PANEL_WIDTH = 800;

	/** Active panel */
	private static JPanel activePanel;

	/** Main frame */
	private static final JFrame mainFrame = new JFrame(TITLE);

	/** Change active panel */
	public static void changePanel(JPanel panel) {
		ThePlants.activePanel = panel;

		/** Change the panel's content */
		ThePlants.mainFrame.getContentPane().removeAll();
		ThePlants.mainFrame.getContentPane().add(activePanel);

		/** Pack and center it */
		ThePlants.mainFrame.pack();
		ThePlants.mainFrame.setLocationRelativeTo(null);

		/** Show the frame */
		ThePlants.mainFrame.setVisible(true);

		/** Gives focus to panel */
		activePanel.setFocusable(true);
		activePanel.requestFocusInWindow();
	}

	public static void main(String args[]) {

		/** Load data */
		PlantFactory.loadData();

		/** Initial configuration for mainframe */
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);

		/** Create new thread */
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO replace with new MainMenu()
				ThePlants.changePanel(new Game());
			}
		});
	}
}
