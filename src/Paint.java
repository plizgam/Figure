import Figures.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Paint extends JFrame implements MouseListener, KeyListener {
    ArrayList<Object> figures = new ArrayList<Object>();
    int rand;

    public Paint(){
        setTitle("Moduł rysowania");
        setSize(1200, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        addMouseListener(this);
    }

    public void paint(Graphics g){
        super.paint(g);
        getContentPane().setBackground(Color.BLACK);
        for(Object o : figures){

        }
    }

    @Override
    public void mousePressed(MouseEvent a) {

        rand = (int)(Math.random()*3);

        switch(rand){
            case 0:
               figures.add(new Rect(a.getX(), a.getY()));
               break;
            case 1:
                figures.add(new Triangle(a.getX(), a.getY()));
        }


        super.repaint();
    }


    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.toString().equals("c"))
            ;
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}