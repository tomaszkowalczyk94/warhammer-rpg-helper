//jeszcze do dopracowania :P
//27.09.17 - ja dalej nad tym pracuje
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

public class Tabela extends JApplet{
    
    public void init() {
        try{
            SwingUtilities.invokeAndWait(
               new Runnable(){
                   public void run(){
                       try {
                           makeGUI();
                       } catch (DatabaseCreateManagerException e) {
                           e.printStackTrace();
                       } catch (DatabaseOpenConnectionException e) {
                           e.printStackTrace();
                       } catch (DatabaseCreateTablesException e) {
                           e.printStackTrace();
                       } catch (DatabaseSqlException e) {
                           e.printStackTrace();
                       }
                   }
               }
            );
        }catch(Exception exc){
            System.out.println(exc);
        }
        
    }
    
    private void makeGUI() throws DatabaseCreateManagerException, DatabaseCreateTablesException, DatabaseOpenConnectionException, DatabaseSqlException {

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

        String[] colHeads = {"Nazwa", "Opis", "WW", "US", "K", "Odp", "ZR", "INT", "SW",
            "ODG", "A", "Zyw", "S", "Wt", "Sz", "Mag", "PO", "PP", "Umiejętności", "Zdolności", "Wyposażenie",
            "Profesje wyjściowe", "Profesja zaawansowana"};


        Object[][] data = new Object[112][23];
        /*

        tu mi wywala jakiś błąd, ale nia mam głowy do tego, aby teraz to rozwiazac ;p
        ogarne to jutro ;p
        x=0;
        for(x=0;x<112;x++){
            data[x] = {id[x], name[x], description[x], weaponSkill[x], ballisticSkill[x], strength[x], toughness[x], agility[x], intelligence[x],
                    willPower[x], fellowship[x], attack[x], wounds[x], strengthBonus[x], toughnessBonus[x], movement[x], magic[x],
                    insanityPoints[x], fatePoints[x], avaibleSkills[x], avaibleTalents[x], equipments[x], carrersExit[x], isAdvanced[x]};
        }*/
    
    JTable table = new JTable(data, colHeads);
    JScrollPane jsp = new JScrollPane(table);
    add(jsp);
}
    
}
