package warhammerrpg.gui.master.observer;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.gui.master.MasterGuiConnector;
import warhammerrpg.network.server.ServerUserContainer;

import java.util.Map;

public class OnConnectGuiObserver  implements Observer {

    MasterGuiConnector masterGuiConnector;

    public OnConnectGuiObserver(MasterGuiConnector masterGuiConnector) {
        this.masterGuiConnector = masterGuiConnector;
    }

    @Override
    public void run(Observable.Event e, Object param1, Object param2) {

        Map<String, ServerUserContainer> users = (Map<String, ServerUserContainer>) param1;
        ServerUserContainer serverUserContainer = (ServerUserContainer) param2;
        masterGuiConnector.refreshUsersList(users);
        masterGuiConnector.addNotice("Gracz "+serverUserContainer.getUsername()+" połączył . Token: " + serverUserContainer.getToken());

        System.out.println("OnConnectGuiObserver - wywoluje się");
    }
}
