package warhammerrpg.network;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import warhammerrpg.network.exception.NetworkException;

import java.io.IOException;

public class Server {
    com.esotericsoftware.kryonet.Server server;

    public void run(int port) throws NetworkException {
        System.out.println("start running server");

        server = new com.esotericsoftware.kryonet.Server();
        new Register().registerClasses(server.getKryo());

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                System.out.println("coś odebrałem");
            }
        });

        server.start();

        try {
            server.bind(port);
        } catch (IOException e) {
            throw new NetworkException(e);
        }
    }

    public void stop() {
        server.stop();
    }

}
