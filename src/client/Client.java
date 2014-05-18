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
				System.out.println("2. upload");
				System.out.println("3. print");
				System.out.println("4. exit");
				input = reader.readLine();
				if (input.equals("login") && !LoggedIn)
					login();
				else if (input.equals("upload"))
					sendPrintInfo();
				else if(input.equals("print"))
					print();
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
			ObjectOutputStream oos;
			
			System.out.println("Enter NIM: ");
			NIM = reader.readLine();
			System.out.println("Enter password: ");
			password = reader.readLine();
			
			socket = new Socket(hostName, portNumber);
			oos = new ObjectOutputStream(socket.getOutputStream());
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
		BufferedReader in;
		try{
			socket = new Socket(hostName, portNumber);
			oos = new ObjectOutputStream(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			sockReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			Credential obj = new Credential(NIM, password, Credential.LOGOUT);
			oos.writeObject(obj);
			System.out.println("Message from server: " + in.readLine());
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void print(){
		if (LoggedIn) {
			try {
				socket = new Socket(hostName, portNumber);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
				// get and print out file name list
				System.out.println("Input filename: ");
				Credential c = new Credential(NIM, password, Credential.PRINT);
				c.setFile(reader.readLine());
				oos.writeObject(c);
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
	
	private void sendPrintInfo() {
		//System.out.println(LoggedIn);
		if (LoggedIn) {
			try {
				socket = new Socket(hostName, portNumber);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				System.out.println("Masukkan path file yang akan diupload: ");
				TransObject obj = new TransObject(NIM,reader.readLine());
				oos.writeObject(obj);
				sendFile(obj);
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

	private void sendFile(TransObject obj) {
		//buat kalo mau pake file
		try {
                //Path    =  reader.readLine().replace("\\","\\\\");
			//System.out.println(Path);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			if (true) {
				File f = new File(obj.getFileName());
				BufferedInputStream inFile = new BufferedInputStream(new FileInputStream(f));
				byte[] buf = new byte[(int) f.length()];
				inFile.read(buf);
				socket.getOutputStream().write(buf);
			}
			//send message to server
			out.println("Someone send a message: " + input);

			//read message from server
			System.out.println("Message from server: " + in.readLine());
		} catch (Exception e) {
			System.out.println("Terjadi kesalahan dalam pengiriman");
		}
	}
}
