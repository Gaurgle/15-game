import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class OptionsPanel extends JPanel {

    private final JButton restartGame = new JButton("Restart Game");
    private final JButton setGameOneFromWin = new JButton("Dev Mode");
    private final JButton musicOnOff = new JButton("Music");

    public OptionsPanel() {

        restartGame.setOpaque(true);
        restartGame.setFont(new Font("Century Gothic", Font.BOLD, 15));
        restartGame.setBackground(new Color(205, 171, 255));
        restartGame.setForeground(new Color(222, 200, 255));
        restartGame.setBorder(new CompoundBorder(new MatteBorder(2, 6, 11, 6, new Color(164, 118, 255)),
                new MatteBorder(0, 2, 5, 2, new Color(176, 129, 255))));
        setBackground(new Color(204, 204, 204));
        add(restartGame);

        setGameOneFromWin.setOpaque(true);
        setGameOneFromWin.setFont(new Font("Century Gothic", Font.BOLD, 15));
        setGameOneFromWin.setBackground(new Color(205, 171, 255));
        setGameOneFromWin.setForeground(new Color(222, 200, 255));
        setGameOneFromWin.setBorder(new CompoundBorder(new MatteBorder(2, 6, 11, 6, new Color(164, 118, 255)),
                new MatteBorder(0, 2, 5, 2, new Color(176, 129, 255))));
        add(setGameOneFromWin);

        musicOnOff.setOpaque(true);
        musicOnOff.setFont(new Font("Century Gothic", Font.BOLD, 15));
        musicOnOff.setBackground(new Color(205, 171, 255));
        musicOnOff.setForeground(new Color(222, 200, 255));
        musicOnOff.setBorder(new CompoundBorder(new MatteBorder(2, 6, 11, 6, new Color(164, 118, 255)),
                new MatteBorder(0, 2, 5, 2, new Color(176, 129, 255))));
        add(musicOnOff);
    }

    public JButton getRestartGame() {
        return restartGame;
    }
    public JButton getSetGameOneFromWin() {
        return setGameOneFromWin;
    }
    public JButton getMusicOnOff() {
        return musicOnOff;
        // music on ooff
    }
}