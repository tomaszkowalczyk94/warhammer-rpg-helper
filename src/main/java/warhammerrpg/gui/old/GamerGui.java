package warhammerrpg.gui.old;

import javax.swing.*;

public class GamerGui {
    public GamerGui()
    {
        run();
    }

    static void run(){
        JFrame frame = new JFrame("Player GUI Form");
        frame.setContentPane(new GamerGuiForm().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }




    ///do usuniecia gdy nie bedzie potrzebne
    public static void main(String args[]){
        JFrame frame = new JFrame("Gamer GUI Form");
        frame.setContentPane(new GamerGuiForm().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}