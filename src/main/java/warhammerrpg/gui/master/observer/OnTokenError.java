package warhammerrpg.gui.master.observer;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.gui.master.MasterGuiManager;

public class OnTokenError extends AbstractMasterGuiObserver implements Observer {

    public OnTokenError(MasterGuiManager masterGuiManager) {
        super(masterGuiManager);
    }

    @Override
    public void run(Observable.Event e, Object param1, Object param2) throws UnknowObserableEventException {
        switch (e) {
            case SERVER_USER_TOKEN_ERROR:
                String username = (String) param1;
                masterGuiManager.addNotice("Bledny token od gracza: "+username);
                System.out.println("OnDisconnectGuiObserver - SERVER_USER_DISCONNECTED wywoluje się");
                break;
        }
    }
}
