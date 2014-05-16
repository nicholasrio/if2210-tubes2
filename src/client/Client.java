package Client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import Entity.Credential;
import Entity.TransObject;

public class Client {

	
	String hostName = "localhost";
	int portNumber = 5432;
	Socket socket;
	String input;
	BufferedReader reader;
	BufferedReader sockReader;
	private boolean LoggedIn;
                
	public static void main(String[] args){
		Client client = new Client();
	}
	
	public Client() {
            LoggedIn    =    false;
		try {
			do{
                            		reader = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("1. login");
				System.out.println("2. print");
				System.out.println("3. exit");
				input = reader.readLine();
				if(input.equals("login")){
					login();
				}
				else if(input.equals("print")){
					//sendPrintInfo();
				}
                                
			}while(!input.equals("exit"));
		}catch(Exception e){
			//e.printStackTrace();
		}
	}
	
	public void login(){
		try {
                    String NIM;
                    String password;
                    System.out.println("Enter NIM: ");
                    NIM = reader.readLine();
                    System.out.println("Enter password: ");
                    password = reader.readLine();
                    socket = new Socket(hostName, portNumber);
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    sockReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    Credential obj = new Credential(NIM, password);
                    //send credential
                    oos.writeObject(obj);
                    //oos.writeBytes("\n");
                    //get response
                    System.out.println(sockReader.readLine());
                    while(!reader.readLine().contains(null)){
                            oos.writeObject(obj);
                            System.out.println(sockReader.readLine());
                            //socket.shutdownInput();
                    }
                    oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*public void sendPrintInfo(){
		try {
			while(!(input = reader.readLine()).equals("exit")){
				
			}
			while ((input = reader.readLine()) != null) {
		    	socket = new Socket(hostName, portNumber);
		    	ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		    	TransObject obj = new TransObject(13512045, "Gilang Julian Suherik");
		    	TransObject obj2 = new TransObject(13512000, "Siapa nih?");
		    	oos.writeObject(obj);
		    	oos.writeObject(obj2);
		    	oos.close();
		        //System.exit(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}*/
}


//buat kalo mau pake file

//PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
/*if(true){
	File f = new File("ClientFolder/send.pdf");
	BufferedInputStream inFile = new BufferedInputStream(new FileInputStream(f));
	byte[] buf = new byte[(int)f.length()];
	inFile.read(buf);
	socket.getOutputStream().write(buf);
}*/
//	send message to server
//out.println("Someone send a message: "+input);

//	read message from server
//System.out.println(in.readLine());