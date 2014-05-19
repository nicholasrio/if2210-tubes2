package org;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ConfigurationView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7789762587700624389L;
	private JPanel contentPane;
	private JSpinner spinnerDownloadheaderlimit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurationView frame = new ConfigurationView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConfigurationView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				if(!Configuration.isLoaded()) {
					try {
						Configuration.load(null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				spinnerDownloadheaderlimit.setValue((int)Configuration.getHeaderDownloadLimit());
			}
		});
		setTitle("Configuration");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow][][]", "[][][][][][][][]"));
		
		JLabel lblHeaderdownloadlimit = new JLabel("Header Download Limit");
		contentPane.add(lblHeaderdownloadlimit, "cell 0 3 3 1,alignx trailing");
		
		spinnerDownloadheaderlimit = new JSpinner();
		contentPane.add(spinnerDownloadheaderlimit, "cell 3 3,growx");
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuration.setHeaderDownloadLimit((int)spinnerDownloadheaderlimit.getValue());
				try {
					Configuration.save(Configuration.getCurrentLocation());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				
				int retval = fc.showOpenDialog(contentPane);
				
				if(retval == JFileChooser.APPROVE_OPTION) {
					String prevSaveFile = Configuration.getCurrentLocation();
					
					try {
						Configuration.load(fc.getSelectedFile().getAbsolutePath());
					} catch (Exception e1) {
						System.err.println("Cannot load file! Reverting...");
						try {
							Configuration.load(prevSaveFile);
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
			}
		});
		contentPane.add(btnLoad, "cell 0 6");
		contentPane.add(btnSave, "cell 0 7");
		
		JButton btnDefault = new JButton("Default");
		btnDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				spinnerDownloadheaderlimit.setValue((int)Configuration.defaultHeaderDownloadLimit);
			}
		});
		contentPane.add(btnDefault, "cell 3 7,alignx center,aligny center");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationView.this.dispose();
			}
		});
		contentPane.add(btnCancel, "cell 5 7,alignx right");
	}

}
