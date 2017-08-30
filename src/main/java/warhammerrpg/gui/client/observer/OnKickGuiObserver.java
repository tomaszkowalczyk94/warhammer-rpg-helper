package warhammerrpg.gui.client.observer;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.gui.client.ClientGuiConnector;
import warhammerrpg.gui.master.observer.AbstractMasterGuiObserver;

public class OnKickGuiObserver  extends AbstractClientGuiObserver implements Observer {

    public OnKickGuiObserver(ClientGuiConnector clientGuiConnector) {
        super(clientGuiConnector);
    }

    @Override
    public void run(Observable.Event e, Object param1, Object param2) throws UnknowObserableEventException {
        String message = (String) param1;
        clientGuiConnector.openAlertAndCloseApp("Zostałeś wyrzucony z powodu:"+message);

    }
}
