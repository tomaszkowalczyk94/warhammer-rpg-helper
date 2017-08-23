package warhammerrpg.network;

import warhammerrpg.network.exception.ClientConnectException;

import java.io.IOException;

public class Client {

    private com.esotericsoftware.kryonet.Client client;

    public Client(String host, int port) throws ClientConnectException {
        client = new com.esotericsoftware.kryonet.Client();
        new Register().registerClasses(client.getKryo());

        client.start();

        try {
            client.connect(5000, host, port);
        } catch (IOException e) {
            throw new ClientConnectException(e);
        }
    }

    public void sendObject(Object object) {
        client.sendTCP(object);
    }
}
