package monolitosemaforo;

import monolitosemaforo.server.Server;

import java.io.IOException;

public class LauncherServer{

    public static void main(String [] args) {
        int port = 8080;
        try {
            Server server = new Server(port);
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
