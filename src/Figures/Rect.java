package Figures;

import java.awt.*;

public class Rect extends Figure {
    int sideA, sideB;

    public Rect(int x, int y){
        super(x, y);
        sideA = (int)(Math.random()*x);
        sideB = (int)(Math.random()*y);
    }

    public void paint(Graphics g, int x, int y){
        g.setColor(this.color);
        g.fillRect(x, y, sideA, sideB);
    }
}
