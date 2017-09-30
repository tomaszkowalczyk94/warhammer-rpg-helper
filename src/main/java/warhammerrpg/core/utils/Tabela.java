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

import java.awt.*;
import java.util.EventObject;
import java.util.List;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;

public class Tabela {
    
    Tabela() throws DatabaseCreateManagerException, DatabaseCreateTablesException, DatabaseOpenConnectionException, DatabaseSqlException {

        JFrame jfrm = new JFrame("Profesje");
        jfrm.setSize(1600, 850);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Database database = new Database();
        CareerManager careerManager = database.getCareerManager();

        List<Career> all = careerManager.getAll();

       Integer[] id = new Integer[113];
       String[] name = new String[113];
       String[] description = new String[113];
       Integer[] weaponSkill = new Integer[113];
       Integer[] ballisticSkill = new Integer[113];
       Integer[] strength = new Integer[113];
       Integer[] toughness = new Integer[113];
       Integer[] agility = new Integer[113];
       Integer[] intelligence = new Integer[113];
       Integer[] willPower = new Integer[113];
       Integer[] fellowship = new Integer[113];
       Integer[] attack = new Integer[113];
       Integer[] wounds = new Integer[113];
       Integer[] strengthBonus = new Integer[113];
       Integer[] toughnessBonus = new Integer[113];
       Integer[] movement = new Integer[113];
       Integer[] magic = new Integer[113];
       Integer[] insanityPoints = new Integer[113];
       Integer[] fatePoints = new Integer[113];
       String[] avaibleSkills = new String[113];
       String[] avaibleTalents = new String[113];
       String[] equipments = new String[113];
       ForeignCollection<CareerExit>[] carrersExit = new ForeignCollection[113];
       Boolean[] isAdvanced = new Boolean[113];

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
            carrersExit[x] = career.getCarrersExit(); //co by wyswietlalo liste profesji a nie to cos dziwnego
            isAdvanced[x] = career.getAdvanced();
            x++;
        }

        String[] colHeads = {"ID","Nazwa", "Opis", "WW", "US", "K", "Odp", "ZR", "INT", "SW",
            "ODG", "A", "Zyw", "S", "Wt", "Sz", "Mag", "PO", "PP", "Umiejętności", "Zdolności", "Wyposażenie",
            "Wyjściowe", "Zaawansowana?"};


        Object[][] data = new Object[113][24];

        x=0;
        for(x=0;x<113;x++){
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

    table.setRowHeight(70);
    table.getColumn("ID").setPreferredWidth(10);
    table.getColumn("Nazwa").setPreferredWidth(100);
    table.getColumn("Opis").setPreferredWidth(300); //dodac scrollbar
    table.getColumn("WW").setPreferredWidth(10);
    table.getColumn("US").setPreferredWidth(10);
    table.getColumn("K").setPreferredWidth(10);
    table.getColumn("Odp").setPreferredWidth(10);
    table.getColumn("ZR").setPreferredWidth(10);
    table.getColumn("INT").setPreferredWidth(10);
    table.getColumn("SW").setPreferredWidth(10);
    table.getColumn("ODG").setPreferredWidth(10);
    table.getColumn("A").setPreferredWidth(10);
    table.getColumn("Zyw").setPreferredWidth(10);
    table.getColumn("S").setPreferredWidth(10);
    table.getColumn("Wt").setPreferredWidth(10);
    table.getColumn("Sz").setPreferredWidth(10);
    table.getColumn("Mag").setPreferredWidth(10);
    table.getColumn("PO").setPreferredWidth(10);
    table.getColumn("PP").setPreferredWidth(10);
    table.getColumn("Umiejętności").setPreferredWidth(100);//dodac scrollbar
    table.getColumn("Zdolności").setPreferredWidth(100); //dodac scrollbar
    table.getColumn("Wyposażenie").setPreferredWidth(100); //dodac scrollbar
    table.getColumn("Wyjściowe").setPreferredWidth(70); //dodac scrollbar
    table.getColumn("Zaawansowana?").setPreferredWidth(80);

    table.getColumnModel().getColumn(2).setCellRenderer(new CustomCellRenderer());
    table.getColumnModel().getColumn(2).setCellEditor(new CustomEditor());
    table.getColumnModel().getColumn(19).setCellRenderer(new CustomCellRenderer());
    table.getColumnModel().getColumn(19).setCellEditor(new CustomEditor());
    table.getColumnModel().getColumn(20).setCellRenderer(new CustomCellRenderer());
    table.getColumnModel().getColumn(20).setCellEditor(new CustomEditor());
    table.getColumnModel().getColumn(21).setCellRenderer(new CustomCellRenderer());
    table.getColumnModel().getColumn(21).setCellEditor(new CustomEditor());
    table.getColumnModel().getColumn(22).setCellRenderer(new CustomCellRenderer());
    table.getColumnModel().getColumn(22).setCellEditor(new CustomEditor());

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

class CustomCellRenderer extends DefaultTableCellRenderer {

    private JTextArea textArea;
    private JScrollPane scrollPane;

    public CustomCellRenderer() {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {

        if(null != value)
            textArea.setText(value.toString());

        return scrollPane;
    }
}

class CustomEditor implements TableCellEditor {

    private JTextArea textArea;
    private JScrollPane scrollPane;

    public CustomEditor() {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(null != value)
            textArea.setText(value.toString());

        return scrollPane;
    }

    @Override
    public void addCellEditorListener(CellEditorListener arg0) {

    }
    @Override
    public void cancelCellEditing() {

    }
    @Override
    public Object getCellEditorValue() {
        return textArea.getText();
    }
    @Override
    public boolean isCellEditable(EventObject arg0) {
        return true;
    }
    @Override
    public void removeCellEditorListener(CellEditorListener arg0) {

    }
    @Override
    public boolean shouldSelectCell(EventObject arg0) {

        return true;
    }
    @Override
    public boolean stopCellEditing() {

        return true;
    }
}