package warhammerrpg.network.exception;

import warhammerrpg.core.exception.WarhammerRpgException;

public class NetworkException extends WarhammerRpgException {

    public NetworkException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }

    public NetworkException() {
        super();
    }
}
