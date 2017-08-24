package warhammerrpg.gui;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {


    public MyFrame() {
        super("Hello world");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(300,300);
        setLocation(50,50);

        setLayout(new FlowLayout());

        add(new JButton("Przycisk1"));
        add(new JButton("Przycisk2"));
        add(new JButton("Przycisk3"));


        setVisible(true);
    }
}
