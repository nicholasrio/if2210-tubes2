/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import Tools.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DaftarAdmin {
    List <Admin> daftaradmin;
    public DaftarAdmin()
    {
        daftaradmin = new ArrayList<>();
        /* Kalo mau ngeload daftar username yang udah ada di database, dan mau ditampilin ke tabel, pake ini 
        try
        {
            daftaradmin = new ArrayList<>();
            Connection koneksi = KoneksiDatabase.getKoneksi();
            Statement statement = koneksi.createStatement();
            String Command = "select * from Admin";
            ResultSet result = statement.executeQuery(Command);
            while(result.next())
            {
                daftaradmin.add(new Admin(result.getString("Username"), 
                                            result.getString("Password"), 
                                            result.getString("Peran").equals("1")));
            }
        }
        catch (SQLException ex) {
            System.out.println("Error DaftarAdmin.java" + ex.getMessage());
        } */
    }
    
    public void saveToDatabase()
    {
        Connection koneksi;
        koneksi = KoneksiDatabase.getKoneksi();
        try
        {
            Statement statement = koneksi.createStatement();
            String command = "Insert into Admin values (?, ?, ?)"
                    + "on duplicate key update Password = md5(?), Peran = (?)";
            PreparedStatement P = koneksi.prepareStatement(command);
            for(Admin admin : daftaradmin)
            {
                P.setString(1, admin.getUsername());
                P.setString(2, Tools.Hashing.StringToMD5(admin.getPassword()));
                P.setString(3, Integer.toString(admin.getPeran()));
                P.setString(4, admin.getPassword());
                P.executeUpdate();
            }
            P.close();
        }
        catch (SQLException ex) {
            System.out.println("Error DaftarAdmin.java" + ex.getMessage());
        }
    }
}
