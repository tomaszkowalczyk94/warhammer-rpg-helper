package warhammerrpg.network;

import com.esotericsoftware.kryonet.Server;
import warhammerrpg.network.exception.NetworkException;

import java.io.IOException;

public class Network {

    public void runServer() throws NetworkException {
        System.out.println("start running server");

        Server server = new Server();
        server.start();

        try {
            server.bind(54321);
        } catch (IOException e) {
            throw new NetworkException(e);
        }


    }

}
