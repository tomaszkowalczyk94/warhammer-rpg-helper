package warhammerrpg.gui.master.observer;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.gui.master.MasterGuiManager;
import warhammerrpg.network.server.ServerUserContainer;

import java.util.Map;

public class OnDisconnectGuiObserver extends AbstractMasterGuiObserver implements Observer {


    public OnDisconnectGuiObserver(MasterGuiManager masterGuiManager) {
        super(masterGuiManager);
    }

    @Override
    public void run(Observable.Event e, Object param1, Object param2) throws UnknowObserableEventException {
        switch (e) {
            case SERVER_USER_DISCONNECTED:
                Map<String, ServerUserContainer> users = (Map<String, ServerUserContainer>) param1;
                ServerUserContainer serverUserContainer = (ServerUserContainer) param2;
                masterGuiManager.refreshUsersList(users);
                masterGuiManager.addNotice("Gracz "+serverUserContainer.getUsername()+" rozłączył się ");
                System.out.println("OnDisconnectGuiObserver - SERVER_USER_DISCONNECTED wywoluje się");
                break;
        }
    }
}
