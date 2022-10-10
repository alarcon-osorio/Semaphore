
import javax.swing.*;

import view.SemaphoreView;

/**
 *
 * @author mac
 */
public class LaunchSemaphore {

    public static void main(String[] args) {
        SemaphoreView frame = new SemaphoreView();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(370, 600);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
