import java.util.*;
import java.io.*;
import java.sql.*;


public class Budget {
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	public static final String DB_URL = "jdbc:mysql://localhost/bima";
	public static final String USER = "root";
	public static final String PASS = "";
	public static Connection conn = null;
	public static Statement stmt = null;
	public static int pilihMenu;
	public static int pilihBulan;
	public static String ketBudget;
	public static String tanggal;
	public Budget() {InsertRecord();}
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
		pilihMenu = in.nextInt();in.nextLine();
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
				pilihBulan = in.nextInt();in.nextLine();
				if(pilihBulan == 1) {
					stmt = conn.createStatement();
					System.out.println("Masukkan keterangan budget : ");
					ketBudget = in.nextLine();
					System.out.println("Masukkan tanggal : ");
					tanggal = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO january(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from january";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
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
					PreparedStatement ps = conn.prepareStatement("INSERT INTO february(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from february";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
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
					PreparedStatement ps = conn.prepareStatement("INSERT INTO maret(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from maret";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
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
					PreparedStatement ps = conn.prepareStatement("INSERT INTO april(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from april";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
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
					PreparedStatement ps = conn.prepareStatement("INSERT INTO may(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from may";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
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
					PreparedStatement ps = conn.prepareStatement("INSERT INTO juni(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from juni";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
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
					PreparedStatement ps = conn.prepareStatement("INSERT INTO juli(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from juli";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
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
					PreparedStatement ps = conn.prepareStatement("INSERT INTO agustus(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from agustus";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
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
					PreparedStatement ps = conn.prepareStatement("INSERT INTO september(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from september";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("");
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
					PreparedStatement ps = conn.prepareStatement("INSERT INTO oktober(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from oktober";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
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
					PreparedStatement ps = conn.prepareStatement("INSERT INTO november(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from november";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
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
					PreparedStatement ps = conn.prepareStatement("INSERT INTO desember(keterangan,tanggal) values (?,?)");
					ps.setString(1,ketBudget);
					ps.setString(2,tanggal);
					ps.executeUpdate();
					
					String sql = "select * from desember";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
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
					stmt = conn.createStatement();
					String sql = "select * from january";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String ketB = rs.getString("keterangan");
						String tangg = rs.getString("tanggal");
						System.out.println(ketB + " "+tangg);
					}
					rs.close();
			}
			else if(pilihBulan == 2) {
				stmt = conn.createStatement();
				String sql = "select * from february";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterangan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 3) {
				stmt = conn.createStatement();
				String sql = "select * from maret";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterangan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 4){
				stmt = conn.createStatement();
				String sql = "select * from april";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterangan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 5) {
				stmt = conn.createStatement();
				String sql = "select keterangan,tanggal from may";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterangan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 6) {
				stmt = conn.createStatement();
				String sql = "select * from juni";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterangan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 7) {
				stmt = conn.createStatement();
				String sql = "select * from juli";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterangan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 8) {
				stmt = conn.createStatement();
				String sql = "select * from agustus";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterangan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 9) {
				stmt = conn.createStatement();
				String sql = "select * from september";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterangan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 10) {
				stmt = conn.createStatement();
				String sql = "select * from oktober";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterangan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 11) {
				stmt = conn.createStatement();
				String sql = "select * from november";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterangan");
					String tangg = rs.getString("tanggal");
					System.out.println(ketB + " "+tangg);
				}
				rs.close();
			}
			else if(pilihBulan == 12) {
				stmt = conn.createStatement();
				String sql = "select * from desember";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ketB = rs.getString("keterangan");
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
			pilihBulan = in.nextInt();in.nextLine();
			if(pilihBulan == 1) {
				System.out.println("Masukkan budget yang akan dihapus");
				stmt = conn.createStatement();
				System.out.println("Masukkan keterangan budget :");
				String ketBudget2 = in.nextLine();
				System.out.println("Masukkan tanggal :");
				String tanggal = in.next();
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM january where (keterangan = ?) AND (tanggal = ?) ");
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
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM february where (keterangan = ?) AND (tanggal = ?) ");
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
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM maret where (keterangan = ?) AND (tanggal = ?) ");
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
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM april where (keterangan = ?) AND (tanggal = ?) ");
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
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM may where (keterangan = ?) AND (tanggal = ?) ");
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
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM juni where (keterangan = ?) AND (tanggal = ?) ");
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
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM juli where (keterangan = ?) AND (tanggal = ?) ");
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
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM agustus where (keterangan = ?) AND (tanggal = ?) ");
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
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM september where (keterangan = ?) AND (tanggal = ?) ");
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
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM oktober where (keterangan = ?) AND (tanggal = ?) ");
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
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM november where (keterangan = ?) AND (tanggal = ?) ");
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
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM desember where (keterangan = ?) AND (tanggal = ?) ");
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
					PreparedStatement ps3 = conn.prepareStatement("DELETE FROM may");
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
}
