package warhammerrpg.network.client;

import warhammerrpg.network.pack.Pack;
import warhammerrpg.network.Register;
import warhammerrpg.network.exception.ClientConnectException;
import warhammerrpg.network.exception.InvalidUsernameException;
import warhammerrpg.network.pack.WelcomePack;

import java.io.IOException;

public class Client {

    private com.esotericsoftware.kryonet.Client client;

    private String token;

    public Client(String host, int port, String username) throws ClientConnectException, InvalidUsernameException {

        if(username == null | username.length() < 2) {
            throw new InvalidUsernameException();
        }

        client = new com.esotericsoftware.kryonet.Client();
        new Register().registerClasses(client.getKryo());
        client.addListener(new ClientListener(this));
        client.start();

        try {
            client.connect(5000, host, port);

            WelcomePack welcomeRequest = new WelcomePack();
            welcomeRequest.setUsername(username);
            this.sendRequest(welcomeRequest);
        } catch (IOException e) {
            throw new ClientConnectException(e);
        }
    }

    public void sendRequest(Pack request) {
        client.sendTCP(request);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



}
