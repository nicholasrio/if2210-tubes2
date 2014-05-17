/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.JRadioButton;
import java.util.*;

/**
 *
 * @author akhfa
 */
public class FormDaftarCaleg extends javax.swing.JFrame{
    private String Lingkup;
    private String NIK;
    private int NomorDapil;
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
    }
    
    public void InisialisasiDaftarCaleg(){
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
        DaftarCalegPartai5.add(jRadioButtonP5C7);
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
    
    public void InisialisasiDaftarPartai(){
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
        
    public void SaveToDatabase() {
       
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
        jRadioButtonP5C5 = new javax.swing.JRadioButton();
        jRadioButtonP5C8 = new javax.swing.JRadioButton();
        jRadioButtonP5C7 = new javax.swing.JRadioButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Dapil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Dapil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dapil.setText("Dapil");

        jLabelLingkup.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelLingkup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLingkup.setText("DPR");

        NoDapil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NoDapil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NoDapil.setText("0");

        Submit.setText("Submit");

        jRadioButtonP1C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C4);
        jRadioButtonP1C4.setText("jRadioButton1");

        jRadioButtonP1C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C5);
        jRadioButtonP1C5.setText("jRadioButton1");

        jRadioButtonP1C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C6);
        jRadioButtonP1C6.setText("jRadioButton1");

        jRadioButtonP1C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C7);
        jRadioButtonP1C7.setText("jRadioButton1");

        jRadioButtonP1C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C8);
        jRadioButtonP1C8.setText("jRadioButton1");

        jRadioButtonP1C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C1);
        jRadioButtonP1C1.setText("jRadioButton1");
        jRadioButtonP1C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP1C1ActionPerformed(evt);
            }
        });

        jRadioButtonP1C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C3);
        jRadioButtonP1C3.setText("jRadioButton1");

        jRadioButtonPartai1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai1);
        jRadioButtonPartai1.setText("Partai 1");

        jRadioButtonP1C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP1C2);
        jRadioButtonP1C2.setText("jRadioButton1");

        jRadioButtonP2C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C1);
        jRadioButtonP2C1.setText("jRadioButton1");

        jRadioButtonP2C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C4);
        jRadioButtonP2C4.setText("jRadioButton1");

        jRadioButtonP2C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C2);
        jRadioButtonP2C2.setText("jRadioButton1");

        jRadioButtonP2C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C5);
        jRadioButtonP2C5.setText("jRadioButton1");

        jRadioButtonP2C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C3);
        jRadioButtonP2C3.setText("jRadioButton1");

        jRadioButtonP2C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C6);
        jRadioButtonP2C6.setText("jRadioButton1");

        jRadioButtonP2C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C8);
        jRadioButtonP2C8.setText("jRadioButton1");

        jRadioButtonP2C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP2C7);
        jRadioButtonP2C7.setText("jRadioButton1");

        jRadioButtonPartai2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai2);
        jRadioButtonPartai2.setText("Partai 2");

        jRadioButtonP3C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C8);
        jRadioButtonP3C8.setText("jRadioButton1");

        jRadioButtonP3C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C6);
        jRadioButtonP3C6.setText("jRadioButton1");

        jRadioButtonP3C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C7);
        jRadioButtonP3C7.setText("jRadioButton1");

        jRadioButtonP3C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C2);
        jRadioButtonP3C2.setText("jRadioButton1");

        jRadioButtonP3C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C1);
        jRadioButtonP3C1.setText("jRadioButton1");

        jRadioButtonPartai3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai3);
        jRadioButtonPartai3.setText("Partai 3");

        jRadioButtonP3C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C4);
        jRadioButtonP3C4.setText("jRadioButton1");

        jRadioButtonP3C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C3);
        jRadioButtonP3C3.setText("jRadioButton1");

        jRadioButtonP3C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP3C5);
        jRadioButtonP3C5.setText("jRadioButton1");
        jRadioButtonP3C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP3C5ActionPerformed(evt);
            }
        });

        jRadioButtonP4C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C1);
        jRadioButtonP4C1.setText("jRadioButton1");

        jRadioButtonP4C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C8);
        jRadioButtonP4C8.setText("jRadioButton1");

        jRadioButtonP4C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C5);
        jRadioButtonP4C5.setText("jRadioButton1");

        jRadioButtonP4C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C4);
        jRadioButtonP4C4.setText("jRadioButton1");

        jRadioButtonP4C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C3);
        jRadioButtonP4C3.setText("jRadioButton1");

        jRadioButtonP4C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C2);
        jRadioButtonP4C2.setText("jRadioButton1");

        jRadioButtonPartai4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai4);
        jRadioButtonPartai4.setText("Partai 4");
        jRadioButtonPartai4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPartai4ActionPerformed(evt);
            }
        });

        jRadioButtonP4C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C7);
        jRadioButtonP4C7.setText("jRadioButton1");

        jRadioButtonP4C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP4C6);
        jRadioButtonP4C6.setText("jRadioButton1");

        jRadioButtonP5C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C1);
        jRadioButtonP5C1.setText("jRadioButton1");

        jRadioButtonP5C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C2);
        jRadioButtonP5C2.setText("jRadioButton1");

        jRadioButtonP5C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C3);
        jRadioButtonP5C3.setText("jRadioButton1");

        jRadioButtonP5C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C4);
        jRadioButtonP5C4.setText("jRadioButton1");

        jRadioButtonPartai5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai5);
        jRadioButtonPartai5.setText("Partai 5");

        jRadioButtonP5C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C6);
        jRadioButtonP5C6.setText("jRadioButton1");

        jRadioButtonP5C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C5);
        jRadioButtonP5C5.setText("jRadioButton1");

        jRadioButtonP5C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C8);
        jRadioButtonP5C8.setText("jRadioButton1");

        jRadioButtonP5C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP5C7);
        jRadioButtonP5C7.setText("jRadioButton1");

        jRadioButtonP6C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C7);
        jRadioButtonP6C7.setText("jRadioButton1");

        jRadioButtonP6C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C8);
        jRadioButtonP6C8.setText("jRadioButton1");
        jRadioButtonP6C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP6C8ActionPerformed(evt);
            }
        });

        jRadioButtonP6C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C5);
        jRadioButtonP6C5.setText("jRadioButton1");

        jRadioButtonP6C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C6);
        jRadioButtonP6C6.setText("jRadioButton1");

        jRadioButtonP6C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C3);
        jRadioButtonP6C3.setText("jRadioButton1");

        jRadioButtonP6C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C4);
        jRadioButtonP6C4.setText("jRadioButton1");

        jRadioButtonP6C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C2);
        jRadioButtonP6C2.setText("jRadioButton1");

        jRadioButtonPartai6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai6);
        jRadioButtonPartai6.setText("Partai 6");

        jRadioButtonP6C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP6C1);
        jRadioButtonP6C1.setText("jRadioButton1");

        jRadioButtonP7C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C3);
        jRadioButtonP7C3.setText("jRadioButton1");

        jRadioButtonP7C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C1);
        jRadioButtonP7C1.setText("jRadioButton1");

        jRadioButtonP7C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C2);
        jRadioButtonP7C2.setText("jRadioButton1");

        jRadioButtonPartai7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai7);
        jRadioButtonPartai7.setText("Partai 7");

        jRadioButtonP7C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C7);
        jRadioButtonP7C7.setText("jRadioButton1");

        jRadioButtonP7C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C6);
        jRadioButtonP7C6.setText("jRadioButton1");

        jRadioButtonP7C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C5);
        jRadioButtonP7C5.setText("jRadioButton1");

        jRadioButtonP7C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C4);
        jRadioButtonP7C4.setText("jRadioButton1");

        jRadioButtonP7C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP7C8);
        jRadioButtonP7C8.setText("jRadioButton1");

        jRadioButtonPartai8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai8);
        jRadioButtonPartai8.setText("Partai 8");

        jRadioButtonP8C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C5);
        jRadioButtonP8C5.setText("jRadioButton1");

        jRadioButtonP8C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C4);
        jRadioButtonP8C4.setText("jRadioButton1");

        jRadioButtonP8C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C3);
        jRadioButtonP8C3.setText("jRadioButton1");

        jRadioButtonP8C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C2);
        jRadioButtonP8C2.setText("jRadioButton1");

        jRadioButtonP8C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C1);
        jRadioButtonP8C1.setText("jRadioButton1");

        jRadioButtonP8C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C8);
        jRadioButtonP8C8.setText("jRadioButton1");

        jRadioButtonP8C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C7);
        jRadioButtonP8C7.setText("jRadioButton1");
        jRadioButtonP8C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP8C7ActionPerformed(evt);
            }
        });

        jRadioButtonP8C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP8C6);
        jRadioButtonP8C6.setText("jRadioButton1");

        jRadioButtonP9C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C8);
        jRadioButtonP9C8.setText("jRadioButton1");

        jRadioButtonPartai9.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai9);
        jRadioButtonPartai9.setText("Partai 9");

        jRadioButtonP9C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C2);
        jRadioButtonP9C2.setText("jRadioButton1");

        jRadioButtonP9C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C1);
        jRadioButtonP9C1.setText("jRadioButton1");

        jRadioButtonP9C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C7);
        jRadioButtonP9C7.setText("jRadioButton1");

        jRadioButtonP9C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C4);
        jRadioButtonP9C4.setText("jRadioButton1");

        jRadioButtonP9C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C3);
        jRadioButtonP9C3.setText("jRadioButton1");

        jRadioButtonP9C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C6);
        jRadioButtonP9C6.setText("jRadioButton1");

        jRadioButtonP9C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP9C5);
        jRadioButtonP9C5.setText("jRadioButton1");

        jRadioButtonP10C1.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C1);
        jRadioButtonP10C1.setText("jRadioButton1");

        jRadioButtonP10C5.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C5);
        jRadioButtonP10C5.setText("jRadioButton1");

        jRadioButtonP10C4.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C4);
        jRadioButtonP10C4.setText("jRadioButton1");

        jRadioButtonP10C3.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C3);
        jRadioButtonP10C3.setText("jRadioButton1");

        jRadioButtonP10C2.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C2);
        jRadioButtonP10C2.setText("jRadioButton1");

        jRadioButtonP10C8.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C8);
        jRadioButtonP10C8.setText("jRadioButton1");

        jRadioButtonP10C7.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C7);
        jRadioButtonP10C7.setText("jRadioButton1");

        jRadioButtonP10C6.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonP10C6);
        jRadioButtonP10C6.setText("jRadioButton1");

        jRadioButtonPartai10.setBackground(new java.awt.Color(255, 255, 255));
        Pilihan.add(jRadioButtonPartai10);
        jRadioButtonPartai10.setText("Partai 10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButtonP1C1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP1C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP1C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP1C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP1C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP1C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP1C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP1C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonPartai1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP6C1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP6C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP6C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP6C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP6C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP6C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP6C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP6C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonPartai6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButtonP2C1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP2C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP2C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP2C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP2C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP2C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP2C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP2C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonPartai2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP7C1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP7C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP7C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP7C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP7C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP7C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP7C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP7C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonPartai7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButtonP3C1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP3C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP3C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP3C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP3C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP3C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP3C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP3C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonPartai3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonPartai8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP8C1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP8C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP8C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP8C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP8C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP8C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP8C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP8C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButtonP4C1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jRadioButtonPartai4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP4C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP4C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP4C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP4C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP4C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP4C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP4C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonPartai9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP9C1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP9C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP9C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP9C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP9C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP9C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP9C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP9C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButtonP5C1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP5C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP5C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP5C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP5C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP5C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP5C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP5C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonPartai5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonPartai10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP10C1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP10C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP10C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP10C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP10C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP10C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP10C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonP10C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
            .addComponent(jLabelLingkup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Dapil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NoDapil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLingkup)
                .addGap(7, 7, 7)
                .addComponent(Dapil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoDapil)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jRadioButtonPartai5)
                        .addGap(12, 12, 12)
                        .addComponent(jRadioButtonP5C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP5C2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP5C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP5C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP5C5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP5C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP5C7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP5C8)
                        .addGap(27, 27, 27)
                        .addComponent(jRadioButtonPartai10)
                        .addGap(12, 12, 12)
                        .addComponent(jRadioButtonP10C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP10C2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP10C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP10C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP10C5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP10C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP10C7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP10C8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonPartai1)
                                .addGap(12, 12, 12)
                                .addComponent(jRadioButtonP1C1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jRadioButtonP1C3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP1C4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP1C5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP1C6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP1C7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP1C2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP1C8))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jRadioButtonPartai4)
                                    .addGap(12, 12, 12)
                                    .addComponent(jRadioButtonP4C1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButtonP4C2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButtonP4C3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButtonP4C4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButtonP4C5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButtonP4C6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButtonP4C7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButtonP4C8))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButtonPartai3)
                                        .addGap(12, 12, 12)
                                        .addComponent(jRadioButtonP3C1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP3C2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP3C3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP3C4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP3C5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP3C6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP3C7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP3C8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButtonPartai2)
                                        .addGap(12, 12, 12)
                                        .addComponent(jRadioButtonP2C1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP2C2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP2C3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP2C4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP2C5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP2C6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP2C7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonP2C8)))))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jRadioButtonPartai9)
                                .addGap(12, 12, 12)
                                .addComponent(jRadioButtonP9C1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP9C2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP9C3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP9C4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP9C5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP9C6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP9C7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP9C8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jRadioButtonPartai6)
                                .addGap(12, 12, 12)
                                .addComponent(jRadioButtonP6C1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP6C2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP6C3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP6C4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP6C5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP6C6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP6C7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP6C8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jRadioButtonPartai7)
                                .addGap(12, 12, 12)
                                .addComponent(jRadioButtonP7C1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP7C2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP7C3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP7C4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP7C5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP7C6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP7C7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP7C8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jRadioButtonPartai8)
                                .addGap(12, 12, 12)
                                .addComponent(jRadioButtonP8C1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP8C2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP8C3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP8C4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP8C5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP8C6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP8C7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonP8C8)))))
                .addGap(18, 18, 18)
                .addComponent(Submit)
                .addContainerGap())
        );

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DPR;
    private javax.swing.JPanel DPR1;
    private javax.swing.JPanel DPR2;
    private javax.swing.JPanel DPR3;
    private javax.swing.JLabel Dapil;
    private javax.swing.JLabel NoDapil;
    private javax.swing.JLabel Partai10DPR;
    private javax.swing.JLabel Partai10DPR1;
    private javax.swing.JLabel Partai10DPR2;
    private javax.swing.JLabel Partai10DPR3;
    private javax.swing.JLabel Partai1DPR;
    private javax.swing.JLabel Partai1DPR1;
    private javax.swing.JLabel Partai1DPR2;
    private javax.swing.JLabel Partai1DPR3;
    private javax.swing.JLabel Partai2DPR;
    private javax.swing.JLabel Partai2DPR1;
    private javax.swing.JLabel Partai2DPR2;
    private javax.swing.JLabel Partai2DPR3;
    private javax.swing.JLabel Partai3DPR;
    private javax.swing.JLabel Partai3DPR1;
    private javax.swing.JLabel Partai3DPR2;
    private javax.swing.JLabel Partai3DPR3;
    private javax.swing.JLabel Partai4DPR;
    private javax.swing.JLabel Partai4DPR1;
    private javax.swing.JLabel Partai4DPR2;
    private javax.swing.JLabel Partai4DPR3;
    private javax.swing.JLabel Partai5DPR;
    private javax.swing.JLabel Partai5DPR1;
    private javax.swing.JLabel Partai5DPR2;
    private javax.swing.JLabel Partai5DPR3;
    private javax.swing.JLabel Partai6DPR;
    private javax.swing.JLabel Partai6DPR1;
    private javax.swing.JLabel Partai6DPR2;
    private javax.swing.JLabel Partai6DPR3;
    private javax.swing.JLabel Partai7DPR;
    private javax.swing.JLabel Partai7DPR1;
    private javax.swing.JLabel Partai7DPR2;
    private javax.swing.JLabel Partai7DPR3;
    private javax.swing.JLabel Partai8DPR;
    private javax.swing.JLabel Partai8DPR1;
    private javax.swing.JLabel Partai8DPR2;
    private javax.swing.JLabel Partai8DPR3;
    private javax.swing.JLabel Partai9DPR;
    private javax.swing.JLabel Partai9DPR1;
    private javax.swing.JLabel Partai9DPR2;
    private javax.swing.JLabel Partai9DPR3;
    private javax.swing.ButtonGroup Pilihan;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel jLabelLingkup;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton100;
    private javax.swing.JRadioButton jRadioButton101;
    private javax.swing.JRadioButton jRadioButton102;
    private javax.swing.JRadioButton jRadioButton103;
    private javax.swing.JRadioButton jRadioButton104;
    private javax.swing.JRadioButton jRadioButton105;
    private javax.swing.JRadioButton jRadioButton106;
    private javax.swing.JRadioButton jRadioButton107;
    private javax.swing.JRadioButton jRadioButton108;
    private javax.swing.JRadioButton jRadioButton109;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton110;
    private javax.swing.JRadioButton jRadioButton111;
    private javax.swing.JRadioButton jRadioButton112;
    private javax.swing.JRadioButton jRadioButton113;
    private javax.swing.JRadioButton jRadioButton114;
    private javax.swing.JRadioButton jRadioButton115;
    private javax.swing.JRadioButton jRadioButton116;
    private javax.swing.JRadioButton jRadioButton117;
    private javax.swing.JRadioButton jRadioButton118;
    private javax.swing.JRadioButton jRadioButton119;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton120;
    private javax.swing.JRadioButton jRadioButton121;
    private javax.swing.JRadioButton jRadioButton122;
    private javax.swing.JRadioButton jRadioButton123;
    private javax.swing.JRadioButton jRadioButton124;
    private javax.swing.JRadioButton jRadioButton125;
    private javax.swing.JRadioButton jRadioButton126;
    private javax.swing.JRadioButton jRadioButton127;
    private javax.swing.JRadioButton jRadioButton128;
    private javax.swing.JRadioButton jRadioButton129;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton130;
    private javax.swing.JRadioButton jRadioButton131;
    private javax.swing.JRadioButton jRadioButton132;
    private javax.swing.JRadioButton jRadioButton133;
    private javax.swing.JRadioButton jRadioButton134;
    private javax.swing.JRadioButton jRadioButton135;
    private javax.swing.JRadioButton jRadioButton136;
    private javax.swing.JRadioButton jRadioButton137;
    private javax.swing.JRadioButton jRadioButton138;
    private javax.swing.JRadioButton jRadioButton139;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton140;
    private javax.swing.JRadioButton jRadioButton141;
    private javax.swing.JRadioButton jRadioButton142;
    private javax.swing.JRadioButton jRadioButton143;
    private javax.swing.JRadioButton jRadioButton144;
    private javax.swing.JRadioButton jRadioButton145;
    private javax.swing.JRadioButton jRadioButton146;
    private javax.swing.JRadioButton jRadioButton147;
    private javax.swing.JRadioButton jRadioButton148;
    private javax.swing.JRadioButton jRadioButton149;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton150;
    private javax.swing.JRadioButton jRadioButton151;
    private javax.swing.JRadioButton jRadioButton152;
    private javax.swing.JRadioButton jRadioButton153;
    private javax.swing.JRadioButton jRadioButton154;
    private javax.swing.JRadioButton jRadioButton155;
    private javax.swing.JRadioButton jRadioButton156;
    private javax.swing.JRadioButton jRadioButton157;
    private javax.swing.JRadioButton jRadioButton158;
    private javax.swing.JRadioButton jRadioButton159;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton160;
    private javax.swing.JRadioButton jRadioButton161;
    private javax.swing.JRadioButton jRadioButton162;
    private javax.swing.JRadioButton jRadioButton163;
    private javax.swing.JRadioButton jRadioButton164;
    private javax.swing.JRadioButton jRadioButton165;
    private javax.swing.JRadioButton jRadioButton166;
    private javax.swing.JRadioButton jRadioButton167;
    private javax.swing.JRadioButton jRadioButton168;
    private javax.swing.JRadioButton jRadioButton169;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton170;
    private javax.swing.JRadioButton jRadioButton171;
    private javax.swing.JRadioButton jRadioButton172;
    private javax.swing.JRadioButton jRadioButton173;
    private javax.swing.JRadioButton jRadioButton174;
    private javax.swing.JRadioButton jRadioButton175;
    private javax.swing.JRadioButton jRadioButton176;
    private javax.swing.JRadioButton jRadioButton177;
    private javax.swing.JRadioButton jRadioButton178;
    private javax.swing.JRadioButton jRadioButton179;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton180;
    private javax.swing.JRadioButton jRadioButton181;
    private javax.swing.JRadioButton jRadioButton182;
    private javax.swing.JRadioButton jRadioButton183;
    private javax.swing.JRadioButton jRadioButton184;
    private javax.swing.JRadioButton jRadioButton185;
    private javax.swing.JRadioButton jRadioButton186;
    private javax.swing.JRadioButton jRadioButton187;
    private javax.swing.JRadioButton jRadioButton188;
    private javax.swing.JRadioButton jRadioButton189;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton190;
    private javax.swing.JRadioButton jRadioButton191;
    private javax.swing.JRadioButton jRadioButton192;
    private javax.swing.JRadioButton jRadioButton193;
    private javax.swing.JRadioButton jRadioButton194;
    private javax.swing.JRadioButton jRadioButton195;
    private javax.swing.JRadioButton jRadioButton196;
    private javax.swing.JRadioButton jRadioButton197;
    private javax.swing.JRadioButton jRadioButton198;
    private javax.swing.JRadioButton jRadioButton199;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton200;
    private javax.swing.JRadioButton jRadioButton201;
    private javax.swing.JRadioButton jRadioButton202;
    private javax.swing.JRadioButton jRadioButton203;
    private javax.swing.JRadioButton jRadioButton204;
    private javax.swing.JRadioButton jRadioButton205;
    private javax.swing.JRadioButton jRadioButton206;
    private javax.swing.JRadioButton jRadioButton207;
    private javax.swing.JRadioButton jRadioButton208;
    private javax.swing.JRadioButton jRadioButton209;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton210;
    private javax.swing.JRadioButton jRadioButton211;
    private javax.swing.JRadioButton jRadioButton212;
    private javax.swing.JRadioButton jRadioButton213;
    private javax.swing.JRadioButton jRadioButton214;
    private javax.swing.JRadioButton jRadioButton215;
    private javax.swing.JRadioButton jRadioButton216;
    private javax.swing.JRadioButton jRadioButton217;
    private javax.swing.JRadioButton jRadioButton218;
    private javax.swing.JRadioButton jRadioButton219;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton220;
    private javax.swing.JRadioButton jRadioButton221;
    private javax.swing.JRadioButton jRadioButton222;
    private javax.swing.JRadioButton jRadioButton223;
    private javax.swing.JRadioButton jRadioButton224;
    private javax.swing.JRadioButton jRadioButton225;
    private javax.swing.JRadioButton jRadioButton226;
    private javax.swing.JRadioButton jRadioButton227;
    private javax.swing.JRadioButton jRadioButton228;
    private javax.swing.JRadioButton jRadioButton229;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton230;
    private javax.swing.JRadioButton jRadioButton231;
    private javax.swing.JRadioButton jRadioButton232;
    private javax.swing.JRadioButton jRadioButton233;
    private javax.swing.JRadioButton jRadioButton234;
    private javax.swing.JRadioButton jRadioButton235;
    private javax.swing.JRadioButton jRadioButton236;
    private javax.swing.JRadioButton jRadioButton237;
    private javax.swing.JRadioButton jRadioButton238;
    private javax.swing.JRadioButton jRadioButton239;
    private javax.swing.JRadioButton jRadioButton24;
    private javax.swing.JRadioButton jRadioButton240;
    private javax.swing.JRadioButton jRadioButton241;
    private javax.swing.JRadioButton jRadioButton242;
    private javax.swing.JRadioButton jRadioButton243;
    private javax.swing.JRadioButton jRadioButton244;
    private javax.swing.JRadioButton jRadioButton245;
    private javax.swing.JRadioButton jRadioButton246;
    private javax.swing.JRadioButton jRadioButton247;
    private javax.swing.JRadioButton jRadioButton248;
    private javax.swing.JRadioButton jRadioButton249;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton250;
    private javax.swing.JRadioButton jRadioButton251;
    private javax.swing.JRadioButton jRadioButton252;
    private javax.swing.JRadioButton jRadioButton253;
    private javax.swing.JRadioButton jRadioButton254;
    private javax.swing.JRadioButton jRadioButton255;
    private javax.swing.JRadioButton jRadioButton256;
    private javax.swing.JRadioButton jRadioButton257;
    private javax.swing.JRadioButton jRadioButton258;
    private javax.swing.JRadioButton jRadioButton259;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton260;
    private javax.swing.JRadioButton jRadioButton261;
    private javax.swing.JRadioButton jRadioButton262;
    private javax.swing.JRadioButton jRadioButton263;
    private javax.swing.JRadioButton jRadioButton264;
    private javax.swing.JRadioButton jRadioButton265;
    private javax.swing.JRadioButton jRadioButton266;
    private javax.swing.JRadioButton jRadioButton267;
    private javax.swing.JRadioButton jRadioButton268;
    private javax.swing.JRadioButton jRadioButton269;
    private javax.swing.JRadioButton jRadioButton27;
    private javax.swing.JRadioButton jRadioButton270;
    private javax.swing.JRadioButton jRadioButton271;
    private javax.swing.JRadioButton jRadioButton272;
    private javax.swing.JRadioButton jRadioButton273;
    private javax.swing.JRadioButton jRadioButton274;
    private javax.swing.JRadioButton jRadioButton275;
    private javax.swing.JRadioButton jRadioButton276;
    private javax.swing.JRadioButton jRadioButton277;
    private javax.swing.JRadioButton jRadioButton278;
    private javax.swing.JRadioButton jRadioButton279;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton280;
    private javax.swing.JRadioButton jRadioButton281;
    private javax.swing.JRadioButton jRadioButton282;
    private javax.swing.JRadioButton jRadioButton283;
    private javax.swing.JRadioButton jRadioButton284;
    private javax.swing.JRadioButton jRadioButton285;
    private javax.swing.JRadioButton jRadioButton286;
    private javax.swing.JRadioButton jRadioButton287;
    private javax.swing.JRadioButton jRadioButton288;
    private javax.swing.JRadioButton jRadioButton289;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton290;
    private javax.swing.JRadioButton jRadioButton291;
    private javax.swing.JRadioButton jRadioButton292;
    private javax.swing.JRadioButton jRadioButton293;
    private javax.swing.JRadioButton jRadioButton294;
    private javax.swing.JRadioButton jRadioButton295;
    private javax.swing.JRadioButton jRadioButton296;
    private javax.swing.JRadioButton jRadioButton297;
    private javax.swing.JRadioButton jRadioButton298;
    private javax.swing.JRadioButton jRadioButton299;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton300;
    private javax.swing.JRadioButton jRadioButton301;
    private javax.swing.JRadioButton jRadioButton302;
    private javax.swing.JRadioButton jRadioButton303;
    private javax.swing.JRadioButton jRadioButton304;
    private javax.swing.JRadioButton jRadioButton305;
    private javax.swing.JRadioButton jRadioButton306;
    private javax.swing.JRadioButton jRadioButton307;
    private javax.swing.JRadioButton jRadioButton308;
    private javax.swing.JRadioButton jRadioButton309;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton310;
    private javax.swing.JRadioButton jRadioButton311;
    private javax.swing.JRadioButton jRadioButton312;
    private javax.swing.JRadioButton jRadioButton313;
    private javax.swing.JRadioButton jRadioButton314;
    private javax.swing.JRadioButton jRadioButton315;
    private javax.swing.JRadioButton jRadioButton316;
    private javax.swing.JRadioButton jRadioButton317;
    private javax.swing.JRadioButton jRadioButton318;
    private javax.swing.JRadioButton jRadioButton319;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton320;
    private javax.swing.JRadioButton jRadioButton33;
    private javax.swing.JRadioButton jRadioButton34;
    private javax.swing.JRadioButton jRadioButton35;
    private javax.swing.JRadioButton jRadioButton36;
    private javax.swing.JRadioButton jRadioButton37;
    private javax.swing.JRadioButton jRadioButton38;
    private javax.swing.JRadioButton jRadioButton39;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton40;
    private javax.swing.JRadioButton jRadioButton41;
    private javax.swing.JRadioButton jRadioButton42;
    private javax.swing.JRadioButton jRadioButton43;
    private javax.swing.JRadioButton jRadioButton44;
    private javax.swing.JRadioButton jRadioButton45;
    private javax.swing.JRadioButton jRadioButton46;
    private javax.swing.JRadioButton jRadioButton47;
    private javax.swing.JRadioButton jRadioButton48;
    private javax.swing.JRadioButton jRadioButton49;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton50;
    private javax.swing.JRadioButton jRadioButton51;
    private javax.swing.JRadioButton jRadioButton52;
    private javax.swing.JRadioButton jRadioButton53;
    private javax.swing.JRadioButton jRadioButton54;
    private javax.swing.JRadioButton jRadioButton55;
    private javax.swing.JRadioButton jRadioButton56;
    private javax.swing.JRadioButton jRadioButton57;
    private javax.swing.JRadioButton jRadioButton58;
    private javax.swing.JRadioButton jRadioButton59;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton60;
    private javax.swing.JRadioButton jRadioButton61;
    private javax.swing.JRadioButton jRadioButton62;
    private javax.swing.JRadioButton jRadioButton63;
    private javax.swing.JRadioButton jRadioButton64;
    private javax.swing.JRadioButton jRadioButton65;
    private javax.swing.JRadioButton jRadioButton66;
    private javax.swing.JRadioButton jRadioButton67;
    private javax.swing.JRadioButton jRadioButton68;
    private javax.swing.JRadioButton jRadioButton69;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton70;
    private javax.swing.JRadioButton jRadioButton71;
    private javax.swing.JRadioButton jRadioButton72;
    private javax.swing.JRadioButton jRadioButton73;
    private javax.swing.JRadioButton jRadioButton74;
    private javax.swing.JRadioButton jRadioButton75;
    private javax.swing.JRadioButton jRadioButton76;
    private javax.swing.JRadioButton jRadioButton77;
    private javax.swing.JRadioButton jRadioButton78;
    private javax.swing.JRadioButton jRadioButton79;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton80;
    private javax.swing.JRadioButton jRadioButton81;
    private javax.swing.JRadioButton jRadioButton82;
    private javax.swing.JRadioButton jRadioButton83;
    private javax.swing.JRadioButton jRadioButton84;
    private javax.swing.JRadioButton jRadioButton85;
    private javax.swing.JRadioButton jRadioButton86;
    private javax.swing.JRadioButton jRadioButton87;
    private javax.swing.JRadioButton jRadioButton88;
    private javax.swing.JRadioButton jRadioButton89;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JRadioButton jRadioButton90;
    private javax.swing.JRadioButton jRadioButton91;
    private javax.swing.JRadioButton jRadioButton92;
    private javax.swing.JRadioButton jRadioButton93;
    private javax.swing.JRadioButton jRadioButton94;
    private javax.swing.JRadioButton jRadioButton95;
    private javax.swing.JRadioButton jRadioButton96;
    private javax.swing.JRadioButton jRadioButton97;
    private javax.swing.JRadioButton jRadioButton98;
    private javax.swing.JRadioButton jRadioButton99;
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