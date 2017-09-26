package warhammerrpg.gui.server.gameNotificationTable;

import warhammerrpg.gui.server.playersTable.PlayersTableRow;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class NotificationTableModel extends AbstractTableModel {

    private String[] columnNames = {"użytkownik", "data", "wiadomość"};
    List<NotificationTableRow> data = new ArrayList<NotificationTableRow>();

    public void addRow(NotificationTableRow notificationTableRow) {
        data.add(notificationTableRow);
    }

    public void clearRows() {
        data.clear();
    }

    public NotificationTableRow getRow(int index) {
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

    public void removeRow(int modelRow) {
        data.remove(data.get(modelRow));
    }

}
