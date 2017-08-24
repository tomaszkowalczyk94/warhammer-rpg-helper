package warhammerrpg.gui.network;

import javax.swing.*;

public class ChooseServerForm {
    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel;
    private JTextField ipConnectText;
    private JTextField portConnectText;
    private JButton connectButton;
    private JButton createGameButton;
    private JTextField portCreateText;
    private JLabel ipConnectLabel;
    private JLabel portConnectLabel;
    private JLabel connectNagLabel;
    private JLabel createNagLabel;
    private JLabel portCreateLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
