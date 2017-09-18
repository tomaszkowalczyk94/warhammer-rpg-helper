package warhammerrpg.network.client.action;

import com.esotericsoftware.kryonet.Connection;
import warhammerrpg.gui.client.ClientGuiManager;
import warhammerrpg.network.AbstractAction;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.pack.Pack;
import warhammerrpg.network.pack.WelcomeReplyPack;

public class WelcomeReplyAction extends AbstractAction implements ActionInterface{

    Client client;
    ClientGuiManager clientGuiManager;

    public WelcomeReplyAction(Client client, ClientGuiManager clientGuiManager) {
        this.client = client;
        this.clientGuiManager = clientGuiManager;
    }

    @Override
    public Pack run(Pack request, Connection connection) {
        WelcomeReplyPack welcomeReplyPackrequest = (WelcomeReplyPack)request;

        if(welcomeReplyPackrequest.successful) {
            System.out.println("CLIENT: dostałem token: " + welcomeReplyPackrequest.receivedToken);
            client.setToken(welcomeReplyPackrequest.receivedToken);
        } else {
            System.out.println("ERROR: brak tokena");
            clientGuiManager.openAlertAndCloseApp("Zostałeś automatycznie wyrzucony z serwera. Może ktoś z takim nickiem jest już połączony?");
        }


        return null;
    }

}
