package warhammerrpg.network.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import warhammerrpg.gui.client.ClientGuiConnector;
import warhammerrpg.network.client.action.WelcomeReplyAction;
import warhammerrpg.network.pack.Pack;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.server.action.PingAction;
import warhammerrpg.network.exception.UnexpectedRequestException;
import warhammerrpg.network.pack.PingPack;
import warhammerrpg.network.pack.WelcomeReplyPack;

public class ClientListener  extends Listener {

    Client client;
    ClientGuiConnector clientGuiConnector;

    public ClientListener(Client client, ClientGuiConnector clientGuiConnector) {
        this.client = client;
        this.clientGuiConnector = clientGuiConnector;
    }

    public void received (Connection connection, Object object) {

        if (object instanceof Pack) {
            Pack request = (Pack)object;

            ActionInterface action = null;
            try {
                action = selectAction(request);
            } catch (UnexpectedRequestException e) {
                e.printStackTrace();
                //@todo put something
            }

            Pack pack = action.run(request);

            if(pack != null) {
                connection.sendTCP(pack);
            }
        }
    }

    private ActionInterface selectAction(Pack response) throws UnexpectedRequestException {
        if(response instanceof PingPack) {
            return new PingAction();
        } else if(response instanceof WelcomeReplyPack) {
            return new WelcomeReplyAction(this.client, clientGuiConnector);
        }
        throw new UnexpectedRequestException();
    }
}
