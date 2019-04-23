package Figures;

import java.awt.*;

public abstract class Figure {

    public int x, y;
    Color color;

    public Figure(int x, int y){
        this.x = x;
        this.y = y;
        color = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    }


    public abstract void paint(Graphics g, int x, int y);
}