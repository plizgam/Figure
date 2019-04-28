import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel{
    public JButton loadButton = new JButton("WCZYTAJ");
    public JButton clearButton = new JButton("WYCZYŚĆ");

    ButtonsPanel(){

        loadButton.setPreferredSize(new Dimension(120,60));
        add(loadButton);

        clearButton.setPreferredSize(new Dimension(120,60));
        add(clearButton);

    }
}
