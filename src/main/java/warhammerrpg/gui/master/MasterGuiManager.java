package warhammerrpg.gui.master;

import warhammerrpg.gui.master.playersTable.PlayersTableRow;
import warhammerrpg.network.server.ServerUserContainer;

import javax.swing.*;
import java.util.Map;

public class MasterGuiManager {

    private MasterGui masterGui;

    public MasterGuiManager(MasterGui masterGui) {
        this.masterGui = masterGui;
    }

    public void addNotice(final String text) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String output = "";
                masterGui.getMessages().append(text);
                masterGui.getMessages().append(System.getProperty("line.separator"));
            }
        });
    }

    public void refreshUsersList(final Map<String, ServerUserContainer> users) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                masterGui.getPlayersTableModel().clearRows();
                for(Map.Entry<String, ServerUserContainer> entry: users.entrySet()) {
                    PlayersTableRow playersTableRow = new PlayersTableRow();

                    playersTableRow.setName(entry.getValue().getUsername());
                    playersTableRow.setToken(entry.getValue().getToken());

                    masterGui.getPlayersTableModel().addRow(playersTableRow);
                }
                masterGui.getPlayersTableModel().fireTableDataChanged();
            }
        });


    }
}
