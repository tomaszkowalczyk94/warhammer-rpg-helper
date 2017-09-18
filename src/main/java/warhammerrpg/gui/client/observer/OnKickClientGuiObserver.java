package warhammerrpg.gui.client.observer;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.gui.client.ClientGuiManager;

public class OnKickClientGuiObserver extends AbstractClientGuiObserver implements Observer {

    public OnKickClientGuiObserver(ClientGuiManager clientGuiManager) {
        super(clientGuiManager);
    }

    @Override
    public void run(Observable.Event e, Object param1, Object param2) throws UnknowObserableEventException {
        String message = (String) param1;
        clientGuiManager.openAlertAndCloseApp("Zostałeś wyrzucony z powodu:"+message);

    }
}
