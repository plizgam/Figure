import Figures.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;

public class Paint extends JFrame {
    int xDim, yDim, parameterA, parameterB;

    ArrayList<Figure> figures = new ArrayList<Figure>();

    public Paint() {
        setTitle("Moduł rysowania");
        setSize(1200, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);



        makeFigures();
        FileManager.saveFigure(figures);
    }

    public void paint(Graphics g) {

        super.paint(g);

        for (int i = 0; i < figures.size(); i++) {

            figures.get(i).paint(g, ((figures.get(i).x)* getWidth())/100, ((figures.get(i).y)* getHeight())/100, getWidth(), getHeight());

        }
    }

    public void makeFigures() {
        repaint();
        Thread th = new Thread(() ->{


            for(int i = 0; i < 100; i++) {

                do{
                    xDim = (int)(Math.random() * 100);
                    yDim = (int)(Math.random() * 100);
                    parameterA = (int)(Math.random() * 100);
                    parameterB = (int)(Math.random() * 100);
                }
                while(!((xDim*getWidth())/100 > parameterA*((getWidth()+getHeight())/2)/100 &&
                        (yDim*getHeight())/100 > parameterA*((getWidth()+getHeight())/2)/100+40 &&
                        (xDim*getWidth())/100 < getWidth()-1.5*parameterA*((getWidth()+getHeight())/2)/100 &&
                        (yDim*getHeight())/100 < getHeight()-1.5*parameterA*((getWidth()+getHeight())/2)/100 &&
                        yDim != 0 && xDim != 0 && parameterA != 0 && parameterB != 0));


                switch ((int) (Math.random() * 3)) {
                    case 0:
                        figures.add(new Rect(xDim, yDim, parameterA));
                        break;

                    case 1:
                        figures.add(new Arc(xDim, yDim, parameterA, parameterB));
                        break;

                    case 2:
                        figures.add(new Oval(xDim, yDim, parameterA));
                        break;
                }

                TimerTask timer = new TimerTask(){
                    @Override
                    public void run() {
                        repaint();
                    }
                };

                timer.run();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timer.cancel();

            }
        });

        th.start();

       /* while(th.isAlive()){

        }*/
    }
}

