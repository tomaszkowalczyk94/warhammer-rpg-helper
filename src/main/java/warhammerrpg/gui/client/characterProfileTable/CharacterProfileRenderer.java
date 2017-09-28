package warhammerrpg.gui.client.characterProfileTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CharacterProfileRenderer extends DefaultTableCellRenderer{

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if(row == 0 || column == 0) {
            setBorder(BorderFactory.createEmptyBorder());
        } else {
            setBorder(BorderFactory.createMatteBorder(
                    1,
                    1 ,
                    getSizeOfBottomBorder(row, column),
                    getSizeOfRightBorder(row, column),
                    Color.black));
        }


        return this;
    }


    /**
     * Aby iniknąć krawędzi z podwójną grubością
     * @param row
     * @param column
     * @return
     */
    private int getSizeOfBottomBorder(int row, int column) {
        if(row == CharacterProfileTable.ROW_COUNT -1) {
            return 1;
        }
        return 0;
    }

    /**
     * Aby iniknąć krawędzi z podwójną grubością
     * @param row
     * @param column
     * @return
     */
    private int getSizeOfRightBorder(int row, int column) {
        if(column == CharacterProfileTable.COLUMN_COUNT -1) {
            return 1;
        }
        return 0;
    }
}
