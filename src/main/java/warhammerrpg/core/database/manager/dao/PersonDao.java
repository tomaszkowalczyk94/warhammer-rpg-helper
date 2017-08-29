package warhammerrpg.core.database.manager.dao;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import warhammerrpg.core.database.entity.Person;
import warhammerrpg.core.database.exception.DatabaseRecordAlreadyExistException;
import warhammerrpg.core.database.exception.DatabaseSqlException;
import warhammerrpg.core.database.manager.PersonManager;

import java.sql.SQLException;

public class PersonDao extends AbstractDao<Person, Integer> {

    public PersonDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Person.class);
    }



}
