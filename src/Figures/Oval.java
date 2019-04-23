package Figures;

import java.awt.*;

public class Oval extends Figure {

    int r;

    public Oval(int x, int y){
        super(x, y);
        r = (int)(Math.random()*x);
    }

    public void paint(Graphics g, int x, int y){
        g.setColor(this.color);
        g.fillOval(x, y, r,r);
    }
}
