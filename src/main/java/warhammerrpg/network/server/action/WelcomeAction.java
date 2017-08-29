package warhammerrpg.network.server.action;

import warhammerrpg.gui.master.MasterGuiConnector;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.pack.Pack;
import warhammerrpg.network.server.ServerUserContainer;
import warhammerrpg.network.pack.WelcomePack;
import warhammerrpg.network.pack.WelcomeReplyPack;

import java.util.Map;
import java.util.UUID;

/**
 * Tworzy token, inicjuje bardzo uproszczoną sesje
 */
public class WelcomeAction implements ActionInterface {

    Map<String, ServerUserContainer> users;
    MasterGuiConnector masterGuiConnector;

    public WelcomeAction(Map<String, ServerUserContainer> users, MasterGuiConnector masterGuiConnector) {
        this.users = users;
        this.masterGuiConnector = masterGuiConnector;
    }

    @Override
    public Pack run(Pack request) {
        request = (WelcomePack)request;
        String username = request.getUsername();
        System.out.println("username: " + username);


        WelcomeReplyPack welcomeReply = new WelcomeReplyPack();

        if(users.get(username) == null) {
            String token = generateToken();
            System.out.println("SERVER: generated token:" + token);
            welcomeReply.successful = true;
            welcomeReply.receivedToken = token;

            ServerUserContainer serverUserContainer = new ServerUserContainer();
            serverUserContainer.setToken(token);
            serverUserContainer.setUsername(username);
            users.put(username, serverUserContainer);

            masterGuiConnector.refreshUsersList(users);
            masterGuiConnector.addNotice("Gracz "+username+" połączył . Token: " + token);
        } else {
            welcomeReply.successful = false;
            welcomeReply.message = "użytkownik już jest zalogowany";
        }

        return (Pack) welcomeReply;
    }

    private String generateToken() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
