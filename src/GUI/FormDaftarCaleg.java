/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.JRadioButton;
import java.util.*;
import javax.swing.JOptionPane;
import main.DaftarPilihan;
import main.Caleg;
import main.PilihanPartai;
import main.PilihanCaleg;

/**
 *
 * @author akhfa
 */
public class FormDaftarCaleg extends javax.swing.JFrame{
    private String Lingkup;
    private String NIK;
    private int NomorDapil;
    private DaftarPilihan DaftarPilihanCaleg;
    private ArrayList<JRadioButton> DaftarPartai;
    private ArrayList<ArrayList<JRadioButton>> DaftarCalegBerdasarkanPartai;
    private ArrayList<JRadioButton> DaftarCalegPartai1;
    private ArrayList<JRadioButton> DaftarCalegPartai2;
    private ArrayList<JRadioButton> DaftarCalegPartai3;
    private ArrayList<JRadioButton> DaftarCalegPartai4;
    private ArrayList<JRadioButton> DaftarCalegPartai5;
    private ArrayList<JRadioButton> DaftarCalegPartai6;
    private ArrayList<JRadioButton> DaftarCalegPartai7;
    private ArrayList<JRadioButton> DaftarCalegPartai8;
    private ArrayList<JRadioButton> DaftarCalegPartai9;
    private ArrayList<JRadioButton> DaftarCalegPartai10;

    /**
     * Creates new form FormPemilih
     */
    public FormDaftarCaleg(String _Lingkup, String _NIK, int _NoDapil) {
        Lingkup = _Lingkup;
        NIK = _NIK;
        NomorDapil = _NoDapil;
        initComponents();
        NoDapil.setText("" + NomorDapil);
        jLabelLingkup.setText(Lingkup);
        InisialisasiDaftarPartai();
        InisialisasiDaftarCaleg();
        DaftarPilihanCaleg = new DaftarPilihan(NomorDapil);
        switch(Lingkup){
            case "DPR":
                TampilkanDaftarCalegDPR();
                break;
            case "DPD":
                TampilkanDaftarCalegDPD();
                break;
            case "DPRD Provinsi":
                TampilkanDaftarCalegDPRDProvinsi();
                break;
            case "DPRD Kabupaten":
                TampilkanDaftarCalegDPRKabupaten();
                break;
        }
    }
    
    private void TampilkanDaftarCalegDPR(){
        ArrayList<String> daftarPartai = DaftarPilihanCaleg.GetDaftarPartai();
        for(int i = 0; i < daftarPartai.size(); i++){
            DaftarPartai.get(i).setText(daftarPartai.get(i));
            DaftarPartai.get(i).setEnabled(true);
            ArrayList<Caleg> DaftarCaleg = DaftarPilihanCaleg.GetDaftarCalegDPR(daftarPartai.get(i));
            for(int j = 0; j < DaftarCaleg.size(); j++){
                DaftarCalegBerdasarkanPartai.get(i).get(j).setText(DaftarCaleg.get(j).GetNama());
                DaftarCalegBerdasarkanPartai.get(i).get(j).setEnabled(true);
            }
            DaftarCaleg.clear();
        }  
    }
    
    private void TampilkanDaftarCalegDPD(){
        ArrayList<String> daftarPartai = DaftarPilihanCaleg.GetDaftarPartai();
        for(int i = 0; i < daftarPartai.size(); i++){
            DaftarPartai.get(i).setText(daftarPartai.get(i));
            DaftarPartai.get(i).setEnabled(true);
            ArrayList<Caleg> DaftarCaleg = DaftarPilihanCaleg.GetDaftarCalegDPD(daftarPartai.get(i));
            for(int j = 0; j < DaftarCaleg.size(); j++){
                DaftarCalegBerdasarkanPartai.get(i).get(j).setText(DaftarCaleg.get(j).GetNama());
                DaftarCalegBerdasarkanPartai.get(i).get(j).setEnabled(true);
            }
            DaftarCaleg.clear();
        }  
    }
    
    private void TampilkanDaftarCalegDPRDProvinsi(){
        ArrayList<String> daftarPartai = DaftarPilihanCaleg.GetDaftarPartai();
        for(int i = 0; i < daftarPartai.size(); i++){
            DaftarPartai.get(i).setText(daftarPartai.get(i));
            DaftarPartai.get(i).setEnabled(true);
            ArrayList<Caleg> DaftarCaleg = DaftarPilihanCaleg.GetDaftarCalegDPRDProvinsi(daftarPartai.get(i));
            for(int j = 0; j < DaftarCaleg.size(); j++){
                DaftarCalegBerdasarkanPartai.get(i).get(j).setText(DaftarCaleg.get(j).GetNama());
                DaftarCalegBerdasarkanPartai.get(i).get(j).setEnabled(true);
            }
            DaftarCaleg.clear();
        }    
    }
    
    private void TampilkanDaftarCalegDPRKabupaten(){
        ArrayList<String> daftarPartai = DaftarPilihanCaleg.GetDaftarPartai();
        for(int i = 0; i < daftarPartai.size(); i++){
            DaftarPartai.get(i).setText(daftarPartai.get(i));
            DaftarPartai.get(i).setEnabled(true);
            ArrayList<Caleg> DaftarCaleg = DaftarPilihanCaleg.GetDaftarCalegDPRDKabupaten(daftarPartai.get(i));
            for(int j = 0; j < DaftarCaleg.size(); j++){
                DaftarCalegBerdasarkanPartai.get(i).get(j).setText(DaftarCaleg.get(j).GetNama());
                DaftarCalegBerdasarkanPartai.get(i).get(j).setEnabled(true);
            }
            DaftarCaleg.clear();
        }  
    }
    
