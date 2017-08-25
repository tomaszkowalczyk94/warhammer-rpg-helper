package warhammerrpg.gui.network;

import com.sun.org.apache.xpath.internal.operations.Bool;
import warhammerrpg.Person.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class GamerGuiForm {
    private JPanel panel;
    private JButton saveChanges;
    private JTabbedPane tabbedPane1;
    private JRadioButton radioButton1;
    private JTextField nameTextField;
    private JTextField breedTextField;
    private JTextField curProffesionTextField;
    private JTextField prevProffesionTextField;
    private JTextField goldTextField;
    private JTextField silverTextField;
    private JTextField brassTextField;
    private JTextField ageTextField;
    private JTextField sexTextField;
    private JTextField weightTextField;
    private JTextField heightTextField;
    private JTextField eyesColourTextField;
    private JTextField hairColourTextField;
    private JTextField starSignTextField;
    private JTextField birthPlaceTextField;
    private JTextPane specialSignsTextPanel;
    private JTextField curExpTextField;
    private JTextField allExpTextField;


    public GamerGuiForm() {
        saveChanges.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPerson();

            }
        });
    }

    public void createPerson() {
        Person person = new Person(nameTextField.getText(),
                                   breedTextField.getText(),
                                   curProffesionTextField.getText(),
                                   ageTextField.getText(),
                                   sexTextField.getText(),
                                   birthPlaceTextField.getText(),
                                   goldTextField.getText());
        basicValuesTest();
        person.printPerson();
    }

    public void basicValuesTest(){
        if(nameTextField.getText().isEmpty() || breedTextField.getText().isEmpty() || curProffesionTextField.getText().isEmpty() ||
                ageTextField.getText().isEmpty() ||  sexTextField.getText().isEmpty() || birthPlaceTextField.getText().isEmpty() ||  goldTextField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(panel, "Wypełnij wymagane pola");
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
