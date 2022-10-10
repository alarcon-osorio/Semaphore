package view;

import client.Client;
import model.Light;

import javax.swing.*;
import javax.swing.plaf.SliderUI;
import java.awt.*;

import java.util.Timer;
import java.util.TimerTask;

public class SemaphoreView extends JFrame implements Runnable{
    private Light light = new Light();
    Timer timer = new Timer();

    Client client;


    public SemaphoreView(){

        setTitle("Semaforo");

        //Se agrega el semaforo contenido en un panel al panel p1
        JPanel p1 = new JPanel();
        p1.setSize(200, 200);
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        light.setSize(100, 90);
        p1.add(light);

        getContentPane().add(p1, BorderLayout.CENTER);

    }

    public void red(){
        System.out.println("Rojo");
        light.red();
    }

    public void yellow(){
        System.out.println("Yellow");
        light.yellow();
    }

    public void green(){
        System.out.println("Green");
        light.green();
    }

    public void off(){
        System.out.println("Off");
        light.off();
    }

    public void auto() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                light.red();
                System.out.println("Luz Roja");
            }
        }, 5000, 5000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                light.green();
                System.out.println("Luz Amarilla");
            }
        }, 5000, 5000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                light.yellow();
                System.out.println("Luz Verde");
            }
        }, 5000, 5000);

    }

    public void fail(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                light.fail();
                System.out.println("Intermitencia: Falla " + 1);
            }
        }, 0, 1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                light.off();
                System.out.println("Intermitencia: Falla " + 2);
            }
        }, 100, 2000);


    }
    public void repair(){
        System.out.println("Reparacion");
        timer.cancel();
    }

    @Override
    public void run() {

    }
}
