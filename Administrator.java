/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import java.sql.SQLException;

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
    
    /* Method yang digunakan untuk mengecek apakah sebuah _NIM sudah ada dalam 
     * database admin atau belum.
     * Mengembalikan true jika ada, false jika tidak ada.
     */
    public boolean isUserExist(int _NIM) throws SQLException{
        SqlStatement s = new SqlStatement();
        return s.IsAdminExist(_NIM);
    }
    
    /* untuk mengecek apakah password dari username tertentu valid/tidak.
     * Mengembalikan true jika sesuai. False jika tidak sesuai.
     */
    public boolean isPasswordMatch(String _password) throws SQLException{
        SqlStatement s = new SqlStatement();
        return s.isPassword(NIM, _password);
    }
    
    /* Panggil dulu setter NIM dan password sebelum memanggil method ini
     * Digunakan untuk mendaftarkan admin pada database admin
     */
    public void Register() throws SQLException{
        SqlStatement s =new SqlStatement();
        s.insert_admin(NIM, password, name);
    }
    
    /* Method untuk menghapus record admin dalam database admin */
    public void Delete(int _NIM) throws SQLException{
        if(isUserExist(_NIM)){
            SqlStatement s = new SqlStatement();
            s.deleteAdmin(_NIM);
        }
    }
}