package warhammerrpg.core;

public interface Observable {


    public enum Event {
        SERVER_USER_HAS_JOINED,
        SERVER_USER_JOINED_TOKEN_ALREADY_EXIST,
    }

    void register(Observer o);
    void unregister(Observer o);

    void notifyObservers(Observable.Event e);
    void notifyObservers(Observable.Event e, Object param1);
    void notifyObservers(Observable.Event e, Object param1, Object param2);
}
