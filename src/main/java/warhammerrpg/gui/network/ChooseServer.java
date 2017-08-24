package warhammerrpg.gui.network;

import javax.swing.*;

public class ChooseServer {

    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setContentPane(new ChooseServerForm().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
