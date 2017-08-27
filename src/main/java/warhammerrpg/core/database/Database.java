package warhammerrpg.core.database;


import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import warhammerrpg.core.database.exception.DatabaseCreateTablesException;
import warhammerrpg.core.database.exception.DatabaseDropTableException;
import warhammerrpg.core.database.entity.Person;
import warhammerrpg.core.database.entity.PersonToSkill;
import warhammerrpg.core.database.entity.Skill;
import warhammerrpg.core.database.exception.DatabaseCloseConnectionException;
import warhammerrpg.core.database.exception.DatabaseOpenConnectionException;

import java.io.IOException;
import java.sql.SQLException;

public class Database {

    private final static String DATABASE_URL = "jdbc:h2:~/WarhammerRpgDatabase";
    private final static String DATABASE_USER = "root";
    private final static String DATABASE_PASSWORD = "haslo";

    private ConnectionSource conn = null;

    public Database() throws DatabaseOpenConnectionException, DatabaseCreateTablesException {

        try {
            this.conn = new JdbcConnectionSource(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            this.createTablesIfNotExists();
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

    private void createTablesIfNotExists() throws DatabaseCreateTablesException {
        try {
            TableUtils.createTableIfNotExists(this.conn, Skill.class);
            TableUtils.createTableIfNotExists(this.conn, Person.class);
            TableUtils.createTableIfNotExists(this.conn, PersonToSkill.class);
        } catch (SQLException e) {
            throw new DatabaseCreateTablesException(e);
        }
    }

    private void reCreateTables() throws DatabaseCreateTablesException, DatabaseDropTableException {

        try {
            TableUtils.dropTable(this.conn, PersonToSkill.class, true);
            TableUtils.dropTable(this.conn, Person.class, true);
            TableUtils.dropTable(this.conn, Skill.class, true);
        } catch (SQLException e) {
            throw new DatabaseDropTableException(e);
        }

        this.createTablesIfNotExists();
    }


}