/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

/**
 * 
 * @author William Stefan
 */
public class Main extends JPanel implements ActionListener {
	private Vehicle V;
	int x;
	Timer t;
	JFrame j = new JFrame("Coba");

	public static void main(String arg[]) {
		Main main = new Main();
		main.t.start();
	}

	public Main() {
		V = new Vehicle();
		j.setSize(800, 600);
		j.setLocationRelativeTo(null);
		j.setTitle("Vehicle - Type");
		j.setResizable(false);
		j.add(this);
		j.setVisible(true);
		x = 0;
		t = new Timer(1000, this);
		
		// membuat panel / canvas
		getRootPane().add(this);
		setLayout(null);
		setBackground(Color.blue);

		// setBounds(x, y, width, height)
		// Quit Button
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(0, 360, 100, 30);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
				System.out.println("quit");
			}
		});
		quitButton.setToolTipText("A quit button");

		// Upgrade Vehicle
		JButton upgrade = new JButton("Upgrade");
		upgrade.setBounds(0, 300, 100, 30);
		upgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				V.Upgrade();
				System.out.println("upgrade");
			}
		});
		upgrade.setToolTipText("A button to upgrade vehicle");

		// Downgrade Vehicle
		JButton downgrade = new JButton("Downgrade");
		downgrade.setBounds(0, 330, 100, 30);
		downgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				V.Downgrade();
				System.out.println("downgrade");
			}
		});
		downgrade.setToolTipText("A button to downgrade vehicle");
		
		// Ke pasar
		JButton pasar = new JButton("Ke pasar");
		pasar.setBounds(200, 300, 150, 30);
		pasar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				V.setImage(V.getID(), 1);
				t.start();
				System.out.println("pasar");
			}
		});
		pasar.setToolTipText("Memberangkatkan vehicle ke pasar");
		
		// Ke pertanian
		JButton pertanian = new JButton("Ke pertanian");
		pertanian.setBounds(200, 330, 150, 30);
		pertanian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				V.setImage(V.getID(), 0);
				t.start();
				System.out.println("pertanin");
			}
		});
		pertanian.setToolTipText("Memberangkatkan vehicle ke pertanian");		
		
		// Penambahan button ke panel, kalau engga ditambah, ga akan muncul
		add(quitButton);
		add(upgrade);
		add(downgrade);
		add(pasar);
		add(pertanian);
		
		j.setTitle("SwingTest");
		j.setLocationRelativeTo(null);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(V.getImage(), x, 0, 256, 256, null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (x < 450) {
			x += 5;
		}
		if (x >= 450) {
			System.out.println("Sudah sampai~");
			t.stop();
		}
		repaint();
	}
}