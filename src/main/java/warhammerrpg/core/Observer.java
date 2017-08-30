package warhammerrpg.core;

import warhammerrpg.core.exception.UnknowObserableEventException;

public interface Observer {


    void run(Observable.Event e, Object param1, Object param2) throws UnknowObserableEventException;
}
