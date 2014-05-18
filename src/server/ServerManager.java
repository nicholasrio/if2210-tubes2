package Server;

import java.net.Socket;

public class ServerManager {

	public static final int MAX_THREADS = 10;
	public static int availableThreads = 10;
	private static boolean[] available = {true, true, true, true, true, true, true, true, true, true};
	private static ServerThread[] threads = new ServerThread[10];

	public static ServerThread get(Socket socket) {
		int i = 0;
		while (!available[i]) {
			i++;
		}
		availableThreads--;
		available[i] = false;
		threads[i] = new ServerThread(socket, i);
		return threads[i];
	}

	public static boolean isAvailable() {
		boolean found = false;
		int i = 0;
		while (i < MAX_THREADS && !found) {
			if (available[i]) {
				found = true;
			}
			i++;
		}
		return found;
	}

	public static void release(int id) {
		availableThreads++;
		available[id] = true;
		threads[id] = null;
	}

}
