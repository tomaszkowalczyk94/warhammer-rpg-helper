package warhammerrpg.network.server.action;

import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.pack.Pack;

public class PingAction implements ActionInterface {

    public Pack run(Pack request) {
        System.out.println("PING");
        return null;
    }
}
