package Figures;

public class Rect extends Figure {
    int sideA, sideB;

    public Rect(int x, int y){
        super(x, y);
        sideA = Figure.rand(400);
        sideB = Figure.rand(400);
    }
}
