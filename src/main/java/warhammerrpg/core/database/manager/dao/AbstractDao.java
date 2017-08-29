package warhammerrpg.core.database.manager.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import warhammerrpg.core.database.exception.DatabaseSqlException;

import java.sql.SQLException;

abstract class AbstractDao<T, PK> extends BaseDaoImpl<T, PK>{


    protected AbstractDao(ConnectionSource connectionSource, Class<T> dataClass) throws SQLException {
        super(connectionSource, dataClass);

    }

    public T get(PK pk) throws DatabaseSqlException {
        try {
            return this.queryForId(pk);
        } catch (SQLException e) {
            throw new DatabaseSqlException(e);
        }
    }

}
