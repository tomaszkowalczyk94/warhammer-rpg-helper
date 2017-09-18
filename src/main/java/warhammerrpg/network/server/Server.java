package warhammerrpg.network.server;

import warhammerrpg.gui.server.MasterGuiManager;
import warhammerrpg.gui.server.observer.OnTokenErrorServerGuiObserver;
import warhammerrpg.gui.server.observer.OnUserDisconnectServerGuiObserver;
import warhammerrpg.network.Register;
import warhammerrpg.network.exception.NetworkException;
import warhammerrpg.network.pack.KickPack;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Server {
    com.esotericsoftware.kryonet.Server server;

    private MasterGuiManager masterGuiManager;
    private Map<String, ServerUserContainer> users;

    public Server() {
        users = new HashMap<String, ServerUserContainer>();
    }

    public void run(int port) throws NetworkException {
        System.out.println("start running server");

        server = new com.esotericsoftware.kryonet.Server();
        new Register().registerClasses(server.getKryo());

        ServerListener serverListener = new ServerListener(masterGuiManager, users);
        serverListener.addObserver(new OnUserDisconnectServerGuiObserver(masterGuiManager));
        serverListener.addObserver(new OnTokenErrorServerGuiObserver(masterGuiManager));
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
        this.kickUser(username, message, false);
    }

    public void kickUser(String username, String message, boolean test) {
        if(users.get(username) != null) {
            KickPack kickPack = new KickPack();
            kickPack.message = message;

            if(!test) {
                users.get(username).getConnection().sendTCP(kickPack);
            }

            users.remove(username);
        } else {
            //@todo cos zrobic z tym
        }
    }

    public Map<String, ServerUserContainer> getUsers() {
        return users;
    }

    public MasterGuiManager getMasterGuiManager() {
        return masterGuiManager;
    }

    public void setMasterGuiManager(MasterGuiManager masterGuiManager) {
        this.masterGuiManager = masterGuiManager;
    }


}
