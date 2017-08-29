package warhammerrpg.network;

import warhammerrpg.network.exception.ClientConnectException;
import warhammerrpg.network.exception.InvalidUsernameException;
import warhammerrpg.network.request.RequestInterface;

import java.io.IOException;

public class Client {

    private com.esotericsoftware.kryonet.Client client;

    public Client(String host, int port, String username) throws ClientConnectException, InvalidUsernameException {

        if(username == null | username.length() < 2) {
            throw new InvalidUsernameException();
        }

        client = new com.esotericsoftware.kryonet.Client();
        new Register().registerClasses(client.getKryo());
        client.addListener(new ClientListener());
        client.start();



        try {
            client.connect(5000, host, port);
        } catch (IOException e) {
            throw new ClientConnectException(e);
        }
    }

    public void sendRequest(RequestInterface request) {
        client.sendTCP(request);
    }


}
