package warhammerrpg.gui.master;

import warhammerrpg.core.gameMechanics.*;
import warhammerrpg.gui.master.playersTable.PlayersTableModel;
import warhammerrpg.gui.network.SelectPersonTableModel.SelectPersonTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
    }
}

