import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// är adam med?

public class Graphic extends JFrame {
    JPanel panel = new JPanel();
    List<JButton> buttons = new ArrayList<>();
    List<String> facit = new ArrayList<>(15);
    List<String> oneFromFinished = new ArrayList<>(15);



    public Graphic() {
        setTitle("Graphic");
        add(panel);
        panel.setLayout(new GridLayout(4, 4));
        gameLayout();
        for (JButton b : buttons) {
            panel.add(b);
        }
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Lägger till 15 knappar
    public void gameLayout() {
        for (int i = 1; i <= 16; i++) {
            if (i == 16) {
                JButton b = (new JButton(""));
                buttons.add(b);
            } else {
                JButton b = (new JButton("" + i));
                buttons.add(b);
            }
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


    @Override
    public String toString() {
        return "Graphic{" +
                "buttons=" + buttons +
                '}';
    }
}
