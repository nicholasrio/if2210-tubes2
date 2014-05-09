/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

/**
 *
 * @author akhfa
 */
public class Caleg {
    private String NIK;
    private String NamaPartai;
    private String History;
    private int NoDapil;
    
    public Caleg(String _NIK, String _Partai, String _History, int _NoDapil){
        NIK = _NIK;
        NamaPartai = _Partai;
        History = _History;
        NoDapil = _NoDapil;
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
    
}
