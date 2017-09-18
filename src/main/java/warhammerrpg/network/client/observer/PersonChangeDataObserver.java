package warhammerrpg.network.client.observer;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.gui.client.observer.ClientSetPersonDataEventContainer;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.pack.ChangeDataEventPack;

public class PersonChangeDataObserver implements Observer {

    Client client;
    private ChangeDataEventPack changeDataEventPack;

    public PersonChangeDataObserver(Client client) {
        this.client = client;
    }

    @Override
    public void run(Observable.Event e, Object param1, Object param2) throws UnknowObserableEventException {

        ClientSetPersonDataEventContainer clientSetPersonDataEventContainer = (ClientSetPersonDataEventContainer) param1;

        ChangeDataEventPack changeDataEventPack = new ChangeDataEventPack();
        changeDataEventPack.oldValue = clientSetPersonDataEventContainer.oldValue;
        changeDataEventPack.newValue = clientSetPersonDataEventContainer.newValue;
        changeDataEventPack.updatedField = clientSetPersonDataEventContainer.field;

        client.sendRequest(changeDataEventPack);
    }
}
