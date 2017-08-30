package warhammerrpg.gui.master.observer;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.gui.master.MasterGuiConnector;
import warhammerrpg.network.server.ServerUserContainer;

import java.util.Map;

public class OnTokenError extends AbstractMasterGuiObserver implements Observer {

    public OnTokenError(MasterGuiConnector masterGuiConnector) {
        super(masterGuiConnector);
    }

    @Override
    public void run(Observable.Event e, Object param1, Object param2) throws UnknowObserableEventException {
        switch (e) {
            case SERVER_USER_TOKEN_ERROR:
                String username = (String) param1;
                masterGuiConnector.addNotice("Bledny token od gracza: "+username);
                System.out.println("OnDisconnectGuiObserver - SERVER_USER_DISCONNECTED wywoluje się");
                break;
        }
    }
}
