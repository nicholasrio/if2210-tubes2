package Server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import job.Job;

public class ServerManager {

	private static final int MAX_THREADS = 10;
	private static int availableThreads = 10;
	private static ServerManager instance;
	private boolean[] available = {true, true, true, true, true, true, true, true, true, true};
	private ServerThread[] threads;
	private List<String> loggedInUsers;

	public Job myJob;

	private ServerManager() {
		threads = new ServerThread[MAX_THREADS];
		loggedInUsers = new ArrayList<String>();
	}

	public static ServerManager getSingleton() {
		if (instance == null) {
			instance = new ServerManager();
		}
		return instance;
	}

	public ServerThread get(Socket socket) {
		int i = 0;
		while (!available[i]) {
			i++;
		}
		availableThreads--;
		available[i] = false;
		threads[i] = new ServerThread(socket, i);
		return threads[i];
	}

	public boolean isAvailable() {
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

	public void release(int id) {
		availableThreads++;
		available[id] = true;
		try {
			threads[id].join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		threads[id] = null;
	}

	public void addLoggedUser(String username) {
		loggedInUsers.add(username);
		System.out.println("User: " + username + " has logged in");
	}

	public void removeLoggedUser(String username) {
		loggedInUsers.remove(username);
		System.out.println("User: " + username + " has logged out");
	}

	public boolean isLoggedIn(String username) {
		return loggedInUsers.contains(username);

	}

}
