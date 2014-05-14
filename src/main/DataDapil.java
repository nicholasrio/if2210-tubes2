/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author linda.sekawati
 */
public class DataDapil {
    private static Connection koneksi;
    public static Connection getKoneksi(){
        if(koneksi == null)
        {
            try
            {
                String url = "jdbc:mysql://localhost:3306/UNIVERSITAS";
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
