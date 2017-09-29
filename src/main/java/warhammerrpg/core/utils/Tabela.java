//jeszcze do dopracowania :P
package warhammerrpg.core.utils;
import com.j256.ormlite.dao.ForeignCollection;
import warhammerrpg.database.Database;
import warhammerrpg.database.entity.Career;
import warhammerrpg.database.entity.CareerExit;
import warhammerrpg.database.exception.DatabaseCreateManagerException;
import warhammerrpg.database.exception.DatabaseCreateTablesException;
import warhammerrpg.database.exception.DatabaseOpenConnectionException;
import warhammerrpg.database.exception.DatabaseSqlException;
import warhammerrpg.database.manager.CareerManager;

import java.util.List;

import javax.swing.*;

public class Tabela {
    
    Tabela() throws DatabaseCreateManagerException, DatabaseCreateTablesException, DatabaseOpenConnectionException, DatabaseSqlException {

        JFrame jfrm = new JFrame("Profesje");
        jfrm.setSize(800, 900);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Database database = new Database();
        CareerManager careerManager = database.getCareerManager();

        List<Career> all = careerManager.getAll();

       Integer[] id = new Integer[112];
       String[] name = new String[112];
       String[] description = new String[112];
       Integer[] weaponSkill = new Integer[112];
       Integer[] ballisticSkill = new Integer[112];
       Integer[] strength = new Integer[112];
       Integer[] toughness = new Integer[112];
       Integer[] agility = new Integer[112];
       Integer[] intelligence = new Integer[112];
       Integer[] willPower = new Integer[112];
       Integer[] fellowship = new Integer[112];
       Integer[] attack = new Integer[112];
       Integer[] wounds = new Integer[112];
       Integer[] strengthBonus = new Integer[112];
       Integer[] toughnessBonus = new Integer[112];
       Integer[] movement = new Integer[112];
       Integer[] magic = new Integer[112];
       Integer[] insanityPoints = new Integer[112];
       Integer[] fatePoints = new Integer[112];
       String[] avaibleSkills = new String[112];
       String[] avaibleTalents = new String[112];
       String[] equipments = new String[112];
       ForeignCollection<CareerExit>[] carrersExit = new ForeignCollection[112];
       Boolean[] isAdvanced = new Boolean[112];

       int x=0;

        for(Career career : all) {
            id[x] = career.getId();
            name[x] = career.getName();
            description[x] = career.getDescription();
            weaponSkill[x] = career.getWeaponSkill();
            ballisticSkill[x] = career.getBallisticSkill();
            strength[x] = career.getStrength();
            toughness[x] = career.getToughness();
            agility[x] = career.getAgility();
            intelligence[x] = career.getIntelligence();
            willPower[x] = career.getWillPower();
            fellowship[x] = career.getFellowship();
            attack[x] = career.getAttack();
            wounds[x] = career.getWounds();
            strengthBonus[x] = career.getStrengthBonus();
            toughnessBonus[x] = career.getToughnessBonus();
            movement[x] = career.getMovement();
            magic[x] = career.getMagic();
            insanityPoints[x] = career.getInsanityPoints();
            fatePoints[x] = career.getFatePoints();
            avaibleSkills[x] = career.getAvaibleSkills();
            avaibleTalents[x] = career.getAvaibleTalents();
            equipments[x] = career.getEquipments();
            carrersExit[x] = career.getCarrersExit();
            isAdvanced[x] = career.getAdvanced();
            x++;
        }

        String[] colHeads = {"ID","Nazwa", "Opis", "WW", "US", "K", "Odp", "ZR", "INT", "SW",
            "ODG", "A", "Zyw", "S", "Wt", "Sz", "Mag", "PO", "PP", "Umiejętności", "Zdolności", "Wyposażenie",
            "Profesje wyjściowe", "Profesja zaawansowana"};


        Object[][] data = new Object[112][24];

        x=0;
        for(x=0;x<112;x++){
            data[x][0] = id[x];
            data[x][1] = name[x];
            data[x][2] = description[x];
            data[x][3] = weaponSkill[x];
            data[x][4] = ballisticSkill[x];
            data[x][5] = strength[x];
            data[x][6] = toughness[x];
            data[x][7] = agility[x];
            data[x][8] = intelligence[x];
            data[x][9] = willPower[x];
            data[x][10] = fellowship[x];
            data[x][11] = attack[x];
            data[x][12] = wounds[x];
            data[x][13] = strengthBonus[x];
            data[x][14] = toughnessBonus[x];
            data[x][15] = movement[x];
            data[x][16] = magic[x];
            data[x][17] = insanityPoints[x];
            data[x][18] = fatePoints[x];
            data[x][19] = avaibleSkills[x];
            data[x][20] = avaibleTalents[x];
            data[x][21] = equipments[x];
            data[x][22] = carrersExit[x];
            data[x][23] = isAdvanced[x];
        }
    
    JTable table = new JTable(data, colHeads);
    JScrollPane jsp = new JScrollPane(table);
    jfrm.add(jsp);
    jfrm.setVisible(true);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                try {
                    new Tabela();
                } catch (DatabaseCreateManagerException e) {
                    e.printStackTrace();
                } catch (DatabaseCreateTablesException e) {
                    e.printStackTrace();
                } catch (DatabaseOpenConnectionException e) {
                    e.printStackTrace();
                } catch (DatabaseSqlException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
}
