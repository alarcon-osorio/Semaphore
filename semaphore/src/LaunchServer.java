import client.Client;
import controller.ControllerBoard;

import javax.swing.*;
import java.io.IOException;

public class LaunchServer {

    public static void main(String[] args) throws IOException {
        ControllerBoard frame = new ControllerBoard();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setResizable(true);
        frame.setVisible(true);

        Client client = new Client();

    }
}
