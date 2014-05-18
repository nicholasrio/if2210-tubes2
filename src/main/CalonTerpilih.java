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
                P.setString(5, caleg.getLingkup());
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
            String command = "Select * from Kabupaten";
            ResultSet result = statement.executeQuery(command);
            List <String> noDapil = new ArrayList<>();
            List<String> NamaKabupaten = new ArrayList<>();
            while(result.next())
            {
                Object []o = new Object[2];
                o[0] = result.getString("No_Dapil");
                o[1] = result.getString("Nama_Kabupaten");
                noDapil.add((String) o[0]);
                NamaKabupaten.add((String) o[1]);
            }
            
            if(!noDapil.isEmpty())
            {
                System.out.println("Masuk if noDapil not empty");
                int NoDapilTemp = Integer.parseInt(noDapil.get(0));
                Dapil DapilTemp = new Dapil(NoDapilTemp, NamaKabupaten.get(0));
                for(int i = 1; i < noDapil.size(); i++)
                {
                    if(isNoDapilExist(NoDapilTemp))
                    if(NoDapilTemp != Integer.parseInt(noDapil.get(i)))
                    {
                        daerahPemilihan.add(DapilTemp);
                        NoDapilTemp = Integer.parseInt(noDapil.get(i));
                        DapilTemp = new Dapil(NoDapilTemp, NamaKabupaten.get(i));
                    }
                    else
                    {
                        DapilTemp.addKabupaten(NamaKabupaten.get(i));
                    }
                }
                daerahPemilihan.add(DapilTemp);
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
    
    private boolean isNomorDapilExist(int NoDapil)
    {
        boolean ketemu = false;
        int i = 0;
        while (!ketemu && i < daerahPemilihan.size())
        {
            if(daerahPemilihan.get(i).getNoDapil() == NoDapil)
                ketemu = true;
            i++;
        }
        return ketemu;
    }
}
