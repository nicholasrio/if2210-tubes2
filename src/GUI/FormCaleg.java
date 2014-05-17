/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Tools.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import main.Caleg;
import main.CalonTerpilih;

/**
 *
 * @author linda.sekawati
 */
public class FormCaleg extends javax.swing.JFrame {

    /**
     * Creates new form FormCaleg
     */
    private DefaultTableModel model;
    String Lingkup;
    CalonTerpilih calonterpilih,daftarCaleg;
  
    public FormCaleg(String lingkup) {
        initComponents();
        Lingkup = lingkup;
        if(lingkup.equals("DPRDKabupaten")){
            Lingkup="DPRD Kota/Kabupaten";
        }
        else if(lingkup.equals("DPRDProvinsi")){
            Lingkup="DPRD Provinsi";
        }
        this.setTitle(Lingkup);
        model = new DefaultTableModel();
        TabelCaleg.setModel(model);
        calonterpilih = new CalonTerpilih();
        daftarCaleg = new CalonTerpilih();
        
        
        model.addColumn("NIK");
        model.addColumn("Nama");
        model.addColumn("Partai");
        model.addColumn("No.Dapil");
        model.addColumn("History");
        loadData();
    }
    private void loadData()
    {
         
//        try
//        {
//            Connection koneksi = KoneksiDatabase.getKoneksi();
//            Statement statement = koneksi.createStatement();
//            
//            String commandGetCaleg = "select * from Caleg where Lingkup = " + Lingkup;
//            ResultSet resultCaleg = statement.executeQuery(commandGetCaleg);
//            while(resultCaleg.next())
//            {
////                daftarCaleg = new CalonTerpilih();
////                 daftarCaleg.addCaleg(new Caleg(resultCaleg.getString("NIKCaleg"), 
////                                            resultCaleg.getString("NamaPartai"), 
////                                            resultCaleg.getString("TrackRecord"), 
////                                            Integer.parseInt(resultCaleg.getString("NoDapil")), 
////                                            resultCaleg.getString("Lingkup")));
//            }
//            koneksi.close();
//        }
//        catch (SQLException ex) {
//            System.out.println("Error CalonTerpilih.java" + ex.getMessage());
//        }
//        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jColorChooser1 = new javax.swing.JColorChooser();
        jColorChooser2 = new javax.swing.JColorChooser();
        jColorChooser3 = new javax.swing.JColorChooser();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        KembaliFormAdmin = new javax.swing.JButton();
        NIK = new javax.swing.JTextField();
        Nama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Partai = new javax.swing.JTextField();
        Tambah = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelCaleg = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NoDapil = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        History = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Nama      :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("Partai     :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        KembaliFormAdmin.setBackground(java.awt.SystemColor.inactiveCaptionText);
        KembaliFormAdmin.setFont(new java.awt.Font("Belwe Bd BT", 0, 12)); // NOI18N
        KembaliFormAdmin.setForeground(new java.awt.Color(255, 153, 102));
        KembaliFormAdmin.setText("Kembali");
        KembaliFormAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliFormAdminActionPerformed(evt);
            }
        });
        getContentPane().add(KembaliFormAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        NIK.setBackground(new java.awt.Color(255, 255, 204));
        NIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIKActionPerformed(evt);
            }
        });
        getContentPane().add(NIK, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 152, -1));

        Nama.setBackground(new java.awt.Color(255, 255, 204));
        Nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaActionPerformed(evt);
            }
        });
        getContentPane().add(Nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 152, -1));

        jLabel7.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 204));
        jLabel7.setText("NIK         :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        Partai.setBackground(new java.awt.Color(255, 255, 204));
        Partai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PartaiActionPerformed(evt);
            }
        });
        getContentPane().add(Partai, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 153, -1));

        Tambah.setBackground(java.awt.SystemColor.inactiveCaptionText);
        Tambah.setFont(new java.awt.Font("Belwe Bd BT", 0, 12)); // NOI18N
        Tambah.setForeground(new java.awt.Color(255, 153, 102));
        Tambah.setText("Tambah");
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });
        getContentPane().add(Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 204));
        jLabel4.setText("Daftar Calon Legislatif");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        TabelCaleg.setBackground(new java.awt.Color(255, 255, 204));
        TabelCaleg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIK", "Partai", "No. Dapil", "History"
            }
        ));
        TabelCaleg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelCalegMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelCaleg);
        if (TabelCaleg.getColumnModel().getColumnCount() > 0) {
            TabelCaleg.getColumnModel().getColumn(0).setResizable(false);
            TabelCaleg.getColumnModel().getColumn(1).setResizable(false);
            TabelCaleg.getColumnModel().getColumn(2).setResizable(false);
            TabelCaleg.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 470, 300));

        jLabel5.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("No.Dapil :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("History   : ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        NoDapil.setBackground(new java.awt.Color(255, 255, 204));
        NoDapil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoDapilActionPerformed(evt);
            }
        });
        getContentPane().add(NoDapil, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 46, -1));

        History.setBackground(new java.awt.Color(255, 255, 204));
        History.setColumns(20);
        History.setRows(5);
        jScrollPane2.setViewportView(History);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 390, 85));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/shutterstock_47142253.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 140));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/shutterstock_47142253.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 590, 460));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/shutterstock_47142253.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 590, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIKActionPerformed

    private void PartaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PartaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PartaiActionPerformed

    private void NoDapilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoDapilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoDapilActionPerformed

    private void KembaliFormAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliFormAdminActionPerformed
        // TODO add your handling code here:
        this.dispose();
        FormAdmin FA = new FormAdmin();
        FA.setVisible(true);
    }//GEN-LAST:event_KembaliFormAdminActionPerformed

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
        // TODO add your handling code here:
        String nik = NIK.getText();
        String nama = Nama.getText();
        String partai = Partai.getText();
        String nodapil = NoDapil.getText();
        String history = History.getText();
        String lingkup = Lingkup;
        try
        {
            Connection c = KoneksiDatabase.getKoneksi();
            String sql = "INSERT INTO YukCoblos VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            calonterpilih = new CalonTerpilih();
            int nodapilInt = Integer.parseInt(nodapil);
            calonterpilih.AddCaleg(nik, nama, partai, history, nodapilInt, lingkup);
            
            p.setString(1, nik);
            p.setString(2, nama);
            p.setString(3, partai);
            p.setString(4, nodapil);
            p.setString(5, history);
//            p.setString(5, pilihcaleg);
            
            p.executeUpdate();
            p.close();
        }
        catch(SQLException e)
        {
            System.out.println("Terjadi Error");
        }
        finally
        {
            loadData();
        }
    }//GEN-LAST:event_TambahActionPerformed

    private void TabelCalegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelCalegMouseClicked
        // TODO add your handling code here:
        int i = TabelCaleg.getSelectedRow();
        if(i == -1){
            return;
        }
        
        String nik = (String) model.getValueAt(i, 0);
        NIK.setText(nik);
        
        String nama = (String) model.getValueAt(i, 1);
        NIK.setText(nama);
        
        String partai = (String) model.getValueAt(i, 2);
        Partai.setText(partai);
        
        String nodapil = (String) model.getValueAt(i, 3);
        NoDapil.setText(nodapil);
        
        String history = (String) model.getValueAt(i, 4);
        History.setText(history);
        
    }//GEN-LAST:event_TabelCalegMouseClicked

    private void NamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea History;
    private javax.swing.JButton KembaliFormAdmin;
    private javax.swing.JTextField NIK;
    private javax.swing.JTextField Nama;
    private javax.swing.JTextField NoDapil;
    private javax.swing.JTextField Partai;
    private javax.swing.JTable TabelCaleg;
    private javax.swing.JButton Tambah;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JColorChooser jColorChooser2;
    private javax.swing.JColorChooser jColorChooser3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
