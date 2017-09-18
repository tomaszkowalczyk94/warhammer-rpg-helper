package warhammerrpg.gui.server;

import warhammerrpg.core.gameMechanics.*;
import warhammerrpg.gui.ButtonColumn;
import warhammerrpg.gui.server.playersTable.PlayersTableModel;
import warhammerrpg.gui.server.playersTable.PlayersTableRow;
import warhammerrpg.network.server.Server;

import javax.swing.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class ServerGui {



    private JPanel panel;
    private JButton throwDice;
    private JTextField diceResult;
    private JRadioButton oneDice;
    private JRadioButton twoDices;
    private JTextArea messages;
    private JTable playersTable;
    private JLabel ipAdressLabel;
    private JRadioButton twoDice;

    JFrame frame;

    private Server server;

    public ServerGui(JFrame frame) {
        this.frame = frame;

        throwDice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Dice dice = new Dice();
                if (twoDices.isSelected()) {
                    diceResult.setText(dice.twoDicesThrow().toString());
                } else {
                    diceResult.setText(dice.oneDiceThrow().toString());
                }
            }
        });
        twoDices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                oneDice.setSelected(false);
                twoDices.setSelected(false);
            }
        });
        oneDice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                oneDice.setSelected(true);
                twoDices.setSelected(false);
            }
        });

        try {
            ipAdressLabel.setText("Adres ip: "+ InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace(); // @todo cos z tym zrobić
        }
    }

    public void open(){
        JFrame frame = new JFrame("Game Master Panel");
        frame.setContentPane(this.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextArea getMessages() {
        return messages;
    }

    private PlayersTableModel playersTableModel = null;

    public PlayersTableModel getPlayersTableModel() {
        return playersTableModel;
    }

    private void createUIComponents() {
        playersTableModel = new PlayersTableModel();
        playersTable = new JTable(playersTableModel);

        ButtonColumn buttonColumn = new ButtonColumn(playersTable, null, 2);

        playersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String kickMessage = JOptionPane.showInputDialog(panel, "Powód");
                if(kickMessage != null) {
                    int row = playersTable.rowAtPoint(evt.getPoint());
                    PlayersTableRow playersTableRow = playersTableModel.getRow(row);
                    System.out.println("user: "+playersTableRow.getName());

                    server.kickUser(playersTableRow.getName(), kickMessage);
                }




            }
        });
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

}

