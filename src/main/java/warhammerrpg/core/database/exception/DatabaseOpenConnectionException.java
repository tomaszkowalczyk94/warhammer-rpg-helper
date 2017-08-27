package warhammerrpg.core.database.exception;

import warhammerrpg.core.exception.WarhammerRpgException;

public class DatabaseOpenConnectionException extends DatabaseException {
    public DatabaseOpenConnectionException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }
}
