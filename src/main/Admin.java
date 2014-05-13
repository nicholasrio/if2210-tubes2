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
import javax.swing.JOptionPane;


public class Admin {
    private final String Username;
    private final String Password;
    private boolean SuperAdmin;
    
    public Admin(String user, String pass, boolean superAdmin)
    {
        Username = user;
        Password = pass;
        SuperAdmin = superAdmin;
    }
    
    /**
     * Memvalidasi input dari form login admin
     * @return True jika username dan input cocok, False kalau tidak
     */
    public boolean ValidateInput(){
        Connection koneksi = KoneksiDatabase.getKoneksi();
        boolean valid = false;
        try {
            Statement statemet = koneksi.createStatement();
            String command = "SELECT * FROM Admin where username = '" + Username + "';";
            ResultSet result = statemet.executeQuery(command);
            /* Jika username terdaftar di database */
            if(result.next())
            {
                String []o = new String[2];
                o[0] = result.getString("username");
                o[1] = result.getString("password");
                if(Username.compareToIgnoreCase(o[0]) == 0  && Hashing.StringToMD5(Password).compareTo(o[1]) == 0)
                {
                    SuperAdmin = result.getInt("Peran") == 1;
                    valid = true;
                }
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return valid;
    }
    
    public boolean IsSuperAdmin(){
        return SuperAdmin;
    }
    
}
