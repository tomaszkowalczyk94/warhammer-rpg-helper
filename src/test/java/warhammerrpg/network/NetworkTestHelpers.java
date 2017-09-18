package warhammerrpg.network;

import warhammerrpg.gui.client.ClientGuiConnector;
import warhammerrpg.gui.master.MasterGuiConnector;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.exception.ClientConnectException;
import warhammerrpg.network.exception.InvalidUsernameException;
import warhammerrpg.network.exception.NetworkException;
import warhammerrpg.network.server.Server;

import static org.mockito.Mockito.mock;

public class NetworkTestHelpers {

    public static String host = "localhost";
    public static int port = 54321;
    public static String username = "test";

    public static Server createServer() throws NetworkException {
        Server server = new Server();
        server.setMasterGuiConnector(mock(MasterGuiConnector.class));

        server.run(port);
        return server;
    }

    public static Client createClient() throws ClientConnectException, InvalidUsernameException {
        Client client = new Client();
        client.connect(host, port, username);

        ClientGuiConnector clientGuiConnector = mock(ClientGuiConnector.class);

        client.setClientGuiConnector(clientGuiConnector);

        return client;
    }
}
