import javax.swing.*;
import java.awt.*;

public class BorderPanel extends JPanel {

    public BorderPanel() {
        setLayout(new BorderLayout());
        add(new GamePanel(), BorderLayout.SOUTH);
        add(new OptionsPanel(), BorderLayout.NORTH);
        setVisible(true);
    }
}
