import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// är adam med?
//Adam är med!

public class Graphic extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    List<JButton> buttons = new ArrayList<>();
    List<String> facit = new ArrayList<>(15);
    List<String> oneFromFinished = new ArrayList<>(15);


    List<JButton> buttons;
    int indexOfEmptyButton;

    public Graphic() {
        setTitle("Graphic");
        add(panel);
        panel.setLayout(new GridLayout(4, 4));
        buttons = gameLayout();
        paint();
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Lägger till 15 knappar
    public List<JButton> gameLayout() {

        List <JButton> buttons = new ArrayList<>();

        for (int i = 1; i <= 16; i++) {
            JButton b;
            if (i == 16) {
                b = (new JButton(""));
            } else {
                b = (new JButton("" + i));
            }
            buttons.add(b);
            b.addActionListener(this);
        }

        Collections.shuffle(buttons);

        setFacit();
        setOneFromFinished();
        getFacit();
        getOneFromFinished();

        // String list
        List<String> buttonsOrder = new ArrayList<>();
        for (JButton b : buttons) {
            buttonsOrder.add(b.getText());
        }
        System.out.print(buttonsOrder);

//        List<Integer> buttonsOrderInt = new ArrayList<>();
//        for (String s : buttonsOrder) {
//            buttonsOrderInt.add(Integer.parseInt(s));
//
//        }
//        Collections.sort(buttonsOrder);
//        System.out.println(buttonsOrderInt);

        return buttons;
    }

    public void setFacit() {
        for (int i = 0; i <= 16; i++) {
            if (i == 0) {
                facit.add("");
            } else if (i <= 15) {
                facit.add(String.valueOf(i));
            }
        }
    }
    public void getFacit() {
        System.out.println(facit + " = facit:");
    }

    public void setOneFromFinished() {
        for (int i = 0; i <= 16; i++) {
             if (i == 0) {
                 oneFromFinished.add("");
             } else if (i <= 15) {
                oneFromFinished.add(String.valueOf(i));
            } else {
                oneFromFinished.set(Integer.parseInt(String.valueOf(14)), String.valueOf(15));
                oneFromFinished.set(Integer.parseInt(String.valueOf(15)), String.valueOf(14));
            }
        }
    }

    public void getOneFromFinished() {
        System.out.println(oneFromFinished +" = one from finished:" );
    }


    public void paint() {
        for (JButton b : buttons) {
            panel.add(b);
        }
    }

    public void repaint() {
        panel.removeAll();
        panel.revalidate();
        paint();
    }


    @Override
    public String toString() {
        return "Graphic{" +
                "buttons=" + buttons +
                '}';
    }

    public boolean isOnSameRow(int indexOne, int indexTwo) {
        int sum = indexOne + indexTwo;

        return sum > 0 && sum <= 5 || sum > 8 && sum <= 13 || sum > 16 && sum <= 21 || sum > 24 && sum <= 29;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton butt = (JButton) e.getSource();
        int i = buttons.indexOf(butt);
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                indexOfEmptyButton = buttons.indexOf(button);
            }
        }

        System.out.println(i);
        System.out.println(indexOfEmptyButton);

        //Finslipa denna. Just nu byter den om den ligger en rad ovanför men är ej direkt bredvid eller ovanför knappen man tryckte.
        //Revalidate och Repaint är våra vänner.
        //Förenkla nedan statement.
        if (i + 4 == indexOfEmptyButton || i -4 == indexOfEmptyButton) {
            //Byt plats på den tomma knappen och den tryckta knappen
            System.out.println("Change places!");
            Collections.swap(buttons, i, indexOfEmptyButton);
            repaint();
        } else if (isOnSameRow(i, indexOfEmptyButton) && i - 1 == indexOfEmptyButton || isOnSameRow(i, indexOfEmptyButton) && i + 1 == indexOfEmptyButton) {
            System.out.println("Change places!");
            Collections.swap(buttons, i, indexOfEmptyButton);
            repaint();
        }


    }
}
