import presentation.ControllerBoardPrincipal;

import javax.swing.*;
import java.io.IOException;

public class LaunchServer {

    public static void main(String[] args) throws IOException {
        ControllerBoardPrincipal frame = new ControllerBoardPrincipal();
        frame.setTitle("Controladora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(310, 390);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
