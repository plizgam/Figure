package Figures;

import java.awt.*;

public abstract class Figure {

    public int x, y, parA, parB;
    public Color color;

    public Figure(int x, int y, int parA, int parB){
        this.x = x;
        this.y = y;
        this.parA = parA;
        this.parB = parB;

        color = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    }
    public abstract void paint(Graphics g, int x, int y, int width, int height);
}