package warhammerrpg.core.exception;

public class DatabaseCloseConnectionException  extends WarhammerRpgException {
    public DatabaseCloseConnectionException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }
}
