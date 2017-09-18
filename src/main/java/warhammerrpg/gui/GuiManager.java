package warhammerrpg.gui;

import warhammerrpg.gui.network.ChooseServerGui;

import javax.swing.*;

public class GuiManager {

    public void run() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        //@todo zmienic to na coś fajniejszego, i nie robić tego w pętli -_-
        for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
            if("Windows".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }

        JFrame frame = new JFrame("Warhammer RPG Helper");
        frame.setContentPane(new ChooseServerGui(frame).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
