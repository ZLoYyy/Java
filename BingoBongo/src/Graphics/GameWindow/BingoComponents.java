package Graphics.GameWindow;

/**
 * Created by ((ZLoY)) on 25.10.2016.
 */
public class BingoComponents extends JComponent implements ActionListener{
    Timer timer = new Timer(100, this);

    Point point = new Point(0, 0);

    public BingoComponentsngo()
    {
        timer.start();
    }


}
