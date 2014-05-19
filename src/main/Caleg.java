package main;

import Tools.KoneksiDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Caleg {
    private final String NIK;
    private final String Nama;
    private final String NamaPartai;
    private final String History;
    private final int NoDapil;
    private final String Lingkup;//DPR, DPD, DPRDProv, DPRDKab
    
    public Caleg(String _NIK, String _Partai, String _History, int _NoDapil, String lingkup){
        NIK = _NIK;
        Nama = getNamaFromDatabase();
        NamaPartai = _Partai;
        History = _History;
        NoDapil = _NoDapil;
        Lingkup = lingkup;
    }
    
    public String GetNIK(){
        return NIK;        
    }
    
    public String GetPartai(){
        return NamaPartai;
    }
    
    public String GetHistory(){
        return History;
    }
    
    public int GetDapil(){
        return NoDapil;
    }
    
    public String GetLingkup()
    {
        return Lingkup;
    }
    
    public String GetNama(){
        return Nama;
    }
    
    private String getNamaFromDatabase()
    {
        String NamaTemp = "";
        try {
            Connection koneksi = KoneksiDatabase.getKoneksi();
            Statement statement = koneksi.createStatement();
            String command = "select Nama from Penduduk where NIK = " + NIK;
            ResultSet result = statement.executeQuery(command);
            if(result.next())
            {
                NamaTemp = result.getString("Nama");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Caleg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NamaTemp;
    }
}
