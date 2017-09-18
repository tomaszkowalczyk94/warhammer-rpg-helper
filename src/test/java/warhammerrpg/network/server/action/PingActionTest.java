package warhammerrpg.network.server.action;

import org.junit.Test;

import static org.junit.Assert.*;

public class PingActionTest {
    @Test
    public void run() throws Exception {
        PingAction pingAction = new PingAction();
        assertNull(pingAction.run(null, null));
    }

}