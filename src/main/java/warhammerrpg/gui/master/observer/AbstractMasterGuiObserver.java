package warhammerrpg.gui.master.observer;

import warhammerrpg.gui.master.MasterGuiConnector;

abstract public class AbstractMasterGuiObserver {

    protected MasterGuiConnector masterGuiConnector;

    public AbstractMasterGuiObserver(MasterGuiConnector masterGuiConnector) {
        this.masterGuiConnector = masterGuiConnector;
    }
}
