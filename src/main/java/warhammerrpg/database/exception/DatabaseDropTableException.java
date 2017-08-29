package warhammerrpg.database.exception;

public class DatabaseDropTableException extends DatabaseException {
    public DatabaseDropTableException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }
}
