package warhammerrpg.gui.network;


import warhammerrpg.core.database.Database;
import warhammerrpg.core.database.entity.Person;
import warhammerrpg.core.database.exception.*;
import warhammerrpg.core.database.manager.PersonManager;
import warhammerrpg.gui.network.SelectPersonTableModel.SelectPersonRow;
import warhammerrpg.gui.network.SelectPersonTableModel.SelectPersonTableModel;
import warhammerrpg.network.client.Client;
import warhammerrpg.network.server.Server;
import warhammerrpg.network.exception.ClientConnectException;
import warhammerrpg.network.exception.InvalidUsernameException;
import warhammerrpg.network.exception.NetworkException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

    Database database = null;

    public ChooseServerForm() {

        try {
            database = new Database();
            generatePersonTable();
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        final Database finalDatabase = database;

        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connectButton.setEnabled(Boolean.FALSE);
                createGameButton.setEnabled(Boolean.FALSE);

                int selectRowIndex = selectPerson.getSelectedRow();
                if(selectRowIndex != -1) { // -1 jesli nie wybrano żadnego wiersza
                    String username =  selectPersonTableModel.getRow(selectRowIndex).getName();

                    try {
                        connectButton.setEnabled(Boolean.FALSE);
                        createGameButton.setEnabled(Boolean.FALSE);
                        client = new Client(ipConnectText.getText(), Integer.parseInt(portConnectText.getText()), username);
                        JOptionPane.showMessageDialog(panel, "Połączono");
                        GamerGui gamerGui = new GamerGui();

                    } catch (ClientConnectException exception) {
                        JOptionPane.showMessageDialog(panel, "Nie można połączyć się z serwerem", "błąd", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(panel, "Niepoprawny port", "błąd", JOptionPane.ERROR_MESSAGE);
                    } catch (InvalidUsernameException e1) {
                        JOptionPane.showMessageDialog(panel, "Nieprawidłowa nazwa użytkownika", "błąd", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Wybierz użytkownika", "błąd", JOptionPane.ERROR_MESSAGE);
                }

                connectButton.setEnabled(Boolean.TRUE);
                createGameButton.setEnabled(Boolean.TRUE);
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

        addPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog(panel, "Podaj nick");
                if(username != null) {
                    PersonManager personManager = null;
                    try {
                        Person person = new Person();

                        person.setName(username);

                        personManager = finalDatabase.getPersonManager();
                        personManager.create(person);
                        generatePersonTable();

                    } catch(DatabaseRecordAlreadyExistException e1) {
                        JOptionPane.showMessageDialog(panel, "Użytkownik o danej nazwie już istnieje", "błąd", JOptionPane.ERROR_MESSAGE);
                    } catch (DatabaseCreateManagerException | DatabaseSqlException e1) {
                        JOptionPane.showMessageDialog(panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private SelectPersonTableModel selectPersonTableModel = null;

    private void createUIComponents() {
        selectPersonTableModel = new SelectPersonTableModel();
        selectPerson = new JTable(selectPersonTableModel);
    }

    private void generatePersonTable() throws DatabaseCreateManagerException, DatabaseSqlException {

        final List<Person> allPersons = database.getPersonManager().getAll();
        selectPersonTableModel.clearRows();
        for(Person p : allPersons) {
            SelectPersonRow row = new SelectPersonRow();

            row.setId(p.getId());
            row.setName(getEmptyStringIfNull(p.getName()));
            row.setBreed(getEmptyStringIfNull(p.getBreed()));
            row.setProffesion(getEmptyStringIfNull(p.getCurProffesion()));

            selectPersonTableModel.addRow(row);
        }
        selectPersonTableModel.fireTableDataChanged();
    }

    private String getEmptyStringIfNull(String text) {
        if(text != null) {
            return text;
        }else {
           return "";
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

}
