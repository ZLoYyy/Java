package Games.GameWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class GameWindow extends JFrame
{

    private static GameWindow game_window;
    private static long last_frame_time;
    private static Image background;
    private static Image drop;
    private static Image game_over;
    private static float drop_left = 300;
    private static float drop_top = -100;
    private static float drop_speed = 200;
    private static int score = 0;

    public static void main(String[] args) throws IOException
    {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.jpg"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        game_window = new GameWindow();//класс + сылка объект окна
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//настройка окна при закрытие
        game_window.setLocation(200, 100);//где будет появлятся окно
        game_window.setSize(1024, 600);// размер окна;
        last_frame_time = System.nanoTime();
        GameField game_field = new GameField();
        game_field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float drop_right = drop_left + drop.getWidth(null);
                float drop_bottom = drop_top + drop.getHeight(null);
                boolean is_drop = x >= drop_left && x <= drop_right && y >= drop_top && y <= drop_bottom;
                if(is_drop)
                {
                    drop_top = -100;
                    drop_left = (int) (Math.random() * (game_field.getWidth() - drop.getWidth(null)));
                    drop_speed = drop_speed + 20;
                    score++;
                        game_window.setTitle("Score: "+ score);

                }
            }
        });
        game_window.add(game_field);
        game_window.setVisible(true);// сделать видимым окно
        game_window.setResizable(false);// запретить изменение окна
    }

    private static void onRepaint(Graphics g)// рисовать
    {
        long current_time = System.nanoTime();
        float delta_time = (current_time - last_frame_time)*0.000000001f;
        last_frame_time = current_time;

        drop_top = drop_top + drop_speed * delta_time;
        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, (int) drop_left, (int) drop_top, null);
        if(drop_top > game_window.getHeight())g.drawImage(game_over, 280, 120, null);
    }

    private static class GameField extends JPanel //класс понели
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }
}
