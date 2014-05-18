package Client;

import entity.Credential;
import entity.TransObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	String hostName = "localhost";
	int portNumber = 5432;
	Socket socket;
	String input;
	String NIM;
	String password;
	BufferedReader reader;
	BufferedReader sockReader;
	private boolean LoggedIn;

	public static void main(String[] args) {
		Client client = new Client();
	}

	public Client() {
		LoggedIn = false;
		try {
			do {
				reader = new BufferedReader(new InputStreamReader(System.in));
				if(!LoggedIn)
					System.out.println("1. login");
				else
					System.out.println("1. logout");
				System.out.println("2. print");
				System.out.println("3. exit");
				input = reader.readLine();
				if (input.equals("login") && !LoggedIn)
					login();
				else if (input.equals("print"))
					sendPrintInfo();
				else if(input.equals("logout") && LoggedIn)
					logout();
			} while (!input.equals("exit"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void login() {
		try {
			
			String tempSR;
			System.out.println("Enter NIM: ");
			NIM = reader.readLine();
			System.out.println("Enter password: ");
			password = reader.readLine();
			socket = new Socket(hostName, portNumber);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			sockReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Credential obj = new Credential(NIM, password, Credential.LOGIN);
			oos.writeObject(obj);
			
			// login with DB to be implemented
			tempSR = sockReader.readLine();
			System.out.println("Dari server " + tempSR);
			if (tempSR.contains("Login sukses")) {
				LoggedIn = true;
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void logout(){
		ObjectOutputStream oos;
		try{
			socket = new Socket(hostName, portNumber);
			oos = new ObjectOutputStream(socket.getOutputStream());
			sockReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Credential obj = new Credential(NIM, password, Credential.LOGOUT);
			oos.writeObject(obj);
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void sendPrintInfo() {
		//System.out.println(LoggedIn);
		if (LoggedIn) {
			try {
				socket = new Socket(hostName, portNumber);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				TransObject obj = new TransObject(NIM,"receive.pdf");
				oos.writeObject(obj);
				sendFile();
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			System.out.println("Silahkan login terlebih dahulu.");
			login();
		}
	}

	private void sendFile() {
		//buat kalo mau pake file
		String Path;
		System.out.println("Masukkan path file yang akan diupload:");
		try {
                //Path    =  reader.readLine().replace("\\","\\\\");
			//System.out.println(Path);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			if (true) {
				File f = new File("clientFolder/TSocket.pdf");
				BufferedInputStream inFile = new BufferedInputStream(new FileInputStream(f));
				byte[] buf = new byte[(int) f.length()];
				inFile.read(buf);
				socket.getOutputStream().write(buf);
			}
			//send message to server
			System.out.println("Someone send a message: " + input);

			//read message from server
			System.out.println(in.readLine());
		} catch (Exception e) {
			System.out.println("Terjadi kesalahan dalam pengiriman");
		}
	}
}
