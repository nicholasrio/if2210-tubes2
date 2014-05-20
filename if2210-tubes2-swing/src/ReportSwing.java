import java.util.Scanner;
import javax.swing.*;

import org.jfree.ui.RefineryUtilities;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	
public class ReportSwing extends JFrame{
	
	public JFrame fReport = new JFrame();
	
	public ReportSwing(){
			fReport.getContentPane();
			fReport.setLayout(new FlowLayout(FlowLayout.CENTER));
			fReport.add(new JLabel("Pilih Menu Report"));
			
			
			JButton btnPengeluaran = new JButton("Pengeluaran");
			fReport.add(btnPengeluaran);
			btnPengeluaran.setPreferredSize(new Dimension(320,140));
			btnPengeluaran.setBackground(Color.lightGray);
			btnPengeluaran.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					Thread t1 = new Thread(){
						@Override
						public void run(){
							reportkeluaran();
						}
					};t1.start();
				}
			});
			JButton btnPemasukan = new JButton("Pemasukan");
			fReport.add(btnPemasukan);
			btnPemasukan.setPreferredSize(new Dimension(320,140));
			btnPemasukan.setBackground(Color.lightGray);
			btnPemasukan.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					Thread t2 = new Thread(){
						@Override
						public void run(){
							ReportSwingPemasukan test2 = new ReportSwingPemasukan("perbandingan", "Pemasukan");
						    test2.pack();
						    test2.setVisible(true);
						}
					};t2.start();
				}
			});
			JButton btnOverall = new JButton("Balance");
			fReport.add(btnOverall);
			btnOverall.setPreferredSize(new Dimension(320,140));
			btnOverall.setBackground(Color.lightGray);
			btnOverall.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					Thread t3 = new Thread(){
						@Override
						public void run(){
							ReportSwingOverall test3 = new ReportSwingOverall("Balance Report", "Pekan","nominal");
						    test3.pack();
						    test3.setVisible(true);
						}
					};t3.start();
				}
			});
			
			JButton btnBackReport = new JButton("Back");
			fReport.add(btnBackReport);
			btnBackReport.setPreferredSize(new Dimension(100,50));
			btnBackReport.setBackground(Color.lightGray);
			btnBackReport.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					Thread t0 = new Thread(){
						@Override
						public void run(){
							fReport.setVisible(false);
							MainMenu test1 = new MainMenu();
							test1.fMenu.setVisible(true);
						}
					};t0.start();
				}
			});
			
			fReport.setLocation(450, 50);
			fReport.getContentPane().setBackground(Color.white);
			fReport.setTitle("Aplikasi Keuangan Anak Kosan"); // "this" Frame sets title
			fReport.setSize(400, 680);      // "this" Frame sets initial size
		    fReport.setVisible(true);
		    
		}
	
	public static void reportkeluaran(){
		ReportSwingPengeluaran test1 = new ReportSwingPengeluaran("Comparison", "Pengeluaran");
	    test1.pack();
	    test1.setVisible(true);
	}
}
	