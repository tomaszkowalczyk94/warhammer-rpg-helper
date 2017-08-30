package warhammerrpg.network.client.action;

import com.esotericsoftware.kryonet.Connection;
import warhammerrpg.gui.client.ClientGuiConnector;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.pack.Pack;
import warhammerrpg.network.pack.WelcomeReplyPack;

public class WelcomeReplyAction implements ActionInterface{

    Client client;
    ClientGuiConnector clientGuiConnector;

    public WelcomeReplyAction(Client client, ClientGuiConnector clientGuiConnector) {
        this.client = client;
        this.clientGuiConnector = clientGuiConnector;
    }

    @Override
    public Pack run(Pack request, Connection connection) {
        WelcomeReplyPack welcomeReplyPackrequest = (WelcomeReplyPack)request;

        if(welcomeReplyPackrequest.successful) {
            System.out.println("CLIENT: dostałem token: " + welcomeReplyPackrequest.receivedToken);
            client.setToken(welcomeReplyPackrequest.receivedToken);
        } else {
            System.out.println("ERROR: brak tokena");
            clientGuiConnector.openAlertAndCloseApp("Zostałeś automatycznie wyrzucony z serwera. Może ktoś z takim nickiem jest już połączony?");
        }


        return null;
    }

}
