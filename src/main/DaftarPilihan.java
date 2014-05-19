/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import Tools.KoneksiDatabase;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Sakurai
 */
public class DaftarPilihan {
    private ArrayList<Caleg> DaftarCalegDPR;
    private ArrayList<Caleg> DaftarCalegDPD;
    private ArrayList<Caleg> DaftarCalegDPRDProvinsi;
    private ArrayList<Caleg> DaftarCalegDPRDKabupaten;
    private ArrayList<String> DaftarPartai;
    
    /**
     * CTOR memiliki parameter No Dapil. CTOR memasukkan Daftar Caleg DPR, DPD, DPRD Provinsi dan DPRD Kabupaten
     * dari database ke dalam array berdasarkan No Dapil input.
    */
    public DaftarPilihan(int Dapil){
        DaftarCalegDPR = new ArrayList<>();
        DaftarCalegDPD = new ArrayList<>();
        DaftarCalegDPRDProvinsi = new ArrayList<>();
        DaftarCalegDPRDKabupaten = new ArrayList<>();
        /* Load database */
        try {
            Connection koneksi = KoneksiDatabase.getKoneksi();
            Statement statement = koneksi.createStatement();
            // Mengambil data Caleg 1 dari database lalu memasukkan ke array list DaftarCalegDPR
            String commandEkstrakCalegDPR = "select Caleg.*, Penduduk.Nama "
                    + "from Caleg, Penduduk "
                    + "where Caleg.NIKCaleg = Penduduk.NIK and Lingkup = \'DPR\'";
            ResultSet CalegDPR = statement.executeQuery(commandEkstrakCalegDPR);
            while(CalegDPR.next()){
                String NIK = CalegDPR.getString("NIK");
                String NamaPartai = CalegDPR.getString("NamaPartai");
                String TrackRecord = CalegDPR.getString("TrackRecord");
                int NoDapil = CalegDPR.getInt("NoDapil");
                String nama = CalegDPR.getString("Nama");
                DaftarCalegDPR.add(new Caleg(NIK, NamaPartai, TrackRecord, NoDapil,"DPR"));
            }
            // Mengambil data Caleg 2 dari database lalu memasukkan ke array list DaftarCalegDPD
            String commandEkstrakCalegDPD = "select Caleg.*, Penduduk.Nama "
                    + "from Caleg, Penduduk "
                    + "where Caleg.NIKCaleg = Penduduk.NIK and Lingkup = \'DPD\'";
            ResultSet CalegDPD = statement.executeQuery(commandEkstrakCalegDPD);
            while(CalegDPD.next()){
                String NIK = CalegDPD.getString("NIK");
                String NamaPartai = CalegDPD.getString("NamaPartai");
                String TrackRecord = CalegDPD.getString("TrackRecord");
                int NoDapil = CalegDPD.getInt("NoDapil");
                String nama = CalegDPD.getString("Nama");
                DaftarCalegDPD.add(new Caleg(NIK, NamaPartai, TrackRecord, NoDapil,"DPD"));
            }
            // Mengambil data Caleg 3 dari database lalu memasukkan ke array list DaftarCalegDPRDProvinsi
            String commandEkstrakCalegDPRDProvinsi = "select Caleg.*, Penduduk.Nama "
                    + "from Caleg, Penduduk "
                    + "where Caleg.NIKCaleg = Penduduk.NIK and Lingkup = \'DPRDProvinsi\'";
            ResultSet CalegDPRDProvinsi = statement.executeQuery(commandEkstrakCalegDPRDProvinsi);
            while(CalegDPRDProvinsi.next()){
                String NIK = CalegDPRDProvinsi.getString("NIK");
                String NamaPartai = CalegDPRDProvinsi.getString("NamaPartai");
                String TrackRecord = CalegDPRDProvinsi.getString("TrackRecord");
                int NoDapil = CalegDPRDProvinsi.getInt("NoDapil");
                String nama = CalegDPRDProvinsi.getString("Nama");
                DaftarCalegDPRDProvinsi.add(new Caleg(NIK, NamaPartai, TrackRecord, NoDapil,"DPRDProvinsi"));
            }
            // Mengambil data Caleg 4 dari database lalu memasukkan ke array list DaftarCalegDPRDKabupaten
            String commandEkstrakCalegDPRDKabupaten = "select Caleg.*, Penduduk.Nama "
                    + "from Caleg, Penduduk "
                    + "where Caleg.NIKCaleg = Penduduk.NIK and Lingkup = \'DPRDKabupaten\'";
            ResultSet CalegDPRDKabupaten = statement.executeQuery(commandEkstrakCalegDPRDKabupaten);
            while(CalegDPRDKabupaten.next()){
                String NIK = CalegDPRDKabupaten.getString("NIK");
                String NamaPartai = CalegDPRDKabupaten.getString("NamaPartai");
                String TrackRecord = CalegDPRDKabupaten.getString("TrackRecord");
                int NoDapil = CalegDPRDKabupaten.getInt("NoDapil");
                String nama = CalegDPRDKabupaten.getString("Nama");
                DaftarCalegDPRDKabupaten.add(new Caleg(NIK, NamaPartai, TrackRecord, NoDapil,"DPRDKabupaten"));
            }
            
            koneksi.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }        
    }
    
