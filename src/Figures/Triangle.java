package Figures;


public class Triangle extends Figure {
    int sideA, sideB;

    public Triangle(int x, int y){
        super(x, y);
        sideA = Figure.rand(400);
        sideB = Figure.rand(400);
    }
}
