/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetusingtwitter4j;

/**
 *
 * @author jais
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.io.*;
import java.sql.*;
public class StatusBudget {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	public static final String DB_URL = "jdbc:mysql://localhost/bima";
	public static final String USER = "root";
	public static final String PASS = "";
	public static Connection conn = null;
	public static Statement stmt = null;
    public static String keterangan;
    //public static String deskripsi;
    public static int keuangan;
	public static String pemasukan;
    public static String budgetshow;
    public static int pilihMenu;
	public static String ketBudget;
	public static String tanggal;
	public static String showIn;
	public static String showOut;
        /*
        @param IntegerMenu
        @returns another function
        */
		
		public StatusBudget(){
			InsertBalance();
		}
	
        public static void InsertBalance(){
            regJDBCException();
		openConn();
		try {
		Date date = new Date();
		SimpleDateFormat month ;
		month = new SimpleDateFormat("MMMM");
		String thisMonth = month.format(date);
		System.out.println("Status : ");
		System.out.println();
		System.out.println("1. Edit Keuangan");
		System.out.println("2. Lihat Status ");
                Scanner in = new Scanner(System.in);
		pilihMenu = in.nextInt(); in.nextLine();
                if (pilihMenu == 1){
                    stmt = conn.createStatement();
					System.out.print("Masukkan Keterangan : ");
					keterangan = in.nextLine();
					char tet = '"';
					System.out.println("");
					System.out.print("Masukkan Nominal Keuangan : ");
					keuangan = in.nextInt();
					String sql1 = "update "+thisMonth+" set keuangan = "+keuangan+" where keterangan = "+tet+keterangan+tet;
					PreparedStatement ps = conn.prepareStatement(sql1);
					ps.executeUpdate();
					
                    /*String sql1 = "select * from "+thisMonth+" (keterangan) values (?)"; //HARDCODE BULAN
					ResultSet rs1 = stmt.executeQuery(sql1);
                    rs1.next();
                    String keterangan = rs1.getString("keterangan");
                    System.out.println("Masukkan budget : ");
                    budgets = in.next();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO may(keuangan) values (?) where keterangan = (keterangan)"); //PERHATIKAN HARDCODE BULAN
					ps.setString(2,keterangan);
					ps.executeUpdate();*/
					
					String sql = "select * from "+ thisMonth; 
					ResultSet rs1 = stmt.executeQuery(sql);
					System.out.println("Budget"+"	"+"keterangan"+"	  "+"tanggal");
					System.out.println("____________________________________________");
					while(rs1.next()) {
						String budgets = rs1.getString("keuangan");
						String ket = rs1.getString("keterangan");
						String tang = rs1.getString("tanggal");
						System.out.println(budgets+"	"+ket+"	  "+tang);}
					rs1.close();
                }
                else if (pilihMenu == 2){
					stmt = conn.createStatement();
					String sql = "select * from "+thisMonth; //HARDCODE BULAN
					ResultSet rs = stmt.executeQuery(sql);
					System.out.println("Budget"+"	"+"keterangan"+"	  "+"tanggal");
					System.out.println("____________________________________________");
					while(rs.next()) {
						String budgets = rs.getString("keuangan");
						String ket = rs.getString("keterangan");
						String tang = rs.getString("tanggal");
						System.out.println(budgets+"	"+ket+"	  "+tang);
						
						}
                rs.close();
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
