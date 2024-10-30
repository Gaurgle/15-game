import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderPanel extends JPanel implements ActionListener {

    private final GamePanel gamePanel = new GamePanel();
    private final OptionsPanel optionsPanel = new OptionsPanel();

    public BorderPanel() {
        setLayout(new BorderLayout());
        add(gamePanel, BorderLayout.SOUTH);
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