package warhammerrpg.core.utils;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import warhammerrpg.core.database.Database;
import warhammerrpg.core.database.entity.Career;
import warhammerrpg.core.database.entity.Skill;
import warhammerrpg.core.database.exception.DatabaseCreateTablesException;
import warhammerrpg.core.database.exception.DatabaseOpenConnectionException;

import java.sql.SQLException;
import java.util.List;

public class DatabaseToLowercase {

    public static void main(String[] args) throws DatabaseCreateTablesException, DatabaseOpenConnectionException, SQLException {
        Database database = new Database();

        Dao<Career, Integer> careerDao = DaoManager.createDao(database.getConn(), Career.class);
        Dao<Skill, Integer> skillDao = DaoManager.createDao(database.getConn(), Skill.class);

        List<Career> careers = careerDao.queryForAll();

        for(Career c: careers) {
            System.out.println("Parsuję career: "+c.getName());
            String newName = c.getName().trim().toLowerCase();

            System.out.println("zmieniam nazwe na: "+newName);
            c.setName(newName);

            String newDescription = c.getDescription().trim().replace("\n", "").replace("\r", "");
            System.out.println("usuwam entery z opisu");
            c.setDescription(newDescription);

            careerDao.update(c);
        }

        List<Skill> skills = skillDao.queryForAll();

        for(Skill s : skills) {
            System.out.println("Parsuję skill: "+s.getName());
            String newName = s.getName().trim().toLowerCase();

            System.out.println("zmieniam nazwe na: "+newName);
            s.setName(newName);

            skillDao.update(s);
        }




    }
}
