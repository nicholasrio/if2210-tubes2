package Server;

import entity.Credential;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import entity.TransObject;
import java.io.*;
import java.net.URI;
import com.data.*;
import file.*;
import job.*;

public class ServerThread extends Thread {

	private Socket socket;
	private int id;
	private Credential credential;
	public static final int BUF_SIZE = 2048;
        public Job myJob;
	public ServerThread(Socket clientSocket, int id) {
		socket = clientSocket;
		this.id = id;
	}

	public void run() {

		ObjectInputStream ois = null;
		PrintWriter pw = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			pw = new PrintWriter(socket.getOutputStream(), true);
			Object obj = ois.readObject();
			if (obj instanceof TransObject) {
				TransObject transObj = (TransObject) obj;
				if (ServerManager.getSingleton().isLoggedIn(transObj.getSenderNIM())) {
					File file = new File("serverFolder/" + transObj.getSenderNIM());
					file.mkdirs();
					file = new File(transObj.getFileName());
					
					InputStream in = socket.getInputStream(); //used  
					DataInputStream clientData = new DataInputStream(in); //used
					
					OutputStream output = new FileOutputStream("serverFolder/" + transObj.getSenderNIM() + "/" + file.getName());

                                //clientData.readLong();  
					byte[] buffer = new byte[BUF_SIZE];

					int smblen;
					do {
						smblen = in.read(buffer);
						output.write(buffer, 0, smblen);
					} while (clientData.available() != 0);
					output.close();
					System.out.println("User " + transObj.getSenderNIM() + " uploaded a file: " + file.getName());
					pw.write("File successfully uploaded");
					pw.flush();
                                        
                                        /* belum dalam method */
                                        FileFactory myFactory   =    new FileFactory();
                                        MyFile  myFile;
                                        if(file.getName().contains(".txt")){
                                                myFile  =   myFactory.getFile("TXT");
                                                myFile.setEkstensi("TXT");
                                        }else if(file.getName().contains(".pdf")){
                                                myFile  =   myFactory.getFile("PDF");
                                                myFile.setEkstensi("PDF");
                                        }else{
                                                myFile  =   myFactory.getFile("DOC");
                                                myFile.setEkstensi("DOC");
                                        }
                                        myFile.nama =   file.getName();
                                        myFile.uploader =    transObj.getSenderNIM();
                                        myFile.path =   file.getName();
                                        
                                        myFile.print();
                                        
                                        /* Menambahkan ke dalam Job
                                        myJob =    new Job(myFile.uploader);
                                        myJob.addFile(myFile);
                                        myJob.print();
                                                 */
				}
			} else if (obj instanceof Credential) {
				System.out.println("Credential information received");
				credential = (Credential) obj;
				if (checkCredential(credential)) {
					if(credential.getType() == Credential.LOGIN){
						ServerManager.getSingleton().addLoggedUser(credential.getId());
						pw.write("Login sukses");
						pw.flush();
					}
					else if(credential.getType() == Credential.LOGOUT){
						// todo when logout
						ServerManager.getSingleton().removeLoggedUser(credential.getId());
						pw.write("Logout sukses");
						pw.flush();
					}
					else if(credential.getType() == Credential.PRINT){
						//call to method print("serverFolder/" + credential.getId() + "/" + credential.getFile())
                                            //myJob.print();
					}
				} else {
					pw.write("Wrong username or password");
					pw.flush();
				}
				System.out.println("Message sent");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
					pw.close();
					ServerManager.getSingleton().release(id);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private boolean checkCredential(Credential c) {
		// to be implemented with DB
            UserDao Data = new UserDaoImpl();
            User user = Data.Validate(c.getId(), c.getPassword());
            return (user != null);
	}
        
        
}
