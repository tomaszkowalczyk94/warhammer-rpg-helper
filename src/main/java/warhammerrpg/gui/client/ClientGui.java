package warhammerrpg.gui.client;

import warhammerrpg.core.Observable;
import warhammerrpg.core.Observer;
import warhammerrpg.core.exception.UnknowObserableEventException;
import warhammerrpg.database.Database;
import warhammerrpg.database.entity.Career;
import warhammerrpg.database.entity.Person;
import warhammerrpg.database.exception.*;
import warhammerrpg.database.manager.PersonManager;
import warhammerrpg.gui.client.observer.ClientSetPersonDataEventContainer;
import warhammerrpg.network.client.Client;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static warhammerrpg.database.entity.Person.Field.*;


/**
 * default observers:
 *  - PersonChangeDataObserver
 */
public class ClientGui  implements Observable {

    protected JPanel panel;

    protected JFormattedTextField nameTextField;
    protected JFormattedTextField breedTextField;
    protected JComboBox curCareer;
    protected JComboBox prevCareer;

    protected JFormattedTextField ageTextField;
    protected JFormattedTextField sexTextField;
    protected JFormattedTextField eyesColourTextField;
    protected JFormattedTextField hairColourTextField;
    protected JFormattedTextField starSignTextField;
    protected JFormattedTextField weightTextField;
    protected JFormattedTextField heightTextField;
    protected JFormattedTextField siblingsTextField;
    protected JFormattedTextField birthPlaceTextField;
    protected JFormattedTextField specialSignsTextField;

    protected JLabel imageLogo;

    JFrame frame;
    Client client;

    protected Database database;
    protected Person person;
    protected int personId;
    protected ClientGuiHelper clientGuiHelper;

    public ClientGui(JFrame frame, Client client, int personId) {

        this.frame = frame;
        this.client = client;
        this.personId = personId;
        this.clientGuiHelper = new ClientGuiHelper(this);

        this.observerList = new ArrayList<>();

        try {
            database = new Database();
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
        }

        clientGuiHelper.createStringEditableField(nameTextField, NAME);
        clientGuiHelper.createStringEditableField(breedTextField, BREED);

        clientGuiHelper.createStringEditableField(ageTextField , AGE);
        clientGuiHelper.createStringEditableField(sexTextField , SEX);
        clientGuiHelper.createStringEditableField(eyesColourTextField , EYES_COLOUR);
        clientGuiHelper.createStringEditableField(hairColourTextField , HAIR_COLOUR);
        clientGuiHelper.createStringEditableField(starSignTextField , STAR_SIGN);
        clientGuiHelper.createStringEditableField(weightTextField , WEIGHT);
        clientGuiHelper.createStringEditableField(heightTextField , HEIGHT);
        clientGuiHelper.createStringEditableField(siblingsTextField , SIBLINGS);
        clientGuiHelper.createStringEditableField(birthPlaceTextField , BIRTH_PLACE);
        clientGuiHelper.createStringEditableField(specialSignsTextField , SPECIAL_SIGNS);

        clientGuiHelper.createJComboBoxEditableField(curCareer, CUR_CAREER);
        clientGuiHelper.createJComboBoxEditableField(prevCareer, PREV_CAREER);

        fillIn(clientGuiHelper.getPerson());
    }

    private void fillIn(Person person) {
        nameTextField.setText(person.getName());
        breedTextField.setText(person.getBreed());
        curCareer.setSelectedItem(person.getCurCareer());
        prevCareer.setSelectedItem(person.getPrevCareer());
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

        createComboBoxes();
    }

    private void createComboBoxes() {
        try {
            database = new Database();

            List<Career> all = database.getCareerManager().getAll();
            curCareer = new JComboBox<Career>(new Vector<Career>(all) );
            prevCareer = new JComboBox<Career>(new Vector<Career>(all) );

            database.closeConnection();
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(panel, "Błąd bazy danych", "błąd", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
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
