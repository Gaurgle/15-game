import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {

    private final JButton restartGame = new JButton("Restart Game");

    public OptionsPanel() {

        restartGame.setFont(new Font("Century Gothic", Font.BOLD, 15));
        setBackground(Color.DARK_GRAY);
        add(restartGame);

    }

    public JButton getRestartGame() {
        return restartGame;
    }
}
