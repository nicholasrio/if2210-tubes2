
import java.util.*;
import java.util.Date;
import java.io.*;
import java.sql.*;
import java.text.*;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
	
public class ReportSwingOverall extends JFrame{
	
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/bima";
	public static final String USER = "root";
	public static final String PASS = "";
	public static Connection conn = null;
	public static Statement stmt = null;
	//overall
	public static int week1 ; 
	public static int week2 ;
	public static int week3 ;
	public static int week4 ;
	//pengeluaran
	public static int week1a ;
	public static int week2a ;
	public static int week3a ;
	public static int week4a ;
	//pemasukan
	public static int week1b ;
	public static int week2b ;
	public static int week3b ;
	public static int week4b ;
	private static final long serialVersionUID = 1L;
	static final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

	public ReportSwingOverall(String title,String categoryAxisLabel, String valueAxisLabel) {
		
        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(title,categoryAxisLabel, valueAxisLabel,dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 500));
        setContentPane(chartPanel);
    	
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
			
			if (thisMonth.equals("February")){sql1 = "select DAY(tanggal) as date , keuangan from january where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql1 = "select DAY(tanggal) as date , keuangan from february where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql1 = "select DAY(tanggal) as date , keuangan from march where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql1 = "select DAY(tanggal) as date , keuangan from april where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql1 = "select DAY(tanggal) as date , keuangan from May where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql1 = "select DAY(tanggal) as date , keuangan from june where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql1 = "select DAY(tanggal) as date , keuangan from july where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql1 = "select DAY(tanggal) as date , keuangan from august where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql1 = "select DAY(tanggal) as date , keuangan from september where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql1 = "select DAY(tanggal) as date , keuangan from october where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql1 = "select DAY(tanggal) as date , keuangan from november where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql1 = "select DAY(tanggal) as date , keuangan from december where DAY(tanggal) <= 7 and keuangan < 0 order by tanggal asc";}
			ResultSet rs8 = stmt.executeQuery(sql1);
			while(rs8.next()){
				String get1 = rs8.getString("keuangan");
				int temp1 = Integer.parseInt(get1);
				week1a = week1a + temp1 ;
			}
			
			if (thisMonth.equals("February")){sql1 = "select DAY(tanggal) as date , keuangan from january where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql1 = "select DAY(tanggal) as date , keuangan from february where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql1 = "select DAY(tanggal) as date , keuangan from march where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql1 = "select DAY(tanggal) as date , keuangan from april where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql1 = "select DAY(tanggal) as date , keuangan from May where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql1 = "select DAY(tanggal) as date , keuangan from june where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql1 = "select DAY(tanggal) as date , keuangan from july where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql1 = "select DAY(tanggal) as date , keuangan from august where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql1 = "select DAY(tanggal) as date , keuangan from september where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql1 = "select DAY(tanggal) as date , keuangan from october where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql1 = "select DAY(tanggal) as date , keuangan from november where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql1 = "select DAY(tanggal) as date , keuangan from december where DAY(tanggal) <= 7 and keuangan > 0 order by tanggal asc";}
			ResultSet rs9 = stmt.executeQuery(sql1);
			while(rs9.next()){
				String get1 = rs9.getString("keuangan");
				int temp1 = Integer.parseInt(get1);
				week1b = week1b + temp1 ;
			}
		
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
			
			if (thisMonth.equals("February")){sql1 = "select DAY(tanggal) as date , keuangan from january where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql1 = "select DAY(tanggal) as date , keuangan from february where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql1 = "select DAY(tanggal) as date , keuangan from march where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql1 = "select DAY(tanggal) as date , keuangan from april where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql1 = "select DAY(tanggal) as date , keuangan from May where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql1 = "select DAY(tanggal) as date , keuangan from june where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql1 = "select DAY(tanggal) as date , keuangan from july where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql1 = "select DAY(tanggal) as date , keuangan from august where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql1 = "select DAY(tanggal) as date , keuangan from september where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql1 = "select DAY(tanggal) as date , keuangan from october where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql1 = "select DAY(tanggal) as date , keuangan from november where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql1 = "select DAY(tanggal) as date , keuangan from december where DAY(tanggal) <= 14 and keuangan < 0 order by tanggal asc";}
			ResultSet rs10 = stmt.executeQuery(sql1);
			while(rs10.next()){
				String get1 = rs10.getString("keuangan");
				int temp1 = Integer.parseInt(get1);
				week2a = week2a + temp1 ;
			}
			
			if (thisMonth.equals("February")){sql1 = "select DAY(tanggal) as date , keuangan from january where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql1 = "select DAY(tanggal) as date , keuangan from february where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql1 = "select DAY(tanggal) as date , keuangan from march where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql1 = "select DAY(tanggal) as date , keuangan from april where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql1 = "select DAY(tanggal) as date , keuangan from May where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql1 = "select DAY(tanggal) as date , keuangan from june where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql1 = "select DAY(tanggal) as date , keuangan from july where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql1 = "select DAY(tanggal) as date , keuangan from august where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql1 = "select DAY(tanggal) as date , keuangan from september where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql1 = "select DAY(tanggal) as date , keuangan from october where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql1 = "select DAY(tanggal) as date , keuangan from november where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql1 = "select DAY(tanggal) as date , keuangan from december where DAY(tanggal) <= 14 and keuangan > 0 order by tanggal asc";}
			ResultSet rs11 = stmt.executeQuery(sql1);
			while(rs11.next()){
				String get1 = rs11.getString("keuangan");
				int temp1 = Integer.parseInt(get1);
				week2b = week2b + temp1 ;
			}
			
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
			
			if (thisMonth.equals("February")){sql1 = "select DAY(tanggal) as date , keuangan from january where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql1 = "select DAY(tanggal) as date , keuangan from february where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql1 = "select DAY(tanggal) as date , keuangan from march where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql1 = "select DAY(tanggal) as date , keuangan from april where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql1 = "select DAY(tanggal) as date , keuangan from May where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql1 = "select DAY(tanggal) as date , keuangan from june where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql1 = "select DAY(tanggal) as date , keuangan from july where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql1 = "select DAY(tanggal) as date , keuangan from august where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql1 = "select DAY(tanggal) as date , keuangan from september where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql1 = "select DAY(tanggal) as date , keuangan from october where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql1 = "select DAY(tanggal) as date , keuangan from november where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql1 = "select DAY(tanggal) as date , keuangan from december where DAY(tanggal) <= 21 and keuangan < 0 order by tanggal asc";}
			ResultSet rs12 = stmt.executeQuery(sql1);
			while(rs12.next()){
				String get1 = rs12.getString("keuangan");
				int temp1 = Integer.parseInt(get1);
				week3a = week3a + temp1 ;
			}
			
			if (thisMonth.equals("February")){sql1 = "select DAY(tanggal) as date , keuangan from january where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql1 = "select DAY(tanggal) as date , keuangan from february where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql1 = "select DAY(tanggal) as date , keuangan from march where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql1 = "select DAY(tanggal) as date , keuangan from april where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql1 = "select DAY(tanggal) as date , keuangan from May where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql1 = "select DAY(tanggal) as date , keuangan from june where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql1 = "select DAY(tanggal) as date , keuangan from july where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql1 = "select DAY(tanggal) as date , keuangan from august where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql1 = "select DAY(tanggal) as date , keuangan from september where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql1 = "select DAY(tanggal) as date , keuangan from october where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql1 = "select DAY(tanggal) as date , keuangan from november where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql1 = "select DAY(tanggal) as date , keuangan from december where DAY(tanggal) <= 21 and keuangan > 0 order by tanggal asc";}
			ResultSet rs13 = stmt.executeQuery(sql1);
			while(rs13.next()){
				String get1 = rs13.getString("keuangan");
				int temp1 = Integer.parseInt(get1);
				week3b = week3b + temp1 ;
			}
			
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
			
			if (thisMonth.equals("February")){sql4 = "select keuangan from january where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql4 = "select keuangan from february where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql4 = "select keuangan from march where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql4 = "select keuangan from april where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql4 = "select keuangan from May where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql4 = "select keuangan from june where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql4 = "select keuangan from july where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql4 = "select keuangan from august where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql4 = "select keuangan from september where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql4 = "select keuangan from october where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql4 = "select keuangan from november where keuangan < 0 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql4 = "select keuangan from december where keuangan < 0 order by tanggal asc";}
			ResultSet rs14 = stmt.executeQuery(sql4);
			while(rs14.next()){
				String get1 = rs14.getString("keuangan");
				int temp = Integer.parseInt(get1);
				week4a = week4a + temp ;
			}
			
			if (thisMonth.equals("February")){sql4 = "select keuangan from january where keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("March")){sql4 = "select keuangan from february where keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("April")){sql4 = "select keuangan from march where keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("May")){sql4 = "select keuangan from april where keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("June")){sql4 = "select keuangan from May where keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("July")){sql4 = "select keuangan from june where keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("August")){sql4 = "select keuangan from july where keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("September")){sql4 = "select keuangan from august where keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("October")){sql4 = "select keuangan from september where keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("November")){sql4 = "select keuangan from october where keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("December")){sql4 = "select keuangan from november where keuangan > 0 order by tanggal asc";}
			else if (thisMonth.equals("January")){sql4 = "select keuangan from december where keuangan > 0 order by tanggal asc";}
			ResultSet rs15 = stmt.executeQuery(sql4);
			while(rs15.next()){
				String get1 = rs15.getString("keuangan");
				int temp = Integer.parseInt(get1);
				week4b = week4b + temp ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tutupStatement();
		tutupKoneksi();
		System.out.println(week1);
		System.out.println(week2);
		System.out.println(week3);
		System.out.println(week4);
		}
	
	

	static private CategoryDataset createDataset() {
		MonthlyReports();
		
        dataset.addValue(week1, "Balance", "Week 1");
        dataset.addValue(week2, "Balance", "Week 2");
        dataset.addValue(week3, "Balance", "Week 3");
        dataset.addValue(week4, "Balance", "Week 4");

        dataset.addValue(week1a, "Pengeluaran", "Week 1");
        dataset.addValue(week2a, "Pengeluaran", "Week 2");
        dataset.addValue(week3a, "Pengeluaran", "Week 3");
        dataset.addValue(week4a, "Pengeluaran", "Week 4");

        dataset.addValue(week1b, "Pemasukan", "Week 1");
        dataset.addValue(week2b, "Pemasukan", "Week 2");
        dataset.addValue(week3b, "Pemasukan", "Week 3");
        dataset.addValue(week4b, "Pemasukan", "Week 4");
       
        return dataset;
               
    }
 
 private static JFreeChart createChart(String title,String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset) {
       
        JFreeChart jfreechart = ChartFactory.createLineChart3D(title, categoryAxisLabel, valueAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, true);
        jfreechart.setBackgroundPaint(Color.WHITE);
       
        CategoryPlot categoryplot = jfreechart.getCategoryPlot();
        categoryplot.setBackgroundPaint(new Color(238, 238, 255));
        categoryplot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
               
        //Manages the Domain(x-axis) label position
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
    
        return jfreechart;
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