package Graphics.GameWindow;

import javax.swing.*;
import java.awt.*;

public class Bingo extends JFrame {
    BongoComponent component = new BongoComponent();

    public Bingo()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(component);
        getContentPane().setPreferredSize(new Dimension(800, 600));
        pack();
    }

    public static void main(String[] args)
    {
        Bingo bingo = new Bingo();
        bingo.setVisible(true);

    }
}
