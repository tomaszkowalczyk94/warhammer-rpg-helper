package warhammerrpg.network.server.action;

import org.junit.Test;
import warhammerrpg.network.pack.ChangeDataEventPack;

import static org.junit.Assert.*;

public class UserChangedDataActionTest {
    @Test
    public void run() throws Exception {

        ChangeDataEventPack changeDataEventPack = new ChangeDataEventPack();
        changeDataEventPack.setToken("xxx");
        changeDataEventPack.setUsername("test");

        UserChangedDataAction userChangedDataAction = new UserChangedDataAction();
        assertNull(userChangedDataAction.run(changeDataEventPack, null));
    }

}