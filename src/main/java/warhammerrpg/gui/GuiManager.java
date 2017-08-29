package warhammerrpg.gui;

import warhammerrpg.gui.network.ChooseServerForm;

import javax.swing.*;

public class GuiManager {

    public void run() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName());

            if("Windows".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }


        JFrame frame = new JFrame("Warhammer RPG Helper");
        frame.setContentPane(new ChooseServerForm().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
