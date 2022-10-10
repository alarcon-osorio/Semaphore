/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semaphore2;

import javax.swing.JOptionPane;

/**
 *
 * @author mac
 */
public class Semaphore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        int vel = 3000;
        try{
        vel = Integer.parseInt(JOptionPane.showInputDialog("digite la velocidad y ok para iniciar el semaforo"));
        }catch(Exception e){
            vel=300;
        }
        
        Temporizador s = new Temporizador();
        s.semaforoprendido(vel);
    }
}