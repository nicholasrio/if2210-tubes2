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
import java.awt.print.PrinterJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import job.*;

public class ServerThread extends Thread {

	public static final int BUF_SIZE = 2048;
	public Job myJob;
	private Socket socket;
	private int id;
	private Credential credential;
	private ObjectInputStream ois;
	private PrintWriter pw;
	private File file;
	

	public ServerThread(Socket clientSocket, int id) {
		socket = clientSocket;
		this.id = id;
	}

	public void run() {	
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			pw = new PrintWriter(socket.getOutputStream(), true);
			Object obj = ois.readObject();
			if (obj instanceof TransObject) {
				TransObject transObj = (TransObject) obj;
				if (ServerManager.getSingleton().isLoggedIn(transObj.getSenderNIM())) {
					writeFile(transObj);
					tryprint(transObj);
				}
			} else if (obj instanceof Credential) {
				System.out.println("Credential information received");
				credential = (Credential) obj;
				if (checkCredential(credential)) {
					if (credential.getType() == Credential.LOGIN) {
						processLogin();
					} else if (credential.getType() == Credential.LOGOUT) {
						processLogout();
					} else if (credential.getType() == Credential.PRINT) {
						//call to method print("serverFolder/" + credential.getId() + "/" + credential.getFile())
						//myJob.print();
					}
				} else {
					pw.write("Wrong username or password\n");
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
	
	private void writeFile(TransObject transObj){
		file = new File("serverFolder/" + transObj.getSenderNIM());
		file.mkdirs();
		file = new File(transObj.getFileName());
		try{
			InputStream in = socket.getInputStream(); //used  
			DataInputStream clientData = new DataInputStream(in); //used

			OutputStream output = new FileOutputStream("serverFolder/" + transObj.getSenderNIM() + "/" + file.getName());

			byte[] buffer = new byte[BUF_SIZE];

			int smblen;
			do {
				smblen = in.read(buffer);
				output.write(buffer, 0, smblen);
			} while (clientData.available() != 0);
			output.close();
			System.out.println("User " + transObj.getSenderNIM() + " uploaded a file: " + file.getName());
			pw.write("File successfully uploaded\n");
			pw.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void tryprint(TransObject transObj){
		MyFile myFile;
		FileFactory myFactory = new FileFactory();
		if (file.getName().contains(".txt")) {
			myFile = myFactory.getFile("TXT");
			myFile.setEkstensi("TXT");
		} else if (file.getName().contains(".pdf")) {
			myFile = myFactory.getFile("PDF");
			myFile.setEkstensi("PDF");
		} else {
			myFile = myFactory.getFile("DOC");
			myFile.setEkstensi("DOC");
		}
		myFile.nama = file.getName();
		myFile.uploader = transObj.getSenderNIM();
		myFile.path = file.getName();
		myFile.toPDF();

		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
		System.out.println("Number of print services: " + printServices.length);
		int i = 1;
		PrinterJob printJob = PrinterJob.getPrinterJob();
		for (PrintService printer : printServices) {
			pw.write(i + ". Printer: " + printer.getName() + "\n");
			i++;
		}
		pw.write("Choose printer : \n");
		pw.flush();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String number = br.readLine();
			//int id = Integer.parseInt(number);
			//id--;
			//System.out.println("selected printer: " + id);
			myFile.print(printServices[4]);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void processLogin(){
		ServerManager.getSingleton().addLoggedUser(credential.getId());
		pw.write("Login sukses\n");
		pw.flush();
		UserDao data = new UserDaoImpl();
		User user = data.getByUsername(credential.getId());
		try{
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(user);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void processLogout(){
		ServerManager.getSingleton().removeLoggedUser(credential.getId());
		pw.write("Logout sukses\n");
		pw.flush();
	}

}
