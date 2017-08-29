package warhammerrpg.database.manager;

import com.j256.ormlite.dao.BaseDaoImpl;

abstract class AbstractManagero<T, PK>  {
    protected BaseDaoImpl dao;

    public BaseDaoImpl getDao() {
        return dao;
    }

    public void setDao(BaseDaoImpl dao) {
        this.dao = dao;
    }

}
