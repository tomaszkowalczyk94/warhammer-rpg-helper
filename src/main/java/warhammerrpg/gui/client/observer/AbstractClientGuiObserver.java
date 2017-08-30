package warhammerrpg.gui.client.observer;

import warhammerrpg.gui.client.ClientGuiConnector;
import warhammerrpg.gui.master.MasterGuiConnector;

public class AbstractClientGuiObserver {

    protected ClientGuiConnector clientGuiConnector;

    public AbstractClientGuiObserver(ClientGuiConnector clientGuiConnector) {
        this.clientGuiConnector = clientGuiConnector;
    }
}
