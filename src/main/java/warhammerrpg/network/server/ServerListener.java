package warhammerrpg.network.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.gui.server.MasterGuiManager;
import warhammerrpg.gui.server.observer.OnConnectServerGuiObserver;
import warhammerrpg.gui.server.observer.OnUserChangeDataServerGuiObserver;
import warhammerrpg.network.pack.ChangeDataEventPack;
import warhammerrpg.network.pack.Pack;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.server.action.PingAction;
import warhammerrpg.network.server.action.UserChangedDataAction;
import warhammerrpg.network.server.action.WelcomeAction;
import warhammerrpg.network.exception.UnexpectedRequestException;
import warhammerrpg.network.pack.PingPack;
import warhammerrpg.network.pack.WelcomePack;

import java.util.ArrayList;
import java.util.Map;

import static warhammerrpg.core.Observable.Event.*;

class ServerListener extends Listener implements Observable {

    private Map<String, ServerUserContainer> users;

    MasterGuiManager masterGuiManager;

    public ServerListener(MasterGuiManager masterGuiManager, Map<String, ServerUserContainer> users) {
        this.masterGuiManager = masterGuiManager;
        this.users = users;
        this.observerList = new ArrayList<>();
    }

    public void received (Connection connection, Object object) {

        if (object instanceof Pack) {
            Pack request = (Pack)object;

            ActionInterface action = null;
            try {
                action = SelectAction(request);
            } catch (UnexpectedRequestException e) {
                e.printStackTrace();
                //@todo put something
            }

            if(action.checkToken()) {
                ServerUserContainer serverUserContainer = users.get(request.getUsername());
                if(!serverUserContainer.getToken().equals(request.getToken())) {
                    System.out.println("Błedny TOKEN");
                    this.notifyObservers(SERVER_USER_TOKEN_ERROR, request.getUsername(), null);
                    return;
                }
            }

            Pack response = action.run(request, connection);

            if(response != null) {
                connection.sendTCP(response);
            }
        }
    }

    public void disconnected (Connection connection) {
        ServerUserContainer serverUserContainer = findServerUserContainerByConnection(connection);

        if(serverUserContainer != null) {
            users.remove(serverUserContainer.getUsername());
            this.notifyObservers(SERVER_USER_DISCONNECTED, users, serverUserContainer);
        }
    }

    private ActionInterface SelectAction(Pack request) throws UnexpectedRequestException {
        if(request instanceof PingPack) {
            return new PingAction();
        } else if((request instanceof WelcomePack)) {
            WelcomeAction welcomeAction = new WelcomeAction(users);
            welcomeAction.addObserver(new OnConnectServerGuiObserver(masterGuiManager));
            return welcomeAction;
        } else if(request instanceof ChangeDataEventPack) {
            UserChangedDataAction userChangedDataAction = new UserChangedDataAction();
            userChangedDataAction.addObserver(new OnUserChangeDataServerGuiObserver(masterGuiManager));
            return userChangedDataAction;
        }
        throw new UnexpectedRequestException();
    }

    private ServerUserContainer findServerUserContainerByConnection(Connection connection) {
        for(Map.Entry<String, ServerUserContainer> entry : users.entrySet()) {
            if(entry.getValue().getConnection().getID() == connection.getID()) {
                return entry.getValue();
            }
        }
        return null;
    }


    protected ArrayList<Observer> observerList;

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers(Observable.Event event, Object param1, Object param2) {
        for (Observer o : observerList){
            try {
                o.run(event, param1, param2);
            } catch (UnknowObserableEventException e) {
                e.printStackTrace(); // @todo cos z tym zrobic
            }
        }
    }
}
