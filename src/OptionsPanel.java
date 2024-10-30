import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {

    private final JButton restartGame = new JButton("Restart Game");
    private final JButton setGameOneFromWin = new JButton("Dev Mode");

    public OptionsPanel() {

        restartGame.setFont(new Font("Century Gothic", Font.BOLD, 15));
        setBackground(Color.DARK_GRAY);
        add(restartGame);

        setGameOneFromWin.setFont(new Font("Century Gothic", Font.BOLD, 15));
        setBackground(Color.DARK_GRAY);
        add(setGameOneFromWin);

    }

    public JButton getRestartGame() {
        return restartGame;
    }
    public JButton getSetGameOneFromWin() {
        return setGameOneFromWin;
    }
}