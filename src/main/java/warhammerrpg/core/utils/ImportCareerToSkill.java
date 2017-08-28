package warhammerrpg.core.utils;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.opencsv.CSVReader;
import warhammerrpg.core.database.Database;
import warhammerrpg.core.database.entity.Career;
import warhammerrpg.core.database.entity.CareerExit;
import warhammerrpg.core.database.entity.Skill;
import warhammerrpg.core.database.exception.DatabaseCreateTablesException;
import warhammerrpg.core.database.exception.DatabaseOpenConnectionException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * wstawia relacje do tabeli PersonToSkill z pliku csv
 */
public class ImportCareerToSkill {

    private static final int NAME_ROW = 1;
    private static final int SKILLS_ROW = 19;

    public static void main(String[] args) throws DatabaseCreateTablesException, DatabaseOpenConnectionException, SQLException, IOException {
        Database database = new Database();
        Dao<Career, Integer> careerDao = DaoManager.createDao(database.getConn(), Career.class);
        Dao<Skill, Integer> skillDao = DaoManager.createDao(database.getConn(), Skill.class);

        String fileName = "src\\main\\java\\warhammerrpg\\core\\utils\\profesje.csv";
        CSVReader reader = new CSVReader(new FileReader(fileName));

        String[] header = reader.readNext();

        String[] line;
        while ((line = reader.readNext()) != null) {

            String name = line[NAME_ROW].trim().toLowerCase();
            Career career = getCareerByName(name, careerDao);

            System.out.println("start parsing: " + name);
            String skillsString = line[SKILLS_ROW].trim().replace(".", ",");

            String[] skillsArrayString = skillsString.split(",");

            for (String skillString : skillsArrayString) {
                System.out.println(" -> skill: " + skillString);

                Skill skill = getSkillByName(skillString, skillDao);

                if (skill != null) {
                    System.out.println("  odnaleziono skill w bazie, id: "+skill.getId());
                } else {
                    System.out.println("  NIE ODNALEZIONO WPISU!!!");
                }

            }

        }


    }

    static private Career getCareerByName(String name, Dao<Career, Integer> careerDao) throws SQLException {
        QueryBuilder<Career, Integer> queryBuilder = careerDao.queryBuilder();
        queryBuilder.where().eq("NAME", name);
        PreparedQuery<Career> preparedQuery = queryBuilder.prepare();
        return careerDao.queryForFirst(preparedQuery);
    }

    static private Skill getSkillByName(String name, Dao<Skill, Integer>skillsDao) throws SQLException {
        QueryBuilder<Skill, Integer> queryBuilder = skillsDao.queryBuilder();
        queryBuilder.where().eq("NAME", name);
        PreparedQuery<Skill> preparedQuery = queryBuilder.prepare();
        return skillsDao.queryForFirst(preparedQuery);
    }

}
