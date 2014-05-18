package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerManager {

    private static ServerManager server;
    public static final int MAX_THREADS = 10;
    public int availableThreads = 10;
    private boolean[] available = {true, true, true, true, true, true, true, true, true, true};
    private ServerThread[] threads = new ServerThread[10];

    private ObjectInputStream ois;
    private PrintWriter pw;

    private ServerManager() {

    }

    public static ServerManager getSingleton() {
        if(server != null)
            server = new ServerManager();
        return server;
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

    public static void release(int id) {
        server.availableThreads++;
        server.available[id] = true;
        server.threads[id] = null;
    }

}
