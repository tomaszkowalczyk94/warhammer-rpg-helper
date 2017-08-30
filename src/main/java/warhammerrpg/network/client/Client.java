package warhammerrpg.network.client;

import warhammerrpg.gui.client.ClientGuiConnector;
import warhammerrpg.network.pack.Pack;
import warhammerrpg.network.Register;
import warhammerrpg.network.exception.ClientConnectException;
import warhammerrpg.network.exception.InvalidUsernameException;
import warhammerrpg.network.pack.WelcomePack;

import java.io.IOException;

public class Client {

    private com.esotericsoftware.kryonet.Client client;

    private String token;
    private String username;
    private ClientGuiConnector clientGuiConnector;


    public Client() {
        client = new com.esotericsoftware.kryonet.Client();
        new Register().registerClasses(client.getKryo());

    }

    public void connect(String host, int port, String username) throws InvalidUsernameException, ClientConnectException {
        client.addListener(new ClientListener(this, clientGuiConnector));
        client.start();

        try {
            if (username == null | username.length() < 2) {
                throw new InvalidUsernameException();
            }
            this.username = username;
            client.connect(5000, host, port);

            WelcomePack welcomeRequest = new WelcomePack();
            welcomeRequest.setUsername(username);
            this.sendRequest(welcomeRequest);
        } catch(NumberFormatException e) {
                throw new ClientConnectException(e);
        } catch (IOException | IllegalArgumentException e) {
            throw new ClientConnectException(e);
        }
    }

    public void sendRequest(Pack request) {
        request.setToken(token);
        request.setUsername(username);
        client.sendTCP(request);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public ClientGuiConnector getClientGuiConnector() {
        return clientGuiConnector;
    }

    public void setClientGuiConnector(ClientGuiConnector clientGuiConnector) {
        this.clientGuiConnector = clientGuiConnector;
    }
}
