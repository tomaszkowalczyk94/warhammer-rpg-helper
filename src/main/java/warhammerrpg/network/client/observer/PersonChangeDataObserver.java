package warhammerrpg.network.client.observer;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.pack.ChangeDataEventPack;

public class PersonChangeDataObserver implements Observer {

    Client client;

    public PersonChangeDataObserver(Client client) {
        this.client = client;
    }

    @Override
    public void run(Observable.Event e, Object param1, Object param2) throws UnknowObserableEventException {

        ChangeDataEventPack changeDataEventPack = new ChangeDataEventPack();
        changeDataEventPack.oldValue = (String) param1;
        changeDataEventPack.newValue = (String) param2;
        client.sendRequest(changeDataEventPack);
    }
}
