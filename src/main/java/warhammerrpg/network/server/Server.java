package warhammerrpg.network.server;

import warhammerrpg.gui.master.MasterGuiConnector;
import warhammerrpg.gui.master.observer.OnDisconnectGuiObserver;
import warhammerrpg.gui.master.observer.OnTokenError;
import warhammerrpg.network.Register;
import warhammerrpg.network.exception.NetworkException;
import warhammerrpg.network.pack.KickPack;

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
        serverListener.register(new OnTokenError(masterGuiConnector));
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

    public void kickUser(String username, String message) {
        if(users.get(username) != null) {
            KickPack kickPack = new KickPack();
            kickPack.message = message;
            users.get(username).getConnection().sendTCP(kickPack);
            users.remove(username);
        } else {
            //@todo cos zrobic z tym
        }

    }

    public MasterGuiConnector getMasterGuiConnector() {
        return masterGuiConnector;
    }

    public void setMasterGuiConnector(MasterGuiConnector masterGuiConnector) {
        this.masterGuiConnector = masterGuiConnector;
    }
}
