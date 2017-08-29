package warhammerrpg.database.manager.dao;

import com.j256.ormlite.support.ConnectionSource;
import warhammerrpg.database.entity.Person;

import java.sql.SQLException;

public class PersonDao extends AbstractDao<Person, Integer> {

    public PersonDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Person.class);
    }



}
