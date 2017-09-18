package warhammerrpg.gui.client.observer;

import warhammerrpg.gui.client.ClientGuiManager;

public class AbstractClientGuiObserver {

    protected ClientGuiManager clientGuiManager;

    public AbstractClientGuiObserver(ClientGuiManager clientGuiManager) {
        this.clientGuiManager = clientGuiManager;
    }
}
