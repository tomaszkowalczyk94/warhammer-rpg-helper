package warhammerrpg.gui.network;


import warhammerrpg.network.Client;
import warhammerrpg.network.Server;
import warhammerrpg.network.exception.ClientConnectException;
import warhammerrpg.network.exception.NetworkException;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseServerForm {

    private Client client;
    private Server server;

    public ChooseServerForm() {
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    client = new Client(ipConnectText.getText(), Integer.parseInt(portConnectText.getText()));
                    JOptionPane.showMessageDialog(panel, "Połączono");
                    GamerGui gamerGui = new GamerGui();
                    connectButton.setEnabled(Boolean.FALSE);
                    createGameButton.setEnabled(Boolean.FALSE);
                } catch (ClientConnectException exception) {
                    JOptionPane.showMessageDialog(panel, "Nie można połączyć się z serwerem", "błąd", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(panel, "Niepoprawny port", "błąd", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        createGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                server = new Server();
                try {
                    server.run(Integer.parseInt(portCreateText.getText()));
                    JOptionPane.showMessageDialog(panel, "Serwer uruchomiony");
                    MasterGui masterGui = new MasterGui();
                    connectButton.setEnabled(Boolean.FALSE);
                    createGameButton.setEnabled(Boolean.FALSE);
                } catch (NetworkException e1) {
                    JOptionPane.showMessageDialog(panel, "Nie można uruchomić serwera", "błąd", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(panel, "Niepoprawny port", "błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

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
