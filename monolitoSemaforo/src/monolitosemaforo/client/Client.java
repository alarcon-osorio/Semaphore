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

            int service, input1, input2;

            String red;

            do {
                System.out.print("\nSeleccione una Opción: ");
                service = userEntry.nextInt();

                System.out.print("Entrada : ");

                output.writeInt(service);

                System.out.println(input.readUTF());

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
                System.out.println("--->Unable to disconnect<---");
                System.exit(1);
            }
        }
    }
}
