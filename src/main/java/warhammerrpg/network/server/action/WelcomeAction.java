package warhammerrpg.network.server.action;

import com.esotericsoftware.kryonet.Connection;
import warhammerrpg.core.Observable;
import warhammerrpg.network.AbstractAction;
import warhammerrpg.network.ActionInterface;
import warhammerrpg.network.pack.Pack;
import warhammerrpg.network.server.ServerUserContainer;
import warhammerrpg.network.pack.WelcomePack;
import warhammerrpg.network.pack.WelcomeReplyPack;

import java.util.Map;
import java.util.UUID;

import static warhammerrpg.core.Observable.Event.SERVER_USER_HAS_JOINED;
import static warhammerrpg.core.Observable.Event.SERVER_USER_JOINED_TOKEN_ALREADY_EXIST;

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
    public Pack run(Pack request, Connection connection) {
        request = (WelcomePack)request;
        String username = request.getUsername();
        System.out.println("username: " + username + "conn id: "+connection.getID()+"conn name"+ connection.getRemoteAddressTCP().toString());

        WelcomeReplyPack welcomeReply = new WelcomeReplyPack();

        if(users.get(username) == null) {
            String token = generateToken();
            System.out.println("SERVER: generated token:" + token);
            welcomeReply.successful = true;
            welcomeReply.receivedToken = token;

            ServerUserContainer serverUserContainer = new ServerUserContainer();
            serverUserContainer.setToken(token);
            serverUserContainer.setUsername(username);
            serverUserContainer.setConnection(connection);
            users.put(username, serverUserContainer);

            this.notifyObservers(SERVER_USER_HAS_JOINED, users, serverUserContainer);
        } else {
            this.notifyObservers(SERVER_USER_JOINED_TOKEN_ALREADY_EXIST, username);
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
