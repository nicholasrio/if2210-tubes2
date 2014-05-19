/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import java.sql.SQLException;

/**
 * MVC View untuk Administrator
 * @author Rikysamuel
 */
public class AdministratorView {
    /**
     * Default Constructor untuk Administrator View
     */
    public AdministratorView(){
        
    }
    
    /**
     * print detail admin
     * @param details
     * @throws SQLException 
     */
    public void printAdminDetails(String details) throws SQLException{
        System.out.println(details);
    }
    
    /**
     * print NIM tidak ditemukan
     * @param NIM 
     */
    public void printUserRejected(int NIM){
        System.out.println("NIM \'" + NIM + "\' tidak ditemukan!");
    }
    
    /**
     * print username/password tidak match
     * @param _PassMatch 
     */
    public void printMatchPassword(boolean _PassMatch){
        if (_PassMatch){
            System.out.println("Selamat. Anda telah masuk sebagai admin");
        }
        else{
            System.out.println("Salah kombinasi password/NIM");
        }
    }
    
    /**
     * print username/password cocok
     * @param _completed
     * @param name 
     */
    public void printRegister(boolean _completed, String name){
        if (_completed){
            System.out.println("Selamat \"" + name + "\". Anda telah terdaftar sebagai admin.");
        }
        else{
            System.out.println("Tidak dapat membuat data!");
        }
    }
    
    /**
     * print admin delete
     * @param _exist
     * @param NIM 
     */
    public void printDelete(boolean _exist, int NIM){
        if(_exist){
            System.out.println("OK. Admin dengan NIM : \'" + NIM + "\' dihapus.");
        }
        else{
            System.out.println("Tidak ditemukan NIM : \'" + NIM + "\'");
        }
    }
}