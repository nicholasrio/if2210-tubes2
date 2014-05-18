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

	protected String hostName;
	protected int portNumber;
	protected Socket socket;
	protected String input;
	protected String NIM;
	protected String password;
	protected BufferedReader reader;
	protected BufferedReader sockReader;
	protected boolean LoggedIn;

	public Client(String host, int port) {
		LoggedIn = false;
		hostName = host;
		portNumber = port;
	}
		
	public void login(String NIM, String password) {
		try {
			String tempSR;
			ObjectOutputStream oos;
			
			socket = new Socket(hostName, portNumber);
			oos = new ObjectOutputStream(socket.getOutputStream());
			sockReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Credential obj = new Credential(NIM, password, Credential.LOGIN);
			oos.writeObject(obj);
			
			// login with DB to be implemented
			tempSR = sockReader.readLine();
			System.out.println("Message from server: " + tempSR);
			if (tempSR.contains("Login sukses")) {
				LoggedIn = true;
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logout(){
		ObjectOutputStream oos;
		BufferedReader in;
		try{
			socket = new Socket(hostName, portNumber);
			oos = new ObjectOutputStream(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			sockReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			Credential obj = new Credential(NIM, password, Credential.LOGOUT);
			oos.writeObject(obj);
			String response = in.readLine();
			System.out.println("Message from server: " + response);
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void printRequest(String fileName){
		if (LoggedIn) {
			try {
				socket = new Socket(hostName, portNumber);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
				// get and print out file name list
				
				Credential c = new Credential(NIM, password, Credential.PRINT);
				c.setFile(fileName);
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
		}
	}
	
	public void sendFile(String filePath) {
		//System.out.println(LoggedIn);
		if (LoggedIn) {
			try {
				socket = new Socket(hostName, portNumber);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				TransObject obj = new TransObject(NIM,filePath);
				oos.writeObject(obj);
				upload(obj);
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
		}	
	}
	
	private void upload(TransObject obj) {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			if (true) {
				File f = new File(obj.getFileName());
				BufferedInputStream inFile = new BufferedInputStream(new FileInputStream(f));
				byte[] buf = new byte[(int) f.length()];
				inFile.read(buf);
				socket.getOutputStream().write(buf);
			}
			String response = in.readLine();
			//send message to server
			out.println("Someone send a message: " + input);

			//read message from server
			System.out.println("Message from server: " + response);
		} catch (Exception e) {
			System.out.println("Terjadi kesalahan dalam pengiriman");
		}
	}
	
	//getter and setter
	public String getHostName() {
		return hostName;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public Socket getSocket() {
		return socket;
	}

	public String getInput() {
		return input;
	}

	public String getNIM() {
		return NIM;
	}

	public String getPassword() {
		return password;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public BufferedReader getSockReader() {
		return sockReader;
	}

	public boolean isLoggedIn() {
		return LoggedIn;
	}
}
