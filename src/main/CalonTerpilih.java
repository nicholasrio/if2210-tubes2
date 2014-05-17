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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author akhfa
 */
public class CalonTerpilih {
    private List<Dapil> daerahPemilihan;
    private List<Caleg> daftarCaleg;
    
    public CalonTerpilih()
    {
        daerahPemilihan = new ArrayList<>();
        daftarCaleg = new ArrayList<>();
    }
    public void AddCaleg(String NIK, String Nama, String Partai,String History, int _NoDapil, String lingkup){
        //Jangan lupa pengecekan udah ada Caleg apa belum
        Caleg caleg = new Caleg(NIK, Nama, Partai, History, _NoDapil, lingkup);
        daftarCaleg.add(caleg);
    }
    
    public void AddCaleg(Caleg caleg){
        //Jangan lupa pengecekan udah ada Caleg apa belum
        daftarCaleg.add(caleg);
    }
    
    public void AddDapil(int NomorDapil, String Kabupaten[]){
        //Jangan lupa pengecekan noDapilnya udah ada apa belum
        Dapil dapil = new Dapil(NomorDapil, Kabupaten[0]);
        for(int i =1; i<Kabupaten.length;i++){
            dapil.addKabupaten(Kabupaten[i]);
        }
        daerahPemilihan.add(dapil);
    }
    
    public void AddDapil(Dapil dapil){
        //Jangan lupa pengecekan noDapilnya udah ada apa belum
        daerahPemilihan.add(dapil);
    }
    
    
    /**
     * Menyimpan list dapil dan list caleg ke database. Isi list harus sudah unik dan belum ada di database.
     */
    public void SaveToDatabase(){
        if(daftarCaleg.size() == 0)
        {
            saveDapilToDatabase();
        }
        else if(daerahPemilihan.size() == 0)
        {
            saveCalegToDatabase();
        }
        else
        {
            saveCalegToDatabase();
            saveDapilToDatabase();
        }
    }
    
    /**
     * Menyimpan List of dapil ke database. List sudah unik.
     */
    private void saveDapilToDatabase()
    {
        Connection koneksi;
        koneksi = KoneksiDatabase.getKoneksi();
        try
        {
            Statement statement = koneksi.createStatement();
            String command1 = "Insert into Dapil values (?)";
            String command2 = "Insert into Kabupaten values (?, ?)";
            PreparedStatement P1 = koneksi.prepareStatement(command1);
            PreparedStatement P2 = koneksi.prepareStatement(command2);
            List<String> daftarKabupaten = new ArrayList<>();
            for(Dapil dapil : daerahPemilihan)
            {
                P1.setString(1, Integer.toString(dapil.getNoDapil()));
                daftarKabupaten = dapil.getDaftarKabupaten();
                for(String kabupaten : daftarKabupaten)
                {
                    P1.setString(1, Integer.toString(dapil.getNoDapil()));
                    P2.setString(2, kabupaten);
                }
                
                P1.executeUpdate();
                P2.executeUpdate();
            }
            P1.close();
            P2.close();
        }
        catch (SQLException ex) {
            System.out.println("Error CalonTerpilih.java: " + ex.getMessage());
        }
    }
    
    /**
     * Menyimpan List of Caleg ke database. List sudah unik dan belum ada di database.
     */
    private void saveCalegToDatabase()
    {
        Connection koneksi;
        koneksi = KoneksiDatabase.getKoneksi();
        try
        {
            Statement statement = koneksi.createStatement();
            String command = "Insert into Dapil values (?, ?, ?, ?, ?)";
            PreparedStatement P = koneksi.prepareStatement(command);
            for(Caleg caleg : daftarCaleg)
            {
                P.setString(1, caleg.GetNIK());
                P.setString(2, caleg.GetPartai());
                P.setString(3, caleg.GetHistory());
                P.setString(4, Integer.toString(caleg.GetDapil()));
                P.setString(5, caleg.getLingkup());
                P.executeUpdate();
            }
            P.close();
        }
        catch (SQLException ex) {
            System.out.println("Error CalonTerpilih.java: " + ex.getMessage());
        }
    }
    
    
}
