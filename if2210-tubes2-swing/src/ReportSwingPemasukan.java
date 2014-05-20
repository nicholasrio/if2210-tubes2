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


public class ReportSwingPemasukan extends JFrame{

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/bima";
	public static final String USER = "root";
	public static final String PASS = "";
	public static Connection conn = null;
	public static Statement stmt = null;
	private static final long serialVersionUID = 1L;
	private static Integer peng3[] = new Integer[200];
	private static String peng4[] = new String [200];
	public static int counter = 0;

	public ReportSwingPemasukan(String applicationTitle, String chartTitle) {
		MonthlyReports2();
        // This will create the dataset 
		PieDataset dataset2 = createDataset2();
		//PieDataset dataset2 = createDataset2();
		// based on the dataset we create the chart
		JFreeChart chart2 = createChart(dataset2, chartTitle);
		// we put the chart into a panel
		ChartPanel chartPanel2 = new ChartPanel(chart2);
		// default size
		chartPanel2.setPreferredSize(new java.awt.Dimension(600,500));
		// add it to our application
		setContentPane(chartPanel2);
		
		}


	/**
     * Creates a sample dataset 
     */

	public static void MonthlyReports2(){
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
				String sql6 = new String();
				
			if (thisMonth.equals("February")){sql6 = "select keuangan, keterangan from january where keuangan >= 0 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql6 = "select keuangan, keterangan from february where keuangan >= 0 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql6 = "select keuangan, keterangan from march where keuangan >= 0 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql6 = "select keuangan, keterangan from april where keuangan >= 0 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql6 = "select keuangan, keterangan from May where keuangan >= 0 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql6 = "select keuangan, keterangan from june where keuangan >= 0 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql6 = "select keuangan, keterangan from july where keuangan >= 0 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql6 = "select keuangan, keterangan from august where keuangan >= 0 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql6 = "select keuangan, keterangan from september where keuangan >= 0 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql6 = "select keuangan, keterangan from october where keuangan >= 0 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql6 = "select keuangan, keterangan from november where keuangan >= 0 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql6 = "select keuangan, keterangan from december where keuangan >= 0 order by tanggal asc";}
			ResultSet rs6 = stmt.executeQuery(sql6);
			while(rs6.next()){
				String get5 = rs6.getString("keuangan");
				int temp5 = Integer.parseInt(get5);
				peng3[counter] = temp5;
				String get6 = rs6.getString("keterangan");
				peng4[counter] = get6;
				counter++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tutupStatement();
		tutupKoneksi();
		}
	
	
	private  static PieDataset createDataset2() {
		DefaultPieDataset result2 = new DefaultPieDataset();
	    for (int i = 0; i < counter ; i++ ){
	    	result2.setValue(peng4[i]+" "+"Rp."+peng3[i], peng3[i]);
	    }
		    return result2;  
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
        plot.setBackgroundPaint(Color.WHITE);
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
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
