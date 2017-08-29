package warhammerrpg.core.utils;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import warhammerrpg.database.Database;
import warhammerrpg.database.entity.Career;
import warhammerrpg.database.entity.Skill;
import warhammerrpg.database.entity.Talent;
import warhammerrpg.database.exception.DatabaseCreateTablesException;
import warhammerrpg.database.exception.DatabaseOpenConnectionException;

import java.sql.SQLException;
import java.util.List;

public class DatabaseToLowercase {

    public static void main(String[] args) throws DatabaseCreateTablesException, DatabaseOpenConnectionException, SQLException {
        Database database = new Database();

        Dao<Career, Integer> careerDao = DaoManager.createDao(database.getConn(), Career.class);
        Dao<Skill, Integer> skillDao = DaoManager.createDao(database.getConn(), Skill.class);
        Dao<Talent, Integer> talentDao = DaoManager.createDao(database.getConn(), Talent.class);


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

        List<Talent> talents = talentDao.queryForAll();

        for(Talent t : talents) {
            System.out.println("Parsuję talent: "+t.getName());
            String newName = t.getName().trim().toLowerCase();

            System.out.println("zmieniam nazwe na: "+newName);
            t.setName(newName);

            talentDao.update(t);
        }




    }
}
