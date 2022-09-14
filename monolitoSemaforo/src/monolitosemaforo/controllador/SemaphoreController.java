/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monolitosemaforo.controllador;

import monolitosemaforo.presentation.model.Semaphore;

import java.awt.Component;
import javax.swing.JFrame;

/**
 *
 * @author mac
 */
public class SemaphoreController extends JFrame {
    
    Semaphore semaphore1 = new Semaphore();
    Semaphore semaphore2 = new Semaphore();
    Semaphore semaphore3 = new Semaphore();
    Semaphore semaphore4 = new Semaphore();
    
    public Component getLight1(){
        semaphore1.setSize(50, 40);
        return semaphore1;
    }
    
    public Component getLight2(){
        semaphore2.setSize(50, 40);
        return semaphore2;
    }
    
    public Component getLight3(){
        semaphore3.setSize(50, 40);
        return semaphore3;
    }
    
    public Component getLight4(){
        semaphore4.setSize(50, 40);
        return semaphore4;
    }
    
    public void setLight(String color){
        if("Off".equals(color)){
            semaphore1.off();
            semaphore2.off();
            semaphore3.off();
            semaphore4.off();
        }else if ("Red".equals(color)){
            semaphore1.red();
            semaphore2.yellow();
            semaphore3.red();
            semaphore4.yellow();
        }else if ("Yellow".equals(color)){
            semaphore1.yellow();
            semaphore2.green();
            semaphore3.yellow();
            semaphore4.green();
        }else if ("Green".equals(color)){
            semaphore1.green();
            semaphore2.red();
            semaphore3.green();
            semaphore4.red();
        }
    }
    
    
}
