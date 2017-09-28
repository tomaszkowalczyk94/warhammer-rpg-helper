package warhammerrpg.gui.client;

import warhammerrpg.core.Observable;
import warhammerrpg.database.entity.Fieldable;
import warhammerrpg.database.entity.Person;
import warhammerrpg.database.exception.DatabaseCreateManagerException;
import warhammerrpg.database.exception.DatabaseException;
import warhammerrpg.database.exception.DatabaseSqlException;
import warhammerrpg.database.manager.PersonManager;
import warhammerrpg.gui.client.observer.ClientSetPersonDataEventContainer;

import javax.swing.*;
import java.awt.event.*;

class ClientGuiHelper {

    ClientGui clientGui;

    public ClientGuiHelper(ClientGui clientGui) {
        this.clientGui = clientGui;
    }

    protected Person getPerson() {
        try {
            return clientGui.database.getPersonManager().getById(clientGui.personId);
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(clientGui.panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    protected void createStringEditableField(final JFormattedTextField field, final Person.Field personField) {

        field.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                field.setEditable(true);
                field.requestFocus();
                field.getCaret().setVisible(true);
            }
        });
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                field.setEditable(false);
                field.getCaret().setVisible(false);
                saveStringField(field, personField);
            }
        });
        // wcisniecie entera
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setEditable(false);
                field.getCaret().setVisible(false);
                saveStringField(field, personField);
            }
        });
    }

    protected void createJComboBoxEditableField(final JComboBox field, final Person.Field personField) {
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveComboBoxField(field, personField);
            }
        });
    }

    private void saveStringField(final JFormattedTextField field, Person.Field nameField) {

        try {
            PersonManager personManager = clientGui.database.getPersonManager();

            String newValue =  field.getText();
            String oldValue = personManager.updateStringField(getPerson(), nameField, newValue);

            if(!oldValue.equals(newValue)) {
                notifyClientGuiObserversAboutDataChanged(nameField, oldValue, newValue);
            }
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(clientGui.panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveComboBoxField(final JComboBox jComboBox, Person.Field field){
        try {
            PersonManager personManager = clientGui.database.getPersonManager();

            Fieldable newValue = (Fieldable) jComboBox.getSelectedItem();
            Fieldable oldValue = personManager.updateObjectField(getPerson(), field, newValue);

            if(newValue != null && !newValue.equals(oldValue)) {
                notifyClientGuiObserversAboutDataChanged(field, oldValue, newValue);
            }

        } catch (DatabaseCreateManagerException e) {
            JOptionPane.showMessageDialog(clientGui.panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
        } catch (DatabaseSqlException e) {
            e.printStackTrace();
        }
    }

    private void notifyClientGuiObserversAboutDataChanged(Person.Field field, Object oldValue, Object newValue) {

        if(oldValue == null) {
            oldValue = "";
        }
        if(newValue == null) {
            newValue = "";
        }

        ClientSetPersonDataEventContainer clientSetPersonDataEventContainer = new ClientSetPersonDataEventContainer();
        clientSetPersonDataEventContainer.field = field;
        clientSetPersonDataEventContainer.oldValue = oldValue.toString();
        clientSetPersonDataEventContainer.newValue = newValue.toString();

        clientGui.notifyObservers(Observable.Event.CLIENT_SET_PERSON_DATA, clientSetPersonDataEventContainer, null);
    }
}
