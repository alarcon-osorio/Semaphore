import logic.Client;

import java.io.IOException;

/**
 *
 * @author mac
 */
public class LaunchClient {

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.run();
    }
}
