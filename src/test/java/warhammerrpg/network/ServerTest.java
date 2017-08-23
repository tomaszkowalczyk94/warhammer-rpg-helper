package warhammerrpg.network;

import junit.framework.TestCase;
import warhammerrpg.network.request.Ping;

public class ServerTest extends TestCase {

    public void testRun() throws Exception {
        Server server = new Server();
        server.run(54321);

        Client client = new Client("localhost", 54321);
        client.sendObject(new Ping());
        server.stop();

    }

}