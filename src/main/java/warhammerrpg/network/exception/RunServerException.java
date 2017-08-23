package warhammerrpg.network.exception;

public class RunServerException extends NetworkException {

    public RunServerException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }

    public RunServerException() {
        super();
    }
}
