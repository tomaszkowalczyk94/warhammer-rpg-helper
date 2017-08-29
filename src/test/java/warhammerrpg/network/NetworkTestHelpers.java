package warhammerrpg.network;

import warhammerrpg.network.client.Client;
import warhammerrpg.network.exception.ClientConnectException;
import warhammerrpg.network.exception.InvalidUsernameException;
import warhammerrpg.network.exception.NetworkException;
import warhammerrpg.network.server.Server;

public class NetworkTestHelpers {

    public static Server createServer() throws NetworkException {
        Server server = new Server();
        server.run(54321);
        return server;
    }

    public static Client createClient() throws ClientConnectException, InvalidUsernameException {
        Client client = new Client();
        client.connect("localhost", 54321, "test");
        return client;
    }
}
