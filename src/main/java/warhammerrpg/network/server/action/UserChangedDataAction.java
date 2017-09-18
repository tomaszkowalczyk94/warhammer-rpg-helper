package warhammerrpg.network.server.action;

import com.esotericsoftware.kryonet.Connection;
import warhammerrpg.core.Observable;
import warhammerrpg.network.AbstractAction;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.pack.ChangeDataEventPack;
import warhammerrpg.network.pack.Pack;

import static warhammerrpg.core.Observable.Event.SERVER_USER_CHANGED_DATA;

/**
 * default observers:
 *  - OnUserChangeDataServerGuiObserver
 */
public class UserChangedDataAction extends AbstractAction implements ActionInterface, Observable {


    @Override
    public Pack run(Pack request, Connection connection) {
        ChangeDataEventPack changeDataEventPack = (ChangeDataEventPack) request;


        this.notifyObservers(SERVER_USER_CHANGED_DATA, changeDataEventPack.getUsername(), changeDataEventPack);
        return null;
    }
}
