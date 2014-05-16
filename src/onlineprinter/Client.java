package onlineprinter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 *
 * @author Aryya Dwisatya W / 13512043
 * 
 */
public class Client {

	
	String hostName = "127.0.0.1";
	int portNumber = 8080;
	Socket echoSocket;
	String userInput;
		
	/*
        public static void main(String[] args){
		Client client = new Client();
	}
	*/
	public Client() {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			while ((userInput = stdIn.readLine()) != null) {
		    	echoSocket = new Socket(hostName, portNumber);
			    PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
			    BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			    if(true){
			    	File f = new File("ClientFolder/send.pdf");
			    	BufferedInputStream inFile = new BufferedInputStream(new FileInputStream(f));
			    	byte[] buf = new byte[(int)f.length()];
			    	inFile.read(buf);
			    	echoSocket.getOutputStream().write(buf);
			    }
			    //	send message to server
			    //out.println("Someone send a message: "+userInput);
			    
			    //	read message from server
		        System.out.println(in.readLine());
		        //System.exit(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(echoSocket != null){
				try {
					echoSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
