import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("Graphic");
        add(new BorderPanel());
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}