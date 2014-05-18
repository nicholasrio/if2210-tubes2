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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        LoadDapilFromDatabaseToList();
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
        if(daerahPemilihan.size() != 0 && daftarCaleg.size() == 0)
        {
            saveDapilToDatabase();
        }
        else if(daftarCaleg.size() != 0 && daerahPemilihan.size() == 0)
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
            String command1 = "Insert ignore into Dapil values (?)";
            String command2 = "Insert into Kabupaten values (?, ?)";
            String commandCheckExist = "Select Nama_Kabupaten from Kabupaten "
                    + "where Nama_Kabupaten = ?";
            PreparedStatement P1 = koneksi.prepareStatement(command1);
            PreparedStatement P2 = koneksi.prepareStatement(command2);
            PreparedStatement PCheck = koneksi.prepareStatement(commandCheckExist);
            List<String> daftarKabupaten = new ArrayList<>();
            for(Dapil dapil : daerahPemilihan)
            {
                P1.setString(1, Integer.toString(dapil.getNoDapil()));
                P1.executeUpdate();
                daftarKabupaten = dapil.getDaftarKabupaten();
                int i = 0;
                for(String kabupaten : daftarKabupaten)
                {
                    PCheck.setString(1, kabupaten);
                    ResultSet result = PCheck.executeQuery();
                    if(!result.next())
                    {
                        P2.setString(1, Integer.toString(dapil.getNoDapil()));
                        P2.setString(2, kabupaten);
                        P2.executeUpdate();
                    }
                    
                }
                
            }
            P1.close();
            P2.close();
            daerahPemilihan = new ArrayList<>();
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
                P.setString(5, caleg.GetLingkup());
                P.executeUpdate();
            }
            P.close();
        }
        catch (SQLException ex) {
            System.out.println("Error CalonTerpilih.java: " + ex.getMessage());
        }
    }
    
    private void LoadDapilFromDatabaseToList()
    {
        System.out.println("LoadDapilFromDatabaseToList");
        try {
            Connection koneksi;
            koneksi = KoneksiDatabase.getKoneksi();
            
            Statement statement = koneksi.createStatement();
            String commandNoDapil = "select Max(No_Dapil) from Dapil";
            ResultSet resultNoDapilMaks = statement.executeQuery(commandNoDapil);
            if(resultNoDapilMaks.next())
            {
                int NoDapilMaksimum = Integer.parseInt(resultNoDapilMaks.getString(1));
            
                /* Mengambil kabupaten tiap dapil secara urut */
                String command = "Select * from Kabupaten where No_Dapil = ?";
                for(int i = 0; i < NoDapilMaksimum; i++)
                {
                    PreparedStatement P = koneksi.prepareStatement(command);
                    P.setString(1, "" + (i+1));
                    ResultSet result = P.executeQuery();
                    Dapil Temp = new Dapil(i+1);
                    while(result.next())
                    {
                        Temp.addKabupaten(result.getString("Nama_Kabupaten"));
                    }
                    daerahPemilihan.add(Temp);
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CalonTerpilih.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Mendapatkan daftar dapil
     * @return List <Dapil>
     */
    public List<Dapil> getDapil()
    {
        return daerahPemilihan;
    }
    
    /**
     * Mendapatkan daftarCaleg
     * @return List<Caleg>
     */
    public List<Caleg> getDaftarCaleg()
    {
        return daftarCaleg;
    }
}
