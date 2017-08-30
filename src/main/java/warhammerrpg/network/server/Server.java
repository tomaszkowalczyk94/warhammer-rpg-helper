package warhammerrpg.network.server;

import warhammerrpg.gui.master.MasterGuiConnector;
import warhammerrpg.gui.master.observer.OnDisconnectGuiObserver;
import warhammerrpg.network.Register;
import warhammerrpg.network.exception.NetworkException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Server {
    com.esotericsoftware.kryonet.Server server;

    private MasterGuiConnector masterGuiConnector;
    private Map<String, ServerUserContainer> users;

    public Server() {
        users = new HashMap<String, ServerUserContainer>();
    }

    public void run(int port) throws NetworkException {
        System.out.println("start running master");

        server = new com.esotericsoftware.kryonet.Server();
        new Register().registerClasses(server.getKryo());


        ServerListener serverListener = new ServerListener(masterGuiConnector, users);
        serverListener.register(new OnDisconnectGuiObserver(masterGuiConnector));
        server.addListener(serverListener);

        server.start();

        try {
            server.bind(port);
        } catch (IOException e) {
            throw new NetworkException(e);
        }
    }

    public void stop() {
        server.stop();
    }

    public MasterGuiConnector getMasterGuiConnector() {
        return masterGuiConnector;
    }

    public void setMasterGuiConnector(MasterGuiConnector masterGuiConnector) {
        this.masterGuiConnector = masterGuiConnector;
    }
}
