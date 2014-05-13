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


public class Pemilih {
    private String NIK;
    private String Password;
    
    /**
     * Mengecek apakah NIK dan Password Penduduk valid, termasuk apakah sudah mencoblos atau belum.
     * @return Return true jika NIK dan Password valid, serta belum mencoblos.
     */
    public boolean ValidateInput(){
        Connection koneksi = KoneksiDatabase.getKoneksi();
        boolean valid = false;
        try {
            Statement statemet = koneksi.createStatement();
            String command = "SELECT * FROM Pemilih where NIKPemilih = '" + NIK + "';";
            ResultSet result = statemet.executeQuery(command);
            while (result.next())
            {
                String []o = new String[2];
                o[0] = result.getString("NIKPemilih");
                o[1] = result.getString("Password");
                /* Jika NIK dan Password cocok */
                if(NIK.compareToIgnoreCase(o[0]) == 0  && Hashing.StringToMD5(Password).compareTo(o[1]) == 0)
                {
                    command = "SELECT * FROM PilihanCaleg where NIKPemilih = '" + NIK + "';";
                    result = statemet.executeQuery(command);
                    if(!result.next()) /* Jika belum memilih partai */
                    {
                        command = "SELECT * FROM PilihanPartai where NIKPemilih = '" + NIK + "';";
                        result = statemet.executeQuery(command);
                        if(!result.next()) /* dan jika belum memilih caleg */
                            valid = true;
                    }
                    
                }
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return valid;
    }
    
    public int GetDapil(){
        return 1;
    }
    
}
