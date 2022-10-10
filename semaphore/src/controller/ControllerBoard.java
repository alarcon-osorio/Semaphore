/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import server.Server;
import view.SemaphoreView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author mac
 */
public class ControllerBoard extends JFrame implements ActionListener {

    private JMenuItem jmiClose;
    private JRadioButton jrbInit, jrbRed,  jrbYellow, jrbGreen, jrbOff, jrbFail, jrbAuto, jrbRepair;
    private ButtonGroup btg = new ButtonGroup();

    JLabel tittleController = new JLabel();;
    
    private SemaphoreView semaphoreView = new SemaphoreView();

    private Server server = new Server(8081);
    
    public ControllerBoard() throws IOException {

        server.run();

        setTitle("Controladora");

        tittleController.setText("CONTROLADORA PRINCIPAL - SERVIDOR");

        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);

        JMenu exitMenu = new JMenu("Exit");
        exitMenu.setMnemonic('E');
        jmb.add(exitMenu);

        jmiClose = new JMenuItem("Close");
        jmiClose.setMnemonic('C');
        exitMenu.add(jmiClose);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());

        p2.add(jrbInit = new JRadioButton("Inicio",false));
        p2.add(jrbRed = new JRadioButton("Rojo",false));
        p2.add(jrbYellow = new JRadioButton("Amarillo",false));
        p2.add(jrbGreen = new JRadioButton("Verde",false));
        p2.add(jrbAuto = new JRadioButton("Automatico",false));
        p2.add(jrbOff = new JRadioButton("Off",false));
        p2.add(jrbFail = new JRadioButton("Fallo",false));
        p2.add(jrbRepair = new JRadioButton("Reparacion",false));

        btg.add(jrbRepair);
        btg.add(jrbAuto);
        btg.add(jrbFail);
        btg.add(jrbOff);
        btg.add(jrbInit);
        btg.add(jrbRed);
        btg.add(jrbYellow);
        btg.add(jrbGreen);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p2, BorderLayout.SOUTH);

        getContentPane().add(tittleController, BorderLayout.CENTER);

        jrbAuto.addActionListener(this);
        jrbRepair.addActionListener(this);
        jrbFail.addActionListener(this);
        jrbOff.addActionListener(this);
        jrbInit.addActionListener(this);
        jrbRed.addActionListener(this);
        jrbYellow.addActionListener(this);
        jrbGreen.addActionListener(this);
        jmiClose.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if(e.getSource() instanceof JRadioButton) {
            if ("Inicio".equals((actionCommand))){
                semaphoreView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                semaphoreView.setSize(300, 250);
                semaphoreView.setResizable(true);
                semaphoreView.setVisible(true);
            }else if("Rojo".equals(actionCommand)){
                semaphoreView.red();
            }else if("Amarillo".equals(actionCommand)) {
                semaphoreView.yellow();
            }else if("Verde".equals(actionCommand)){
                semaphoreView.green();
            }else if("Automatico".equals(actionCommand)){
               semaphoreView.auto();
            }else if("Off".equals(actionCommand)){
                semaphoreView.off();
            }else if("Fallo".equals(actionCommand)){
                semaphoreView.fail();
            }else if("Reparacion".equals(actionCommand)){
                semaphoreView.repair();
            }else if("Close".equals(actionCommand))
                System.exit(0);
            }
        }

}
