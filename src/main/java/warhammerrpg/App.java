package warhammerrpg;

import warhammerrpg.core.database.Database;
import warhammerrpg.core.database.exception.DatabaseCloseConnectionException;
import warhammerrpg.core.database.exception.DatabaseCreateTablesException;
import warhammerrpg.core.database.exception.DatabaseOpenConnectionException;
import warhammerrpg.core.exception.WarhammerRpgException;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DatabaseOpenConnectionException, DatabaseCloseConnectionException, DatabaseCreateTablesException, SQLException {


        //try {
            Database database = new Database();
            database.closeConnection();
            System.out.println( "Hello World!" );
        //} catch (WarhammerRpgException e) {
        //    e.getOriginalExceptionObject().printStackTrace();
        //}
    }
}
