package warhammerrpg.network.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import warhammerrpg.gui.master.MasterGuiConnector;
import warhammerrpg.network.pack.Pack;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.server.action.PingAction;
import warhammerrpg.network.server.action.WelcomeAction;
import warhammerrpg.network.exception.UnexpectedRequestException;
import warhammerrpg.network.pack.PingPack;
import warhammerrpg.network.pack.WelcomePack;

import java.util.HashMap;
import java.util.Map;

class ServerListener extends Listener {

    private Map<String, ServerUserContainer> users;

    MasterGuiConnector masterGuiConnector;

    public ServerListener(MasterGuiConnector masterGuiConnector, Map<String, ServerUserContainer> users) {
        this.masterGuiConnector = masterGuiConnector;
        this.users = users;
    }

    public void received (Connection connection, Object object) {

        if (object instanceof Pack) {
            Pack request = (Pack)object;

            ActionInterface action = null;
            try {
                action = SelectAction(request);
            } catch (UnexpectedRequestException e) {
                e.printStackTrace();
                //@todo put something
            }

            Pack response = action.run(request);

            if(response != null) {
                connection.sendTCP(response);
            }
        }
    }

    private ActionInterface SelectAction(Pack request) throws UnexpectedRequestException {
        if(request instanceof PingPack) {
            return new PingAction();
        } else if((request instanceof WelcomePack)) {
            return new WelcomeAction(users, masterGuiConnector);
        }
        throw new UnexpectedRequestException();
    }
}
