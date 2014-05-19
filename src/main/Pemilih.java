/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import Tools.Hashing;
import Tools.KoneksiDatabase;
import Tools.PasswordErrorException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Pemilih {
    private String NIK;
    private String Password;
    private int NoDapil;
    boolean statusMemilih[];
    public Pemilih(String nik, String password){
        NIK = nik;
        Password = Hashing.StringToMD5(password);
        getNoDapilFromDatabase();
        LoadStatusMemilihDariDatabase();
        statusMemilih[1] = true;
    }
    
    /**
     * Mengecek apakah NIK dan Password Penduduk valid, termasuk apakah sudah mencoblos atau belum.
     * @return Return true jika NIK dan Password valid, serta belum mencoblos.
     * @throws Tools.PasswordErrorException
     */
    public boolean ValidateInput() throws PasswordErrorException{
        Connection koneksi = KoneksiDatabase.getKoneksi();
        boolean valid = false;
        try {
            Statement statement = koneksi.createStatement();
            String command = "SELECT * FROM Pemilih where NIKPemilih = '" + NIK + "'";
            ResultSet result = statement.executeQuery(command);
            if (result.next())
            {
                String []o = new String[2];
                o[0] = result.getString("NIKPemilih");
                o[1] = result.getString("Password");
                /* Jika NIK dan Password cocok, cek di database pemilihan partai, sudah 4 kali memilih atau belum */
                if(NIK.equals(o[0])  && Password.equals(o[1]))
                {
                    boolean sudahPilihDPR = false,
                            sudahPilihDPD = false,
                            sudahPilihDPRDProp = false, 
                            sudahPilihDPRDKab = false;
                    command = "SELECT Lingkup FROM PilihanPartai where NIKPemilih = '" + NIK + "'";
                    result = statement.executeQuery(command);
                    while(result.next())
                    {
                        String s;
                        s = result.getString(1);
                        if(s.equals("DPR"))
                        {
                            sudahPilihDPR = true;
                        }
                        else if (s.equals("DPD"))
                        {
                            sudahPilihDPD = true;
                        }
                        else if(s.equals("DPRDKabupaten"))
                        {
                            sudahPilihDPRDKab = true;
                        }
                        else if(s.equals("DPRDProvinsi"))
                        {
                            sudahPilihDPRDProp = true;
                        }
                    }
                    if(!sudahPilihDPD || !sudahPilihDPR || !sudahPilihDPRDKab || !sudahPilihDPRDProp)
                        valid = true;
                }
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if(!valid)
            throw new PasswordErrorException();
        else
            return valid;
    }
    
    public int GetDapil(){
        return NoDapil;
    }
    
    public String GetNIK(){
        return NIK;
    }
    
    /**
     * @return Array of boolean statusMemilih 
     */
    public boolean[] getStatusMemilih(){
        return statusMemilih;
    }
    
    /**
     * Mengecek di database apakah orang dengan NIK sekian sudah memilih DPR, DPD, DPRD Kabupaten, dan DPRD Provinsi. 
     * Mengisi attribute statusMemilih.
     * statusMemilih[0] = DPR
     * statusMemilih[0] = DPD
     * statusMemilih[0] = DPRD Provinsi
     * statusMemilih[0] = DPRD Kabupaten
     */
    
    private void LoadStatusMemilihDariDatabase()
    {
        statusMemilih = new boolean[4];
        try {
            Connection koneksi = KoneksiDatabase.getKoneksi();
            Statement statement = koneksi.createStatement();
            String command = "SELECT Lingkup FROM PilihanPartai where NIKPemilih = '" + NIK + "'";
            ResultSet result = statement.executeQuery(command);
            while(result.next())
            {
                String s;
                s = result.getString(1);
                if(s.equals("DPR"))
                {
                    statusMemilih[0] = true;
                }
                else if (s.equals("DPD"))
                {
                    statusMemilih[1] = true;
                }
                else if(s.equals("DPRDProvinsi"))
                {
                    statusMemilih[2] = true;
                }
                else if(s.equals("DPRDKabupaten"))
                {
                    statusMemilih[3] = true;
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pemilih.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getNoDapilFromDatabase()
    {
        try {
            Connection koneksi = KoneksiDatabase.getKoneksi();
            Statement statement = koneksi.createStatement();
            String command = "select Kabupaten.No_Dapil from Kabupaten "
                    + "where Nama_Kabupaten =  "
                    + "(select Penduduk.Kabupaten from Penduduk where NIK = '" + NIK + "')";
            ResultSet result = statement.executeQuery(command);
            if(result.next())
            {
                NoDapil = Integer.parseInt(NIK);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pemilih.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, ""+NoDapil);
    }
}
