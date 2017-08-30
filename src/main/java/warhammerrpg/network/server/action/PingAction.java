package warhammerrpg.network.server.action;

import com.esotericsoftware.kryonet.Connection;
import warhammerrpg.network.AbstractAction;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.pack.Pack;

public class PingAction  extends AbstractAction implements ActionInterface {

    @Override
    public Pack run(Pack request, Connection connection) {
        System.out.println("PING");
        return null;
    }

}
