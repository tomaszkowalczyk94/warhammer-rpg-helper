package warhammerrpg.database;


import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import warhammerrpg.database.entity.*;
import warhammerrpg.database.exception.*;
import warhammerrpg.database.manager.PersonManager;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Database {

    private final static String DATABASE_URL = "jdbc:h2:~/WarhammerRpgDatabase;AUTO_SERVER=TRUE";
    private final static String DATABASE_USER = "sa";
    private final static String DATABASE_PASSWORD = "jk23hjkx9009s";

    private ConnectionSource conn = null;

    public Database() throws DatabaseOpenConnectionException, DatabaseCreateTablesException {

        try {
            this.conn = new JdbcConnectionSource(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            this.reCreateTables();
        } catch (SQLException e) {
            throw new DatabaseOpenConnectionException(e);
        } catch (DatabaseDropTableException e) {
            e.printStackTrace();
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

            this.conn.getReadWriteConnection("Skill").isTableExists("dsa");

            TableUtils.createTableIfNotExists(this.conn, Skill.class);
            TableUtils.createTableIfNotExists(this.conn, Person.class);
            TableUtils.createTableIfNotExists(this.conn, PersonToSkill.class);
            TableUtils.createTableIfNotExists(this.conn, Weapon.class);
            TableUtils.createTableIfNotExists(this.conn, PersonToWeapon.class);
            TableUtils.createTableIfNotExists(this.conn, Equipment.class);
            TableUtils.createTableIfNotExists(this.conn, Talent.class);
            TableUtils.createTableIfNotExists(this.conn, Career.class);
            TableUtils.createTableIfNotExists(this.conn, CareerExit.class);


            this.insertDatabase();

        } catch (SQLException e) {
            throw new DatabaseCreateTablesException(e);
        }
    }

    private void insertDatabase() throws SQLException {

        ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal<DateFormat>() {
            @Override
            protected DateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
            }
        };
        ;

        System.out.println("START import database: "+dateFormatThreadLocal.get().format(new Date()));
        this.insertSqlFile("sql/talent.sql");
        this.insertSqlFile("sql/skill.sql");
        this.insertSqlFile("sql/career.sql");
        this.insertSqlFile("sql/persons.sql");
        System.out.println("END - import database: "+dateFormatThreadLocal.get().format(new Date()));
    }

    private void insertSqlFile(String filePath) throws SQLException {
        String sql = null;
        try {
            sql = readFileAsString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.conn.getReadWriteConnection(null).executeStatement(sql, -1);
    }

    private String readFileAsString(String filePath) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(filePath));
        try {
            long len = new File(filePath).length();
            if (len > Integer.MAX_VALUE) throw new IOException("File "+filePath+" too large, was "+len+" bytes.");
            byte[] bytes = new byte[(int) len];
            dis.readFully(bytes);
            return new String(bytes, "UTF-8");
        } finally {
            dis.close();
        }
    }

    private void reCreateTables() throws DatabaseCreateTablesException, DatabaseDropTableException {

        try {
            TableUtils.dropTable(this.conn, CareerExit.class, true);
            TableUtils.dropTable(this.conn, Career.class, true);
            TableUtils.dropTable(this.conn, Talent.class, true);
            TableUtils.dropTable(this.conn, Equipment.class, true);
            TableUtils.dropTable(this.conn, PersonToWeapon.class, true);
            TableUtils.dropTable(this.conn, Weapon.class, true);
            TableUtils.dropTable(this.conn, PersonToSkill.class, true);
            TableUtils.dropTable(this.conn, Person.class, true);
            TableUtils.dropTable(this.conn, Skill.class, true);
        } catch (SQLException e) {
            throw new DatabaseDropTableException(e);
        }

        this.createTablesIfNotExists();
    }

    public PersonManager getPersonManager() throws DatabaseCreateManagerException {
        try {
            PersonManager personManager = new PersonManager();
            personManager.setDao((BaseDaoImpl) DaoManager.createDao(this.conn, Person.class));
            return personManager;
        } catch (SQLException e) {
            throw new DatabaseCreateManagerException(e);
        }
    }




}