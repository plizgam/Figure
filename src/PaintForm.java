import Figures.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TimerTask;

public class PaintForm extends JFrame {
    int xDim, yDim, parameterA, parameterB, frameValue;
    boolean figureMaker = true;
    ButtonsPanel Buttons;

    ArrayList<Figure> figures = new ArrayList<Figure>();

    public PaintForm() {
        setTitle("Projekt GUI - GENEROWANIE");
        setSize(1200, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);



        makeFigures();
        Buttons = new ButtonsPanel();
        Buttons.setVisible(false);
        add(Buttons);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                repaint();


              if(Buttons.isVisible()){
                  Buttons.setVisible(false);
                  getContentPane().setBackground(Color.WHITE);
              }else{
                  Buttons.setVisible(true);
                  Buttons.loadButton.setLocation(100,100);
              }

                Buttons.requestFocusInWindow();


            }
        });

        Buttons.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(figures.size() != 0) {
                    figureMaker = false;
                    FileManager.saveFigures(figures);
                    figures.clear();
                    repaint();
                    setTitle("Projekt GUI - WYCZYSZCZONE");
                }
            }
        });

        Buttons.loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(figures.size() == 0) {
                    figures = FileManager.loadFigures(figures);
                    repaint();
                    setTitle("Projekt GUI - ODCZYTANE Z PLIKU");
                }
            }
        });

        Buttons.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                figureMaker = false;
                setTitle("Projekt GUI - ZATRZYMANIE");
            }
        });

        Buttons.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!getTitle().contains("GENEROWANIE")) {
                    figureMaker = true;
                    makeFigures();
                    setTitle("Projekt GUI - GENEROWANIE");
                }
            }
        });

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


            while(figureMaker) {

                do{
                    xDim = (int)(Math.random() * 100);
                    yDim = (int)(Math.random() * 100);
                    parameterA = (int)(Math.random() * 100);
                    parameterB = (int)(Math.random() * 100);

                    frameValue = parameterA*((getWidth()+getHeight())/2)/100;
                }
                while(!((xDim*getWidth())/100 > frameValue &&
                        (yDim*getHeight())/100 > frameValue+40 &&
                        (xDim*getWidth())/100 < getWidth()-1.5*frameValue &&
                        (yDim*getHeight())/100 < getHeight()-1.5*frameValue-20 &&
                        yDim != 0 && xDim != 0 && parameterA != 0 && parameterB != 0));

              Color color = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));

                switch ((int) (Math.random() * 3)) {
                    case 0:
                        figures.add(new Square(xDim, yDim, parameterA, color));
                        break;

                    case 1:
                        figures.add(new Arc(xDim, yDim, parameterA, parameterB, color));
                        break;

                    case 2:
                        figures.add(new Oval(xDim, yDim, parameterA, color));
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
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timer.cancel();
            }
        });

        th.start();


    }
}
