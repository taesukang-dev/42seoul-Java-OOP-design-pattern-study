package mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class RadioMediator {
    ArrayList<JRadioButton> store = new ArrayList<>();

    public void add(JRadioButton jRadioButton) {
        store.add(jRadioButton);
    }
    public void select(JRadioButton curr) {
        for (JRadioButton now : store) {
            if (now != curr) {
                now.setSelected(true);
            }
        }
    }
}

public class MediatorUsingSwing extends JFrame {
    public MediatorUsingSwing() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        JRadioButton hi = new JRadioButton("hi!");
        JRadioButton hello = new JRadioButton("hello!");
        JRadioButton bye = new JRadioButton("bye!");

        RadioMediator radioMediator = new RadioMediator();
        radioMediator.add(hi);
        radioMediator.add(hello);
        radioMediator.add(bye);

        contentPane.add(hi);
        contentPane.add(hello);
        contentPane.add(bye);

        setSize(300, 150);
        setVisible(true);

        hi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hi.isSelected()) {
                    radioMediator.select(hi);
                }
            }
        });

    }

    public static void main(String[] args) {
        new MediatorUsingSwing();
    }
}
