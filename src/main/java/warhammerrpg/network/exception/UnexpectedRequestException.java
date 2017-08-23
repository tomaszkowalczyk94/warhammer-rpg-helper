package warhammerrpg.network.exception;

public class UnexpectedRequestException extends NetworkException {
    public UnexpectedRequestException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }

    public UnexpectedRequestException() {
        super();
    }
}
