import Figures.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;

public class Paint extends JFrame {
    ArrayList<Figure> figures = new ArrayList<Figure>();

    public Paint() {
        setTitle("Moduł rysowania");
        setSize(1200, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        makeFigures();
    }

    public void paint(Graphics g) {

        super.paint(g);

        for (int i = 0; i < figures.size(); i++) {
            figures.get(i).paint(g, (figures.get(i).x/100)*getWidth(), (figures.get(i).y/100)*getHeight() );
        }
    }

    public void makeFigures() {

        Thread th = new Thread(() ->{
            for(int i = 0; i < 100; i++) {
                switch ((int) (Math.random() * 2)) {
                    case 0:
                        figures.add(new Rect((int) (Math.random() * 100), (int) (Math.random() * 100)));
                        break;

                    case 1:
                        figures.add(new Triangle((int) (Math.random() * 100), (int) (Math.random() * 100)));
                        break;

                    case 2:
                        figures.add(new Oval((int) (Math.random() * 100), (int) (Math.random() * 100)));
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

    }
}
