package warhammerrpg.gui.network;
import javax.swing.*;

public class MasterGui {
    MasterGui(){
        run();
    }

    public static void run(){
        JFrame frame = new JFrame("Game Master Panel");
        frame.setContentPane(new MasterGuiForm().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]){
        JFrame frame = new JFrame("Game Master Panel");
        frame.setContentPane(new MasterGuiForm().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

