/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import java.sql.SQLException;
import java.util.List;

import Video.NullException;

/**
 *
 * @author Rikysamuel
 */
public class AdministratorController {
    private final Administrator admin;
    private final AdministratorView view;
    
    public AdministratorController(){
        admin = new Administrator();
        view = new AdministratorView();
    }
    
    public Administrator getAdmin(){
        return admin;
    }
    
    public List<String[]> getAdminsData() throws SQLException{
        return admin.getAdmins();
    }
    
    public boolean checkLoginAdmin(String _NIM, String password) throws SQLException{
        if (_NIM!=null && !_NIM.equals("")){
            if (!admin.isUserExist(Integer.valueOf(_NIM))){
                view.printUserRejected(Integer.valueOf(_NIM));
                return false;
            }
            else{
                admin.SetNIM(Integer.valueOf(_NIM));
                if (!admin.isPasswordMatch(password)){
                    view.printMatchPassword(false);
                    return false;
                }
                else{
                    view.printMatchPassword(true);
                    return true;
                }
            }
        }
        return false;
    }
    
    public void AdminRegister(String _NIM, String name, String password) throws SQLException, NullException{
        if ((name.equals("") || password.equals("")) || _NIM.equals("")){
            view.printRegister(false, name);
        } else {
            if (admin.isUserExist(Integer.valueOf(_NIM))){
                view.printRegister(false, name);
            } else{
                admin.SetNIM(Integer.valueOf(_NIM));
                admin.SetName(name);
                admin.SetPassword(password);
                admin.Register();
                view.printRegister(true, name);
            }
        }
    }
    
   public void AdminDelete(String _NIM) throws SQLException{
       if (!_NIM.equals("")){
           if (admin.isUserExist(Integer.valueOf(_NIM))){
               admin.Delete(Integer.valueOf(_NIM));
               view.printDelete(true, Integer.valueOf(_NIM));
           }
           else{
               view.printDelete(false, Integer.valueOf(_NIM));
           }
       }
       else{
           view.printDelete(false, 0);
       }
   }
   /* method tambahan buat cmd */
    public void CallNIM(String _NIM) throws SQLException, AdminException{
        if(!admin.isUserExist(Integer.valueOf(_NIM))){
           throw new AdminException("No such member");
        }
        else{
            admin.SetNIM(Integer.valueOf(_NIM));
            admin.SetName(admin.AdminByNIM(_NIM).get(1));
        }
    }
}