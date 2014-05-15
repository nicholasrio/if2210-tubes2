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
    }
    
    public void saveToDatabase()
    {
        Connection koneksi;
        koneksi = KoneksiDatabase.getKoneksi();
        try
        {
            Statement statement = koneksi.createStatement();
            String command = "Insert into Admin values (?, ?, ?)";
            PreparedStatement P = koneksi.prepareStatement(command);
            for(Admin admin : daftaradmin)
            {
                P.setString(1, admin.getUsername());
                P.setString(2, Tools.Hashing.StringToMD5(admin.getPassword()));
                P.setString(3, Integer.toString(admin.getPeran()));
                P.executeUpdate();
            }
            P.close();
        }
        catch (SQLException ex) {
            System.out.println("Error DaftarAdmin.java" + ex.getMessage());
        }
    }
}
