/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monolitosemaforo.presentation.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author mac
 */
public class Semaphore extends JPanel{
    
    private boolean red;
    private boolean yellow;
    private boolean green;
    private boolean off;

    public Semaphore() {
        red=false;
        yellow=false;
        green=false;
        off=true;
    }

    public void red() {
        red=true;
        yellow=false;
        green=false;
        repaint();
    }

    public void yellow() {
        red=false;
        yellow=true;
        green=false;
        repaint();
    }

    public void green() {
        red=false;
        yellow=false;
        green=true;
        repaint();
    }
    
     public void off() {
        red=false;
        yellow=false;
        green=false;
        off=true;
        repaint();
    }

    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(red) {
            g.setColor(Color.red);
            g.fillOval(20,20,30,30);
            g.setColor(Color.black);
            g.drawOval(20,55,30,30);
            g.drawOval(20,90,30,30);
            g.drawRect(5,5,60,130);
            g.setColor(Color.ORANGE);
            g.fillRect(20,136,30,80);
        }
        
        else if(yellow) {
            g.setColor(Color.yellow);
            g.fillOval(20,55,30,30);
            g.setColor(Color.black);
            g.drawRect(5,5,60,130);
            g.drawOval(20,20,30,30);
            g.drawOval(20,90,30,30);
            g.setColor(Color.ORANGE);
            g.fillRect(20,136,30,80);
        }
        
        else if(green) {
            g.setColor(Color.green);
            g.fillOval(20,90,30,30);
            g.setColor(Color.black);
            g.drawRect(5,5,60,130);
            g.drawOval(20,20,30,30);
            g.drawOval(20,55,30,30);
            g.setColor(Color.ORANGE);
            g.fillRect(20,136,30,80);
        }
        
        else if(off){
            g.setColor(Color.black);
            g.drawRect(5,5,60,130);
            g.drawOval(20,20,30,30);
            g.drawOval(20,55,30,30);
            g.drawOval(20,90,30,30);
            g.setColor(Color.ORANGE);
            g.fillRect(20,136,30,80);
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(70,200);
    }
    
}
