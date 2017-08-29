package warhammerrpg.gui;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ClientGui {

    private JPanel panel;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private JFormattedTextField formattedTextField4;
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

    public ClientGui() {
        formattedTextField5.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                zapiszButton.setVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                zapiszButton.setVisible(false);
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName());

            if("Windows".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }

        JFrame frame = new JFrame("Player GUI Form");
        frame.setContentPane(new ClientGui().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        imageLogo = new JLabel(new ImageIcon("person.PNG"));
    }
}