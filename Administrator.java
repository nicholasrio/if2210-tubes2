/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rikysamuel
 */
public class Administrator {
    private String NIM;             //NIM unik sebagai username. Untuk otentikasi
    private String password;        //Password sebagai pasangan NIM. Untuk otentikasi
    private String name;            //Nama sebagai identitas pemilik akun admin
    
    /* mengeset nilai dari NIM */
    public void SetNIM(String _NIM){
        NIM = _NIM;
    }
    
    /* mengembalikan nilai dari NIM */
    public String GetNIM(){
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
    public boolean isUserExist(String _NIM){
        boolean found;
        found = false;
        //Query mencari NIM di database
        //Jika ditemukan, found di set true;
        return found;
    }
    
    /* dipanggil setelah method isUserExist dipanggil.
     * untuk mengecek apakah password dari username tertentu valid/tidak.
     * Mengembalikan true jika sesuai. False jika tidak sesuai.
     */
    public boolean isPasswordMatch(String _password){
        boolean match;
        match = false;
        //Query mencari password berdasarkan NIM tertentu
        //match di set true jika password dari NIM tertentu sesuai dengan data di database
        return match;
    }
    
    /* Panggil dulu setter NIM dan password sebelum memanggil method ini
     * Digunakan untuk mendaftarkan admin pada database admin
     */
    public void Register(){
        //Query menambahkan record kedalam database admin
    }
    
    /* Method untuk menghapus record admin dalam database admin */
    public void Delete(String _NIM){
        if(isUserExist(_NIM)){
            //Query menghapus data dengan NIM yang sesuai dengan _NIM
        }
        else{
            System.out.println("NIM not found.");
        }
    }
}
