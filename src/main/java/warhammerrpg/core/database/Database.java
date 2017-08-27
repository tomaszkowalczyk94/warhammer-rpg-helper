package warhammerrpg.core.database;


import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import warhammerrpg.core.exception.DatabaseCloseConnectionException;
import warhammerrpg.core.exception.DatabaseOpenConnectionException;

import java.io.IOException;
import java.sql.SQLException;

public class Database {

    private final static String DATABASE_URL = "jdbc:h2:~/WarhammerRpgDatabase";
    private final static String DATABASE_USER = "root";
    private final static String DATABASE_PASSWORD = "haslo";

    private ConnectionSource conn = null;

    public Database() throws DatabaseOpenConnectionException{

        try {
            this.conn = new JdbcConnectionSource(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new DatabaseOpenConnectionException(e);
        }
    }

    public ConnectionSource getConn() {
        return conn;
    }

    public void closeConnection() throws DatabaseCloseConnectionException {
        try {
            this.conn.close();
        } catch (IOException e) {
            throw new DatabaseCloseConnectionException(e);
        }
    }


}