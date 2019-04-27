import Figures.Figure;


import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {
    public static void saveFigure(ArrayList<Figure> figures){

        StringBuilder sb = new StringBuilder();
        String color;

        for(int i = 0; i < figures.size(); i++){
            color =(figures.get(i).color.getRed()) + " " +
                    (figures.get(i).color.getGreen()) + " " +
                    (figures.get(i).color.getBlue()) + "\t\t\t";

            switch(figures.get(i).getClass().getName()){
                case("Figures.Arc"):
                    sb.append("1\t RGB:" + color + "x:" +
                            figures.get(i).x + "\t y:" +
                            figures.get(i).y + "\t parA:" +
                            figures.get(i).parA + "\t parB" +
                            figures.get(i).parB);
                    break;

                case("Figures.Oval"):
                    sb.append("2\t RGB:" + color + "x:" +
                            figures.get(i).x + "\t y:" +
                            figures.get(i).y + "\t parA:" +
                            figures.get(i).parA);
                    break;

                case("Figures.Rect"):
                    sb.append("3\t RGB:" + color + "x:" +
                            figures.get(i).x + "\t y:" +
                            figures.get(i).y + "\t parA:" +
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
}
