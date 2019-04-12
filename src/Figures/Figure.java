package Figures;

public class Figure {
    int[] rgb = new int[3];
    int mouseX, mouseY;

    public Figure(){}

    public Figure(int x, int y){
        mouseX = x;
        mouseY = y;

        for(int i = 0; i < this.rgb.length; i++)
            this.rgb[i] = rand(255);
    }

    public static int rand(int size){
        return (int)(Math.random()*size+1);
    }
}