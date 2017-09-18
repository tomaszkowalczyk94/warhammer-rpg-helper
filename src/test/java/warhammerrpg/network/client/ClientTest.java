package warhammerrpg.network.client;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import warhammerrpg.network.NetworkTestHelpers;
import warhammerrpg.network.pack.PingPack;
import warhammerrpg.network.server.Server;

public class ClientTest {

    static Server server;
    static Client client;

    @BeforeClass
    public static void initialize() throws Exception {
        server = NetworkTestHelpers.createServer();
        client = NetworkTestHelpers.createClient();
    }

    @Test
    public void sendRequest() throws Exception {
        client.sendRequest(new PingPack());
    }

    @AfterClass
    public static void afterClass() {
        client.close();
        server.stop();
    }




}