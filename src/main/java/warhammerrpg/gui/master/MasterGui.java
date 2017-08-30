package warhammerrpg.gui.master;

import warhammerrpg.core.gameMechanics.*;
import warhammerrpg.gui.ButtonColumn;
import warhammerrpg.gui.master.playersTable.PlayersTableModel;
import warhammerrpg.gui.master.playersTable.PlayersTableRow;
import warhammerrpg.gui.network.SelectPersonTableModel.SelectPersonTableModel;
import warhammerrpg.network.server.Server;

import javax.swing.*;
import java.awt.event.*;


public class MasterGui {



    private JPanel panel;
    private JButton throwDice;
    private JTextField diceResult;
    private JRadioButton oneDice;
    private JRadioButton twoDices;
    private JTextArea messages;
    private JLabel gameTime;
    private JTable playersTable;
    private JRadioButton twoDice;

    JFrame frame;

    private Server server;

    public MasterGui(JFrame frame) {
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
                messages.setText("sddsdassad");
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

