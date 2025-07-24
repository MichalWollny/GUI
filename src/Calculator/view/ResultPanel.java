package Calculator.view;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {
    private JLabel resultBox;
    private float result;

    public ResultPanel() {

        setBackground(Color.white);

        resultBox = new JLabel("This is where the result will be");

        GridBagConstraints gbcResultBox = new GridBagConstraints();
        gbcResultBox.gridx = 0;
        gbcResultBox.gridy = 0;
        gbcResultBox.anchor = GridBagConstraints.CENTER;
        gbcResultBox.insets = new Insets(10, 10, 10, 10);

        add(resultBox, gbcResultBox);
    }

    public float getResult(float result) {
        if (result == 0) {
            result = 0;
        }
        return result;
    }
}
