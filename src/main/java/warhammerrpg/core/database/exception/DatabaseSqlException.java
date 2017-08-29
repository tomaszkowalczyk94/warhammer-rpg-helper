package warhammerrpg.core.database.exception;

public class DatabaseSqlException  extends DatabaseException {
    public DatabaseSqlException(Exception originalExceptionObject) {
        super(originalExceptionObject);
    }
}
