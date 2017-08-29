package warhammerrpg.network.client.action;

import warhammerrpg.gui.GuiClientFormConnector;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.pack.Pack;
import warhammerrpg.network.pack.WelcomeReplyPack;

public class WelcomeReplyAction implements ActionInterface{

    Client client;
    GuiClientFormConnector guiClientFormConnector;

    public WelcomeReplyAction(Client client, GuiClientFormConnector guiClientFormConnector) {
        this.client = client;
        this.guiClientFormConnector = guiClientFormConnector;
    }

    @Override
    public Pack run(Pack request) {
        WelcomeReplyPack welcomeReplyPackrequest = (WelcomeReplyPack)request;

        if(welcomeReplyPackrequest.successful) {
            System.out.println("CLIENT: dostałem token: " + welcomeReplyPackrequest.receivedToken);
            client.setToken(welcomeReplyPackrequest.receivedToken);
        } else {
            System.out.println("ERROR: brak tokena");
            guiClientFormConnector.openAlertANdCloseApp("Zostałeś automatycznie wyrzucony z serwera. Może ktoś z takim nickiem jest już połączony?");
        }


        return null;
    }
}
