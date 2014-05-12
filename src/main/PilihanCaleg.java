/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PilihanCaleg implements Pilihan{
    String NIKCaleg;
    String NIKPemilih;
    @Override
    public void addToDatabase()
    {
        try {
            Connection koneksi = KoneksiDatabase.getKoneksi();
            Statement statement = koneksi.createStatement();
            String command = "insert into PilihanCaleg values ( ?, ?)";
            try (PreparedStatement p = koneksi.prepareStatement(command)) {
                p.setString(1, NIKPemilih);
                p.setString(2, NIKCaleg);
                p.executeUpdate();
            }
            koneksi.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
