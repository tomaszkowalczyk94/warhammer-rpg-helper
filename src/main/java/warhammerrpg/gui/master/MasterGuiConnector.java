package warhammerrpg.gui.master;

import warhammerrpg.gui.master.playersTable.PlayersTableRow;
import warhammerrpg.network.server.ServerUserContainer;

import javax.swing.*;
import java.util.Map;

public class MasterGuiConnector {

    private MasterGui masterGui;

    public MasterGuiConnector(MasterGui masterGui) {
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
