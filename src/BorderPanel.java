import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderPanel extends JPanel implements ActionListener {

    private final GamePanel gamePanel = new GamePanel();
    private final OptionsPanel optionsPanel = new OptionsPanel();

    public BorderPanel() {
        setLayout(new BorderLayout());
        setBorder(new CompoundBorder(new MatteBorder(2, 10, 40, 10,
                new Color(170, 170, 170)), new MatteBorder(0, 4, 7, 4, new Color(187, 187, 187))));
        add(gamePanel, BorderLayout.CENTER);
        add(optionsPanel, BorderLayout.NORTH);
        optionsPanel.getRestartGame().addActionListener(this);
        optionsPanel.getSetGameOneFromWin().addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optionsPanel.getRestartGame()) {
            gamePanel.newGame();
        } else if (e.getSource() == optionsPanel.getSetGameOneFromWin()) {
            gamePanel.devMode();
        }
    }
}