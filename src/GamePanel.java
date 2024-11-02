import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener {

    private final AudioManager am = new AudioManager();
    private List<JButton> buttons = new ArrayList<>();
    private int indexOfEmptyButton;
    private boolean hasWon;

    public GamePanel() {

        HelperUtil.setFacit();
        setLayout(new GridLayout(4, 4, 2, 2));
        setBackground(new Color(204, 204, 204));
        createButtonLayout(false);
        for (JButton b : buttons) {
            add(b);
            }
        }

    public void createButtonLayout(boolean devMode) {
        if (hasWon) {
            setLayout(new GridLayout(4, 4, 2, 2));
            hasWon = false;
        }
        List<JButton> buttons = new ArrayList<>();

        for (int i = 1; i <= 16; i++) {
            JButton b;
            if (i == 16) {
                b = (new JButton(""));
                //b.setVisible(false);
                b.setOpaque(true);
                b.setBackground(Color.DARK_GRAY);
                b.setBorder(new CompoundBorder(new MatteBorder(11, 6, 2, 6, Color.GRAY),
                        new MatteBorder(5, 2, 2, 2, new Color(97, 102, 107))));
            } else {
                b = (new JButton("" + i));
                b.setOpaque(true);
                b.setBackground(new Color(205, 171, 255));
                b.setForeground(new Color(222, 200, 255));
                b.setBorder(new CompoundBorder(new MatteBorder(2, 6, 11, 6, new Color(164, 118, 255)),
                        new MatteBorder(0, 2, 5, 2, new Color(176, 129, 255))));
            }
            buttons.add(b);
            b.addActionListener(this);
            b.setFont(new Font("Century Gothic", Font.BOLD, 55));
        }
        if (!devMode) {
            Collections.shuffle(buttons);
        }
        this.buttons = buttons;
    }

    public void newGame() {
        createButtonLayout(false);
        updateButtons(0, true);
        am.playThemeSong();
    }

    public void devMode() {
        createButtonLayout(true);
        updateButtons(0,true);
    }

    public void toggleThemeSong() {
        am.toggleThemeMute();
    }

    public void setWinScreen() {
        hasWon = true;
        setLayout(new FlowLayout());
        removeAll();
        ImageIcon winImage = new ImageIcon("src/images/crtPurpleScreen.jpg");
        JLabel winScreen = new JLabel(winImage);
        add(winScreen);
        revalidate();
        repaint();
    }

    public void updateButtons(int clickedButton, boolean newGame) {
        if (!newGame) {
            Collections.swap(buttons, clickedButton, indexOfEmptyButton);
        }
        removeAll();
        for (JButton b : buttons) {
            add(b);
        }
        revalidate();
        repaint();
    }

    public boolean isOnSameRow(int indexOne, int indexTwo) {
        int sum = indexOne + indexTwo;

        return sum > 0 && sum <= 5 || sum > 8 && sum <= 13 || sum > 16 && sum <= 21 || sum > 24 && sum <= 29;
    }

    public boolean emptyButtonIsAboveOrBelow(int index) {
        return index + 4 == indexOfEmptyButton || index - 4 == indexOfEmptyButton;
    }

    public boolean emptyButtonIsNextTo(int index) {
        return isOnSameRow(index, indexOfEmptyButton) && index - 1 == indexOfEmptyButton ||
                isOnSameRow(index, indexOfEmptyButton) && index + 1 == indexOfEmptyButton;
    }

    public boolean buttonsAreSwappable(int index) {
        return emptyButtonIsAboveOrBelow(index) || emptyButtonIsNextTo(index);
    }

    public void setIndexOfEmptyButton() {
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                indexOfEmptyButton = buttons.indexOf(button);
                break;
            }
        }
    }

    public List<String> getButtonsOrder() {
        List<String> buttonsOrder = new ArrayList<>();
        for (JButton b : buttons) {
            buttonsOrder.add(b.getText());
        }
        return buttonsOrder;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton butt = (JButton) e.getSource();
        int indexOfClickedButton = buttons.indexOf(butt);
        setIndexOfEmptyButton();

        if (buttonsAreSwappable(indexOfClickedButton)) {
            //Byt plats på den tomma knappen och den tryckta knappen
            updateButtons(indexOfClickedButton, false);
            am.playAudioMoveSucc();
        } else {
            am.playAudioMoveFail();
        }
        //Är vi i mål?
        List<String> buttonsNow = getButtonsOrder();
        List<String> buttonsFTW = HelperUtil.getFacit();

        if (buttonsNow.equals(buttonsFTW)) {
            System.out.println("you won");
            am.stopThemeSong();
            am.playAudioCleared();

            setWinScreen();
        } else if (!buttonsFTW.equals(buttonsNow)) {
            System.out.println("you haven't woneth yet");
        }
    }
}