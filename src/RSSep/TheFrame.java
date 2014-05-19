package RSSep;
import RSS.slidinglayout.SLAnimator;
import RSS.slidinglayout.SLConfig;
import RSS.slidinglayout.SLKeyframe;
import RSS.slidinglayout.SLPanel;
import RSS.slidinglayout.SLSide;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * 
 * @author Capokantil
 *
 */

public class TheFrame extends JFrame implements ActionListener, HyperlinkListener {
	
	/**
	 * Attributs of the frame contains panels
	 */
	final SLPanel panel = new SLPanel();
	private final ThePanel p1 = new ThePanel("1");
	private final ThePanel p2 = new ThePanel("2");
	private final ThePanel p3 = new ThePanel("3");
	private final ThePanel p4 = new ThePanel("About");
	private final ThePanel p5 = new ThePanel("Content");
	private final SLConfig mainCfg, p1Cfg, p2Cfg, p3Cfg, p4Cfg, p5Cfg;
	
	/**
	 * Attributs of the frame contains panel components
	 */
	public JTextPane TextPane_world, TextPane_tech, TextPane_business, TextPane_sports, TextPane_entertaint, TextPane_hasilSearch, TextPane_topTen;
	public JScrollPane scrollPane_world, scrollPane_tech, scrollPane_business, scrollPane_sports, scrollPane_entertaint, scrollPane_hasilSearch, scrollPane_topTen;
	public JButton image31, image32, image33, image34, image35, buttonGo;
	public String tempWorld, tempTech, tempBus, tempSports, tempEntertaint;
	public JLabel labelworld, labelTech, labelBusiness, labelSports, labelEnt, labelSearch, gbrP5;
	public JTextField searchText;
	
	/**
	 * Frame Constructor
	 */
	public TheFrame() {
		
		/*
		 * Set main panel
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RSSep.");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);

		/*
		 * Set action to the panels
		 */
		p1.setAction(p1Action);
		p2.setAction(p2Action);
		p3.setAction(p3Action);
		p4.setAction(p4Action);
		p5.setAction(p5Action);
		
		/*
		 * Set color
		 */
		Color blue = new Color(0x3799fe);
		p1.setBackground(blue);

		Color lightblue = new Color(0x87c2ff);
		p2.setBackground(lightblue);
		
		Color pink = new Color(0xf76576);
		p3.setBackground(pink);
		
		Color lightpink = new Color(0xff9999);
		p4.setBackground(lightpink);
		
		Color orange = new Color(0xfdab4a);
		p5.setBackground(orange);
		
		/*
		 * Main panel configuration
		 * Set the grid of each panels
		 */
		mainCfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(250).col(1f).col(2f)
			.beginGrid(0, 0)
				.row(2f).row(1f).col(1f)
				.place(0, 0, p1)
				.place(1, 0, p2)
			.endGrid()
			.beginGrid(0, 1)
				.row(1f).row(2f).col(1f)
				.place(0, 0, p3)
				.place(1, 0, p4)
			.endGrid()
			.place(0, 2, p5);

		/*
		 * First panel configuration
		 */
		p1Cfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(920).col(1f).col(2f)
			.place(0, 0, p1)
			.beginGrid(0, 1)
				.row(1f).row(2f).col(1f)
				.place(0, 0, p3)
				.place(1, 0, p4)
			.endGrid()
			.place(0, 2, p5);

		/*
		 * Second panel configuration
		 */
		p2Cfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(5f).col(1f)
			.beginGrid(0, 0)
				.row(2f).row(1f).col(1f)
				.beginGrid(0, 0)
					.row(1f).col(250).col(1f)
					.place(0, 0, p1)
					.place(0, 1, p3)
				.endGrid()
				.place(1, 0, p2)
			.endGrid()
			.place(0, 1, p5);

		/*
		 * Third panel configuration
		 */
		p3Cfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(2f).col(1f)
			.place(0, 0, p3)
			.place(0, 1, p5);

		/*
		 * Fourth panel configuration
		 */
		p4Cfg = new SLConfig(panel)
			.gap(10, 10)
			.row(2f).row(640).col(1f).col(2f)
			.place(0, 0, p1)
			.place(1, 0, p2)
			.place(0, 1, p3)
			.place(1, 1, p4);

		/*
		 * Fifth panel configuration
		 */
		p5Cfg = new SLConfig(panel)
			.gap(10, 10)
			.row(1f).col(1f)
			.place(0, 0, p5);

		/*
		 * Initialize main panel, including initialize the five panels with slider animations
		 */
		panel.setTweenManager(SLAnimator.createTweenManager());
		panel.initialize(mainCfg);
		FillPanel1();
		FillPanel2();
		FillPanel3();
		FillPanel4();
		FillPanel5();
	}

