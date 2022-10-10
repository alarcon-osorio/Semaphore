package monolitosemaforo.client;

import java.io.*;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {

    public static void main(String [] args) {
        Socket client = null;
        String host = "127.0.0.1";
        int port = 8080;

        try {
            client = new Socket(host, port);
            InputStream inFromServer = client.getInputStream();
            DataInputStream input = new DataInputStream(inFromServer);

            OutputStream outToServer = client.getOutputStream();
            DataOutputStream output = new DataOutputStream(outToServer);
            Scanner userEntry = new Scanner(System.in);

            System.out.println(input.readUTF());

            int service;

            do {
                System.out.print("\nSeleccione una Opción: ");
                service = userEntry.nextInt();
                System.out.print("Salida : ");
                output.writeInt(service);

            } while (service != 0);

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NoSuchElementException ne){   //This exception may be raised when the server closes connection
            System.out.println("Conexión cerrada");
        }
        finally {
            try {
                System.out.println("\n* Cerrando conexión *");
                client.close();
            } catch (IOException ioEx) {
                System.out.println("--->Conexión no disponible<---");
                System.exit(1);
            }
        }
    }
}
