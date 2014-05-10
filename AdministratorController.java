/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package catalogue;

import java.sql.SQLException;

/**
 *
 * @author Rikysamuel
 */
public class AdministratorController {
    private Administrator admin;
    private AdministratorView view;
    
    public AdministratorController(){
        admin = new Administrator();
        view = new AdministratorView();
    }
    
    public void checkLoginAdmin(String _NIM, String password) throws SQLException{
        if (_NIM!=null && _NIM!=""){
            if (!admin.isUserExist(Integer.valueOf(_NIM))){
                view.printUserRejected(Integer.valueOf(_NIM));
            }
            else{
                admin.SetNIM(Integer.valueOf(_NIM));
                if (!admin.isPasswordMatch(password)){
                    view.printMatchPassword(false);
                }
                else{
                    view.printMatchPassword(true);
                }
            }
        }
    }
    
    public void AdminRegister(String _NIM, String name, String password) throws SQLException{
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
}
