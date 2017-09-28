package warhammerrpg.gui.client.characterProfileTable;

import javax.swing.*;

public class CharacterProfileTable extends JTable {

    public static int ROW_COUNT = 4;
    public static int COLUMN_COUNT = 5;

    public CharacterProfileTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
    }
}
