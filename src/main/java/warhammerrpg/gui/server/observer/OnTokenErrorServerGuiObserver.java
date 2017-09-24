package warhammerrpg.gui.server.observer;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.gui.server.MasterGuiManager;
import warhammerrpg.gui.server.gameNotificationTable.NotificationTableManager;

public class OnTokenErrorServerGuiObserver extends AbstractServerGuiObserver implements Observer {

    public OnTokenErrorServerGuiObserver(MasterGuiManager masterGuiManager) {
        super(masterGuiManager);
    }

    @Override
    public void run(Observable.Event e, Object param1, Object param2) throws UnknowObserableEventException {
        switch (e) {
            case SERVER_USER_TOKEN_ERROR:
                String username = (String) param1;
                masterGuiManager.getNotificationTableManager().addNotification(username, "Bledny token od gracza",  NotificationTableManager.Type.ERROR);
                System.out.println("OnUserDisconnectServerGuiObserver - SERVER_USER_DISCONNECTED wywoluje się");
                break;
        }
    }
}
