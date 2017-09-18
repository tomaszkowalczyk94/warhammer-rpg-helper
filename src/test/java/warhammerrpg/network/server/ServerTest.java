package warhammerrpg.network.server;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import warhammerrpg.network.NetworkTestHelpers;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.pack.PingPack;

public class ServerTest{


    static Server server;
    static Client client;

    @BeforeClass
    public static void initialize() throws Exception {
        server = NetworkTestHelpers.createServer();
        client = NetworkTestHelpers.createClient();
    }

    @Test
    public void kickUser() throws Exception {
        String kickMsg = "you are kicked";
        Assert.assertEquals(1, server.getUsers().size());

        server.kickUser(NetworkTestHelpers.username, kickMsg, true);

        Assert.assertEquals(0, server.getUsers().size());
    }


    @AfterClass
    public static void afterClass() {
        client.close();
        server.stop();
    }

}