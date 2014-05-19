package Group;

import Main.MenuLoginAdmin;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hendro Triokta Brianto - 13512081
 */
public class GroupJFrame extends javax.swing.JFrame {
    
    Group g;
    private List<String> aList;
    
    /**
     * Creates new form GroupJFrame
     */
    public GroupJFrame() {
        initComponents();
        this.g = new Group();
        aList = new ArrayList<>();
        temp_kel.setVisible(false);
        temp_tubes.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_save = new javax.swing.JButton();
        no_tubes = new javax.swing.JTextField();
        group_name = new javax.swing.JTextField();
        anggota_1 = new javax.swing.JTextField();
        anggota_2 = new javax.swing.JTextField();
        anggota_3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        b_back = new javax.swing.JButton();
        temp_tubes = new javax.swing.JLabel();
        temp_kel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        b_save.setText("Save");
        b_save.setToolTipText("Menyimpan data");
        b_save.setName(""); // NOI18N
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        no_tubes.setToolTipText("");
        no_tubes.setName("no_tubes"); // NOI18N

        jLabel1.setText("No Tubes");

        jLabel2.setText("Nama Kelompok");

        jLabel3.setText("Anggota 1");

        jLabel4.setText("Anggota 2");

        jLabel5.setText("Anggota 3");

        b_back.setText("Back");
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(anggota_1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(anggota_2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(115, 115, 115))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(no_tubes, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b_back)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(temp_kel)
                            .addComponent(temp_tubes)))
                    .addComponent(anggota_3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(b_save)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(no_tubes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(temp_tubes)
                    .addComponent(b_back))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(group_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(temp_kel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anggota_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anggota_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anggota_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(b_save)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * menyimpan data baru
     * @param evt 
     */
    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed

        
        if(!cek()){
            JOptionPane.showMessageDialog(rootPane, "Nomor Tubes dan Nama Kelompok harus diisi..!", "KatalogV Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Apa anda yakin untuk menyimpan data ini?","Warning",dialogButton);

            if(dialogResult == JOptionPane.YES_OPTION){
                try {
                    g.setNo_tubes(Integer.parseInt(no_tubes.getText()));
                    g.setGroup_name(group_name.getText());
                    aList.add(anggota_1.getText());
                    aList.add(anggota_2.getText());
                    aList.add(anggota_3.getText());

                    g.setMember(aList);

                    g.save();

                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan...");
                    clean();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ada Kesalahan...");
                    Logger.getLogger(GroupJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_b_saveActionPerformed

    /**
     * inisisalisasi form ketika baru active
     * @param evt 
     */
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        final int WIDTH = screenSize.width;
        final int HEIGHT = screenSize.height;
        int lebar = (int) this.getSize().getWidth() / 2;
        int tinggi = (int) this.getSize().getHeight() / 2;
        // Setup the frame accordingly
        // This is assuming you are extending the JFrame //class
        this.setLocation((WIDTH/2) - lebar, (HEIGHT/2) - tinggi);
    }//GEN-LAST:event_formWindowActivated

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        new MenuLoginAdmin().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_b_backActionPerformed

    /**
     * 
     * Mengosongkan JTeksField
     */
    public void clean(){
        no_tubes.setText("");
        group_name.setText("");
        anggota_1.setText("");
        anggota_2.setText("");
        anggota_3.setText("");
        
        aList.clear();
    }
    
    /**
     * 
     * mengecek kekosongan JTeksField
     * @return 
     */
    public boolean cek(){
        if(no_tubes.getText().equals("") || group_name.getText().equals("")){
            return false;
        }
        else{
            return true;
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anggota_1;
    private javax.swing.JTextField anggota_2;
    private javax.swing.JTextField anggota_3;
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_save;
    private javax.swing.JTextField group_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField no_tubes;
    private javax.swing.JLabel temp_kel;
    private javax.swing.JLabel temp_tubes;
    // End of variables declaration//GEN-END:variables
}
