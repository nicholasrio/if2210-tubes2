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
        ButtFight = new javax.swing.JButton();
        ButtSleep = new javax.swing.JButton();
        ButtToilet = new javax.swing.JButton();
        ButtSave = new javax.swing.JButton();
        ButtSaveQuit = new javax.swing.JButton();
        TextMoney = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calogerus Draconis");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
            .addGap(0, 497, Short.MAX_VALUE)
        );
        InventoryPanelLayout.setVerticalGroup(
            InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );

        InventoryPane.setViewportView(InventoryPanel);

        jTabbedPane1.addTab("Inventory", InventoryPane);

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
            .addGap(0, 381, Short.MAX_VALUE)
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

        ButtFight.setText("Fight another Dragon");
        ButtFight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtFightMouseClicked(evt);
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

        ButtSave.setText("Save");
        ButtSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtSaveMouseClicked(evt);
            }
        });

        ButtSaveQuit.setText("Save and Quit");
        ButtSaveQuit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtSaveQuitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ButtTrain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtEntertain, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtSleep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtToilet, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(ButtFight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtSaveQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(ButtSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtSaveQuit))
                    .addComponent(ButtFight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtEntertain)
                            .addComponent(ButtSleep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtTrain)
                            .addComponent(ButtToilet))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TextMoney.setText("Money 2400");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(DragonName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DragonLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DragonExp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DragonLevel)
                                    .addComponent(TextMoney))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DragonExp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(DragonName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtEntertainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtEntertainMouseClicked
        synchronized(SelectionNotifier) {
			selection = 1;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtEntertainMouseClicked

    private void ButtTrainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtTrainMouseClicked
        synchronized(SelectionNotifier) {
			selection = 2;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtTrainMouseClicked

    private void ButtSleepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtSleepMouseClicked
        synchronized(SelectionNotifier) {
			selection = 3;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtSleepMouseClicked

    private void ButtToiletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtToiletMouseClicked
        synchronized(SelectionNotifier) {
			selection = 4;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtToiletMouseClicked

    private void ButtFightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtFightMouseClicked
        synchronized(SelectionNotifier) {
			selection = 5;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtFightMouseClicked

    private void ButtSaveQuitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtSaveQuitMouseClicked
        synchronized(SelectionNotifier) {
			selection = -1;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtSaveQuitMouseClicked

    private void ButtSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtSaveMouseClicked
        synchronized(SelectionNotifier) {
			selection = 6;
			selectionUpdate = true;
			SelectionNotifier.notifyAll();
			disableButts();
		}
    }//GEN-LAST:event_ButtSaveMouseClicked

    private void InventoryPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventoryPanelMouseMoved
		if (evt.getX() > 64 || evt.getY() < 10) InventoryDisplay.pilihan = null; //tipe data Integer
		else InventoryDisplay.pilihan = (evt.getY()-10)/64;
    }//GEN-LAST:event_InventoryPanelMouseMoved

    private void StorePanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StorePanelMouseMoved
		if (evt.getX() > 64 || evt.getY() < 10) StoreDisplay.pilihan = null; //tipe data Integer
		else StoreDisplay.pilihan = (evt.getY()-10)/64;
    }//GEN-LAST:event_StorePanelMouseMoved

    private void InventoryPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventoryPanelMouseClicked
        // TODO add your handling code here:
		if (evt.getClickCount() == 2 && !evt.isConsumed()) {
			System.out.println(evt.getX() + " " + evt.getY());
		}
		/*algoritma penentuan barang apa, lihat di atas. dia atas itu indexnya mulai dari 0*/
    }//GEN-LAST:event_InventoryPanelMouseClicked

	@Override
	public void showMenu() {
		//NOP. already shown.
	}
	
	@Override
    public void UpdateScreen (UserDragon drg) {
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
		DragonImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calogerusdraconis/res/neutral.png")));
		
		TextMoney.setText("Money: " + money);
		DragonLevel.setText("Level: " + level);
		
		int next = 100 * (level+1) * (level+1) * (level+1);
		DragonExp.setText("Exp: " + drg.getExperience() +"/"+next);
		//TODO : progXP
		//100*(lvl+1)^3
		InventoryDisplay.change(drg,(InventoryDisplay) InventoryPanel);
		InventoryPanel.repaint();
    }

	
	@Override
    public void UpdateScreen (Store str) {
		StorePanel.repaint();
    }

	
	@Override
    public void UpdateScreen (UserDragon drg, Dragon enemy) {
		//NOP. already shown.
    }

	
	@Override
    public void UpdateScreen (UserDragon drg, Event evnt) {
		enableButts();
		JOptionPane.showMessageDialog(null, evnt.getMessage());
    }
	
	private void disableButts() {
		ButtEntertain.setEnabled(false);
		ButtFight.setEnabled(false);
		ButtSave.setEnabled(false);
		ButtSaveQuit.setEnabled(false);
		ButtSleep.setEnabled(false);
		ButtToilet.setEnabled(false);
		ButtTrain.setEnabled(false);
	}
	
	private void enableButts() {
		ButtEntertain.setEnabled(true);
		ButtFight.setEnabled(true);
		ButtSave.setEnabled(true);
		ButtSaveQuit.setEnabled(true);
		ButtSleep.setEnabled(true);
		ButtToilet.setEnabled(true);
		ButtTrain.setEnabled(true);
	}
	
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
	
	@Override
	public void seeFoodDirectory(UserDragon drg) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