    private boolean isPilihanPartai(){
        boolean sudahPilihPartai = false;
        for (JRadioButton DaftarPartai1 : DaftarPartai) {
            if(DaftarPartai1.isSelected()){
                sudahPilihPartai = true;
                break;
            }
        }
        return sudahPilihPartai;
    }
    
    private boolean isPilihanCaleg(){
        boolean sudahPilihCaleg = false;
        for(ArrayList<JRadioButton> RadioButton : DaftarCalegBerdasarkanPartai){
            for(JRadioButton DaftarPartai : RadioButton){
                if(DaftarPartai.isSelected()){
                    sudahPilihCaleg = true;
                    break;
                }
            }
        }
        return sudahPilihCaleg;
    }
    
    private boolean isSudahPilih(){
        if(isPilihanCaleg()){
            return true;
        }else{
            return isPilihanPartai();
        }
    }
        
    private void SaveToDatabase() {
       if(isPilihanPartai()){
            String NamaPartaiPilihan = "";
            for (JRadioButton DaftarPartai1 : DaftarPartai) {
                if(DaftarPartai1.isSelected()){
                    NamaPartaiPilihan = DaftarPartai1.getText();
                    break;
                }
            }
            PilihanPartai pilihanPartai = new PilihanPartai(NIK, NamaPartaiPilihan);
            pilihanPartai.addToDatabase();
        }else{
            if(isPilihanCaleg()){
                String NamaPartaiPilihan = "";
                String NamaCalegPilihan = "";
                for(int i = 0; i < DaftarCalegBerdasarkanPartai.size(); i++){
                    for(int j = 0; j < DaftarCalegBerdasarkanPartai.get(i).size(); j++){
                        if(DaftarCalegBerdasarkanPartai.get(i).get(j).isSelected()){
                            NamaCalegPilihan = DaftarCalegBerdasarkanPartai.get(i).get(j).getText();
                            NamaPartaiPilihan = DaftarPartai.get(i).getText();
                            break;
                        }
                    }
                }
                PilihanPartai pilihanPartai = new PilihanPartai(NIK, NamaPartaiPilihan);
                pilihanPartai.addToDatabase();
                PilihanCaleg pilihanCaleg = new PilihanCaleg(NIK, NamaCalegPilihan);
                pilihanCaleg.addToDatabase();
            }
        }
    }
           
