import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graphic extends JFrame {
    JPanel panel = new JPanel();
    List<JButton> buttons = new ArrayList<>();

    public Graphic() {
        setTitle("Graphic");
        add(panel);
        panel.setLayout(new GridLayout(4, 4));
        gameLayout();
        for (JButton b : buttons) {
            panel.add(b);
        }
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Lägger till 15 knappar
    public void gameLayout() {
        for (int i = 1; i <= 16; i++) {
            if (i == 16) {
                JButton b = (new JButton(""));
                buttons.add(b);
            } else {
                JButton b = (new JButton("" + i));
                buttons.add(b);
            }
        }

        Collections.shuffle(buttons);
    }

    @Override
    public String toString() {
        return "Graphic{" +
                "buttons=" + buttons +
                '}';
    }
}
