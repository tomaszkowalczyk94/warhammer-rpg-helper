package warhammerrpg.database.exception;

public class DatabaseRecordAlreadyExistException extends DatabaseException {
    public DatabaseRecordAlreadyExistException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }

    public DatabaseRecordAlreadyExistException() {
        super();
    }
}
