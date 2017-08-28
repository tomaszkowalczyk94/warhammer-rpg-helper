package warhammerrpg.core.utils;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.opencsv.CSVReader;
import warhammerrpg.core.database.Database;
import warhammerrpg.core.database.entity.Career;
import warhammerrpg.core.database.exception.DatabaseCreateTablesException;
import warhammerrpg.core.database.exception.DatabaseOpenConnectionException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
*importuje dane z  pliku csv
*/
public class ImportSkillsAndTalents {

    private static final int SKILL_ROW = 19;
    private static final int TALENT_ROW = 20;
    private static final int NAME_ROW = 1;

    public static void main(String[] args) throws SQLException, DatabaseCreateTablesException, DatabaseOpenConnectionException, IOException {
        Database database = new Database();
        Dao<Career, Integer> careerDao = DaoManager.createDao(database.getConn(), Career.class);


        String fileName = "src\\main\\java\\warhammerrpg\\core\\utils\\profesje.csv";
        CSVReader reader = new CSVReader(new FileReader(fileName ));

        String[] header = reader.readNext();

        String[] line;
        while((line = reader.readNext()) != null) {
            String name = line[NAME_ROW].trim().toLowerCase();
            Career career = getCareerByName(name, careerDao);
            System.out.println("start parsing: "+ name);


            String skillsString = line[SKILL_ROW].trim();
            String talentsString = line[TALENT_ROW].trim();

            career.setAvaibleSkills(skillsString);
            career.setAvaibleTalents(talentsString);

            System.out.println("aktualizuje skills and talents");
            careerDao.update(career);
        }



    }

    static private Career getCareerByName(String name, Dao<Career, Integer> careerDao) throws SQLException {
        QueryBuilder<Career, Integer> queryBuilder = careerDao.queryBuilder();
        queryBuilder.where().eq("NAME", name);
        PreparedQuery<Career> preparedQuery = queryBuilder.prepare();
        return careerDao.queryForFirst(preparedQuery);
    }

}
