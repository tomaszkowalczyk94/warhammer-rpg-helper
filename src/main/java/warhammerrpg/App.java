package warhammerrpg;

import warhammerrpg.database.Database;
import warhammerrpg.database.exception.DatabaseCloseConnectionException;
import warhammerrpg.database.exception.DatabaseCreateTablesException;
import warhammerrpg.database.exception.DatabaseOpenConnectionException;

import java.sql.SQLException;

/**
 * Hello world!
 * @todo usunać
 */
public class App 
{
    public static void main( String[] args ) throws DatabaseOpenConnectionException, DatabaseCloseConnectionException, DatabaseCreateTablesException, SQLException {


        //try {
        //    Database database = new Database();
        //    database.closeConnection();
        //    System.out.println( "Hello World!" );
        //} catch (WarhammerRpgException e) {
        //    e.getOriginalExceptionObject().printStackTrace();
        //}
    }
}
