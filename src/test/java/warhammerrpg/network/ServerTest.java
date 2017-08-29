package warhammerrpg.network;

import junit.framework.TestCase;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.exception.ClientConnectException;
import warhammerrpg.network.exception.InvalidUsernameException;
import warhammerrpg.network.exception.NetworkException;
import warhammerrpg.network.server.Server;
import warhammerrpg.network.pack.PingPack;

public class ServerTest extends TestCase {


    public void testRun() throws Exception {
        Server server = new Server();
        server.run(54321);

        Client client = new Client();
        client.connect("localhost", 54321, "test");
        //client.sendRequest(new PingPack());
        //wait();
        //master.stop();
    }

}