package Figures;

import java.awt.*;

public class Oval extends Figure {

    public Oval(int x, int y, int parA){
        super(x, y, parA, 0);
    }

    public void paint(Graphics g, int x, int y, int width, int height) {
        g.setColor(this.color);
        g.fillOval(x, y, (super.parA*((width+height)/2)/100), (super.parA*((width+height)/2)/100));
    }
}