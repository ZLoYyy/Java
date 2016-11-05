package Graphics.GameWindow;

/**
 * Created by ((ZLoY)) on 28.10.2016.
 */
import java.awt.Color;
import java.awt.Graphics;


public class Point implements Runnable{

    private int x,y;

    private int dx = 1, dy = 1;
    private int nx = 1, ny = 1;
    private int adx = 1, ady = 1;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x-10, y-10, 20, 20);
    }

    public void work(int nx, int ny) {
        this.nx = nx;
        this.ny = ny;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void run() {
        if(x < nx) this.dx += adx;
        else this.dx -= adx;
        if(y < ny) this.dy += ady;
        else this.dy -= ady;

        this.x += dx;
        this.y += dy;
    }


}
