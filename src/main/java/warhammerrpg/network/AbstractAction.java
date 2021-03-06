package warhammerrpg.network;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;

import java.util.ArrayList;

public abstract class AbstractAction implements Observable {

    public boolean checkToken() {
        return true;
    }

    protected ArrayList<Observer> observerList;

    protected AbstractAction() {
        observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }


    public void notifyObservers(Observable.Event event) {
        this.notifyObservers(event, null, null);
    }

    public void notifyObservers(Observable.Event event, Object param1) {
        this.notifyObservers(event, param1, null);
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
