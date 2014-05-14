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

public class PilihanPartai implements Pilihan{
    String NIKPemilih;
    String NamaPartai;
    
    public PilihanPartai(String nikPemilih, String namaPartai)
    {
        NIKPemilih = nikPemilih;
        NamaPartai = namaPartai;
    }
    @Override
    public void addToDatabase()
    {
        try {
            Connection koneksi = KoneksiDatabase.getKoneksi();
            Statement statement = koneksi.createStatement();
            String command = "insert into PilihanPartai values ( ?, ?)";
            try (PreparedStatement p = koneksi.prepareStatement(command)) {
                p.setString(1, NIKPemilih);
                p.setString(2, NamaPartai);
                p.executeUpdate();
            }
            koneksi.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
