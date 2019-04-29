import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel{
    public JButton loadButton, clearButton, startButton, stopButton;
    Image img, scaledImage;

    ButtonsPanel(){

        loadButton = new JButton("WCZYTAJ");
        clearButton = new JButton("WYCZYŚĆ");
        startButton = new JButton("WZNÓW");
        stopButton = new JButton("STOP");


        loadButton.setPreferredSize(new Dimension(120,60));
        ImageIcon loadIcon = new ImageIcon(getClass().getResource("Icons/load.png"));
        img = loadIcon.getImage() ;
        scaledImage = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
        loadIcon = new ImageIcon(scaledImage);
        loadButton.setIcon(loadIcon);
        add(loadButton);


        clearButton.setPreferredSize(new Dimension(120,60));
        ImageIcon clearIcon = new ImageIcon(getClass().getResource("Icons/clear.png"));
        img = clearIcon.getImage() ;
        scaledImage = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
        clearIcon = new ImageIcon(scaledImage);
        clearButton.setIcon(clearIcon);
        add(clearButton);

        startButton.setPreferredSize(new Dimension(120,60));
        ImageIcon startIcon = new ImageIcon(getClass().getResource("Icons/start.png"));
        img = startIcon.getImage() ;
        scaledImage = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
        startIcon = new ImageIcon(scaledImage);
        startButton.setIcon(startIcon);
        add(startButton);

        stopButton.setPreferredSize(new Dimension(120,60));
        ImageIcon stopIcon = new ImageIcon(getClass().getResource("Icons/stop.png"));
        img = stopIcon.getImage() ;
        scaledImage = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
        stopIcon = new ImageIcon(scaledImage);
        stopButton.setIcon(stopIcon);
        add(stopButton);

    }
}
