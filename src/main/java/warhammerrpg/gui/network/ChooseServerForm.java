package warhammerrpg.gui.network;


import warhammerrpg.core.database.Database;
import warhammerrpg.core.database.entity.Person;
import warhammerrpg.core.database.exception.*;
import warhammerrpg.core.database.manager.PersonManager;
import warhammerrpg.network.Client;
import warhammerrpg.network.Server;
import warhammerrpg.network.exception.ClientConnectException;
import warhammerrpg.network.exception.NetworkException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseServerForm {

    private Client client;
    private Server server;

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
    private JTable selectPerson;
    private JButton addPerson;

    String[] selectPersonColumnNames = {"Id", "Nick", "Rasa", "Profesja"};
    Object[][] data = {
            {"1", "Kathy", "Smith","xxx"},
            {"2", "Kathy2", "Smith2","xxx"}
    };


    public ChooseServerForm() {

        Database database = null;

        try {
            database = new Database();


        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }


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

        final Database finalDatabase = database;
        addPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog(panel, "Podaj nick");

                PersonManager personManager = null;
                try {
                    Person person = new Person();
                    person.setName(username);

                    personManager = finalDatabase.getPersonManager();
                    personManager.create(person);


                } catch(DatabaseRecordAlreadyExistException e1) {
                        JOptionPane.showMessageDialog(panel, "Użytkownik o danej nazwie już istnieje", "błąd", JOptionPane.ERROR_MESSAGE);
                } catch (DatabaseCreateManagerException | DatabaseSqlException e1) {
                    JOptionPane.showMessageDialog(panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
    }



    private void createUIComponents() {
        selectPerson = new JTable(new DefaultTableModel(data, selectPersonColumnNames) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

}
