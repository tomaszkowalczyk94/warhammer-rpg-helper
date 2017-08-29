package warhammerrpg.gui.master.playersTable;

import warhammerrpg.gui.network.SelectPersonTableModel.SelectPersonRow;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class PlayersTableModel extends AbstractTableModel {

    private String[] columnNames = {"nick", "token"};
    List<PlayersTableRow> data = new ArrayList<PlayersTableRow>();

    public void addRow(PlayersTableRow playersTableRow) {
        data.add(playersTableRow);
    }

    public void clearRows() {
        data.clear();
    }

    public PlayersTableRow getRow(int index) {
        return data.get(index);
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
