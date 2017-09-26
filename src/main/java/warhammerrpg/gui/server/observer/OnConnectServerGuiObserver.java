package warhammerrpg.gui.server.observer;

import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.gui.server.MasterGuiManager;
import warhammerrpg.gui.server.gameNotificationTable.NotificationTableManager;
import warhammerrpg.network.server.ServerUserContainer;

import java.util.Map;

import static warhammerrpg.core.Observable.*;

public class OnConnectServerGuiObserver extends AbstractServerGuiObserver implements Observer {

    public OnConnectServerGuiObserver(MasterGuiManager masterGuiManager) {
        super(masterGuiManager);
    }

    @Override
    public void run(Event e, Object param1, Object param2) throws UnknowObserableEventException {

        String msg;

        switch (e) {
            case SERVER_USER_HAS_JOINED:
                Map<String, ServerUserContainer> users = (Map<String, ServerUserContainer>) param1;
                ServerUserContainer serverUserContainer = (ServerUserContainer) param2;
                masterGuiManager.refreshUsersList(users);

                msg = "Gracz dołączył do gry. Token"+serverUserContainer.getToken();
                masterGuiManager.getNotificationTableManager().addNotification(serverUserContainer.getUsername(), msg, NotificationTableManager.Type.INFO);

                System.out.println("OnConnectServerGuiObserver - SERVER_USER_HAS_JOINED wywoluje się");
                break;
            case SERVER_USER_JOINED_TOKEN_ALREADY_EXIST:
                String username = (String) param1;
                msg = "Gracz próbował się połączyć, ale jest już połączony";
                masterGuiManager.getNotificationTableManager().addNotification(username, msg,  NotificationTableManager.Type.ERROR);
                System.out.println("OnConnectServerGuiObserver - SERVER_USER_JOINED_TOKEN_ALREADY_EXIST wywoluje się");
                break;
            default:
                throw new UnknowObserableEventException();
        }


    }
}
