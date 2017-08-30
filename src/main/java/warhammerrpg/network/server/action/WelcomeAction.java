package warhammerrpg.network.server.action;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.gui.master.MasterGuiConnector;
import warhammerrpg.gui.master.observer.OnConnectGuiObserver;
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
public class WelcomeAction extends AbstractAction implements ActionInterface, Observable {



    Map<String, ServerUserContainer> users;

    public WelcomeAction(Map<String, ServerUserContainer> users) {
        super();
        this.users = users;
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

            this.notifyObservers(Observable.Event.TOKEN_CREATED, users, serverUserContainer);
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
