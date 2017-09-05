package warhammerrpg.gui.client;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.database.Database;
import warhammerrpg.database.entity.Person;
import warhammerrpg.database.exception.*;
import warhammerrpg.database.manager.PersonManager;
import warhammerrpg.network.client.Client;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import static warhammerrpg.database.entity.Person.Field.*;

public class ClientGui  implements Observable {

    private JPanel panel;
    private JFormattedTextField nameTextField;
    private JFormattedTextField breedTextField;
    private JFormattedTextField curProffesionTextField;
    private JFormattedTextField prevProffesionTextField;


    private JLabel imageLogo;
    private JFormattedTextField formattedTextField5;
    private JFormattedTextField formattedTextField6;
    private JFormattedTextField formattedTextField7;
    private JFormattedTextField formattedTextField8;
    private JFormattedTextField formattedTextField9;
    private JFormattedTextField formattedTextField10;
    private JFormattedTextField formattedTextField11;
    private JFormattedTextField formattedTextField12;
    private JFormattedTextField formattedTextField13;
    private JFormattedTextField formattedTextField14;
    private JButton zapiszButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;


    JFrame frame;
    Client client;

    private Database database;
    private Person person;
    private int personId;

    public ClientGui(JFrame frame, Client client, int personId) {

        this.frame = frame;
        this.client = client;
        this.personId = personId;

        this.observerList = new ArrayList<>();

        try {
            database = new Database();
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
        }

        createEditableField(nameTextField, NAME);
        createEditableField(breedTextField, BREED);
        createEditableField(curProffesionTextField, CUR_PROFFESION);
        createEditableField(prevProffesionTextField, PREV_PROFFESION);

        fillIn(this.getPerson());
    }

    private void fillIn(Person person) {
        nameTextField.setText(person.getName());
        breedTextField.setText(person.getBreed());
        curProffesionTextField.setText(person.getCurProffesion());
        prevProffesionTextField.setText(person.getPrevProffesion());
    }

    private void createEditableField(final JFormattedTextField field, final Person.Field personField) {

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

    private void saveStringField(final JFormattedTextField field, Person.Field nameField) {

        try {
            PersonManager personManager = database.getPersonManager();

            String newValue =  field.getText();
            String oldValue = personManager.updateStringField(getPerson(), nameField, newValue);


            if(oldValue == null) {
                oldValue = "";
            }
            if(newValue == null) {
                newValue = "";
            }

            System.out.println("old: "+ oldValue);
            System.out.println("new: " + newValue);

            if(!oldValue.equals(newValue)) {
                this.notifyObservers(Event.CLIENT_SET_PERSON_DATA, oldValue, newValue);
            }
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
        }
        //zapis do bazy
        //jak się powiódł to wysyłamy do GM
    }

    public void open() {
        JFrame frame = new JFrame("Player GUI Form");
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        imageLogo = new JLabel(new ImageIcon("person.PNG"));
    }

    public Person getPerson() {
        try {
            return database.getPersonManager().getById(personId);
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }


    protected ArrayList<Observer> observerList;

    @Override
    public void register(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers(Observable.Event event, Object param1, Object param2) {
        for (Observer o : observerList){
            try {
                o.run(event, param1, param2);
            } catch (UnknowObserableEventException e) {
                System.out.println(e);
                e.printStackTrace(); // @todo cos z tym zrobic
            }
        }
    }
}
