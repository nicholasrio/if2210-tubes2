package Server;
/**
 *
 * @author Aryya Dwisatya W / 13512043
 */
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public Server() {
		int portNumber = 8080; 
		try { 
		    ServerSocket serverSocket = new ServerSocket(portNumber);
    	    while(true){
    	    	Socket clientSocket = serverSocket.accept();
    	    	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    		    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    		    //System.out.println(in.readLine());
    		    out.println("Message received");
    		    BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("ServerFolder/receive.pdf")));
	    		int bytesread;
    		    byte[] outBuf = new byte[1024];
	    		while((bytesread = clientSocket.getInputStream().read(outBuf)) != -1){
	    			bout.write(outBuf, 0, bytesread);
	    			System.out.println(bytesread);
	    		}
	    		System.out.println("dummy1");
    		    bout.close();
    		    System.out.println("dummy2");
    		    out.println("finish");
    		    System.out.println("dummy3");
    		    clientSocket.close();
    		    break;
    	    }
    	    System.exit(0);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
