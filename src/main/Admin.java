package main;

import Tools.KoneksiDatabase;
import Tools.Hashing;
import Tools.PasswordErrorException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Admin {
    private final String Username;
    private final String Password;
    private boolean SuperAdmin;
    
    public Admin(String user, String pass, boolean superAdmin)
    {
        Username = user;
        Password = Tools.Hashing.StringToMD5(pass);
        SuperAdmin = superAdmin;
    }
    
    /**
     * Memvalidasi input dari form login admin
     * @return True jika username dan input cocok, False kalau tidak
     */
    public boolean ValidateInput() throws PasswordErrorException{
        Connection koneksi = KoneksiDatabase.getKoneksi();
        boolean valid = false;
        try {
            Statement statemet = koneksi.createStatement();
            String command = "SELECT * FROM Admin where username = '" + Username + "'";
            ResultSet result = statemet.executeQuery(command);
            /* Jika username terdaftar di database */
            if(result.next())
            {
                String []o = new String[2];
                o[0] = result.getString("username");
                o[1] = result.getString("password");
                int SuperAdminInt;
                if(SuperAdmin)
                    SuperAdminInt = 1;
                else
                    SuperAdminInt = 0;
                    
                if(Username.compareToIgnoreCase(o[0]) == 0  && Password.equals(o[1]))
                {
                    valid = result.getInt("Peran") == SuperAdminInt;
                }
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if(!valid)
        {
            throw new PasswordErrorException();
        }
        else
            return valid;
    }
     /**
     * Mengecek apakah seseorang adalah superadmin
     * @return  true jika benar, false jika salah
     */
    public boolean IsSuperAdmin(){
        return SuperAdmin;
    }
     /**
     * 
     * @return username seorang admin 
     */
    public String getUsername()
    {
        return Username;
    }
     /**
     * 
     * @return password seorang admin 
     */
    public String getPassword()
    {
        return Password;
    }
    /**
     * Mengecek apakah seseorang adalah superadmin dengan menggunakan 0 atau 1
     * @return 1 jika benar, 0 jika salah
     */
    public int getPeran()
    {
        if(SuperAdmin)
            return 1;
        else
            return 0;
    }
}
