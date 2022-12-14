/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monolitosemaforo;

import javax.swing.JFrame;

import monolitosemaforo.client.Client;
import monolitosemaforo.presentation.SemaphoreView;
import monolitosemaforo.server.Server;

import java.io.IOException;

/**
 *
 * @author mac
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        SemaphoreView frame = new SemaphoreView();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(370, 600);
        frame.setTitle("Semaforo");
        frame.setResizable(true);
        frame.setVisible(true);

    }
    
}
