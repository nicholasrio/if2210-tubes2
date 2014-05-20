import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.*;

import org.jfree.ui.RefineryUtilities;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StatusSwing {

	public JFrame fStatus = new JFrame();
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	public static final String DB_URL = "jdbc:mysql://localhost/bima";
	public static final String USER = "root";
	public static final String PASS = "";
	public static Connection conn = null;
	public static Statement stmt = null;
    public static String keterangan;
    public static int keuangan;
	public static String pemasukan;
    public static int pilihMenu;
	
	public StatusSwing(){
		
		fStatus.getContentPane();
		fStatus.setLayout(new FlowLayout(FlowLayout.CENTER));
		fStatus.add(new JLabel("Pilih Menu Status"));
		
		
		JButton btnKeuangan = new JButton("Edit Keuangan");
		fStatus.add(btnKeuangan);
		btnKeuangan.setPreferredSize(new Dimension(320,140));
		btnKeuangan.setBackground(Color.lightGray);
		btnKeuangan.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Thread t1 = new Thread(){
					@Override
					public void run(){
						newFrameInsertJanket();
					}
				};t1.start();
			}
		});
		
		JButton btnLihatStatus = new JButton("Lihat Status");
		fStatus.add(btnLihatStatus);
		btnLihatStatus.setPreferredSize(new Dimension(320,140));
		btnLihatStatus.setBackground(Color.lightGray);
		btnLihatStatus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Thread t2 = new Thread(){
					@Override
					public void run(){
						
					}
				};t2.start();
			}
		});
		
		JButton btnBackStatus = new JButton("Back");
		fStatus.add(btnBackStatus);
		btnBackStatus.setPreferredSize(new Dimension(100,50));
		btnBackStatus.setBackground(Color.lightGray);
		btnBackStatus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Thread t0 = new Thread(){
					@Override
					public void run(){
						fStatus.setVisible(false);
						MainMenu test2 = new MainMenu();
						test2.fMenu.setVisible(true);	
					}
				};t0.start();
			}
		});
		
		fStatus.setLocation(450, 50);
		fStatus.getContentPane().setBackground(Color.white);
		fStatus.setTitle("Aplikasi Keuangan Anak Kosan"); // "this" Frame sets title
		fStatus.setSize(400, 680);      // "this" Frame sets initial size
	    fStatus.setVisible(true);
		
	}
		
		public static void regJDBCException() {
			try {
				Class.forName("com.mysql.jdbc.Driver"); }
			catch(ClassNotFoundException e) {
				System.out.println("kelas tidak ditemukan " + e);}
		}

		public static void openConn() {
			try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);}
			catch(SQLException e) {
				System.out.println("Tidak bisa membuka konektivitas " + e);}
		}
		
		public static void tutupStatement() {
				try {
					if (stmt != null) conn.close();}
				catch(SQLException e) {
					System.out.println("gagal menutup statement " + e); }
		}

		public static void tutupKoneksi() {
				try {
					if (conn != null) conn.close();}
				catch(SQLException e) {
					System.out.println("Gagal menutup konektivitas " + e); }
		}
		
		public static void newFrameInsertJanket() {
			//final String keterangan;
			regJDBCException();
			openConn();
			try {
			Date date = new Date();
			SimpleDateFormat month ;
			month = new SimpleDateFormat("MMMM");
			String thisMonth = month.format(date);
			String tanggal;
		 	final JFrame g = new JFrame("Keterangan Budget");
		 	g.getContentPane();
			g.setLayout(new FlowLayout(FlowLayout.CENTER));
			g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			g.setSize(300,300);
			g.setVisible(true);
		    final JTextField ketText = new JTextField("",20);
			ketText.setEditable(true);
			g.add(ketText);
			JButton ketButton = new JButton("insert");
			g.add(ketButton);
			g.add(new JLabel("Masukkan Keterangan"));
			ketButton.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	
		        	Thread t = new Thread() {
		        	@Override
		        	public void run() {
		        		g.dispose();
		        		keterangan = ketText.getText();
		        		newFrameInsertJanTan();
		        	  }
		        	}; t.start();
		         }
			
			});
			
			g.setLocation(450, 200);
			g.getContentPane().setBackground(Color.white);
			g.setTitle("Aplikasi Keuangan Anak Kosan"); // "this" Frame sets title
			g.setSize(400, 150);      // "this" Frame sets initial size
		    g.setVisible(true);
			}
			catch (Exception e) {e.printStackTrace();}
			tutupStatement();
			tutupKoneksi();
		    
	}
			
	public static void newFrameInsertJanTan(){
		
		regJDBCException();
		openConn();
		try {
		Date date = new Date();
		SimpleDateFormat month ;
		month = new SimpleDateFormat("MMMM");
		String thisMonth = month.format(date);
		
		final JFrame f = new JFrame("Nominal Budget");
		f.getContentPane();
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JTextField ketText = new JTextField("",20);
		
		ketText.setEditable(true);
		f.add(ketText);
		JButton ketButton = new JButton("insert");
		f.add(ketButton);
		f.add(new JLabel("Masukkan Nominal"));
		ketButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	           f.dispose();
	           //String temp= ketText.getText();
	           
	         }
	      });
		f.setLocation(450, 200);
		f.getContentPane().setBackground(Color.white);
		f.setTitle("Aplikasi Keuangan Anak Kosan"); // "this" Frame sets title
		f.setSize(400, 150);      // "this" Frame sets initial size
	    f.setVisible(true);
	}
	catch (Exception e) {e.printStackTrace();}
	tutupStatement();
	tutupKoneksi();
	    
	}
}
		

