package warhammerrpg.gui;

import javax.swing.*;

public class GuiClientFormConnector {

    private ClientGui clientGui;

    public GuiClientFormConnector(ClientGui clientGui) {
        this.clientGui = clientGui;
    }

    public void openAlertANdCloseApp(String alert) {
        JOptionPane.showMessageDialog(null, alert, "błąd", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

}
