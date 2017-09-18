package warhammerrpg.gui.server;

import warhammerrpg.gui.server.playersTable.PlayersTableRow;
import warhammerrpg.network.server.ServerUserContainer;

import javax.swing.*;
import java.util.Map;

public class MasterGuiManager {

    private ServerGui serverGui;

    public MasterGuiManager(ServerGui serverGui) {
        this.serverGui = serverGui;
    }

    public void addNotice(final String text) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String output = "";
                serverGui.getMessages().append(text);
                serverGui.getMessages().append(System.getProperty("line.separator"));
            }
        });
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
}
