package warhammerrpg.gui.server.gameNotificationTable;

import warhammerrpg.gui.server.ServerGui;
import warhammerrpg.gui.server.playersTable.PlayersTableRow;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class NotificationTableManager {

    public enum Type {
        INFO, ERROR
    }

    private ServerGui serverGui;

    public void addNotification(String username, String msg, Type type) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                NotificationTableRow notificationTableRow = new NotificationTableRow();
                notificationTableRow.setDate(new Date());
                notificationTableRow.setUsername(username);
                notificationTableRow.setMessage(msg);

                System.out.println("dodaje");
                serverGui.getNotificationTableModel().addRow(notificationTableRow);


                serverGui.getNotificationTableModel().fireTableDataChanged();

                scrollToVisible(
                        serverGui.getNotificationTable(),
                        serverGui.getNotificationTableModel().getRowCount(),
                        1
                );
            }
        });
    }

    public ServerGui getServerGui() {
        return serverGui;
    }

    public void setServerGui(ServerGui serverGui) {
        this.serverGui = serverGui;
    }


    private void scrollToVisible(JTable table, int rowIndex, int vColIndex) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                int viewRow = table.convertRowIndexToView(rowIndex);
                table.scrollRectToVisible(table.getCellRect(viewRow, 0, true));
            }
        });
    }
}
