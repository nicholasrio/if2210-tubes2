import java.util.*;
import java.util.Date;
import java.io.*;
import java.sql.*;
import java.text.*;

public class Report {
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/bima";
	public static final String USER = "root";
	public static final String PASS = "";
	public static Connection conn = null;
	public static Statement stmt = null;
	public static int week1 = 0;
	public static int week2 = 0;
	public static int week3 = 0;
	public static int week4 = 0;
	
	public Report(){
		MonthlyReports();
	}
	
	public static void MonthlyReports(){
		regJDBCException();
		openConn();
		try {
			System.out.print("Laporan keuangan : ");
			stmt = conn.createStatement();
				Date date = new Date();
				SimpleDateFormat month ;
				month = new SimpleDateFormat("MMMM");
				String thisMonth = month.format(date);
				//String thisMonth = "March";
				String sql1 = new String();
				String sql2 = new String();
				String sql3 = new String();
				String sql4 = new String();
				
				System.out.println(thisMonth);
				System.out.println("");

		//Week 1
			if (thisMonth.equals("February")){sql1 = "select DAY(tanggal) as date , keuangan from january where DAY(tanggal) <= 7 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql1 = "select DAY(tanggal) as date , keuangan from february where DAY(tanggal) <= 7 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql1 = "select DAY(tanggal) as date , keuangan from march where DAY(tanggal) <= 7 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql1 = "select DAY(tanggal) as date , keuangan from april where DAY(tanggal) <= 7 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql1 = "select DAY(tanggal) as date , keuangan from May where DAY(tanggal) <= 7 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql1 = "select DAY(tanggal) as date , keuangan from june where DAY(tanggal) <= 7 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql1 = "select DAY(tanggal) as date , keuangan from july where DAY(tanggal) <= 7 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql1 = "select DAY(tanggal) as date , keuangan from august where DAY(tanggal) <= 7 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql1 = "select DAY(tanggal) as date , keuangan from september where DAY(tanggal) <= 7 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql1 = "select DAY(tanggal) as date , keuangan from october where DAY(tanggal) <= 7 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql1 = "select DAY(tanggal) as date , keuangan from november where DAY(tanggal) <= 7 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql1 = "select DAY(tanggal) as date , keuangan from december where DAY(tanggal) <= 7 order by tanggal asc";}
			ResultSet rs = stmt.executeQuery(sql1);
			while(rs.next()){
				String get1 = rs.getString("keuangan");
				int temp1 = Integer.parseInt(get1);
				week1 = week1 + temp1 ;
			}
			//week1 = -276500;
			System.out.println("        |");
			System.out.print(" Week 1 ");
			LineGraph(week1);
		//Week 2
			if (thisMonth.equals("February")){sql2 = "select DAY(tanggal) as date , keuangan from january where DAY(tanggal) <= 14 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql2 = "select DAY(tanggal) as date , keuangan from february where DAY(tanggal) <= 14 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql2 = "select DAY(tanggal) as date , keuangan from march where DAY(tanggal) <= 14 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql2 = "select DAY(tanggal) as date , keuangan from april where DAY(tanggal) <= 14 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql2 = "select DAY(tanggal) as date , keuangan from May where DAY(tanggal) <= 14 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql2 = "select DAY(tanggal) as date , keuangan from june where DAY(tanggal) <= 14 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql2 = "select DAY(tanggal) as date , keuangan from july where DAY(tanggal) <= 14 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql2 = "select DAY(tanggal) as date , keuangan from august where DAY(tanggal) <= 14 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql2 = "select DAY(tanggal) as date , keuangan from september where DAY(tanggal) <= 14 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql2 = "select DAY(tanggal) as date , keuangan from october where DAY(tanggal) <= 14 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql2 = "select DAY(tanggal) as date , keuangan from november where DAY(tanggal) <= 14 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql2 = "select DAY(tanggal) as date , keuangan from december where DAY(tanggal) <= 14 order by tanggal asc";}
			ResultSet rs2 = stmt.executeQuery(sql2);
			while(rs2.next()){
				String get = rs2.getString("keuangan");
				int temp = Integer.parseInt(get);
				week2 = week2 + temp ;
			}
			//week2 = 198000;
			System.out.println("        |");
			System.out.print(" Week 2 ");
			LineGraph(week2);
		//Week 3
			if (thisMonth.equals("February")){sql3 = "select DAY(tanggal) as date , keuangan from january where DAY(tanggal) <= 21 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql3 = "select DAY(tanggal) as date , keuangan from february where DAY(tanggal) <= 21 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql3 = "select DAY(tanggal) as date , keuangan from march where DAY(tanggal) <= 21 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql3 = "select DAY(tanggal) as date , keuangan from april where DAY(tanggal) <= 21 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql3 = "select DAY(tanggal) as date , keuangan from May where DAY(tanggal) <= 21 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql3 = "select DAY(tanggal) as date , keuangan from june where DAY(tanggal) <= 21 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql3 = "select DAY(tanggal) as date , keuangan from july where DAY(tanggal) <= 21 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql3 = "select DAY(tanggal) as date , keuangan from august where DAY(tanggal) <= 21 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql3 = "select DAY(tanggal) as date , keuangan from september where DAY(tanggal) <= 21 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql3 = "select DAY(tanggal) as date , keuangan from october where DAY(tanggal) <= 21 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql3 = "select DAY(tanggal) as date , keuangan from november where DAY(tanggal) <= 21 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql3 = "select DAY(tanggal) as date , keuangan from december where DAY(tanggal) <= 21 order by tanggal asc";}
			ResultSet rs3 = stmt.executeQuery(sql3);
			while(rs3.next()){
				String get = rs3.getString("keuangan");
				int temp = Integer.parseInt(get);
				week3 = week3 + temp ;
			}
			//week3 = -24939;
			System.out.println("        |");
			System.out.print(" Week 3 ");
			LineGraph(week3);
		//Week 4
			if (thisMonth.equals("February")){sql4 = "select keuangan from january order by tanggal asc";}
			else if (thisMonth.equals("March")){sql4 = "select keuangan from february order by tanggal asc";}
			else if (thisMonth.equals("April")){sql4 = "select keuangan from march order by tanggal asc";}
			else if (thisMonth.equals("May")){sql4 = "select keuangan from april order by tanggal asc";}
			else if (thisMonth.equals("June")){sql4 = "select keuangan from May order by tanggal asc";}
			else if (thisMonth.equals("July")){sql4 = "select keuangan from june order by tanggal asc";}
			else if (thisMonth.equals("August")){sql4 = "select keuangan from july order by tanggal asc";}
			else if (thisMonth.equals("September")){sql4 = "select keuangan from august order by tanggal asc";}
			else if (thisMonth.equals("October")){sql4 = "select keuangan from september order by tanggal asc";}
			else if (thisMonth.equals("November")){sql4 = "select keuangan from october order by tanggal asc";}
			else if (thisMonth.equals("December")){sql4 = "select keuangan from november order by tanggal asc";}
			else if (thisMonth.equals("January")){sql4 = "select keuangan from december order by tanggal asc";}
			ResultSet rs4 = stmt.executeQuery(sql4);
			while(rs4.next()){
				String get1 = rs4.getString("keuangan");
				int temp = Integer.parseInt(get1);
				week4 = week4 + temp ;
			}
			//week4 = 109232;
			System.out.println("        |");
			System.out.print(" Week 4 ");
			LineGraph(week4);
			System.out.println("        |_____________________________________________________________________________");
			System.out.println("         -300  -250  -200  -150  -100   -50    0     50   100   150   200   250   300");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tutupStatement();
		tutupKoneksi();
		System.out.println("");
		System.out.println("Week 1 :"+week1);
		System.out.println("Week 2 :"+week2);
		System.out.println("Week 3 :"+week3);
		System.out.println("Week 4 :"+week4);
		}
	
	public static void LineGraph(int a){
		if (a <= -287500){ //-300
			System.out.println("|===");
		}
		else if ((a > -287500) && (a <= -262500)){ //-275
			System.out.println("|======");
			}
		else if ((a > -262500) && (a <= -237500)){ //-250
			System.out.println("|=========");
			}
		else if ((a > -237500) && (a <= -212500)){ //-225
			System.out.println("|============");
			}
		else if ((a > -212500) && (a <= -187500)){ //-200
			System.out.println("|===============");
			}
		else if ((a > -187500) && (a <= -162500)){ //-175
			System.out.println("|==================");
			}
		else if ((a > -162500) && (a <= -137500)){ //-150
			System.out.println("|=====================");
			}
		else if ((a > -137500) && (a <= -112500)){ //-125
			System.out.println("|========================");
			}
		else if ((a > -112500) && (a <= -87500)){ //-100
			System.out.println("|===========================");
			}
		else if ((a > -87500) && (a <= -62500)){ //-75
			System.out.println("|==============================");
			}
		else if ((a > -62500) && (a <= -37500)){ //-50
			System.out.println("|=================================");
			}
		else if ((a > -37500) && (a <= -12500)){ //-25
			System.out.println("|====================================");
			}
		else if ((a > 12500) && (a <= 12500)){ //0
			System.out.println("|=======================================");
			}
		else if (( a > 12500) && (a <= 37500)){ //25
			System.out.println("|==========================================");
			}
		else if ((a > 37500) && (a <= 62500)){ //50
			System.out.println("|=============================================");
			}
		else if ((a > 62500) && (a <= 87500)){ //75
			System.out.println("|================================================");
			}
		else if ((a > 87500) && (a <= 112500)){ //100
			System.out.println("|===================================================");
			}
		else if ((a > 112500) && (a <= 137500)){ //125 
			System.out.println("|======================================================");
			}
		else if ((a > 137500) && (a <= 162500)){ //150
			System.out.println("|=========================================================");
			}
		else if ((a > 162500) && (a <= 187500)){ //175 
			System.out.println("|============================================================");
			}
		else if ((a > 187500) && (a <= 212500)){ //200
			System.out.println("|===============================================================");
			}
		else if ((a > 212500) && (a <= 237500)){ //225 
			System.out.println("|==================================================================");
			}
		else if ((a > 237500) && (a <= 262500)){ //250
			System.out.println("|=====================================================================");
			}
		else if ((a > 262500) && (a <= 287500)){ //275 
			System.out.println("|========================================================================");
			}
		else if (a > 287500){  //300
			System.out.println("|===========================================================================");
			}
	}
	
	public static void regJDBCException(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			System.out.println("Kelas tidak ditemukan " + e);
		}
	}
	
	public static void openConn(){
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}
		catch(SQLException e){
			System.out.println("Tidak bisa menutup konektivitas " + e);
		}
	}
	
	public static void tutupStatement(){
		try{
			if(stmt != null) conn.close();
		}
		catch(SQLException e){
			System.out.println("Gagal menutup statement " + e);
		}	
	}
	
	public static void tutupKoneksi(){
		try{
			if(conn != null) conn.close();
		}
		catch(SQLException e){
			System.out.println("Gagal menutup konektivitas " + e);
		}
	}
	
}
