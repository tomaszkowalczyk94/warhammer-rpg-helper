package warhammerrpg.gui.server.observer;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.database.entity.Person;
import warhammerrpg.gui.server.MasterGuiManager;
import warhammerrpg.network.pack.ChangeDataEventPack;

public class OnUserChangeDataServerGuiObserver extends AbstractServerGuiObserver implements Observer {

    public OnUserChangeDataServerGuiObserver(MasterGuiManager masterGuiManager) {
        super(masterGuiManager);
    }

    @Override
    public void run(Observable.Event e, Object param1, Object param2) throws UnknowObserableEventException {

        switch (e) {
            case SERVER_USER_CHANGED_DATA:
                String username = (String) param1;
                ChangeDataEventPack changeDataEventPack = (ChangeDataEventPack) param2;

                Person person = new Person();

                String nameUpdatedField = person.getNameField(changeDataEventPack.updatedField);

                System.out.println("OnUserChangeDataServerGuiObserver - wywoluje się");
                masterGuiManager.addNotice("Gracz: "+username+" zmienił '"+nameUpdatedField+"' wartość z '"+changeDataEventPack.oldValue+"' na '"+changeDataEventPack.newValue+"'" );
                break;
        }

    }
}
