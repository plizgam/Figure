package Figures;

import java.awt.*;

public class Square extends Figure {

    public Square(int x, int y, int parA, Color color){ super(x, y, parA, 0, color); }


    public void paint(Graphics g, int x, int y, int width, int height){
        g.setColor(this.color);
        g.fillRect(x, y, (super.parA*((width+height)/2)/100), (super.parA*((width+height)/2)/100));
    }
}
