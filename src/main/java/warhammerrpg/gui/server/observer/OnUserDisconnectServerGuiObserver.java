package warhammerrpg.gui.server.observer;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.gui.server.MasterGuiManager;
import warhammerrpg.gui.server.gameNotificationTable.NotificationTableManager;
import warhammerrpg.network.server.ServerUserContainer;

import java.util.Map;

public class OnUserDisconnectServerGuiObserver extends AbstractServerGuiObserver implements Observer {


    public OnUserDisconnectServerGuiObserver(MasterGuiManager masterGuiManager) {
        super(masterGuiManager);
    }

    @Override
    public void run(Observable.Event e, Object param1, Object param2) throws UnknowObserableEventException {
        switch (e) {
            case SERVER_USER_DISCONNECTED:
                Map<String, ServerUserContainer> users = (Map<String, ServerUserContainer>) param1;
                ServerUserContainer serverUserContainer = (ServerUserContainer) param2;
                masterGuiManager.refreshUsersList(users);

                masterGuiManager.getNotificationTableManager().addNotification(
                        serverUserContainer.getUsername(), "Gracz rozłączył się", NotificationTableManager.Type.ERROR
                );

                System.out.println("OnUserDisconnectServerGuiObserver - SERVER_USER_DISCONNECTED wywoluje się");
                break;
        }
    }
}
