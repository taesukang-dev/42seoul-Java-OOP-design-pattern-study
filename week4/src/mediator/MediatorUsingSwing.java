package mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediatorUsingSwing extends JFrame {
    public MediatorUsingSwing() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        JRadioButton hi = new JRadioButton("hi!");
        JRadioButton hello = new JRadioButton("hello!");
        JRadioButton bye = new JRadioButton("bye!");

        contentPane.add(hi);
        contentPane.add(hello);
        contentPane.add(bye);

        setSize(300, 150);
        setVisible(true);

        hi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hi.isSelected()) {
                    hello.setSelected(true);
                    bye.setSelected(true);
                }
            }
        });

    }

    public static void main(String[] args) {
        new MediatorUsingSwing();

    }
}
