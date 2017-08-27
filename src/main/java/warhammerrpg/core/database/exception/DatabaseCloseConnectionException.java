package warhammerrpg.core.database.exception;

import warhammerrpg.core.exception.WarhammerRpgException;

public class DatabaseCloseConnectionException  extends DatabaseException {
    public DatabaseCloseConnectionException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }
}
