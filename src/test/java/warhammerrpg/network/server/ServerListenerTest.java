package warhammerrpg.network.server;

import com.esotericsoftware.kryonet.Connection;
import org.junit.Before;
import org.junit.Test;
import warhammerrpg.gui.master.MasterGuiManager;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerListenerTest {

    private Map<String, ServerUserContainer> users;
    MasterGuiManager masterGuiManager;
    ServerListener serverListener;

    @Before
    public void setUp() throws Exception {
        users = new HashMap<String, ServerUserContainer>();
        masterGuiManager = mock(MasterGuiManager.class);

    }

    @Test
    public void disconnected() throws Exception {
        Connection connection = mock(Connection.class);
        when(connection.getID()).thenReturn(99);

        ServerUserContainer serverUserContainer = new ServerUserContainer();
        serverUserContainer.setConnection(connection);
        serverUserContainer.setUsername("testUsername");
        users.put("testUsername", serverUserContainer);

        serverListener = new ServerListener(masterGuiManager, users);


        Connection connectionfail = mock(Connection.class);
        when(connectionfail.getID()).thenReturn(100);

        assertEquals(1, users.size());
        serverListener.disconnected(connectionfail);
        assertEquals(1, users.size());
        serverListener.disconnected(connection);
        assertEquals(0, users.size());
    }

}