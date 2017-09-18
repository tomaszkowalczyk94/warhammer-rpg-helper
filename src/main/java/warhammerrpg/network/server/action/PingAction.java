package warhammerrpg.network.server.action;

import com.esotericsoftware.kryonet.Connection;
import warhammerrpg.core.Observable;
import warhammerrpg.network.AbstractAction;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.pack.Pack;

public class PingAction  extends AbstractAction implements ActionInterface, Observable {

    @Override
    public Pack run(Pack request, Connection connection) {
        System.out.println("PING");
        return null;
    }

}
