import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// är adam med?
//Adam är med!

public class Graphic extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    List<JButton> buttons = new ArrayList<>();
    int indexOfEmptyButton;

    public Graphic() {
        setTitle("Graphic");
        add(panel);
        panel.setLayout(new GridLayout(4, 4));
        gameLayout();
        for (JButton b : buttons) {
            panel.add(b);
            b.addActionListener(this);
            b.setOpaque(true);
        }
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Lägger till 15 knappar
    public void gameLayout() {
        for (int i = 1; i <= 16; i++) {
            JButton b;
            if (i == 16) {
                b = (new JButton(""));
            } else {
                b = (new JButton("" + i));
            }
            buttons.add(b);
        }

        Collections.shuffle(buttons);
    }

    @Override
    public String toString() {
        return "Graphic{" +
                "buttons=" + buttons +
                '}';
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton butt = (JButton) e.getSource();
        int i = buttons.indexOf(butt);
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                indexOfEmptyButton = buttons.indexOf(button);
            }
        }

        if (i - 1 == indexOfEmptyButton || i + 1 == indexOfEmptyButton || i + 4 == indexOfEmptyButton || i -4 == indexOfEmptyButton) {
            //Byt plats på den tomma knappen och den tryckta knappen
            System.out.println("Change places!");
        }


    }
}
