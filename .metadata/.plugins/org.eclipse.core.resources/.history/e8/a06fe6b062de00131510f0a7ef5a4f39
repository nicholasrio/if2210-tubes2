package org;

 import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    import java.util.ArrayList;
    import java.io.*;

public class UserUI extends JFrame{
    
    private JTabbedPane pane;               // Tabbed pane
    private JPanel top;                     // panel paling atas
    private JPanel mycollectionPanel;       // panel mycollection pada tabbed pane
    private JPanel explorerPanel;           // panel explorer pada tabbed pane
    private JLabel label1, label2;          // label
    private JTextField textfield;           // area teks
    private JButton button1;                // tombol
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UserUI(){
        
        top = new JPanel();
        top.setLayout(new BorderLayout());
        getContentPane().add(top);
        
        createPage1();
        createPage2();
        
        pane = new JTabbedPane();
        pane.addTab("My Collection", mycollectionPanel);
        pane.addTab("Explorer", explorerPanel);
        top.add(pane, BorderLayout.CENTER);
    }
    
    public void createPage1(){
        mycollectionPanel = new JPanel();
        mycollectionPanel.setLayout(new BoxLayout(mycollectionPanel, BoxLayout.Y_AXIS));
        
        /*label1 = new JLabel("Koleksi Buku Pribadi");
        mycollectionPanel.add(label1);
        label2 = new JLabel(new ImageIcon("D:\\Kuliah\\Latihan\\Java\\Coding\\Test\\src\\test\\a.jpg"));
        mycollectionPanel.add(label2);
        */
        try{
            BufferedReader read = new BufferedReader(new FileReader("D:\\Kuliah\\Latihan\\Java\\Coding\\Test\\src\\test\\input.txt"));
            ArrayList<String> Pilihan = new ArrayList<>();
            String opsi;
            int count = 0;
            while((opsi = read.readLine()) != null){
                Pilihan.add(opsi);
                count++;
            }
            read.close();
            for(int i = 0; i<count;i++){
                JCheckBox pilihan = new JCheckBox("Opsi" + i);
                mycollectionPanel.add(pilihan);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
                
        button1 = new JButton("Hapus");
        mycollectionPanel.add(button1);
        
    }
    
    public void createPage2(){
        explorerPanel = new JPanel();
        explorerPanel.setLayout(new FlowLayout());
        
        textfield = new JTextField(20 );
        explorerPanel.add(textfield);
        
        label1 = new JLabel("Masukkan query pencarian");
        explorerPanel.add(label1);
        
        button1 = new JButton("Cari");
        explorerPanel.add(button1);
        
        //UserUI3 tm3 = new UserUI3();
    //    explorerPanel.add(tm3);
    }
}
