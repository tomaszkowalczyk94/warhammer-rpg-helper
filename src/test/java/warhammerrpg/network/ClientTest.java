package warhammerrpg.network;

import junit.framework.TestCase;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.server.Server;

public class ClientTest extends TestCase {


    public void testSendRequest() throws Exception {

        Server server = NetworkTestHelpers.createServer();
        Client client = new Client("localhost", 54321, "test");



    }

}