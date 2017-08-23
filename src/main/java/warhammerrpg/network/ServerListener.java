package warhammerrpg.network;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import warhammerrpg.network.action.ActionInterface;
import warhammerrpg.network.action.PingAction;
import warhammerrpg.network.exception.UnexpectedRequestException;
import warhammerrpg.network.request.PingRequest;
import warhammerrpg.network.request.RequestInterface;
import warhammerrpg.network.response.ResponseInterface;

class ServerListener extends Listener {

    public void received (Connection connection, Object object) {
        if (object instanceof RequestInterface) {
            RequestInterface request = (RequestInterface)object;

            ActionInterface action = null;
            try {
                action = SelectAction(request);
            } catch (UnexpectedRequestException e) {
                e.printStackTrace();
                //@todo put something
            }

            ResponseInterface response = action.run();

            if(response != null) {
                connection.sendTCP(response);
            }

        }
    }

    private ActionInterface SelectAction(RequestInterface request) throws UnexpectedRequestException {
        if(request instanceof PingRequest) {
            return new PingAction();
        }
        throw new UnexpectedRequestException();
    }
}
