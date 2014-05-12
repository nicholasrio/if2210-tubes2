/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author akhfa
 */
public class KoneksiDatabase {
    private static Connection koneksi;
    
    public static Connection getKoneksi(){
        if(koneksi == null)
        {
            try
            {
                //String url = "http://localhost/phpmyadmin/index.php?db=UNIVERSITAS";
                String url = "jdbc:mysql://localhost:3306/YukCoblos";
                String user = "root";
                String password = "akhfa";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                koneksi = DriverManager.getConnection(url, user, password);
            }
            catch(SQLException t)
            {
                System.out.println("Error Membuat Koneksi");
            }
        }
        else
        {
            System.out.println("tersambung dengan mysql");            
        }
        return koneksi;
        
    }
    
}
