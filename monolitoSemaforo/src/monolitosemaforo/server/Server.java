package monolitosemaforo.server;

import monolitosemaforo.logic.SemaphoreLogic;
import monolitosemaforo.presentation.SemaphoreView;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;


import java.net.*;
import java.io.*;

public class Server extends Thread {
    private ServerSocket serverSocket;

    private SemaphoreLogic semaphoreLogic = new SemaphoreLogic();

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(1000000);
    }

    public static void main(String [] args) {
        int port = 8080;
        try {
            Thread t = new Server(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        while(true) {

            try {

                System.out.println("Esperando conexión del cliente " +
                        serverSocket.getLocalPort());

                Socket server = serverSocket.accept();

                System.out.println("Servicio Conectado desde " + server.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(server.getInputStream());
                DataOutputStream output = new DataOutputStream(server.getOutputStream());

                output.writeUTF("\n\nSERVIDOR INICIADO\n" + menu());

                int service = input.readInt();


                System.out.println("service: " + service);


                do {
                    if (service == 0) {
                        output.writeUTF("Cerrando Semaforo...");

                        break; // from do while
                    } else if (service == 1) {

                        output.writeUTF("Arrancando Semaforo...");
                        SemaphoreView frame = new SemaphoreView();
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(370, 600);
                        frame.setTitle("Semaforo");
                        frame.setResizable(true);
                        frame.setVisible(true);

                    } else if (service == 2) {

                        output.writeUTF("Rojo 2\n\t ");
                        semaphoreLogic.setLight1("Red");

                    } else if (service == 3) {

                        output.writeUTF("Amarillo 3\n\t ");

                    } else if (service == 4) {

                        output.writeUTF("Verde 4\n\t " );

                    } else if (service == 5) {

                        output.writeUTF("Intermitente");
                    }else if (service == 6) {
                        output.writeUTF("Intermitente");
                    }
                    else if (service == 6) {
                        output.writeUTF("\n\nMenu \n" + menu());
                    }else {
                        output.writeUTF("Opcion Invalida\n\t " + "Seleccion no valide");

                    }

                    service = input.readInt();

                } while (service != 0);

                output.writeUTF("Servidor -->\n\t " + "Gracias por conectarse a" + server.getLocalSocketAddress());
                server.close();



            } catch (SocketTimeoutException s) {

                System.out.println("Socket fuera de tiempo");
                break;

            } catch (IOException e) {

                e.printStackTrace();
                break;

            }
        }
    }


    private String menu() {
        return "\tServidor Iniciado\n***************************\n" +
                "Seleccione\n" +
                "Enviando la respuesta en el siguiente formato\n\n" +
                "\tOpcion: (int)\n" +
                "\tEntrada 1: (int)\n" +
                "\tEntrada 2 (int)\n\n " +
                "0. Salir del Sistema\n" +
                " 1. Iniciar\n" +
                " 2. Luz Roja\n" +
                " 3. Luz Amarilla\n" +
                " 4. Luz Verde\n" +
                " 5. Luz Intermitente\n" +
                " 6. Apagar Semaforo";
    }

    private String red(String red) {
        return "Rojo";
    }

    private String yellow(String rojo) {
        return "";
    }

    private String green() {
        return "";
    }

    private String qout() {
        return "";
    }
}