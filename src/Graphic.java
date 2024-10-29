import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// är adam med?

public class Graphic extends JFrame {
        JPanel panel = new JPanel();
        List<JButton> buttons = new ArrayList<>();

        public void Graphic(){
            setTitle("Graphic");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 600);

            gameLayout();

            add(panel);

        }

    public void gameLayout() {
        panel.setLayout(new GridLayout(3, 5,10,10));

        for (int i = 1; i <= 15; i++) {
            JButton b = (new JButton("b" +i));
            buttons.add(b);
            panel.add(b);
        }

        for (JButton button : buttons){
            System.out.println(button.getText());
        }
    }

    @Override
    public String toString() {
        return "Graphic{" +
                "buttons=" + buttons +
                '}';
    }
}
