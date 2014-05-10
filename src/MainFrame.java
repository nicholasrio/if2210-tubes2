import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;


public class MainFrame extends JFrame {
	
	private LoginPanel loginPanel;
	
	public MainFrame(String Title){
		super(Title);
		
		// Set frame configuration
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set layout manager
		setLayout(new BorderLayout());
		
		// Create swing component
		loginPanel = new LoginPanel();
		
		// Add swing component to content pane
		Container c = getContentPane();
		c.add(loginPanel, BorderLayout.CENTER);
		
	}
}
