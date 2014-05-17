package org;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FileViewGUI extends JFrame implements IFileView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7292590782177680886L;

	// ini listener ke Controller
	private IFileController listener;
	
	// semua elemen dari Swing
	private JPanel contentPane;
	private JTextPane txtpnFileinfo;
	private JButton btnDownload;
	private JButton btnRename;
	private JLabel lblFileicon;
	private JButton btnDelete;
	private JButton btnExit;
	private JButton btnUpload;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileViewGUI frame = new FileViewGUI(null);
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
	public FileViewGUI(FileExt model) {
		listener = new FileController(model, this);
		initialize();
	}
	
	/**
	 * Initialize the components
	 */
	private void initialize() {
		setTitle("File View");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		txtpnFileinfo = new JTextPane();
		txtpnFileinfo.setEditable(false);
		contentPane.add(txtpnFileinfo, "2, 2, 1, 3, fill, fill");
		
		btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				
				int retval = fc.showSaveDialog(contentPane);
				
				if(retval == JFileChooser.APPROVE_OPTION) {
					try {
						// TODO: ini butuh modul dari UserView, soalnya butuh di-register siapa uploadernya
						listener.download(fc.getSelectedFile(), listener.getFileUploader());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		contentPane.add(btnDownload, "6, 2");
		
		btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				
				int retval = fc.showOpenDialog(contentPane);
				
				if(retval == JFileChooser.APPROVE_OPTION) {
					try {
						// TODO: tombol ini hanya mensimulasikan bahwa upload berhasil.
						// ini masih berupa stub.
						File temp = fc.getSelectedFile();
						
						FileExt file = new FileExt(temp.getAbsolutePath(), temp.getName(),
										new User("Edmund Ophie", "edmundophie", "12345"), new Date(), "Upload stub");
						file.setCategory(FileCategory.TextBook);
						
						listener.registerModel(file);
						listener.upload();
						
						updateModel();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		contentPane.add(btnUpload, "6, 4");
		
		btnRename = new JButton("Rename");
		btnRename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!listener.isModelEmpty()) {
					String newFileName = JOptionPane.showInputDialog("Enter new name for file " + listener.getFileNamedName());
					
					try {
						if(newFileName != null) {
							listener.rename(newFileName);
							listener.sync();
						} else {
							JOptionPane.showMessageDialog(contentPane, "File name cannot be empty");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Current file is empty");
				}
			}
		});
		contentPane.add(btnRename, "6, 6");
		
		lblFileicon = new JLabel("fileIcon");
		contentPane.add(lblFileicon, "2, 6, 1, 5");
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assert(!listener.isModelEmpty());
				
				try {
					listener.delete();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnDelete, "6, 8");
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.registerView(null);
				FileViewGUI.this.dispose();
			}
		});
		contentPane.add(btnExit, "6, 10");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				lblFileicon.setText(null); // TODO: tampilin icon yang sesuai
				updateModel();
			}
		});
	}

	@Override
	public void updateModel() {
		if(!listener.isModelEmpty()) {
			StringBuilder sb = new StringBuilder();
			
			sb.append("File name: ").append(listener.getFileNamedName()).append("\n");
			sb.append("Size: ").append(listener.getFileSize()).append("\n");
			sb.append("Category: ").append(listener.getFileCategory()).append("\n");
			sb.append("Uploader: ").append(listener.getFileUploader().name()).append("\n");
			sb.append("Download count: ").append(listener.getFileDownloadCount()).append("\n");
			sb.append("Description: ").append(listener.getFileDescription()).append("\n");
			
			txtpnFileinfo.setText(sb.toString());
		} else {
			txtpnFileinfo.setText(null);
		}
		
	}

}
