/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.ArrayList;
import java.util.List;

public class Dapil {
    private int NoDapil;
    private List<String>Kabupaten;
    
    public Dapil(){
        Kabupaten = new ArrayList<>();
    }
    
    public int getNoDapil()
    {
        return NoDapil;
    }
    
    public List<String> getDaftarKabupaten()
    {
        return Kabupaten;
    }
}
