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
    private List<String> daftarKabupaten;
    
    public Dapil(){
        daftarKabupaten = new ArrayList<>();
    }
    /**
     * Menambahkan Dapil baru
     * @param noDapil Nomor Dapil yang dimasukkan
     * @param kabupaten Kabupaten yang termasuk dalam dapil
     */
    public Dapil(int noDapil, String kabupaten)
    {
        daftarKabupaten = new ArrayList<>();
        NoDapil = noDapil;
        daftarKabupaten.add(kabupaten);
    }
    
    public int getNoDapil()
    {
        return NoDapil;
    }
    
    public List<String> getDaftarKabupaten()
    {
        return daftarKabupaten;
    }
    
    public void addKabupaten(String kabupaten)
    {
        if(!daftarKabupaten.contains(kabupaten))
        {
            daftarKabupaten.add(kabupaten);
        }
    }
}
