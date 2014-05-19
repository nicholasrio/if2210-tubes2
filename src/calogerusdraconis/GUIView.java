/*
 * Copyright (C) 2014 Calogerus Draconis Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package calogerusdraconis;

import java.awt.Dimension; 
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Dariel Valdano
 */
public class GUIView extends javax.swing.JFrame implements View {
	
	private boolean selectionUpdate = false;
	private int selection = 0;
	private final Object SelectionNotifier = new Object();
	private UserDragon draco;
	private Store str;
	
	/**
	 * Constructor GuiView, melakukan inisialisasi komponen GUI
	 */
	public GUIView() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DragonImg = new javax.swing.JLabel();
        DragonName = new javax.swing.JLabel();
        DragonLevel = new javax.swing.JLabel();
        DragonExp = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ProgHealth = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        ProgStamina = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        ProgHunger = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        ProgThirst = new javax.swing.JProgressBar();
        ProgBladder = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ProgHappy = new javax.swing.JProgressBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        InventoryPane = new JScrollPane(InventoryPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        InventoryPanel = new InventoryDisplay(null);
        InventoryPanel.setPreferredSize(new Dimension(100,600));
        StorePane = new JScrollPane(StorePanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        StorePanel = new StoreDisplay(Store.getInstance());
        InventoryPanel.setPreferredSize(new Dimension(100,600));
        jPanel6 = new javax.swing.JPanel();
        ButtEntertain = new javax.swing.JButton();
        ButtTrain = new javax.swing.JButton();
        ButtSleep = new javax.swing.JButton();
        ButtToilet = new javax.swing.JButton();
        ButtFight = new javax.swing.JButton();
        ButtSaveQuit = new javax.swing.JButton();
        ButtSave = new javax.swing.JButton();
        TextMoney = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calogerus Draconis");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(809, 490));
        setMinimumSize(new java.awt.Dimension(809, 490));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Your Dragon"));

        DragonImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calogerusdraconis/res/neutral r.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DragonImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DragonImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        DragonName.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        DragonName.setText("Xanareth Viserus");

        DragonLevel.setText("Level 20");

        DragonExp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DragonExp.setText("Exp 10000/15000");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Stats"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Health");

        ProgHealth.setString("0/150");
        ProgHealth.setStringPainted(true);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Stamina");

        ProgStamina.setRequestFocusEnabled(false);
        ProgStamina.setString("0/130");
        ProgStamina.setStringPainted(true);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Hunger");

        ProgHunger.setString("0");
        ProgHunger.setStringPainted(true);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Thirst");

        ProgThirst.setString("0");
        ProgThirst.setStringPainted(true);

        ProgBladder.setString("0");
        ProgBladder.setStringPainted(true);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Bladder");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Happiness");

