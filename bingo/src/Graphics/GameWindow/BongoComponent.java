package Graphics.GameWindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;


/**
 * Created by ((ZLoY)) on 28.10.2016.
 */
public class BongoComponent extends JComponent implements Runnable, MouseMotionListener
{
    ArrayList<Point> points = new ArrayList<>();
    ScheduledExecutorService ses = Executors.newScheduledThreadPool(30);

    int x = 0;
    int y = 0;

    public BongoComponent()
    {
        ses.scheduleWithFixedDelay(() -> repaint(), 0, 20, TimeUnit.MILLISECONDS);
        addMouseMotionListener(this);
        Random random = new Random();
        for(int i=0; i<30; i++) {
            Point p = new Point(random.nextInt(200), random.nextInt(200));
            points.add(p);
            ses.scheduleWithFixedDelay(p, 0, random.nextInt(10)+10, TimeUnit.MILLISECONDS);
        }
    }
    @Override
    public void paint(Graphics g) {
        points.forEach((point) -> {
            point.paint(g);
        });
    }

    @Override
    public void run() {

    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        points.forEach((point) -> {
            point.work(e.getX(),e.getY());
        });
    }
}
