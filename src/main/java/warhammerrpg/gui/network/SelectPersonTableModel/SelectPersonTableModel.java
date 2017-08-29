package warhammerrpg.gui.network.SelectPersonTableModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SelectPersonTableModel extends AbstractTableModel {

    private String[] columnNames = {"Id", "Nick", "Rasa", "Profesja"};
    List<SelectPersonRow> data = new ArrayList<SelectPersonRow>();

    public void addRow(SelectPersonRow selectPersonRow) {
        data.add(selectPersonRow);
    }

    public void clearRows() {
        data.clear();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data.get(row).getCol(col);
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
