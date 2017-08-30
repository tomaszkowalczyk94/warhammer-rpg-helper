package warhammerrpg.database.manager;

import com.j256.ormlite.dao.BaseDaoImpl;
import warhammerrpg.database.entity.Person;
import warhammerrpg.database.exception.DatabaseSqlException;

import java.sql.SQLException;

abstract class AbstractManager<T, PK>  {
    protected BaseDaoImpl dao;

    public BaseDaoImpl getDao() {
        return dao;
    }

    public void setDao(BaseDaoImpl dao) {
        this.dao = dao;
    }

    public void update(T t) throws DatabaseSqlException {
        try {
            dao.update(t);
        } catch (SQLException e) {
            throw new DatabaseSqlException(e);
        }
    }

    public T getById(PK pk) throws DatabaseSqlException {
        try {
            return (T) dao.queryForId(pk);
        } catch (SQLException e) {
            throw new DatabaseSqlException(e);
        }
    }

}
