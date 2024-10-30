import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener {

    private List<JButton> buttons = new ArrayList<>();
    private int indexOfEmptyButton;

    public GamePanel() {
        HelperUtil.setFacit();
        setLayout(new GridLayout(4, 4, 2, 2));
        createButtonLayout();
        for (JButton b : buttons) {
            add(b);
            b.setFont(new Font("Century Gothic", Font.BOLD, 35));
        }
    }

    public void createButtonLayout() {

        List<JButton> buttons = new ArrayList<>();

        for (int i = 1; i <= 16; i++) {
            JButton b;

            if (i == 16) {
                b = (new JButton(""));
                b.setVisible(false);
            } else {
                b = (new JButton("" + i));
            }
            buttons.add(b);
            b.addActionListener(this);
        }
        Collections.shuffle(buttons);
        this.buttons = buttons;
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
        }
        System.out.println(getButtonsOrder().toString());
//        HelperUtil.getFacit();


        List<String> buttonsNow = getButtonsOrder();
        List<String> buttonsFTW = HelperUtil.getFacit();

        if (buttonsNow.equals(buttonsFTW)) {
            System.out.println("you won");
        } else if (!buttonsFTW.equals(buttonsNow)) {
            System.out.println("you haven't woneth yet");
        }
        //Är vi i mål?
    }

}

