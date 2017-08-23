package warhammerrpg.network.action;

import warhammerrpg.network.response.ResponseInterface;

public class PingAction implements ActionInterface {

    public ResponseInterface run() {
        System.out.println("PING");
        return null;
    }
}
