import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Window.Type;


public class ClientGUI {

	private JFrame frame;
	private JTextField Path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel UploadPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, UploadPanel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, UploadPanel, 0, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(UploadPanel);
		
		Path = new JTextField();
		UploadPanel.add(Path);
		Path.setColumns(20);
		
		JButton BrowseBtn = new JButton("Browse");
		UploadPanel.add(BrowseBtn);
		
		JButton UploadBtn = new JButton("Upload");
		UploadPanel.add(UploadBtn);
		
		JButton LogoutBtn = new JButton("Logout");
		UploadPanel.add(LogoutBtn);
		
		JTabbedPane BooksTab = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.EAST, UploadPanel, 0, SpringLayout.EAST, BooksTab);
		springLayout.putConstraint(SpringLayout.NORTH, BooksTab, 33, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, BooksTab, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, BooksTab, 431, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, BooksTab, 614, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(BooksTab);
		
		JScrollPane BookPane = new JScrollPane();
		BooksTab.addTab("Books", null, BookPane, null);
		
		JPanel LOBPanel = new JPanel();
		BookPane.setViewportView(LOBPanel);
		LOBPanel.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][][]"));
		
		JLabel LabelLOB = new JLabel("List Of Books :");
		LOBPanel.add(LabelLOB, "cell 1 0");
		
		JLabel labellob1 = new JLabel("1.");
		LOBPanel.add(labellob1, "cell 0 1");
		
		JButton btnRemoveBook1 = new JButton("Remove Book");
		LOBPanel.add(btnRemoveBook1, "cell 2 1");
		
		JLabel labellob2 = new JLabel("2.");
		LOBPanel.add(labellob2, "cell 0 2");
		
		JButton btnRemoveBook2 = new JButton("Remove Book");
		LOBPanel.add(btnRemoveBook2, "cell 2 2");
		
		JLabel labellob3 = new JLabel("3.");
		LOBPanel.add(labellob3, "cell 0 3");
		
		JButton btnRemoveBook3 = new JButton("Remove Book");
		LOBPanel.add(btnRemoveBook3, "cell 2 3");
		
		JLabel labellob4 = new JLabel("4.");
		LOBPanel.add(labellob4, "cell 0 4");
		
		JButton btnRemoveBook4 = new JButton("Remove Book");
		LOBPanel.add(btnRemoveBook4, "cell 2 4");
		
		JLabel labellob5 = new JLabel("5.");
		LOBPanel.add(labellob5, "cell 0 5");
		
		JButton btnRemoveBook5 = new JButton("Remove Book");
		LOBPanel.add(btnRemoveBook5, "cell 2 5");
		
		JLabel labellob6 = new JLabel("6.");
		LOBPanel.add(labellob6, "cell 0 6");
		
		JButton btnRemoveBook6 = new JButton("Remove Book");
		LOBPanel.add(btnRemoveBook6, "cell 2 6");
		
		JLabel labellob7 = new JLabel("7.");
		LOBPanel.add(labellob7, "cell 0 7");
		
		JButton btnRemoveBook7 = new JButton("Remove Book");
		LOBPanel.add(btnRemoveBook7, "cell 2 7");
		
		JLabel labellob8 = new JLabel("8.");
		LOBPanel.add(labellob8, "cell 0 8");
		
		JButton btnRemoveBook8 = new JButton("Remove Book");
		LOBPanel.add(btnRemoveBook8, "cell 2 8");
		
		JLabel labellob9 = new JLabel("9.");
		LOBPanel.add(labellob9, "cell 0 9");
		
		JButton btnRemoveBook9 = new JButton("Remove Book");
		LOBPanel.add(btnRemoveBook9, "cell 2 9");
		
		JLabel labellob10 = new JLabel("10.");
		LOBPanel.add(labellob10, "cell 0 10");
		
		JButton btnRemoveBook10 = new JButton("Remove Book");
		LOBPanel.add(btnRemoveBook10, "cell 2 10");
		
		JScrollPane ExplorePane = new JScrollPane();
		BooksTab.addTab("Explore", null, ExplorePane, null);
		
		JPanel EXPPanel = new JPanel();
		ExplorePane.setViewportView(EXPPanel);
		EXPPanel.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][][]"));
		
		JLabel LabelExp = new JLabel("Explore Books :");
		EXPPanel.add(LabelExp, "cell 1 0");
		
		JLabel labelexp1 = new JLabel("1.");
		EXPPanel.add(labelexp1, "cell 0 1");
		
		JButton btnAddBook1 = new JButton("Add Book");
		EXPPanel.add(btnAddBook1, "cell 2 1");
		
		JLabel labelexp2 = new JLabel("2.");
		EXPPanel.add(labelexp2, "cell 0 2");
		
		JButton btnAddBook2 = new JButton("Add Book");
		EXPPanel.add(btnAddBook2, "cell 2 2");
		
		JLabel labelexp3 = new JLabel("3.");
		EXPPanel.add(labelexp3, "cell 0 3");
		
		JButton btnAddBook3 = new JButton("Add Book");
		EXPPanel.add(btnAddBook3, "cell 2 3");
		
		JLabel labelexp4 = new JLabel("4.");
		EXPPanel.add(labelexp4, "cell 0 4");
		
		JButton btnAddBook4 = new JButton("Add Book");
		EXPPanel.add(btnAddBook4, "cell 2 4");
		
		JLabel labelexp5 = new JLabel("5.");
		EXPPanel.add(labelexp5, "cell 0 5");
		
		JButton btnAddBook5 = new JButton("Add Book");
		EXPPanel.add(btnAddBook5, "cell 2 5");
		
		JLabel labelexp6 = new JLabel("6.");
		EXPPanel.add(labelexp6, "cell 0 6");
		
		JButton btnAddBook6 = new JButton("Add Book");
		EXPPanel.add(btnAddBook6, "cell 2 6");
		
		JLabel labelexp7 = new JLabel("7.");
		EXPPanel.add(labelexp7, "cell 0 7");
		
		JButton btnAddBook7 = new JButton("Add Book");
		EXPPanel.add(btnAddBook7, "cell 2 7");
		
		JLabel labelexp8 = new JLabel("8.");
		EXPPanel.add(labelexp8, "cell 0 8");
		
		JButton btnAddBook8 = new JButton("Add Book");
		EXPPanel.add(btnAddBook8, "cell 2 8");
		
		JLabel labelexp9 = new JLabel("9.");
		EXPPanel.add(labelexp9, "cell 0 9");
		
		JButton btnAddBook9 = new JButton("Add Book");
		EXPPanel.add(btnAddBook9, "cell 2 9");
		
		JLabel labelexp10 = new JLabel("10.");
		EXPPanel.add(labelexp10, "cell 0 10");
		
		JButton btnAddBook10 = new JButton("Add Book");
		EXPPanel.add(btnAddBook10, "cell 2 10");
	}
}
