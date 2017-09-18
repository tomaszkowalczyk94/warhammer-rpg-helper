package warhammerrpg.gui.client;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.database.Database;
import warhammerrpg.database.entity.Person;
import warhammerrpg.database.exception.*;
import warhammerrpg.database.manager.PersonManager;
import warhammerrpg.gui.client.observer.ClientSetPersonDataEventContainer;
import warhammerrpg.network.client.Client;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import static warhammerrpg.database.entity.Person.Field.*;


/**
 * default observers:
 *  - PersonChangeDataObserver
 */
public class ClientGui  implements Observable {

    private JPanel panel;
    private JFormattedTextField nameTextField;
    private JFormattedTextField breedTextField;
    private JFormattedTextField curProffesionTextField;
    private JFormattedTextField prevProffesionTextField;

    private JFormattedTextField ageTextField;
    private JFormattedTextField sexTextField;
    private JFormattedTextField eyesColourTextField;
    private JFormattedTextField hairColourTextField;
    private JFormattedTextField starSignTextField;
    private JFormattedTextField weightTextField;
    private JFormattedTextField heightTextField;
    private JFormattedTextField siblingsTextField;
    private JFormattedTextField birthPlaceTextField;
    private JFormattedTextField specialSignsTextField;

    private JLabel imageLogo;



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

        createStringEditableField(nameTextField, NAME);
        createStringEditableField(breedTextField, BREED);
        createStringEditableField(curProffesionTextField, CUR_PROFFESION);
        createStringEditableField(prevProffesionTextField, PREV_PROFFESION);

        createStringEditableField(ageTextField , AGE);
        createStringEditableField(sexTextField , SEX);
        createStringEditableField(eyesColourTextField , EYES_COLOUR);
        createStringEditableField(hairColourTextField , HAIR_COLOUR);
        createStringEditableField(starSignTextField , STAR_SIGN);
        createStringEditableField(weightTextField , WEIGHT);
        createStringEditableField(heightTextField , HEIGHT);
        createStringEditableField(siblingsTextField , SIBLINGS);
        createStringEditableField(birthPlaceTextField , BIRTH_PLACE);
        createStringEditableField(specialSignsTextField , SPECIAL_SIGNS);

        fillIn(this.getPerson());
    }

    private void fillIn(Person person) {
        nameTextField.setText(person.getName());
        breedTextField.setText(person.getBreed());
        curProffesionTextField.setText(person.getCurProffesion());
        prevProffesionTextField.setText(person.getPrevProffesion());
    }

    private void createStringEditableField(final JFormattedTextField field, final Person.Field personField) {

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

            if(!oldValue.equals(newValue)) {
                ClientSetPersonDataEventContainer clientSetPersonDataEventContainer = new ClientSetPersonDataEventContainer();
                clientSetPersonDataEventContainer.field = nameField;
                clientSetPersonDataEventContainer.oldValue = oldValue;
                clientSetPersonDataEventContainer.newValue = newValue;

                this.notifyObservers(Event.CLIENT_SET_PERSON_DATA, clientSetPersonDataEventContainer, null);
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
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
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
