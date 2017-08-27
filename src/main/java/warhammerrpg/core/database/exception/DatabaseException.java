package warhammerrpg.core.database.exception;

import warhammerrpg.core.exception.WarhammerRpgException;

public class DatabaseException extends WarhammerRpgException {
    public DatabaseException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }
}
