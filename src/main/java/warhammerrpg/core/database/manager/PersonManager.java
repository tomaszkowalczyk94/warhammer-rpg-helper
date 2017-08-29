package warhammerrpg.core.database.manager;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import warhammerrpg.core.database.entity.Person;
import warhammerrpg.core.database.exception.DatabaseRecordAlreadyExistException;
import warhammerrpg.core.database.exception.DatabaseSqlException;

import java.sql.SQLException;
import java.util.List;

public class PersonManager extends AbstractManagero<Person, Integer> {

    public Person getByName(String name) throws DatabaseSqlException {
        QueryBuilder<Person, Integer> queryBuilder = dao.queryBuilder();
        try {
            queryBuilder.where().eq("NAME", name);
            PreparedQuery<Person> preparedQuery = queryBuilder.prepare();
            return (Person) dao.queryForFirst(preparedQuery);
        } catch (SQLException e) {
            throw new DatabaseSqlException(e);
        }
    }

    public void create(Person person) throws DatabaseSqlException, DatabaseRecordAlreadyExistException {
        if(this.getByName(person.getName()) != null) {
            throw new DatabaseRecordAlreadyExistException();
        }

        try {
            dao.create(person);
        } catch (SQLException e) {
            throw new DatabaseSqlException(e);
        }
    }

    public List getAll() throws DatabaseSqlException {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            throw new DatabaseSqlException(e);
        }
    }
}
