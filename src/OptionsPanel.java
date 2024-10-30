import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class OptionsPanel extends JPanel {

    private final JButton restartGame = new JButton("Restart Game");
    private final JButton setGameOneFromWin = new JButton("Dev Mode");

    public OptionsPanel() {

        restartGame.setFont(new Font("Century Gothic", Font.BOLD, 15));
        restartGame.setBackground(new Color(205, 171, 255));
        restartGame.setForeground(new Color(222, 200, 255));
        restartGame.setBorder(new MatteBorder(2, 5, 8, 5, new Color(222, 200, 255)));
        setBackground(Color.WHITE);
        add(restartGame);

        setGameOneFromWin.setFont(new Font("Century Gothic", Font.BOLD, 15));
        setGameOneFromWin.setBackground(new Color(205, 171, 255));
        setGameOneFromWin.setForeground(new Color(222, 200, 255));
        setGameOneFromWin.setBorder(new MatteBorder(2, 5, 8, 5, new Color(222, 200, 255)));
        add(setGameOneFromWin);
    }

    public JButton getRestartGame() {
        return restartGame;
    }
    public JButton getSetGameOneFromWin() {
        return setGameOneFromWin;
    }
}