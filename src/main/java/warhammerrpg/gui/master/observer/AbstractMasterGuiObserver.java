package warhammerrpg.gui.master.observer;

import warhammerrpg.gui.master.MasterGuiManager;

abstract public class AbstractMasterGuiObserver {

    protected MasterGuiManager masterGuiManager;

    public AbstractMasterGuiObserver(MasterGuiManager masterGuiManager) {
        this.masterGuiManager = masterGuiManager;
    }
}
