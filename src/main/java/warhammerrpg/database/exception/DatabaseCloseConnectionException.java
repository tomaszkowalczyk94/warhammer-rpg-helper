package warhammerrpg.database.exception;

public class DatabaseCloseConnectionException  extends DatabaseException {
    public DatabaseCloseConnectionException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }
}
