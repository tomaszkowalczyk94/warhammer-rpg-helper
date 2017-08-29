package warhammerrpg.gui;

import warhammerrpg.gui.GuiManager;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        GuiManager guiManager = new GuiManager();
        guiManager.run();
    }
}
