/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package org;


import javax.swing.JFileChooser;
import javax.swing.JTable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.sql.*;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;


import java.util.Date;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

// test


public class MainMenu extends javax.swing.JFrame {


    /**
     * Creates new form MainMenu
     */
    public static JTable table;
    public MainMenu() throws SQLException {
        ArrayList<Object> columnNames = new ArrayList<>();
        ArrayList<Object> data = new ArrayList<>();

        //  Connect to an MySQL Database, run query, get result set
        // BERANTAKAN~~~~~~~~~~~~~
        String url = "jdbc:mysql://localhost:3306/bookbay";
        String userid = "root";
        String password = "";
        String sql = "SELECT name, description, uploader_id FROM book INNER JOIN collection ON book.id = collection.book_id " +
        				"WHERE user_id=(SELECT id FROM user WHERE username='"+LoginController.currUser.getID()+"')";

        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program 
        // is finished with them
        try (Connection connection = DriverManager.getConnection( url, userid, password );
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql ))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();


            //  Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.add( md.getColumnName(i) );
            }

            while (rs.next()) {
               ArrayList row = new ArrayList(columns);
               for (int i = 1; i <= columns; i++) {

                        row.add( rs.getObject(i) );
                    }


                    data.add( row );
                //}
            }



           }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();


        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }


        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));


        //  Create table with database data    
        System.out.println(columnNamesVector);
        table = new JTable(dataVector, columnNamesVector)
        {
            @Override
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);


                    if (o != null)
                    {
                        return o.getClass();
                    }
                }


                return Object.class;
            }
        };
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );


        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws SQLException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws SQLException {
        MainMenu = new javax.swing.JTabbedPane();
        MyCollections = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Upload = new javax.swing.JButton();

        Upload.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFileChooser fc = new JFileChooser();
        		
        		FileExt newFile;
        		
        		int retval = fc.showOpenDialog(MainMenu.this);
        		if(retval == JFileChooser.APPROVE_OPTION) {
        			try {
	        			File temp = fc.getSelectedFile();
	        			
	        			String category = (String) JOptionPane.showInputDialog(MainMenu.this, 
	        										"Select file category", 
	        										"File category",
	        										JOptionPane.QUESTION_MESSAGE,
	        										null,
	        										FileCategory.catStrings,
	        										FileCategory.catStrings[0]);
	        			if(category == null) {
	        				
	        			} else {
	        				String desc = JOptionPane.showInputDialog(MainMenu.this, "Describe the file");
	        				if(desc == null) {
	        					
	        				} else {
	        					newFile = new FileExt(temp.getAbsolutePath(), temp.getName(), LoginController.currUser, new Date(), desc, category);
	        					FileViewGUI uploadedFile = null;
	        					IFileController fcntl = new FileController(newFile, null);
	        					uploadedFile = new FileViewGUI(newFile, fcntl);
	        					fcntl.registerView(uploadedFile);
	        					
	        					fcntl.upload();
	        					
	        					int ret = JOptionPane.showConfirmDialog(MainMenu.this,
	        															"File successfully uploaded! Open viewer?",
	        															"Upload Success",
	        															JOptionPane.YES_NO_OPTION);
	        					if(ret == JOptionPane.YES_OPTION) {
	        						uploadedFile.setVisible(true);
	        					}
	        				}
	        			}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
        		}
        	}
        });

        Download = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        UserLabel = new javax.swing.JLabel();
        Browse = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        AddCollection = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("User :");


        jTable1.setModel(table.getModel());
        jScrollPane1.setViewportView(jTable1);

        Upload.setText("Upload");
        Download.setText("Download");
        
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });


        UserLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        UserLabel.setText(LoginController.currUser.name());
        UserLabel.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                UserLabelInputMethodTextChanged(evt);
            }
        });


        javax.swing.GroupLayout MyCollectionsLayout = new javax.swing.GroupLayout(MyCollections);
        MyCollectionsLayout.setHorizontalGroup(
            MyCollectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyCollectionsLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MyCollectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Upload, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(Download, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(MyCollectionsLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)));
        	MyCollectionsLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(MyCollectionsLayout.createSequentialGroup()
        			.addGroup(MyCollectionsLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(MyCollectionsLayout.createSequentialGroup()
        					.addGap(20)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(MyCollectionsLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(Exit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(Upload, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        						.addComponent(Download, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
        				.addGroup(MyCollectionsLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(UserLabel, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(71, Short.MAX_VALUE));

        MyCollectionsLayout.setVerticalGroup(
            MyCollectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyCollectionsLayout.createSequentialGroup()
                .addGroup(MyCollectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(UserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MyCollectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MyCollectionsLayout.createSequentialGroup()
                        .addComponent(Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Download,javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyCollectionsLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(432, 432, 432)))));
        	MyCollectionsLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(MyCollectionsLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(MyCollectionsLayout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(UserLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(MyCollectionsLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(MyCollectionsLayout.createSequentialGroup()
        					.addComponent(Upload, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(Download, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(Exit, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(108, Short.MAX_VALUE));

        MyCollections.setLayout(MyCollectionsLayout);


        MainMenu.addTab("My Collections", MyCollections);


        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setText("Browse!");

        //Tampilan explorer
        DBConnection conn = new DBConnection();
		ResultSet rs = conn.executeQuery("SELECT * FROM book");
		Vector row = new Vector();
		Rows = new Vector();
                while(rs.next())
		{
			Vector data = new Vector();
                        Vector data2 = new Vector();
			data.add(rs.getString("name"));
			data.add(rs.getString("description"));
			data.add(rs.getString("uploader_id"));
                        data2.add(rs.getString("name"));
			data2.add(rs.getString("description"));
			data2.add(rs.getString("uploader_id"));
			data2.add(rs.getString("id"));
                        data.add(false);
			row.add(data);
                        Rows.add(data2);
		}
		conn.closeConnection();
                

		Vector columnNames = new Vector();
		columnNames.add("Judul Buku");
		columnNames.add("Deskripsi");
		columnNames.add("Uploader ID");
		columnNames.add("Cek");


        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            row,
            columnNames
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };


            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        AddCollection.setText("Add to Collections");
        AddCollection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    AddCollectionActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout BrowseLayout = new javax.swing.GroupLayout(Browse);
        BrowseLayout.setHorizontalGroup(
        	BrowseLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(BrowseLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(BrowseLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(BrowseLayout.createSequentialGroup()
        					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(AddCollection, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        					.addGap(18))
        				.addGroup(BrowseLayout.createSequentialGroup()
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(457, Short.MAX_VALUE))))
        );
        BrowseLayout.setVerticalGroup(
        	BrowseLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(BrowseLayout.createSequentialGroup()
        			.addGap(5)
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(BrowseLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(AddCollection, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(27, Short.MAX_VALUE))
        );
        Browse.setLayout(BrowseLayout);


        MainMenu.addTab("Browse", Browse);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
        );


        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed


    private void UserLabelInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_UserLabelInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_UserLabelInputMethodTextChanged
    
    
    private void AddCollectionActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                              
        DBConnection con = new DBConnection();
        String userID = LoginController.currUser.getID();
        String Query = "INSERT INTO collection (book_id, user_id) VALUES(?, (SELECT id FROM user WHERE username='"+userID+"'))";
        for (int j = 0; j < jTable2.getModel().getRowCount();j++){
            if("true".equals(jTable2.getModel().getValueAt(j, 3).toString())){
               // con.executeQuery("INSERT INTO collection VALUES ()")
                Vector<Object> record = (Vector<Object>)Rows.elementAt(j);
                System.out.println(record.elementAt(3));
                String bookID = record.elementAt(3).toString();
                con.executeQuery(Query, bookID);
            }
            //System.out.println(jTable2.getModel().getValueAt(j, 3));
        }
        
        System.out.println(jTable2.getModel().getRowCount());
    }  

    /**
     * @param args the command line arguments
     */
    public static void mainp() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
            
        
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new MainMenu().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCollection;
    private javax.swing.JPanel Browse;
    private javax.swing.JButton Exit;
    private javax.swing.JTabbedPane MainMenu;
    private javax.swing.JPanel MyCollections;
    private javax.swing.JButton Upload;
    private javax.swing.JButton Download;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private Vector Rows;
    // End of variables declaration//GEN-END:variables
}
