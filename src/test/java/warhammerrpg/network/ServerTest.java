package warhammerrpg.network;

import junit.framework.TestCase;
import warhammerrpg.network.exception.ClientConnectException;
import warhammerrpg.network.exception.NetworkException;
import warhammerrpg.network.request.PingRequest;

public class ServerTest extends TestCase {


    public void testRun() throws Exception {
        Server server = new Server();
        server.run(54321);

        Client client = new Client("localhost", 54321);
        client.sendRequest(new PingRequest());
        server.stop();
    }

    public void testStop(){
        Server server = new Server();
        try {
            server.run(54321);
        } catch (NetworkException e) {
            fail();
        }
        server.stop();


        try {
            Client client = new Client("localhost", 54321);
            fail();
        } catch (ClientConnectException e) {
            //nothing
        }
    }

}