	/**
	 * Make actions to five panels disabled
	 */
	private void disableActions() {
		p1.disableAction();
		p2.disableAction();
		p3.disableAction();
		p4.disableAction();
		p5.disableAction();
	}

	/**
	 * Make actions to five panels enabled
	 */
	private void enableActions() {
		p1.enableAction();
		p2.enableAction();
		p3.enableAction();
		p4.enableAction();
		p5.enableAction();
	}

	/**
	 * Run panel 1 in action
	 * While panel 1 is running, panel 2 is not shown by sliding it to the bottom
	 */
	private final Runnable p1Action = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(p1Cfg, 0.6f)
				.setEndSide(SLSide.BOTTOM, p2)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					p1.setAction(p1BackAction);
					p1.enableAction();
				}}))
			.play();
	}};

	/**
	 * Run panel 1 back action
	 * When panel 1 is clicked for the second time
	 * While panel 1 is back action, panel 2 is shown by sliding up
	 */
	private final Runnable p1BackAction = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(mainCfg, 0.6f)
				.setStartSide(SLSide.BOTTOM, p2)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					p1.setAction(p1Action);
					enableActions();
				}}))
			.play();
	}};

	/**
	 * Run panel 2 in action
	 * Panel 2 is running in action by clicking it for the first time
	 * While panel 2 is in action, panel 4 is ended
	 */
	private final Runnable p2Action = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(p2Cfg, 0.6f)
				.setEndSide(SLSide.BOTTOM, p4)
				.setDelay(0.6f, p2)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					p2.setAction(p2BackAction);
					p2.enableAction();
				}}))
			.play();
	}};

	/**
	 * Run panel 2 back action
	 * Panel 2 is running back action by clicking it for the second time
	 * While panel 2 is back action, panel 4 is started
	 */
	private final Runnable p2BackAction = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(mainCfg, 0.6f)
				.setStartSide(SLSide.BOTTOM, p4)
				.setDelay(0.6f, p4)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					p2.setAction(p2Action);
					enableActions();
				}}))
			.play();
	}};

	/**
	 * Run panel 3 in action
	 * Panel 3 is running in action by clicking it for the first time
	 * While panel 3 is in action, panel 1, 2, 4 is ended
	 */
	private final Runnable p3Action = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(p3Cfg, 0.8f)
				.setEndSide(SLSide.LEFT, p1, p2)
				.setEndSide(SLSide.BOTTOM, p4)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					p3.setAction(p3BackAction);
					p3.enableAction();
				}}))
			.play();
	}};

	/**
	 * Run panel 3 back action
	 * Panel 3 is running back action by clicking it for the second time
	 * While panel 2 is back action, panel 1, 2, 4 is started
	 */
	private final Runnable p3BackAction = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(mainCfg, 0.8f)
				.setStartSide(SLSide.LEFT, p1, p2)
				.setStartSide(SLSide.BOTTOM, p4)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					p3.setAction(p3Action);
					enableActions();
				}}))
			.play();
	}};

	/**
	 * Run panel 4 in action
	 * Panel 4 is running in action by clicking it for the first time
	 * While panel 4 is in action, panel 5 is ended
	 */
	private final Runnable p4Action = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(p4Cfg, 0.6f)
				.setEndSide(SLSide.RIGHT, p5)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					p4.setAction(p4BackAction);
					p4.enableAction();
				}}))
			.play();
	}};

	/**
	 * Run panel 4 back action
	 * Panel 4 is running back action by clicking it for the second time
	 * While panel 4 is back action, panel 5 is started
	 */
	private final Runnable p4BackAction = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(mainCfg, 0.6f)
				.setStartSide(SLSide.RIGHT, p5)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					p4.setAction(p4Action);
					enableActions();
				}}))
			.play();
	}};

	/**
	 * Run panel 5 in action
	 * Panel 5 is running in action by clicking it for the first time
	 * While panel 5 is in action, panel 1, 2, 3, 4 is ended
	 */
	private final Runnable p5Action = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(p5Cfg, 0.8f)
				.setEndSide(SLSide.LEFT, p1, p2, p3, p4)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					p5.setAction(p5BackAction);
					p5.enableAction();
				}}))
			.play();
	}};

	/**
	 * Run panel 5 back action
	 * Panel 5 is running back action by clicking it for the second time
	 * While panel 5 is back action, panel 1, 2, 3, 4 is started
	 */
	private final Runnable p5BackAction = new Runnable() {@Override public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(mainCfg, 0.8f)
				.setStartSide(SLSide.LEFT, p1, p2, p3, p4)
				.setCallback(new SLKeyframe.Callback() {@Override public void done() {
					p5.setAction(p5Action);
					enableActions();
				}}))
			.play();
	}};

	/**
	 * Panel 1 contents
	 */
	private void FillPanel1() {
		
		/*
		 * Set layout to absolute 
		 */
		p1.setLayout(null);
		
		/*
		 * Image logo
		 */
		JLabel image1 = new JLabel();
		image1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		p1.add(image1);
		image1.setBounds(25, 100, 200, 250);
		image1.setIcon(new ImageIcon("data/rss.jpg"));
		
		/*
		 * Image about us
		 */
		JLabel image11 = new JLabel();
		p1.add(image11);
		image11.setBounds(260, 100, 600, 420);
		image11.setIcon(new ImageIcon("data/about.jpg"));
	}
	
	/**
	 * Panel 2 contents
	 */
	private void FillPanel2() {
		/*
		 * Initialize color
		 */
		Color lightBlue = new Color(0x87c2ff);
		 
		/*
		 * Set layout to absolute
		 */
		p2.setLayout(null);

		JLabel image2 = new JLabel(); //image 2 is a search image
		image2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		p2.add(image2);
		image2.setBounds(20, 7, 200, 200);
		image2.setIcon(new ImageIcon("data/search.png"));
		
		JLabel image22 = new JLabel(); //image 22 is an image of computer and search tool
		image22.setBounds(20, 350, 261, 262);
		image22.setIcon(new ImageIcon("data/search_img.jpg"));
		p2.add(image22);
		
		searchText = new JTextField(); //search box
		searchText.setBounds(330, 100, 300, 30);
		Border whiteline = null;
		whiteline = BorderFactory.createLineBorder(Color.white);
		searchText.setBorder(whiteline);
		searchText.setFont(new Font("Arial", Font.PLAIN, 16));
		p2.add(searchText);
		
		buttonGo = new JButton(); //"go" button
		buttonGo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonGo.setBounds(645, 97, 76, 39);
		buttonGo.setIcon(new ImageIcon("data/go.jpg"));
		Border lightBlueline = null;
		lightBlueline = BorderFactory.createLineBorder(lightBlue);
		buttonGo.setBorder(lightBlueline);
		p2.add(buttonGo);
		buttonGo.addActionListener(this);
	}
	
	/**
	 * Panel 3 contents
	 */
	private void FillPanel3() {
		/*
		 * Initialize color
		 */
		Color Pink = new Color(0xf76576);
		
		/*
		 * Set layout to absolute
		 */
		p3.setLayout(null);
		
		JLabel image3 = new JLabel(); //category image
		image3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		image31 = new JButton(); //international image
		image32 = new JButton(); //technology image
		image33 = new JButton(); //business image
		image34 = new JButton(); //sports image
		image35 = new JButton(); //entertainment image
		
		Border Pinkline = null;
		Pinkline = BorderFactory.createLineBorder(Pink);
		image31.setBorder(Pinkline); //border pink color
		image32.setBorder(Pinkline);
		image33.setBorder(Pinkline);
		image34.setBorder(Pinkline);
		image35.setBorder(Pinkline);
		
		image31.setCursor(new Cursor(Cursor.HAND_CURSOR)); //set cursor to hand cursor
		image32.setCursor(new Cursor(Cursor.HAND_CURSOR));
		image33.setCursor(new Cursor(Cursor.HAND_CURSOR));
		image34.setCursor(new Cursor(Cursor.HAND_CURSOR));
		image35.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		p3.add(image3); //add category image to panel 3
		image3.setBounds(20, 5, 200, 200);
		image3.setIcon(new ImageIcon("data/category.jpg"));
		
		p3.add(image31); //add international image to panel3
		image31.setBounds(350, 20, 180, 180);
		image31.setIcon(new ImageIcon("data/international.jpg"));
		image31.addActionListener(this);
		
		p3.add(image32); //add technology image to panel 3
		image32.setBounds(80, 220, 180, 180);
		image32.setIcon(new ImageIcon("data/tech.jpg"));
		image32.addActionListener(this);
		
		p3.add(image33); //add business image to panel 3
		image33.setBounds(350, 220, 180, 180);
		image33.setIcon(new ImageIcon("data/business.jpg"));
		image33.addActionListener(this);
		
		p3.add(image34); //add sports image to panel 3
		image34.setBounds(75, 420, 180, 180);
		image34.setIcon(new ImageIcon("data/sports.jpg"));
		image34.addActionListener(this);
		
		p3.add(image35); //add entertainment image to panel 3
		image35.setBounds(350, 420, 180, 180);
		image35.setIcon(new ImageIcon("data/entertainment.jpg"));
		image35.addActionListener(this);
	}
	
	/**
	 * Panel 4 contents
	 */
	private void FillPanel4() {
		/*
		 * Initialize color
		 */
		Color lightPink = new Color(0xff9999);
		Color HotPink = new Color(0xb64242);
		
		/*
		 * Set layout to absolute
		 */
		p4.setLayout(null);
		
		JLabel image4 = new JLabel(); //trending topics image
		image4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		p4.add(image4);
		image4.setBounds(20, 90, 200, 202);
		image4.setIcon(new ImageIcon("data/trending.jpg"));
		
		TextPane_topTen = new JTextPane(); //textpane as a conteiner
	    TextPane_topTen.setEditable(false);
	    TextPane_topTen.setBackground(HotPink);
	    TextPane_topTen.setText(tempTopTen());
	    TextPane_topTen.setFont(new Font("Arial", Font.PLAIN, 16));
	    TextPane_topTen.setForeground(Color.white);
	    
	    SimpleAttributeSet bSet = new SimpleAttributeSet();  
        StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER); //set fonts to center alignment
        StyledDocument doc = TextPane_topTen.getStyledDocument();  
        doc.setParagraphAttributes(0, 104, bSet, false);
	    
	    scrollPane_topTen = new JScrollPane(TextPane_topTen); //scrollpane
	    scrollPane_topTen.setSize(350, 490);
	    scrollPane_topTen.setLocation(260, 100);
	    scrollPane_topTen.setBackground(HotPink);
	    scrollPane_topTen.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane_topTen.setVisible(true);
	    Border lightPinkline = null;
		lightPinkline = BorderFactory.createLineBorder(lightPink);
		scrollPane_topTen.setBorder(lightPinkline);
	    p4.add(scrollPane_topTen);
	}
	
	/**
	 * Panel 5 contents
	 */
	private void FillPanel5() {
		
		/*
		 * Initialize color
		 */
		Color orange = new Color(0xfdab4a);
		
		/*
		 * Set layout to absolute
		 */
		p5.setLayout(null);
		
		gbrP5 = new JLabel(); //result logo image
		gbrP5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		p5.add(gbrP5);
		gbrP5.setBounds(120, 200, 250, 250);
		gbrP5.setIcon(new ImageIcon("data/result.jpg"));
		gbrP5.setVisible(true);
		
		labelworld = new JLabel(); //international logo
		labelworld.setBounds(2, 2, 150, 250);
		labelworld.setIcon(new ImageIcon("data/international_feed.jpg"));
		labelworld.setVisible(false);
		p5.add(labelworld);
		
		labelTech = new JLabel(); //technology logo
		labelTech.setBounds(2, 2, 150,250);
		labelTech.setIcon(new ImageIcon("data/technology_feed.jpg"));
		labelTech.setVisible(false);
		p5.add(labelTech);
		
		labelBusiness = new JLabel(); //business logo
		labelBusiness.setBounds(2, 2, 150,250);
		labelBusiness.setIcon(new ImageIcon("data/business_feed.jpg"));
		labelBusiness.setVisible(false);
		p5.add(labelBusiness);
		
		labelSports = new JLabel(); //sports logo
		labelSports.setBounds(2, 2, 150, 250);
		labelSports.setIcon(new ImageIcon("data/sports_feed.jpg"));
		labelSports.setVisible(false);
		p5.add(labelSports);
		
		labelEnt = new JLabel(); //entertainment logo
		labelEnt.setBounds(2, 2, 150,250);
		labelEnt.setIcon(new ImageIcon("data/entertainment_feed.jpg"));
		labelEnt.setVisible(false);
		p5.add(labelEnt);
		
		labelSearch = new JLabel(); //search logo
		labelSearch.setBounds(2, 2, 150,250);
		labelSearch.setIcon(new ImageIcon("data/search_feed.jpg"));
		labelSearch.setVisible(false);
		p5.add(labelEnt);
		
		TextPane_world = new JTextPane(); //text pane as result container for international category
		Border orangeline = null;
		orangeline = BorderFactory.createLineBorder(orange);
		TextPane_world.setBorder(orangeline);
		TextPane_world.setForeground(Color.white);
		TextPane_world.setEditable(false);
		TextPane_world.setBackground(orange);
		TextPane_world.setContentType("text/html");
		TextPane_world.addHyperlinkListener(new HyperlinkListener() {
		    public void hyperlinkUpdate(HyperlinkEvent e) {
		        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
		            if (Desktop.isDesktopSupported()) {
		                try {
		                    Desktop.getDesktop().browse(e.getURL().toURI());
		                } catch (IOException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                } catch (URISyntaxException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                }
		            }
		        }
		    }
		});
		
	    scrollPane_world = new JScrollPane(TextPane_world); //scroll pane for international category
		orangeline = BorderFactory.createLineBorder(orange);
		scrollPane_world.setBorder(orangeline);
	    scrollPane_world.setSize(815, 605);
	    scrollPane_world.setLocation(150, 20);
	    scrollPane_world.setBackground(orange);
	    scrollPane_world.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane_world.setVisible(false);
	    
	    TextPane_tech = new JTextPane(); //text pane as text container for technology category
		orangeline = BorderFactory.createLineBorder(orange);
		TextPane_tech.setBorder(orangeline);
	    TextPane_tech.setEditable(false);
	    TextPane_tech.setBackground(orange);
	    TextPane_tech.setContentType("text/html");
	    TextPane_tech.addHyperlinkListener(new HyperlinkListener() {
		    public void hyperlinkUpdate(HyperlinkEvent e) {
		        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
		            if (Desktop.isDesktopSupported()) {
		                try {
		                    Desktop.getDesktop().browse(e.getURL().toURI());
		                } catch (IOException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                } catch (URISyntaxException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                }
		            }
		        }
		    }
		});
	    
	    scrollPane_tech = new JScrollPane(TextPane_tech); //scroll pane for technology category
	    orangeline = BorderFactory.createLineBorder(orange);
		scrollPane_tech.setBorder(orangeline);
	    scrollPane_tech.setSize(815, 605);
	    scrollPane_tech.setLocation(150, 20);
	    scrollPane_tech.setBackground(orange);
	    scrollPane_tech.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane_tech.setVisible(false);
	    
	    TextPane_business = new JTextPane(); //text pane for business category
	    TextPane_business.setEditable(false);
	    TextPane_business.setBackground(orange);
	    TextPane_business.setContentType("text/html");
	    TextPane_business.addHyperlinkListener(new HyperlinkListener() {
		    public void hyperlinkUpdate(HyperlinkEvent e) {
		        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
		            if (Desktop.isDesktopSupported()) {
		                try {
		                    Desktop.getDesktop().browse(e.getURL().toURI());
		                } catch (IOException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                } catch (URISyntaxException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                }
		            }
		        }
		    }
		});
	    
	    scrollPane_business = new JScrollPane(TextPane_business); //scroll pane for business category
	    orangeline = BorderFactory.createLineBorder(orange);
		scrollPane_business.setBorder(orangeline);
	    scrollPane_business.setSize(815, 605);
	    scrollPane_business.setLocation(150, 20);
	    scrollPane_business.setBackground(orange);
	    scrollPane_business.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane_business.setVisible(false);
	    
	    TextPane_sports = new JTextPane(); //text pane for sports category
	    TextPane_sports.setEditable(false);
	    TextPane_sports.setBackground(orange);
	    TextPane_sports.setContentType("text/html");
	    TextPane_sports.addHyperlinkListener(new HyperlinkListener() {
		    public void hyperlinkUpdate(HyperlinkEvent e) {
		        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
		            if (Desktop.isDesktopSupported()) {
		                try {
		                    Desktop.getDesktop().browse(e.getURL().toURI());
		                } catch (IOException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                } catch (URISyntaxException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                }
		            }
		        }
		    }
		});
	    
	    scrollPane_sports = new JScrollPane(TextPane_sports); //scroll pane for sports category
	    orangeline = BorderFactory.createLineBorder(orange);
		scrollPane_sports.setBorder(orangeline);
	    scrollPane_sports.setSize(815, 605);
	    scrollPane_sports.setLocation(150, 20);
	    scrollPane_sports.setBackground(orange);
	    scrollPane_sports.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane_sports.setVisible(false);
	    
	    TextPane_entertaint = new JTextPane(); //text pane for entertainment category
	    TextPane_entertaint.setEditable(false);
	    TextPane_entertaint.setBackground(orange);
	    TextPane_entertaint.setContentType("text/html");
	    TextPane_entertaint.addHyperlinkListener(new HyperlinkListener() {
		    public void hyperlinkUpdate(HyperlinkEvent e) {
		        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
		            if (Desktop.isDesktopSupported()) {
		                try {
		                    Desktop.getDesktop().browse(e.getURL().toURI());
		                } catch (IOException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                } catch (URISyntaxException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                }
		            }
		        }
		    }
		});
	    
	    scrollPane_entertaint = new JScrollPane(TextPane_entertaint); //scroll pane for entertainment category
	    orangeline = BorderFactory.createLineBorder(orange);
		scrollPane_entertaint.setBorder(orangeline);
	    scrollPane_entertaint.setSize(815, 605);
	    scrollPane_entertaint.setLocation(150, 20);
	    scrollPane_entertaint.setBackground(orange);
	    scrollPane_entertaint.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane_entertaint.setVisible(false);
	    
	    TextPane_hasilSearch = new JTextPane(); //text pane for search result
	    TextPane_hasilSearch.setEditable(false);
	    TextPane_hasilSearch.setBackground(orange);
	    TextPane_hasilSearch.setContentType("text/html");
	    TextPane_hasilSearch.addHyperlinkListener(new HyperlinkListener() {
		    public void hyperlinkUpdate(HyperlinkEvent e) {
		        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
		            if (Desktop.isDesktopSupported()) {
		                try {
		                    Desktop.getDesktop().browse(e.getURL().toURI());
		                } catch (IOException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                } catch (URISyntaxException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                }
		            }
		        }
		    }
		});
	    
	    scrollPane_hasilSearch = new JScrollPane(TextPane_hasilSearch); //scroll pane for search result
	    orangeline = BorderFactory.createLineBorder(orange);
		scrollPane_hasilSearch.setBorder(orangeline);
	    scrollPane_hasilSearch.setSize(815, 605);
	    scrollPane_hasilSearch.setLocation(150, 20);
	    scrollPane_hasilSearch.setBackground(orange);
	    scrollPane_hasilSearch.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane_hasilSearch.setVisible(false);
	    
	    Pengkategori PK = new Pengkategori();
	    
	    //List of international category
		tempWorld = "<html>";
	    for(FeedMessage fm : PK.ListWorld){
	    	tempWorld += "<a href = \""+fm.getLink()+"\">"+fm.getDescription()+"</a>";
	    	tempWorld += "<br><br>";	
	    }
	    tempWorld += "</html>";
	    
	    //List of technology category
	    tempTech = "<html>";
	    for(FeedMessage fm : PK.ListTech){
	    	tempTech += "<a href = \""+fm.getLink()+"\">"+fm.getDescription()+"</a>";
	    	tempTech += "<br><br>";
	    }
	    tempTech += "</html>";
	    
	    //List of business category
	    tempBus = "<html>";
	    for(FeedMessage fm : PK.ListBusiness){
	    	tempBus += "<a href = \""+fm.getLink()+"\">"+fm.getDescription()+"</a>";
	    	tempBus += "<br><br>";
	    }
	    tempBus += "</html>";
	    
	    //List of sports category
	    tempSports = "<html>";
	    for(FeedMessage fm : PK.ListSport){
	    	tempSports += "<a href = \""+fm.getLink()+"\">"+fm.getDescription()+"</a>";
	    	tempSports += "<br><br>";
	    }
	    tempSports += "</html>";
	    
	    //List of Entertainment category
	    tempEntertaint = "<html>";
	    for(FeedMessage fm : PK.ListEnt){
	    	tempEntertaint += "<a href = \""+fm.getLink()+"\">"+fm.getDescription()+"</a>";
	    	tempEntertaint += "<br><br>";
	    }
	    tempEntertaint += "<html>";
	}
	
	/**
	 * Function to return string in List from topTen()
	 * @return tempTopTen
	 */
	private String tempTopTen() {
		String tempTopTen = "";
	    for (String s : topTen())
	    {
	    	tempTopTen += s;
	    	tempTopTen += "\n\n";
	    }
	    
	    return tempTopTen;
	}
	
	/**
	 * Function to return search result from ListAll
	 * @param String s
	 * @return temp
	 */
	public static String search(String s){
		Pengkategori PK = new Pengkategori();
		String temp = "<html>";
		boolean found = false;
	    for(FeedMessage fm : PK.ListAll){
	    	if(fm.getDescription().toLowerCase().contains(s.toLowerCase())){
	    		found = true;
	    		temp += "<a href = \""+fm.getLink()+"\">"+fm.getDescription()+"</a>";
	    		temp += "<br><br>";
	    	}
	    }
	    if(!found){
	    	temp += "Search querry not found<br>";
	    }
	    temp += "</html>";
		
		return temp;
	}
	
	/**
	 * Function to return List of string of topTen()
	 * @return temp
	 */
	public static List<String> topTen(){
		Pengkategori PK = new Pengkategori();
		List<String> temp = new ArrayList<String>();
		temp.add("\n");
		String strSource = "";
		
		for(FeedMessage fm : PK.ListAll){
			strSource += fm.getDescription() + " ";
		}
		Index idx = new Index(strSource);
		for(String s : idx.KataTopN(10)){
			temp.add(s.toUpperCase());
		}
		
		
		return temp;
	}
	
	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Method to show actions in panel 5
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == image31)
		{
			p5.removeAll();
			TextPane_world.setText(tempWorld);
			p5.add(scrollPane_world);
			p5.add(labelworld);
			gbrP5.setVisible(false);
			labelTech.setVisible(false);
			labelBusiness.setVisible(false);
			labelSports.setVisible(false);
			labelEnt.setVisible(false);
			labelworld.setVisible(true);
			labelSearch.setVisible(false);
			scrollPane_hasilSearch.setVisible(false);
			scrollPane_sports.setVisible(false);
			scrollPane_entertaint.setVisible(false);
			scrollPane_business.setVisible(false);
			scrollPane_tech.setVisible(false);
			scrollPane_world.setVisible(true);
		} else if (e.getSource() == image32)
		{
			p5.removeAll();
			TextPane_tech.setText(tempTech);
			p5.add(scrollPane_tech);
			p5.add(labelTech);
			gbrP5.setVisible(false);
			labelTech.setVisible(true);
			labelBusiness.setVisible(false);
			labelSports.setVisible(false);
			labelEnt.setVisible(false);
			labelworld.setVisible(false);
			labelSearch.setVisible(false);
			scrollPane_hasilSearch.setVisible(false);
			scrollPane_sports.setVisible(false);
			scrollPane_entertaint.setVisible(false);
			scrollPane_business.setVisible(false);
			scrollPane_world.setVisible(false);
			scrollPane_tech.setVisible(true);
		} else if (e.getSource() == image33)
		{
			p5.removeAll();
			TextPane_business.setText(tempBus);
			p5.add(scrollPane_business);
			p5.add(labelBusiness);
			gbrP5.setVisible(false);
			labelTech.setVisible(false);
			labelBusiness.setVisible(true);
			labelSports.setVisible(false);
			labelEnt.setVisible(false);
			labelworld.setVisible(false);
			labelSearch.setVisible(false);
			scrollPane_hasilSearch.setVisible(false);
			scrollPane_sports.setVisible(false);
			scrollPane_entertaint.setVisible(false);
			scrollPane_tech.setVisible(false);
			scrollPane_world.setVisible(false);
			scrollPane_business.setVisible(true);
		} else if (e.getSource() == image34)
		{
			p5.removeAll();
			TextPane_sports.setText(tempSports);
			p5.add(scrollPane_sports);
			p5.add(labelSports);
			gbrP5.setVisible(false);
			labelTech.setVisible(false);
			labelBusiness.setVisible(false);
			labelSports.setVisible(true);
			labelEnt.setVisible(false);
			labelworld.setVisible(false);
			labelSearch.setVisible(false);
			scrollPane_hasilSearch.setVisible(false);
			scrollPane_tech.setVisible(false);
			scrollPane_entertaint.setVisible(false);
			scrollPane_business.setVisible(false);
			scrollPane_world.setVisible(false);
			scrollPane_sports.setVisible(true);
		} else if (e.getSource() == image35)
		{
			p5.removeAll();
			TextPane_entertaint.setText(tempEntertaint);
			p5.add(scrollPane_entertaint);
			p5.add(labelEnt);
			gbrP5.setVisible(false);
			labelTech.setVisible(false);
			labelBusiness.setVisible(false);
			labelSports.setVisible(false);
			labelEnt.setVisible(true);
			labelworld.setVisible(false);
			labelSearch.setVisible(false);
			scrollPane_hasilSearch.setVisible(false);
			scrollPane_sports.setVisible(false);
			scrollPane_business.setVisible(false);
			scrollPane_tech.setVisible(false);
			scrollPane_world.setVisible(false);
			scrollPane_entertaint.setVisible(true);
		} else if (e.getSource() == buttonGo)
		{
			p5.removeAll();
			TextPane_hasilSearch.setText(search(searchText.getText()));
			p5.add(scrollPane_hasilSearch);
			p5.add(labelSearch);
			gbrP5.setVisible(false);
			labelTech.setVisible(false);
			labelBusiness.setVisible(false);
			labelSports.setVisible(false);
			labelEnt.setVisible(false);
			labelworld.setVisible(false);
			labelSearch.setVisible(true);
			scrollPane_tech.setVisible(false);
			scrollPane_entertaint.setVisible(false);
			scrollPane_business.setVisible(false);
			scrollPane_world.setVisible(false);
			scrollPane_sports.setVisible(false);
			scrollPane_hasilSearch.setVisible(true);
		}
	}	
}