    /**
     * @return Daftar partai
     */
    public ArrayList<String> GetDaftarPartai(){
        ArrayList<String> DaftarPartai = new ArrayList<>();
        for(int i = 0; i < DaftarCalegDPR.size(); i++){
            DaftarPartai.add(DaftarCalegDPR.get(i).GetPartai());
        }
        HashSet UniqueDaftarPartai = new HashSet();
        UniqueDaftarPartai.addAll(DaftarPartai);
        DaftarPartai.clear();
        DaftarPartai.addAll(UniqueDaftarPartai);
        assert (DaftarPartai.size() <= 10):("Jumlah partai melebihi kapasitas");
        return DaftarPartai;
    }
    
    /**
     * @return Daftar caleg DPR
     * @param  NamaPartai
     */
    public ArrayList<Caleg> GetDaftarCalegDPR(String NamaPartai){
        ArrayList<Caleg> DaftarCaleg = new ArrayList<>();
        for(int i = 0; i < DaftarCalegDPR.size(); i++){
            if(DaftarCalegDPR.get(i).GetPartai().equals(NamaPartai)){
                DaftarCaleg.add(DaftarCalegDPR.get(i));
            }
        }
        assert (DaftarCaleg.size() <= 8):("Jumlah caleg melebihi kapasitas");
        return DaftarCaleg;
    }
    
    /**
     * @return Daftar caleg DPD
     * @param NamaPartai
     */
    public ArrayList<Caleg> GetDaftarCalegDPD(String NamaPartai){
        ArrayList<Caleg> DaftarCaleg = new ArrayList<>();
        for(int i = 0; i < DaftarCalegDPD.size(); i++){
            if(DaftarCalegDPD.get(i).GetPartai().equals(NamaPartai)){
                DaftarCaleg.add(DaftarCalegDPD.get(i));
            }
        }
        assert (DaftarCaleg.size() <= 8):("Jumlah caleg melebihi kapasitas");
        return DaftarCaleg;
    }
    
    /**
     * @return Daftar caleg DPRD Provinsi
     * @param NamaPartai
     */
    public ArrayList<Caleg> GetDaftarCalegDPRDProvinsi(String NamaPartai){
        ArrayList<Caleg> DaftarCaleg = new ArrayList<>();
        for(int i = 0; i < DaftarCalegDPRDProvinsi.size(); i++){
            if(DaftarCalegDPRDProvinsi.get(i).GetPartai().equals(NamaPartai)){
                DaftarCaleg.add(DaftarCalegDPRDProvinsi.get(i));
            }
        }
        assert (DaftarCaleg.size() <= 8):("Jumlah caleg melebihi kapasitas");
        return DaftarCaleg;
    }
    
    /**
     * @return Daftar caleg DPRD Kabupaten
     * @param NamaPartai
     */
    public ArrayList<Caleg> GetDaftarCalegDPRDKabupaten(String NamaPartai){
        ArrayList<Caleg> DaftarCaleg = new ArrayList<>();
        for(int i = 0; i < DaftarCalegDPRDKabupaten.size(); i++){
            if(DaftarCalegDPRDKabupaten.get(i).GetPartai().equals(NamaPartai)){
                DaftarCaleg.add(DaftarCalegDPRDKabupaten.get(i));
            }
        }
        assert (DaftarCaleg.size() <= 8):("Jumlah caleg melebihi kapasitas");
        return DaftarCaleg;
    }
    
    
}