    private void InisialisasiDaftarCaleg(){
        DaftarCalegPartai1 = new ArrayList<>();
        DaftarCalegPartai1.add(jRadioButtonP1C1);
        DaftarCalegPartai1.add(jRadioButtonP1C2);
        DaftarCalegPartai1.add(jRadioButtonP1C3);
        DaftarCalegPartai1.add(jRadioButtonP1C4);
        DaftarCalegPartai1.add(jRadioButtonP1C5);
        DaftarCalegPartai1.add(jRadioButtonP1C6);
        DaftarCalegPartai1.add(jRadioButtonP1C7);
        DaftarCalegPartai1.add(jRadioButtonP1C8);
        DaftarCalegPartai2 = new ArrayList<>();
        DaftarCalegPartai2.add(jRadioButtonP2C1);
        DaftarCalegPartai2.add(jRadioButtonP2C2);
        DaftarCalegPartai2.add(jRadioButtonP2C3);
        DaftarCalegPartai2.add(jRadioButtonP2C4);
        DaftarCalegPartai2.add(jRadioButtonP2C5);
        DaftarCalegPartai2.add(jRadioButtonP2C6);
        DaftarCalegPartai2.add(jRadioButtonP2C7);
        DaftarCalegPartai2.add(jRadioButtonP2C8);
        DaftarCalegPartai3 = new ArrayList<>();
        DaftarCalegPartai3.add(jRadioButtonP3C1);
        DaftarCalegPartai3.add(jRadioButtonP3C2);
        DaftarCalegPartai3.add(jRadioButtonP3C3);
        DaftarCalegPartai3.add(jRadioButtonP3C4);
        DaftarCalegPartai3.add(jRadioButtonP3C5);
        DaftarCalegPartai3.add(jRadioButtonP3C6);
        DaftarCalegPartai3.add(jRadioButtonP3C7);
        DaftarCalegPartai3.add(jRadioButtonP3C8);
        DaftarCalegPartai4 = new ArrayList<>();
        DaftarCalegPartai4.add(jRadioButtonP4C1);
        DaftarCalegPartai4.add(jRadioButtonP4C2);
        DaftarCalegPartai4.add(jRadioButtonP4C3);
        DaftarCalegPartai4.add(jRadioButtonP4C4);
        DaftarCalegPartai4.add(jRadioButtonP4C5);
        DaftarCalegPartai4.add(jRadioButtonP4C6);
        DaftarCalegPartai4.add(jRadioButtonP4C7);
        DaftarCalegPartai4.add(jRadioButtonP4C8);
        DaftarCalegPartai5 = new ArrayList<>();
        DaftarCalegPartai5.add(jRadioButtonP5C1);
        DaftarCalegPartai5.add(jRadioButtonP5C2);
        DaftarCalegPartai5.add(jRadioButtonP5C3);
        DaftarCalegPartai5.add(jRadioButtonP5C4);
        DaftarCalegPartai5.add(jRadioButtonP5C5);
        DaftarCalegPartai5.add(jRadioButtonP5C6);
        DaftarCalegPartai5.add(jRadioButtonP5C9);
        DaftarCalegPartai5.add(jRadioButtonP5C8);
        DaftarCalegPartai6 = new ArrayList<>();
        DaftarCalegPartai6.add(jRadioButtonP6C1);
        DaftarCalegPartai6.add(jRadioButtonP6C2);
        DaftarCalegPartai6.add(jRadioButtonP6C3);
        DaftarCalegPartai6.add(jRadioButtonP6C4);
        DaftarCalegPartai6.add(jRadioButtonP6C5);
        DaftarCalegPartai6.add(jRadioButtonP6C6);
        DaftarCalegPartai6.add(jRadioButtonP6C7);
        DaftarCalegPartai6.add(jRadioButtonP6C8);
        DaftarCalegPartai7 = new ArrayList<>();
        DaftarCalegPartai7.add(jRadioButtonP7C1);
        DaftarCalegPartai7.add(jRadioButtonP7C2);
        DaftarCalegPartai7.add(jRadioButtonP7C3);
        DaftarCalegPartai7.add(jRadioButtonP7C4);
        DaftarCalegPartai7.add(jRadioButtonP7C5);
        DaftarCalegPartai7.add(jRadioButtonP7C6);
        DaftarCalegPartai7.add(jRadioButtonP7C7);
        DaftarCalegPartai7.add(jRadioButtonP7C8);
        DaftarCalegPartai8 = new ArrayList<>();
        DaftarCalegPartai8.add(jRadioButtonP8C1);
        DaftarCalegPartai8.add(jRadioButtonP8C2);
        DaftarCalegPartai8.add(jRadioButtonP8C3);
        DaftarCalegPartai8.add(jRadioButtonP8C4);
        DaftarCalegPartai8.add(jRadioButtonP8C5);
        DaftarCalegPartai8.add(jRadioButtonP8C6);
        DaftarCalegPartai8.add(jRadioButtonP8C7);
        DaftarCalegPartai8.add(jRadioButtonP8C8);
        DaftarCalegPartai9 = new ArrayList<>();
        DaftarCalegPartai9.add(jRadioButtonP9C1);
        DaftarCalegPartai9.add(jRadioButtonP9C2);
        DaftarCalegPartai9.add(jRadioButtonP9C3);
        DaftarCalegPartai9.add(jRadioButtonP9C4);
        DaftarCalegPartai9.add(jRadioButtonP9C5);
        DaftarCalegPartai9.add(jRadioButtonP9C6);
        DaftarCalegPartai9.add(jRadioButtonP9C7);
        DaftarCalegPartai9.add(jRadioButtonP9C8);
        DaftarCalegPartai10 = new ArrayList<>();
        DaftarCalegPartai10.add(jRadioButtonP10C1);
        DaftarCalegPartai10.add(jRadioButtonP10C2);
        DaftarCalegPartai10.add(jRadioButtonP10C3);
        DaftarCalegPartai10.add(jRadioButtonP10C4);
        DaftarCalegPartai10.add(jRadioButtonP10C5);
        DaftarCalegPartai10.add(jRadioButtonP10C6);
        DaftarCalegPartai10.add(jRadioButtonP10C7);
        DaftarCalegPartai10.add(jRadioButtonP10C8);
        DaftarCalegBerdasarkanPartai = new ArrayList<>();
        DaftarCalegBerdasarkanPartai.add(DaftarCalegPartai1);
        DaftarCalegBerdasarkanPartai.add(DaftarCalegPartai2);
        DaftarCalegBerdasarkanPartai.add(DaftarCalegPartai3);
        DaftarCalegBerdasarkanPartai.add(DaftarCalegPartai4);
        DaftarCalegBerdasarkanPartai.add(DaftarCalegPartai5);
        DaftarCalegBerdasarkanPartai.add(DaftarCalegPartai6);
        DaftarCalegBerdasarkanPartai.add(DaftarCalegPartai7);
        DaftarCalegBerdasarkanPartai.add(DaftarCalegPartai8);
        DaftarCalegBerdasarkanPartai.add(DaftarCalegPartai9);
        DaftarCalegBerdasarkanPartai.add(DaftarCalegPartai10);
        for(ArrayList<JRadioButton> RadioButton : DaftarCalegBerdasarkanPartai){
            for(JRadioButton DaftarPartai : RadioButton){
                DaftarPartai.setEnabled(false);
                DaftarPartai.setText("null");
            }
        }
    }
    
