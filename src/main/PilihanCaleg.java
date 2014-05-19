/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import Tools.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PilihanCaleg implements Pilihan{
    private String NIKCaleg;
    private String NIKPemilih;
    private String Lingkup;
    public PilihanCaleg(String NIKPemilih, String NamaCaleg, String Lingkup)
    {
        this.NIKPemilih = NIKPemilih;
        this.NIKCaleg = NIKCaleg;
        this.Lingkup = Lingkup;
    }
    @Override
    /**
     * Memasukan data berupa NIK Pemilih dan NIK Caleg yang dipilih ke database
     */
    public void addToDatabase()
    {
        try {
            Connection koneksi = KoneksiDatabase.getKoneksi();
            Statement statement = koneksi.createStatement();
            String command = "insert into PilihanCaleg values (?, ?, ?)";
            try (PreparedStatement p = koneksi.prepareStatement(command)) {
                p.setString(1, NIKPemilih);
                p.setString(2, NIKCaleg);
                p.setString(3, Lingkup);
                p.executeUpdate();
            }
            koneksi.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     /**
     *  
     * @return NIK pemilih 
     */
    public String getNIKPemilih()
    {
        return NIKPemilih;
    }
     /**
     * 
     * @return NIK Caleg
     */
    public String getNIKCaleg()
    {
        return NIKCaleg;
    }
    /**
     * 
     * @return Lingkup caleg
     */
    public String getLingkup()
    {
        return Lingkup;
    }
}