        ProgHappy.setString("0");
        ProgHappy.setStringPainted(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProgBladder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProgHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProgStamina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProgHunger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProgThirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProgHappy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProgHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProgStamina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProgHappy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProgHunger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProgThirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProgBladder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InventoryPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        InventoryPane.setMinimumSize(new java.awt.Dimension(0, 0));

        InventoryPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        InventoryPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InventoryPanelMouseClicked(evt);
            }
        });
        InventoryPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                InventoryPanelMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout InventoryPanelLayout = new javax.swing.GroupLayout(InventoryPanel);
        InventoryPanel.setLayout(InventoryPanelLayout);
        InventoryPanelLayout.setHorizontalGroup(
            InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );
        InventoryPanelLayout.setVerticalGroup(
            InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        InventoryPane.setViewportView(InventoryPanel);

        jTabbedPane1.addTab("Inventory", InventoryPane);

        StorePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StorePanelMouseClicked(evt);
            }
        });
        StorePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                StorePanelMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout StorePanelLayout = new javax.swing.GroupLayout(StorePanel);
        StorePanel.setLayout(StorePanelLayout);
        StorePanelLayout.setHorizontalGroup(
            StorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );
        StorePanelLayout.setVerticalGroup(
            StorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        StorePane.setViewportView(StorePanel);

        jTabbedPane1.addTab("Store", StorePane);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        ButtEntertain.setText("Entertain");
        ButtEntertain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtEntertainMouseClicked(evt);
            }
        });

        ButtTrain.setText("Training");
        ButtTrain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtTrainMouseClicked(evt);
            }
        });

        ButtSleep.setText("Sleep");
        ButtSleep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtSleepMouseClicked(evt);
            }
        });

        ButtToilet.setText("Go to Toilet");
        ButtToilet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtToiletMouseClicked(evt);
            }
        });

        ButtFight.setText("Fight a Dragon");
        ButtFight.setActionCommand("<html> <center> Fight <br /> another <br /> Dragon </center> </html>");
        ButtFight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtFight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtFightMouseClicked(evt);
            }
        });

        ButtSaveQuit.setText("Save and Quit");
        ButtSaveQuit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtSaveQuitMouseClicked(evt);
            }
        });

        ButtSave.setText("Save");
        ButtSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtSaveQuit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtEntertain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtTrain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtSleep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtToilet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtFight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtEntertain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtTrain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtSleep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtToilet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtFight, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtSaveQuit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TextMoney.setText("Money 2400");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DragonLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DragonExp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DragonName, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DragonName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextMoney)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DragonLevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DragonExp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	
	/**
	 * Saat meng-klik button entertain
	 * @param evt MouseEvent
	 */
    private void ButtEntertainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtEntertainMouseClicked
        synchronized(SelectionNotifier) {
			selection = 1;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtEntertainMouseClicked
	
	/**
	 * Saat meng-klik button train
	 * @param evt MouseEvent
	 */
    private void ButtTrainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtTrainMouseClicked
        synchronized(SelectionNotifier) {
			selection = 2;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtTrainMouseClicked
	
	/**
	 * Saat meng-klik button sleep
	 * @param evt MouseEvent
	 */
    private void ButtSleepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtSleepMouseClicked
        synchronized(SelectionNotifier) {
			selection = 3;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtSleepMouseClicked
	
	/**
	 * Saat meng-klik button Go to Toilet
	 * @param evt MouseEvent
	 */
    private void ButtToiletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtToiletMouseClicked
        synchronized(SelectionNotifier) {
			selection = 4;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtToiletMouseClicked
	
	/**
	 * Saat meng-klik button Fight
	 * @param evt MouseEvent
	 */
    private void ButtFightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtFightMouseClicked
        synchronized(SelectionNotifier) {
			selection = 5;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtFightMouseClicked
	
	/**
	 * Saat meng-klik button Save and Quit
	 * @param evt MouseEvent
	 */
    private void ButtSaveQuitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtSaveQuitMouseClicked
        synchronized(SelectionNotifier) {
			selection = -1;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
		}
    }//GEN-LAST:event_ButtSaveQuitMouseClicked
	
	/**
	 * Saat meng-klik button Save
	 * @param evt MouseEvent
	 */
    private void ButtSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtSaveMouseClicked
        synchronized(SelectionNotifier) {
			selection = 6;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
		}
    }//GEN-LAST:event_ButtSaveMouseClicked
	
	/**
	 * Saat kursor hover ke inventory panel
	 * @param evt MouseEvent
	 */
    private void InventoryPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventoryPanelMouseMoved
		if (evt.getX() > 64 || evt.getY() < 10) InventoryDisplay.pilihan = null; //tipe data Integer
		else if (evt.getY() > draco.getFdInventory().size()*64+10) InventoryDisplay.pilihan = null;
		else InventoryDisplay.pilihan = (evt.getY()-10)/64;
    }//GEN-LAST:event_InventoryPanelMouseMoved
	
	/**
	 * Saat kursor hover ke store panel
	 * @param evt MouseEvent
	 */
    private void StorePanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StorePanelMouseMoved
		if (evt.getX() > 64 || evt.getY() < 10) StoreDisplay.pilihan = null; //tipe data Integer
		else StoreDisplay.pilihan = (evt.getY()-10)/64;
    }//GEN-LAST:event_StorePanelMouseMoved
	
	/**
	 * Saat meng-klik item dalam inventory panel
	 * @param evt MouseEvent
	 */
    private void InventoryPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventoryPanelMouseClicked
		if (evt.getClickCount()==2 && !evt.isConsumed()) {
			int pilihan = (evt.getY()-10)/64;
			if (evt.getX() > 64 || evt.getY() < 10) {
				pilihan = -1;
			} else
			if (pilihan < draco.getFdInventory().size()) {
				try {
					System.out.println((evt.getY()-10)/64 + " di invent");
					draco.useConsumable(draco.getFdInventory().get(pilihan));
					//System.out.println(draco.getFdInventory().size());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		}
		UpdateScreen(draco);
    }//GEN-LAST:event_InventoryPanelMouseClicked
	
	/**
	 * Saat meng-klik item dalam store panel
	 * @param evt MouseEvent
	 */
    private void StorePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StorePanelMouseClicked
		if (evt.getClickCount() == 2 && !evt.isConsumed()) {
			int pilihan = (evt.getY()-10)/64;
			if (evt.getX() > 64 || evt.getY() < 10) {
				pilihan = -1;
			} else
			if (pilihan < str.getFdInventory().size()) {
				try {
					System.out.println((evt.getY()-10)/64);
					draco.addConsumable(str.getFdInventory().get(pilihan));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		}
    }//GEN-LAST:event_StorePanelMouseClicked
	
	/**
	 * Menampilkan daftar menu
	 */
	@Override
	public void showMenu() {
		//NOP. already shown.
	}
	
	/**
	 * Meng-update tampilan status dragon
	 * @param drg dragon yang ditampilkan statusnya
	 */
	@Override
    public void UpdateScreen (UserDragon drg) {
		
		draco = drg;
		
		int health = (int) drg.getHealth();
		int maxhealth = (int) drg.getMaxHealth();
		int bladder = (int) drg.getBladder();
		int stamina = (int) drg.getStamina();
		int maxstamina = (int) drg.getMaxStamina();
		int happiness = (int) drg.getHappiness();
		int hunger = (int) drg.getHunger();
		int thirst = (int) drg.getThirst();
		int money = (int) drg.getMoney();
		int level = (int) drg.getLevel();
		
		ProgHealth.setValue(health);
		ProgHealth.setMaximum(maxhealth);
		ProgHealth.setString(""+health+"/"+maxhealth);
		
		ProgStamina.setValue(stamina);
		ProgStamina.setMaximum(maxstamina);
		ProgStamina.setString(""+stamina+"/"+maxstamina);
		
		ProgHappy.setValue(happiness);
		ProgHappy.setString(""+happiness+"/100");
		
		ProgHunger.setValue(hunger);
		ProgHunger.setString(""+hunger+"/100");
		
		ProgThirst.setValue(thirst);
		ProgThirst.setString(""+thirst+"/100");
		
		ProgBladder.setValue(bladder);
		ProgBladder.setString(""+bladder+"/100");
		
		DragonName.setText(drg.getName());
		try {
			DragonImg.setIcon(drg.getImage());
		} catch (Exception ex) {
			
		}
		TextMoney.setText("Money: " + money);
		DragonLevel.setText("Level: " + level);
		
		int next = 100 * (level+1) * (level+1) * (level+1);
		DragonExp.setText("Exp: " + drg.getExperience() +"/"+next);

		InventoryDisplay.change(drg,(InventoryDisplay) InventoryPanel);
		InventoryPanel.repaint();
    }

	/**
	 * Meng-update tampilan store
	 * @param str Store yang ditampilkan
	 */
	@Override
    public void UpdateScreen (Store str) {
		this.str = str;
		StorePanel.repaint();
    }

	/**
	 * Meng-update tampilan fight
	 * @param drg dragon user
	 * @param enemy dragon enemy
	 */
	@Override
    public void UpdateScreen (UserDragon drg, Dragon enemy) {
		//NOP. already shown.
    }

	/**
	 * Menampilkan hasil aktivitas dragon
	 * @param drg	dragon user
	 * @param evnt  event yang telah dilakukan user
	 */
	@Override
    public void UpdateScreen (UserDragon drg, Event evnt) {
		enableButts();
		JOptionPane.showMessageDialog(null, evnt.getMessage());
    }
	
	/**
	 * Menonaktifkan button di saat tidak bisa digunakan
	 */
	private void disableButts() {
		ButtEntertain.setEnabled(false);
		ButtFight.setEnabled(false);
		ButtSave.setEnabled(false);
		ButtSaveQuit.setEnabled(false);
		ButtSleep.setEnabled(false);
		ButtToilet.setEnabled(false);
		ButtTrain.setEnabled(false);
	}
	
	/**
	 * Mengaktifkan button di saat bisa digunakan
	 */
	public void enableButts() {
		ButtEntertain.setEnabled(true);
		ButtFight.setEnabled(true);
		ButtSave.setEnabled(true);
		ButtSaveQuit.setEnabled(true);
		ButtSleep.setEnabled(true);
		ButtToilet.setEnabled(true);
		ButtTrain.setEnabled(true);
	}
	
	/**
	 * Menunggu user untuk memilih suatu aktivitas untuk dragon
	 * @return integer yang merepresentasikan pilihan aktivitas
	 */
	public int waitForSelection(){
		try {
			synchronized(SelectionNotifier) {
				while (!selectionUpdate) {
					SelectionNotifier.wait();
				}
			}
		} catch (InterruptedException ex) {
			System.out.println("interrupted");
		}
		selectionUpdate = false;
		return selection;
	}
	
	/**
	 * Melihat isi food directory
	 * @param drg dragon yang dilihat isi food directory nya
	 */
	@Override
	public void seeFoodDirectory(UserDragon drg) {
		}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtEntertain;
    private javax.swing.JButton ButtFight;
    private javax.swing.JButton ButtSave;
    private javax.swing.JButton ButtSaveQuit;
    private javax.swing.JButton ButtSleep;
    private javax.swing.JButton ButtToilet;
    private javax.swing.JButton ButtTrain;
    private javax.swing.JLabel DragonExp;
    private javax.swing.JLabel DragonImg;
    private javax.swing.JLabel DragonLevel;
    private javax.swing.JLabel DragonName;
    private javax.swing.JScrollPane InventoryPane;
    private javax.swing.JPanel InventoryPanel;
    private javax.swing.JProgressBar ProgBladder;
    private javax.swing.JProgressBar ProgHappy;
    private javax.swing.JProgressBar ProgHealth;
    private javax.swing.JProgressBar ProgHunger;
    private javax.swing.JProgressBar ProgStamina;
    private javax.swing.JProgressBar ProgThirst;
    private javax.swing.JScrollPane StorePane;
    private javax.swing.JPanel StorePanel;
    private javax.swing.JLabel TextMoney;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
