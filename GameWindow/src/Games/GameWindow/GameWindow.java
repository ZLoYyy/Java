package Games.GameWindow;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame
{

    private static GameWindow game_window;

    public static void main(String[] args)
    {
        game_window = new GameWindow();//класс + сылка объект окна
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//настройка окна при закрытие
        game_window.setLocation(200, 100)//где будет появлятся окно
        game_window.setSize(600, 400)// размер окна;
        GameField game_field = new GameField();
        game_window.add(game_field);
        game_window.setVisible(true);// сделать видимым окно
        game_window.setResizable(false);// запретить изменение окна
    }

    private static void onRepaint(Graphics g)// рисовать
    {
        g.fillOval(10, 10, 200, 100);
        g.drawLine(200, 300, 200, 100);
    }

    private static class GameField extends JPanel //класс понели
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);//сначало он
            onRepaint(g);
        }
    }
}
