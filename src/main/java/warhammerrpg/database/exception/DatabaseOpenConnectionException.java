package warhammerrpg.database.exception;

public class DatabaseOpenConnectionException extends DatabaseException {
    public DatabaseOpenConnectionException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }
}
