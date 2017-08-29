package warhammerrpg.network.server.action;

import junit.framework.TestCase;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.NetworkTestHelpers;
import warhammerrpg.network.server.Server;

public class WelcomeActionTest extends TestCase {

    public void testRun() throws Exception {
        Server server = NetworkTestHelpers.createServer();
        Client client = NetworkTestHelpers.createClient();


        server.stop();


    }

}