    private void InisialisasiDaftarPartai(){
        DaftarPartai = new ArrayList<>();
        DaftarPartai.add(jRadioButtonPartai1);
        DaftarPartai.add(jRadioButtonPartai2);
        DaftarPartai.add(jRadioButtonPartai3);
        DaftarPartai.add(jRadioButtonPartai4);
        DaftarPartai.add(jRadioButtonPartai5);
        DaftarPartai.add(jRadioButtonPartai6);
        DaftarPartai.add(jRadioButtonPartai7);
        DaftarPartai.add(jRadioButtonPartai8);
        DaftarPartai.add(jRadioButtonPartai9);
        DaftarPartai.add(jRadioButtonPartai10);
        for (JRadioButton DaftarPartai1 : DaftarPartai) {
            DaftarPartai1.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pilihan = new javax.swing.ButtonGroup();
        jRadioButtonP5C7 = new javax.swing.JRadioButton();
        Dapil = new javax.swing.JLabel();
        jLabelLingkup = new javax.swing.JLabel();
        NoDapil = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        jRadioButtonP1C4 = new javax.swing.JRadioButton();
        jRadioButtonP1C5 = new javax.swing.JRadioButton();
        jRadioButtonP1C6 = new javax.swing.JRadioButton();
        jRadioButtonP1C7 = new javax.swing.JRadioButton();
        jRadioButtonP1C8 = new javax.swing.JRadioButton();
        jRadioButtonP1C1 = new javax.swing.JRadioButton();
        jRadioButtonP1C3 = new javax.swing.JRadioButton();
        jRadioButtonPartai1 = new javax.swing.JRadioButton();
        jRadioButtonP1C2 = new javax.swing.JRadioButton();
        jRadioButtonP2C1 = new javax.swing.JRadioButton();
        jRadioButtonP2C4 = new javax.swing.JRadioButton();
        jRadioButtonP2C2 = new javax.swing.JRadioButton();
        jRadioButtonP2C5 = new javax.swing.JRadioButton();
        jRadioButtonP2C3 = new javax.swing.JRadioButton();
        jRadioButtonP2C6 = new javax.swing.JRadioButton();
        jRadioButtonP2C8 = new javax.swing.JRadioButton();
        jRadioButtonP2C7 = new javax.swing.JRadioButton();
        jRadioButtonPartai2 = new javax.swing.JRadioButton();
        jRadioButtonP3C8 = new javax.swing.JRadioButton();
        jRadioButtonP3C6 = new javax.swing.JRadioButton();
        jRadioButtonP3C7 = new javax.swing.JRadioButton();
        jRadioButtonP3C2 = new javax.swing.JRadioButton();
        jRadioButtonP3C1 = new javax.swing.JRadioButton();
        jRadioButtonPartai3 = new javax.swing.JRadioButton();
        jRadioButtonP3C4 = new javax.swing.JRadioButton();
        jRadioButtonP3C3 = new javax.swing.JRadioButton();
        jRadioButtonP3C5 = new javax.swing.JRadioButton();
        jRadioButtonP4C1 = new javax.swing.JRadioButton();
        jRadioButtonP4C8 = new javax.swing.JRadioButton();
        jRadioButtonP4C5 = new javax.swing.JRadioButton();
        jRadioButtonP4C4 = new javax.swing.JRadioButton();
        jRadioButtonP4C3 = new javax.swing.JRadioButton();
        jRadioButtonP4C2 = new javax.swing.JRadioButton();
        jRadioButtonPartai4 = new javax.swing.JRadioButton();
        jRadioButtonP4C7 = new javax.swing.JRadioButton();
        jRadioButtonP4C6 = new javax.swing.JRadioButton();
        jRadioButtonP5C1 = new javax.swing.JRadioButton();
        jRadioButtonP5C2 = new javax.swing.JRadioButton();
        jRadioButtonP5C3 = new javax.swing.JRadioButton();
        jRadioButtonP5C4 = new javax.swing.JRadioButton();
        jRadioButtonPartai5 = new javax.swing.JRadioButton();
        jRadioButtonP5C6 = new javax.swing.JRadioButton();
        jRadioButtonP5C9 = new javax.swing.JRadioButton();
        jRadioButtonP5C5 = new javax.swing.JRadioButton();
        jRadioButtonP5C8 = new javax.swing.JRadioButton();
        jRadioButtonP6C7 = new javax.swing.JRadioButton();
        jRadioButtonP6C8 = new javax.swing.JRadioButton();
        jRadioButtonP6C5 = new javax.swing.JRadioButton();
        jRadioButtonP6C6 = new javax.swing.JRadioButton();
        jRadioButtonP6C3 = new javax.swing.JRadioButton();
        jRadioButtonP6C4 = new javax.swing.JRadioButton();
        jRadioButtonP6C2 = new javax.swing.JRadioButton();
        jRadioButtonPartai6 = new javax.swing.JRadioButton();
        jRadioButtonP6C1 = new javax.swing.JRadioButton();
        jRadioButtonP7C3 = new javax.swing.JRadioButton();
        jRadioButtonP7C1 = new javax.swing.JRadioButton();
        jRadioButtonP7C2 = new javax.swing.JRadioButton();
        jRadioButtonPartai7 = new javax.swing.JRadioButton();
        jRadioButtonP7C7 = new javax.swing.JRadioButton();
        jRadioButtonP7C6 = new javax.swing.JRadioButton();
        jRadioButtonP7C5 = new javax.swing.JRadioButton();
        jRadioButtonP7C4 = new javax.swing.JRadioButton();
        jRadioButtonP7C8 = new javax.swing.JRadioButton();
        jRadioButtonPartai8 = new javax.swing.JRadioButton();
        jRadioButtonP8C5 = new javax.swing.JRadioButton();
        jRadioButtonP8C4 = new javax.swing.JRadioButton();
        jRadioButtonP8C3 = new javax.swing.JRadioButton();
        jRadioButtonP8C2 = new javax.swing.JRadioButton();
        jRadioButtonP8C1 = new javax.swing.JRadioButton();
        jRadioButtonP8C8 = new javax.swing.JRadioButton();
        jRadioButtonP8C7 = new javax.swing.JRadioButton();
        jRadioButtonP8C6 = new javax.swing.JRadioButton();
        jRadioButtonP9C8 = new javax.swing.JRadioButton();
        jRadioButtonPartai9 = new javax.swing.JRadioButton();
        jRadioButtonP9C2 = new javax.swing.JRadioButton();
        jRadioButtonP9C1 = new javax.swing.JRadioButton();
        jRadioButtonP9C7 = new javax.swing.JRadioButton();
        jRadioButtonP9C4 = new javax.swing.JRadioButton();
        jRadioButtonP9C3 = new javax.swing.JRadioButton();
        jRadioButtonP9C6 = new javax.swing.JRadioButton();
        jRadioButtonP9C5 = new javax.swing.JRadioButton();
        jRadioButtonP10C1 = new javax.swing.JRadioButton();
        jRadioButtonP10C5 = new javax.swing.JRadioButton();
        jRadioButtonP10C4 = new javax.swing.JRadioButton();
        jRadioButtonP10C3 = new javax.swing.JRadioButton();
        jRadioButtonP10C2 = new javax.swing.JRadioButton();
        jRadioButtonP10C8 = new javax.swing.JRadioButton();
        jRadioButtonP10C7 = new javax.swing.JRadioButton();
        jRadioButtonP10C6 = new javax.swing.JRadioButton();
        jRadioButtonPartai10 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        jRadioButtonP5C7.setBackground(java.awt.SystemColor.controlHighlight);
        Pilihan.add(jRadioButtonP5C7);
        jRadioButtonP5C7.setFont(new java.awt.Font("Belwe Bd BT", 0, 36)); // NOI18N
        jRadioButtonP5C7.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dapil.setFont(new java.awt.Font("Belwe Bd BT", 1, 36)); // NOI18N
        Dapil.setForeground(new java.awt.Color(255, 255, 204));
        Dapil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dapil.setText("Dapil");
        getContentPane().add(Dapil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 879, -1));

        jLabelLingkup.setFont(new java.awt.Font("Belwe Bd BT", 1, 24)); // NOI18N
        jLabelLingkup.setForeground(new java.awt.Color(255, 255, 204));
        jLabelLingkup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLingkup.setText("DPR");
        getContentPane().add(jLabelLingkup, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 879, -1));

