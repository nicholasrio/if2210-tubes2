package Server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int BUF_SIZE = 2048;

	public static void main(String[] args) {
		Server server = new Server();
	}

	public Server() {
		int portNumber = 5432;
		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			while (true) {
				Socket clientSocket = serverSocket.accept();
				ServerThread ss = ServerManager.get(clientSocket);
				ss.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*

 //buat kalo mau baca dari file
                        
 */
