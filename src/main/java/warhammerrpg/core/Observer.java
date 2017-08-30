package warhammerrpg.core;

public interface Observer {


    void run(Observable.Event e, Object param1, Object param2);
}
