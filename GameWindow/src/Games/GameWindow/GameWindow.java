package Games.GameWindow;

import javax.swing.*;

public class GameWindow extends JFrame
{

    private static GameWindow game_window;

    public static void main(String[] args)
    {
        game_window = new GameWindow();
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_window.setLocation(200, 100);
        game_window.setSize(600, 400);
        game_window.setVisible(true);
        game_window.setResizable(false);
    }
}
