package warhammerrpg.gui.master.observer;

import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.gui.master.MasterGuiConnector;
import warhammerrpg.network.server.ServerUserContainer;

import java.util.Map;

import static warhammerrpg.core.Observable.*;

public class OnConnectGuiObserver extends AbstractMasterGuiObserver  implements Observer {

    public OnConnectGuiObserver(MasterGuiConnector masterGuiConnector) {
        super(masterGuiConnector);
    }

    @Override
    public void run(Event e, Object param1, Object param2) throws UnknowObserableEventException {

        switch (e) {
            case SERVER_USER_HAS_JOINED:
                Map<String, ServerUserContainer> users = (Map<String, ServerUserContainer>) param1;
                ServerUserContainer serverUserContainer = (ServerUserContainer) param2;
                masterGuiConnector.refreshUsersList(users);
                masterGuiConnector.addNotice("Gracz "+serverUserContainer.getUsername()+" połączył . Token: " + serverUserContainer.getToken());
                System.out.println("OnConnectGuiObserver - SERVER_USER_HAS_JOINED wywoluje się");
                break;
            case SERVER_USER_JOINED_TOKEN_ALREADY_EXIST:
                String username = (String) param1;
                masterGuiConnector.addNotice("Gracz "+username+" próbował się połączyć, ale jest już połączony");
                System.out.println("OnConnectGuiObserver - SERVER_USER_JOINED_TOKEN_ALREADY_EXIST wywoluje się");
                break;
            default:
                throw new UnknowObserableEventException();
        }


    }
}
