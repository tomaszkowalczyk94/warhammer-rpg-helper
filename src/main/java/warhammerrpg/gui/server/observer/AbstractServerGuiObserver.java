package warhammerrpg.gui.server.observer;

import warhammerrpg.gui.server.MasterGuiManager;

abstract public class AbstractServerGuiObserver {

    protected MasterGuiManager masterGuiManager;

    public AbstractServerGuiObserver(MasterGuiManager masterGuiManager) {
        this.masterGuiManager = masterGuiManager;
    }
}
