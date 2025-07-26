package Calculator.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        MainWindow r = new MainWindow();
    }

    public MainWindow() {
        initialize();
    }

    private void initialize() {
//        appFrame = new JFrame("Calculator");
        setSize(500, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        setBackground(Color.LIGHT_GRAY);

        // Result Panel
        ResultPanel resultPanel = new ResultPanel();
        GridBagConstraints gbcResultPanel = new GridBagConstraints();
        gbcResultPanel.gridx = 0;
        gbcResultPanel.gridy = 0;
        gbcResultPanel.anchor = GridBagConstraints.CENTER;
        gbcResultPanel.insets = new Insets(10, 10, 10, 10);

        add(resultPanel,gbcResultPanel);

        // Operation Panel
        OperationPanel operationPanel = new OperationPanel();
        GridBagConstraints gbcOperationPanel = new GridBagConstraints();
        gbcOperationPanel.gridx = 0;
        gbcOperationPanel.gridy = 1;
        gbcOperationPanel.anchor = GridBagConstraints.CENTER;
        gbcOperationPanel.insets = new Insets(10, 10, 10, 10);

        add(operationPanel,gbcOperationPanel);

        setVisible(true);
    }
}
