package warhammerrpg.network.client.action;

import com.esotericsoftware.kryonet.Connection;
import warhammerrpg.core.Observable;
import warhammerrpg.gui.client.observer.OnKickGuiObserver;
import warhammerrpg.network.AbstractAction;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.pack.KickPack;
import warhammerrpg.network.pack.Pack;

import static warhammerrpg.core.Observable.Event.CLIENT_KICKED;
import static warhammerrpg.core.Observable.Event.SERVER_USER_HAS_JOINED;

public class KickAction extends AbstractAction implements ActionInterface, Observable {

    @Override
    public Pack run(Pack request, Connection connection) {
        KickPack kickPack = (KickPack) request;

        this.notifyObservers(CLIENT_KICKED, kickPack.message);
        return null;
    }
}
