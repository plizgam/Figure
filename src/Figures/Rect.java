package Figures;

import java.awt.*;

public class Rect extends Figure {

    public Rect(int x, int y, int parA){
        super(x, y, parA, 0);
    }

    public void paint(Graphics g, int x, int y, int width, int height){
        g.setColor(this.color);
        g.fillRect(x, y, (super.parA*((width+height)/2)/100), (super.parA*((width+height)/2)/100));
    }
}
