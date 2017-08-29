package warhammerrpg.network.client.action;

import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.pack.Pack;
import warhammerrpg.network.pack.WelcomeReplyPack;

public class WelcomeReplyAction implements ActionInterface{

    Client client;

    public WelcomeReplyAction(Client client) {
        this.client = client;
    }

    @Override
    public Pack run(Pack request) {
        WelcomeReplyPack welcomeReplyPackrequest = (WelcomeReplyPack)request;

        System.out.println("CLIENT: dostałem token: "+welcomeReplyPackrequest.receivedToken);
        client.setToken(welcomeReplyPackrequest.receivedToken);
        return null;
    }
}
