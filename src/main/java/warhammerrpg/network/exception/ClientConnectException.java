package warhammerrpg.network.exception;

import warhammerrpg.core.exception.WarhammerRpgException;

public class ClientConnectException extends WarhammerRpgException {

    public ClientConnectException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }

    public ClientConnectException() {
        super();
    }
}
