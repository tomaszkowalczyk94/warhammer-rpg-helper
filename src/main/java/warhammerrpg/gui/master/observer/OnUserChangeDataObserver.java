package warhammerrpg.gui.master.observer;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.database.entity.Person;
import warhammerrpg.gui.master.MasterGuiManager;
import warhammerrpg.network.pack.ChangeDataEventPack;

public class OnUserChangeDataObserver extends AbstractMasterGuiObserver  implements Observer {

    public OnUserChangeDataObserver(MasterGuiManager masterGuiManager) {
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

                System.out.println("OnUserChangeDataObserver - wywoluje się");
                masterGuiManager.addNotice("Gracz: "+username+" zmienił '"+nameUpdatedField+"' wartość z '"+changeDataEventPack.oldValue+"' na '"+changeDataEventPack.newValue+"'" );
                break;
        }

    }
}
