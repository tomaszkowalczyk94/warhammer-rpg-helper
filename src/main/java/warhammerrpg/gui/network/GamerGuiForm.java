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


    private JTable mainFeatureTab;
    private JTable nonMainFeatureTab;
    private JTable weaponsTab;

    public GamerGuiForm() {
        saveChanges.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person person = new Person();
                updatePerson(person);

            }
        });
    }



    public void updatePerson(Person person) {
        basicValuesTest();


        person.setName(nameTextField.getText());
        person.setBreed(breedTextField.getText());
        person.setCurProffesion(curProffesionTextField.getText());
        person.setPrevProffesion(prevProffesionTextField.getText());

        person.setAge(ageTextField.getText());
        person.setSex(sexTextField.getText());
        person.setWeight(weightTextField.getText());
        person.setHeight(heightTextField.getText());
        person.setEyesColour(eyesColourTextField.getText());
        person.setHairColour(hairColourTextField.getText());
        person.setStarSign(starSignTextField.getText());
        person.setBirthPlace(birthPlaceTextField.getText());
        person.setSpecialSigns(specialSignsTextPanel.getText());

        person.setGold(goldTextField.getText());
        person.setSilver(silverTextField.getText());
        person.setBrass(brassTextField.getText());
        person.setCurExp(curExpTextField.getText());
        person.setAllExp(allExpTextField.getText());

        person.printPerson();
    }

    public void basicValuesTest(){
        if(nameTextField.getText().isEmpty() || breedTextField.getText().isEmpty() || curProffesionTextField.getText().isEmpty() ||
                ageTextField.getText().isEmpty() ||  sexTextField.getText().isEmpty() || birthPlaceTextField.getText().isEmpty() ||  goldTextField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(panel, "Wypełnij wymagane (*) pola");
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {

    }
}
