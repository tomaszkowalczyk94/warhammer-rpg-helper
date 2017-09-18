package warhammerrpg.gui.client;

import javax.swing.*;

public class ClientGuiManager {

    private ClientGui clientGui;

    public ClientGuiManager(ClientGui clientGui) {
        this.clientGui = clientGui;
    }

    public void openAlertAndCloseApp(String alert) {
        JOptionPane.showMessageDialog(null, alert, "błąd", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

}
