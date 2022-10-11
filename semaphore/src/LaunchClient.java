import javax.swing.*;

import presentation.SemaphoresView;

/**
 *
 * @author mac
 */
public class LaunchClient {

    public static void main(String[] args) {
        SemaphoresView frame = new SemaphoresView();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(260, 600);
        frame.setTitle("Semaforo");
        frame.setResizable(true);
        frame.setVisible(true);
     
    }
}
