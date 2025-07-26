package Calculator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OperationPanel extends JPanel {

    public OperationPanel() {
        JButton zeroButton = new JButton("0");
        JButton oneButton = new JButton("1");
        JButton twoButton = new JButton("2");
        JButton threeButton = new JButton("3");
        JButton fourButton = new JButton("4");
        JButton fiveButton = new JButton("5");
        JButton sixButton = new JButton("6");
        JButton sevenButton = new JButton("7");
        JButton eightButton = new JButton("8");
        JButton nineButton = new JButton("9");

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");

        JButton decimalButton = new JButton(".");
        JButton equalsButton = new JButton("=");

        JButton clearButton = new JButton("C");
        JButton backspaceButton = new JButton("←");

        setLayout(new GridLayout(0, 4, 2, 2));

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton sourceButton = (JButton) e.getSource();
                System.out.println("Button pressed: " + sourceButton.getText());
            }
        };

        add(clearButton);
        add(backspaceButton);
        add(divideButton);

        add(new JPanel());

        add(sevenButton);
        add(eightButton);
        add(nineButton);
        add(multiplyButton);

        add(fourButton);
        add(fiveButton);
        add(sixButton);
        add(subtractButton);

        add(oneButton);
        add(twoButton);
        add(threeButton);
        add(addButton);

        add(zeroButton);
        add(decimalButton);
        add(equalsButton);

        for (Component component : this.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addActionListener(buttonListener);
            }
        }
    }

}
