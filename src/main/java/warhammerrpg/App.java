package warhammerrpg;

import warhammerrpg.core.database.Database;
import warhammerrpg.core.exception.DatabaseCloseConnectionException;
import warhammerrpg.core.exception.DatabaseOpenConnectionException;
import warhammerrpg.network.exception.NetworkException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DatabaseOpenConnectionException, DatabaseCloseConnectionException {

        Database database = new Database();
        database.closeConnection();

        System.out.println( "Hello World!" );
    }
}
