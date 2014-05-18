package Server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Entity.Credential;
import Entity.TransObject;

public class Server {
 
	public static final int BUF_SIZE = 2048;
	
	public static void main(String[] args){
		Server server = new Server();
	}
	
	public Server() {
		int portNumber = 5432;
		try { 
		    ServerSocket serverSocket = new ServerSocket(portNumber);
                    while(true){
                        Socket clientSocket = serverSocket.accept();
                        
                        //buat kalo mau baca dari file
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        out.println(in.readLine());
                        out.println("Message received");
                        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("receive.pdf")));
                        int bytesread;
                        byte[] outBuf = new byte[2048];
                        int retval;
                        do{
                                retval = (bytesread = clientSocket.getInputStream().read(outBuf));
                                System.out.println(retval);
                                bout.write(outBuf, 0, bytesread);
                                System.out.println(bytesread);
                                System.out.println("dummy1");
                        }while(retval == BUF_SIZE);
                        
                        ServerThread ss = ServerManager.get(clientSocket);
                        ss.start();
                    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

