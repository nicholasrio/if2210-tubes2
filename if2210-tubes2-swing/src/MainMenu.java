import javax.swing.*;

import org.jfree.ui.RefineryUtilities;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
public JFrame fMenu = new JFrame();
	
	public MainMenu(){
			fMenu.getContentPane();
			fMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
			fMenu.add(new JLabel("Financial Planner SI ANAK KOST"));
			
			
			JButton btnBudget = new JButton("Budget");
			fMenu.add(btnBudget);
			btnBudget.setPreferredSize(new Dimension(320,140));
			btnBudget.setBackground(Color.lightGray);
			btnBudget.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					Thread t1 = new Thread(){
						@Override
						public void run(){
							fMenu.setVisible(false);
							BudgetSwing test3 = new BudgetSwing();
							test3.f.setVisible(true);
						}
					};t1.start();
				}
			});
			JButton btnStatus = new JButton("Status");
			fMenu.add(btnStatus);
			btnStatus.setPreferredSize(new Dimension(320,140));
			btnStatus.setBackground(Color.lightGray);
			btnStatus.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					Thread t2 = new Thread(){
						@Override
						public void run(){
							fMenu.setVisible(false);
							StatusSwing test1 = new StatusSwing();
							test1.fStatus.setVisible(true);
						}
					};t2.start();
				}
			});
			JButton btnReport = new JButton("Report");
			fMenu.add(btnReport);
			btnReport.setPreferredSize(new Dimension(320,140));
			btnReport.setBackground(Color.lightGray);
			btnReport.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					Thread t3 = new Thread(){
						@Override
						public void run(){
							fMenu.setVisible(false);
							ReportSwing test2 = new ReportSwing();
							test2.fReport.setVisible(true);
						}
					};t3.start();
				}
			});
			
			JButton btnTwitter = new JButton("Twitter Share");
			fMenu.add(btnTwitter);
			btnTwitter.setPreferredSize(new Dimension(320,140));
			btnTwitter.setBackground(Color.lightGray);
			btnTwitter.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					Thread t4 = new Thread(){
						@Override
						public void run(){
							//fMenu.setVisible(false);
							//ReportSwing test5 = new ReportSwing();
							//test5.fReport.setVisible(true);
						}
					};t4.start();
				}
			});
			
			fMenu.setLocation(450, 50);
			fMenu.getContentPane().setBackground(Color.white);
			fMenu.setTitle("Aplikasi Keuangan Anak Kosan"); // "this" Frame sets title
			fMenu.setSize(400, 680);      // "this" Frame sets initial size
		    fMenu.setVisible(true);
		    
		}
}
