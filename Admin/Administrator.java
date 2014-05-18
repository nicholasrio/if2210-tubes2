/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import java.sql.SQLException;
import java.util.List;
import mysql.SqlStatement;


/**
 *
 * @author Rikysamuel
 */
public class Administrator {
    private int NIM;             //NIM unik sebagai username. Untuk otentikasi
    private String password;        //Password sebagai pasangan NIM. Untuk otentikasi
    private String name;            //Nama sebagai identitas pemilik akun admin
    
    /* mengeset nilai dari NIM */
    public void SetNIM(int _NIM){
        NIM = _NIM;
    }
    
    /* mengembalikan nilai dari NIM */
    public int GetNIM(){
        return NIM;
    }
    
    /* mengeset nilai dari password */
    public void SetPassword(String _password){
        password = _password;
    }
    
    /* mengembalikan nilai dari password */
    public String GetPassword(){
        return password;
    }
    
    /* mengeset nilai name */
    public void SetName(String _name){
        name = _name;
    }
    
    /* Mengembalikan name */
    public String GetName(){
        return name;
    }
    
    /**
     * Method yang digunakan untuk mengecek apakah sebuah _NIM sudah ada dalam 
     * database admin atau belum.
     * Mengembalikan true jika ada, false jika tidak ada.
     * @param _NIM
     * @return 
     * @throws java.sql.SQLException 
     */
    public boolean isUserExist(int _NIM) throws SQLException{
        return new SqlStatement().IsAdminExist(_NIM);
    }
    
    /**
     * untuk mengecek apakah password dari username tertentu valid/tidak.
     * Mengembalikan true jika sesuai. False jika tidak sesuai.
     * @param _password
     * @return 
     * @throws java.sql.SQLException
     */
    public boolean isPasswordMatch(String _password) throws SQLException{
        return new SqlStatement().isPassword(NIM, _password);
    }
    
    /**
     * Panggil dulu setter NIM dan password sebelum memanggil method ini
     * Digunakan untuk mendaftarkan admin pada database admin
     * @throws java.sql.SQLException
     */
    public void Register() throws SQLException{
        new SqlStatement().insert_admin(NIM, password, name);
    }
    
    /* Method untuk menghapus record admin dalam database admin */
    public void Delete(int _NIM) throws SQLException{
        if(isUserExist(_NIM)){
            new SqlStatement().deleteAdmin(_NIM);
        }
    }
    
    /* Method untuk mendapatkan data admin */
    public List<String[]> getAdmins() throws SQLException{
        return new SqlStatement().select_admin();
    }
    
    /* method tambahan buat cmd */
    public List<String> AdminByNIM(String _NIM )throws SQLException{
        return new SqlStatement().select_admin_specific(NIM);
    }
}