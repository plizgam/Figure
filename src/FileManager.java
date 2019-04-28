import Figures.*;


import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class FileManager {
    public static void saveFigures(ArrayList<Figure> figures){

        StringBuilder sb = new StringBuilder();
        String color;

        for(int i = 0; i < figures.size(); i++){
            color =(figures.get(i).color.getRed()) + " " +
                    (figures.get(i).color.getGreen()) + " " +
                    (figures.get(i).color.getBlue()) + "\t";

            switch(figures.get(i).getClass().getName()){
                case("Figures.Arc"):
                    sb.append("Arc\tRGB:" + color + "x:" +
                            figures.get(i).x + "\ty:" +
                            figures.get(i).y + "\tparA:" +
                            figures.get(i).parA + "\tparB:" +
                            figures.get(i).parB);
                    break;

                case("Figures.Oval"):
                    sb.append("Oval\tRGB:" + color + "x:" +
                            figures.get(i).x + "\ty:" +
                            figures.get(i).y + "\tparA:" +
                            figures.get(i).parA);
                    break;

                case("Figures.Square"):
                    sb.append("Square\tRGB:" + color + "x:" +
                            figures.get(i).x + "\ty:" +
                            figures.get(i).y + "\tparA:" +
                            figures.get(i).parA);
                    break;
            }


            sb.append('\n');

        }


        try {
            File FileSave = new File("Figures.txt");
            FileWriter file = new FileWriter(FileSave);
            file.write(sb.toString());

            file.flush();
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Figure> loadFigures(ArrayList<Figure> figures){

        StringBuilder sb = new StringBuilder();

        try {
            FileInputStream fis = new FileInputStream("Figures.txt");

            int wrt = 0;

            while(wrt != -1){
                sb.append((char)wrt);
                wrt = fis.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(sb.toString());


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String typeOfFigure, colors, x, y, parameterA, parameterB = "";

                String[] arg = line.split("\t");

                typeOfFigure = arg[0];
                colors = arg[1];
                colors = colors.replace("RGB:", "");
                String RGB[] = colors.split("\\s");

                x = arg[2];
                x = x.replace("x:", "");
                y = arg[3];
                y = y.replace("y:", "");


                parameterA = arg[4];

                parameterA = parameterA.replace("parA:", "");

                if (arg.length == 6) {
                    parameterB = arg[5];
                    parameterB = parameterB.replace("parB:", "");
                }


                Color color = new Color(Integer.parseInt(RGB[0]), Integer.parseInt(RGB[1]), Integer.parseInt(RGB[2]));


                if(typeOfFigure.contains("Square"))
                    figures.add(new Square(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(parameterA), color));
                else
                if(typeOfFigure.contains("Oval"))
                    figures.add(new Oval(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(parameterA), color));
                else
                if(typeOfFigure.contains("Arc"))
                    figures.add(new Arc(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(parameterA), Integer.parseInt(parameterB), color));

        }
        scanner.close();
        return figures;
    }
}
