package server;

import controller.ControllerBoard;
import model.Light;
import view.SemaphoreView;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server extends JFrame implements Runnable {
    private ServerSocket serverSocket;

    private SemaphoreView semaphoreView = new SemaphoreView();

    Light light = new Light();

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(1000000);
    }

    public static void main(String[] args) {
        int port = 8080;
        try {
            Runnable t = new Server(port);
            t.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        while (true) {

            try {

                System.out.println("Esperando conexión del cliente " + serverSocket.getLocalPort());
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

                        output.writeUTF("Arrancando Consola...");
                        ControllerBoard frame = new ControllerBoard();
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(600, 200);
                        frame.setResizable(true);
                        frame.setVisible(true);

                    } else if (service == 2) {
                        output.writeUTF("\n\nMenu \n" + menu());
                    } else {
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
        return "\tServidor Iniciado...\n***************************\n" +
                "Seleccione una Opcion\n" +
                "0. Salir del Sistema\n" +
                " 1. Iniciar\n" +
                " 2. Menu";
    }
}
