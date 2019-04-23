package Figures;


import java.awt.*;

public class Triangle extends Figure {
    int h, r, k;

    public Triangle(int x, int y){
        super(x, y);
        h = (int)(Math.random()*x);
        r= (int)(Math.random()*y);
        k = (int)(Math.random()*y);
    }

    public void paint(Graphics g, int x, int y){
        g.setColor(this.color);
        g.fillArc(x, y, h, r, k, k);
    }
}
