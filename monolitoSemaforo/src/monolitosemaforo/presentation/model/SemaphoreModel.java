/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monolitosemaforo.presentation.model;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import monolitosemaforo.logic.Light;

/**
 *
 * @author mac
 */
public class SemaphoreModel extends JFrame {
    
    Light light = new Light();
    
    public Component getLight(){
        light.setSize(50, 40);
        return light;
    }
    
    public void setLight(String color){
        if("Off".equals(color)){
            light.off();
        }else if ("Red".equals(color)){
            light.red();
        }else if ("Yellow".equals(color)){
            light.yellow();
        }else if ("Green".equals(color)){
            light.green();
        }
    }
    
    
}