        NoDapil.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 43)); // NOI18N
        NoDapil.setForeground(new java.awt.Color(255, 255, 204));
        NoDapil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NoDapil.setText("0");
        getContentPane().add(NoDapil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 879, -1));

        Submit.setBackground(java.awt.SystemColor.inactiveCaptionText);
        Submit.setFont(new java.awt.Font("Belwe Bd BT", 1, 24)); // NOI18N
        Submit.setForeground(new java.awt.Color(255, 153, 102));
        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        getContentPane().add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 620, 130, -1));

        jRadioButtonP1C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C4);
        jRadioButtonP1C4.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP1C4.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP1C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 103, -1));

        jRadioButtonP1C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C5);
        jRadioButtonP1C5.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP1C5.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP1C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 103, -1));

        jRadioButtonP1C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C6);
        jRadioButtonP1C6.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP1C6.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP1C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 103, -1));

        jRadioButtonP1C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C7);
        jRadioButtonP1C7.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP1C7.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP1C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 103, -1));

        jRadioButtonP1C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C8);
        jRadioButtonP1C8.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP1C8.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP1C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 103, -1));

        jRadioButtonP1C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C1);
        jRadioButtonP1C1.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP1C1.setText("jRadioButton1");
        jRadioButtonP1C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP1C1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonP1C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 103, -1));

        jRadioButtonP1C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C3);
        jRadioButtonP1C3.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP1C3.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP1C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 103, -1));

        jRadioButtonPartai1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai1);
        jRadioButtonPartai1.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonPartai1.setText("Partai 1");
        getContentPane().add(jRadioButtonPartai1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 103, -1));

        jRadioButtonP1C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C2);
        jRadioButtonP1C2.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP1C2.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP1C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 103, -1));

        jRadioButtonP2C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C1);
        jRadioButtonP2C1.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP2C1.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP2C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 103, -1));

        jRadioButtonP2C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C4);
        jRadioButtonP2C4.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP2C4.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP2C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 103, -1));

        jRadioButtonP2C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C2);
        jRadioButtonP2C2.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP2C2.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP2C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 103, -1));

        jRadioButtonP2C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C5);
        jRadioButtonP2C5.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP2C5.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP2C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 103, -1));

        jRadioButtonP2C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C3);
        jRadioButtonP2C3.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP2C3.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP2C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 103, -1));

        jRadioButtonP2C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C6);
        jRadioButtonP2C6.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP2C6.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP2C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 103, -1));

        jRadioButtonP2C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C8);
        jRadioButtonP2C8.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP2C8.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP2C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 103, -1));

        jRadioButtonP2C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C7);
        jRadioButtonP2C7.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP2C7.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP2C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 103, -1));

        jRadioButtonPartai2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai2);
        jRadioButtonPartai2.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonPartai2.setText("Partai 2");
        getContentPane().add(jRadioButtonPartai2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 103, -1));

        jRadioButtonP3C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C8);
        jRadioButtonP3C8.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP3C8.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP3C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 103, -1));

        jRadioButtonP3C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C6);
        jRadioButtonP3C6.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP3C6.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP3C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 103, -1));

        jRadioButtonP3C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C7);
        jRadioButtonP3C7.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP3C7.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP3C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 103, -1));

        jRadioButtonP3C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C2);
        jRadioButtonP3C2.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP3C2.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP3C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 103, -1));

        jRadioButtonP3C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C1);
        jRadioButtonP3C1.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP3C1.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP3C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 103, -1));

        jRadioButtonPartai3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai3);
        jRadioButtonPartai3.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonPartai3.setText("Partai 3");
        getContentPane().add(jRadioButtonPartai3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 103, -1));

        jRadioButtonP3C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C4);
        jRadioButtonP3C4.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP3C4.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP3C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 103, -1));

        jRadioButtonP3C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C3);
        jRadioButtonP3C3.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP3C3.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP3C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 103, -1));

        jRadioButtonP3C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C5);
        jRadioButtonP3C5.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP3C5.setText("jRadioButton1");
        jRadioButtonP3C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP3C5ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonP3C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 103, -1));

        jRadioButtonP4C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C1);
        jRadioButtonP4C1.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP4C1.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP4C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 103, -1));

        jRadioButtonP4C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C8);
        jRadioButtonP4C8.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP4C8.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP4C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 103, -1));

        jRadioButtonP4C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C5);
        jRadioButtonP4C5.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP4C5.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP4C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 103, -1));

        jRadioButtonP4C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C4);
        jRadioButtonP4C4.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP4C4.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP4C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 103, -1));

        jRadioButtonP4C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C3);
        jRadioButtonP4C3.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP4C3.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP4C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 103, -1));

        jRadioButtonP4C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C2);
        jRadioButtonP4C2.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP4C2.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP4C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 103, -1));

        jRadioButtonPartai4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai4);
        jRadioButtonPartai4.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonPartai4.setText("Partai 4");
        jRadioButtonPartai4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPartai4ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonPartai4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 103, -1));

        jRadioButtonP4C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C7);
        jRadioButtonP4C7.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP4C7.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP4C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 103, -1));

        jRadioButtonP4C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C6);
        jRadioButtonP4C6.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP4C6.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP4C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 103, -1));

        jRadioButtonP5C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C1);
        jRadioButtonP5C1.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP5C1.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP5C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 103, -1));

        jRadioButtonP5C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C2);
        jRadioButtonP5C2.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP5C2.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP5C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, 103, -1));

        jRadioButtonP5C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C3);
        jRadioButtonP5C3.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP5C3.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP5C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 103, -1));

        jRadioButtonP5C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C4);
        jRadioButtonP5C4.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP5C4.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP5C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, 103, -1));

        jRadioButtonPartai5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai5);
        jRadioButtonPartai5.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonPartai5.setText("Partai 5");
        getContentPane().add(jRadioButtonPartai5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 103, -1));

        jRadioButtonP5C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C6);
        jRadioButtonP5C6.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP5C6.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP5C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, 103, -1));

        jRadioButtonP5C9.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C9);
        jRadioButtonP5C9.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP5C9.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP5C9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 103, -1));

        jRadioButtonP5C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C5);
        jRadioButtonP5C5.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP5C5.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP5C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 103, -1));

        jRadioButtonP5C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C8);
        jRadioButtonP5C8.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP5C8.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP5C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 103, -1));

        jRadioButtonP6C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C7);
        jRadioButtonP6C7.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP6C7.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP6C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 103, -1));

        jRadioButtonP6C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C8);
        jRadioButtonP6C8.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP6C8.setText("jRadioButton1");
        jRadioButtonP6C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP6C8ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonP6C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 103, -1));

        jRadioButtonP6C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C5);
        jRadioButtonP6C5.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP6C5.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP6C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 103, -1));

        jRadioButtonP6C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C6);
        jRadioButtonP6C6.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP6C6.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP6C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 103, -1));

        jRadioButtonP6C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C3);
        jRadioButtonP6C3.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP6C3.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP6C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 103, -1));

        jRadioButtonP6C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C4);
        jRadioButtonP6C4.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP6C4.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP6C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 103, -1));

        jRadioButtonP6C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C2);
        jRadioButtonP6C2.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP6C2.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP6C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 103, -1));

        jRadioButtonPartai6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai6);
        jRadioButtonPartai6.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonPartai6.setText("Partai 6");
        getContentPane().add(jRadioButtonPartai6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 103, -1));

        jRadioButtonP6C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C1);
        jRadioButtonP6C1.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP6C1.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP6C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 103, -1));

        jRadioButtonP7C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C3);
        jRadioButtonP7C3.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP7C3.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP7C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 103, -1));

        jRadioButtonP7C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C1);
        jRadioButtonP7C1.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP7C1.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP7C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 103, -1));

        jRadioButtonP7C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C2);
        jRadioButtonP7C2.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP7C2.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP7C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 103, -1));

        jRadioButtonPartai7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai7);
        jRadioButtonPartai7.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonPartai7.setText("Partai 7");
        getContentPane().add(jRadioButtonPartai7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 103, -1));

        jRadioButtonP7C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C7);
        jRadioButtonP7C7.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP7C7.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP7C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 103, -1));

        jRadioButtonP7C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C6);
        jRadioButtonP7C6.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP7C6.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP7C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 103, -1));

        jRadioButtonP7C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C5);
        jRadioButtonP7C5.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP7C5.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP7C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 103, -1));

        jRadioButtonP7C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C4);
        jRadioButtonP7C4.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP7C4.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP7C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 103, -1));

        jRadioButtonP7C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C8);
        jRadioButtonP7C8.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP7C8.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP7C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 103, -1));

        jRadioButtonPartai8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai8);
        jRadioButtonPartai8.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonPartai8.setText("Partai 8");
        getContentPane().add(jRadioButtonPartai8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 103, -1));

        jRadioButtonP8C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C5);
        jRadioButtonP8C5.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP8C5.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP8C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 103, -1));

        jRadioButtonP8C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C4);
        jRadioButtonP8C4.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP8C4.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP8C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 103, -1));

        jRadioButtonP8C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C3);
        jRadioButtonP8C3.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP8C3.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP8C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 103, -1));

        jRadioButtonP8C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C2);
        jRadioButtonP8C2.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP8C2.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP8C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 103, -1));

        jRadioButtonP8C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C1);
        jRadioButtonP8C1.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP8C1.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP8C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 103, -1));

        jRadioButtonP8C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C8);
        jRadioButtonP8C8.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP8C8.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP8C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, 103, -1));

        jRadioButtonP8C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C7);
        jRadioButtonP8C7.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP8C7.setText("jRadioButton1");
        jRadioButtonP8C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP8C7ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonP8C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 103, -1));

        jRadioButtonP8C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C6);
        jRadioButtonP8C6.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP8C6.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP8C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 103, -1));

        jRadioButtonP9C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C8);
        jRadioButtonP9C8.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP9C8.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP9C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 570, 103, -1));

        jRadioButtonPartai9.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai9);
        jRadioButtonPartai9.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonPartai9.setText("Partai 9");
        getContentPane().add(jRadioButtonPartai9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 103, -1));

        jRadioButtonP9C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C2);
        jRadioButtonP9C2.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP9C2.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP9C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 103, -1));

        jRadioButtonP9C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C1);
        jRadioButtonP9C1.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP9C1.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP9C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 103, -1));

        jRadioButtonP9C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C7);
        jRadioButtonP9C7.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP9C7.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP9C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 550, 103, -1));

        jRadioButtonP9C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C4);
        jRadioButtonP9C4.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP9C4.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP9C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 103, -1));

        jRadioButtonP9C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C3);
        jRadioButtonP9C3.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP9C3.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP9C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 103, -1));

        jRadioButtonP9C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C6);
        jRadioButtonP9C6.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP9C6.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP9C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, 103, -1));

        jRadioButtonP9C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C5);
        jRadioButtonP9C5.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP9C5.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP9C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 510, 103, -1));

        jRadioButtonP10C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C1);
        jRadioButtonP10C1.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP10C1.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP10C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 103, -1));

        jRadioButtonP10C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C5);
        jRadioButtonP10C5.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP10C5.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP10C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, 103, -1));

        jRadioButtonP10C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C4);
        jRadioButtonP10C4.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP10C4.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP10C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, 103, -1));

        jRadioButtonP10C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C3);
        jRadioButtonP10C3.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP10C3.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP10C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, 103, -1));

        jRadioButtonP10C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C2);
        jRadioButtonP10C2.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP10C2.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP10C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, 103, -1));

        jRadioButtonP10C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C8);
        jRadioButtonP10C8.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP10C8.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP10C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 570, 103, -1));

        jRadioButtonP10C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C7);
        jRadioButtonP10C7.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP10C7.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP10C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, 103, -1));

        jRadioButtonP10C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C6);
        jRadioButtonP10C6.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonP10C6.setText("jRadioButton1");
        getContentPane().add(jRadioButtonP10C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 530, 103, -1));

        jRadioButtonPartai10.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai10);
        jRadioButtonPartai10.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        jRadioButtonPartai10.setText("Partai 10");
        getContentPane().add(jRadioButtonPartai10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, 103, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/shutterstock_47142253.jpg"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 290, 140));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/shutterstock_47142253.jpg"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 290, 460));

        jLabel16.setFont(new java.awt.Font("Belwe Bd BT", 1, 24)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/shutterstock_47142253.jpg"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 600, 290, 110));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/shutterstock_47142253.jpg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 140));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/shutterstock_47142253.jpg"))); // NOI18N
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 590, 460));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/shutterstock_47142253.jpg"))); // NOI18N
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 590, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonP1C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP1C1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonP1C1ActionPerformed

    private void jRadioButtonP3C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP3C5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonP3C5ActionPerformed

    private void jRadioButtonPartai4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPartai4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonPartai4ActionPerformed

    private void jRadioButtonP6C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP6C8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonP6C8ActionPerformed

    private void jRadioButtonP8C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP8C7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonP8C7ActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        if(isSudahPilih()){
            SaveToDatabase();
            FormPemilih form = new FormPemilih(NIK, "any password");
            form.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Anda belum memilih");
        }
    }//GEN-LAST:event_SubmitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dapil;
    private javax.swing.JLabel NoDapil;
    private javax.swing.ButtonGroup Pilihan;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabelLingkup;
    private javax.swing.JRadioButton jRadioButtonP10C1;
    private javax.swing.JRadioButton jRadioButtonP10C2;
    private javax.swing.JRadioButton jRadioButtonP10C3;
    private javax.swing.JRadioButton jRadioButtonP10C4;
    private javax.swing.JRadioButton jRadioButtonP10C5;
    private javax.swing.JRadioButton jRadioButtonP10C6;
    private javax.swing.JRadioButton jRadioButtonP10C7;
    private javax.swing.JRadioButton jRadioButtonP10C8;
    private javax.swing.JRadioButton jRadioButtonP1C1;
    private javax.swing.JRadioButton jRadioButtonP1C2;
    private javax.swing.JRadioButton jRadioButtonP1C3;
    private javax.swing.JRadioButton jRadioButtonP1C4;
    private javax.swing.JRadioButton jRadioButtonP1C5;
    private javax.swing.JRadioButton jRadioButtonP1C6;
    private javax.swing.JRadioButton jRadioButtonP1C7;
    private javax.swing.JRadioButton jRadioButtonP1C8;
    private javax.swing.JRadioButton jRadioButtonP2C1;
    private javax.swing.JRadioButton jRadioButtonP2C2;
    private javax.swing.JRadioButton jRadioButtonP2C3;
    private javax.swing.JRadioButton jRadioButtonP2C4;
    private javax.swing.JRadioButton jRadioButtonP2C5;
    private javax.swing.JRadioButton jRadioButtonP2C6;
    private javax.swing.JRadioButton jRadioButtonP2C7;
    private javax.swing.JRadioButton jRadioButtonP2C8;
    private javax.swing.JRadioButton jRadioButtonP3C1;
    private javax.swing.JRadioButton jRadioButtonP3C2;
    private javax.swing.JRadioButton jRadioButtonP3C3;
    private javax.swing.JRadioButton jRadioButtonP3C4;
    private javax.swing.JRadioButton jRadioButtonP3C5;
    private javax.swing.JRadioButton jRadioButtonP3C6;
    private javax.swing.JRadioButton jRadioButtonP3C7;
    private javax.swing.JRadioButton jRadioButtonP3C8;
    private javax.swing.JRadioButton jRadioButtonP4C1;
    private javax.swing.JRadioButton jRadioButtonP4C2;
    private javax.swing.JRadioButton jRadioButtonP4C3;
    private javax.swing.JRadioButton jRadioButtonP4C4;
    private javax.swing.JRadioButton jRadioButtonP4C5;
    private javax.swing.JRadioButton jRadioButtonP4C6;
    private javax.swing.JRadioButton jRadioButtonP4C7;
    private javax.swing.JRadioButton jRadioButtonP4C8;
    private javax.swing.JRadioButton jRadioButtonP5C1;
    private javax.swing.JRadioButton jRadioButtonP5C2;
    private javax.swing.JRadioButton jRadioButtonP5C3;
    private javax.swing.JRadioButton jRadioButtonP5C4;
    private javax.swing.JRadioButton jRadioButtonP5C5;
    private javax.swing.JRadioButton jRadioButtonP5C6;
    private javax.swing.JRadioButton jRadioButtonP5C7;
    private javax.swing.JRadioButton jRadioButtonP5C8;
    private javax.swing.JRadioButton jRadioButtonP5C9;
    private javax.swing.JRadioButton jRadioButtonP6C1;
    private javax.swing.JRadioButton jRadioButtonP6C2;
    private javax.swing.JRadioButton jRadioButtonP6C3;
    private javax.swing.JRadioButton jRadioButtonP6C4;
    private javax.swing.JRadioButton jRadioButtonP6C5;
    private javax.swing.JRadioButton jRadioButtonP6C6;
    private javax.swing.JRadioButton jRadioButtonP6C7;
    private javax.swing.JRadioButton jRadioButtonP6C8;
    private javax.swing.JRadioButton jRadioButtonP7C1;
    private javax.swing.JRadioButton jRadioButtonP7C2;
    private javax.swing.JRadioButton jRadioButtonP7C3;
    private javax.swing.JRadioButton jRadioButtonP7C4;
    private javax.swing.JRadioButton jRadioButtonP7C5;
    private javax.swing.JRadioButton jRadioButtonP7C6;
    private javax.swing.JRadioButton jRadioButtonP7C7;
    private javax.swing.JRadioButton jRadioButtonP7C8;
    private javax.swing.JRadioButton jRadioButtonP8C1;
    private javax.swing.JRadioButton jRadioButtonP8C2;
    private javax.swing.JRadioButton jRadioButtonP8C3;
    private javax.swing.JRadioButton jRadioButtonP8C4;
    private javax.swing.JRadioButton jRadioButtonP8C5;
    private javax.swing.JRadioButton jRadioButtonP8C6;
    private javax.swing.JRadioButton jRadioButtonP8C7;
    private javax.swing.JRadioButton jRadioButtonP8C8;
    private javax.swing.JRadioButton jRadioButtonP9C1;
    private javax.swing.JRadioButton jRadioButtonP9C2;
    private javax.swing.JRadioButton jRadioButtonP9C3;
    private javax.swing.JRadioButton jRadioButtonP9C4;
    private javax.swing.JRadioButton jRadioButtonP9C5;
    private javax.swing.JRadioButton jRadioButtonP9C6;
    private javax.swing.JRadioButton jRadioButtonP9C7;
    private javax.swing.JRadioButton jRadioButtonP9C8;
    private javax.swing.JRadioButton jRadioButtonPartai1;
    private javax.swing.JRadioButton jRadioButtonPartai10;
    private javax.swing.JRadioButton jRadioButtonPartai2;
    private javax.swing.JRadioButton jRadioButtonPartai3;
    private javax.swing.JRadioButton jRadioButtonPartai4;
    private javax.swing.JRadioButton jRadioButtonPartai5;
    private javax.swing.JRadioButton jRadioButtonPartai6;
    private javax.swing.JRadioButton jRadioButtonPartai7;
    private javax.swing.JRadioButton jRadioButtonPartai8;
    private javax.swing.JRadioButton jRadioButtonPartai9;
    // End of variables declaration//GEN-END:variables

}