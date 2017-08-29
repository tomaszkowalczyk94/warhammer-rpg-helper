package warhammerrpg.gui.client;

import javax.swing.*;

public class ClientGuiConnector {

    private ClientGui clientGui;

    public ClientGuiConnector(ClientGui clientGui) {
        this.clientGui = clientGui;
    }

    public void openAlertAndCloseApp(String alert) {
        JOptionPane.showMessageDialog(null, alert, "błąd", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

}
