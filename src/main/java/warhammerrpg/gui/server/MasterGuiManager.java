package warhammerrpg.gui.server;

import warhammerrpg.gui.server.gameNotificationTable.NotificationTableManager;
import warhammerrpg.gui.server.playersTable.PlayersTableRow;
import warhammerrpg.network.server.ServerUserContainer;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MasterGuiManager {

    private ServerGui serverGui;

    private NotificationTableManager notificationTableManager;

    public MasterGuiManager(ServerGui serverGui) {
        this.serverGui = serverGui;
        this.notificationTableManager = new NotificationTableManager();
        this.notificationTableManager.setServerGui(serverGui);
    }

    public void refreshUsersList(final Map<String, ServerUserContainer> users) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                serverGui.getPlayersTableModel().clearRows();
                for(Map.Entry<String, ServerUserContainer> entry: users.entrySet()) {
                    PlayersTableRow playersTableRow = new PlayersTableRow();

                    playersTableRow.setName(entry.getValue().getUsername());
                    playersTableRow.setToken(entry.getValue().getToken());

                    serverGui.getPlayersTableModel().addRow(playersTableRow);
                }
                serverGui.getPlayersTableModel().fireTableDataChanged();
            }
        });
    }


    public NotificationTableManager getNotificationTableManager() {
        return notificationTableManager;
    }
}
