package warhammerrpg.core;

public interface Observable {


    public enum Event {
        TOKEN_CREATED,
    }

    void register(Observer o);
    void unregister(Observer o);

    void notifyObservers(Observable.Event e);
    void notifyObservers(Observable.Event e, Object param1);
    void notifyObservers(Observable.Event e, Object param1, Object param2);
}
