/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Admin {
    private String Username;
    private String Password;
    private boolean SuperAdmin;
    
    /**
     * Memvalidasi input dari form login admin
     * @return True jika username dan input cocok, False kalau tidak
     */
    public boolean ValidateInput(){
        Connection koneksi = KoneksiDatabase.getKoneksi();
        try {
            Statement statemet = koneksi.createStatement();
            String command = "SELECT * FROM Admin where username = '" + Username + "';";
            ResultSet result = statemet.executeQuery(command);
            String []o = new String[2];
            o[0] = result.getString("username");
            o[1] = result.getString("password");
            if(Username.compareToIgnoreCase(o[0]) == 0  && Hashing.StringToMD5(Password).compareTo(o[1]) == 0)
                SuperAdmin = result.getInt("Peran") == 1;
            else
                JOptionPane.showMessageDialog(null, "username dan password tidak cocok");
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    public boolean IsSuperAdmin(){
        return SuperAdmin;
    }
    
}
