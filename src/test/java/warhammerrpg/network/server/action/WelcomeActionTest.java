package warhammerrpg.network.server.action;

import com.esotericsoftware.kryonet.Connection;
import org.junit.Before;
import org.junit.Test;
import warhammerrpg.network.pack.WelcomePack;
import warhammerrpg.network.pack.WelcomeReplyPack;
import warhammerrpg.network.server.ServerUserContainer;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class WelcomeActionTest {

    HashMap<String, ServerUserContainer> emptyUsers = new HashMap<String, ServerUserContainer>();

    @Before
    public void before() {

    }

    @Test
    public void checkToken() throws Exception {
        assertFalse(new WelcomeAction(emptyUsers).checkToken());
    }

    @Test
    public void run() throws Exception {
        String firstToken;
        String secondToken;

        WelcomeAction welcomeAction = new WelcomeAction(emptyUsers);

        Connection conn = mock(Connection.class);
        WelcomePack welcomePack = new WelcomePack();
        welcomePack.setUsername("nowyuser");


        assertEquals(0, emptyUsers.size());
        WelcomeReplyPack welcomeReply = (WelcomeReplyPack) welcomeAction.run(welcomePack, conn);
        assertEquals(1, emptyUsers.size());

        firstToken = welcomeReply.receivedToken;
        assertTrue(welcomeReply.successful);

        WelcomePack welcomePack2 = new WelcomePack();
        welcomePack2.setUsername("nowyuser2");
        WelcomeReplyPack welcomeReply2 = (WelcomeReplyPack) welcomeAction.run(welcomePack2, conn);
        assertEquals(2, emptyUsers.size());
        secondToken = welcomeReply2.receivedToken;

        //spr czy tokeny nie są takie same
        assertNotEquals(firstToken, secondToken);

        WelcomePack welcomePack3 = new WelcomePack();
        welcomePack3.setUsername("nowyuser"); // nazwa się powtarza
        WelcomeReplyPack welcomeReply3 = (WelcomeReplyPack) welcomeAction.run(welcomePack3, conn);
        assertFalse(welcomeReply3.successful);
        assertNull(welcomeReply3.receivedToken);

    }



}