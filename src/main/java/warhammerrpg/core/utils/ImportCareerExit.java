package warhammerrpg.core.utils;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.opencsv.CSVReader;
import warhammerrpg.database.Database;
import warhammerrpg.database.entity.Career;
import warhammerrpg.database.entity.CareerExit;

import java.io.FileReader;
import java.sql.SQLException;

/**
 * wstawia relacje do tabeli CareerExit z pliku csv
 */
public class ImportCareerExit {

    private static final int CAREER_EXIT_ROW = 23;
    private static final int NAME_ROW = 1;

    public static void main(String[] args) throws Exception {

        Database database = new Database();
        Dao<Career, Integer> careerDao = DaoManager.createDao(database.getConn(), Career.class);
        Dao<CareerExit, Integer> careerExitDao = DaoManager.createDao(database.getConn(), CareerExit.class);

        String fileName = "src\\main\\java\\warhammerrpg\\core\\utils\\profesje.csv";
        CSVReader reader = new CSVReader(new FileReader(fileName ));

        String[] header = reader.readNext();

        String[] line;
        while((line = reader.readNext()) != null) {

            String name = line[NAME_ROW].trim().toLowerCase();
            Career career = getCareerByName(name, careerDao);

            System.out.println("start parsing: "+ name);
            String careersExitString = line[CAREER_EXIT_ROW].trim().replace(".",",");

            String[] careersExitArrayString = careersExitString.split(",");

            for (String careerExitString: careersExitArrayString) {
                careerExitString = careerExitString.trim();
                System.out.println(" -> profesja wyjsciowa: "+careerExitString);

                Career careerExit = getCareerByName(careerExitString, careerDao);

                if(careerExit != null) {
                    System.out.println("  odnaleziono profesje w bazie, id: "+careerExit.getId());
                    CareerExit careerExitEntity = new CareerExit();
                    careerExitEntity.setCareer(career);
                    careerExitEntity.setCareerExit(careerExit);

                    careerExitDao.create(careerExitEntity);
                    System.out.println("    zapisany profesje wyjsciowa pod id: "+careerExitEntity.getId());

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
}
