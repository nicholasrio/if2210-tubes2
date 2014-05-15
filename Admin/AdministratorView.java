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
public class AdministratorView {
    public AdministratorView(){
        
    }
    
    public void printAdminDetails(String details) throws SQLException{
        System.out.println(details);
    }
    
    public void printUserRejected(int NIM){
        System.out.println("NIM \'" + NIM + "\' not Found!");
    }
    
    public void printMatchPassword(boolean _PassMatch){
        if (_PassMatch){
            System.out.println("Welcome, You're logged in now");
        }
        else{
            System.out.println("Wrong combination of user/password");
        }
    }
    
    public void printRegister(boolean _completed, String name){
        if (_completed){
            System.out.println("Welcome\"" + name + "\". You're now an Admin.");
        }
        else{
            System.out.println("Cannot Create Data!");
        }
    }
    
    public void printDelete(boolean _exist, int NIM){
        if(_exist){
            System.out.println("OK. Admin with NIM : \'" + NIM + "\' deteled.");
        }
        else{
            System.out.println("Not found NIM : \'" + NIM + "\'");
        }
    }
}