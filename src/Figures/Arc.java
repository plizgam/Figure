package Figures;

import java.awt.*;

public class Arc extends Figure {

    public Arc(int x, int y, int parA, int parB, Color color){
        super(x, y, parA, parB, color);
    }


    public void paint(Graphics g, int x, int y, int width, int height) {
        g.setColor(this.color);
        g.fillArc(x, y, (super.parA*((width+height)/2)/100), (super.parA*((width+height)/2)/100), super.parB, super.parB);
    }
}