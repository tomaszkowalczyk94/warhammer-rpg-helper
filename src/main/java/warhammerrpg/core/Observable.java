package warhammerrpg.core;

public interface Observable {


    public enum Event {
        SERVER_USER_HAS_JOINED,
        SERVER_USER_JOINED_TOKEN_ALREADY_EXIST,
        SERVER_USER_DISCONNECTED,
        SERVER_USER_DISCONNECTED_ERROR,
        CLIENT_KICKED,
    }

    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers(Observable.Event e, Object param1, Object param2);
}
