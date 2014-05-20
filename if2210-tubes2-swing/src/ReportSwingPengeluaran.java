import java.util.*;
import java.util.Date;
import java.awt.Color;
import java.io.*;
import java.sql.*;
import java.text.*;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class ReportSwingPengeluaran extends JFrame{
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/bima";
	public static final String USER = "root";
	public static final String PASS = "";
	public static Connection conn = null;
	public static Statement stmt = null;
	private static final long serialVersionUID = 1L;
	private static Integer peng1[] = new Integer[200];
	private static String peng2[] = new String [200];
	private static int counter = 0;
	

	public ReportSwingPengeluaran(String applicationTitle, String chartTitle) {
		MonthlyReports();
        // This will create the dataset 
		PieDataset dataset1 = createDataset1();
		//PieDataset dataset2 = createDataset2();
		// based on the dataset we create the chart
		JFreeChart chart = createChart(dataset1, chartTitle);
		// we put the chart into a panel
		ChartPanel chartPanel1 = new ChartPanel(chart);
		// default size
		chartPanel1.setPreferredSize(new java.awt.Dimension(600, 500));
		// add it to our application
		setContentPane(chartPanel1);
		
		}


	/**
     * Creates a sample dataset 
     */

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
				String sql5 = new String();
				
			if (thisMonth.equals("February")){sql5 = "select keuangan, keterangan from january where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql5 = "select keuangan, keterangan from february where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql5 = "select keuangan, keterangan from march where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql5 = "select keuangan, keterangan from april where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql5 = "select keuangan, keterangan from May where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql5 = "select keuangan, keterangan from june where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql5 = "select keuangan, keterangan from july where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql5 = "select keuangan, keterangan from august where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql5 = "select keuangan, keterangan from september where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql5 = "select keuangan, keterangan from october where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql5 = "select keuangan, keterangan from november where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql5 = "select keuangan, keterangan from december where keuangan < 0 order by tanggal asc";}
			ResultSet rs5 = stmt.executeQuery(sql5);
			while(rs5.next()){
				String get1 = rs5.getString("keuangan");
				int temp = Integer.parseInt(get1);
				peng1[counter] = (-1 * temp);
				String get2 = rs5.getString("keterangan");
				peng2[counter] = get2;
				counter++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tutupStatement();
		tutupKoneksi();
		}
	
	
	private  static PieDataset createDataset1() {
		
		
	    DefaultPieDataset result1 = new DefaultPieDataset();
	    for (int i = 0; i < counter ; i++ ){
	    	result1.setValue(peng2[i]+" "+"Rp."+peng1[i], peng1[i]);
	    }
	    
		    return result1;  
		}


	/**
     * Creates a chart
     */

	private static JFreeChart createChart(PieDataset dataset, String title) {
    
	    JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
		dataset,                // data
		true,                   // include legend
	    true,
	    false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setBackgroundPaint(Color.WHITE);
        return chart;
        
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
