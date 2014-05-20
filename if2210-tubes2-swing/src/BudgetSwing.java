import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
public class BudgetSwing extends JFrame {
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	public static final String DB_URL = "jdbc:mysql://localhost/jais";
	public static final String USER = "root";
	public static final String PASS = "";
	public static Connection conn = null;
	public static Statement stmt = null;
	public static int pilihMenu;
	public static int pilihBulan;
	public static String ketBudget;
	public static String tanggal;
	public static String keteranganJan;
	public static String TanggalJan;
	public JFrame f = new JFrame();
	public BudgetSwing() {
		regJDBCException();
		openConn();
		//final JFrame f = new JFrame();
		//Container cp = this.getContentPane();
		f.getContentPane();
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		//cp.add(new JLabel("Aplikasi Keuangan Anak Kosan"));
		f.add(new JLabel("Pilih Bulan : "));
		
		
		
		JButton btnJanuari = new JButton("1. Januari");
		f.add(btnJanuari);
		btnJanuari.setPreferredSize(new Dimension(320,40));
		btnJanuari.setBackground(Color.lightGray);
		btnJanuari.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Thread t  = new Thread() {
					
					@Override
					public void run() {
						//f.dispose();
						newFrameInsertJanket();
					}
				}; t.start();
			}
			
		});
		
		JButton btnFebruari = new JButton("2. Februari");
		f.add(btnFebruari);
		btnFebruari.setPreferredSize(new Dimension(320,40));
		btnFebruari.setBackground(Color.lightGray);
		
		JButton btnMaret = new JButton("3. Maret");
		f.add(btnMaret);
		btnMaret.setPreferredSize(new Dimension(320,40));
		btnMaret.setBackground(Color.lightGray);
		
		JButton btnApril = new JButton("4. April");
		f.add(btnApril);
		btnApril.setPreferredSize(new Dimension(320,40));
		btnApril.setBackground(Color.lightGray);
		
		JButton btnMei = new JButton("5. Mei");
		f.add(btnMei);
		btnMei.setPreferredSize(new Dimension(320,40));
		btnMei.setBackground(Color.lightGray);
		
		JButton btnJuni = new JButton("6. Juni");
		f.add(btnJuni);
		btnJuni.setPreferredSize(new Dimension(320,40));
		btnJuni.setBackground(Color.lightGray);
		
		JButton btnJuli = new JButton("7. Juli");
		f.add(btnJuli);
		btnJuli.setPreferredSize(new Dimension(320,40));
		btnJuli.setBackground(Color.lightGray);
		
		JButton btnAgustus = new JButton("8. Agustus");
		f.add(btnAgustus);
		btnAgustus.setPreferredSize(new Dimension(320,40));
		btnAgustus.setBackground(Color.lightGray);
		
		JButton btnSeptember = new JButton("9. September");
		f.add(btnSeptember);
		btnSeptember.setPreferredSize(new Dimension(320,40));
		btnSeptember.setBackground(Color.lightGray);
		
		JButton btnOktober = new JButton("10. Oktober");
		f.add(btnOktober);
		btnOktober.setPreferredSize(new Dimension(320,40));
		btnOktober.setBackground(Color.lightGray);
		
		JButton btnNovember = new JButton("11. November");
		f.add(btnNovember);
		btnNovember.setPreferredSize(new Dimension(320,40));
		btnNovember.setBackground(Color.lightGray);
		
		JButton btnDesember = new JButton("12. Desember");
		f.add(btnDesember);
		btnDesember.setPreferredSize(new Dimension(320,40));
		btnDesember.setBackground(Color.lightGray);
		
		
		JButton btnBackReport = new JButton("Back");
		f.add(btnBackReport);
		btnBackReport.setPreferredSize(new Dimension(100,50));
		btnBackReport.setBackground(Color.lightGray);
		btnBackReport.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Thread t0 = new Thread(){
					@Override
					public void run(){
						f.setVisible(false);
						MainMenu test1 = new MainMenu();
						test1.fMenu.setVisible(true);
					}
				};t0.start();
			}
		});
		
		f.setLocation(450, 50);
		f.getContentPane().setBackground(Color.white);
		f.setTitle("Aplikasi Keuangan Anak Kosan"); // "this" Frame sets title
		f.setSize(400, 680);      // "this" Frame sets initial size
	    f.setVisible(true);
	}
	public static void InsertRecord() {
		regJDBCException();
		openConn();
		try {
		System.out.println("Budgetting : ");
		System.out.println();
		System.out.println("1. Insert Budget ");
		System.out.println("2. Show Budget ");
		System.out.println("3. Delete Budget ");
		System.out.println("4. Clear Budget ");
		Scanner in = new Scanner(System.in);
		pilihMenu = in.nextInt();
		if (pilihMenu == 1) {
				System.out.println("Choose month : ");
				System.out.println("1. January");
				System.out.println("2. Pebruary");
				System.out.println("3. March");
				System.out.println("4. April");
				System.out.println("5. May");
				System.out.println("6. June");
				System.out.println("7. July");
				System.out.println("8. August");
				System.out.println("9. September");
				System.out.println("10. October");
				System.out.println("11. Nopember");
				System.out.println("12. Desember");
				pilihBulan = in.nextInt();
				if(pilihBulan == 1) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO january(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from january";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
				else if(pilihBulan == 2) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO february(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from february";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
				else if(pilihBulan == 3) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO maret(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from maret";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
				else if (pilihBulan == 4) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO april(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from april";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
				else if(pilihBulan == 5) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO mei(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from mei";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
				else if (pilihBulan == 6) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO juni(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from juni";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
				else if (pilihBulan == 7) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO juli(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from juli";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
				else if (pilihBulan == 8) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO agustus(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from agustus";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
				else if(pilihBulan == 9) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO september(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from september";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
				else if(pilihBulan == 10) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO oktober(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from oktober";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
				else if(pilihBulan == 11) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO november(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from november";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
				else if(pilihBulan == 12) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.next();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO desember(keterengan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from desember";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterengan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
				}
			}
		else if(pilihMenu == 2) {
			System.out.println("Choose month : ");
			System.out.println("1. January");
			System.out.println("2. Pebruary");
			System.out.println("3. March");
			System.out.println("4. April");
			System.out.println("5. May");
			System.out.println("6. June");
			System.out.println("7. July");
			System.out.println("8. August");
			System.out.println("9. September");
			System.out.println("10. October");
			System.out.println("11. Nopember");
			System.out.println("12. Desember");
			pilihBulan = in.nextInt();
			if (pilihBulan == 1) {
				String sql = "select * from january";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 2) {
				String sql = "select * from february";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 3) {
				String sql = "select * from maret";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 4){
				String sql = "select * from april";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 5) {
				String sql = "select * from mei";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 6) {
				String sql = "select * from juni";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 7) {
				String sql = "select * from juli";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 8) {
				String sql = "select * from agustus";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 9) {
				String sql = "select * from september";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 10) {
				String sql = "select * from oktober";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 11) {
				String sql = "select * from november";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 12) {
				String sql = "select * from desember";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterengan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
		}
		else if (pilihMenu == 3) {
			System.out.println("Choose month : ");
			System.out.println("1. January");
			System.out.println("2. Pebruary");
			System.out.println("3. March");
			System.out.println("4. April");
			System.out.println("5. May");
			System.out.println("6. June");
			System.out.println("7. July");
			System.out.println("8. August");
			System.out.println("9. September");
			System.out.println("10. October");
			System.out.println("11. Nopember");
			System.out.println("12. Desember");
			pilihBulan = in.nextInt();
			if(pilihBulan == 1) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM january where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
			else if(pilihBulan == 2) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM february where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
			else if(pilihBulan == 3) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM maret where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
			else if(pilihBulan == 4) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM april where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
			else if(pilihBulan == 5) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM mei where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
			else if(pilihBulan == 6) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM juni where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
			else if(pilihBulan == 7) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM juli where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
			else if(pilihBulan == 8) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM agustus where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
			else if(pilihBulan == 9) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM september where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
			else if(pilihBulan == 10) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM oktober where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
			else if(pilihBulan == 11) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM november where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
			else if(pilihBulan == 12) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.next();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM desember where (keterengan = ?) AND (tanggal = ?) ");
				ps2.setString(1,ketBudget2);
				ps2.setString(2,tanggal);
				ps2.execute();
				return;
			}
		}
		else if (pilihMenu == 4) {
				System.out.println("Choose month : ");
				System.out.println("1. January");
				System.out.println("2. Pebruary");
				System.out.println("3. March");
				System.out.println("4. April");
				System.out.println("5. May");
				System.out.println("6. June");
				System.out.println("7. July");
				System.out.println("8. August");
				System.out.println("9. September");
				System.out.println("10. October");
				System.out.println("11. Nopember");
				System.out.println("12. Desember");
				pilihBulan = in.nextInt();
				if(pilihBulan == 1) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM january");
					ps3.execute();
				}
				else if(pilihBulan == 2) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM february");
					ps3.execute();
				}
				else if(pilihBulan == 3) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM maret");
					ps3.execute();
				}
				else if(pilihBulan == 4) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM april");
					ps3.execute();
				}
				else if(pilihBulan == 5) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM mei");
					ps3.execute();
				}
				else if(pilihBulan == 6) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM juni");
					ps3.execute();

				}
				else if(pilihBulan == 7) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM juli");
					ps3.execute();
				}
				else if(pilihBulan == 8) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM agustus");
					ps3.execute();
				}
				else if(pilihBulan == 9) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM september");
					ps3.execute();
				}
				else if(pilihBulan == 10) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM oktober");
					ps3.execute();
				}
				else if(pilihBulan == 11) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM november");
					ps3.execute();
				}
				else if(pilihBulan == 12) {
					System.out.println("Are you sure to delete all budget records  ");
					System.out.println("press 'y' for yes or 'n' for no");
					String choice = in.next();
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM desember");
					ps3.execute();
				}
			}
		}
		catch (Exception e) {e.printStackTrace();}
		tutupStatement();
		tutupKoneksi();
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
			        		keteranganJan = ketText.getText();
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
		public static void newFrameInsertJanTan(){
			final JFrame f = new JFrame("Tanggal Budget");
			f.getContentPane();
			f.setLayout(new FlowLayout(FlowLayout.CENTER));
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			final JTextField ketText = new JTextField("",20);
			
			ketText.setEditable(true);
			f.add(ketText);
			JButton ketButton = new JButton("insert");
			f.add(ketButton);
			f.add(new JLabel("Masukkan Tanggal"));
			ketButton.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		           f.dispose();
		           TanggalJan = ketText.getText();
		         }
		      });
			f.setLocation(450, 200);
			f.getContentPane().setBackground(Color.white);
			f.setTitle("Aplikasi Keuangan Anak Kosan"); // "this" Frame sets title
			f.setSize(400, 150);      // "this" Frame sets initial size
		    f.setVisible(true);
		}
}
